package com.onrkrdmn.restapi.resource;

import com.onrkrdmn.restapi.controller.CustomerController;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
public class RootResource extends ResourceSupport {
    private String message;

    public RootResource() {
        this.message = "Welcome to connect4 api version 1.0.0";
        add(
                linkTo(CustomerController.class).withRel("customers")
        );

    }
}
