package com.esis.esempioSpring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.Ruoli;

@Repository
public class RuoliRepository {
	
	@PersistenceContext(name = "")
    protected EntityManager em;

    public void create(Ruoli entity) {
        em.persist(entity);
    }

    public void edit(Ruoli entity) {
        em.merge(entity);
    }

    public Ruoli find(Integer id) {
        return em.find(Ruoli.class, id);
    }

    public void remove(Ruoli entity) {
        em.remove(em.merge(entity));
    }

    public List<Ruoli> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Ruoli.class));
        List<Ruoli> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<Ruoli> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM Ruoli t");
        List<Ruoli> risultato = q.getResultList();
        return risultato;
    }

    public List<Ruoli> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM Ruoli t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<Ruoli> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Ruoli> rt = cq.from(Ruoli.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
