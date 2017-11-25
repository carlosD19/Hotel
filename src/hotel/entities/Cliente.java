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
public class Cliente extends Persona{
    
    private int tarjeta;
    private String pais;
    private String provincia;
    private String canton;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int tarjeta, String pais, String provincia, String canton, String direccion, String nombre, String cedula, String nacionalida, String email, int telefono) {
        super(nombre, cedula, nacionalida, email, telefono);
        this.tarjeta = tarjeta;
        this.pais = pais;
        this.provincia = provincia;
        this.canton = canton;
        this.direccion = direccion;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "tarjeta=" + tarjeta + ", pais=" + pais + ", provincia=" + provincia + ", canton=" + canton + ", direccion=" + direccion + '}';
    }
 
}
