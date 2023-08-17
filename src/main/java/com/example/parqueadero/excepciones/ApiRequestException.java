package com.example.parqueadero.excepciones;

public class ApiRequestException extends RuntimeException{

    private int statusCode;

    public ApiRequestException(String mensaje){
        super(mensaje);
    }

    public ApiRequestException(String mensaje, Throwable cause){
        super(mensaje,cause);
    }

    public ApiRequestException(String mensaje, int statusCode){
        super(mensaje);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
