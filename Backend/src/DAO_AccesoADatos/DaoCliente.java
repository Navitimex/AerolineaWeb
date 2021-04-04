package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Cliente;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCliente extends Conexion {

    private static final String INSERTAR_CLIENTE = "call insertar_cliente(?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR_CLIENTE = "call actualizar_cliente(?,?,?,?,?,?,?,?,?,?)";
    private static final String MOSTRAR_CLIENTE_X_ID = "call mostrar_cliente_x_id(?)";
    private static final String VISTA_CLIENTE = "select * from keed_moviles.vista_cliente";
    private static final String ELIMINAR_CLIENTE = "call eliminar_cliente(?)";

    public void insertar_cliente(Cliente cliente) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_CLIENTE);
            pstmt.setString(1, cliente.getContrasena());
            pstmt.setInt(2, cliente.getRol());
            pstmt.setString(3, cliente.getNombre());
            pstmt.setString(4, cliente.getApellidos());
            pstmt.setString(5, cliente.getCorreo());
            pstmt.setDate(6, (Date) cliente.getFec_naci()); //Funciona?
            pstmt.setString(7, cliente.getDireccion());
            pstmt.setString(8, cliente.getTel_trabajo());
            pstmt.setString(9, cliente.getTel_cel());
            boolean resultado = pstmt.execute();
            // <editor-fold defaultstate="collapsed" desc="Excepciones">
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        // </editor-fold>
    }

    public void actualizar_cliente(Cliente cliente) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_CLIENTE);
            pstmt.setString(1, cliente.getContrasena());
            pstmt.setInt(2, cliente.getRol());
            pstmt.setString(3, cliente.getNombre());
            pstmt.setString(4, cliente.getApellidos());
            pstmt.setString(5, cliente.getCorreo());
            pstmt.setDate(6, (Date) cliente.getFec_naci()); //Funciona?
            pstmt.setString(7, cliente.getDireccion());
            pstmt.setString(8, cliente.getTel_trabajo());
            pstmt.setString(9, cliente.getTel_cel());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el cliente");
            }
            // <editor-fold defaultstate="collapsed" desc="Excepciones">
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        // </editor-fold>
    }

    public void eliminar_Cliente(int cliente) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_CLIENTE);
            pstmt.setInt(1, cliente);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el cliente");
            }
            // <editor-fold defaultstate="collapsed" desc="Excepciones">
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        // </editor-fold>
    }

    public Cliente mostrar_cliente_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Cliente cliente = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_CLIENTE_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("contrasena"),
                    rs.getInt("rol"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correo"),
                    rs.getDate("fec_naci"),
                    rs.getString("direccion"),
                    rs.getString("tel_trabajo"),
                    rs.getString("tel_cel"));

            // <editor-fold defaultstate="collapsed" desc="Excepciones">
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (cliente == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return cliente;
    }

    public ArrayList vista_cliente() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Cliente> coleccion = new ArrayList<Cliente>();
        Cliente cliente = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_CLIENTE);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("contrasena"),
                        rs.getInt("rol"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getDate("fec_naci"),
                        rs.getString("direccion"),
                        rs.getString("tel_trabajo"),
                        rs.getString("tel_cel"));
                coleccion.add(cliente);
            }
            // <editor-fold defaultstate="collapsed" desc="Excepciones">
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return coleccion;
    }

}
