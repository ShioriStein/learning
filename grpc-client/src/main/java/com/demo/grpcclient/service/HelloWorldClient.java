package com.demo.grpcclient.service;

import com.demo.grpc.stubs.HelloWorldRequest;
import com.demo.grpc.stubs.HelloWorldResponse;
import com.demo.grpc.stubs.HelloWorldServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class HelloWorldClient {

    public HelloWorldResponse doHello(String name, String age) {
        //Create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        //Create stub
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        //Create reuest

        HelloWorldRequest.Builder requestBuilder = HelloWorldRequest.newBuilder();
        Optional.ofNullable(name).ifPresent(requestBuilder::setName);
        requestBuilder.setAge(Integer.parseInt(age));
//        if(StringUtils.hasText(age)) {
//            requestBuilder.setAge(Integer.parseInt(age));
//        }

        HelloWorldResponse helloWorldResponse = stub.sayHello(requestBuilder.build());

        channel.shutdown();

        return helloWorldResponse;
    }
}
