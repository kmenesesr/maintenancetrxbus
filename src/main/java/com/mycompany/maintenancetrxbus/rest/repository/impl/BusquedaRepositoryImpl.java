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
    public boolean existsConsultaEstado(ConsultaEstadoInDto consultaEstadoInDto) {

        StoredProcedureQuery spq = this.entityManager.createStoredProcedureQuery(SP_CONSULTAESTADO)
                .registerStoredProcedureParameter(1, BigInteger.class, ParameterMode.IN)
                .setParameter(1, consultaEstadoInDto.getTransactionId())
                .registerStoredProcedureParameter(2, BigInteger.class, ParameterMode.IN)
                .setParameter(2, consultaEstadoInDto.getOrderId())
                .registerStoredProcedureParameter(3, BigDecimal.class, ParameterMode.IN)
                .setParameter(3, consultaEstadoInDto.getAmount())
                .registerStoredProcedureParameter(4, BigInteger.class, ParameterMode.IN)
                .setParameter(4, consultaEstadoInDto.getGatewayId())
                .registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
                .setParameter(5, consultaEstadoInDto.getGatewayName())
                .registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
                .setParameter(6, consultaEstadoInDto.getReferenceId())
                .registerStoredProcedureParameter(7, String.class, ParameterMode.IN)
                .setParameter(7, consultaEstadoInDto.getCurrencyCode());

        spq.execute();
        BigInteger count = (BigInteger) spq.getResultList().get(0);
        if (count != BigInteger.ZERO) {
            return true;
        }
        return false;
    }

}
