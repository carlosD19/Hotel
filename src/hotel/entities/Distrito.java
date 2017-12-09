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
    private int idProvincia;

    public Distrito() {
    }

    public Distrito(String nombre, int idProvincia) {
        this.nombre = nombre;
        this.idProvincia = idProvincia;
    }

}
