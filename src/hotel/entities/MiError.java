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
public class MiError extends RuntimeException{

    public MiError() {
    }

    public MiError(String message) {
        super(message);
    }
    
}
