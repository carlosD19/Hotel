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
public class Tarifa {

    private float precio;
    private float descuento;
    private float iva;

    public Tarifa() {
    }

    public Tarifa(float precio, float descuento, float iva) {
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "precio=" + precio + ", descuento=" + descuento + ", iva=" + iva + '}';
    }

}
