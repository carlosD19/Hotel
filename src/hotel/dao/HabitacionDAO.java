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

    /**
     * Registra una habitacion
     *
     * @param h la habitacion que se desea registrar
     * @return true = si se registro = false = si no
     */
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

    /**
     * Carga una lista de habitaciones
     *
     * @return una lista de habitaciones
     */
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

    /**
     * Carga la entidad habitacion
     *
     * @param rs atributos que se desean guardar
     * @return la entidad habitacion
     * @throws SQLException
     * @throws IOException
     */
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

    /**
     * Carga los atributos de la entidad
     *
     * @param num habitacion que se desea cargar
     * @return la entidad habitacion
     */
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

    /**
     * Modifica la habitacion
     *
     * @param h habitacion que se va a modificar
     * @param id de la habitacion que se va a modificar
     * @return true = si se modifico y false = si no
     */
    public boolean modificar(Habitacion h, int id) {
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

    /**
     * Elimina la habitacion
     *
     * @param id de la habitacion que se va a eliminar
     * @return true = si se elimino y false = si no
     */
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

    /**
     * Modifica la habitacion a Disponible
     *
     * @param id de la habitacion
     * @return true = si se modifico y false = si no
     */
    public boolean modificarCheckOut(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update habitacion SET estado = ?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "Disponible");
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las habitaciones");
        }
    }

    /**
     * Modifica la habitacion a Reservada
     *
     * @param id de la habitacion
     * @return true = si se modifico y false = si no
     */
    public boolean modificarCheckIn(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update habitacion SET estado = ?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "Reservada");
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las habitaciones");
        }
    }

}
