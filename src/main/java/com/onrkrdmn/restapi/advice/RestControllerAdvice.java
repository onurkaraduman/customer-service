package com.onrkrdmn.restapi.advice;

import com.onrkrdmn.service.exception.ContractTypeNotFoundException;
import com.onrkrdmn.service.exception.CustomerExistException;
import com.onrkrdmn.service.exception.CustomerNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@ControllerAdvice("com.onrkrdmn.restapi.controller")
public class RestControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors customerNotFoundExceptionHandle(CustomerNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(ContractTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors contractTypeNotFoundExceptionHandle(ContractTypeNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(CustomerExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors customerAlreadyExistExceptionHandle(CustomerExistException ex) {
        return new VndErrors("error", ex.getMessage());
    }


}
