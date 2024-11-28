package com.demo.kafkademo.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class HelloWorldOtherGroupConsumer4Spam {
    public static void main(String[] args) throws InterruptedException {
        String bootstrapServers = "127.0.0.1:19092";
        String groupId = "test_group_4";
        String topic = "HELLO_WORLD_2";

        // create consumer configs
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        // create consumer
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        // subscribe'
        kafkaConsumer.subscribe(Arrays.asList(topic));

        // polling for data
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Key: " + record.key() + " Value: " + record.value());
                System.out.println("Partition: " + record.partition() + " Offset: " + record.offset());
                Thread.sleep(1000);
            }
        }

    }
}
