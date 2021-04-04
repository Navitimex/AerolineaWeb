package DAO_AccesoADatos;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import LogicaDeNegocio.Horario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoHorario extends Conexion {

    private static final String INSERTAR_HORARIO = "{call insertar_horario(?,?,?,?,?)}";
    private static final String ACTUALIZAR_HORARIO = "{call actualizar_horario(?,?,?,?,?)}";
    private static final String MOSTRAR_HORARIO_X_ID = "{call mostrar_horario_x_id(?)}";
    private static final String VISTA_HORARIO = "{select * from keed_moviles.vista_horario}";
    private static final String ELIMINAR_HORARIO = "{call eliminar_horario(?)}";

    public void insertar_horario(Horario horario) throws NoDataException, GlobalException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(INSERTAR_HORARIO);
            pstmt.setString(1, horario.getDia_semana());
            pstmt.setTime(2, horario.getHora_salida());
            pstmt.setTime(3, horario.getHora_llegada());
            pstmt.setString(4, horario.getRuta_codigo());
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

    public void actualizar_horario(Horario horario) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(ACTUALIZAR_HORARIO);
            pstmt.setString(1, horario.getDia_semana());
            pstmt.setTime(2, horario.getHora_salida());
            pstmt.setTime(3, horario.getHora_llegada());
            pstmt.setString(4, horario.getRuta_codigo());
            boolean resultado = pstmt.execute();

            if (resultado == true) {
                throw new NoDataException("No se modifico el horario");
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

    public void eliminar_Horario(int horario) throws GlobalException, NoDataException {
        conectar();
        CallableStatement pstmt = null;

        try {
            pstmt = cnx.prepareCall(ELIMINAR_HORARIO);
            pstmt.setInt(1, horario);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se elimino el horario");
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

    public Horario mostrar_horario_x_id(String id) throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        Horario horario = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(MOSTRAR_HORARIO_X_ID);
            pstmt.clearParameters();
            pstmt.setString(1, id);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            rs.next();
            horario = new Horario(
                    rs.getInt("id"),
                    rs.getString("dia_semana"),
                    rs.getTime("hora_salida"),
                    rs.getTime("hora_llegada"),
                    rs.getString("Ruta_codigo"));
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
        if (horario == null) {
            throw new NoDataException("No hay datos");
        }
        // </editor-fold>
        return horario;
    }

    public ArrayList vista_horario() throws GlobalException, NoDataException {
        conectar();
        ResultSet rs = null;
        ArrayList<Horario> coleccion = new ArrayList<Horario>();
        Horario horario = null;
        CallableStatement pstmt = null;
        try {
            pstmt = cnx.prepareCall(VISTA_HORARIO);
            //pstmt.execute();
            rs = pstmt.executeQuery();
            while (rs.next()) {
                horario = new Horario(
                    rs.getInt("id"),
                    rs.getString("dia_semana"),
                    rs.getTime("hora_salida"),
                    rs.getTime("hora_llegada"),
                    rs.getString("Ruta_codigo"));
                coleccion.add(horario);
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
