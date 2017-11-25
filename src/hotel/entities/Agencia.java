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
public class Agencia {

    private String nombre;
    private int telefono;
    private String email;
    private String paginaWeb;

    public Agencia() {
    }

    public Agencia(String nombre, int telefono, String email, String paginaWeb) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.paginaWeb = paginaWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String toString() {
        return "Agencia{" + "nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", paginaWeb=" + paginaWeb + '}';
    }

}
