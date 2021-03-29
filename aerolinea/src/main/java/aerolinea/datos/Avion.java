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
public class Avion {
    
   private int anio;
   private String modelo;
   private String marca;
   private int can_asientos;
   
       public Avion(int anio, String modelo, String marca, int can_asientos) {
        this.anio = anio;
        this.modelo = modelo;
        this.marca = marca;
        this.can_asientos = can_asientos;
    }
       
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    public int getCan_asientos() {
        return can_asientos;
    }

    public void setCan_asientos(int can_asientos) {
        this.can_asientos = can_asientos;
    }

    @Override
    public String toString() {
        return "Avion{" + "anio=" + anio + ", modelo=" + modelo + ", marca=" + marca + ", can_asientos=" + can_asientos + '}';
    }



}
