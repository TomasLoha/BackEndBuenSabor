/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buenSabor.BackEnd.models.producto;

import com.buenSabor.BackEnd.models.venta.Pedido;
import com.buenSabor.BackEnd.models.venta.PromocionArticulo;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "existe")
    private Boolean existe;
    @Column(name = "es_para_elaborar")
    private Boolean esParaElaborar;
    
    
    
    @ManyToMany(mappedBy = "articuloList", fetch = FetchType.EAGER)
    private List<Pedido> pedidoList;
    //
//    @OneToMany(mappedBy = "articulo", fetch = FetchType.EAGER)
//    private List<ArticuloManufacturado> articuloManufacturadoList;
    //
    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.EAGER)
    private List<HistoricoPrecioVentaArticulo> historicoPrecioVentaArticuloList;
    //
//    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.EAGER)
//    private List<ArticuloInsumo> articuloInsumoList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private ImagenArticulo imagenArticulo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private UnidadMedida unidadMedida;
    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.EAGER)
    private List<PromocionArticulo> promocionArticuloList;
    @OneToMany(mappedBy = "idArticulo", fetch = FetchType.EAGER)
    private List<DetalleArticulo> detalleArticuloList;

    public Articulo() {
    }

    public Articulo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }

    public Boolean getEsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(Boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

   

    public List<HistoricoPrecioVentaArticulo> getHistoricoPrecioVentaArticuloList() {
        return historicoPrecioVentaArticuloList;
    }

    public void setHistoricoPrecioVentaArticuloList(List<HistoricoPrecioVentaArticulo> historicoPrecioVentaArticuloList) {
        this.historicoPrecioVentaArticuloList = historicoPrecioVentaArticuloList;
    }

    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ImagenArticulo getImagenArticulo() {
        return imagenArticulo;
    }

    public void setImagenArticulo(ImagenArticulo imagenArticulo) {
        this.imagenArticulo = imagenArticulo;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<PromocionArticulo> getPromocionArticuloList() {
        return promocionArticuloList;
    }

    public void setPromocionArticuloList(List<PromocionArticulo> promocionArticuloList) {
        this.promocionArticuloList = promocionArticuloList;
    }

    public List<DetalleArticulo> getDetalleArticuloList() {
        return detalleArticuloList;
    }

    public void setDetalleArticuloList(List<DetalleArticulo> detalleArticuloList) {
        this.detalleArticuloList = detalleArticuloList;
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
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.buenSabor.BackEnd.models.direccion.Articulo[ id=" + id + " ]";
    }
    
}
