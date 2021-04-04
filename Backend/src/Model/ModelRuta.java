package Model;

import DAO_AccesoADatos.DaoRuta;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Ruta;
import java.util.ArrayList;
import java.util.Observable;

public class ModelRuta extends Observable implements ModelInterface<Ruta> {

    private static ModelRuta mInstance;
    private ArrayList<Ruta> listRuta;
    private final DaoRuta daoRuta;

    public static ModelRuta getInstance() {
        if (mInstance == null) {
            mInstance = new ModelRuta();
        }

        return mInstance;
    }

    private ModelRuta() {
        listRuta = new ArrayList<Ruta>();
        daoRuta = new DaoRuta();
    }

    @Override
    public void insertar(Ruta e) {
        try {
            daoRuta.insertar_ruta(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Ruta e) {
        try {
            daoRuta.actualizar_ruta(e);
            listRuta = daoRuta.vista_ruta();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoRuta.eliminar_ruta((String) e);
            listRuta = daoRuta.vista_ruta();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Ruta consultar(Object e) {
        Ruta ruta = null;
        try {
            ruta = daoRuta.mostrar_ruta_x_id((String) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return ruta;
    }

    @Override
    public ArrayList listar() {
        try {
            listRuta = daoRuta.vista_ruta();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listRuta;
    }

}
