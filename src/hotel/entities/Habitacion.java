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
public class Habitacion {

    private Image foto;
    private int numero;
    private String nombre;
    private boolean estado;
    private float tamaño;
    private int tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(Image foto, int numero, String nombre, boolean estado, float tamaño, int tipoHabitacion) {
        this.foto = foto;
        this.numero = numero;
        this.nombre = nombre;
        this.estado = estado;
        this.tamaño = tamaño;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "foto=" + foto + ", numero=" + numero + ", nombre=" + nombre + ", estado=" + estado + ", tama\u00f1o=" + tamaño + ", tipoHabitacion=" + tipoHabitacion + '}';
    }
    
}
