/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author claudio
 */
@Entity
@Table(name = "rota")
@XmlRootElement
public class Rota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codrota;
    
    private String origem;
    private String destino;
    
    private Integer distancia;

    @ManyToOne
    @JoinColumn(name = "codmapa", referencedColumnName = "codmapa")
    private Mapa codmapa;

    public Rota() {
    }

    public Rota(String origem, String destino, Integer distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Rota(String origem, String destino, Integer distancia, Mapa codmapa) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.codmapa = codmapa;
    }

    public Long getCodrota() {
        return codrota;
    }

    public void setCodrota(Long codrota) {
        this.codrota = codrota;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Mapa getCodmapa() {
        return codmapa;
    }

    public void setCodmapa(Mapa codmapa) {
        this.codmapa = codmapa;
    }

}
