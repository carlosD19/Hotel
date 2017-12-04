/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.UsuarioDAO;
import hotel.entities.MiError;
import hotel.entities.Usuario;

/**
 *
 * @author pc
 */
public class UsuarioBo {

    public Usuario verificarLogin(String userName, String pass) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de usuario requerido.");
        }
        if (pass.isEmpty()) {
            throw new MiError("Contraseña requerida.");
        }
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarLogin(userName, pass);
    }

    public boolean verificarRegistro(Usuario u, String reContrasena, int funcion, String cedula) {
        if (u.getNombre().isEmpty()) {
            throw new MiError("Nombre completo requerido.");
        }
        if (u.getCedula().isEmpty()) {
            throw new MiError("Cedula requerida.");
        }
        if (u.getEmail().isEmpty()) {
            throw new MiError("Email requerido.");
        }
        if (u.getNacionalidad().isEmpty()) {
            throw new MiError("Nacionalidad requerida.");
        }
        if (u.getNombreUsu().isEmpty()) {
            throw new MiError("Nombre de usuario requerido.");
        }
        if (u.getPuesto().isEmpty()) {
            throw new MiError("Nombre de usuario requerido.");
        }
        if (u.getContrasena().isEmpty()) {
            throw new MiError("Contraseña requerida.");
        }
        if (reContrasena.isEmpty()) {
            throw new MiError("Re-Contraseña requerida.");
        }
        if (!u.getContrasena().equals(reContrasena)) {
            throw new MiError("Las contraseñas no coinciden");
        }

        UsuarioDAO udao = new UsuarioDAO();
        if (funcion == 2) {
            return udao.modificarUsu(u, cedula);
        }
        return udao.insertarUsu(u);
    }

    public Usuario verificarCorreo(String userName) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarCorreo(userName);
    }
    public Usuario cargarUsuario(String cedula){
        UsuarioDAO udao = new UsuarioDAO();
        return udao.cargarDatos(cedula);
    }
    public boolean eliminarUsuario(String cedula){
        UsuarioDAO udao = new UsuarioDAO();
        return udao.eliminarUsu(cedula);
    }
}
