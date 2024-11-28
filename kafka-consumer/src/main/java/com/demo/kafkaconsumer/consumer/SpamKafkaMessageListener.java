package com.demo.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpamKafkaMessageListener {

    @KafkaListener(topics = {"HELLO_WORLD_2"}, containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<?, ?> record) throws InterruptedException {
        System.out.println("Key: " + record.key() + " Value: " + record.value());
        System.out.println("Partition: " + record.partition() + " Offset: " + record.offset());
        Thread.sleep(1000);
    }
}
