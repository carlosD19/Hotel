/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.bo;

import hotel.dao.UsuarioDAO;
import hotel.entities.MiError;
import hotel.entities.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author pc
 */
public class UsuarioBo {

    /**
     * Verifica que los parametros este correctos
     *
     * @param userName nombre de usuario
     * @param pass contraseña del usuario
     * @return true = si estan correctos y false = si hay un error
     */
    public Usuario verificarLogin(String userName, String pass) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de usuario requerido.");
        }
        if (pass.isEmpty()) {
            throw new MiError("Contraseña requerida.");
        }
        pass = encriptar(pass);
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarLogin(userName, pass);
    }

    /**
     * Este metodo verifica que todos los atributos esten correctos y llama al
     * de modificar o eliminar
     *
     * @param u Usuario que se desea registrar
     * @param reContrasena verificacion de contraseña
     * @param funcion funcion que se desea realizar
     * @param id del usuario que se desea modificar
     * @return
     */
    public boolean verificarRegistro(Usuario u, String reContrasena, int funcion, int id) {
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
        u.setContrasena(encriptar(u.getContrasena()));
        UsuarioDAO udao = new UsuarioDAO();
        if (funcion == 2) {
            return udao.modificarUsu(u, id);
        }
        return udao.insertarUsu(u);
    }

    /**
     * Verifica que el correo exista
     *
     * @param userName correo de la persona
     * @return la entidad Usuario
     */
    public Usuario verificarCorreo(String userName) {
        if (userName.isEmpty()) {
            throw new MiError("Nombre de Usuario Requerido.");
        }
        UsuarioDAO udao = new UsuarioDAO();
        return udao.verificarCorreo(userName);
    }

    /**
     * Este metodo carga la entidad Usuario
     *
     * @param cedula del usuario que se desea cargar
     * @return la entidad Usuario
     */
    public Usuario cargarUsuario(String cedula) {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.cargarDatos(cedula);
    }

    /**
     * Este metodo elimina un usuario
     *
     * @param id del usuario que se desea eliminar
     * @return true = si se elimino y false = si ocurrio un error
     */
    public boolean eliminarUsuario(int id) {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.eliminarUsu(id);
    }

    /**
     * Este metodo encripta la contraseña del usuario
     *
     * @param texto contraseña que se desea encriptar
     * @return la contraseña encriptada
     */
    public String encriptar(String texto) {

        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return base64EncryptedString;
    }

}
