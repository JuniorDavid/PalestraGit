/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author silvano
 */
@Entity
@Table(name = "magazzino")
@NamedQueries({
    @NamedQuery(name = "Magazzino.findAll", query = "SELECT m FROM Magazzino m")
    , @NamedQuery(name = "Magazzino.findByCodice", query = "SELECT m FROM Magazzino m WHERE m.codice = :codice")
    , @NamedQuery(name = "Magazzino.findByIndirizzo", query = "SELECT m FROM Magazzino m WHERE m.indirizzo = :indirizzo")})
public class Magazzino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codice")
    private String codice;
    @Size(max = 100)
    @Column(name = "indirizzo")
    private String indirizzo;
    @ManyToMany(mappedBy = "magazzinoList")
    private List<Articolo> articoloList;

    public Magazzino() {
    }

    public Magazzino(String codice) {
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public List<Articolo> getArticoloList() {
        return articoloList;
    }

    public void setArticoloList(List<Articolo> articoloList) {
        this.articoloList = articoloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magazzino)) {
            return false;
        }
        Magazzino other = (Magazzino) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.piana.silvano.corsospring.Magazzino[ codice=" + codice + " ]";
    }
    
}
