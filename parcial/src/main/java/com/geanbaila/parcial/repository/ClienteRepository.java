package com.geanbaila.parcial.repository;

import com.geanbaila.parcial.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer>{
    
}
