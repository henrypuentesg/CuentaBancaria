/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entity.Bncos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author henry
 */
public class BncosJpaController implements Serializable {

    public BncosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BncosJpaController() {
    }
    
    

    public void create(Bncos bncos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bncos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bncos bncos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bncos = em.merge(bncos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = bncos.getIdBnco();
                if (findBncos(id) == null) {
                    throw new NonexistentEntityException("The bncos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bncos bncos;
            try {
                bncos = em.getReference(Bncos.class, id);
                bncos.getIdBnco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bncos with id " + id + " no longer exists.", enfe);
            }
            em.remove(bncos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bncos> findBncosEntities() {
        return findBncosEntities(true, -1, -1);
    }

    public List<Bncos> findBncosEntities(int maxResults, int firstResult) {
        return findBncosEntities(false, maxResults, firstResult);
    }

    private List<Bncos> findBncosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bncos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Bncos findBncos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bncos.class, id);
        } finally {
            em.close();
        }
    }

    public int getBncosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bncos> rt = cq.from(Bncos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
