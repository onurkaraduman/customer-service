package com.onrkrdmn.restapi.dto;

import com.onrkrdmn.repository.domain.ContractType;
import com.onrkrdmn.repository.domain.Customer;
import lombok.Getter;
import lombok.Setter;
import org.dozer.Mapping;

import java.util.Date;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Getter
@Setter
public class ContractDto {

    private Date startDate;

    private double monthlyRevenue;

    @Mapping("type.name")
    private String type;
}
