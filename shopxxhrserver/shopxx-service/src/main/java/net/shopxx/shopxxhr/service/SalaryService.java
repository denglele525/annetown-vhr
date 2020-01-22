package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Salary;

import java.util.List;

public interface SalaryService {

    List<Salary> getAllSalarities();

    Salary saveOrUpdateEmp(Salary salary);

    void deleteEmpById(Integer id);
}
