/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author claudio
 */
@Entity
@Table(name = "mapa")
@XmlRootElement
public class Mapa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codmapa;
    
    private String nomeDoMapa;

    @OneToMany(mappedBy = "codmapa")
    private Set<Rota> rotas;

    public Mapa() {
    }
    
    public Mapa(String nomeDoMapa) {
        this.nomeDoMapa = nomeDoMapa;
    }
    
    public Long getCodmapa() {
        return codmapa;
    }

    public void setCodmapa(Long codmapa) {
        this.codmapa = codmapa;
    }

    public String getNomeDoMapa() {
        return nomeDoMapa;
    }

    public void setNomeDoMapa(String nomeDoMapa) {
        this.nomeDoMapa = nomeDoMapa;
    }

    public Set<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(Set<Rota> rotas) {
        this.rotas = rotas;
    }
    


}
