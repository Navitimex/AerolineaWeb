package controller;

import Excepciones.GeneralException;
import LogicaDeNegocio.Cliente;
import LogicaDeNegocio.Destino;
import LogicaDeNegocio.Ruta;
import LogicaDeNegocio.Vuelo;
import Model.ModelCliente;
import Model.ModelDestino;
import Model.ModelRuta;
import Model.ModelVuelo;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    public String insertar(String id) {
        Gson gson = new Gson();
        Cliente clienteRest = gson.fromJson(id, Cliente.class);
        ModelCliente mCliente = ModelCliente.getInstance();
        mCliente.insertar(clienteRest);
        return gson.toJson(clienteRest);
    }

    @GET
    @Path("/verVuelos")
    @Produces(MediaType.APPLICATION_JSON)
    public String mostarvuelos() {
        Gson gson = new Gson();
        ModelVuelo mVuelo = ModelVuelo.getInstance();
        ArrayList<Vuelo> vueloRest = (ArrayList<Vuelo>) mVuelo.listar(); 
        return gson.toJson(vueloRest);
    }

    
    @GET
    @Path("/verDestinos")
    @Produces(MediaType.APPLICATION_JSON)
    public String mostarDestinos() {
        Gson gson = new Gson();
        ModelDestino mDestino = ModelDestino.getInstance();
        ArrayList<Destino> destinoRest = (ArrayList<Destino>) mDestino.listar(); 
        return gson.toJson(destinoRest);
    }

    @GET
    @Path("/verRutas")
    @Produces(MediaType.APPLICATION_JSON)
    public String mostarRutas() {
        Gson gson = new Gson();
        ModelRuta mRuta = ModelRuta.getInstance();
        ArrayList<Ruta> rutaRest = (ArrayList<Ruta>) mRuta.listar(); 
        return gson.toJson(rutaRest);
    }
    
    
}
