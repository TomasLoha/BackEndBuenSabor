/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buenSabor.BackEnd.models.producto;

import com.buenSabor.BackEnd.models.empresa.Sucursal;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author oscarloha
 */
@Entity
@Table(name = "Stock_ArticuloInsumo")
public class StockArticuloInsumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "max_stock")
    private Integer maxStock;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_articulo_insumo", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ArticuloInsumo idArticuloInsumo;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal idSucursal;
    @OneToMany(mappedBy = "idstockarticuloInsumo", fetch = FetchType.EAGER)
    private List<HistoricoStockArticuloInsumo> historicoStockArticuloInsumoList;

    public StockArticuloInsumo() {
    }

    public StockArticuloInsumo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ArticuloInsumo getIdArticuloInsumo() {
        return idArticuloInsumo;
    }

    public void setIdArticuloInsumo(ArticuloInsumo idArticuloInsumo) {
        this.idArticuloInsumo = idArticuloInsumo;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public List<HistoricoStockArticuloInsumo> getHistoricoStockArticuloInsumoList() {
        return historicoStockArticuloInsumoList;
    }

    public void setHistoricoStockArticuloInsumoList(List<HistoricoStockArticuloInsumo> historicoStockArticuloInsumoList) {
        this.historicoStockArticuloInsumoList = historicoStockArticuloInsumoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockArticuloInsumo)) {
            return false;
        }
        StockArticuloInsumo other = (StockArticuloInsumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.buenSabor.BackEnd.models.direccion.StockArticuloInsumo[ id=" + id + " ]";
    }
    
}
