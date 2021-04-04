package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Tiquete;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoTiquete extends Conexion {

    private static final String INSERTAR_TIQUETE = "{call insertar_tiquete(?,?,?,?)}";
    private static final String ACTUALIZAR_TIQUETE = "{call actualizar_tiquete(?,?,?,?,?)}";
    private static final String MOSTRAR_TIQUETE_X_ID = "{call mostrar_tiquete_x_id(?)}";
    private static final String VISTA_TIQUETE = "{select * from keed_moviles.vista_tiquete}";
    private static final String ELIMINAR_TIQUETE = "{call eliminar_tiquete(?)}";
 
    
    public void insertar_tiquete(Tiquete tiquete) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_TIQUETE);
            pstmt.setInt(1, tiquete.getId());
            pstmt.setInt(2, tiquete.getVuelo_id());
            pstmt.setInt(3, tiquete.getCliente_id());
            pstmt.setInt(4, tiquete.getNumero_asiento());
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

    public void actualizar_tiquete(Tiquete tiquete) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_TIQUETE);
            pstmt.setInt(1, tiquete.getId());
            pstmt.setInt(2, tiquete.getVuelo_id());
            pstmt.setInt(3, tiquete.getCliente_id());
            pstmt.setInt(4, tiquete.getNumero_asiento());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se Modifico el Tiquete.");
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

    public void eliminar_tiquete(int tiquete) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_TIQUETE);
            pstmt.setInt(1, tiquete);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el tiquete");
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

    public Tiquete consultar_tiquete_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Tiquete tiquete = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_TIQUETE_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            tiquete = new Tiquete(
                    rs.getInt("id"),
                    rs.getInt("Vuelo_id"),
                    rs.getInt("Cliente_id"),
                    rs.getInt("numero_asiento"));
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
        if (tiquete == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return tiquete;
    }

    public ArrayList vista_tiquete() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Tiquete> coleccion = new ArrayList<Tiquete>();
        Tiquete tiquete = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_TIQUETE);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tiquete = new Tiquete(
                    rs.getInt("id"),
                    rs.getInt("Vuelo_id"),
                    rs.getInt("Cliente_id"),
                    rs.getInt("numero_asiento"));
                coleccion.add(tiquete);
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
