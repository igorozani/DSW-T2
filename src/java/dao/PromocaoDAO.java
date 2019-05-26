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
import pojo.Promocao;
import pojo.Teatro;

/**
 *
 * @author clauc
 */
public class PromocaoDAO extends GenericDAO<Promocao> {
    
    
    @Override
    public Promocao get(int id) {
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.find(Promocao.class, id);
        em.close();
        return promocao;
    }

    @Override
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select t from Promocao t", Teatro.class);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes;
    }

    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
       /* EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getEmail());
        tx.begin();
        em.remove(teatro);
        tx.commit();*/
       
        /*String s = "delete t ftom Teatro t where t,email = :nome";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        q.setParameter("nome", email); */
        
    }
    
    public List<Promocao> getAllPorTeatro(String teatro) {
        EntityManager em = this.getEntityManager();
        String s = "select t from Promocao t where t.teatro = :nome";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("nome", teatro);
        return q.getResultList();
    }
    
}
