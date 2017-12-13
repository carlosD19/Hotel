/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.MiError;
import hotel.entities.Reserva;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author pc
 */
public class ReservaDAO {

    /**
     * Registra una reserva
     *
     * @param r reserva que se va a guardar
     * @return true = si se guardo y false = si no
     */
    public boolean insertar(Reserva r) {

        java.sql.Date fInicio = new java.sql.Date(r.getFechaInicio().getTime());
        java.sql.Date fFinal = new java.sql.Date(r.getFechaFinal().getTime());
        java.sql.Date fReserva = new java.sql.Date(r.getFechaReserva().getTime());

        try (Connection con = Conexion.conexion()) {
            String sql = "insert into reserva(id_habitacion,id_cliente,id_agencia,cant_persona,desayuno,fecha_ingreso,fecha_salida,fecha_reservacion,precio) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, r.getHabitacion());
            stmt.setInt(2, r.getCliente());
            if (r.getAgencia() > 0) {
                stmt.setInt(3, r.getAgencia());
            } else {
                stmt.setInt(3, 0);
            }
            stmt.setInt(4, r.getCantPersona());
            stmt.setInt(5, r.getDesayuno());
            stmt.setDate(6, fInicio);
            stmt.setDate(7, fFinal);
            stmt.setDate(8, fReserva);
            stmt.setInt(9, (int) r.getPrecio());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al guardar reserva.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al cargar reserva.");
        }
    }

    /**
     * Carga una lista de reservas
     *
     * @return una lista de reservas
     */
    public ArrayList<Reserva> cargar() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from reserva where activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservas.add(cargarAgencia(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las reservas");
        }
        return reservas;
    }

    /**
     * Carga la entidad reserva
     *
     * @param rs atributos que se van a cargar
     * @return la entidad reserva
     * @throws SQLException
     */
    private Reserva cargarAgencia(ResultSet rs) throws SQLException {
        Reserva r = new Reserva();
        Date d = rs.getDate("fecha_salida");
        Date d2 = rs.getDate("fecha_ingreso");
        java.util.Date fFinal = new java.util.Date(d.getTime());
        java.util.Date fInicio = new java.util.Date(d2.getTime());
        r.setAgencia(rs.getInt("id_agencia"));
        r.setPrecio(rs.getInt("precio"));
        r.setDesayuno(rs.getInt("desayuno"));
        r.setHabitacion(rs.getInt("id_habitacion"));
        r.setCliente(rs.getInt("id_cliente"));
        r.setId(rs.getInt("id"));
        r.setFechaFinal(fFinal);
        r.setFechaInicio(fInicio);
        return r;
    }

    public boolean modificarReserva(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update reserva SET activo = ?"
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las reservas.");
        }
    }

    public ArrayList<Reserva> cargarCheckOut(Date date) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from reserva where fecha_salida = ? and activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, date);
            stmt.setBoolean(2, false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                reservas.add(cargarAgencia(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las reservas");
        }
        return reservas;
    }

}
