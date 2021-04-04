package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Ruta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoRuta extends Conexion {

    private static final String INSERTAR_RUTA = "{call insertar_ruta(?,?,?,?,?,?)}";
    private static final String ACTUALIZAR_RUTA = "{call actualizar_ruta(?,?,?,?,?,?)}";
    private static final String MOSTRAR_RUTA_X_ID = "{call mostrar_ruta_x_id(?)}";
    private static final String VISTA_RUTA = "{select * from keed_moviles.vista_destinos}";
    private static final String ELIMINAR_RUTA = "{call elimiar_ruta(?)}";



    public void insertar_ruta(Ruta ruta) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_RUTA);
            pstmt.setString(1, ruta.getCodigo());
            pstmt.setString(2, ruta.getOrigen());
            pstmt.setString(3, ruta.getDestino());
            pstmt.setTime(4, ruta.getDuracionMin());
            pstmt.setFloat(5, ruta.getPrecio());
            pstmt.setFloat(6, ruta.getDescuento());
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

    public void actualizar_ruta(Ruta ruta) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_RUTA);
            pstmt.setString(1, ruta.getCodigo());
            pstmt.setString(2, ruta.getOrigen());
            pstmt.setString(3, ruta.getDestino());
            pstmt.setTime(4, ruta.getDuracionMin());
            pstmt.setFloat(5, ruta.getPrecio());
            pstmt.setFloat(6, ruta.getDescuento());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el ruta");
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

    public void eliminar_ruta(String ruta) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_RUTA);
            pstmt.setString(1, ruta);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el ruta");
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

    public Ruta mostrar_ruta_x_id(String id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Ruta ruta = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_RUTA_X_ID);
            pstmt.clearParameters();
            pstmt.setString(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            ruta = new Ruta(
                    rs.getString("codigo"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getTime("duracionMin"),
                    rs.getInt("precio"),
                    rs.getInt("descuento"));
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
        if (ruta == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return ruta;
    }

    public ArrayList vista_ruta() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Ruta> coleccion = new ArrayList<Ruta>();
        Ruta ruta = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_RUTA);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ruta = new Ruta(
                        rs.getString("codigo"),
                        rs.getString("origen"),
                        rs.getString("destino"),
                        rs.getTime("duracionMin"),
                        rs.getInt("precio"),
                        rs.getInt("descuento"));
                coleccion.add(ruta);
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
