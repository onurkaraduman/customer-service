package com.onrkrdmn.restapi.dto;

import com.onrkrdmn.repository.domain.Contract;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Getter
@Setter
public class CustomerDto implements BaseDto {

    private String fullName;

    private String email;

    private List<ContractDto> contracts;
}
