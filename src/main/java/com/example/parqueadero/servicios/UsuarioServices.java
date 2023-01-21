package com.example.parqueadero.servicios;

import com.example.parqueadero.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}