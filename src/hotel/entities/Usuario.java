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
public class Usuario extends Persona {

    private String nombreUsu;
    private String contrasena;
    private String puesto;
    private String nacionalidad;
    private int id;

    public Usuario() {
    }

    public Usuario(String nombreUsu, String contrasena, String puesto, String nacionalidad, int id, String nombre, String cedula, String email, int telefono, String apellido) {
        super(nombre, cedula, email, telefono, apellido);
        this.nombreUsu = nombreUsu;
        this.contrasena = contrasena;
        this.puesto = puesto;
        this.nacionalidad = nacionalidad;
        this.id = id;
    }
    //Metodos getters y setters que modifican o obtienen datos

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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
