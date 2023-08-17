package com.example.parqueadero.entitys;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "numero_Factura")
    private Integer numeroFactura;

    @Column(name = "Hora_parqueadero")
    private double horaParqueo;

    @Column(name = "Total_Pagar")
    private double totalPagar;

    @Column(name = "Descuento")
    private double descuento;

   // @Column(name = " Usuario_id")
   // @OneToOne
    //  private Usuario usuarioid;

   // @Column(name = "Carro_id")
   // @OneToOne
    // private Carro carroid;

    public Factura() {

    }

    public Factura(Integer id, Integer numeroFactura, double horaParqueo, double totalPagar, double descuento) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.horaParqueo = horaParqueo;
        this.totalPagar = totalPagar;
        this.descuento = descuento;
        //   this.usuarioid = usuarioid;
        //   this.carroid = carroid;
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

  /*  public Usuario getUsuarioid() {
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
    }  */
}
