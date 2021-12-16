package com.mycompany.maintenancetrxbus.rest.dto.base;

import com.mycompany.maintenancetrxbus.rest.enums.ErrorEnum;

public class BaseOutDto extends BaseDto {

    private static final long serialVersionUID = 7824693124569066165L;

    private Integer errorCode = ErrorEnum.NO_ERROR.getValue();
    private String message = ErrorEnum.NO_ERROR.getReason();

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseOutDto{");
        sb.append("errorCode=").append(errorCode);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
