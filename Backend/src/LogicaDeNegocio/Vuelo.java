package LogicaDeNegocio;

import org.json.JSONObject;

public class Vuelo {

    private int id;
    private Horario Horario_id;
    //private Ruta Ruta_codigo;
    private Avion Avion_id;

    @Override
    public String toString() {
        return "Vuelo{" + "id=" + id + ", horario_id=" + Horario_id +  ", avion_id=" + Avion_id + '}'+'\n';
    }

    public Vuelo(int id, Horario Horario_id, Ruta Ruta_codigo, Avion Avion_id) {
        this.id = id;
        this.Horario_id = Horario_id;
        //this.Ruta_codigo = Ruta_codigo;
        this.Avion_id = Avion_id;
    }

    public Vuelo() {
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("avion", getHorario_id());
       // r.put("ruta", getRuta_codigo());
        r.put("horario", getAvion_id());
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Horario getHorario_id() {
        return Horario_id;
    }

    public void setHorario_id(Horario horario_id) {
        this.Horario_id = horario_id;
    }

//    public Ruta getRuta_codigo() {
//        return Ruta_codigo;
//    }
//
//    public void setRuta_codigo(Ruta ruta_codigo) {
//        this.Ruta_codigo = ruta_codigo;
//    }

    public Avion getAvion_id() {
        return Avion_id;
    }

    public void setAvion_id(Avion avion_id) {
        this.Avion_id = avion_id;
    }

}
