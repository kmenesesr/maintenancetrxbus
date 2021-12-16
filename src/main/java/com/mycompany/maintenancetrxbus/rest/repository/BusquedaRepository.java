package com.mycompany.maintenancetrxbus.rest.repository;

import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.ConsultaEstadoOutDto;

public interface BusquedaRepository {

    ConsultaEstadoOutDto consultaEstado(ConsultaEstadoInDto consultaEstadoInDto);


}
