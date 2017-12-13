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

    /**
     * Este metodo verifica que los atributos esten correctos y llama al de
     * modificar o agregar
     *
     * @param h la entidad Habitacion
     * @param f la funcion que va a realizar
     * @param id de la habitacion
     * @return true = si se logro modificar o agregar y false = si ocurrio un
     * error
     */
    public boolean registrarHabitacion(Habitacion h, int f, int id) {
        if (h.getImagen() == null) {
            throw new MiError("Favor seleccionar una imagen.");
        }
        if (h.getNumero() < 0) {
            throw new MiError("Numero de habitacion requerido.");
        }
        if (h.getTamaño() < 0) {
            throw new MiError("Tamaño de habitacion requerido.");
        }
        HabitacionDAO hdao = new HabitacionDAO();
        if (f == 2) {
            return hdao.modificar(h, id);
        }
        return hdao.registrar(h);
    }

    /**
     * Este metodo llama al de cargar habitaciones
     *
     * @return una lista de habitaciones
     */
    public ArrayList<Habitacion> cargarHabitaciones() {
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.cargarHabitacion();
    }

    /**
     * Este metodo llama al de cargar habitacion
     *
     * @param num de habitacion
     * @return la entidad Habitacion
     */
    public Habitacion cargarHabitacion(int num) {
        HabitacionDAO udao = new HabitacionDAO();
        return udao.cargarDatos(num);

    }

    /**
     * Este metodo llama al de eliminar habitacion
     *
     * @param id de la habitacion que se desea eliminar
     * @return true = si se elimino y false = si ocurrio un error
     */
    public boolean eliminarHabitacion(int id) {
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.eliminar(id);
    }

    /**
     * Este metodo llama al de modificar el check out
     *
     * @param id de la habitacion que se desea modificar
     * @return true = si se modifico y false = si no
     */
    public boolean checkOut(int id) {
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.modificarCheckOut(id);
    }

    /**
     * Este metodo llama al de modificar el check in
     *
     * @param id de la habitacion que se desea modificar
     * @return true = si se modifico y false = si no
     */
    public boolean checkIn(int id) {
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.modificarCheckIn(id);
    }
}
