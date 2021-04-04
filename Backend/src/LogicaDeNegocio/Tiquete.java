package LogicaDeNegocio;

public class Tiquete {

    private int id;
    private int Vuelo_id;
    private int Cliente_id;
    private int numero_asiento;

    @Override
    public String toString() {
        return "Tiquete{" + "id=" + id + ", vuelo_id=" + Vuelo_id + ", cliente_id=" + Cliente_id + ", numero_asientos=" + numero_asiento + '}';
    }

    public Tiquete(int id, int vuelo_id, int cliente_id, int numero_asiento) {
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

    public int getVuelo_id() {
        return Vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.Vuelo_id = vuelo_id;
    }

    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.Cliente_id = cliente_id;
    }

    public int getNumero_asiento() {
        return numero_asiento;
    }

    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }

}
