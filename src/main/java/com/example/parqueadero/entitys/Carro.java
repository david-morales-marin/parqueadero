package com.example.parqueadero.entitys;


import javax.persistence.*;
import java.io.Serializable;

 @Entity
@Table(name = "Carro")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private enum tipoCarro{ escolar , privado , alimentos, moto, publico};
    @Column(name = "placa")
    private Integer placa;

    @Column(name = "matricula")
    private Long matricula;

    @Column(name = "ciudad_carro")
    private String ciudadCarro;

   // @Column(name = "usuario_id")
   // @OneToOne
    //  private Usuario usuarioid;

  //  @Column(name = "factura_id")
   // @OneToOne
    //   private Factura facturaid;

    public Carro() {
    }

    public Carro(Long id, Integer placa, Long matricula, String ciudadCarro) {
        this.id = id;
        this.placa = placa;
        this.matricula = matricula;
        this.ciudadCarro = ciudadCarro;
        //   this.usuarioid = usuarioid;
        //   this.facturaid = facturaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getCiudadCarro() {
        return ciudadCarro;
    }

    public void setCiudadCarro(String ciudadCarro) {
        this.ciudadCarro = ciudadCarro;
    }

    //  public Usuario getUsuarioid() {
    //    return usuarioid;
    //  }

    // public void setUsuarioid(Usuario usuarioid) {
    //     this.usuarioid = usuarioid;
    //   }

    //  public Factura getFacturaid() {
    //   return facturaid;
    //  }

    //  public void setFacturaid(Factura facturaid) {
    //   this.facturaid = facturaid;
    //  }
}
