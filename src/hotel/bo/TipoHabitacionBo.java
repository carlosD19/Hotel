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
    
    public boolean verificarRegistro(TipoHabitacion th){
        if(th.getNombre().isEmpty()){
            throw new MiError("El tipo es requerido.");
        }
        TipoHabitacionDAO thdao = new TipoHabitacionDAO();
        return thdao.registrar(th);
    }
    
    public ArrayList<TipoHabitacion> cargarTodo(){
        TipoHabitacionDAO udao = new TipoHabitacionDAO();
        return udao.cargarTipoHabitacion();
    }
}
