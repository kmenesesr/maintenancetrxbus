package com.mycompany.maintenancetrxbus.rest.enums;

public enum ErrorEnum {

    NO_ERROR(0, ""),
    GENERIC_ERROR(1000, "Generic error. "),
    REQUIRED_VALUE(1001, "Required value. "),
    INVALID_VALUE(1002, "Invalid value. ");

    private static final ErrorEnum[] VALUES;

    static {
        VALUES = values();
    }

    private final Integer value;
    private final String reason;

    ErrorEnum(Integer value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public Integer getValue() {
        return value;
    }

    public String getReason() {
        return reason;
    }

    public static ErrorEnum valueOf(Integer value) {
        ErrorEnum error = resolve(value);
        if (error == null) {
            throw new IllegalArgumentException("No matching constant for [" + value + "]");
        }
        return error;
    }

    private static ErrorEnum resolve(Integer value) {
        for (ErrorEnum error : VALUES) {
            if (error.value.equals(value)) {
                return error;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorEnum{");
        sb.append("value=").append(value);
        sb.append(", reason='").append(reason).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
