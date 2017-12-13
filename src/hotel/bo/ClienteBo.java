/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ClienteDAO;
import hotel.entities.Cliente;
import hotel.entities.MiError;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ClienteBo {

    /**
     * Este metodo verifica que los atributos esten correctos y llama al de
     * modificar o agregar
     *
     * @param c es la entidad Cliente
     * @param funcion la funcion que debe realizar
     * @param id del cliente
     * @return true = si se logro modificar o agregar y false = si ocurrio un
     * error
     */
    public boolean verificarRegistro(Cliente c, int funcion, int id) {
        if (c.getNombre().isEmpty()) {
            throw new MiError("Nombre completo requerido.");
        }
        if (c.getCedula().isEmpty()) {
            throw new MiError("Cedula requerida.");
        }
        if (c.getEmail().isEmpty()) {
            throw new MiError("Email requerido.");
        }
        if (c.getApellido().isEmpty()) {
            throw new MiError("Apellido requerido.");
        }
        if (c.getDireccion().isEmpty()) {
            throw new MiError("Dirección requerida.");
        }
        if (c.getTarjeta().isEmpty()) {
            throw new MiError("Numero de tarjeta requerido.");
        }

        ClienteDAO cdao = new ClienteDAO();
        if (funcion == 2) {
            return cdao.modificar(c, id);
        }
        return cdao.insertar(c);
    }

    /**
     * Este metodo llama al de cargar datos del cliente
     *
     * @param cedula la cedula del cliente que se desea cargar
     * @return la entidad Cliente
     */
    public Cliente cargarCliente(String cedula) {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.cargarDatos(cedula);
    }

    /**
     * Este metodo llama al de eliminar cliente
     *
     * @param id del cliente que se desea eliminar
     * @return true = si se elimino y false = si ocurrio un error
     */
    public boolean eliminarCliente(int id) {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.eliminar(id);
    }

    /**
     * Este metodo llama al de cargar clientes
     *
     * @return una lista de todos los clientes
     */
    public ArrayList<Cliente> cargarTodo() {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.cargar();
    }

}
