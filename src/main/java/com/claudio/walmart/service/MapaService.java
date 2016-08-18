/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claudio.walmart.service;

import com.claudio.walmart.dao.MapaDAO;
import com.claudio.walmart.dao.RotaDAO;
import com.claudio.walmart.model.Mapa;
import com.claudio.walmart.model.Rota;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jersey.repackaged.com.google.common.collect.Sets;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author claudio
 */
public class MapaService {

    public void verificaMapaInicial() {
        if (!mapaFoiCriadoNoBanco()) {
            criaMapaInicial(mapaInicial());
        }
    }

    public void criaMapaInicial(Mapa m) {
        List<Rota> rotas = new ArrayList<>();
        rotas.addAll(m.getRotas());
        m.getRotas().removeAll(rotas);
        new MapaDAO().salvar(m);
        for (Rota r : rotas) {
            new RotaDAO().salvar(r);
        }
    }

    public Mapa mapaInicial() {
        Mapa mapa = new Mapa("SP");
        Set<Rota> rotas = new HashSet<>();
        rotas.add(new Rota("A", "B", 10, mapa));
        rotas.add(new Rota("B", "D", 15, mapa));
        rotas.add(new Rota("A", "C", 20, mapa));
        rotas.add(new Rota("C", "D", 30, mapa));
        rotas.add(new Rota("B", "E", 50, mapa));
        rotas.add(new Rota("D", "E", 30, mapa));
        mapa.setRotas(rotas);
        return mapa;
    }

    public boolean mapaFoiCriadoNoBanco() {
        return !new MapaDAO().findAll().isEmpty();
    }

    public void salvaMapaJson(String inputJsonObj) {
        JSONObject json = new JSONObject(inputJsonObj);
        Mapa map = new Mapa();
        map.setNomeDoMapa(json.get("nome").toString());
        JSONArray list = json.getJSONArray("rotas");
        Set<Rota> rotas = new HashSet<>();
        for (int i = 0; i < list.length(); i++) {
            JSONObject jsonRota = (JSONObject) list.get(i);
            rotas.add(new Rota(jsonRota.getString("origem"), jsonRota.getString("destino"), jsonRota.getInt("distancia"), map));
        }
        map.setRotas(rotas);
        new MapaDAO().salvaMapasComRotas(map);
    }

}
