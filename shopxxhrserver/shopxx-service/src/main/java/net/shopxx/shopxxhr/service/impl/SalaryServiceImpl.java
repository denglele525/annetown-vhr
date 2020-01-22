package net.shopxx.shopxxhr.service.impl;

import net.shopxx.shopxxhr.model.Salary;
import net.shopxx.shopxxhr.repository.SalaryRepository;
import net.shopxx.shopxxhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Override
    public List<Salary> getAllSalarities() {
        return salaryRepository.findAll();
    }

    @Override
    @Transactional
    public Salary saveOrUpdateEmp(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryRepository.save(salary);
    }

    @Override
    @Transactional
    public void deleteEmpById(Integer id) {
        salaryRepository.deleteById(id);
    }

}
