package com.onrkrdmn.restapi.controller;

import com.onrkrdmn.restapi.dto.SumOfRevenueDto;
import com.onrkrdmn.restapi.model.Response;
import com.onrkrdmn.service.ContractService;
import com.onrkrdmn.service.CustomerService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Contract rest api
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@RestController
@RequestMapping("/contracts")
public class ContractController implements Controller {

    @Autowired
    private ContractService contractService;

    private Mapper mapper;


    @PostConstruct
    public void init() {
        this.mapper = new DozerBeanMapper();
    }


    @RequestMapping("/{type}/sum")
    public Response sumOfRevenuesByType(@Validated @PathVariable String type) {
        double sumOfRevenue = contractService.sumOfMonthlyRevenueByType(type);
        SumOfRevenueDto revenueDto = new SumOfRevenueDto(sumOfRevenue);
        return new Response<>(revenueDto, HttpStatus.OK);
    }
}
