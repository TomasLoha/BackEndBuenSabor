/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buenSabor.BackEnd.models.producto;

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
@Table(name = "ArticuloInsumo")
public class ArticuloInsumo extends Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_compra")
    private Double precioCompra;
    
   
    @OneToMany(mappedBy = "idArticuloInsumo", fetch = FetchType.EAGER)
    private List<StockArticuloInsumo> stockArticuloInsumoList;
    @OneToMany(mappedBy = "idArticuloInsumo", fetch = FetchType.EAGER)
    private List<HistoricoPrecioCostoArticuloInsumo> historicoPrecioCostoArticuloInsumoList;

    public ArticuloInsumo() {
    }

    public ArticuloInsumo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public List<StockArticuloInsumo> getStockArticuloInsumoList() {
        return stockArticuloInsumoList;
    }

    public void setStockArticuloInsumoList(List<StockArticuloInsumo> stockArticuloInsumoList) {
        this.stockArticuloInsumoList = stockArticuloInsumoList;
    }

    public List<HistoricoPrecioCostoArticuloInsumo> getHistoricoPrecioCostoArticuloInsumoList() {
        return historicoPrecioCostoArticuloInsumoList;
    }

    public void setHistoricoPrecioCostoArticuloInsumoList(List<HistoricoPrecioCostoArticuloInsumo> historicoPrecioCostoArticuloInsumoList) {
        this.historicoPrecioCostoArticuloInsumoList = historicoPrecioCostoArticuloInsumoList;
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
        if (!(object instanceof ArticuloInsumo)) {
            return false;
        }
        ArticuloInsumo other = (ArticuloInsumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.buenSabor.BackEnd.models.direccion.ArticuloInsumo[ id=" + id + " ]";
    }
    
}
