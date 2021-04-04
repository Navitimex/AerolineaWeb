package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import LogicaDeNegocio.Reservacion;
import Model.ModelCliente;
import Model.ModelReservacion;
import Model.ModelTiquete;

public class DaoReservacion extends Conexion {

    private static final String INSERTAR_RESERVACION_IDA_VUELTA = "call insertar_reservacion_ida_vuelta(?,?)";
    private static final String ACTUALIZAR_CLIENTE = "call actualizar_cliente(?,?,?)";
    private static final String MOSTRAR_RESERVACION_X_ID = "call mostrar_reservacion_x_id(?)";
    private static final String VISTA_RESERVACION = "select * from keed_moviles.vista_reservacion";
    private static final String ELIMINAR_RESERVACION = "call eliminar_reservacion(?)";

    public void insertar_reservacion_ida_vuelta(Reservacion reservacion) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_RESERVACION_IDA_VUELTA);
            pstmt.setInt(1, reservacion.getIda().getId());
            pstmt.setInt(2, reservacion.getVuelta().getId());
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

    public void actualizar_reserva(Reservacion reservacion) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_CLIENTE);
            pstmt.setInt(2, reservacion.getIda().getId());
            pstmt.setInt(3, reservacion.getVuelta().getId());
            pstmt.setInt(4, reservacion.getCliente_id().getId());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el reservacion");
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

    public void eliminar_Reservacion(int reservacion) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_RESERVACION);
            pstmt.setInt(1, reservacion);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el reservacion");
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

    public Reservacion mostrar_reservacion_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Reservacion reservacion = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_RESERVACION_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            reservacion = new Reservacion(
                    rs.getInt("id"),
                    ModelTiquete.getInstance().consultar(rs.getInt("ida")),
                   // ModelTiquete.getInstance().consultar(rs.getInt("vuelta")),
                    ModelCliente.getInstance().consultar(rs.getInt("Cliente_id")) 
            );
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
        if (reservacion == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return reservacion;
    }

    public ArrayList vista_reservacion() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Reservacion> coleccion = new ArrayList<Reservacion>();
        Reservacion reservacion = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_RESERVACION);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                reservacion = new Reservacion(
                        rs.getInt("id"),
                    ModelTiquete.getInstance().consultar(rs.getInt("ida")),
                    ModelTiquete.getInstance().consultar(rs.getInt("vuelta")),
                    ModelCliente.getInstance().consultar(rs.getInt("Cliente_id")) 
                );
                coleccion.add(reservacion);
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
