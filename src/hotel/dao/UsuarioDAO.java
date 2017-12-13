/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.MiError;
import hotel.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class UsuarioDAO {

    /**
     * Verifica que el login sea correcto
     *
     * @param userName nombre de usuario de la persona
     * @param pass contraseña de la persona
     * @return la entidad Usuario
     */
    public Usuario verificarLogin(String userName, String pass) {
        Usuario u = new Usuario();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from usuario where (nom_usuario = ? or email = ? or cedula = ?) and (contrasena = ? and (puesto = 'Adm' or puesto = 'Recepcionista') and activo = ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, userName);
            stmt.setString(4, pass);
            stmt.setBoolean(5, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                u = cargarUsu(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            throw new MiError("Problemas al verificar usuario.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

    /**
     * Carga los datos de la persona
     *
     * @param cedula de la persona
     * @return la entidad Usuario
     */
    public Usuario cargarDatos(String cedula) {
        Usuario u = new Usuario();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from usuario where cedula = ? and (puesto = ? or puesto = ?) and activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            stmt.setString(2, "Recepcionista");
            stmt.setString(3, "Mucama");
            stmt.setBoolean(4, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String pass = desencriptar(rs.getString("contrasena"));
                u.setApellido(rs.getString("apellido"));
                u.setCedula(rs.getString("cedula"));
                u.setContrasena(pass);
                u.setEmail(rs.getString("email"));
                u.setNacionalidad(rs.getString("nacionalidad"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreUsu(rs.getString("nom_usuario"));
                u.setPuesto(rs.getString("puesto"));
                u.setTelefono(rs.getInt("telefono"));
                u.setId(rs.getInt("id"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

    /**
     * Carga los datos de la persona
     *
     * @param rs atributos que se van a cargar
     * @return la entidad Usuario
     * @throws SQLException
     * @throws Exception
     */
    public Usuario cargarUsu(ResultSet rs) throws SQLException, Exception {
        Usuario u = new Usuario();
        String pass = desencriptar(rs.getString("contrasena"));
        u.setApellido(rs.getString("apellido"));
        u.setCedula(rs.getString("cedula"));
        u.setContrasena(pass);
        u.setEmail(rs.getString("email"));
        u.setNacionalidad(rs.getString("nacionalidad"));
        u.setNombre(rs.getString("nombre"));
        u.setNombreUsu(rs.getString("nom_usuario"));
        u.setPuesto(rs.getString("puesto"));
        u.setTelefono(rs.getInt("telefono"));
        return u;
    }

    /**
     * Registra un usuario
     *
     * @param u usuario que se va a guardar
     * @return true = si se guardo y false = si no
     */
    public boolean insertarUsu(Usuario u) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into usuario(nombre,apellido,cedula,nacionalidad,telefono,email,contrasena,nom_usuario,puesto) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getApellido());
            stmt.setString(3, u.getCedula());
            stmt.setString(4, u.getNacionalidad());
            stmt.setInt(5, u.getTelefono());
            stmt.setString(6, u.getEmail());
            stmt.setString(7, u.getContrasena());
            stmt.setString(8, u.getNombreUsu());
            stmt.setString(9, u.getPuesto());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("El Usuario ya existe.");
        }
    }

    /**
     * elimina el usuario
     *
     * @param id del usuario que se va a eliminar
     * @return true = si se elimino y false = si no
     */
    public boolean eliminarUsu(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update usuario set activo = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
    }

    /**
     * modifica el usuario
     *
     * @param u usuario que se va a modificar
     * @param id de la persona
     * @return true = si se modifico y false = si no
     */
    public boolean modificarUsu(Usuario u, int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update usuario SET nombre = ?,apellido = ?,cedula = ?,nacionalidad = ?,telefono = ?,email = ?,contrasena = ?,nom_usuario = ?,puesto = ?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getApellido());
            stmt.setString(3, u.getCedula());
            stmt.setString(4, u.getNacionalidad());
            stmt.setInt(5, u.getTelefono());
            stmt.setString(6, u.getEmail());
            stmt.setString(7, u.getContrasena());
            stmt.setString(8, u.getNombreUsu());
            stmt.setString(9, u.getPuesto());
            stmt.setInt(10, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
    }

    /**
     * Verifica si el correo existe
     *
     * @param userName correo de la persona
     * @return la entidad Usuario
     */
    public Usuario verificarCorreo(String userName) {
        Usuario u = new Usuario();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from usuario where email = ? and (puesto = 'Adm' or puesto = 'Recepcionista') and activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                u.setContrasena(rs.getString("contrasena"));
                String pass = desencriptar(u.getContrasena());
                u.setApellido(rs.getString("apellido"));
                u.setContrasena(pass);
                u.setNombre(rs.getString("nombre"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

    /**
     * Desencripta la contraseña
     *
     * @param textoEncriptado contraseña que se va desencriptar
     * @return la contraseña desencriptada
     * @throws Exception
     */
    public String desencriptar(String textoEncriptado) throws Exception {

        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        }
        return base64EncryptedString;
    }

}
