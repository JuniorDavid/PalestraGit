package com.esis.esempioSpring.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ClientiDTO implements Serializable {

	private Integer idCliente;
	private String nome;
	private String cognome;
	private String cf;
//	private Date fineAbbonamento;
	private String fineAbbonamento;
//	private AccessiDTO accessi;
	private String usr;

	public ClientiDTO() {
		super();
//		accessi = new AccessiDTO();
	}

	public ClientiDTO(Integer idCliente, String nome, String cognome, String cf, String fineAbbonamento/*, AccessiDTO accessi*/) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.fineAbbonamento = fineAbbonamento;
//		this.usr = accessi;
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

//	public Date getFineAbbonamento() {
//		return fineAbbonamento;
//	}
//
//	public void setFineAbbonamento(Date fineAbbonamento) {
//		this.fineAbbonamento = fineAbbonamento;
//	}
	
	public String getFineAbbonamento() {
		return fineAbbonamento;
	}

	public void setFineAbbonamento(String fineAbbonamento) {
		this.fineAbbonamento = fineAbbonamento;
	}

//	public AccessiDTO getAccessi() {
//		return accessi;
//	}
//
//	public void setAccessi(AccessiDTO accessi) {
//		this.accessi = accessi;
//	}

	public String getUsr() {
		return usr;
	}

	public void setUsr (String usr) {
		this.usr = usr;
	}
}