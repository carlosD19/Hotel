/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Habitacion;
import hotel.entities.MiError;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class HabitacionDAO {

    public boolean registrar(Habitacion h) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into habitacion(nombre,tamano,numero,estado,id_tipo,foto) values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, h.getNombre());
            stmt.setFloat(2, h.getTamaño());
            stmt.setInt(3, h.getNumero());
            stmt.setBoolean(4, h.isEstado());
            stmt.setInt(5, h.getTipoHabitacion());
            
            //Falta Guardar Imagen;
            
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar Habitaciones.");
        }
    }
    
}
