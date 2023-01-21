package com.example.parqueadero.repositorios;

import com.example.parqueadero.entidades.Carro;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro , Integer> {
}