/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.model.dao;

import aerolinea.configuracion.Conexion;
import aerolinea.datos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
public class clienteDao {

    Connection con;
    Conexion cn = new Conexion();


    public int validar(Cliente cli) {
        String sql = "Select * from cliente where correo=? and contrasena=? ";
        try {
            PreparedStatement ps;
            ResultSet rs;
            int resultado = 0;
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCorreo());
            ps.setString(2, cli.getContrasena());
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = resultado + 1;
                
                cli.setCorreo(rs.getString("correo"));
                cli.setContrasena(rs.getString("contrasena"));
            }
            if (resultado == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

    }
}
