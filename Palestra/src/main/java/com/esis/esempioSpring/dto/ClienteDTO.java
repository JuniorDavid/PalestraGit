package com.esis.esempioSpring.dto;

import java.io.Serializable;

/**
 *
 * @author silvano
 */
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idCliente;
    private String nome;
    private String cognome;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteDTO(Integer idCliente, String cognome) {
        this.idCliente = idCliente;
        this.cognome = cognome;
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
}
