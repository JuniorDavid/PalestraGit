/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author silvano
 */
@Entity
@Table(name = "articolo")
@NamedQueries({
    @NamedQuery(name = "Articolo.findAll", query = "SELECT a FROM Articolo a")
    , @NamedQuery(name = "Articolo.findByCodice", query = "SELECT a FROM Articolo a WHERE a.codice = :codice")
    , @NamedQuery(name = "Articolo.findByDescrizione", query = "SELECT a FROM Articolo a WHERE a.descrizione = :descrizione")})
public class Articolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codice")
    private String codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descrizione")
    private String descrizione;
    @JoinTable(name = "articolo_magazzino", joinColumns = {
        @JoinColumn(name = "codice_articolo", referencedColumnName = "codice")}, inverseJoinColumns = {
        @JoinColumn(name = "codice_magazzino", referencedColumnName = "codice")})
    @ManyToMany
    private List<Magazzino> magazzinoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articolo")
    private List<RigaOrdine> rigaOrdineList;

    public Articolo() {
    }

    public Articolo(String codice) {
        this.codice = codice;
    }

    public Articolo(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Magazzino> getMagazzinoList() {
        return magazzinoList;
    }

    public void setMagazzinoList(List<Magazzino> magazzinoList) {
        this.magazzinoList = magazzinoList;
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
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articolo)) {
            return false;
        }
        Articolo other = (Articolo) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.piana.silvano.corsospring.Articolo[ codice=" + codice + " ]";
    }
    
}
