package Model;

import DAO_AccesoADatos.DaoDestino;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Avion;
import LogicaDeNegocio.Destino;
import java.util.ArrayList;
import java.util.Observable;

public class ModelDestino extends Observable implements ModelInterface<Destino> {

    private static ModelDestino mInstance;
    private ArrayList<Destino> listPais;
    private final DaoDestino daoPais;

    public static ModelDestino getInstance() {
        if (mInstance == null) {
            mInstance = new ModelDestino();
        }
        return mInstance;
    }

    private ModelDestino() {
        daoPais = new DaoDestino();
    }

    @Override
    public void insertar(Destino e) {
        try {
            daoPais.insertar_destino(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Destino e) {
        try {
            daoPais.actualizar_destino(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoPais.eliminar_destino((int) e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Destino consultar(Object e) {
        Destino pais = null;
        try {
            pais = daoPais.mostrar_destino_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return pais;
    }

    @Override
    public ArrayList listar() {
        try {
            listPais = daoPais.vista_destino();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listPais;
    }

}
