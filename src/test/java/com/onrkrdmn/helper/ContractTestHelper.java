package com.onrkrdmn.helper;

import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class ContractTestHelper {

    public static Contract creatContact(double monthlyRevenue, Customer customer) {
        Contract contract = new Contract();
        contract.setMonthlyRevenue(monthlyRevenue);
        contract.setStartDate(new Date());

        ContractType type = new ContractType();
        type.setName("express");

        contract.setType(type);
        contract.setCustomer(customer);
        return contract;
    }

    public static ContractType createType(String type) {
        ContractType contractType = new ContractType();
        contractType.setName(type);
        return contractType;
    }
}
