package LogicaDeNegocio;

public class Tiquete {

    private int id;
    private Vuelo Vuelo_id;
    private Cliente Cliente_id;
    private int numero_asiento;

    @Override
    public String toString() {
        return "Tiquete{" + "id=" + id + '\n'+ ", vuelo_id=" + Vuelo_id + ", cliente_id=" + Cliente_id + ", numero_asientos=" + numero_asiento + '}'+'\n';
    }

    public Tiquete(int id, Vuelo vuelo_id, Cliente cliente_id, int numero_asiento) {
        this.id = id;
        this.Vuelo_id = vuelo_id;
        this.Cliente_id = cliente_id;
        this.numero_asiento = numero_asiento;
    }

    public Tiquete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo getVuelo_id() {
        return Vuelo_id;
    }

    public void setVuelo_id(Vuelo vuelo_id) {
        this.Vuelo_id = vuelo_id;
    }

    public Cliente getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.Cliente_id = cliente_id;
    }

    public int getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }

}
