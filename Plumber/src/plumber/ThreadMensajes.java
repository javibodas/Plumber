/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.awt.Component;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class ThreadMensajes extends Thread{
    
    GridPane pane;
    private int valor;
    private Boolean error;
    public ThreadMensajes(boolean error){
        //this.pane = pane;
        this.error = error;
    }
    
    @Override
    public void run() {
        
        if(error){
            valor = JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?");
         }else{
            JOptionPane.showMessageDialog(null, "Siguiente nivel");
         }
              
        
        if(valor==JOptionPane.OK_OPTION){
            if(error){
                
            }else{
                
            }
        }else{
            if(error){
                System.exit(1);
            }
        }
    }
    
    

    
}
