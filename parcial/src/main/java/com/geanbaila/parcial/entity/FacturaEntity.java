package com.geanbaila.parcial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "FacturaEntity")
@Table(name = "factura")
@Data
public class FacturaEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity cliente;

    @OneToMany(targetEntity=FacturaDetalleEntity.class)
    private List<FacturaDetalleEntity> facturaDetalle = new ArrayList<FacturaDetalleEntity>();

    @Column
    private String numero;

    @Column
    private String fecha;

    @Column(name="moneda_id")
    private Integer monedaId;

    @Column
    private double monto;

    @Column
    private String estado;

    public FacturaEntity() {
    };

    public FacturaEntity(String numero, String fecha, ClienteEntity cliente, Integer monedaId, double monto) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.monedaId = monedaId;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(Integer monedaId) {
        this.monedaId = monedaId;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<FacturaDetalleEntity> getFacturaDetalle() {
        return facturaDetalle;
    }

    public void setFacturaDetalle(List<FacturaDetalleEntity> facturaDetalle) {
        this.facturaDetalle = facturaDetalle;
    }

    
}
