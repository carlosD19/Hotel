/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.MiError;
import hotel.entities.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class TipoHabitacionDAO {

    /**
     * Registra un tipo de habitacion
     *
     * @param th tipo de habitacion que se va a guardar
     * @return true = si se guardo y false = si no
     */
    public boolean registrar(TipoHabitacion th) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into tipo_habitacion(precio,nombre,bano,tv,aire,refri,reloj,vista_mar,telefono,caja_fuerte) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, th.getPrecio());
            stmt.setString(2, th.getNombre());
            stmt.setBoolean(3, th.isBaño());
            stmt.setBoolean(4, th.isTv());
            stmt.setBoolean(5, th.isAireAcondicionado());
            stmt.setBoolean(6, th.isRefri());
            stmt.setBoolean(7, th.isReloj());
            stmt.setBoolean(8, th.isVistaMar());
            stmt.setBoolean(9, th.isTelefono());
            stmt.setBoolean(10, th.isCajaFuerte());
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar tipos de habitaciones.");
        }
    }

    /**
     * Carga una lista de tipo de habitaciones
     *
     * @return una lista de tipo de habitaciones
     */
    public ArrayList<TipoHabitacion> cargarTipoHabitacion() {
        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from tipo_habitacion where activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tipos.add(cargarTipoHabitacion(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al cargar los tipos de habitación.");
        }
        return tipos;
    }

    /**
     * Carga la entidad tipo de habitacion
     *
     * @param rs atributos que se van a cargar
     * @return la entidad tipo de habitacion
     * @throws SQLException
     */
    private TipoHabitacion cargarTipoHabitacion(ResultSet rs) throws SQLException {
        TipoHabitacion th = new TipoHabitacion();
        th.setId(rs.getInt("id"));
        th.setAireAcondicionado(rs.getBoolean("aire"));
        th.setActivo(rs.getBoolean("activo"));
        th.setTv(rs.getBoolean("tv"));
        th.setRefri(rs.getBoolean("refri"));
        th.setCajaFuerte(rs.getBoolean("caja_fuerte"));
        th.setVistaMar(rs.getBoolean("vista_mar"));
        th.setTelefono(rs.getBoolean("telefono"));
        th.setBaño(rs.getBoolean("bano"));
        th.setReloj(rs.getBoolean("reloj"));
        th.setNombre(rs.getString("nombre"));
        th.setPrecio((int) rs.getInt("precio"));
        return th;
    }

    /**
     * modifica el tipo de habitacion
     *
     * @param th tipo que se va a modificar
     * @param id del tipo que se va a modificar
     * @return true = si se modifico y false = si no
     */
    public boolean modificar(TipoHabitacion th, int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update tipo_habitacion set precio = ?, nombre = ?, bano= ?, tv = ?, aire = ?, refri= ?, reloj = ?, vista_mar = ?, telefono = ?, caja_fuerte = ?"
                    + "where id = ?";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, th.getPrecio());
            stmt.setString(2, th.getNombre());
            stmt.setBoolean(3, th.isBaño());
            stmt.setBoolean(4, th.isTv());
            stmt.setBoolean(5, th.isAireAcondicionado());
            stmt.setBoolean(6, th.isRefri());
            stmt.setBoolean(7, th.isReloj());
            stmt.setBoolean(8, th.isVistaMar());
            stmt.setBoolean(9, th.isTelefono());
            stmt.setBoolean(10, th.isCajaFuerte());
            stmt.setInt(11, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar tipo de habitaciones.");
        }
    }

    /**
     * elimina el tipo de habitacion
     *
     * @param id del tipo que se va a eliminar
     * @return true = si se elimino y false = si no
     */
    public boolean eliminar(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update tipo_habitacion set activo = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar los tipo de habitaciones.");
        }
    }

}
