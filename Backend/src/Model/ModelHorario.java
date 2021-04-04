package Model;

import DAO_AccesoADatos.DaoHorario;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Interfaces.ModelInterface;
import LogicaDeNegocio.Horario;
import java.util.ArrayList;
import java.util.Observable;

public class ModelHorario extends Observable implements ModelInterface<Horario> {

    private static ModelHorario mInstance;
    private ArrayList<Horario> listHorario;
    private final DaoHorario daoHorario;

    public static ModelHorario getInstance() {
        if (mInstance == null) {
            mInstance = new ModelHorario();
        }

        return mInstance;
    }

    private ModelHorario() {
        listHorario = new ArrayList<Horario>();
        daoHorario = new DaoHorario();
    }

    @Override
    public void insertar(Horario e) {
        try {
            daoHorario.insertar_horario(e);
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void modificar(Horario e) {
        try {
            daoHorario.actualizar_horario(e);
            listHorario = daoHorario.vista_horario();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public void eliminar(Object e) {
        try {
            daoHorario.eliminar_Horario((int) e);
            listHorario = daoHorario.vista_horario();
            setChanged();
            notifyObservers();
        } catch (NoDataException | GlobalException noDataException) {
        }
    }

    @Override
    public Horario consultar(Object e) {
        Horario horario = null;
        try {
            horario = daoHorario.mostrar_horario_x_id((int) e);
        } catch (NoDataException | GlobalException noDataException) {
        }
        return horario;
    }

    @Override
    public ArrayList listar() {
        try {
            listHorario = daoHorario.vista_horario();
        } catch (NoDataException | GlobalException noDataException) {
        }
        return listHorario;
    }

}
