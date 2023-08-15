package com.example.parqueadero.repositorys;

import com.example.parqueadero.entitys.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro , Integer> {
}