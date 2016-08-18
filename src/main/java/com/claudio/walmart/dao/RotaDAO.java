/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.dao;

import com.claudio.walmart.model.Rota;
import com.claudio.walmart.utils.EntityManagerFactoryWrapper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author claudio
 */
public class RotaDAO {

    public void salvar(Rota r) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        em.getTransaction().begin();
        if (r.getCodrota() != null) {
            em.merge(r);
        } else {
            em.persist(r);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Rota buscaPorId(Long id) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        Query qry = em.createQuery("from Cliente c where c.codcli = " + id);
        Rota r = (Rota) qry.getSingleResult();
        em.close();
        return r;
    }
    
    public List<Rota> buscaPorOrigem(String origem) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        Query qry = em.createQuery("from Rota c where c.origem = '" + origem+"'");
        List<Rota> rotas = qry.getResultList();
        em.close();
        return rotas;
    }

    public List<Rota> findAll() {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        Query qry = em.createQuery("from Rota");
        List<Rota> rotas = qry.getResultList();
        em.close();
        return rotas;
    }

}
