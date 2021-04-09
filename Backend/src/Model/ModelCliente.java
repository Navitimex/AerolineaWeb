package Model;

import DAO_AccesoADatos.DaoCliente;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Cliente;
import java.util.ArrayList;
import java.util.Observable;

public class ModelCliente extends Observable implements ModelInterface<Cliente> {

    private static ModelCliente mInstance;
    private ArrayList<Cliente> listCliente;
    private final DaoCliente daoCliente;

    public static ModelCliente getInstance() {
        if (mInstance == null) {
            mInstance = new ModelCliente();
        }

        return mInstance;
    }

    private ModelCliente() {
        daoCliente = new DaoCliente();
    }

    @Override
    public void insertar(Cliente e) {
        try {
            daoCliente.insertar_cliente(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Cliente e) {
        try {
            daoCliente.actualizar_cliente(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoCliente.eliminar_Cliente((int) e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Cliente consultar(Object e) {
        Cliente cliente = null;
        try {
            cliente = daoCliente.mostrar_cliente_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return cliente;
    }

    @Override
    public ArrayList listar() {
        try {
            listCliente = daoCliente.vista_cliente();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listCliente;
    }

}
