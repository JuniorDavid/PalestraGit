package com.esis.esempioSpring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accessi database table.
 * 
 */
@Entity
@NamedQuery(name="Accessi.findAll", query="SELECT a FROM Accessi a")
public class Accessi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String usr;

	private String pswd;

	//bi-directional many-to-one association to Clienti
	@OneToMany(mappedBy="accessi")
	private List<Clienti> clientis;

	//bi-directional many-to-one association to Istruttori
	@OneToMany(mappedBy="accessi")
	private List<Istruttori> istruttoris;

	//bi-directional many-to-many association to Ruoli
	@ManyToMany(mappedBy="accessis")
	private List<Ruoli> ruolis;

	public Accessi() {
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<Clienti> getClientis() {
		return this.clientis;
	}

	public void setClientis(List<Clienti> clientis) {
		this.clientis = clientis;
	}

	public Clienti addClienti(Clienti clienti) {
		getClientis().add(clienti);
		clienti.setAccessi(this);

		return clienti;
	}

	public Clienti removeClienti(Clienti clienti) {
		getClientis().remove(clienti);
		clienti.setAccessi(null);

		return clienti;
	}

	public List<Istruttori> getIstruttoris() {
		return this.istruttoris;
	}

	public void setIstruttoris(List<Istruttori> istruttoris) {
		this.istruttoris = istruttoris;
	}

	public Istruttori addIstruttori(Istruttori istruttori) {
		getIstruttoris().add(istruttori);
		istruttori.setAccessi(this);

		return istruttori;
	}

	public Istruttori removeIstruttori(Istruttori istruttori) {
		getIstruttoris().remove(istruttori);
		istruttori.setAccessi(null);

		return istruttori;
	}

	public List<Ruoli> getRuolis() {
		return this.ruolis;
	}

	public void setRuolis(List<Ruoli> ruolis) {
		this.ruolis = ruolis;
	}

}