package LogicaDeNegocio;

import java.util.Date;
import org.json.JSONObject;

public class Cliente {

    private int id;
    private String contrasena;
    private int rol;
    private String nombre;
    private String apellidos;
    private String correo;
    private Date fec_naci;
    private String direccion;
    private String tel_trabajo;
    private String tel_cel;

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", contrasena=" + contrasena + ", rol=" + rol + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", fec_naci=" + fec_naci + ", direccion=" + direccion + ", tel_trabajo=" + tel_trabajo + ", tel_cel=" + tel_cel + '}';
    }

    public Cliente() {
    }

    public Cliente(int id, String contrasena, int rol, String nombre, String apellidos, String correo, Date fec_naci, String direccion, String tel_trabajo, String tel_cel) {
        this.id = id;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fec_naci = fec_naci;
        this.direccion = direccion;
        this.tel_trabajo = tel_trabajo;
        this.tel_cel = tel_cel;
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getId());
        r.put("contrasena", getContrasena());
        r.put("rol", getRol());
        r.put("nombre", getNombre());
        r.put("apellidos", getApellidos());
        r.put("correo", getCorreo());
        r.put("fec_nac", getFec_naci());
        r.put("direccion", getDireccion());
        r.put("tel_trabajo", getTel_trabajo());
        r.put("tel_cel", getTel_cel());

        return r;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Date getFec_naci() {
        return fec_naci;
    }

    public void setFec_naci(Date fec_naci) {
        this.fec_naci = fec_naci;
    }

}
