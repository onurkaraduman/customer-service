package com.onrkrdmn.restapi.dto;

import com.onrkrdmn.repository.domain.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Getter
@Setter
public class CustomerDto implements BaseDto {

    @NotNull
    private String fullName;

    @NotNull
    private String email;

    private List<ContractDto> contracts;
}
