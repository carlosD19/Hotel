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
    private int capacidad;
    private boolean estado;
    private float tamaño;
    private TipoCama tipoCama;

    public Habitacion() {
    }

    public Habitacion(Image foto, int capacidad, boolean estado, float tamaño, TipoCama tipoCama) {
        this.foto = foto;
        this.capacidad = capacidad;
        this.estado = estado;
        this.tamaño = tamaño;
        this.tipoCama = tipoCama;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

    public TipoCama getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(TipoCama tipoCama) {
        this.tipoCama = tipoCama;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "foto=" + foto + ", capacidad=" + capacidad + ", estado=" + estado + ", tama\u00f1o=" + tamaño + ", tipoCama=" + tipoCama + '}';
    }

}
