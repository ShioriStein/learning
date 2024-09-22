package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
//    vertx.createHttpServer().requestHandler(req -> {
//      req.response()
//        .putHeader("content-type", "text/plain")
//        .end("Hello from Vert.x!");
//    }).listen(8888).onComplete(http -> {
//      if (http.succeeded()) {
//        startPromise.complete();
//        System.out.println("HTTP server started on port 8888");
//      } else {
//        startPromise.fail(http.cause());
//      }
//    });
    //Create a router
    Router router = Router.router(vertx);

    //Mount the handler for all incomign requests at every path and HTTP method
    router.route().handler(context -> {
      //Get the address of the request
      String address = context.request().connection().remoteAddress().toString();
      // Get the query parameter "name"
      MultiMap queryParams = context.queryParams();
      String name = queryParams.contains("name") ? queryParams.get("name") : "unknow";
      // Write a json response
      context.json(new JsonObject().put("name", name)
        .put("address", address)
        .put("message", "Hello " + name + " connected from " + address));
    });

    // Create the HTTP server
    vertx.createHttpServer()
      //Handler every request using the router
      .requestHandler(router).listen(8888)
      // Start listening
      //Print the port on success
      .onSuccess(httpServer -> {
        System.out.println("HTTP server started on port " + httpServer.actualPort());
        startPromise.complete();
      })

      //Print the problem on failure
      .onFailure(throwable -> {
        throwable.printStackTrace();
        startPromise.fail(throwable);
      });
    ;
  }

  @Override
  public void stop() throws Exception {
    System.out.println("Stopping");
  }
}
