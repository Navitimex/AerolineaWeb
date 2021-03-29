/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.model.dao;

import aerolinea.configuracion.Conexion;
import aerolinea.datos.Cliente;
import aerolinea.datos.validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
public class clienteDao implements validar{
        Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int resultado = 0;

    @Override
    public int validar(Cliente cli) {
        String sql = "Select * from cliente where nombre=? and correo=? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado = resultado + 1;
                cli.setNombre(rs.getString("Nombres"));
                cli.setCorreo(rs.getString("Correo"));
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
