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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ClienteDAO {

    /**
     * Inserta al Cliente
     *
     * @param c cliente que se va a insertar
     * @return true = si se inserto y false = si no
     */
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

    /**
     * modifica el cliente
     *
     * @param c cliente que se va a modificar
     * @param id del cliente
     * @return true = si se modifico y false = si no
     */
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

    /**
     * Carga el cliente
     *
     * @param cedula del cliente que se desea cargar
     * @return el cliente
     */
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

    /**
     * Elimina el cliente
     *
     * @param id del cliente que se desea eliminar
     * @return true = si se elimino y false = si no
     */
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

    /**
     * Carga una lista con los clientes
     *
     * @return una lista de clientes
     */
    public ArrayList<Cliente> cargar() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from cliente where activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clientes.add(cargarCliente(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los clientes");
        }
        return clientes;
    }

    /**
     * cargar la entidad cliente
     *
     * @param rs atributos que se van a cargar
     * @return Cliente
     * @throws SQLException
     */
    public Cliente cargarCliente(ResultSet rs) throws SQLException {
        Cliente c = new Cliente();
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
        return c;
    }
}
