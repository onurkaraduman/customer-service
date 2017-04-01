package com.onrkrdmn.restapi.controller;

import com.onrkrdmn.restapi.resource.RootResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Onur Karaduman
 * @since 01.04.17
 */
@RestController
@RequestMapping("/")
public class RootController implements Controller {

    @RequestMapping(method = RequestMethod.GET)
    public RootResource getRoot() {
        return new RootResource();
    }
}
