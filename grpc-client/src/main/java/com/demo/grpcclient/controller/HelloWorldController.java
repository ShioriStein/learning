package com.demo.grpcclient.controller;

import com.demo.grpc.stubs.HelloWorldRequest;
import com.demo.grpc.stubs.HelloWorldResponse;
import com.demo.grpc.stubs.HelloWorldServiceGrpc;
import com.demo.grpcclient.dto.ReturnResponse;
import com.demo.grpcclient.service.HelloWorldClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @GetMapping
    public ReturnResponse sayHelloWorld(String name, String age) {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();
//
//        //Create stub
//        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
//
//        HelloWorldResponse helloWorldResponse = stub.sayHello(HelloWorldRequest.newBuilder().setName(name).build());
//
////        channel.shutdown();
//
//        return helloWorldResponse;
        ReturnResponse returnResponse = new ReturnResponse();
        returnResponse.setGreeting(helloWorldClient.doHello(name, age).getGreeting());

        return returnResponse;
    }
}
