package LogicaDeNegocio;

import java.sql.Time;

public class Ruta {

    private String codigo;
    private String origen;
    private String destino;
    private Time duracionMin;
    private float precio;
    private float descuento;

    public Ruta() {
    }

    public Ruta(String codigo, String origen, String destino, Time duracionMin, float precio, float descuento) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Ruta{" + "codigo=" + codigo + ", origen=" + origen + ", destino=" + destino + ", duracionMin=" + duracionMin + ", precio=" + precio + ", descuento=" + descuento + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Time duracionMin) {
        this.duracionMin = duracionMin;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

}
