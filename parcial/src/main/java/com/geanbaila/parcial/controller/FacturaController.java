package com.geanbaila.parcial.controller;

import com.geanbaila.parcial.entity.ClienteEntity;
import com.geanbaila.parcial.entity.FacturaDetalleEntity;
import com.geanbaila.parcial.entity.FacturaEntity;
import com.geanbaila.parcial.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping(value = { "", "/" })
    public ModelAndView index() {
        List<FacturaEntity> facturas = facturaService.getFactura();
        return new ModelAndView("layout", "facturas", facturas);
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "factura/nuevo";
    }

    @GetMapping("/editar/{id}")
    public String mostrar(@PathVariable("id") int id){
        return "factura/nuevo";
    }

    @RequestMapping("/grabar")
    public String grabar(@RequestParam("numero") String numero, @RequestParam("cliente") String cliente,
            @RequestParam("fecha") String fecha, @RequestParam("moneda") int monedaId,
            @RequestParam("monto") double monto,
            @RequestParam(name = "cbproducto", required = false) String[] productoId,
            @RequestParam(name = "punitario", required = false) String[] precioUnitario,
            @RequestParam(name = "parcial", required = false) String[] precioParcial,
            @RequestParam(name = "cantidad", required = false) String[] cantidad) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente, "", "");
        FacturaEntity facturaEntity = new FacturaEntity(numero, fecha, clienteEntity, monedaId, monto);
        List<FacturaDetalleEntity> facturaDetalleEntity = new ArrayList<>();
        for (var i = 0; i < 3; i++) {
            if (!cantidad[i].isEmpty() && !productoId[i].isEmpty() && !precioUnitario[i].isEmpty()
                    && !precioParcial[i].isEmpty()) {
                if (!cantidad[i].equals("0") && !productoId[i].equals("0")) {
                    facturaDetalleEntity.add(new FacturaDetalleEntity(Integer.parseInt(productoId[i]),
                            Double.parseDouble(precioUnitario[i]), Double.parseDouble(precioParcial[i]),
                            Integer.parseInt(cantidad[i])));
                }
            }
        }
        facturaService.saveFactura(clienteEntity, facturaEntity, facturaDetalleEntity);
        return "redirect:/";
    }

}
