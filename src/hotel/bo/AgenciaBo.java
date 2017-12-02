/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.AgenciaDAO;
import hotel.entities.Agencia;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AgenciaBo {

    public boolean registrarAgencia(Agencia a) {
        AgenciaDAO adao = new AgenciaDAO();
        return adao.registrar(a);
    }
    
    public ArrayList<Agencia> cargarImagenes() {
        AgenciaDAO adao = new AgenciaDAO();
        return  adao.cargarTodo();
    }

    
}
