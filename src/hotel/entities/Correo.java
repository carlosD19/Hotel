/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.entities;

/**
 *
 * @author pc
 */
public class Correo {

    private String usuarioCorreo;
    private String contraseña;
    private String rutaArchivo;
    private String nombreArchivo;
    private String asunto;
    private String destino;
    private String mensaje;

    public Correo() {
    }

    public Correo(String usuarioCorreo, String contraseña, String rutaArchivo, String nombreArchivo, String asunto, String destino, String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.contraseña = contraseña;
        this.rutaArchivo = rutaArchivo;
        this.nombreArchivo = nombreArchivo;
        this.asunto = asunto;
        this.destino = destino;
        this.mensaje = mensaje;
    }

    //Metodos getters y setters que modifican o obtienen datos
    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
