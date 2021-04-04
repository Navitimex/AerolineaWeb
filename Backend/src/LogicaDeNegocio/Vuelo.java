package LogicaDeNegocio;

import org.json.JSONObject;

public class Vuelo {

    private int id;
    private int Horario_id;
    private int Ruta_codigo;
    private int Avion_id;

    @Override
    public String toString() {
        return "Vuelo{" + "id=" + id + ", horario_id=" + Horario_id + ", ruta_codigo=" + Ruta_codigo + ", avion_id=" + Avion_id + '}';
    }

    public Vuelo(int id, int Horario_id, int Ruta_codigo, int Avion_id) {
        this.id = id;
        this.Horario_id = Horario_id;
        this.Ruta_codigo = Ruta_codigo;
        this.Avion_id = Avion_id;
    }

    public Vuelo() {
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("avion", getHorario_id());
        r.put("ruta", getRuta_codigo());
        r.put("horario", getAvion_id());
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorario_id() {
        return Horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.Horario_id = horario_id;
    }

    public int getRuta_codigo() {
        return Ruta_codigo;
    }

    public void setRuta_codigo(int ruta_codigo) {
        this.Ruta_codigo = ruta_codigo;
    }

    public int getAvion_id() {
        return Avion_id;
    }

    public void setAvion_id(int avion_id) {
        this.Avion_id = avion_id;
    }

}
