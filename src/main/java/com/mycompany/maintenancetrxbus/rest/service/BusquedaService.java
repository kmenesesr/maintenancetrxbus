package com.mycompany.maintenancetrxbus.rest.service;

import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.ConsultaEstadoOutDto;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;

public interface BusquedaService {

    ConsultaEstadoOutDto consultaEstado(ConsultaEstadoInDto consutaEstadoInDto);

    default ConsultaEstadoOutDto getCommonError(String error) {
        ConsultaEstadoOutDto consultaEstadoOutDto = new ConsultaEstadoOutDto();
        consultaEstadoOutDto.setErrorCode(404);
        consultaEstadoOutDto.setErrorMessage(error);
        consultaEstadoOutDto.setStatus("FAILED");
        consultaEstadoOutDto.setTransactionId(BigInteger.ZERO);
        consultaEstadoOutDto.setData("");
        consultaEstadoOutDto.setReferenceId("");
        consultaEstadoOutDto.setMessage("");
        return consultaEstadoOutDto;
    }
}
