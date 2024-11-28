FROM openjdk:17 as jdk

# Extend vert.x image
FROM vertx/vertx4

ENV VERTICLE_NAME com.example.starter.MainVerticle
ENV VERTICLE_FILE target/starter-1.0.0-SNAPSHOT.jar

COPY --from=jdk /usr/java/openjdk-17 /usr/java/openjdk-17
ENV JAVA_HOME=/usr/java/openjdk-17

# SEt the location of the verticles
ENV VERTICLE_HOME /usr/verticles

EXPOSE 8888
# Copy your verticle to the container
COPY $VERTICLE_FILE $VERTICLE_HOME/
#Launch the verticle
WORKDIR $VERTICLE_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec vertx run $VERTICLE_NAME -cp $VERTICLE_HOME/*"]
