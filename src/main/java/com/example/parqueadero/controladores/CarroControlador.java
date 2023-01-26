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
@RequestMapping("/carro")
public class CarroControlador {

    @Autowired
    public CarroServices carroServices;

    @Autowired
    public FacturaServices facturaServices;

    @Autowired
    public UsuarioServices usuarioServices;

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
        this.facturaServices.crearFactura(carro.getFacturaid());
        this.usuarioServices.crearUsuario(carro.getUsuarioid());
        return this.carroServices.crearRegistroCarro(carro);
    }

    @DeleteMapping("/eliminarCarro/{id}")
    public String eliminarCarro(@PathVariable ("id") int id){
        this.carroServices.eliminarCarro(id);
        return "El carro ha sido eliminado exitosamente";
    }

    @PutMapping("/actualizarCarro/{id}")
    public Carro actualizarRegistroCarro(@PathVariable("id") int id, @RequestBody Carro carro){

        Factura factura = carro.getFacturaid();
        this.facturaServices.editarFactura(factura , factura.getId());

        Usuario usuario = carro.getUsuarioid();
        this.usuarioServices.editarUsuario(usuario , usuario.getId());

        return this.carroServices.editarRegistroCarro(carro,id);
    }
}
