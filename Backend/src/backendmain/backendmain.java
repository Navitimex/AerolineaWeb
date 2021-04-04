/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendmain;

import LogicaDeNegocio.Avion;
import Model.ModelAvion;
import Model.ModelCliente;
import Model.ModelDestino;

/**
 *
 * @author kevin
 */
public class backendmain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             //ModelAvion.getInstance().insertar(new Avion(23,234,"AIRBUS319","80",80));
              
             System.out.println(ModelAvion.getInstance().listar());
             System.out.println(ModelDestino.getInstance().listar());
             System.out.println(ModelCliente.getInstance().listar());

    }
    
}
