package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_attivita database table.
 * 
 */
@Entity
@Table(name="tipo_attivita")
@NamedQuery(name="TipoAttivita.findAll", query="SELECT t FROM TipoAttivita t")
public class TipoAttivita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_attivita")
	private Integer idTipoAttivita;

	private String descr;

	//bi-directional many-to-one association to Attivita
	@OneToMany(mappedBy="tipoAttivita")
	private List<Attivita> attivitas;

	public TipoAttivita() {
	}

	public Integer getIdTipoAttivita() {
		return this.idTipoAttivita;
	}

	public void setIdTipoAttivita(Integer idTipoAttivita) {
		this.idTipoAttivita = idTipoAttivita;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public List<Attivita> getAttivitas() {
		return this.attivitas;
	}

	public void setAttivitas(List<Attivita> attivitas) {
		this.attivitas = attivitas;
	}

	public Attivita addAttivita(Attivita attivita) {
		getAttivitas().add(attivita);
		attivita.setTipoAttivita(this);

		return attivita;
	}

	public Attivita removeAttivita(Attivita attivita) {
		getAttivitas().remove(attivita);
		attivita.setTipoAttivita(null);

		return attivita;
	}

}