package net.shopxx.shopxxhr.controller.salary;

import net.shopxx.shopxxhr.bean.RespBean;
import net.shopxx.shopxxhr.exception.ExceptionEnum;
import net.shopxx.shopxxhr.exception.HrException;
import net.shopxx.shopxxhr.model.Employee;
import net.shopxx.shopxxhr.model.Salary;
import net.shopxx.shopxxhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalarities() {
        return salaryService.getAllSalarities();
    }

    @PostMapping("/")
    public RespBean saveOrUpdateSalary(@RequestBody Salary salary) {
        Salary result = salaryService.saveOrUpdateEmp(salary);
        if (result != null) {
            return RespBean.ofSuccess(result);
        }
        return RespBean.ofError("添加(更新)失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        try {
            salaryService.deleteEmpById(id);
        } catch (Exception e) {
            throw new HrException(ExceptionEnum.SALARY_DELETE_FAILED);
        }
        return RespBean.ok("删除成功！");
    }

}
