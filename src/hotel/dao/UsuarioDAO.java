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

/**
 *
 * @author pc
 */
public class UsuarioDAO {

    //revisar login
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
            }else{
                return null;
            }
        } catch (SQLException ex) {
            throw new MiError("Problemas al verificar usuario.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

    public Usuario cargarDatos(String cedula) {
        Usuario u = new Usuario();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from usuario where cedula = ? and puesto = 'Recepcionista' or puesto = 'Mucama'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                u.setApellido(rs.getString("apellido"));
                u.setCedula(rs.getString("cedula"));
                u.setContrasena(rs.getString("contrasena"));
                u.setEmail(rs.getString("email"));
                u.setNacionalidad(rs.getString("nacionalidad"));
                u.setNombre(rs.getString("nombre"));
                u.setNombreUsu(rs.getString("nom_usuario"));
                u.setPuesto(rs.getString("puesto"));
                u.setTelefono(rs.getInt("telefono"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

    public Usuario cargarUsu(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setApellido(rs.getString("apellido"));
        u.setCedula(rs.getString("cedula"));
        u.setContrasena(rs.getString("contrasena"));
        u.setEmail(rs.getString("email"));
        u.setNacionalidad(rs.getString("nacionalidad"));
        u.setNombre(rs.getString("nombre"));
        u.setNombreUsu(rs.getString("nom_usuario"));
        u.setPuesto(rs.getString("puesto"));
        u.setTelefono(rs.getInt("telefono"));
        return u;
    }

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

    public boolean eliminarUsu(String cedula) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update usuario set activo = false where cedula = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al cargar los usuarios");
        }
    }

    public boolean modificarUsu(Usuario u, String cedula) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update usuario SET nombre = ?,apellido = ?,cedula = ?,nacionalidad = ?,telefono = ?,email = ?,contrasena = ?,nom_usuario = ?,puesto = ?"
                    + " where cedula = ?";
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
            stmt.setString(10, cedula);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
    }

    public Usuario verificarCorreo(String userName) {
        Usuario u = new Usuario();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from usuario where email = ? and puesto = 'Adm' or puesto = 'Recepcionista'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                u.setApellido(rs.getString("apellido"));
                u.setContrasena(rs.getString("contrasena"));
                u.setNombre(rs.getString("nombre"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return u;
    }

}
