package com.geanbaila.parcial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "FacturaDetalleEntity")
@Table(name = "factura_detalle")

public class FacturaDetalleEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "precio_parcial")
    private double precioParcial;

    @Column
    private int cantidad;

    @Column(name = "producto_id")
    private int productoId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    private FacturaEntity factura;
    
    public FacturaDetalleEntity() {
    }

    public FacturaDetalleEntity(int productoId, double precioUnitario, double precioParcial,
            int cantidad) {
        this.productoId = productoId;
        this.precioUnitario = precioUnitario;
        this.precioParcial = precioParcial;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioParcial() {
        return precioParcial;
    }

    public void setPrecioParcial(double precioParcial) {
        this.precioParcial = precioParcial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

}
