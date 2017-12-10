/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.DistritoDAO;
import hotel.entities.Distrito;
import hotel.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DistritoBo {

    public boolean registrar(Distrito d) {
        if (d.getNombre().isEmpty()) {
            throw new MiError("Nombre del distrito requerido.");
        }
        if (d.getIdCanton()< 0) {
            throw new MiError("Cantón requerido.");
        }
        DistritoDAO pdao = new DistritoDAO();
        return pdao.insertar(d);
    }

    public ArrayList<Distrito> cargarTodo() {
        DistritoDAO ddao = new DistritoDAO();
        return ddao.cargar();
    }

}
