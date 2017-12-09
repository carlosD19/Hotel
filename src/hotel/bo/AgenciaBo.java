/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.AgenciaDAO;
import hotel.entities.Agencia;
import hotel.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class AgenciaBo {

    public boolean registrarAgencia(Agencia a, int f, int id) {
        if (a.getNombre().isEmpty()) {
            throw new MiError("Nombre requerido.");
        }
        if (a.getEmail().isEmpty()) {
            throw new MiError("Email requerido.");
        }
        if (a.getPaginaWeb().isEmpty()) {
            throw new MiError("Pagina Web requerida.");
        }
        if (a.getImagen() == null) {
            throw new MiError("Favor seleccionar una imagen.");
        }
        AgenciaDAO adao = new AgenciaDAO();
        if (f == 2) {
            return adao.modificar(a, id);
        }
        return adao.registrar(a);
    }

    public ArrayList<Agencia> cargarImagenes() {
        AgenciaDAO adao = new AgenciaDAO();
        return adao.cargarTodo();
    }
    public boolean eliminarAgencia(int id) {
        AgenciaDAO udao = new AgenciaDAO();
        return udao.eliminar(id);
    }

}
