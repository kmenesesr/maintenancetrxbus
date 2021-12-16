package com.mycompany.maintenancetrxbus.rest.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5957411162817737869L;

    private Integer statusCode;

    public BusinessException(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public BusinessException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public BusinessException(Integer statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public BusinessException(Integer statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusinessException{");
        sb.append("statusCode=").append(statusCode);
        sb.append('}');
        return sb.toString();
    }

}
