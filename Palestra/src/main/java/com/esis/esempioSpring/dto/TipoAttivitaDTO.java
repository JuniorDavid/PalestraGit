package com.esis.esempioSpring.dto;

import java.io.Serializable;

public class TipoAttivitaDTO implements Serializable{
	
	private Integer idTipoAttivita;
	private String descr;
	
	public TipoAttivitaDTO(Integer idTipoAttivita, String descr) {
		super();
		this.idTipoAttivita = idTipoAttivita;
		this.descr = descr;
	}

	public TipoAttivitaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoAttivita() {
		return idTipoAttivita;
	}

	public void setIdTipoAttivita(Integer idTipoAttivita) {
		this.idTipoAttivita = idTipoAttivita;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
}
