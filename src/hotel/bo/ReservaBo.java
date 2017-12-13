/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ReservaDAO;
import hotel.entities.MiError;
import hotel.entities.Reserva;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pc
 */
public class ReservaBo {

    /**
     * Este metodo llama al de registrar reserva
     *
     * @param r la entidad que se va a registrar
     * @return true = si se registro y false = si ocurrio un error
     */
    public boolean registrar(Reserva r) {
        if (r.getCliente() <= 0) {
            throw new MiError("Cliente requerido.");
        }
        if (r.getFechaFinal() == null) {
            throw new MiError("Fecha de salida requerida.");
        }
        if (r.getFechaInicio() == null) {
            throw new MiError("Fecha de entrada requerida.");
        }
        if (r.getHabitacion() <= 0) {
            throw new MiError("Habitacion requerida.");
        }
        ReservaDAO rdao = new ReservaDAO();
        return rdao.insertar(r);
    }

    /**
     * Este metodo llama al de cargar todas las reservas
     *
     * @return una lista de reservas
     */
    public ArrayList<Reserva> cargarTodo() {
        ReservaDAO rdao = new ReservaDAO();
        return rdao.cargar();
    }

    /**
     * Este metodo llama al de modificar reserva
     *
     * @param id de la reserva
     * @return true = si se modifico y false = si no se pudo
     */
    public boolean modificar(int id) {
        ReservaDAO rdao = new ReservaDAO();
        return rdao.modificarReserva(id);
    }

    /**
     * Este metodo llama al de cargar todas las reservas que se pueden hacer
     * check out
     *
     * @param date la fecha actual
     * @return una lista de reservas
     */
    public ArrayList<Reserva> cargarOut(Date date) {
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        ReservaDAO rdao = new ReservaDAO();
        return rdao.cargarCheckOut(fecha);
    }
}
