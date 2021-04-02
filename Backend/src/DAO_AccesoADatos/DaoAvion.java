package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Avion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoAvion extends Conexion {

    private static final String AGREGAR_AVION = "{call AgregarAvion(?,?)}";
    private static final String MODIFICAR_AVION = "{call ModificarAvion(?,?)}";
    private static final String ELIMINAR_AVION = "{call EliminarAvion(?)}";
    private static final String CONSULTA_AVION = "{call ConsultarAvion(?)}";
    private static final String LISTAR_AVION = "{call ListarAvion()}";

    public void insertar_avion(Avion avion) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(AGREGAR_AVION);
            pstmt.setString(1, avion.getId());
            pstmt.setString(2, avion.getTipoAvion());
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

    public void modificar_Avion(Avion avion) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MODIFICAR_AVION);
            pstmt.setString(1, avion.getId());
            pstmt.setString(2, avion.getTipoAvion());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el avion");
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

    public void eliminar_Avion(String avion) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_AVION);
            pstmt.setString(1, avion);
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

    public Avion consultar_Avion(String id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Avion avion = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(CONSULTA_AVION);
            pstmt.clearParameters();
            pstmt.setString(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            avion = new Avion(
                    rs.getString("id"),
                    rs.getString("TipoAvion_id"));
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
            pstmt = cnx.prepareCall(LISTAR_AVION);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                avion = new Avion(
                    rs.getString("id"),
                    rs.getString("TipoAvion_id"));
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
