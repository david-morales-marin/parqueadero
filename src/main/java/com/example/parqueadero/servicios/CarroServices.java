package com.example.parqueadero.servicios;

import com.example.parqueadero.entidades.Carro;
import com.example.parqueadero.repositorios.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarroServices {
    @Autowired
    CarroRepository carroRepository;

    public CarroServices(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> obtenerCarros(){
        return this.carroRepository.findAll();
    }

    public Optional<Carro> obtenerCarroXId(int id){
        return this.carroRepository.findById(id);
    }

    public Carro crearRegistroCarro(Carro nuevoCarro){
        return this.carroRepository.save(nuevoCarro);
    }

    public void eliminarCarro(int id){
        this.carroRepository.deleteById(id);
    }

    public Carro editarRegistroCarro(Carro carro, int id){
        Carro carro1 = carroRepository.findById(id).get();

        if(Objects.nonNull(
                carro.getMatricula())
                && !"".equalsIgnoreCase(
                        carro.getMatricula().toString())) {
            carro1.setMatricula(
                    carro.getMatricula());
        }
            if (Objects.nonNull(
                    carro.getCiudadCarro())
                    && !"".equalsIgnoreCase(
                    carro.getCiudadCarro().toString())) {
                carro1.setCiudadCarro(
                        carro.getCiudadCarro());
            }
        if (Objects.nonNull(
                carro.getFacturaid())
                && !"".equalsIgnoreCase(
                carro.getFacturaid().toString())
        ) {
            carro1.setFacturaid(
                    carro.getFacturaid());
        }
        if (Objects.nonNull(
                carro.getPlaca())
            && !"".equalsIgnoreCase(
              carro.getPlaca().toString())){
            carro1.setPlaca(
                    carro.getPlaca());
        }
        if (Objects.nonNull(
                carro.getUsuarioid())
                && !"".equalsIgnoreCase(
                        carro.getUsuarioid().toString())){
                    carro1.setUsuarioid(
                            carro.getUsuarioid());
        }
        return  this.carroRepository.save(carro1);
    }

}
