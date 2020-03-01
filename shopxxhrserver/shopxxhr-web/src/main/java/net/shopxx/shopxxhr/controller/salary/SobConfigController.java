package net.shopxx.shopxxhr.controller.salary;

import net.shopxx.shopxxhr.bean.RespBean;
import net.shopxx.shopxxhr.model.EmployeeSalary;
import net.shopxx.shopxxhr.model.RespPageBean;
import net.shopxx.shopxxhr.model.Salary;
import net.shopxx.shopxxhr.service.EmployeeService;
import net.shopxx.shopxxhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalarities();
    }

    @PutMapping("/")
    public RespBean updateOrUpdateEmployeeSalaryById(Integer eid, Integer sid) {
        EmployeeSalary result = employeeService.updateOrUpdateEmployeeSalaryById(eid, sid);
        if (result != null) {
            return RespBean.ok("添加(更新)成功！");
        }
        return RespBean.ofError("添加(更新)失败！");
    }

}