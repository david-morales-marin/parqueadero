package com.example.parqueadero.servicios;

import com.example.parqueadero.entidades.Factura;
import com.example.parqueadero.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServices {
    @Autowired
    FacturaRepository facturaRepository;

    public FacturaServices(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> obtenerFacturas(){
        return this.facturaRepository.findAll();
    }

    public Optional<Factura> obtenerFacturaXId(int id){
        return this.facturaRepository.findById(id);
    }
}
