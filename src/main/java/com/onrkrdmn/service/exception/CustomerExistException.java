package com.onrkrdmn.service.exception;

/**
 * Customer already exist exception
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class CustomerExistException extends RuntimeException {
    public CustomerExistException(String fullName) {
        super(String.format("Customer already exist. Customer FullName:%s", fullName));
    }
}
