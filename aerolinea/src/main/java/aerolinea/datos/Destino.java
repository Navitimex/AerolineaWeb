/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.datos;

/**
 *
 * @author kevin
 */
public class Destino {

    private int codigo;
    private String nombre;

    public Destino(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Destino() {
    }

    @Override
    public String toString() {
        return "Destino{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
