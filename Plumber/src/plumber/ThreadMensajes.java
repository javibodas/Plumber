/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class ThreadMensajes extends Thread{
    
    PanelTuberias pane;
    private Thread t;
    private int valor = 666;
    private Boolean error;
    public ThreadMensajes(PanelTuberias panel, boolean error){
        this.pane = panel;
        this.error = error;
    }
    
    @Override
   public void run() {
        
        if(error){
            valor = JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?");
        }else{
            JOptionPane.showMessageDialog(null, "Siguiente nivel");
        } 
    }
    
    @Override
    public void start(){
        if(t==null){
           t = new Thread(this);
           t.start();
           pane.setValor(valor);
        }
    }
}
