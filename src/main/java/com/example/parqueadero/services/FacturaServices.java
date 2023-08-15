package com.example.parqueadero.services;

import com.example.parqueadero.entitys.Factura;
import com.example.parqueadero.repositorys.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void eliminarFactura(int id){
        this.facturaRepository.deleteById(id);
    }
    public Factura crearFactura(Factura nuevaFactura){
        return this.facturaRepository.save(nuevaFactura);
    }

    public Factura editarFactura(Factura factura, int id){
        Factura factura1 = facturaRepository.findById(id).get();

        if(Objects.nonNull(
                factura.getNumeroFactura())
            && !"".equalsIgnoreCase(
                    factura.getNumeroFactura().toString())) {
            factura1.setNumeroFactura(
                    factura.getNumeroFactura());
        }
        if (Objects.nonNull(
                factura.getUsuarioid())
                && !"".equalsIgnoreCase(
                factura.getUsuarioid().toString())) {
            factura1.setUsuarioid(
                    factura.getUsuarioid());
        }
        if (Objects.nonNull(
                factura.getCarroid())
                        && !"".equalsIgnoreCase(
                        factura.getCarroid().toString())) {
            factura1.setCarroid(
                    factura.getCarroid());
        }
        if(Objects.nonNull(
                factura.getDescuento())
     /*   && !"".equalsIgnoreCase(
                factura.getDescuento())*/){
            factura1.setDescuento(
                    factura.getDescuento());
        }
        if(Objects.nonNull(
                factura.getHoraParqueo())){
            factura1.setHoraParqueo(
                    factura.getHoraParqueo());
        }
        if(Objects.nonNull(
                factura.getTotalPagar())){
            factura1.setTotalPagar(
                    factura.getTotalPagar());
        }

        return this.facturaRepository.save(factura1);
    }
}
