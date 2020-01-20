package net.shopxx.shopxxhr.Controller.emp;

import com.querydsl.core.types.Predicate;
import net.shopxx.shopxxhr.bean.RespBean;
import net.shopxx.shopxxhr.model.*;
import net.shopxx.shopxxhr.exception.ExceptionEnum;
import net.shopxx.shopxxhr.exception.HrException;
import net.shopxx.shopxxhr.service.*;
import net.shopxx.shopxxhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@QuerydslPredicate(root = Employee.class) Predicate predicate, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Date[] beginDateScope) {
        return employeeService.getEmployeeByPage(page, size, predicate, beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        Employee result = employeeService.saveOrUpdateEmp(employee);
        if (result != null) {

            return RespBean.ofSuccess(result);
        }
        return RespBean.ofError("添加失败！");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatuses() {
        return politicsstatusService.getAllPoliticsstatuses();
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        Integer maxWorkID = employeeService.maxWorkID();
        if (maxWorkID != 0) {
            return RespBean.build()
                    .setCode(200)
                    .setMessage(null)
                    .setData(String.format("%08d", maxWorkID + 1));
        }
        return RespBean.ofError("查询工号不正确!");
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartmentsByParentId(-1);
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id) {
        try {
            employeeService.deleteEmpById(id);
        } catch (Exception e) {
            throw new HrException(ExceptionEnum.EMPLOYEE_DELETE_FAILED);
        }
        return RespBean.ok("删除成功！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null, null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/importData")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatuses()
                , departmentService.getAllDepartmentsWithoutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        employeeService.addEmps(list);
        return RespBean.ok("导入成功");
    }

}
