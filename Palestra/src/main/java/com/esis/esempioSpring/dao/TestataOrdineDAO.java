/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esis.esempioSpring.dao;

import com.esis.esempioSpring.entities.TestataOrdine;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author silvano
 */
@Repository
public class TestataOrdineDAO {

    @PersistenceContext(name = "")
    protected EntityManager em;

    public void create(TestataOrdine entity) {
        em.persist(entity);
    }

    public void edit(TestataOrdine entity) {
        em.merge(entity);
    }

    public TestataOrdine find(Integer id) {
        return em.find(TestataOrdine.class, id);
    }

    public void remove(TestataOrdine entity) {
        em.remove(em.merge(entity));
    }

    public List<TestataOrdine> findAllByCriteria() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TestataOrdine.class));
        List<TestataOrdine> risultato = em.createQuery(cq).getResultList();
        return risultato;
    }

    public List<TestataOrdine> findAllBySelect() {
        Query q = em.createQuery("SELECT t FROM TestataOrdine t");
        List<TestataOrdine> risultato = q.getResultList();
        return risultato;
    }

    public List<TestataOrdine> findRangeBySelect(int first_result, int max_results) {
        
        System.out.println("Sil - findRangeBySelect first_result = "+first_result);
        
        System.out.println("Sil - findRangeBySelect em = "+em);
        
        Query q = em.createQuery("SELECT t FROM TestataOrdine t");
        if (first_result >= 0) {
            q.setFirstResult(first_result);
        }
        if (max_results >= 0) {
            q.setMaxResults(max_results);
        }
        List<TestataOrdine> risultato = q.getResultList();
        return risultato;
    }

    public Integer count() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<TestataOrdine> rt = cq.from(TestataOrdine.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
