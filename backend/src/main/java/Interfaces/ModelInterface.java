/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface ModelInterface <General> {
    public void insertar(General e);
    public void modificar(General e);
    public void eliminar(Object e);
    public General consultar(Object e);
    public ArrayList listar();
}
