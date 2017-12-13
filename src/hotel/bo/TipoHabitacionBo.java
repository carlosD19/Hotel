/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.TipoHabitacionDAO;
import hotel.entities.MiError;
import hotel.entities.TipoHabitacion;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class TipoHabitacionBo {

    /**
     * Este metodo verifica que los atributos esten correctos y llama al de
     * modificar o agregar
     *
     * @param th la entidad Tipo Habitacion
     * @param f la funcion que va a realizar
     * @param id del tipo de habitacion
     * @return true = si se logro modificar o agregar y false = si ocurrio un
     * error
     */
    public boolean verificarRegistro(TipoHabitacion th, int f, int id) {
        if (th.getNombre().isEmpty()) {
            throw new MiError("El tipo es requerido.");
        }
        TipoHabitacionDAO thdao = new TipoHabitacionDAO();
        if (f == 2) {
            return thdao.modificar(th, id);
        }
        return thdao.registrar(th);
    }

    /**
     * Este metodo llama al de cargar tipo de habitaciones
     *
     * @return una lista de tipo de habitaciones
     */
    public ArrayList<TipoHabitacion> cargarTodo() {
        TipoHabitacionDAO udao = new TipoHabitacionDAO();
        return udao.cargarTipoHabitacion();
    }

    /**
     * Este metodo llama al de eliminar tipo de habitacion
     *
     * @param id del tipo de habitacion
     * @return la entidad Tipo de Habitacion
     */
    public boolean eliminarTipo(int id) {
        TipoHabitacionDAO tdao = new TipoHabitacionDAO();
        return tdao.eliminar(id);
    }
}
