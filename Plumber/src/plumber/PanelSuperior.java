/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author javier
 */
public class PanelSuperior extends GridPane {
    
    
    private BarraProgreso time;
    private Label moves;
    private Label level;
    
    public PanelSuperior(Label moves,Label level,BarraProgreso time){
        
        this.time = time;
        this.moves = moves;
        this.level = level;
    }
    
    public void colocarElementos(){
        moves.setFont(Font.font("MOVES:", FontWeight.BOLD, 23));
        level.setFont(Font.font("LEVEL:", FontWeight.BOLD, 23));
        
        this.setPadding(new Insets(25,25,25,25));
        this.setHgap(10);
        this.setVgap(10);
        
        this.add(moves, 0, 0);
        this.add(level, 15, 0);
        this.add(time, 30, 0); 
    }
    
    
    public void setBarraProgreso(BarraProgreso time){
        this.time = time;
    }
    
    public BarraProgreso getBarraProgreso(){
        return this.time;
    }
    
    public void setLevel(Nivel level){
        this.level = level;
    }
    
    public Label getLevel(){
        return this.level;
    }
 
    public void setMoves(Label moves){
        this.moves = moves;
    }
    
    public Label getMoves(){
        return this.moves;
    }
}
