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
public class Nivel extends Label{
    
    private int nivel = 1;
    public Nivel(String string){
        super(string);
    } 
    
    public int getNivel(){
        return this.nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    
}
