package com.geanbaila.parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.geanbaila.parcial.entity.ClienteEntity;
import com.geanbaila.parcial.entity.FacturaDetalleEntity;
import com.geanbaila.parcial.entity.FacturaEntity;
import com.geanbaila.parcial.repository.FacturaDetalleRepository;
import com.geanbaila.parcial.repository.FacturaRepository;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    public List<FacturaEntity> getFactura() {
        List<FacturaEntity> factura = facturaRepository.findAll();
        return factura;
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public FacturaEntity saveFactura(ClienteEntity clienteEntity, FacturaEntity facturaEntity,
            List<FacturaDetalleEntity> l) {
        facturaEntity.setCliente(clienteEntity);
        FacturaEntity newFacturaEntity = facturaRepository.save(facturaEntity);
        if(!l.isEmpty()){
            for (FacturaDetalleEntity facturaDetalleEntity : l) {
                facturaDetalleEntity.setFactura(newFacturaEntity);
                this.saveFacturaDetalle(facturaDetalleEntity);
            }
        }
        return newFacturaEntity;
    }

    public void saveFacturaDetalle(FacturaDetalleEntity facturaDetalleEntity) {
        facturaDetalleRepository.save(facturaDetalleEntity);
    }

    public void deleteFactura(Long facturaId){
        Optional<FacturaEntity> o = facturaRepository.findById(facturaId);
        if(o.isPresent()){
            FacturaEntity facturaEntity =o.get();
            facturaDetalleRepository.deleteByFactura(facturaEntity.getId());
            facturaRepository.deleteById(facturaId);
        }

        
        
    }
 
}
