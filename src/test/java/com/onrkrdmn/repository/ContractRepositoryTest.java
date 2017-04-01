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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by onur on 01.04.17.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class ContractRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("test@gmail.com");
        customer.setFullName("John Doe");

        Contract contract = new Contract();
        contract.setMonthlyRevenue(1000);
        contract.setStartDate(new Date());

        ContractType type = new ContractType();
        type.setName("Express Contract");

        contract.setType(type);
        contract.setCustomer(customer);

        customer.setContracts(Arrays.asList(contract));

        customerRepository.save(customer);

        List<Contract> foundContracts = contractRepository.findByCustomer(customer);

        assertThat(foundContracts).hasSize(1);
    }

}