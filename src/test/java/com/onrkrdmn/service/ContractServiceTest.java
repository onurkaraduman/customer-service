package com.onrkrdmn.service;

import com.onrkrdmn.helper.ContractTestHelper;
import com.onrkrdmn.helper.CustomerTestHelper;
import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by onur on 01.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ContractServiceTest {

    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void findAllByCustomerId() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);
        customer.addContract(contract);
        customerService.save(customer);


        List<Contract> contracts = contractService.findAllByCustomerId(customer.getId());
        assertThat(contracts).hasSize(1);
    }

    @Test
    public void findByCustomer() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);
        customer.addContract(contract);
        customerService.save(customer);

        List<Contract> contracts = contractService.findByCustomer(customer);

        assertThat(contracts).hasSize(1);
    }

    @Test
    public void sumOfMonthlyRevenueByType() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);
        ContractType contractType = ContractTestHelper.createType("express");
        contract.setType(contractType);

        customer.addContract(contract);
        customerService.save(customer);

        double express = contractService.sumOfMonthlyRevenueByType("express");
        assertThat(express).isEqualTo(2000);
    }

    @Test
    public void getAllContractType() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);
        ContractType contractType = ContractTestHelper.createType("express");
        contract.setType(contractType);

        customer.addContract(contract);
        customerService.save(customer);

        List<ContractType> contractTypes = contractService.getAllContractType();
        assertThat(contractTypes).hasSize(1);

    }

    @Test
    public void findContractTypeByName() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);
        ContractType contractType = ContractTestHelper.createType("express");
        contract.setType(contractType);

        customer.addContract(contract);
        customerService.save(customer);

        ContractType contractTypeByName = contractService.findContractTypeByName("express");
        assertThat(contractTypeByName.getName()).isEqualTo("express");
    }

}