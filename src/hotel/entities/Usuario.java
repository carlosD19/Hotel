/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

/**
 *
 * @author pc
 */
public class Usuario extends Persona{

    private String nombreUsu;
    private String contrasena;
    private String puesto;

    public Usuario() {
    }

    public Usuario(String nombreUsu, String contrasena, String puesto, String nombre, String cedula, String nacionalidad, String email, int telefono, String apellido) {
        super(nombre, cedula, nacionalidad, email, telefono, apellido);
        this.nombreUsu = nombreUsu;
        this.contrasena = contrasena;
        this.puesto = puesto;
    }

  

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsu=" + nombreUsu + ", contrasena=" + contrasena + ", puesto=" + puesto + '}';
    }

}
