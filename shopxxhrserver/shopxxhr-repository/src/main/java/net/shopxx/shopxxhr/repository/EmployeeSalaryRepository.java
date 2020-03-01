package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.model.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Integer>, JpaSpecificationExecutor<EmployeeSalary>, PagingAndSortingRepository<EmployeeSalary, Integer>, BaseRepository<EmployeeSalary, Integer> {

}
