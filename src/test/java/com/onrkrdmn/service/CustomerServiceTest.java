package com.onrkrdmn.service;

import com.onrkrdmn.helper.ContractTestHelper;
import com.onrkrdmn.helper.CustomerTestHelper;
import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by onur on 01.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void addContract() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        Contract contract = ContractTestHelper.creatContact(2000, customer);

        customerService.save(customer);

        customerService.addContract(customer.getId(), contract);

        assertThat(customer.getContracts().get(0).getId()).isNotNull();
    }

    @Test
    public void sumOfMonthlyRevenue() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();
        List<Contract> contracts = new ArrayList<>();
        Contract contract1 = ContractTestHelper.creatContact(2000, customer);
        Contract contract2 = ContractTestHelper.creatContact(2500, customer);

        contracts.add(contract1);
        contracts.add(contract2);

        customer.setContracts(contracts);

        customerService.save(customer);

        double sumOfMonthlyRevenue = customerService.sumOfMonthlyRevenue(customer.getId());

        assertThat(sumOfMonthlyRevenue).isEqualTo(4500);
    }

    @Test
    public void save() throws Exception {
        Customer customer = CustomerTestHelper.createCustomer();

        customerService.save(customer);
        assertThat(customer.getId()).isNotNull();
    }

}