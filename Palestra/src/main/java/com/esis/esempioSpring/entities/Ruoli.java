package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruoli database table.
 * 
 */
@Entity
@NamedQuery(name="Ruoli.findAll", query="SELECT r FROM Ruoli r")
public class Ruoli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruolo")
	private Integer idRuolo;

	private String descrizione;

	//bi-directional many-to-many association to Accessi
	@ManyToMany
	@JoinTable(
		name="user_ruoli"
		, joinColumns={
			@JoinColumn(name="id_ruolo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="usr")
			}
		)
	private List<Accessi> accessis;

	public Ruoli() {
	}

	public Integer getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Accessi> getAccessis() {
		return this.accessis;
	}

	public void setAccessis(List<Accessi> accessis) {
		this.accessis = accessis;
	}

}