package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Destino;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoDestino extends Conexion {

    private static final String INSERTAR_DESTINO = "call insertar_destino(?,?)";
    private static final String ACTUALIZAR_DESTINO = "call actualizar_destino(?,?)";
    private static final String MOSTRAR_DESTINO_X_ID = "call mostrar_destinos_x_id(?)";
    private static final String VISTA_DESTINO = "select * from keed_moviles.vista_destinos";
    private static final String ELIMINAR_DESTINO = "call eliminar_detino(?)";

    public void insertar_destino(Destino destino) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_DESTINO);
            pstmt.setInt(1, destino.getCodigo());
            pstmt.setString(2, destino.getNombre());
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

    public void actualizar_destino(Destino destino) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_DESTINO);
            pstmt.setInt(1, destino.getCodigo());
            pstmt.setString(2, destino.getNombre());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el pais");
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

    public void eliminar_destino(int destino) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_DESTINO);
            pstmt.setInt(1, destino);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el pais");
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

    public Destino mostrar_destino_x_id(int id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Destino destino = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_DESTINO_X_ID);
            pstmt.clearParameters();
            pstmt.setInt(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            destino = new Destino(
                    rs.getInt("codigo"),
                    rs.getString("nombre"));
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
        if (destino == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return destino;
    }

    public ArrayList vista_destino() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Destino> coleccion = new ArrayList<Destino>();
        Destino destino = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_DESTINO);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                destino = new Destino(
                        rs.getInt("codigo"),
                        rs.getString("nombre"));
                coleccion.add(destino);
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
