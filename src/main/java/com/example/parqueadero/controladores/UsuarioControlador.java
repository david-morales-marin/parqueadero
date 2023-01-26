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
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    public UsuarioServices usuarioServices;

    @Autowired
    public FacturaServices facturaServices;

    @Autowired
    public CarroServices carroServices;

    public UsuarioControlador(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return this.usuarioServices.obtenerUsuarios();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> obtenerUnUsuario(@PathVariable ("id") int id){
        return this.usuarioServices.obtenerUsuarioXId(id);
    }

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        this.carroServices.crearRegistroCarro(usuario.getCarroid());
        this.facturaServices.crearFactura(usuario.getFacturaid());
        return this.usuarioServices.crearUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@PathVariable ("int") int id){
        this.usuarioServices.eliminarUsuario(id);
        return "Se ha eliminado el usuario";
    }

    @PutMapping("/editarUsuario/{id}")
    public Usuario editarUsuario( @PathVariable("id") int id , @RequestBody Usuario usuario){
        Carro carro = usuario.getCarroid();
        this.carroServices.editarRegistroCarro(carro, carro.getId());

        Factura factura = usuario.getFacturaid();
        this.facturaServices.editarFactura(factura, factura.getId());

        return this.usuarioServices.editarUsuario(usuario,id);
    }

}
