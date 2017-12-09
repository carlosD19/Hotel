/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.MiError;
import hotel.entities.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class PaisDAO {

    public boolean insertar(Pais p) {
       try (Connection con = Conexion.conexion()) {
            String sql = "insert into pais(descripcion) values(?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new MiError("Problemas al insertar país.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar paises.");
        }
    }
    public ArrayList<Pais> cargar(){
        ArrayList<Pais> paises = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from pais";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                paises.add(cargarPais(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los paises.");
        }
        return paises;
    }

    private Pais cargarPais(ResultSet rs) throws SQLException {
        Pais p = new Pais();
        p.setNombre(rs.getString("descripcion"));
        p.setId(rs.getInt("id"));
        return p;
    }
    
}
