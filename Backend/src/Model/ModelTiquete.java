package Model;

import DAO_AccesoADatos.DaoTiquete;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Tiquete;
import java.util.ArrayList;
import java.util.Observable;

public class ModelTiquete extends Observable implements ModelInterface<Tiquete> {

    private static ModelTiquete mInstance;
    private ArrayList<Tiquete> listTiquete;
    private final DaoTiquete daoTiquete;

    public static ModelTiquete getInstance() {
        if (mInstance == null) {
            mInstance = new ModelTiquete();
        }

        return mInstance;
    }

    private ModelTiquete() {
        listTiquete = new ArrayList<Tiquete>();
        daoTiquete = new DaoTiquete();
    }

    @Override
    public void insertar(Tiquete e) {
        try {
            daoTiquete.insertar_tiquete(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Tiquete e) {
        try {
            daoTiquete.actualizar_tiquete(e);
            listTiquete = daoTiquete.vista_tiquete();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoTiquete.eliminar_tiquete((int) e);
            listTiquete = daoTiquete.vista_tiquete();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Tiquete consultar(Object e) {
        Tiquete tiquete = null;
        try {
            tiquete = daoTiquete.consultar_tiquete_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return tiquete;
    }

    @Override
    public ArrayList listar() {
        try {
            listTiquete = daoTiquete.vista_tiquete();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listTiquete;
    }

}
