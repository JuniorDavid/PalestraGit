package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the istruttori database table.
 * 
 */
@Entity
@NamedQuery(name="Istruttori.findAll", query="SELECT i FROM Istruttori i")
public class Istruttori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_istruttore")
	private Integer idIstruttore;

	private String cf;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Attivita
	@OneToMany(mappedBy="istruttori")
	private List<Attivita> attivitas;

	//bi-directional many-to-one association to Accessi
	@ManyToOne
	@JoinColumn(name="usr")
	private Accessi accessi;

	public Istruttori() {
	}

	public Integer getIdIstruttore() {
		return this.idIstruttore;
	}

	public void setIdIstruttore(Integer idIstruttore) {
		this.idIstruttore = idIstruttore;
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
		attivita.setIstruttori(this);

		return attivita;
	}

	public Attivita removeAttivita(Attivita attivita) {
		getAttivitas().remove(attivita);
		attivita.setIstruttori(null);

		return attivita;
	}

	public Accessi getAccessi() {
		return this.accessi;
	}

	public void setAccessi(Accessi accessi) {
		this.accessi = accessi;
	}

}