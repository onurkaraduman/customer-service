package com.onrkrdmn.repository;

import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *  Database operations for {@link com.onrkrdmn.repository.domain.Contract}
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Repository
public interface ContractRepository extends com.onrkrdmn.repository.Repository<Contract, Long> {

    /**
     * Retrive all contracts of a specicic customer
     *
     * @param customer
     * @return
     */
    public List<Contract> findByCustomer(Customer customer);

    /**
     * Retrieve the sum of revenues of all contracts of a specific type
     *
     * @param type {@link ContractType}
     * @return
     */
    @Query("select sum(c.monthlyRevenue) from Contract c where c.type = :#{#type}")
    public double sumOfMonthlyRevenue(@Param("type") ContractType type);
}
