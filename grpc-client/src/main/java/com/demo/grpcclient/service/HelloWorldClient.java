package com.demo.grpcclient.service;

import com.demo.grpc.stubs.HelloWorldRequest;
import com.demo.grpc.stubs.HelloWorldResponse;
import com.demo.grpc.stubs.HelloWorldServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldClient {

    public HelloWorldResponse doHello(String name, String age) {
        //Create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        //Create stub
        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        HelloWorldResponse helloWorldResponse = stub.sayHello(HelloWorldRequest.newBuilder().setName(name).build());

        channel.shutdown();

        return helloWorldResponse;
    }
}
