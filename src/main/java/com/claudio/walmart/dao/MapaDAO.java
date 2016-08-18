/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.dao;

import com.claudio.walmart.model.Mapa;
import com.claudio.walmart.model.Rota;
import com.claudio.walmart.utils.EntityManagerFactoryWrapper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author claudio
 */
public class MapaDAO {

    public void salvar(Mapa m) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        em.getTransaction().begin();
        if (m.getCodmapa() != null) {
            em.merge(m);
        } else {
            em.persist(m);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void salvaMapasComRotas(Mapa m) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        em.getTransaction().begin();
        if (m.getCodmapa() != null) {
            em.merge(m);
            for (Rota r : m.getRotas()) {
                em.merge(r);
            }
        } else {
            em.persist(m);
            for (Rota r : m.getRotas()) {
                em.persist(r);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    public Mapa buscaPorId(Long id) {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        Query qry = em.createQuery("from Mapa c where c.codmapa = " + id);
        Mapa m = (Mapa) qry.getSingleResult();
        em.close();
        return m;
    }

    public List<Mapa> findAll() {
        EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
        Query qry = em.createQuery("from Mapa");
        List<Mapa> mapas = qry.getResultList();
        em.close();
        return mapas;
    }

}
