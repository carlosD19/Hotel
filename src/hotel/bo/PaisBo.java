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

    public boolean registrar(Pais p) {
        if (p.getNombre().isEmpty()) {
            throw new MiError("Nombre del país requerido.");
        }
        PaisDAO pdao = new PaisDAO();
        return pdao.insertar(p);
    }
    
    public ArrayList<Pais> cargarTodo(){
        PaisDAO pdao = new PaisDAO();
        return pdao.cargar();
    }
}
