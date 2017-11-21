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
public class Descripcion {

    private boolean baño;
    private boolean tv;
    private boolean reloj;
    private boolean refri;
    private boolean telefono;
    private boolean cajaFuerte;
    private boolean aireAcondicionado;

    public Descripcion() {
    }

    public Descripcion(boolean baño, boolean tv, boolean reloj, boolean refri, boolean telefono, boolean cajaFuerte, boolean aireAcondicionado) {
        this.baño = baño;
        this.tv = tv;
        this.reloj = reloj;
        this.refri = refri;
        this.telefono = telefono;
        this.cajaFuerte = cajaFuerte;
        this.aireAcondicionado = aireAcondicionado;
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

    @Override
    public String toString() {
        return "Descripcion{" + "ba\u00f1o=" + baño + ", tv=" + tv + ", reloj=" + reloj + ", refri=" + refri + ", telefono=" + telefono + ", cajaFuerte=" + cajaFuerte + ", aireAcondicionado=" + aireAcondicionado + '}';
    }

}
