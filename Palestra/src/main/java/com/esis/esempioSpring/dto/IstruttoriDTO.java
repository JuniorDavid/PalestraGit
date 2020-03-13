package com.esis.esempioSpring.dto;

import java.io.Serializable;
import java.util.Date;

public class IstruttoriDTO implements Serializable{
	
	private Integer idIstruttore;
//	private AccessiDTO accessi;
	private String usr;
    private String nome;
    private String cf;
    private String cognome;
	
    public IstruttoriDTO() {
		super();
//		this.accessi = new AccessiDTO();
	}
	
	public IstruttoriDTO(Integer idIstruttore, /*AccessiDTO accessi*/String usr, String nome, String cf, String cognome) {
		super();
		this.idIstruttore = idIstruttore;
//		this.accessi = accessi;
		this.usr = usr;
		this.nome = nome;
		this.cf = cf;
		this.cognome = cognome;
	}
	
	public Integer getIdIstruttore() {
		return idIstruttore;
	}
	public void setIdIstruttore(Integer idIstruttore) {
		this.idIstruttore = idIstruttore;
	}
//	public AccessiDTO getAccessi() {
//		return accessi;
//	}
//	public void setAccessi(AccessiDTO accessi) {
//		this.accessi = accessi;
//	}
	
	public String getUsr() {
		return usr;
	}
	public void setUsr(String accessi) {
		this.usr = accessi;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}
