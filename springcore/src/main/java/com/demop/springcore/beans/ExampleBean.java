package com.demop.springcore.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean {

    public ExampleBean() {
        System.out.println("Constructor: Bean is being created");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct: Bean is going through custom initialization");
    }

    public void doSomething() {
        System.out.println("Bean is doing something");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy: Bean is being destroyed");
    }
}
