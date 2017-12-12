/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Reserva {

    private int id;
    private Date fechaInicio;
    private Date fechaFinal;
    private Date fechaReserva;
    private int desayuno;
    private int cantPersona;
    private int habitacion;
    private int cliente;
    private int agencia;
    private int precio;

    public Reserva() {
    }

    public Reserva(Date fechaInicio, Date fechaFinal, Date fechaReserva, int desayuno, int cantPersona, int habitacion, int cliente, int agencia, int precio) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.fechaReserva = fechaReserva;
        this.desayuno = desayuno;
        this.cantPersona = cantPersona;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.agencia = agencia;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(int desayuno) {
        this.desayuno = desayuno;
    }

    public int getCantPersona() {
        return cantPersona;
    }

    public void setCantPersona(int cantPersona) {
        this.cantPersona = cantPersona;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", fechaReserva=" + fechaReserva + ", desayuno=" + desayuno + ", cantPersona=" + cantPersona + ", habitacion=" + habitacion + ", cliente=" + cliente + ", agencia=" + agencia + ", precio=" + precio + '}';
    }

}
