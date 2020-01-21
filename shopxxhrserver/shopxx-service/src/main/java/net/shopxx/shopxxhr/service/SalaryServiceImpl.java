package net.shopxx.shopxxhr.service;

import net.shopxx.shopxxhr.model.Salary;
import net.shopxx.shopxxhr.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Override
    public List<Salary> getAllSalarities() {
        return salaryRepository.findAll();
    }

}
