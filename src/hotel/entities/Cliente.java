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
public class Cliente extends Persona {

    private String tarjeta;
    private int pais;
    private int provincia;
    private int canton;
    private String direccion;
    private int id;

    public Cliente() {
    }

    public Cliente(String tarjeta, int pais, int provincia, int canton, String direccion, String nombre, String cedula, String nacionalidad, String email, int telefono, String apellido) {
        super(nombre, cedula, email, telefono, apellido);
        this.tarjeta = tarjeta;
        this.pais = pais;
        this.provincia = provincia;
        this.canton = canton;
        this.direccion = direccion;
    }
    //Metodos getters y setters que modifican o obtienen datos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getCanton() {
        return canton;
    }

    public void setCanton(int canton) {
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
