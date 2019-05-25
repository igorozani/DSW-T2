/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.Teatro;

/**
 *
 * @author clauc
 */
public class TeatroDAO  extends GenericDAO<Teatro> {
 
    @Override
    public Teatro get(Long id) {
        EntityManager em = this.getEntityManager();
        Teatro palpite = em.find(Teatro.class, id);
        em.close();
        return palpite;
    }

    @Override
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select t from Teatro t", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }

    @Override
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getEmail());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
    
    public List<Teatro> getAllPorCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        String s = "select t from Teatro t where t.cidade = :nome";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        q.setParameter("nome", cidade);
        return q.getResultList();
    }
    
}
