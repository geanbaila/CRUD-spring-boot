package com.geanbaila.parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.geanbaila.parcial.entity.FacturaEntity;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long> {
    
}