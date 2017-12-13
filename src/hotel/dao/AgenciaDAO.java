/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Agencia;
import hotel.entities.MiError;
import hotel.entities.TipoHabitacion;
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
public class AgenciaDAO {

    /**
     * Este metodo registar la agencia
     *
     * @param a agencia que se desea registrar
     * @return true = si se registro y false = si no
     */
    public boolean registrar(Agencia a) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into agencia(nombre,email,pagina,telefono,activo,logo) values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getPaginaWeb());
            stmt.setInt(4, a.getTelefono());
            stmt.setBoolean(5, true);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) a.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(6, fis);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new MiError("Problemas al insertar agencia.");
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar agencias.");
        }
    }

    /**
     * Carga las agencias
     *
     * @return una lista de agencias
     */
    public ArrayList<Agencia> cargar() {
        ArrayList<Agencia> agencias = new ArrayList<>();
        try (Connection con = Conexion.conexion()) {
            String sql = "select * from agencia where activo = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                agencias.add(cargarAgencia(rs));
            }
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las agencias");
        }
        return agencias;
    }

    /**
     * Carga los atributos de la entidad Agencia
     *
     * @param rs los datos que van ser cargados en la entidad
     * @return la entidad Agencia
     * @throws SQLException
     * @throws IOException
     */
    private Agencia cargarAgencia(ResultSet rs) throws SQLException, IOException {
        Agencia a = new Agencia();
        a.setEmail(rs.getString("email"));
        a.setNombre(rs.getString("nombre"));
        a.setPaginaWeb(rs.getString("pagina"));
        a.setTelefono(rs.getInt("telefono"));
        a.setId(rs.getInt("id"));
        Image imgdb = null;
        InputStream fis = rs.getBinaryStream("logo");
        imgdb = ImageIO.read(fis);
        a.setImagen(imgdb);
        return a;
    }

    /**
     * Modifica la agencia que recibe por parametro
     *
     * @param a agencia que se va a modificar
     * @param id de la agencia
     * @return true = si se modifico y false = si no se modifico
     */
    public boolean modificar(Agencia a, int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update agencia SET nombre = ? ,email = ? ,pagina = ? ,telefono = ? ,logo = ? "
                    + " where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getPaginaWeb());
            stmt.setInt(4, a.getTelefono());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) a.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            stmt.setBinaryStream(5, fis);
            stmt.setInt(6, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las agencias");
        }
    }

    /**
     * Elimina la agencia
     *
     * @param id de la agencia que se va a eliminar
     * @return true= si se elimino y false = si no
     */
    public boolean eliminar(int id) {
        try (Connection con = Conexion.conexion()) {
            String sql = "update agencia set activo = false where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar las agencias");
        }
    }

}
