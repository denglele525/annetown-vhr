package net.shopxx.shopxxhr.controller.salary;

import net.shopxx.shopxxhr.model.Salary;
import net.shopxx.shopxxhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalarities(){
        return salaryService.getAllSalarities();
    }

}
