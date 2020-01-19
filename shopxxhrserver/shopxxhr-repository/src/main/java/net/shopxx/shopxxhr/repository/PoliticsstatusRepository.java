package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.model.Politicsstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface PoliticsstatusRepository extends JpaRepository<Politicsstatus, Integer>, JpaSpecificationExecutor<Politicsstatus>, PagingAndSortingRepository<Politicsstatus, Integer>, BaseRepository<Politicsstatus, Integer> {

}