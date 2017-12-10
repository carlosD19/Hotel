/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;


import hotel.dao.CantonDAO;
import hotel.entities.Canton;
import hotel.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CantonBo {
    public boolean registrar(Canton d) {
        if (d.getNombre().isEmpty()) {
            throw new MiError("Nombre del cantón requerido.");
        }
        if (d.getIdProvincia()< 0) {
            throw new MiError("Provincia requerida.");
        }
        CantonDAO cdao = new CantonDAO();
        return cdao.insertar(d);
    }

    public ArrayList<Canton> cargarTodo() {
        CantonDAO cdao = new CantonDAO();
        return cdao.cargar();
    }
}
