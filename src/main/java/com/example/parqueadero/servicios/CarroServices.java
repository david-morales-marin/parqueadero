package com.example.parqueadero.servicios;

import com.example.parqueadero.repositorios.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroServices {
    @Autowired
    CarroRepository carroRepository;

    public CarroServices(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }
}
