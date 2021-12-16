package com.mycompany.maintenancetrxbus.rest.dto.out;

import com.mycompany.maintenancetrxbus.rest.dto.base.BaseDto;

import java.math.BigInteger;

public class ConsultaEstadoOutDto extends BaseDto {

    private BigInteger transactionId;
    private  String status;
    private  String data;
    private  String message;
    private String referenceId;
    private int errorCode;
    private String errorMessage;

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigInteger transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ConsutaEstadoOutDto{" +
                "transactionId=" + transactionId +
                ", status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
