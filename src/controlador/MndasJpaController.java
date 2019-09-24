/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entity.Mndas;
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
public class MndasJpaController implements Serializable {

    public MndasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MndasJpaController() {
    }
    
    

    public void create(Mndas mndas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mndas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mndas mndas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mndas = em.merge(mndas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mndas.getIdMnda();
                if (findMndas(id) == null) {
                    throw new NonexistentEntityException("The mndas with id " + id + " no longer exists.");
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
            Mndas mndas;
            try {
                mndas = em.getReference(Mndas.class, id);
                mndas.getIdMnda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mndas with id " + id + " no longer exists.", enfe);
            }
            em.remove(mndas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mndas> findMndasEntities() {
        return findMndasEntities(true, -1, -1);
    }

    public List<Mndas> findMndasEntities(int maxResults, int firstResult) {
        return findMndasEntities(false, maxResults, firstResult);
    }

    private List<Mndas> findMndasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mndas.class));
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

    public Mndas findMndas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mndas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMndasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mndas> rt = cq.from(Mndas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
