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
public class Persona {

    private String nombre;
    private String cedula;
    private String nacionalidad;
    private String email;
    private int telefono;
    private String apellido;

    public Persona(String nombre, String cedula, String nacionalidad, String email, int telefono, String apellido) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.telefono = telefono;
        this.apellido = apellido;
    }

    public Persona() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", cedula=" + cedula + ", nacionalidad=" + nacionalidad + ", email=" + email + ", telefono=" + telefono + ", apellido=" + apellido + '}';
    }

}
