package br.com.kualit.service;

import br.com.kualit.model.Operation;
import br.com.kualit.serializer.OperationSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.math.BigDecimal;
import java.util.Properties;
import java.util.Random;

public class OperationGenerator {

    private static Random random = new Random();
    private static long operationId = 0;
    private BigDecimal ticketPrice = BigDecimal.valueOf(500);

    public void generateOperation() {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OperationSerializer.class.getName());

        try (KafkaProducer<String, Operation> producer = new KafkaProducer<>(properties)) {
            Operation operation = newOperation();
            ProducerRecord<String, Operation> producerRecord = new ProducerRecord<>("kualit-tickets", operation);
            producer.send(producerRecord);
        }
    }
    private Operation newOperation() {
        long clientId = random.nextInt();
        int totalOfTickets = random.nextInt();
        return new Operation(random.nextLong(), clientId, totalOfTickets, ticketPrice.multiply(BigDecimal.valueOf(totalOfTickets)));
    }
}
