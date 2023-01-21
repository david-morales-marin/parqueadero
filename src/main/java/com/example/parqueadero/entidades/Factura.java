package com.example.parqueadero.entidades;

public class Factura {

    private Integer id;

    private Integer numeroFactura;

    private double horaParqueo;

    private double totalPagar;

    private double descuento;

    private Usuario usuarioid;

    private Carro carroid;

    public Factura() {

    }

    public Factura(Integer id, Integer numeroFactura, double horaParqueo, double totalPagar, double descuento, Usuario usuarioid, Carro carroid) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.horaParqueo = horaParqueo;
        this.totalPagar = totalPagar;
        this.descuento = descuento;
        this.usuarioid = usuarioid;
        this.carroid = carroid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getHoraParqueo() {
        return horaParqueo;
    }

    public void setHoraParqueo(double horaParqueo) {
        this.horaParqueo = horaParqueo;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Carro getCarroid() {
        return carroid;
    }

    public void setCarroid(Carro carroid) {
        this.carroid = carroid;
    }
}
