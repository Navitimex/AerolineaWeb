package DAO_AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {

    protected Connection cnx = null;

    public Conexion() {

    }

    protected void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/keed_moviles", "root", "admin");
           // System.out.println("Coneccion Satisfactoria");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de coneccion: " + e);
        }
    }

    protected void desconectar() {
        try {
            if (!cnx.isClosed()) {
                cnx.close();
               // System.out.println("Desconeccion Satisfactoria ");
            }
        } catch (SQLException ex) {
            System.out.println("Error de coneccion: " + ex);
        }
    }

    public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet executeQuery(String statement) {
        try {
            Statement stm = cnx.createStatement();
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
        }
        return null;
    }
}
