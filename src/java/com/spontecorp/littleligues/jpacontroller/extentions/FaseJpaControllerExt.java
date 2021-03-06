package com.spontecorp.littleligues.jpacontroller.extentions;

import com.spontecorp.littleligues.jpacontroller.torneo.FaseJpaController;
import com.spontecorp.littleligues.model.torneo.Fase;
import com.spontecorp.littleligues.model.torneo.Fase_;
import com.spontecorp.littleligues.model.torneo.Temporada;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Casper
 */
public class FaseJpaControllerExt extends FaseJpaController{

    public FaseJpaControllerExt(EntityManagerFactory emf) {
        super(emf);
    }
    
    public List<Fase> findFasesOnTemporada(Temporada temporada){
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Fase> cq = cb.createQuery(Fase.class);
        Root<Fase> fase = cq.from(Fase.class);
        cq.select(fase);
        cq.where(cb.equal(fase.get(Fase_.temporadaId), temporada));
        TypedQuery<Fase> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public List<Fase> findFaseEntitiesOnTemporada(Temporada temporada, int maxResults, int firstResult) {
        return findFaseEntitiesOnTemporada(temporada, false, maxResults, firstResult);
    }

    private List<Fase> findFaseEntitiesOnTemporada(Temporada temporada, boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        List<Fase> fases = new ArrayList<Fase>();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery();
            Root<Fase> fase = cq.from(Fase.class);
            cq.select(fase);
            cq.where(cb.equal(fase.get(Fase_.temporadaId), temporada));
            TypedQuery<Fase> q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            fases = q.getResultList();
        } finally {
            em.close();
            return fases;
        }
    }
    
    public List<Fase> findFaseEntitiesWithGruposOnTemporada(Temporada temporada){
        List<Fase> fases = new ArrayList<Fase>();
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery(
                    "SELECT DISTINCT f FROM Grupo g JOIN g.faseId f WHERE f.temporadaId = :temporada");
            q.setParameter("temporada", temporada);
            fases = q.getResultList();
        } finally {
            em.close();
            return fases;
        }
    }
    
    /**
     * Obtengo la Fase marcada como actual
     * @param temporadaId
     * @return 
     */
    public Fase findCurrentFase(Temporada temporadaId) {
        List<Fase> faseList = new ArrayList();
        EntityManager em = getEntityManager();
        try {
            String query = "SELECT f from Fase f "
                    + "WHERE f.temporadaId = :temporadaId AND f.isCurrent = 1";
            Query q = em.createQuery(query);
            q.setParameter("temporadaId", temporadaId);
            faseList = q.getResultList();
        } finally {
            em.close();
        }
        if(faseList.size() > 0){
            return faseList.get(0);
        }else{
            return null;
        }
    }
}
