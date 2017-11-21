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
public class Reserva {

    private int codigo;
    private String fechaInicio;
    private String fechaFinal;
    private Habitacion habitacion;
    private Cliente cliente;
    private TipoReserva tipo;

    public Reserva() {
    }

    public Reserva(int codigo, String fechaInicio, String fechaFinal, Habitacion habitacion, Cliente cliente, TipoReserva tipo) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Reserva{" + "codigo=" + codigo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", habitacion=" + habitacion + ", cliente=" + cliente + ", tipo=" + tipo + '}';
    }

}
