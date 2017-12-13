/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Canton;
import hotel.entities.MiError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class CantonDAO {

    /**
     * Inserta el canton
     *
     * @param c el canton que se va a insertar
     * @return true = si se guardo y false = si no
     */
    public boolean insertar(Canton c) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into canton(descripcion,id_provincia) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNombre());
            stmt.setInt(2, c.getIdProvincia());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new MiError("Problemas al insertar cantón.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar cantón.");
        }
    }

    /**
     * Cargar los cantones
     *
     * @return una lista de cantones
     */
    public ArrayList<Canton> cargar() {
        ArrayList<Canton> cantones = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from canton";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cantones.add(cargarCanton(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los cantones.");
        }
        return cantones;
    }

    /**
     * Carga la entidad Canton
     *
     * @param rs atributos que se van a cargar en la entidad
     * @return la entidad Canton
     * @throws SQLException
     */
    private Canton cargarCanton(ResultSet rs) throws SQLException {
        Canton c = new Canton();
        c.setId(rs.getInt("id"));
        c.setIdProvincia(rs.getInt("id_provincia"));
        c.setNombre(rs.getString("descripcion"));
        return c;
    }
}
