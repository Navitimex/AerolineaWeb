package controller;

import Excepciones.GeneralException;
import LogicaDeNegocio.Cliente;
import Model.ModelCliente;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("cliente")
public class ClienteController {

    @Context
    private UriInfo context;
    public ClienteController() {
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente login(String id) {
        Gson gson = new Gson();
        Cliente clienteRest = gson.fromJson(id, Cliente.class);
        ModelCliente mCliente = ModelCliente.getInstance();
        clienteRest = mCliente.consultar(clienteRest.getId());
      
        return clienteRest;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("/registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertar(String id){
    Gson gson = new Gson();
    Cliente clienteRest = gson.fromJson(id, Cliente.class);
    ModelCliente mCliente = ModelCliente.getInstance();
    mCliente.insertar(clienteRest);
    return gson.toJson(clienteRest);
    }
    
    

}
