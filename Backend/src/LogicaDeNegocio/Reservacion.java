package LogicaDeNegocio;

import org.json.JSONObject;

public class Reservacion {

    private int id;
    private Tiquete ida;
    private Tiquete vuelta;
    private Cliente cliente_id;

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", ida=" + ida + ", vuelta=" + vuelta + ", cliente_id=" + cliente_id + '}';
    }

    public Reservacion(int id, Tiquete ida, Tiquete vuelta, Cliente cliente_id) {
        this.id = id;
        this.ida = ida;
        this.vuelta = vuelta;
        this.cliente_id = cliente_id;
    }

     public Reservacion(int id, Tiquete ida, Cliente cliente_id) {
        this.id = id;
        this.ida = ida;
        this.vuelta = null;
        this.cliente_id = cliente_id;
    }
    
    public Reservacion() {
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("ida", getIda());
        r.put("vuelta", getVuelta());
        r.put("Cliente_id", getCliente_id());
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tiquete getIda() {
        return ida;
    }

    public void setIda(Tiquete ida) {
        this.ida = ida;
    }

    public Tiquete getVuelta() {
        return vuelta;
    }

    public void setVuelta(Tiquete vuelta) {
        this.vuelta = vuelta;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

}
