package com.geanbaila.parcial.service;

import com.geanbaila.parcial.entity.ProductoEntity;
import com.geanbaila.parcial.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> getProductos() {
        return productoRepository.findAll();
    }

    public ProductoEntity getProducto(int id){
        return productoRepository.findById(id).orElse(null);
    }

    

}
