package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Avion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAvion extends Conexion {

    private static final String INSERTAR_AVION = "call insertar_avion(?,?,?,?)";
    private static final String ACTUALIZAR_AVION_ANIO = "call actualizar_avion_anio(?)";
    private static final String ACTUALIZAR_AVION_MODELO = "call actualizar_avion_modelo(?)";
    private static final String ACTUALIZAR_AVION_MARCA = "call actualizar_avion_marca(?)";
    private static final String ACTUALIZAR_AVION_CAN_ASIENTOS = "call actualizar_avion_can_asientos(?)";
    private static final String VISTA_AVION = "SELECT * FROM keed_moviles.vista_avion;";
    private static final String MOSTRAR_AVION_X_ID = "call mostrar_avion_x_id(?)";
    private static final String ELIMINAR_AVION = "call eliminar_avion(?)";

    public void insertar_avion(Avion avion) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_AVION);
//            pstmt.setInt(1, avion.getId());
            pstmt.setInt(1, avion.getAnio());
            pstmt.setString(2, avion.getModelo());
            pstmt.setString(3, avion.getMarca());
            pstmt.setInt(4, avion.getCan_asientos());
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

//    public void modificar_Avion(Avion avion) throws GlobalException, NoDataException {
//        conectar();
//        CallableStatement pstmt = null;
//        try {
//            pstmt = cnx.prepareCall(MODIFICAR_AVION);
//            pstmt.setString(1, avion.getId());
//            pstmt.setString(2, avion.getTipoAvion());
//            boolean resultado = pstmt.execute();
//
//            if (resultado == true) {
//                throw new NoDataException("No se modifico el avion");
//            }
//            // <editor-fold defaultstate="collapsed" desc="Excepciones">
//        } catch (SQLException e) {
//            throw new GlobalException("Sentencia no valida");
//        } finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//                desconectar();
//            } catch (SQLException e) {
//                throw new GlobalException("Estatutos invalidos o nulos");
//            }
//        }
//        // </editor-fold>
//    }

    public void eliminar_Avion(int avion) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_AVION);
            pstmt.setInt(1, avion);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el avion");
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

    public Avion mostrar_avion_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Avion avion = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_AVION_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            avion = new Avion(
                    rs.getInt("id"),
                    rs.getInt("anio"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("can_asientos"));
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
        if (avion == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return avion;
    }

    public ArrayList listar_Avions() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Avion> coleccion = new ArrayList<Avion>();
        Avion avion = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_AVION);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
            avion = new Avion(
                    rs.getInt("id"),
                    rs.getInt("anio"),
                    rs.getString("modelo"),
                    rs.getString("marca"),
                    rs.getInt("can_asientos"));
                coleccion.add(avion);
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
