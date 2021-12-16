package com.mycompany.maintenancetrxbus.rest.dto.in;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConsultaEstadoInDto{

    private BigInteger transactionId;
    private String orderId;
    private String payerName;
    private BigDecimal amount;
    private BigInteger gatewayId;
    private String gatewayName;
    private String referenceId;
    private String requestDate;
    private String currencyCode;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigInteger transactionId) {
        this.transactionId = transactionId;
    }

    public BigInteger getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(BigInteger gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "ConsultaEstadoDto{" +
                "transactionId=" + transactionId +
                ", orderId='" + orderId + '\'' +
                ", payerName='" + payerName + '\'' +
                ", amount=" + amount +
                ", gatewayId=" + gatewayId +
                ", gatewayName='" + gatewayName + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
