package LogicaDeNegocio;

public class Tiquete {

    private int id;
    private int vuelo_id;
    private int cliente_id;
    private int numero_asientos;

    @Override
    public String toString() {
        return "Tiquete{" + "id=" + id + ", vuelo_id=" + vuelo_id + ", cliente_id=" + cliente_id + ", numero_asientos=" + numero_asientos + '}';
    }

    public Tiquete(int id, int vuelo_id, int cliente_id, int numero_asientos) {
        this.id = id;
        this.vuelo_id = vuelo_id;
        this.cliente_id = cliente_id;
        this.numero_asientos = numero_asientos;
    }

    public Tiquete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getNumero_asientos() {
        return numero_asientos;
    }

    public void setNumero_asientos(int numero_asientos) {
        this.numero_asientos = numero_asientos;
    }

}
