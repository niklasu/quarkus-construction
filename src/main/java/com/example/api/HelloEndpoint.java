package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloEndpoint {
    private final Logger logger = LoggerFactory.getLogger(HelloEndpoint.class);

    @GET
    public void sayHello(
            @QueryParam("fname") String firstName,
            @QueryParam("lname") String lastName
    ) {
        logger.info(firstName + " " + lastName);
    }
}