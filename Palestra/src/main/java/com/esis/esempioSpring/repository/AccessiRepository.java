package com.esis.esempioSpring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.esis.esempioSpring.entities.Accessi;

@Repository
public class AccessiRepository {

    @PersistenceContext(name = "")
    protected EntityManager em;

    public void create(Accessi entity) {
        em.persist(entity);
    }

    public void edit(Accessi entity) {
        em.merge(entity);
    }

    public Accessi find(String id) {
        return em.find(Accessi.class, id);
    }

    public void remove(Accessi entity) {
        em.remove(em.merge(entity));
    }

    public List<Accessi> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Accessi.class));
        List<Accessi> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<Accessi> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM Accessi t");
        List<Accessi> risultato = q.getResultList();
        return risultato;
    }

    public List<Accessi> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM Accessi t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<Accessi> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Accessi> rt = cq.from(Accessi.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}

