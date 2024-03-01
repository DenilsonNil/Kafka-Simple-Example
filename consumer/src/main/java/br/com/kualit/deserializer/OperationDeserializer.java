package br.com.kualit.deserializer;

import br.com.kualit.model.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class OperationDeserializer implements Deserializer<Operation> {
    @Override
    public Operation deserialize(String topic, byte[] bytes) {
        try {
            return new ObjectMapper().readValue(bytes, Operation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
