package br.com.kualit.service;

import br.com.kualit.deserializer.OperationDeserializer;
import br.com.kualit.model.Operation;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TicketProcessment {

    public void processTickets() throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OperationDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        try (KafkaConsumer<String, Operation> consumer = new KafkaConsumer<>(properties)) {
            System.out.println("Waiting values from the topic kualit-tickets");
            consumer.subscribe(List.of("kualit-tickets"));
            
            while(true) {
                ConsumerRecords<String, Operation> poll = consumer.poll(Duration.ofMillis(200));
                for(ConsumerRecord<String, Operation> record : poll) {
                    Operation operation = record.value();
                    System.out.println("Operation : " + operation.getOperationId() + " processed succesfully!");
                }

                Thread.sleep(500);
            }
        }
    }
}
