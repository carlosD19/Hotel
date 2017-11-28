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

    public boolean verificarLogin(String userName, String pass) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        if (pass.isEmpty()) {
            throw new MiError("Contraseña Requerida.");
        }
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarLogin(userName, pass);
    }
    public boolean verificarRegistro(Usuario u, String reContrasena) {
        if (u.getNombre().isEmpty()) {
            throw new MiError("Nombre Completo Requerido.");
        }
        if (u.getCedula().isEmpty()) {
            throw new MiError("Cedula Requerida.");
        }
        if (u.getEmail().isEmpty()) {
            throw new MiError("Email Requerido.");
        }
        if (u.getNacionalidad().isEmpty()) {
            throw new MiError("Nacionalidad Requerida.");
        }
        if (u.getNombreUsu().isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        if (u.getPuesto().isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        if(u.getContrasena().isEmpty()){
            throw new MiError("Contraseña Requerida.");
        }
        if(reContrasena.isEmpty()){
            throw new MiError("Re-Contraseña Requerida.");
        }
        if(!u.getContrasena().equals(reContrasena)){
            throw new MiError("Las contraseñas no coinciden");
        }
        
        UsuarioDAO udao = new UsuarioDAO();
        return udao.insertarUsu(u);
    }
    
    public boolean verificarCorreo(String userName) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarCorreo(userName);
    }
}
