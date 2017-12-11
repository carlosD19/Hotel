/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.ClienteDAO;
import hotel.entities.Cliente;
import hotel.entities.MiError;

/**
 *
 * @author pc
 */
public class ClienteBo {

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

    public Cliente cargarCliente(String cedula) {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.cargarDatos(cedula);
    }

    public boolean eliminarCliente(int id) {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.eliminar(id);
    }

}
