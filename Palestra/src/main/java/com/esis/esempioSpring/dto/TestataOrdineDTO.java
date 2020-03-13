package com.esis.esempioSpring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author silvano
 */
public class TestataOrdineDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idTestata;
    private Date dataConsegna;
    private Integer idCliente;
    private String nome;
    private String cognome;
    private List<RigaOrdineDTO> rigaOrdineList;

    public TestataOrdineDTO() {
        rigaOrdineList = new ArrayList<>();
    }

    public TestataOrdineDTO(Integer idTestata) {
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<RigaOrdineDTO> getRigaOrdineList() {
        return rigaOrdineList;
    }

    public void setRigaOrdineList(List<RigaOrdineDTO> rigaOrdineList) {
        this.rigaOrdineList = rigaOrdineList;
    }
    
}
