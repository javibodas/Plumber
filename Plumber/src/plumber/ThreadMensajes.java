/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class ThreadMensajes extends Thread{
    
    LogicaJuego logica;
    private Thread t;
    private int valor = 666;
    private Boolean error;
    public ThreadMensajes(LogicaJuego logica, boolean error){
        this.logica = logica;
        this.error = error;
    }
    
    @Override
   public void run() {
        if(error){
            valor = JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?");
        }else{
            JOptionPane.showMessageDialog(null, "Siguiente nivel");
        }
        //logica.setValor(valor);
        
        if(valor==JOptionPane.NO_OPTION || valor==JOptionPane.CANCEL_OPTION){
           System.exit(0);
        }
        Task task = new Task<Void>() {
            @Override
            protected Void call() {
                    logica.reiniciar();
                
                return null;
            }};
        new Thread(task).start();  
    }
}
