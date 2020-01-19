package net.shopxx.shopxxhr.service;

import com.querydsl.core.types.Predicate;
import net.shopxx.shopxxhr.model.Employee;
import net.shopxx.shopxxhr.model.RespPageBean;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    RespPageBean getEmployeeByPage(Integer page, Integer size, Predicate predicate, Date[] beginDateScope);

    Employee saveOrUpdateEmp(Employee employee);

    Integer maxWorkID();

    void deleteEmpById(Integer id);

    void addEmps(List<Employee> employees);
}
