package com.mycompany.maintenancetrxbus.rest.service;

import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.ConsultaEstadoOutDto;

import java.io.IOException;
import java.net.MalformedURLException;

public interface BusquedaService {

    ConsultaEstadoOutDto consultaEstado(ConsultaEstadoInDto consutaEstadoInDto) throws IOException, Exception;

}
