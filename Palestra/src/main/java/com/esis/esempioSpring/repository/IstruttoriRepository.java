package com.esis.esempioSpring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.Istruttori;


@Repository
public class IstruttoriRepository {
	@PersistenceContext(name = "")
    protected EntityManager em;

    public void create(Istruttori entity) {
        em.persist(entity);
    }

    public void edit(Istruttori entity) {
        em.merge(entity);
    }

    public Istruttori find(Integer id) {
        return em.find(Istruttori.class, id);
    }

    public void remove(Istruttori entity) {
        em.remove(em.merge(entity));
    }

    public List<Istruttori> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Istruttori.class));
        List<Istruttori> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<Istruttori> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM Istruttori t");
        List<Istruttori> risultato = q.getResultList();
        return risultato;
    }

    public List<Istruttori> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM Istruttori t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<Istruttori> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Istruttori> rt = cq.from(Istruttori.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
