/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author silvano
 */
@Embeddable
public class RigaOrdinePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codice_articolo")
    private String codiceArticolo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_testata")
    private int idTestata;

    public RigaOrdinePK() {
    }

    public RigaOrdinePK(String codiceArticolo, int idTestata) {
        this.codiceArticolo = codiceArticolo;
        this.idTestata = idTestata;
    }

    public String getCodiceArticolo() {
        return codiceArticolo;
    }

    public void setCodiceArticolo(String codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public int getIdTestata() {
        return idTestata;
    }

    public void setIdTestata(int idTestata) {
        this.idTestata = idTestata;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceArticolo != null ? codiceArticolo.hashCode() : 0);
        hash += (int) idTestata;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RigaOrdinePK)) {
            return false;
        }
        RigaOrdinePK other = (RigaOrdinePK) object;
        if ((this.codiceArticolo == null && other.codiceArticolo != null) || (this.codiceArticolo != null && !this.codiceArticolo.equals(other.codiceArticolo))) {
            return false;
        }
        if (this.idTestata != other.idTestata) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.piana.silvano.corsospring.RigaOrdinePK[ codiceArticolo=" + codiceArticolo + ", idTestata=" + idTestata + " ]";
    }
    
}
