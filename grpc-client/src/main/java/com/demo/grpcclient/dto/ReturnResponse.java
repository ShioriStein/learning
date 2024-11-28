package com.demo.grpcclient.dto;


public class ReturnResponse {
    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    String greeting;
}
