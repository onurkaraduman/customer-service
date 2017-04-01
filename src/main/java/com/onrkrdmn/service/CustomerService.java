package com.onrkrdmn.service;

import com.onrkrdmn.repository.ContractTypeRepository;
import com.onrkrdmn.repository.CustomerRepository;
import com.onrkrdmn.repository.Repository;
import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import com.onrkrdmn.service.exception.CustomerExistException;
import com.onrkrdmn.service.exception.CustomerNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business operations for {@link Customer}
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Service
@Log4j
public class CustomerService extends AbstractService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public Repository getRepository() {
        return this.customerRepository;
    }

    /**
     * Add a contract to existing customer
     * If contractType exist, don't create with same name.
     *
     * @param customerId
     * @param contract
     */
    public void addContract(Long customerId, Contract contract) {
        Customer customer = this.findById(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException(customerId);
        }
        ContractType contractType = contractTypeRepository.findByName(contract.getType().getName());
        if (contractType != null) {
            contract.setType(contractType);
        }
        customer.addContract(contract);
        contract.setCustomer(customer);
        this.customerRepository.save(customer);
    }

    /**
     * Sum of monthly revenues of specific customer
     *
     * @param customerId
     * @return
     */
    public double sumOfMonthlyRevenue(Long customerId) {
        Customer customer = this.findById(customerId);
        return this.customerRepository.sumOfMonthlyRevenue(customer);
    }

    @Override
    public Customer save(Customer entity) {
        Customer existCustomer = this.customerRepository.findByFullName(entity.getFullName());
        if (existCustomer != null) {
            throw new CustomerExistException(entity.getFullName());
        }
        return super.save(entity);
    }
}
