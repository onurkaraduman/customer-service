package com.onrkrdmn.repository;

import com.onrkrdmn.repository.domain.Customer;
import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Database operations for {@link com.onrkrdmn.repository.domain.Customer}
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Repository
public interface CustomerRepository extends com.onrkrdmn.repository.Repository<Customer, Long> {

    /**
     * Retrieve the sum of revenues of all contracts from an existing customer
     *
     * @param customer
     * @return
     */
    @Query("select sum(c.monthlyRevenue) from Contract c where c.customer = :#{#customer}")
    public double sumOfMonthlyRevenue(@Param("customer") Customer customer);

    /**
     * Find customer with full name
     *
     * @param fullName
     * @return
     */
    public Customer findByFullName(String fullName);
}
