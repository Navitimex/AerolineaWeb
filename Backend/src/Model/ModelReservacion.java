package Model;

import DAO_AccesoADatos.DaoReservacion;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Reservacion;
import java.util.ArrayList;
import java.util.Observable;

public class ModelReservacion extends Observable implements ModelInterface<Reservacion> {

    private static ModelReservacion mInstance;
    private ArrayList<Reservacion> listReservacion;
    private final DaoReservacion daoReservacion;

    public static ModelReservacion getInstance() {
        if (mInstance == null) {
            mInstance = new ModelReservacion();
        }

        return mInstance;
    }

    private ModelReservacion() {
        listReservacion = new ArrayList<Reservacion>();
        daoReservacion = new DaoReservacion();
    }

    @Override
    public void insertar(Reservacion e) {
        try {
            daoReservacion.insertar_reservacion_ida_vuelta(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Reservacion e) {
        try {
            daoReservacion.actualizar_reserva(e);
            listReservacion = daoReservacion.vista_reservacion();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoReservacion.eliminar_Reservacion((int) e);
            listReservacion = daoReservacion.vista_reservacion();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Reservacion consultar(Object e) {
        Reservacion reservacion = null;
        try {
            reservacion = daoReservacion.mostrar_reservacion_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return reservacion;
    }

    @Override
    public ArrayList listar() {
        try {
            listReservacion = daoReservacion.vista_reservacion();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listReservacion;
    }

}
