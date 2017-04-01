package com.onrkrdmn.restapi.model;

import com.onrkrdmn.restapi.dto.BaseDto;
import com.onrkrdmn.restapi.dto.MessageDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Custom response body
 * In the future, some fields can be added according to needs
 *
 * @author Onur Karaduman
 * @since 01.04.17
 */
@Getter
@Setter
public class Response<T extends BaseDto> extends ResponseEntity<T> {

    public Response() {
        super(HttpStatus.OK);
    }

    public Response(T body, HttpStatus status) {
        super(body, status);
    }

    public Response(T body) {
        super(body, HttpStatus.OK);
    }
}
