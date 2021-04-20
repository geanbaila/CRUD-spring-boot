package com.geanbaila.parcial.service;

import com.geanbaila.parcial.entity.MonedaEntity;
import com.geanbaila.parcial.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    public List<MonedaEntity> getMonedas() {
        return monedaRepository.findAll();
    }

    public MonedaEntity getMoneda(int id){
        return monedaRepository.findById(id).orElse(null);
    }
}
