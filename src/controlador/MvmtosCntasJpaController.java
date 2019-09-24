/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entity.MvmtosCntas;
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
public class MvmtosCntasJpaController implements Serializable {

    public MvmtosCntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MvmtosCntasJpaController() {
    }
    
    public void create(MvmtosCntas mvmtosCntas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mvmtosCntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MvmtosCntas mvmtosCntas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mvmtosCntas = em.merge(mvmtosCntas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mvmtosCntas.getIdMvmnto();
                if (findMvmtosCntas(id) == null) {
                    throw new NonexistentEntityException("The mvmtosCntas with id " + id + " no longer exists.");
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
            MvmtosCntas mvmtosCntas;
            try {
                mvmtosCntas = em.getReference(MvmtosCntas.class, id);
                mvmtosCntas.getIdMvmnto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mvmtosCntas with id " + id + " no longer exists.", enfe);
            }
            em.remove(mvmtosCntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MvmtosCntas> findMvmtosCntasEntities() {
        return findMvmtosCntasEntities(true, -1, -1);
    }

    public List<MvmtosCntas> findMvmtosCntasEntities(int maxResults, int firstResult) {
        return findMvmtosCntasEntities(false, maxResults, firstResult);
    }

    private List<MvmtosCntas> findMvmtosCntasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MvmtosCntas.class));
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

    public MvmtosCntas findMvmtosCntas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MvmtosCntas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMvmtosCntasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MvmtosCntas> rt = cq.from(MvmtosCntas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
