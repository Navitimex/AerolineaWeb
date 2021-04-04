package Model;

import DAO_AccesoADatos.DaoAvion;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Avion;
import java.util.ArrayList;
import java.util.Observable;

public class ModelAvion extends Observable implements ModelInterface<Avion> {

    private static ModelAvion mInstance;
    private ArrayList<Avion> listAvion;
    private final DaoAvion daoAvion;

    public static ModelAvion getInstance() {
        if (mInstance == null) {
            mInstance = new ModelAvion();
        }

        return mInstance;
    }

    private ModelAvion() {
        listAvion = new ArrayList<Avion>();
        daoAvion = new DaoAvion();
    }

    @Override
    public void insertar(Avion e) {
        try {
            daoAvion.insertar_avion(e);
            //listAvion = daoAvion.listar_Avions();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

//    @Override
//    public void modificar(Avion e) {
//        try {
//            daoAvion.modificar_Avion(e);
//            listAvion = daoAvion.listar_Avions();
//            setChanged();
//            notifyObservers();
//        } catch (NoDataException | GlobalException noDataException) {
//        }
//    }

        @Override
    public void modificar(Avion e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void eliminar(Object e) {
        try {
            daoAvion.eliminar_Avion((int) e);
            listAvion = daoAvion.listar_Avions();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Avion consultar(Object e) {
        Avion avion = null;
        try {
            avion = daoAvion.mostrar_avion_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return avion;
    }

    @Override
    public ArrayList listar() {
        try {
            listAvion = daoAvion.listar_Avions();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listAvion;
    }



}
