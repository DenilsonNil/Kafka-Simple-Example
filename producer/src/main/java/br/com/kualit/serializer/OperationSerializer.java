package br.com.kualit.serializer;

import br.com.kualit.model.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class OperationSerializer implements Serializer<Operation> {
    @Override
    public byte[] serialize(String s, Operation operation) {
        try {
            return new ObjectMapper().writeValueAsBytes(operation);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
