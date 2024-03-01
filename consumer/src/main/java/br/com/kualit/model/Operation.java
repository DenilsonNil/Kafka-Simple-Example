package br.com.kualit.model;

import java.math.BigDecimal;

public class Operation {

    private Long operationId;
    private Long clientId;
    private Integer totalOfTickets;
    private BigDecimal totalAmount;
    private String status;

    public Operation(Long operationId, Long clientId, Integer totalOfTickets, BigDecimal totalAmount) {
        this.operationId = operationId;
        this.clientId = clientId;
        this.totalOfTickets = totalOfTickets;
        this.totalAmount = totalAmount;
    }

    public Operation() {

    }
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getTotalOfTickets() {
        return totalOfTickets;
    }

    public void setTotalOfTickets(Integer totalOfTickets) {
        this.totalOfTickets = totalOfTickets;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", clientId=" + clientId +
                ", quantity=" + totalOfTickets +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
