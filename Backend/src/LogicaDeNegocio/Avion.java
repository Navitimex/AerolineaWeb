package LogicaDeNegocio;

import org.json.JSONObject;



public class Avion {

    private String id, tipoAvion;
//asdasdasd
    public Avion(String id, String tipoAvion) {
        this.id = id;
        this.tipoAvion = tipoAvion;
    }

    public Avion() {
        this.id = "";
        this.tipoAvion = null;
    }

    public String getId() {
        return id;
    }

 
    public String getTipoAvion() {
        return tipoAvion;
    }


    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("tipoAvion", getTipoAvion());
        return r;
    }
}
