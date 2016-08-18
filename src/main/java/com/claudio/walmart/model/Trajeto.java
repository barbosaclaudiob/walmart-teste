/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author claudio
 */
public class Trajeto {

    private List<String> caminho;
    private Integer distancia;
    private BigDecimal custoDaViagem;

    public List<String> getCaminho() {
        return caminho;
    }

    public void setCaminho(List<String> caminho) {
        this.caminho = caminho;
    }

    public BigDecimal getCustoDaViagem() {
        return custoDaViagem;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
    

    public void setCustoDaViagem(BigDecimal custoDaViagem) {
        this.custoDaViagem = custoDaViagem;
    }

}
