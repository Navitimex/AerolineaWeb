package Model;

import DAO_AccesoADatos.DaoVuelo;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Vuelo;
import java.util.ArrayList;
import java.util.Observable;

public class ModelVuelo extends Observable implements ModelInterface<Vuelo> {

    private static ModelVuelo mInstance;
    private ArrayList<Vuelo> listVuelo;
    private final DaoVuelo daoVuelo;

    public static ModelVuelo getInstance() {
        if (mInstance == null) {
            mInstance = new ModelVuelo();
        }

        return mInstance;
    }

    private ModelVuelo() {
        listVuelo = new ArrayList<Vuelo>();
        daoVuelo = new DaoVuelo();
    }

    @Override
    public void insertar(Vuelo e) {
        try {
            daoVuelo.insertar_vuelo(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Vuelo e) {
        try {
            daoVuelo.modificar_Vuelo(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoVuelo.eliminar_Vuelo((int) e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Vuelo consultar(Object e) {
        Vuelo vuelo = null;
        try {
            vuelo = daoVuelo.mostrar_vuelo_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return vuelo;
    }

    @Override
    public ArrayList listar() {
        try {
            listVuelo = daoVuelo.vista_vuelo();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listVuelo;
    }

}
