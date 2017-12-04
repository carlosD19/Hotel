/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import java.awt.Image;

/**
 *
 * @author pc
 */
public class Agencia {

    private String nombre;
    private int telefono;
    private String email;
    private String paginaWeb;
    private Image imagen;
    private int id;

    public Agencia() {
    }

    public Agencia(String nombre, int telefono, String email, String paginaWeb, Image imagen) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.paginaWeb = paginaWeb;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
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
