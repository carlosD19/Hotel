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

    public ArrayList<TipoHabitacion> cargarTipoHabitacion() {
        ArrayList<TipoHabitacion> tipos = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from tipo_habitacion";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tipos.add(cargarUsuario(rs));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al cargar los usuarios");
        }
        return tipos;
    }

    private TipoHabitacion cargarUsuario(ResultSet rs) throws SQLException {
        TipoHabitacion th = new TipoHabitacion();
        th.setAireAcondicionado(rs.getBoolean("aire"));
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

}
