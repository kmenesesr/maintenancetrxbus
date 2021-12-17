package com.mycompany.maintenancetrxbus.rest.controller;

import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.ConsultaEstadoOutDto;
import com.mycompany.maintenancetrxbus.rest.service.BusquedaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class BusquedaController {

    public static final Logger LOGGER = LoggerFactory.getLogger(BusquedaController.class);

    @Autowired
    private BusquedaService busquedaService;

    @PostMapping(value = "/consultaEstado")
    public ConsultaEstadoOutDto consultaEstado(@RequestBody ConsultaEstadoInDto consutaEstadoInDto) throws IOException {
        LOGGER.debug("Procesando POST para /consultaEstado...");
        LOGGER.debug("Parameters = " + consutaEstadoInDto);
        try {
            return busquedaService.consultaEstado(consutaEstadoInDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
