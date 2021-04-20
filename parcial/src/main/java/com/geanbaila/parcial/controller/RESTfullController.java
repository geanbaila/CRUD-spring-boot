package com.geanbaila.parcial.controller;

import com.geanbaila.parcial.entity.MonedaEntity;
import com.geanbaila.parcial.entity.ProductoEntity;
import com.geanbaila.parcial.service.FacturaService;
import com.geanbaila.parcial.service.MonedaService;
import com.geanbaila.parcial.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/RESTfull/")
public class RESTfullController {

    @Autowired
    private MonedaService monedaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private FacturaService facturaService;

    @RequestMapping(value = "/producto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoEntity> productos() {
        return productoService.getProductos();
    }

    @RequestMapping(value = "/producto/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoEntity productoby(@PathVariable("id") int id) {
        return productoService.getProducto(id);
    }

    @PostMapping(value = "/moneda", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonedaEntity> monedas() {
        return monedaService.getMonedas();
    }

    @PostMapping(value = "/moneda/tipocambio/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MonedaEntity tipocambio(@PathVariable("id") int id) {
        return monedaService.getMoneda(id);
    }

    @PostMapping(value = "/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
        facturaService.deleteFactura(id); 
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
