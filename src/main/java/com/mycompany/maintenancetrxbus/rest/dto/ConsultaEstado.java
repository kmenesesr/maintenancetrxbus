package com.mycompany.maintenancetrxbus.rest.dto;

import java.math.BigInteger;

public class ConsultaEstado {
    private BigInteger transaccionId;
    private BigInteger merchantId;

    public BigInteger getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(BigInteger transaccionId) {
        this.transaccionId = transaccionId;
    }

    public BigInteger getMerchantId() {
        return merchantId;
    }
    public void setMerchantId(BigInteger merchantId) {
        this.merchantId = merchantId;
    }
}
