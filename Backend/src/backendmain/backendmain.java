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
import Model.ModelHorario;
import Model.ModelReservacion;
import Model.ModelRuta;
import Model.ModelTiquete;
import Model.ModelVuelo;

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

//System.out.println(ModelAvion.getInstance().listar());
//System.out.println(ModelAvion.getInstance().consultar(5));

//System.out.println(ModelDestino.getInstance().listar());
//System.out.println(ModelDestino.getInstance().consultar(5));

//System.out.println(ModelCliente.getInstance().listar());
//System.out.println(ModelCliente.getInstance().consultar(5));

//System.out.println(ModelRuta.getInstance().listar());
//System.out.println(ModelRuta.getInstance().consultar(4));

//System.out.println(ModelHorario.getInstance().listar());
//System.out.println(ModelHorario.getInstance().consultar(5));

//System.out.println(ModelVuelo.getInstance().listar());
//System.out.println(ModelVuelo.getInstance().consultar(9));

//System.out.println(ModelTiquete.getInstance().listar());
//System.out.println(ModelTiquete.getInstance().consultar(6));

//System.out.println(ModelReservacion.getInstance().listar());
System.out.println(ModelReservacion.getInstance().consultar(1));

    }

}
