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

    /**
     * Este metodo llama al de registrar provincia
     *
     * @param p provincia que se desea registrar
     * @return true = si se registro y false = si no
     */
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
    /**
     * Este metodo manda a llamar al de cargar todos las provincias
     *
     * @return una lista de provincias
     */
    public ArrayList<Provincia> cargarTodo() {
        ProvinciaDAO pdao = new ProvinciaDAO();
        return pdao.cargar();
    }
}
