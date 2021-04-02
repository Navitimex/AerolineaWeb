package LogicaDeNegocio;

import org.json.JSONObject;

public class Avion {

    private int id;
    private int anio;
    private int can_asientos;
    private String modelo;
    private String marca;

    public Avion() {
    }

    public Avion(int id, int anio, int can_asientos, String modelo, String marca) {
        this.id = id;
        this.anio = anio;
        this.can_asientos = can_asientos;
        this.modelo = modelo;
        this.marca = marca;
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
