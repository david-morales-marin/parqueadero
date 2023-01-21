package com.example.parqueadero.servicios;

import com.example.parqueadero.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServices {
    @Autowired
    FacturaRepository facturaRepository;

    public FacturaServices(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }
}
