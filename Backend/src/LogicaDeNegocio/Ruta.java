package LogicaDeNegocio;

import java.sql.Time;

public class Ruta {

    private int codigo;
    private Destino origen;
    private Destino destino;
    private Time duracionMin;
    private float precio;
    private float descuento;

    public Ruta() {
    }

    public Ruta(
            int codigo, 
            Destino origen, 
            Destino destino, 
            Time duracionMin, 
            float precio, 
            float descuento
    ) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.duracionMin = duracionMin;
        this.precio = precio;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Ruta{" + "codigo=" + codigo +"\n\t"+ ", origen=" + origen +"\t"+ ", destino=" + destino + ", duracionMin=" + duracionMin + ", precio=" + precio + ", descuento=" + descuento + '}'+"\n";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Destino getOrigen() {
        return origen;
    }

    public void setOrigen(Destino origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
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
