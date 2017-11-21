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
public class TipoReserva {

    private boolean todoIncluido;
    private boolean pagoAdelantado;

    public TipoReserva() {
    }

    public TipoReserva(boolean todoIncluido, boolean pagoAdelantado) {
        this.todoIncluido = todoIncluido;
        this.pagoAdelantado = pagoAdelantado;
    }

    public boolean isTodoIncluido() {
        return todoIncluido;
    }

    public void setTodoIncluido(boolean todoIncluido) {
        this.todoIncluido = todoIncluido;
    }

    public boolean isPagoAdelantado() {
        return pagoAdelantado;
    }

    public void setPagoAdelantado(boolean pagoAdelantado) {
        this.pagoAdelantado = pagoAdelantado;
    }

    @Override
    public String toString() {
        return "TipoReserva{" + "todoIncluido=" + todoIncluido + ", pagoAdelantado=" + pagoAdelantado + '}';
    }

}
