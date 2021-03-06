package LogicaDeNegocio;

import java.sql.Time;

public class Horario {

    private int id;
    private String dia_semana;
    private Time hora_salida;
    private Time hora_llegada;
    private Ruta ruta_codigo;

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", dia_semana=" + dia_semana + ", hora_salida=" + hora_salida + ", hora_llegada=" + hora_llegada + ", ruta_codigo=" + ruta_codigo + '}'+'\n';
    }

    public Horario(int id, String dia_semana, Time hora_salida, Time hora_llegada, Ruta ruta_codigo) {
        this.id = id;
        this.dia_semana = dia_semana;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.ruta_codigo = ruta_codigo;
    }

    public Horario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Time getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(Time hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public Ruta getRuta_codigo() {
        return ruta_codigo;
    }

    public void setRuta_codigo(Ruta ruta_codigo) {
        this.ruta_codigo = ruta_codigo;
    }

}
