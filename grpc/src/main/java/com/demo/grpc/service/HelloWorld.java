package com.demo.grpc.service;

import com.demo.grpc.stubs.HelloWorldRequest;
import com.demo.grpc.stubs.HelloWorldResponse;
import com.demo.grpc.stubs.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloWorld extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    @Override
    public void sayHello(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        responseObserver.onNext(HelloWorldResponse.newBuilder().setGreeting("Greeting to " + request.getName()).build());
        responseObserver.onCompleted();
        super.sayHello(request, responseObserver);
    }
}
