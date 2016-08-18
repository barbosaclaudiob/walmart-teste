package com.claudio.walmart.restful;

import com.claudio.walmart.model.Mapa;
import com.claudio.walmart.model.Rota;
import com.claudio.walmart.model.Trajeto;
import com.claudio.walmart.service.MapaService;
import com.claudio.walmart.service.TrajetoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author claudio
 */
@Path("/")
public class TrajetoRest {

    @GET
    @Path("{origem}/{destino}/{autonomia}/{valorDoLitro}")
    @Produces(MediaType.APPLICATION_JSON)
    public String solicitaMelhorRotaEConsumo(
            @PathParam("origem") String origem,
            @PathParam("destino") String destino,
            @PathParam("autonomia") String autonomia,
            @PathParam("valorDoLitro") String valorDoLitro) {
        MapaService ms = new MapaService();
        ms.verificaMapaInicial();

        Trajeto trajeto = new TrajetoService().preencheObjetoTrajeto(origem, destino, autonomia, valorDoLitro);;
        StringBuilder sb = new StringBuilder();
        sb.append("Rota ");
        for (String s : trajeto.getCaminho()) {
            sb.append(s.toUpperCase() + " ");
        }
        sb.append("com custo de " + trajeto.getCustoDaViagem().toString().replace(".", ","));
        return sb.toString();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String sayPlainTextHello(String inputJsonObj) throws Exception {
        MapaService ms = new MapaService();
        ms.salvaMapaJson(inputJsonObj);

        return null;
    }

}
