package com.geanbaila.parcial.service;

import com.geanbaila.parcial.entity.ClienteEntity;
import com.geanbaila.parcial.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity saveClient(ClienteEntity clienteEntity){
        ClienteEntity newClienteEntity = clienteRepository.save(clienteEntity);
        return newClienteEntity;
        
    }
    
}
