/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.HabitacionDAO;
import hotel.entities.Habitacion;

/**
 *
 * @author pc
 */
public class HabitacionBo {

    public boolean registrarHabitacion(Habitacion h) {
        HabitacionDAO hdao = new HabitacionDAO();
        return hdao.registrar(h);
    }
    
}
