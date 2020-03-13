package com.esis.esempioSpring.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.esis.esempioSpring.entities.Clienti;
import com.esis.esempioSpring.entities.Istruttori;
import com.esis.esempioSpring.entities.TipoAttivita;

public class AttivitaDTO implements Serializable{
	
	private Integer idAttivita;
	private ClientiDTO idCliente;
	private IstruttoriDTO idIstruttore;
//	private Timestamp dataOra;
	private String dataOra;
	private TipoAttivitaDTO idTipoAttivita;
	private Boolean state;
	
	//inzializzazione dei 3 attrributi dato che sono oggetti
	public AttivitaDTO() {
		this.idCliente = new ClientiDTO();
		this.idIstruttore = new IstruttoriDTO();
		this.idTipoAttivita = new TipoAttivitaDTO();
		// TODO Auto-generated constructor stub
	}
	


	public AttivitaDTO(Integer idAttivita, ClientiDTO idCliente, IstruttoriDTO idIstruttore, /*Timestamp dataOra*/String dataOra,
			TipoAttivitaDTO idTipoAttivita) {
		this.idAttivita = idAttivita;
		this.idCliente = idCliente;
		this.idIstruttore = idIstruttore;
		this.dataOra = dataOra;
		this.idTipoAttivita = idTipoAttivita;
	}
	
//	public AttivitaDTO(Integer idAttivita, Clienti idCliente, Istruttori idIstruttore, Timestamp dataOra,
//			TipoAttivita idTipoAttivita) {
//		this.idAttivita = idAttivita;
//		this.idCliente = idCliente;
//		this.idIstruttore = idIstruttore;
//		this.dataOra = dataOra;
//		this.idTipoAttivita = idTipoAttivita;
//	}
	
	public Integer getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}
	public ClientiDTO getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(ClientiDTO idCliente) {
		this.idCliente = idCliente;
	}
	public IstruttoriDTO getIdIstruttore() {
		return idIstruttore;
	}
	public void setIdIstruttore(IstruttoriDTO idIstruttore) {
		this.idIstruttore = idIstruttore;
	}
//	public Timestamp getDataOra() {
//		return dataOra;
//	}
//	public void setDataOra(Timestamp dataOra) {
//		this.dataOra = dataOra;
//	}
	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	public TipoAttivitaDTO getIdTipoAttivita() {
		return idTipoAttivita;
	}
	public void setIdTipoAttivita(TipoAttivitaDTO idTipoAttivita) {
		this.idTipoAttivita = idTipoAttivita;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
}
