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

    /**
     * Este metodo verificar que los atributos de agencia esten correctos y
     * llama al de registra o modificar
     *
     * @param a Objeto agencia
     * @param f funcion que tiene que realizar
     * @param id de la agencia que va a modificar
     * @return true = si el se modifico o registro la agencia y false = si
     * ocurrio un problema
     */
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

    /**
     * Este metedo llama al metodo que cargar todas las agencias
     *
     * @return una lista de todas las agencias
     */
    public ArrayList<Agencia> cargarTodo() {
        AgenciaDAO adao = new AgenciaDAO();
        return adao.cargar();
    }

    /**
     * Este metodo llama al de eliminar el cual elimina la agencia
     *
     * @param id de la agencia
     * @return true = si se elimino y false = si ocurrio un error
     */
    public boolean eliminarAgencia(int id) {
        AgenciaDAO udao = new AgenciaDAO();
        return udao.eliminar(id);
    }

}
