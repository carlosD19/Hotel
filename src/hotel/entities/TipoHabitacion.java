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
public class TipoHabitacion {

    private String nombre; //Matrimonial, Sencilla, Delux...
    private Descripcion descripcion;
    private Tarifa tarifa;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String nombre, Descripcion descripcion, Tarifa tarifa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", tarifa=" + tarifa + '}';
    }

}
