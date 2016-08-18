/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.utils;

import com.claudio.walmart.model.Rota;

/**
 *
 * @author claudio
 */
public class RotaDeAntes {

    private Rota rota;
    private Integer distancia;

    public RotaDeAntes(Rota rota, Integer distancia) {
        this.rota = rota;
        this.distancia = distancia;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
