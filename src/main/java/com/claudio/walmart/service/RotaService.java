/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.service;

import com.claudio.walmart.model.Rota;
import com.claudio.walmart.utils.RotaDeAntes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author claudio
 * 
 */

public class RotaService {

    private final String pontoDeOrigem;
    private final String pontoDedestino;
    private final Set<Rota> rotas;
    private final Set<String> pontoVisitado;
    private final Queue<Rota> pontosParaVisitar;
    private final Map<String, RotaDeAntes> menorDistanciaDaRota;
    
    public RotaService(Set<Rota> rotas, String origem, String destino) {
        this.rotas = rotas;
        this.pontoDeOrigem = origem;
        this.pontoDedestino = destino;
        this.pontoVisitado = new HashSet<String>();
        this.menorDistanciaDaRota = new HashMap<String, RotaDeAntes>();
        this.pontosParaVisitar = new LinkedList<Rota>();
        
        if (origem.isEmpty() || destino.isEmpty()) {
            throw new IllegalArgumentException("Favor informar a origem e destino da Rota");
        }
        if (rotas == null || rotas.isEmpty()) {
            throw new IllegalArgumentException("Não há rotas cadastradas no sistema!");
        }

    }


    private void menorDistancia(Rota rota) {
        String origemRota = rota.getOrigem();
        String destinoRota = rota.getDestino();
        RotaDeAntes menorDistanciaOrigem = menorDistanciaDaRota.get(origemRota);
        RotaDeAntes menorDistanciaDestino = menorDistanciaDaRota.get(destinoRota);
        Integer distanciaTotal = rota.getDistancia() + menorDistanciaOrigem.getDistancia();
        if (distanciaTotal < menorDistanciaDestino.getDistancia()) {
            menorDistanciaDestino.setRota(rota);
            menorDistanciaDestino.setDistancia(distanciaTotal);
        }

    }

    public List<Rota> obtemMenorRota() {
        proximasRotasAVisitar(pontoDeOrigem);
        verificaMenorDistancia();
        while (!pontosParaVisitar.isEmpty()) {
            Rota rota = pontosParaVisitar.poll();
            String destinoRota = rota.getDestino();
            pontoVisitado.add(rota.getOrigem());
            if (!pontoVisitado.contains(destinoRota)) {
                proximasRotasAVisitar(destinoRota);
            }
            menorDistancia(rota);
        }
        List<Rota> menorRota = new ArrayList<Rota>();
        RotaDeAntes pontoAnteriorDistancia = menorDistanciaDaRota.get(pontoDedestino);
        do {
            menorRota.add(pontoAnteriorDistancia.getRota());
            pontoAnteriorDistancia = menorDistanciaDaRota.get(pontoAnteriorDistancia.getRota().getOrigem());
        } while (pontoAnteriorDistancia.getRota() != null);
        Collections.reverse(menorRota);
        return menorRota;
    }
    

    private void verificaMenorDistancia() {
        for (Rota rota : rotas) {
            if (rota.getOrigem().equals(pontoDeOrigem)) {
                menorDistanciaDaRota.put(pontoDeOrigem, new RotaDeAntes(null, 0));
                menorDistanciaDaRota.put(rota.getDestino(), new RotaDeAntes(null, Integer.MAX_VALUE));
            } else {
                menorDistanciaDaRota.put(rota.getDestino(), new RotaDeAntes(null, Integer.MAX_VALUE));
            }
        }
    }

    private void proximasRotasAVisitar(String destinoOrigem) {
        for (Rota rota : rotas) {
            if (rota.getOrigem().equals(destinoOrigem)) {
                pontosParaVisitar.add(rota);
            }
        }
    }
}
