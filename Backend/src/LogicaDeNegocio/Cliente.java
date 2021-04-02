package LogicaDeNegocio;

import java.util.Date;

public class Cliente {

    private int id;
    private int rol;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String correo;
    private String tel_trabajo;
    private String tel_cel;
    private String direecion;
    private Date fec_naci;

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", rol=" + rol + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", tel_trabajo=" + tel_trabajo + ", tel_cel=" + tel_cel + ", direecion=" + direecion + ", fec_naci=" + fec_naci + '}';
    }

    public Cliente() {
    }

    public Cliente(int id, int rol, String contrasena, String nombre, String apellidos, String correo, String tel_trabajo, String tel_cel, String direecion, Date fec_naci) {
        this.id = id;
        this.rol = rol;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tel_trabajo = tel_trabajo;
        this.tel_cel = tel_cel;
        this.direecion = direecion;
        this.fec_naci = fec_naci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTel_trabajo() {
        return tel_trabajo;
    }

    public void setTel_trabajo(String tel_trabajo) {
        this.tel_trabajo = tel_trabajo;
    }

    public String getTel_cel() {
        return tel_cel;
    }

    public void setTel_cel(String tel_cel) {
        this.tel_cel = tel_cel;
    }

    public String getDireecion() {
        return direecion;
    }

    public void setDireecion(String direecion) {
        this.direecion = direecion;
    }

    public Date getFec_naci() {
        return fec_naci;
    }

    public void setFec_naci(Date fec_naci) {
        this.fec_naci = fec_naci;
    }

}
