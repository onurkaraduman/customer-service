package com.onrkrdmn.service.exception;

/**
 * Customer not exist exception
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long customerId) {
        super(String.format("Customer not found. CustomerID:%s", customerId));
    }
}
