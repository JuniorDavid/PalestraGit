package com.esis.esempioSpring.dto;

import java.io.Serializable;

public class RuoliDTO implements Serializable{
	
	Integer idRuolo;
	String descrizione;
	
	public RuoliDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RuoliDTO(Integer idRuolo, String descrizione) {
		super();
		this.idRuolo = idRuolo;
		this.descrizione = descrizione;
	}

	public Integer getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	
	

}
