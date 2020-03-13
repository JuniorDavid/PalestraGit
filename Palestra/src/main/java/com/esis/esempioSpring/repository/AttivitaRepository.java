package com.esis.esempioSpring.repository;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.Attivita;

@Repository
public class AttivitaRepository {

	@PersistenceContext(name = "")
	protected EntityManager em;

	public void create(Attivita entity) {
		em.persist(entity);
	}

	public void edit(Attivita entity) {
		em.merge(entity);
	}

	public Attivita find(Integer id) {
		return em.find(Attivita.class, id);
	}

	public void remove(Attivita entity) {
		em.remove(em.merge(entity));
	}

	public List<Attivita> findAllByCriteria() {
		javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(Attivita.class));
		List<Attivita> risultato = em.createQuery(cq).getResultList();
		return risultato;
	}

	public List<Attivita> findAllBySelect() {
		Query q = em.createQuery("SELECT t FROM Attivita t");
		List<Attivita> risultato = q.getResultList();
		return risultato;
	}

	//////////////// CREATA DA NOI/////////////////
	public List<Attivita> findAllBySelectAttivi() {
		Query q = em.createQuery("SELECT t FROM Attivita t WHERE t.state = 'false'");
		List<Attivita> risultato = q.getResultList();
		return risultato;
	}

	public List<Attivita> findByIstruttore(Integer id) {
		Query q = em.createQuery("SELECT t FROM Attivita t");
		List<Attivita> risultato = q.getResultList();
		for (int i = 0, dim = risultato.size(); i < dim; i++) {
			if (risultato.get(i).getIstruttori().getIdIstruttore() != id) {
				risultato.remove(i);
				i--;
				dim--;
			}
		}
		return risultato;
	}

	public List<Attivita> findByCognomeIstruttore(String cognome) {
		Query q = em.createQuery("SELECT a FROM Attivita a");
		List<Attivita> risultato = q.getResultList();
		List<Attivita> attivita = new ArrayList<>();
		for (Attivita ris : risultato) {
			if (ris.getIstruttori().getCognome().equals(cognome)) {
				attivita.add(ris);
			}
		}
		return attivita;
	}

	public List<Attivita> findByCognomeIstruttoreQuery(String cognome) {
		Query q = em.createQuery("SELECT a FROM Attivita a where a.istruttori.cognome = :ciccio");
		q.setParameter("ciccio", cognome);

		List<Attivita> risultato = q.getResultList();

//        
//        List<Attivita> attivita = new ArrayList<>();
//        for (Attivita ris : risultato) {
//        	if (ris.getIstruttori().getCognome().equals(cognome)) {
//        		attivita.add(ris);
//        	}
//        }

		return risultato;
	}

	public Timestamp convertStringToTimestamp(String strDate) throws java.text.ParseException {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// you can change format of date
			Date date = formatter.parse(strDate);
			Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;

		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

	public List<Attivita> findIstruttoreDate(Integer idIstruttore, String from, String to)
			throws java.text.ParseException {
		System.out.println("\nATTIVITA REPOSITORY ");
		// Query q = em.createQuery("SELECT a FROM Attivita a where
		// a.istruttori.idIstruttore = :idParam");
		// System.out.print("id: "+idIstruttore);
		// q.setParameter("idParam", idIstruttore);
		System.out.println("punto di controllo 1");

		Timestamp data_timestampfrom = convertStringToTimestamp(from);
		Timestamp data_timestampto = convertStringToTimestamp(to);
		System.out.println("punto di controllo 2");
		Query q = em.createQuery(
				"SELECT a FROM Attivita a where a.istruttori.idIstruttore = :idIstruttore and a.dataOra > :from and a.dataOra < :to");
		q.setParameter("from", data_timestampfrom);
		q.setParameter("to", data_timestampto);
		q.setParameter("idIstruttore", idIstruttore);
		System.out.println("punto di controllo 3");

		List<Attivita> risultato = q.getResultList();
		System.out.print("\nAbbiamo finito Repository");
		return risultato;
	}

	//////////////// default//////////////////

	public List<Attivita> findRangeBySelect(int first_result, int max_results) {

		System.out.println("Sil - findRangeBySelect first_result = " + first_result);

		System.out.println("Sil - findRangeBySelect em = " + em);

		Query q = em.createQuery("SELECT a FROM Attivita a");
		if (first_result >= 0) {
			q.setFirstResult(first_result);
		}
		if (max_results >= 0) {
			q.setMaxResults(max_results);
		}
		List<Attivita> risultato = q.getResultList();
		return risultato;
	}

	public List<Attivita> findRange(Timestamp first_result, Timestamp max_results, int id) {

		System.out.println("Sil - findRangeBySelect first_result = " + first_result);

		System.out.println("Sil - findRangeBySelect em = " + em);

		Query q = em.createQuery("SELECT a FROM Attivita a WHERE ((a.dataOra between first_result and max_results) "
				+ "AND a.idIstruttore = id) ");

		List<Attivita> risultato = q.getResultList();
		return risultato;
	}

	public Integer count() {
		javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<Attivita> rt = cq.from(Attivita.class);
		cq.select(em.getCriteriaBuilder().count(rt));
		javax.persistence.Query q = em.createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

}
