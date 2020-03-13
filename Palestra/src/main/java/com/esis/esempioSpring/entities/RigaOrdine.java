/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author silvano
 */
@Entity
@Table(name = "riga_ordine")
@NamedQueries({
    @NamedQuery(name = "RigaOrdine.findAll", query = "SELECT r FROM RigaOrdine r")
    , @NamedQuery(name = "RigaOrdine.findByCodiceArticolo", query = "SELECT r FROM RigaOrdine r WHERE r.rigaOrdinePK.codiceArticolo = :codiceArticolo")
    , @NamedQuery(name = "RigaOrdine.findByNumeroPezzi", query = "SELECT r FROM RigaOrdine r WHERE r.numeroPezzi = :numeroPezzi")
    , @NamedQuery(name = "RigaOrdine.findByIdTestata", query = "SELECT r FROM RigaOrdine r WHERE r.rigaOrdinePK.idTestata = :idTestata")})
public class RigaOrdine implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RigaOrdinePK rigaOrdinePK;
    @Column(name = "numero_pezzi")
    private Integer numeroPezzi;
    @JoinColumn(name = "codice_articolo", referencedColumnName = "codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Articolo articolo;
    @JoinColumn(name = "id_testata", referencedColumnName = "id_testata", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TestataOrdine testataOrdine;

    public RigaOrdine() {
    }

    public RigaOrdine(RigaOrdinePK rigaOrdinePK) {
        this.rigaOrdinePK = rigaOrdinePK;
    }

    public RigaOrdine(String codiceArticolo, int idTestata) {
        this.rigaOrdinePK = new RigaOrdinePK(codiceArticolo, idTestata);
    }

    public RigaOrdinePK getRigaOrdinePK() {
        return rigaOrdinePK;
    }

    public void setRigaOrdinePK(RigaOrdinePK rigaOrdinePK) {
        this.rigaOrdinePK = rigaOrdinePK;
    }

    public Integer getNumeroPezzi() {
        return numeroPezzi;
    }

    public void setNumeroPezzi(Integer numeroPezzi) {
        this.numeroPezzi = numeroPezzi;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public TestataOrdine getTestataOrdine() {
        return testataOrdine;
    }

    public void setTestataOrdine(TestataOrdine testataOrdine) {
        this.testataOrdine = testataOrdine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rigaOrdinePK != null ? rigaOrdinePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RigaOrdine)) {
            return false;
        }
        RigaOrdine other = (RigaOrdine) object;
        if ((this.rigaOrdinePK == null && other.rigaOrdinePK != null) || (this.rigaOrdinePK != null && !this.rigaOrdinePK.equals(other.rigaOrdinePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.piana.silvano.corsospring.RigaOrdine[ rigaOrdinePK=" + rigaOrdinePK + " ]";
    }
    
}
