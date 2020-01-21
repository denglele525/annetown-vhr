package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface SalaryRepository  extends JpaRepository<Salary, Integer>, JpaSpecificationExecutor<Salary>, PagingAndSortingRepository<Salary, Integer>, BaseRepository<Salary, Integer> {

}
