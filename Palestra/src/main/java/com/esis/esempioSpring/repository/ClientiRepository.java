package com.esis.esempioSpring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.Clienti;

@Repository
public class ClientiRepository {
	
	@PersistenceContext(name = "")
    protected EntityManager em;

    public void create(Clienti entity) {
        em.persist(entity);
    }

    public void edit(Clienti entity) {
        em.merge(entity);
    }

    public Clienti find(Integer id) {
        return em.find(Clienti.class, id);
    }

    public void remove(Clienti entity) {
        em.remove(em.merge(entity));
    }

    public List<Clienti> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Clienti.class));
        List<Clienti> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<Clienti> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM Clienti t");
        List<Clienti> risultato = q.getResultList();
        return risultato;
    }

    public List<Clienti> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM Clienti t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<Clienti> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Clienti> rt = cq.from(Clienti.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}



