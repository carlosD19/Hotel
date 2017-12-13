/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.MiError;
import hotel.entities.Provincia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ProvinciaDAO {

    /**
     * Inserta un provincia
     *
     * @param p provincia que se va a registrar
     * @return true = si se registro y false = si no
     */
    public boolean insertar(Provincia p) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into provincia(descripcion,id_pais) values(?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getIdPais());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al insertar provincia.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar provincias.");
        }
    }

    /**
     * Carga una lista de provincias
     *
     * @return una lista de provincias
     */
    public ArrayList<Provincia> cargar() {
        ArrayList<Provincia> provincias = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from provincia";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                provincias.add(cargarProvincia(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los provincias.");
        }
        return provincias;
    }

    /**
     * Carga la entidad provincia
     *
     * @param rs atributos que se van a cargar
     * @return la entidad provincia
     * @throws SQLException
     */
    private Provincia cargarProvincia(ResultSet rs) throws SQLException {
        Provincia p = new Provincia();
        p.setId(rs.getInt("id"));
        p.setIdPais(rs.getInt("id_pais"));
        p.setNombre(rs.getString("descripcion"));
        return p;
    }

}
