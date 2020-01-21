package net.shopxx.shopxxhr.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import net.shopxx.shopxxhr.model.*;
import net.shopxx.shopxxhr.repository.DepartmentRepository;
import net.shopxx.shopxxhr.repository.EmployeeRepository;
import net.shopxx.shopxxhr.repository.JobLevelRepository;
import net.shopxx.shopxxhr.repository.PositionRepository;
import net.shopxx.shopxxhr.service.DepartmentService;
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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    JobLevelRepository jobLevelRepository;
    @Autowired
    RabbitTemplate rabbitTemplate;
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
