/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import entity.Cntas;
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
public class CntasJpaController implements Serializable {

    public CntasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CajeroAutomaticoPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CntasJpaController() {
    }
    

    public void create(Cntas cntas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cntas cntas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            int id = cntas.getIdCnta();
            if (findCntas(id) == null) {
                throw new NonexistentEntityException("The cntas with id " + id + " no longer exists.");
            } else {
                cntas = em.merge(cntas);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
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
            Cntas cntas;
            try {
                cntas = em.getReference(Cntas.class, id);
                cntas.getIdCnta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cntas with id " + id + " no longer exists.", enfe);
            }
            em.remove(cntas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cntas> findCntasEntities() {
        return findCntasEntities(true, -1, -1);
    }

    public List<Cntas> findCntasEntities(int maxResults, int firstResult) {
        return findCntasEntities(false, maxResults, firstResult);
    }

    private List<Cntas> findCntasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cntas.class));
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

    public Cntas findCntas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cntas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCntasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cntas> rt = cq.from(Cntas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
