package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@NamedQuery(name="Clienti.findAll", query="SELECT c FROM Clienti c")
public class Clienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private Integer idCliente;

	private String cf;

	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name="fine_abbonamento")
	private Date fineAbbonamento;

	private String nome;

	//bi-directional many-to-one association to Attivita
	@OneToMany(mappedBy="clienti")
	private List<Attivita> attivitas;

	//bi-directional many-to-one association to Accessi
	@ManyToOne
	@JoinColumn(name="usr")
	private Accessi accessi;

	public Clienti() {
		this.accessi = new Accessi();
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCf() {
		return this.cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getFineAbbonamento() {
		return this.fineAbbonamento;
	}

	public void setFineAbbonamento(Date fineAbbonamento) {
		this.fineAbbonamento = fineAbbonamento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Attivita> getAttivitas() {
		return this.attivitas;
	}

	public void setAttivitas(List<Attivita> attivitas) {
		this.attivitas = attivitas;
	}

	public Attivita addAttivita(Attivita attivita) {
		getAttivitas().add(attivita);
		attivita.setClienti(this);

		return attivita;
	}

	public Attivita removeAttivita(Attivita attivita) {
		getAttivitas().remove(attivita);
		attivita.setClienti(null);

		return attivita;
	}

	public Accessi getAccessi() {
		return this.accessi;
	}

	public void setAccessi(Accessi accessi) {
		this.accessi = accessi;
	}

}