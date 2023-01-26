package com.example.parqueadero.controladores;

import com.example.parqueadero.entidades.Carro;
import com.example.parqueadero.entidades.Factura;
import com.example.parqueadero.entidades.Usuario;
import com.example.parqueadero.servicios.CarroServices;
import com.example.parqueadero.servicios.FacturaServices;
import com.example.parqueadero.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/factura")
public class FacturaControlador {

    @Autowired
    public FacturaServices facturaServices;

    @Autowired
    public CarroServices carroServices;

    @Autowired
    public UsuarioServices usuarioServices;

    public FacturaControlador(FacturaServices facturaServices) {
        this.facturaServices = facturaServices;
    }

    @GetMapping("/facturas")
    public List<Factura> obtenerFacturas(){
        return this.facturaServices.obtenerFacturas();
    }

    @GetMapping("/factura/{id}")
    public Optional<Factura> obtenerUnaFactura(@PathVariable ("id") int id){
        return this.facturaServices.obtenerFacturaXId(id);
    }

    @PostMapping("/crearFactura")
    public Factura crearFactura(@RequestBody Factura factura){
        this.carroServices.crearRegistroCarro(factura.getCarroid());
        this.usuarioServices.crearUsuario(factura.getUsuarioid());
        return this.facturaServices.crearFactura(factura);
    }

    @DeleteMapping("/eliminarFactura/{id}")
    public String eliminarFactura(@PathVariable ("id") int id){
        this.facturaServices.eliminarFactura(id);
        return "Se ha eliminado la factura satisfactoriamente";
    }

    @PutMapping("/editarFactura/{id}")
    public Factura editarFactura(@PathVariable ("id") int id , @RequestBody Factura factura ){

        Carro carro = factura.getCarroid();
        this.carroServices.editarRegistroCarro(carro , carro.getId());

        Usuario usuario = factura.getUsuarioid();
        this.usuarioServices.editarUsuario(usuario , factura.getId());

        return this.facturaServices.editarFactura(factura, id);
    }
}
