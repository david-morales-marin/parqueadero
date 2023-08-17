package com.example.parqueadero.repositorys;

import com.example.parqueadero.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Integer> {

   // List<Usuario> getUsuarioByCedula(int cedula);

    Optional<Usuario> findByCedula(int cedula);

    public Boolean existsByCedula(int cedula);


}