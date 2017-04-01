package com.onrkrdmn.service;

import com.onrkrdmn.repository.ContractRepository;
import com.onrkrdmn.repository.ContractTypeRepository;
import com.onrkrdmn.repository.CustomerRepository;
import com.onrkrdmn.repository.Repository;
import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import com.onrkrdmn.service.exception.ContractTypeNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business operations for {@link Contract}
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Service
@Log4j
public class ContractService extends AbstractService<Contract> {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public Repository getRepository() {
        return this.contractRepository;
    }

    /**
     * Find all contracts by customer id
     *
     * @param customerId
     * @return
     */
    public List<Contract> findAllByCustomerId(Long customerId) {
        Customer customer = this.customerRepository.findOne(customerId);
        if (customer != null) {
            return customer.getContracts();
        }
        return null;
    }


    /**
     * Retrive all contracts of a specicic customer
     *
     * @param customer
     * @return
     */
    public List<Contract> findByCustomer(Customer customer) {
        return this.contractRepository.findByCustomer(customer);
    }

    /**
     * Retrieve the sum of revenues of all contracts of a specific type
     *
     * @param type {@link ContractType}
     * @return
     */
    public double sumOfMonthlyRevenueByType(String type) {
        ContractType contractType = this.findContractTypeByName(type);
        if (contractType == null) {
            throw new ContractTypeNotFoundException(type);
        }
        return this.contractRepository.sumOfMonthlyRevenue(contractType);
    }

    /**
     * Retrive all contract types
     *
     * @return
     */
    public List<ContractType> getAllContractType() {
        return this.contractTypeRepository.findAll();
    }

    /**
     * Find contractType by name
     *
     * @param name
     * @return
     */
    public ContractType findContractTypeByName(String name) {
        return this.contractTypeRepository.findByName(name);
    }
}
