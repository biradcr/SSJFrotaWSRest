/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ws;

import com.google.gson.Gson;
import br.edu.ifsul.dao.RetiradaDAO;
import br.edu.ifsul.modelo.Retirada;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ubiratan
 */
@Path("Retiradas")
public class SSJFrotaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SSJFrotaWS
     */
    public SSJFrotaWS() {
    }

    /**
     * Retrieves representation of an instance of br.edu.ifsul.ws.SSJFrotaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Meu primeiro WS REST";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Retirada/list")
    public String listRetiradas()
    {
        List<Retirada> lista;
        
        RetiradaDAO dao = new RetiradaDAO();
        lista = dao.listar();
        
        //Converter para Gson
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("Retirada/inserir")
public boolean inserir(String content){
     Gson g = new Gson();
    Retirada u = (Retirada) g.fromJson(content, Retirada.class);
        RetiradaDAO dao = new RetiradaDAO();  
        return dao.inserir(u);
}
    
    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Retirada/alterar")
    public void alterar(String content) {
        Gson g = new Gson();
        Retirada u = (Retirada) g.fromJson(content, Retirada.class);
        RetiradaDAO dao = new RetiradaDAO();  
        dao.atualizar(u);
    }
}
