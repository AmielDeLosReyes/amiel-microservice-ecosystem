package com.sample_service.rest.controller;

import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private Tracer tracer;

    @GetMapping("/")
    public String greet() { return "Hello from sample-service!"; }
}
