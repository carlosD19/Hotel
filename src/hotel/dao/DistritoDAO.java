/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Distrito;
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
public class DistritoDAO {

    public boolean insertar(Distrito d) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into distrito(descripcion,id_canton) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, d.getNombre());
            stmt.setInt(2, d.getIdCanton());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new MiError("Problemas al insertar distrito.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar distrito.");
        }
    }

    public ArrayList<Distrito> cargar() {
        ArrayList<Distrito> distritos = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from distrito";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                distritos.add(cargarDistrito(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los distritos.");
        }
        return distritos;
    }

    private Distrito cargarDistrito(ResultSet rs) throws SQLException {
        Distrito d = new Distrito();
        d.setId(rs.getInt("id"));
        d.setIdCanton(rs.getInt("id_canton"));
        d.setNombre(rs.getString("descripcion"));
        return d;
    }
    
}
