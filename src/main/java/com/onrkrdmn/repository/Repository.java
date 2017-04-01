package com.onrkrdmn.repository;

import com.onrkrdmn.repository.domain.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * This interface is the custom base repository extended {@link JpaRepository}
 * This interface should be extended by all repositories
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@NoRepositoryBean
public interface Repository<T extends AbstractEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
