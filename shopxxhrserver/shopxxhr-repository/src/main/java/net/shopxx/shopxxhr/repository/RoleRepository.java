package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role>, PagingAndSortingRepository<Role, Integer>, BaseRepository<Role, Integer> {

}
