package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the attivita database table.
 * 
 */
@Entity
@NamedQuery(name="Attivita.findAll", query="SELECT a FROM Attivita a")
public class Attivita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_attivita")
	private Integer idAttivita;

	@Column(name="data_ora")
	private Timestamp dataOra;
//	private String dataOra;

	//bi-directional many-to-one association to Clienti
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clienti clienti;

	//bi-directional many-to-one association to Istruttori
	@ManyToOne
	@JoinColumn(name="id_istruttore")
	private Istruttori istruttori;

	//bi-directional many-to-one association to TipoAttivita
	@ManyToOne
	@JoinColumn(name="id_tipo_attivita")
	private TipoAttivita tipoAttivita;
	
	@Column(name="state")
	private Boolean state;

	public Attivita() {
		this.clienti = new Clienti();
		this.istruttori = new Istruttori();
		this.tipoAttivita = new TipoAttivita();
	}

	public Integer getIdAttivita() {
		return this.idAttivita;
	}

	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}

	public Timestamp getDataOra() {
		return this.dataOra;
	}
//	public String getDataOra() {
//		return this.dataOra;
//	}

	public void setDataOra(Timestamp dataOra) {
		this.dataOra = dataOra;
	}
//	public void setDataOra(String dataOra) {
//		this.dataOra = dataOra;
//	}

	public Clienti getClienti() {
		return this.clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public Istruttori getIstruttori() {
		return this.istruttori;
	}

	public void setIstruttori(Istruttori istruttori) {
		this.istruttori = istruttori;
	}

	public TipoAttivita getTipoAttivita() {
		return this.tipoAttivita;
	}

	public void setTipoAttivita(TipoAttivita tipoAttivita) {
		this.tipoAttivita = tipoAttivita;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
}