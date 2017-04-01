package com.onrkrdmn.helper;

import com.onrkrdmn.repository.domain.Customer;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class CustomerTestHelper {

    public static Customer createCustomer() {
        Customer customer = new Customer();
        customer.setEmail("test@gmail.com");
        customer.setFullName("John Doe");
        return customer;
    }
}
