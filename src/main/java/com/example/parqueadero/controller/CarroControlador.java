package com.example.parqueadero.controller;

import com.example.parqueadero.entitys.Carro;
import com.example.parqueadero.entitys.Factura;
import com.example.parqueadero.entitys.Usuario;
import com.example.parqueadero.services.CarroServices;
import com.example.parqueadero.services.FacturaServices;
import com.example.parqueadero.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroControlador {

    @Autowired
    public CarroServices carroServices;

    // @Autowired
    // public FacturaServices facturaServices;

    //  @Autowired
    // public UsuarioServices usuarioServices;

    public CarroControlador(CarroServices carroServices) {
        this.carroServices = carroServices;
    }

    @GetMapping("/carros")
    public List<Carro> obtenerCarros(){
        return  this.carroServices.obtenerCarros();
    }

    @GetMapping("/carro/{id}")
    public Optional<Carro> obtenerxCarro(@PathVariable ("id") int id){
        return this.carroServices.obtenerCarroXId(id);
    }

    @PostMapping("/RegistrarCarro")
    public Carro RegistrarCarro(@RequestBody Carro carro){
        //    this.facturaServices.crearFactura(carro.getFacturaid());
        //    this.usuarioServices.crearUsuario(carro.getUsuarioid());
        return this.carroServices.crearRegistroCarro(carro);
    }

    @DeleteMapping("/eliminarCarro/{id}")
    public String eliminarCarro(@PathVariable ("id") int id){
        this.carroServices.eliminarCarro(id);
        return "El carro ha sido eliminado exitosamente";
    }

    @PutMapping("/actualizarCarro/{id}")
    public Carro actualizarRegistroCarro(@PathVariable("id") int id, @RequestBody Carro carro){

        //   Factura factura = carro.getFacturaid();
        //  this.facturaServices.editarFactura(factura , factura.getId());

        //  Usuario usuario = carro.getUsuarioid();
        //  this.usuarioServices.editarUsuario(usuario , usuario.getId());

        return this.carroServices.editarRegistroCarro(carro,id);
    }
}
