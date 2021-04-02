/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.model;

/**
 *
 * @author kevin
 */
public class Reserva {

    private int id;
    private int ida;
    private int vuelta;
    private int cliente_id;

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", ida=" + ida + ", vuelta=" + vuelta + ", cliente_id=" + cliente_id + '}';
    }

    public Reserva(int id, int ida, int vuelta, int cliente_id) {
        this.id = id;
        this.ida = ida;
        this.vuelta = vuelta;
        this.cliente_id = cliente_id;
    }

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIda() {
        return ida;
    }

    public void setIda(int ida) {
        this.ida = ida;
    }

    public int getVuelta() {
        return vuelta;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

}
