package com.example.parqueadero.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO" )
    private String apellido;

    @Column(name = "CEDULA")
    private Integer cedula;

    @Column(name = "CORREO" )
    private String correo;

    @Column(name = "CELULAR" )
    private String celular;

    @Column(name = "FACTURA_ID")
    @OneToOne
    private Factura facturaid;

    @Column(name = "CARRO_ID")
    @OneToOne
    private Carro carroid;

    public Usuario() {

    }

    public Usuario(Integer id, String nombre, String apellido, Integer cedula, String correo, String celular, Factura facturaid, Carro carroid) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.facturaid = facturaid;
        this.carroid = carroid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Factura getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(Factura facturaid) {
        this.facturaid = facturaid;
    }

    public Carro getCarroid() {
        return carroid;
    }

    public void setCarroid(Carro carroid) {
        this.carroid = carroid;
    }
}
