/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import static java.lang.Thread.sleep;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class PanelTuberias extends GridPane {
    
    private Tuberias[][] tuberias;
    private Grifo grifo;
    private Sumidero sumidero;
    private Nivel level;
    private int numeroNivel=1;
    private int valor=0;
    private boolean introducirValor=false;
    
    public PanelTuberias(Tuberias[][] tuberias,Grifo grifo,Sumidero sumidero){
        
        this.tuberias = tuberias;
        this.grifo = grifo;
        this.sumidero = sumidero;        
    }
    
    public void colocarGrifo(){
        grifo.setPanelTuberia(this);
        this.add(grifo,0,0);
    }
    
    public void colocarTuberias(){
        for(int i=0;i<tuberias.length;i++){
            for(int j=0;j<tuberias[i].length;j++){
                tuberias[i][j].insertarImagenTuberia();
                tuberias[i][j].setPosicion(j, i+1);
                this.add(tuberias[i][j],j,i+1);
            }
        }
    }
    
    public void colocarSumidero(){
        this.add(sumidero, tuberias[0].length-1, tuberias.length+1);
    }
    
    public void reiniciarTuberias(){
        int contador=0;
        for(int i=0;i<tuberias.length;i++){
            for(int j=0;j<tuberias[i].length;j++){
                tuberias[i][j].insertarImagenTuberia();
                this.getChildren().set(contador, tuberias[i][j]);
                contador++;
            }
        }
    }
    
    public void setNumeroNivel(int nivel){
        this.numeroNivel = nivel;
        level.setNivel(nivel);
    }
    
    public int getNumeroNivel(){
        this.numeroNivel = level.getNivel();
        return this.numeroNivel;
    }   

    public void setValor(int valor){
        this.valor = valor;
        if(valor == JOptionPane.OK_OPTION){
            this.reiniciarTuberias();
        }
    }
    
}
