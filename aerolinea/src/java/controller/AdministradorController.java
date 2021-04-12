package controller;

import LogicaDeNegocio.Avion;
import LogicaDeNegocio.Cliente;
import LogicaDeNegocio.Destino;
import Model.ModelAvion;
import Model.ModelCliente;
import Model.ModelDestino;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("administrador")
public class AdministradorController {

    @Context
    private UriInfo context;

    @POST
    @Path("/insertarAvion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertar(String id) {
        Gson gson = new Gson();
        Avion avionRest = gson.fromJson(id, Avion.class);
        ModelAvion mAvion = ModelAvion.getInstance();
        mAvion.insertar(avionRest);
        return gson.toJson(avionRest);
    }

    @POST
    @Path("/insertarDestino")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertarDestino(String id) {
        Gson gson = new Gson();
        Destino destinoRest = gson.fromJson(id, Destino.class);
        ModelDestino mDestino = ModelDestino.getInstance();
        mDestino.insertar(destinoRest);
        return gson.toJson(destinoRest);
    }

    public AdministradorController() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
