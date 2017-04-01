package com.onrkrdmn.service;

import com.onrkrdmn.repository.Repository;
import com.onrkrdmn.repository.domain.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
public abstract class AbstractService<T extends AbstractEntity> implements Service<T> {

    public abstract Repository getRepository();

    public Page<T> list(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public T findById(Long id) {
        return (T) getRepository().findOne(id);
    }

    public T save(T entity) {
        return (T) getRepository().save(entity);
    }
}
