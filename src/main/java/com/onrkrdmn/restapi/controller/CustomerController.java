package com.onrkrdmn.restapi.controller;

import com.onrkrdmn.repository.domain.Contract;
import com.onrkrdmn.repository.domain.Customer;
import com.onrkrdmn.restapi.dto.ContractDto;
import com.onrkrdmn.restapi.dto.CustomerDto;
import com.onrkrdmn.restapi.dto.MessageDto;
import com.onrkrdmn.restapi.dto.SumOfRevenueDto;
import com.onrkrdmn.restapi.model.Response;
import com.onrkrdmn.service.CustomerService;
import com.onrkrdmn.service.exception.CustomerNotFoundException;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * Customer rest api
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@RestController
@RequestMapping("/customers")
public class CustomerController implements Controller {

    @Autowired
    private CustomerService customerService;


    private Mapper mapper;


    @PostConstruct
    public void init() {
        this.mapper = new DozerBeanMapper();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response createCustomer(@Validated @RequestBody CustomerDto customerDto) {
        Customer mapped = mapper.map(customerDto, Customer.class);
        customerService.save(mapped);
        MessageDto messageDto = new MessageDto(HttpStatus.OK.value(), "Success");
        return new Response<>(messageDto);
    }

    @RequestMapping(value = "/{customerId}/contracts", method = RequestMethod.POST)
    public Response createContract(@Validated @PathVariable Long customerId, @Validated @RequestBody ContractDto contractDto) {
        Contract mappedContract = mapper.map(contractDto, Contract.class);
        customerService.addContract(customerId, mappedContract);
        MessageDto messageDto = new MessageDto(HttpStatus.OK.value(), "Success");
        return new Response<>(messageDto);
    }

    @RequestMapping("/{customerId}")
    public Response<CustomerDto> customerDetails(@Validated @PathVariable Long customerId) {
        Customer foundCustomer = customerService.findById(customerId);
        if (foundCustomer == null) {
            throw new CustomerNotFoundException(customerId);
        }
        CustomerDto mappedCustomer = mapper.map(foundCustomer, CustomerDto.class);
        return new Response<>(mappedCustomer, HttpStatus.OK);
    }

    @RequestMapping("/{customerId}/contracts/sum")
    public Response sumOfRevenuesByCustomer(@Validated @PathVariable Long customerId) {
        double sumOfMonthlyRevenue = customerService.sumOfMonthlyRevenue(customerId);
        SumOfRevenueDto sumOfRevenueDto = new SumOfRevenueDto(sumOfMonthlyRevenue);
        return new Response<>(sumOfRevenueDto, HttpStatus.OK);
    }
}
