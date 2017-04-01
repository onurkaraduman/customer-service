package com.onrkrdmn.service.exception;

/**
 * ContractType not exist exception
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class ContractTypeNotFoundException extends RuntimeException {

    public ContractTypeNotFoundException(String type) {
        super(String.format("ContractType not found. ContractType:%s", type));
    }
}
