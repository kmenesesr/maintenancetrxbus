package com.mycompany.maintenancetrxbus.rest.dto.base;

public class BaseInDto extends BaseDto {

    private static final long serialVersionUID = 7066491278553927928L;

    private String keyCode;

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseInDto{");
        sb.append("keyCode='").append(keyCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
