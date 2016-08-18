/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.service;

import com.claudio.walmart.dao.RotaDAO;
import com.claudio.walmart.model.Rota;
import com.claudio.walmart.model.Trajeto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import jersey.repackaged.com.google.common.collect.Sets;

/**
 *
 * @author claudio
 */
public class TrajetoService {

    public List<Rota> calculaAMenorRota(String origem, String destino) {
        return new RotaService(Sets.newHashSet(new RotaDAO().findAll()), origem, destino).obtemMenorRota();
    }

    public Trajeto preencheObjetoTrajeto(String origem, String destino, String autonomia, String valorDoLitro) {
        List<Rota> menorRota = calculaAMenorRota(origem, destino);
        Trajeto trajeto = new Trajeto();
        Integer distancia = 0;
        for (int i = 0; i < menorRota.size(); i++) {
            if (i == 0) {
                trajeto.setCaminho(new ArrayList<>());
                trajeto.getCaminho().add(menorRota.get(i).getOrigem());
                trajeto.getCaminho().add(menorRota.get(i).getDestino());
            } else {
                trajeto.getCaminho().add(menorRota.get(i).getDestino());
            }
            distancia += (menorRota.get(i).getDistancia());
        }
        trajeto.setDistancia(distancia);
        trajeto.setCustoDaViagem(calculaCustoDaViagem(distancia, autonomia, valorDoLitro));

        return trajeto;

    }

    private BigDecimal calculaCustoDaViagem(Integer distancia, String autonomia, String valorDoLitro) {
        BigDecimal valorLitro = new BigDecimal(valorDoLitro.replaceAll(",", "."));
        BigDecimal autonomiaPorLitro = new BigDecimal(autonomia);
        BigDecimal dist = new BigDecimal(distancia.toString());
        return dist.divide(autonomiaPorLitro).multiply(valorLitro).setScale(2);
    }

}
