package com.example.parqueadero.repositorys;

import com.example.parqueadero.entitys.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura , Integer> {
}