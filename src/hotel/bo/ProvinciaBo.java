/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ProvinciaDAO;
import hotel.entities.MiError;
import hotel.entities.Provincia;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ProvinciaBo {

    public boolean registrar(Provincia p) {
        if (p.getNombre().isEmpty()) {
            throw new MiError("Nombre de la provincia requerido.");
        }
        if (p.getIdPais() < 0) {
            throw new MiError("País requerido.");
        }
        ProvinciaDAO pdao = new ProvinciaDAO();
        return pdao.insertar(p);
    }

    public ArrayList<Provincia> cargarTodo() {
        ProvinciaDAO pdao = new ProvinciaDAO();
        return pdao.cargar();
    }
}
