package net.shopxx.shopxxhr.repository;

import net.shopxx.shopxxhr.repository.extension.QuerydslJpaRepositoryExtension;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends QuerydslJpaRepositoryExtension<T, ID> {

}