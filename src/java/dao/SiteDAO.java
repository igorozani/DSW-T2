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
import pojo.Site;
import pojo.Teatro;

/**
 *
 * @author clauc
 */
public class SiteDAO extends GenericDAO<Site>{
    
    
    @Override
    public Site get(Long id) {
        EntityManager em = this.getEntityManager();
        Site site = em.find(Site.class, id);
        em.close();
        return site;
    }

    @Override
    public List<Site> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select t from Site t", Teatro.class);
        List<Site> sites = q.getResultList();
        em.close();
        return sites;
    }

    @Override
    public void save(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }

    @Override
    public void update(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(Site.class, site.getEmail());
        tx.begin();
        em.remove(site);
        tx.commit();
    }
    
   /* public List<Site> getAllPorCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        String s = "select t from Teatro t where t.cidade = :nome";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        q.setParameter("nome", cidade);
        return q.getResultList();
    } */
    
    
}
