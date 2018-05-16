/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ws;

import com.google.gson.Gson;
import br.edu.ifsul.dao.RetiradaDAO;
import br.edu.ifsul.dao.VeiculoDAO;
import br.edu.ifsul.modelo.Retirada;
import br.edu.ifsul.modelo.Veiculo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ubiratan
 */
@Stateless
@Path("retiradas")
public class SSJFrotaWS implements Serializable{

    @Context
    private UriInfo context;
    private Gson gson = new Gson();

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
    @Path("list")
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
    @Path("inserir")
public boolean inserir(Retirada retirada){
//     Gson g = new Gson();
//    Retirada u = (Retirada) g.fromJson(content, Retirada.class);
        RetiradaDAO dao = new RetiradaDAO();  
        return dao.inserir(retirada);
}
    
    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("alterar")
    public void alterar(String content) {
        Gson g = new Gson();
        Retirada u = (Retirada) g.fromJson(content, Retirada.class);
        RetiradaDAO dao = new RetiradaDAO();  
        dao.atualizar(u);
    }
    
    /**
     * PUT method for updating or creating an instance of FazendaWS
     * @param placa representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("teste/{placa}")
    public Retirada teste(@PathParam("placa") String placa) {
        RetiradaDAO dao = new RetiradaDAO();
        Retirada retirada = dao.getLastRetiradaByPlaca(placa);
        return retirada;
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("buscaVeiculo/{codigo}")
    public Response teste(@PathParam("codigo") Integer codigo) {
        RetiradaDAO dao = new RetiradaDAO();
        Veiculo veiculo = dao.getVeiculo(codigo);
        return Response.ok(gson.toJson(veiculo)).build();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("buscaRetirada/{codigo}")
    public Response buscaRetirada(@PathParam("codigo") Integer codigo) {
        RetiradaDAO dao = new RetiradaDAO();
        Retirada ret = dao.buscar(codigo);
        return Response.ok(gson.toJson(ret)).build();
    }
}
