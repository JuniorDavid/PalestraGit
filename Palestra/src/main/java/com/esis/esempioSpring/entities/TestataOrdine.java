/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author silvano
 */
@Entity
@Table(name = "testata_ordine")
@NamedQueries({
    @NamedQuery(name = "TestataOrdine.findAll", query = "SELECT t FROM TestataOrdine t")
    , @NamedQuery(name = "TestataOrdine.findByIdTestata", query = "SELECT t FROM TestataOrdine t WHERE t.idTestata = :idTestata")
    , @NamedQuery(name = "TestataOrdine.findByDataConsegna", query = "SELECT t FROM TestataOrdine t WHERE t.dataConsegna = :dataConsegna")})
public class TestataOrdine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_testata")
    private Integer idTestata;
    @Column(name = "data_consegna")
    @Temporal(TemporalType.DATE)
    private Date dataConsegna;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testataOrdine")
    private List<RigaOrdine> rigaOrdineList;

    public TestataOrdine() {
    }

    public TestataOrdine(Integer idTestata) {
        this.idTestata = idTestata;
    }

    public Integer getIdTestata() {
        return idTestata;
    }

    public void setIdTestata(Integer idTestata) {
        this.idTestata = idTestata;
    }

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public List<RigaOrdine> getRigaOrdineList() {
        return rigaOrdineList;
    }

    public void setRigaOrdineList(List<RigaOrdine> rigaOrdineList) {
        this.rigaOrdineList = rigaOrdineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTestata != null ? idTestata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestataOrdine)) {
            return false;
        }
        TestataOrdine other = (TestataOrdine) object;
        if ((this.idTestata == null && other.idTestata != null) || (this.idTestata != null && !this.idTestata.equals(other.idTestata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.piana.silvano.corsospring.TestataOrdine[ idTestata=" + idTestata + " ]";
    }
    
}
