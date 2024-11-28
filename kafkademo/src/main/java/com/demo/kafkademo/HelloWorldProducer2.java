package com.demo.kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class HelloWorldProducer2 {
    public static void main(String[] args) throws InterruptedException {
        String bootstrapServers = "127.0.0.1:19092";
        String groupId = "test_group_1";
        String topic = "HELLO_WORLD_2";

        // create producer configs
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);


        for (int i = 0; i < 1000000; i++) {
            //Create a producer record
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, "Hello World " + i);


            //Send the data - async
            producer.send(producerRecord);
            Thread.sleep(100);
        }

        //flush data - sync
        producer.flush();

        //flush and close the producer
        producer.close();
    }
}
