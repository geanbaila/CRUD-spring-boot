package com.geanbaila.parcial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity(name = "ProductoEntity")
@Table(name = "producto")
@Data
public class ProductoEntity {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="marca_id")
    private int marcaId;

    @Column(name="modelo_id")
    private int modeloId;

    @Column(name="denominacion")
    private String denominacion;

    @Column(name="precio_unitario")
    private double precioUnitario;

    @Column(name="color")
    private String color;

    @Column(name="estado")
    private String estado;

    public ProductoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(int marcaId) {
        this.marcaId = marcaId;
    }

    public int getModeloId() {
        return modeloId;
    }

    public void setModeloId(int modeloId) {
        this.modeloId = modeloId;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
