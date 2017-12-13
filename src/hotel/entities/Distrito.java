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
public class Distrito {

    private int id;
    private String nombre;
    private int idCanton;

    public Distrito() {
    }

    public Distrito(String nombre, int idCanton) {
        this.nombre = nombre;
        this.idCanton = idCanton;
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

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

}
