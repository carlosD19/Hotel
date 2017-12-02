/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.dao;

import hotel.entities.Agencia;
import hotel.entities.MiError;
import hotel.entities.TipoHabitacion;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

    public boolean registrar(Agencia a) {
        try (Connection con = Conexion.conexion()) {
            String sql = "insert into agencia(nombre,email,pagina,logo,telefono) values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getPaginaWeb());
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) a.getImagen(), "jpg", os);
            InputStream fis = new ByteArrayInputStream(os.toByteArray());
            
            stmt.setBinaryStream(4, fis);
            
            stmt.setInt(5, a.getTelefono());
            
            return stmt.executeUpdate() > 0;
        } catch (Exception ex) {
            throw new MiError("Problemas al cargar agencias.");
        }
    }
    
    public ArrayList<Agencia> cargarTodo() {
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
            System.out.println(ex.getMessage());
            throw new MiError("Problemas al cargar los usuarios");
        }
        return agencias;
    }
    
    private Agencia cargarAgencia(ResultSet rs) throws SQLException {
        Agencia a = new Agencia();
        a.setEmail(rs.getString("email"));
        a.setNombre(rs.getString("nombre"));
        a.setPaginaWeb(rs.getString("pagina"));
        a.setTelefono(rs.getInt("telefono"));
        
        return a;
    }

    
}
