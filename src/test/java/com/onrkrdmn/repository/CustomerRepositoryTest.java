package com.onrkrdmn.repository;

import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by onur on 01.04.17.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void sumOfMonthlyRevenue() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("test@gmail.com");
        customer.setFullName("John Doe");

        List<Contract> contracts = new ArrayList<>();

        contracts.add(creatContact(1000, customer));
        contracts.add(creatContact(1200, customer));

        customer.setContracts(contracts);

        customerRepository.save(customer);

        double sumOfMonthlyRevenue = customerRepository.sumOfMonthlyRevenue(customer);

        assertThat(sumOfMonthlyRevenue).isEqualTo(2200);
    }

    private Contract creatContact(double monthlyRevenue, Customer customer) {
        Contract contract = new Contract();
        contract.setMonthlyRevenue(monthlyRevenue);
        contract.setStartDate(new Date());

        ContractType type = new ContractType();
        type.setName("Express Contract");

        contract.setType(type);
        contract.setCustomer(customer);
        return contract;
    }

}