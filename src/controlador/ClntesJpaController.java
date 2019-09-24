/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entity.Clntes;
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
public class ClntesJpaController implements Serializable {

    public ClntesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ClntesJpaController() {
    }

    public void create(Clntes clntes) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(clntes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clntes clntes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clntes = em.merge(clntes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = clntes.getIdClnte();
                if (findClntes(id) == null) {
                    throw new NonexistentEntityException("The clntes with id " + id + " no longer exists.");
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
            Clntes clntes;
            try {
                clntes = em.getReference(Clntes.class, id);
                clntes.getIdClnte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clntes with id " + id + " no longer exists.", enfe);
            }
            em.remove(clntes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clntes> findClntesEntities() {
        return findClntesEntities(true, -1, -1);
    }

    public List<Clntes> findClntesEntities(int maxResults, int firstResult) {
        return findClntesEntities(false, maxResults, firstResult);
    }

    private List<Clntes> findClntesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clntes.class));
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

    public Clntes findClntes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clntes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClntesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clntes> rt = cq.from(Clntes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
