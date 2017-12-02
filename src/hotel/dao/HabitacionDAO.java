/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Habitacion;
import hotel.entities.MiError;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 *
 * @author pc
 */
public class HabitacionDAO {

    public boolean registrar(Habitacion h) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into habitacion(numero,nombre,estado,tamano,foto,id_tipo) values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, h.getNumero());
            stmt.setString(2, h.getNombre());
            stmt.setString(3, h.getEstado());
            stmt.setFloat(4, h.getTamaño());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) h.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(5, fis);
            stmt.setInt(6, h.getTipoHabitacion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas SQL.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar Habitaciones.");
        }
    }

}
