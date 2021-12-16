package com.mycompany.maintenancetrxbus.rest;

import com.mycompany.maintenancetrxbus.rest.dto.base.BaseOutDto;
import com.mycompany.maintenancetrxbus.rest.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BusinessExceptionHandler extends RuntimeException {

    private static final long serialVersionUID = -4534956548747715607L;

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseOutDto businessExceptionHandler(BusinessException businessException) {
        BaseOutDto response = new BaseOutDto();
        response.setErrorCode(businessException.getStatusCode());
        response.setMessage(businessException.getMessage());
        return response;

    }
}
