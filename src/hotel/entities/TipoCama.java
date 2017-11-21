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
public class TipoCama {

    private int capacidad;
    private String nombre;
    private float tamaño;

    public TipoCama() {
    }

    public TipoCama(int capacidad, String nombre, float tamaño) {
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTamaño() {
        return tamaño;
    }

    public void setTamaño(float tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "TipoCama{" + "capacidad=" + capacidad + ", nombre=" + nombre + ", tama\u00f1o=" + tamaño + '}';
    }

}
