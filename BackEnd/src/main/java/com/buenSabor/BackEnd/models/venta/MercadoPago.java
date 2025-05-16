/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.buenSabor.BackEnd.models.venta;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author oscarloha
 */
@Entity
@Table(name = "Mercado_Pago")
public class MercadoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mpPaymentId")
    private Long mpPaymentId;
    @Column(name = "mpMerchantOrderId")
    private Integer mpMerchantOrderId;
    @Column(name = "mpPreferenceId")
    private String mpPreferenceId;
    @Column(name = "mpPaymentType")
    private String mpPaymentType;
//    @JoinColumns({
//        @JoinColumn(name = "payment_type_id", referencedColumnName = "id"),
//        @JoinColumn(name = "payment_type_id", referencedColumnName = "id")})
    @ManyToOne(fetch = FetchType.EAGER)
    private TipoPago tipoPago;

    public MercadoPago() {
    }

    public MercadoPago(Long mpPaymentId) {
        this.mpPaymentId = mpPaymentId;
    }

    public Long getMpPaymentId() {
        return mpPaymentId;
    }

    public void setMpPaymentId(Long mpPaymentId) {
        this.mpPaymentId = mpPaymentId;
    }

    public Integer getMpMerchantOrderId() {
        return mpMerchantOrderId;
    }

    public void setMpMerchantOrderId(Integer mpMerchantOrderId) {
        this.mpMerchantOrderId = mpMerchantOrderId;
    }

    public String getMpPreferenceId() {
        return mpPreferenceId;
    }

    public void setMpPreferenceId(String mpPreferenceId) {
        this.mpPreferenceId = mpPreferenceId;
    }

    public String getMpPaymentType() {
        return mpPaymentType;
    }

    public void setMpPaymentType(String mpPaymentType) {
        this.mpPaymentType = mpPaymentType;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mpPaymentId != null ? mpPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MercadoPago)) {
            return false;
        }
        MercadoPago other = (MercadoPago) object;
        if ((this.mpPaymentId == null && other.mpPaymentId != null) || (this.mpPaymentId != null && !this.mpPaymentId.equals(other.mpPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.buenSabor.BackEnd.models.direccion.MercadoPago[ mpPaymentId=" + mpPaymentId + " ]";
    }
    
}
