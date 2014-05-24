/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.scene.control.Label;

/**
 *
 * @author javier
 */
public class Movimientos extends Label {
    
    private int moves = 0;
    public Movimientos(String moves){
        super(moves);
    }
    
    public int getMovimientos(){
        
        return this.moves;
    }
    
    public void setMovimientos(int moves){
        this.moves = moves;
    }
    
}
