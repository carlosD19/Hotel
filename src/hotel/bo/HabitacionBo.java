/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.HabitacionDAO;
import hotel.entities.Habitacion;
import hotel.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class HabitacionBo {

    public boolean registrarHabitacion(Habitacion h) {
        if (h.getImagen() == null) {
            throw new MiError("Favor seleccionar una imagen.");
        }
        if (h.getNumero()< 0) {
            throw new MiError("Numero de habitacion requerido.");
        }
        if (h.getTamaño() < 0) {
            throw new MiError("Tamaño de habitacion requerido.");
        }
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.registrar(h);
    }
    public ArrayList<Habitacion> cargarHabitaciones(){
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.cargarHabitacion();
    }
    
}
