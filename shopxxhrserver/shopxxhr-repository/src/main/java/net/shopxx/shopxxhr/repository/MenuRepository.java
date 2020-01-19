package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface MenuRepository extends JpaRepository<Menu, Integer>, JpaSpecificationExecutor<Menu>, PagingAndSortingRepository<Menu, Integer>, BaseRepository<Menu, Integer> {

}
