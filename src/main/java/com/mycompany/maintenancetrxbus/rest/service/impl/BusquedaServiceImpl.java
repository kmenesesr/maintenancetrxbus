package com.mycompany.maintenancetrxbus.rest.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mycompany.maintenancetrxbus.rest.dto.ConsultaEstado;
import com.mycompany.maintenancetrxbus.rest.dto.constants.Util;
import com.mycompany.maintenancetrxbus.rest.dto.in.ConsultaEstadoInDto;
import com.mycompany.maintenancetrxbus.rest.dto.out.*;
import com.mycompany.maintenancetrxbus.rest.enums.ErrorEnum;
import com.mycompany.maintenancetrxbus.rest.exception.BusinessException;
import com.mycompany.maintenancetrxbus.rest.repository.BusquedaRepository;
import com.mycompany.maintenancetrxbus.rest.service.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class BusquedaServiceImpl implements BusquedaService {

    @Autowired
    private BusquedaRepository busquedaRepository;

    @Override
    public ConsultaEstadoOutDto consultaEstado(ConsultaEstadoInDto consultaEstadoInDto)  {

        ConsultaEstadoOutDto consultaEstadoOutDto = new ConsultaEstadoOutDto();
        try {
        validate(consultaEstadoInDto);

        if (busquedaRepository.existsConsultaEstado(consultaEstadoInDto) == true) {
                consultaEstadoOutDto = getConsultaEstado(getAuthentication(), Util.merchantId, consultaEstadoInDto.getReferenceId(), consultaEstadoInDto.getTransactionId());
        } else {
           consultaEstadoOutDto= getCommonError("No se encontraron datos de la transacción en base de datos");
        }
        } catch (Exception e) {
            consultaEstadoOutDto=getCommonError("No se ingresaron los parámetros requeridos");
        }
        return consultaEstadoOutDto;

    }

    private ConsultaEstadoOutDto getConsultaEstado(String autentication, int merchantId, String referenceId, BigInteger transactionId) throws Exception {
        ConsultaEstadoOutDto result = new ConsultaEstadoOutDto();
        String consultaEstado = "";
        String urlConsulta = "https://apisandbox.vnforappstest.com/api.authorization/v3/retrieve/transaction/" + merchantId + "/" + transactionId;
        URL url2 = new URL(urlConsulta);
        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
        con2.setRequestMethod("GET");
        con2.setRequestProperty("Content-Type", "application/json; utf-8");
        con2.setRequestProperty("Accept", "application/json");
        con2.setRequestProperty("Authorization", autentication);
        con2.setDoOutput(true);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con2.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            consultaEstado = response.toString();

            JsonObject json = JsonParser.parseString(consultaEstado).getAsJsonObject();

            JsonObject order = json.getAsJsonObject("order");
            JsonObject dataMap = json.getAsJsonObject("dataMap");
            result.setTransactionId(order.get("transactionId").getAsBigInteger());
            result.setData(dataMap.toString());
            result.setStatus(order.get("status").getAsString());
            result.setReferenceId(referenceId);
            result.setErrorCode(0);
            result.setErrorMessage("");
            result.setMessage(dataMap.get("ACTION_DESCRIPTION").getAsString());

        }
        return result;
    }

    private String getAuthentication() throws Exception {

        String authentication;

        URL url = new URL("https://apisandbox.vnforappstest.com/api.security/v1/security");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Authorization", "Z2lhbmNhZ2FsbGFyZG9AZ21haWwuY29tOkF2MyR0cnV6");
        con.setDoOutput(true);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            authentication = response.toString();
        }

        return authentication;
    }

    private void validate(ConsultaEstadoInDto consultaEstadoInDto) {

        if (!(consultaEstadoInDto.getTransactionId().compareTo(BigInteger.ZERO) > 0)) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "transactionId");
        }
        if (!(consultaEstadoInDto.getOrderId().compareTo(BigInteger.ZERO) > 0)) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "orderId");
        }
        if (!(consultaEstadoInDto.getAmount().compareTo(BigDecimal.ZERO) > 0)) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "amount");
        }
        if (!(consultaEstadoInDto.getGatewayId().compareTo(BigInteger.ZERO) > 0)) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "gatewayId");
        }
        if (!StringUtils.hasText(consultaEstadoInDto.getGatewayName())) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "gatewayName");
        }
        if (!StringUtils.hasText(consultaEstadoInDto.getReferenceId())) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "referenceId");
        }
        if (!StringUtils.hasText(consultaEstadoInDto.getRequestDate())) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "requestDate");
        }
        if (!StringUtils.hasText(consultaEstadoInDto.getCurrencyCode())) {
            throw new BusinessException(ErrorEnum.REQUIRED_VALUE.getValue(),
                    ErrorEnum.REQUIRED_VALUE.getReason() + "currencyCode");
        }
    }



}
