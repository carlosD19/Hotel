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
public class Provincia {

    private int id;
    private String nombre;
    private int idPais;

    public Provincia() {
    }

    public Provincia(String nombre, int idPais) {
        this.nombre = nombre;
        this.idPais = idPais;
    }
    //Metodos getters y setters que modifican o obtienen datos

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

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

}
