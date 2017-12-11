/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Cliente;
import hotel.entities.MiError;
import hotel.entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class ClienteDAO {

    public boolean insertar(Cliente c) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into cliente(nombre, apellido, cedula, telefono, email, direccion,"
                    + " tarjeta, id_pais, id_provincia, id_canton) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getCedula());
            stmt.setInt(4, c.getTelefono());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getDireccion());
            stmt.setString(7, c.getTarjeta());
            stmt.setInt(8, c.getPais());
            stmt.setInt(9, c.getProvincia());
            stmt.setInt(10, c.getCanton());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("El cliente ya existe.");
        }
    }

    public boolean modificar(Cliente c, int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update cliente SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, email = ?, direccion = ?,"
                    + " tarjeta = ?, id_pais = ?, id_provincia = ?, id_canton = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getCedula());
            stmt.setInt(4, c.getTelefono());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getDireccion());
            stmt.setString(7, c.getTarjeta());
            stmt.setInt(8, c.getPais());
            stmt.setInt(9, c.getProvincia());
            stmt.setInt(10, c.getCanton());
            stmt.setInt(11, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los clientes.");
        }
    }

    public Cliente cargarDatos(String cedula) {
        Cliente c = new Cliente();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from cliente where cedula = ? and activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cedula);
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c.setApellido(rs.getString("apellido"));
                c.setCedula(rs.getString("cedula"));
                c.setEmail(rs.getString("email"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getInt("telefono"));
                c.setCanton(rs.getInt("id_canton"));
                c.setPais(rs.getInt("id_pais"));
                c.setProvincia(rs.getInt("id_provincia"));
                c.setDireccion(rs.getString("direccion"));
                c.setTarjeta(rs.getString("tarjeta"));
                c.setId(rs.getInt("id"));
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los clientes.");
        }
        return c;
    }

    public boolean eliminar(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update cliente set activo = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los clientes.");
        }
    }

}
