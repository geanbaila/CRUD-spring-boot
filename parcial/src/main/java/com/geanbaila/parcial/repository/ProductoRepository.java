package com.geanbaila.parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geanbaila.parcial.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer>{
    
}
