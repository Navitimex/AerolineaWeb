/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocio;

/**
 *
 * @author kevin
 */
public class Vuelo {

    private int id;
    private int horario_id;
    private int ruta_codigo;
    private int avion_id;

    @Override
    public String toString() {
        return "Vuelo{" + "id=" + id + ", horario_id=" + horario_id + ", ruta_codigo=" + ruta_codigo + ", avion_id=" + avion_id + '}';
    }

    public Vuelo(int id, int horario_id, int ruta_codigo, int avion_id) {
        this.id = id;
        this.horario_id = horario_id;
        this.ruta_codigo = ruta_codigo;
        this.avion_id = avion_id;
    }

    public Vuelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public int getRuta_codigo() {
        return ruta_codigo;
    }

    public void setRuta_codigo(int ruta_codigo) {
        this.ruta_codigo = ruta_codigo;
    }

    public int getAvion_id() {
        return avion_id;
    }

    public void setAvion_id(int avion_id) {
        this.avion_id = avion_id;
    }

}
