package LogicaDeNegocio;

import org.json.JSONObject;

public class Avion {

    private int id;
    private int anio;
    private String modelo;
    private String marca;
    private int can_asientos;

    public Avion() {
    }

    public Avion(int id, int anio, String modelo, String marca, int can_asientos) {
        this.id = id;
        this.anio = anio;
        this.modelo = modelo;
        this.marca = marca;
        this.can_asientos = can_asientos;
    }

//    public Avion(int anio, String modelo, String marca, int can_asientos) {
//        this.anio = anio;
//        this.modelo = modelo;
//        this.marca = marca;
//        this.can_asientos = can_asientos;
//    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("anio", getAnio());
        r.put("modelo", getModelo());
        r.put("marca", getMarca());
        r.put("can_asientos", getCan_asientos());
        return r;
    }

    @Override
    public String toString() {
        return "Avion{" + "id=" + id + ", anio=" + anio + ", can_asientos=" + can_asientos + ", modelo=" + modelo + ", marca=" + marca + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCan_asientos() {
        return can_asientos;
    }

    public void setCan_asientos(int can_asientos) {
        this.can_asientos = can_asientos;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
