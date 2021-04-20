package com.geanbaila.parcial.repository;

import com.geanbaila.parcial.entity.MonedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity,Integer>{
    
}
