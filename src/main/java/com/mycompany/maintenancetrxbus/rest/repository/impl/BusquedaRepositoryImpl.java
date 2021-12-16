package com.mycompany.maintenancetrxbus.rest.repository.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.maintenancetrxbus.rest.dto.constants.Constants;
import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.*;
import com.mycompany.maintenancetrxbus.rest.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Repository
public class BusquedaRepositoryImpl implements BusquedaRepository {

    public static final String SP_CONSULTAESTADO = "SP__CONSULTAESTADO";

    @Autowired
    private EntityManager entityManager;




    @Override
    public ConsultaEstadoOutDto consultaEstado(ConsultaEstadoInDto consultaEstadoInDto) {
       ConsultaEstadoOutDto result = new ConsultaEstadoOutDto();
 /*        StoredProcedureQuery spq = this.entityManager.createStoredProcedureQuery(SP_CONSULTAESTADO)
                        // input
                        .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                        // parameters
                        .setParameter(1, consultaEstadoInDto.getTransactionId())
                        .setParameter(2, consultaEstadoInDto.getOrderId())
                        .setParameter(3, consultaEstadoInDto.getAmount())
                        .setParameter(4, consultaEstadoInDto.getGatewayId())
                        .setParameter(5, consultaEstadoInDto.getGatewayName())
                        .setParameter(6, consultaEstadoInDto.getReferenceId())
                        .setParameter(7, consultaEstadoInDto.getRequestDate())
                        .setParameter(8, consultaEstadoInDto.getCurrencyCode());
        
        
                        spq.execute();

                        if (spq.hasMoreResults()==true){
                            result.setTransactionId(consultaEstadoInDto.getTransactionId());
                            result.setReferenceId(consultaEstadoInDto.getReferenceId());
                            result.setErrorCode(0);
                            result.setErrorMessage("");
                        }
                        else {
                            result.setTransactionId(consultaEstadoInDto.getTransactionId());
                            result.setReferenceId(consultaEstadoInDto.getReferenceId());
                            result.setErrorCode(404);
                            result.setErrorMessage("Recurso no encontrado en base de datos");
                        }
  */
        result.setErrorCode(0);
        return result;
}

}
