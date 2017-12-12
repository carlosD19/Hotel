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

/**
 *
 * @author pc
 */
public class ReservaBo {

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

    public ArrayList<Reserva> cargarTodo() {
        ReservaDAO rdao = new ReservaDAO();
        return rdao.cargar();
    }
}
