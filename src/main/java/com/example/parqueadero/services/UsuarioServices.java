package com.example.parqueadero.services;

import com.example.parqueadero.entitys.Usuario;
import com.example.parqueadero.excepciones.ApiRequestException;
import com.example.parqueadero.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceLoader;

import static java.util.Arrays.stream;
import static java.util.Locale.filter;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public int obtenerUsuarioXCedula(int cedula) {

     /*   if(usuarioRepository.findByCedula(cedula).get() == null ){
            throw new ApiRequestException("No se encontro un usuario con cedula" , 404 );
        } */
        // return
                    usuarioRepository.findByCedula(cedula)
                   .stream()
                   .filter(p -> p.getCedula().equals(cedula))
                   .findFirst();
                if(usuarioRepository.existsByCedula(cedula) == false ){
                     //   usuarioRepository.findByCedula(cedula).get() == null){
                    throw new ApiRequestException("No se encontro un usuario con cedula" , 404 );
                }
             return usuarioRepository.findByCedula(cedula).get().getCedula();
    }

    public Usuario crearUsuario(Usuario nuevoUsuario){
            return this.usuarioRepository.save(nuevoUsuario);

    }
    public void eliminarUsuario(int id) {

        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public Usuario editarUsuario(Usuario usuario, int id){
        Usuario usuario1 = usuarioRepository.findById(id).get();

        if(Objects.nonNull(
                usuario.getApellido())
        && !"".equalsIgnoreCase(
                usuario.getApellido().toString())){
            usuario1.setApellido(
                    usuario.getApellido());
        }
       /* if(Objects.nonNull(
                usuario.getCarroid())
        && !"".equalsIgnoreCase(
                usuario.getCarroid().toString())){
            usuario1.setCarroid(
                    usuario.getCarroid());
        }
        if(Objects.nonNull(
                usuario.getFacturaid())
        && !"".equalsIgnoreCase(
                usuario.getFacturaid().toString())){
            usuario1.setFacturaid(
                    usuario.getFacturaid());
        } */
        if(Objects.nonNull(
                usuario.getCedula())
        && !"".equalsIgnoreCase(
                usuario.getCedula().toString())){
            usuario1.setCedula(
                    usuario.getCedula());
        }
        if(Objects.nonNull(
                usuario.getCelular())
        && !"".equalsIgnoreCase(
                usuario.getCelular().toString())){
            usuario1.setCelular(
                    usuario.getCelular());
        }
        if(Objects.nonNull(
                usuario.getCorreo())
        && !"".equalsIgnoreCase(
                usuario.getCorreo().toString())){
            usuario1.setCorreo(
                    usuario.getCorreo());
        }
        if(Objects.nonNull(
                usuario.getNombre())
        && !"".equalsIgnoreCase(
                usuario.getNombre().toString())){
            usuario1.setNombre(
                    usuario.getNombre());
        }
        
        return this.usuarioRepository.save(usuario1);
    }

}