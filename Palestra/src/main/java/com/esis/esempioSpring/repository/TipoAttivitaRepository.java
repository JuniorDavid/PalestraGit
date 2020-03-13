package com.esis.esempioSpring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.TipoAttivita;

@Repository
public class TipoAttivitaRepository {
	@PersistenceContext(name = "")
    protected EntityManager em;

    public void create(TipoAttivita entity) {
        em.persist(entity);
    }

    public void edit(TipoAttivita entity) {
        em.merge(entity);
    }

    public TipoAttivita find(Integer id) {
        return em.find(TipoAttivita.class, id);
    }

    public void remove(TipoAttivita entity) {
        em.remove(em.merge(entity));
    }

    public List<TipoAttivita> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TipoAttivita.class));
        List<TipoAttivita> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<TipoAttivita> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM TipoAttivita t");
        List<TipoAttivita> risultato = q.getResultList();
        return risultato;
    }

    public List<TipoAttivita> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM TipoAttivita t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<TipoAttivita> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<TipoAttivita> rt = cq.from(TipoAttivita.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
