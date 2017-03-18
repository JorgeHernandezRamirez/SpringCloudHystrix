package com.jorgehernandezramirez.spring.springcloud.backend.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.jersey.api.client.ClientHandlerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    public TokenController(){
        //For Spring
    }

    @HystrixCommand(fallbackMethod = "getTokenHystrixFallbackMethod")
    @RequestMapping(method = RequestMethod.GET)
    public String getToken() {
        //Here we throw a ClientHandlerException simulating error of communication
        throw new ClientHandlerException();
    }

    private String getTokenHystrixFallbackMethod() {
        return "El servicio se encuentra no disponible. Inténtelo más tarde.";
    }
}