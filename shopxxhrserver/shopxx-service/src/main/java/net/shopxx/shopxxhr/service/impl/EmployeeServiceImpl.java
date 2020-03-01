package net.shopxx.shopxxhr.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import net.shopxx.shopxxhr.model.*;
import net.shopxx.shopxxhr.repository.*;
import net.shopxx.shopxxhr.service.EmployeeService;
import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    JobLevelRepository jobLevelRepository;
    @Autowired
    EmployeeSalaryRepository employeeSalaryRepository;
    @Autowired
    RabbitTemplate rabbitTemplate;

    protected JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public RespPageBean getEmployeeByPage(Integer page, Integer size, Predicate predicate, Date[] beginDateScope) {
        QEmployee qEmployee = QEmployee.employee;
        RespPageBean respPageBean = new RespPageBean();
        Pageable pageable = null;
        BooleanBuilder booleanBuilder = new BooleanBuilder(predicate);
        if (beginDateScope != null) {
            booleanBuilder.and(qEmployee.beginDate.after(beginDateScope[0]).and(qEmployee.beginDate.before(beginDateScope[1])));
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page - 1, size);
            Page<Employee> all = employeeRepository.findAll(booleanBuilder, pageable);
            long totalSize = all.getTotalElements();
            List<Employee> employees = all.getContent();
            respPageBean.setData(employees);
            respPageBean.setTotal(totalSize);
            return respPageBean;
        }
        List<Employee> employeeList = IterableUtils.toList(employeeRepository.findAll(booleanBuilder));
        respPageBean.setData(employeeList);
        respPageBean.setTotal(employeeList.size());
        return respPageBean;
    }

    @Override
    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        RespPageBean respPageBean = new RespPageBean();
        QSalary qSalary = QSalary.salary;
        QEmployee qEmployee = QEmployee.employee;
        QDepartment qDepartment = QDepartment.department;
        if (page != null && size != null) {
            Pageable pageable = PageRequest.of(page - 1, size);
            Page<Employee> all = employeeRepository.findAll(pageable);
            long totalSize = all.getTotalElements();
            List<Employee> employeeList = all.getContent();
            List<Employee> employees = employeeList.stream().map(
                    employee -> {
                        List<Salary> salaries = jpaQueryFactory
                                .select(Projections.bean(Salary.class, qSalary.id, qSalary.accumulationFundBase, qSalary.accumulationFundPer, qSalary.allSalary, qSalary.basicSalary, qSalary.bonus, qSalary.createDate, qSalary.lunchSalary, qSalary.medicalBase, qSalary.medicalPer, qSalary.name, qSalary.pensionBase, qSalary.pensionPer, qSalary.trafficSalary))
                                .from(qSalary)
                                .innerJoin(qSalary.employee, qEmployee)
                                .where(qEmployee.eq(employee))
                                .distinct()
                                .fetch();
                        Department department = jpaQueryFactory
                                .select(Projections.bean(Department.class, qDepartment.name))
                                .from(qDepartment)
                                .where(qDepartment.id.eq(employee.getId()))
                                .fetchOne();
                        employee.setSalary(salaries);
                        employee.setDepartment(department);
                        return employee;
                    }
            ).collect(Collectors.toList());
            respPageBean.setData(employees);
            respPageBean.setTotal(totalSize);
            return respPageBean;
        }
        return respPageBean;
    }

    @Override
    @Transactional
    public EmployeeSalary updateOrUpdateEmployeeSalaryById(Integer eid, Integer sid) {
        QEmployeeSalary qEmployeeSalary = QEmployeeSalary.employeeSalary;
        EmployeeSalary employeeSalary = employeeSalaryRepository.findOne(qEmployeeSalary.employeeId.eq(eid)).orElse(null);
        if (employeeSalary != null) {
            employeeSalary.setSalaryId(sid);
        } else {
            employeeSalary = new EmployeeSalary();
            employeeSalary.setEmployeeId(eid);
            employeeSalary.setSalaryId(sid);
        }
        return employeeSalaryRepository.save(employeeSalary);
    }

    @Override
    @Transactional
    public Employee saveOrUpdateEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        Employee result = employeeRepository.save(employee);
        if (result != null) {
            LOGGER.info(result.toString());
            Department department = departmentRepository.findById(result.getDepartment().getId()).orElse(null);
            JobLevel jobLevel = jobLevelRepository.findById(result.getJoblevel().getId()).orElse(null);
            Position position = positionRepository.findById(result.getPos().getId()).orElse(null);
            result.setDepartment(department);
            result.setJoblevel(jobLevel);
            result.setPos(position);
            rabbitTemplate.convertAndSend("shopxxhr.mail.welcome", result);
        }
        return result;
    }

    @Override
    public Integer maxWorkID() {
        QEmployee qEmployee = QEmployee.employee;
        Employee employee = employeeRepository.findOne(qEmployee.workId.eq(JPAExpressions.select(qEmployee.workId.max()).from(qEmployee))).orElse(null);
        if (employee != null) {
            return employee.getWorkId();
        }
        return 0;
    }

    @Override
    @Transactional
    public void deleteEmpById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addEmps(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

}
