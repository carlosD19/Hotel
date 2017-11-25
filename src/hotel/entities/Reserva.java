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
    private String fechaReserva;
    private boolean desayuno;
    private int cantPersona;
    private Habitacion habitacion;
    private Cliente cliente;
    private String agencia;
    private float precio;

    public Reserva() {
    }

    public Reserva(int codigo, String fechaInicio, String fechaFinal, String fechaReserva, boolean desayuno, int cantPersona, Habitacion habitacion, Cliente cliente, String agencia, float precio) {
        this.codigo = codigo;
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

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public int getCantPersona() {
        return cantPersona;
    }

    public void setCantPersona(int cantPersona) {
        this.cantPersona = cantPersona;
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" + "codigo=" + codigo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", fechaReserva=" + fechaReserva + ", desayuno=" + desayuno + ", cantPersona=" + cantPersona + ", habitacion=" + habitacion + ", cliente=" + cliente + ", agencia=" + agencia + ", precio=" + precio + '}';
    }
    
    
}
