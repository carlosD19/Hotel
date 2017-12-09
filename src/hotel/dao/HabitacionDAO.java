/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Habitacion;
import hotel.entities.MiError;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public ArrayList<Habitacion> cargarHabitacion() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from habitacion where activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                habitaciones.add(cargarHabitacion2(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las habitaciones.");
        }
        return habitaciones;
    }

    private Habitacion cargarHabitacion2(ResultSet rs) throws SQLException, IOException {
        Habitacion h = new Habitacion();
        h.setEstado(rs.getString("estado"));
        h.setNombre(rs.getString("nombre"));
        h.setNumero(rs.getInt("numero"));
        h.setTamaño(rs.getFloat("tamano"));
        h.setTipoHabitacion(rs.getInt("id_tipo"));
        Image imgdb = null;
        InputStream fis = rs.getBinaryStream("foto");
        imgdb = ImageIO.read(fis);
        h.setImagen(imgdb);
        return h;
    }

    public Habitacion cargarDatos(int num) {
        Habitacion h = new Habitacion();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from habitacion where numero = ? and activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, num);
            stmt.setBoolean(2, true);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                h.setEstado(rs.getString("estado"));
                h.setId(rs.getInt("id"));
                h.setNombre(rs.getString("nombre"));
                h.setNumero(rs.getInt("numero"));
                h.setTamaño(rs.getFloat("tamano"));
                h.setTipoHabitacion(rs.getInt("id_tipo"));
                Image imgdb = null;
                InputStream fis = rs.getBinaryStream("foto");
                imgdb = ImageIO.read(fis);
                h.setImagen(imgdb);
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los usuarios");
        }
        return h;
    }
    
    public boolean modificar(Habitacion h, int id){
        try (Connection con = Conexion.conexion()) {
            String sql = "update habitacion SET numero = ?, nombre = ?, estado = ?, tamano = ?, foto = ?, id_tipo = ?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, h.getNumero());
            stmt.setString(2, h.getNombre());
            stmt.setString(3, h.getEstado());
            stmt.setFloat(4, h.getTamaño());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) h.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(5, fis);
            stmt.setInt(6, h.getTipoHabitacion());
            stmt.setInt(7, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las habitaciones");
        }
    }

    public boolean eliminar(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update habitacion set activo = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las habitaciones.");
        }
    }

}
