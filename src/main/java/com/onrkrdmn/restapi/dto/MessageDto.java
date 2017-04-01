package com.onrkrdmn.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Getter
@Setter
@AllArgsConstructor
public class MessageDto implements BaseDto {
    private int code;
    private String message;
}
