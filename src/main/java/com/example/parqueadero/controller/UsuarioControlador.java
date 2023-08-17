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
@RequestMapping("/usuario")
public class UsuarioControlador {

      @Autowired
      public UsuarioServices usuarioServices;

    //     @Autowired
       // public FacturaServices facturaServices;

    //  @Autowired
    //  public CarroServices carroServices;

    public UsuarioControlador(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        return this.usuarioServices.obtenerUsuarios();
    }

    @GetMapping("/usuario123/{cedula}")
    public int obtenerUnUsuario(@PathVariable ("cedula") int cedula){
        return this.usuarioServices.obtenerUsuarioXCedula(cedula);
             /*   .stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst(); */
    }

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        //  this.carroServices.crearRegistroCarro(usuario.getCarroid());
        //  this.facturaServices.crearFactura(usuario.getFacturaid());
        return this.usuarioServices.crearUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@PathVariable ("int") int id){
        this.usuarioServices.eliminarUsuario(id);
        return "Se ha eliminado el usuario";
    }

    @PutMapping("/editarUsuario/{id}")
    public Usuario editarUsuario( @PathVariable("id") int id , @RequestBody Usuario usuario){
        // Carro carro = usuario.getCarroid();
        // this.carroServices.editarRegistroCarro(carro, carro.getId());

        //  Factura factura = usuario.getFacturaid();
        //   this.facturaServices.editarFactura(factura, factura.getId());

        return this.usuarioServices.editarUsuario(usuario,id);
    }

}
