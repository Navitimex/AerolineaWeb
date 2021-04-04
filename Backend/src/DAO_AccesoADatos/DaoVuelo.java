package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Vuelo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoVuelo extends Conexion {

    private static final String INSERTAR_VUELO = "{call insertar_vuelo(?,?)}";
    private static final String ACTUALIZAR_VUELO = "{call actualizar_vuelo(?,?,?,?)}";
    private static final String CONSULTA_VUELO_X_ID = "{call mostrar_vuelo_x_id(?)}";
    private static final String VISTA_VUELO = "{select * from keed_moviles.vista_vuelo}";
    private static final String ELIMINAR_VUELO = "{call eliminar_vuelo(?)}";

    public void insertar_vuelo(Vuelo vuelo) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_VUELO);
            pstmt.setInt(1, vuelo.getHorario_id());
            pstmt.setInt(2, vuelo.getAvion_id());
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

    public void modificar_Vuelo(Vuelo vuelo) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_VUELO);
            pstmt.setInt(1, vuelo.getHorario_id());
            pstmt.setInt(2, vuelo.getAvion_id());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el vuelo");
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

    public void eliminar_Vuelo(int vuelo) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_VUELO);
            pstmt.setInt(1, vuelo);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el vuelo");
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

    public Vuelo mostrar_vuelo_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Vuelo vuelo = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(CONSULTA_VUELO_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            vuelo = new Vuelo(
                    rs.getInt("id"),
                    rs.getInt("Horario_id"),
                    rs.getInt("Ruta_codigo"),
                    rs.getInt("Avion_id"));
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
        if (vuelo == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return vuelo;
    }

    public ArrayList vista_vuelo() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Vuelo> coleccion = new ArrayList<Vuelo>();
        Vuelo vuelo = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_VUELO);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vuelo = new Vuelo(
                        rs.getInt("id"),
                        rs.getInt("Horario_id"),
                        rs.getInt("Ruta_codigo"),
                        rs.getInt("Avion_id"));
                coleccion.add(vuelo);
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
