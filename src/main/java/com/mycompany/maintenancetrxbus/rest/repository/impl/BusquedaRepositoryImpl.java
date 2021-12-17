package com.mycompany.maintenancetrxbus.rest.repository.impl;

import com.mycompany.maintenancetrxbus.rest.dto.ConsultaEstado;
import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.repository.BusquedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public class BusquedaRepositoryImpl implements BusquedaRepository {

    public static final String SP_CONSULTAESTADO = "SP_CONSULTAESTADO";

    @Autowired
    private EntityManager entityManager;


    @Override
    public ConsultaEstado consultaEstado(ConsultaEstadoInDto consultaEstadoInDto) {
        ConsultaEstado result = new ConsultaEstado();

        String merchantid = null;
        StoredProcedureQuery spq = this.entityManager.createStoredProcedureQuery(SP_CONSULTAESTADO)
                .registerStoredProcedureParameter(1, BigInteger.class, ParameterMode.INOUT)
                .setParameter(1, consultaEstadoInDto.getTransactionId())
                .registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT)
                .setParameter(2, consultaEstadoInDto.getOrderId())
                .registerStoredProcedureParameter(3, BigDecimal.class, ParameterMode.INOUT)
                .setParameter(3, consultaEstadoInDto.getAmount())
                .registerStoredProcedureParameter(4, BigInteger.class, ParameterMode.INOUT)
                .setParameter(4, consultaEstadoInDto.getGatewayId())
                .registerStoredProcedureParameter(5, String.class, ParameterMode.INOUT)
                .setParameter(5, consultaEstadoInDto.getGatewayName())
                .registerStoredProcedureParameter(6, String.class, ParameterMode.INOUT)
                .setParameter(6, consultaEstadoInDto.getReferenceId())
                .registerStoredProcedureParameter(7, String.class, ParameterMode.INOUT)
                .setParameter(7, consultaEstadoInDto.getRequestDate())
                .registerStoredProcedureParameter(8, String.class, ParameterMode.INOUT)
                .setParameter(8, consultaEstadoInDto.getCurrencyCode())
                .registerStoredProcedureParameter(9, String.class, ParameterMode.INOUT)
                .setParameter(9, merchantid);

        spq.execute();

        if (spq.hasMoreResults() == true) {
            result.setMerchantId((BigInteger) spq.getOutputParameterValue(merchantid));
            result.setTransaccionId(consultaEstadoInDto.getTransactionId());
        }
        return result;
    }

}
