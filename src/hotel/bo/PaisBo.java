/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.PaisDAO;
import hotel.entities.MiError;
import hotel.entities.Pais;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PaisBo {

    /**
     * Este metodo llama al de registrar pais
     *
     * @param p pais que se desea registrar
     * @return true = si se registro y false = si no
     */
    public boolean registrar(Pais p) {
        if (p.getNombre().isEmpty()) {
            throw new MiError("Nombre del país requerido.");
        }
        PaisDAO pdao = new PaisDAO();
        return pdao.insertar(p);
    }

    /**
     * Este metodo manda a llamar al de cargar todos los paises
     *
     * @return una lista de paises
     */
    public ArrayList<Pais> cargarTodo() {
        PaisDAO pdao = new PaisDAO();
        return pdao.cargar();
    }
}
