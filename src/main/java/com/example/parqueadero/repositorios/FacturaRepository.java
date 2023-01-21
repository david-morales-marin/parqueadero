package com.example.parqueadero.repositorios;

import com.example.parqueadero.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura , Integer> {
}