package Interfaces;

import java.util.ArrayList;

public interface ModelInterface<General> {

    public void insertar(General e);

    public void modificar(General e);

    public void eliminar(Object e);

    public General consultar(Object e);

    public ArrayList listar();
}
