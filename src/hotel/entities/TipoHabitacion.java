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
public class TipoHabitacion {

    private String nombre; //Matrimonial, Sencilla, Delux...
    private boolean baño;
    private boolean tv;
    private boolean reloj;
    private boolean refri;
    private boolean telefono;
    private boolean cajaFuerte;
    private boolean aireAcondicionado;
    private boolean vistaMar;
    private int precio;
    private boolean activo;
    private int id;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String nombre, boolean baño, boolean tv, boolean reloj, boolean refri, boolean telefono, boolean cajaFuerte, boolean aireAcondicionado, boolean vistaMar, int precio, boolean activo) {
        this.nombre = nombre;
        this.baño = baño;
        this.tv = tv;
        this.reloj = reloj;
        this.refri = refri;
        this.telefono = telefono;
        this.cajaFuerte = cajaFuerte;
        this.aireAcondicionado = aireAcondicionado;
        this.vistaMar = vistaMar;
        this.precio = precio;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isBaño() {
        return baño;
    }

    public void setBaño(boolean baño) {
        this.baño = baño;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isReloj() {
        return reloj;
    }

    public void setReloj(boolean reloj) {
        this.reloj = reloj;
    }

    public boolean isRefri() {
        return refri;
    }

    public void setRefri(boolean refri) {
        this.refri = refri;
    }

    public boolean isTelefono() {
        return telefono;
    }

    public void setTelefono(boolean telefono) {
        this.telefono = telefono;
    }

    public boolean isCajaFuerte() {
        return cajaFuerte;
    }

    public void setCajaFuerte(boolean cajaFuerte) {
        this.cajaFuerte = cajaFuerte;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isVistaMar() {
        return vistaMar;
    }

    public void setVistaMar(boolean vistaMar) {
        this.vistaMar = vistaMar;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "nombre=" + nombre + ", ba\u00f1o=" + baño + ", tv=" + tv + ", reloj=" + reloj + ", refri=" + refri + ", telefono=" + telefono + ", cajaFuerte=" + cajaFuerte + ", aireAcondicionado=" + aireAcondicionado + ", vistaMar=" + vistaMar + ", precio=" + precio + ", activo=" + activo + ", id=" + id + '}';
    }

    
}
