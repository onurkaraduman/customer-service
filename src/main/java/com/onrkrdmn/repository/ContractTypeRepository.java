package com.onrkrdmn.repository;

import com.onrkrdmn.repository.domain.ContractType;
import org.springframework.stereotype.Repository;

/**
 * Database operations for {@link com.onrkrdmn.repository.domain.ContractType}
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Repository
public interface ContractTypeRepository extends com.onrkrdmn.repository.Repository<ContractType, Long> {

    public ContractType findByName(String name);
}
