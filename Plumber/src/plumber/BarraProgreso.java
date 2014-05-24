/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author javier
 */
public class BarraProgreso extends ProgressBar {
    
    
    private double progreso;
    private int count=0;
    public BarraProgreso(double progreso){
        this.progreso = progreso;
    }
    
    public void setProgreso(double progreso){
        this.progreso = progreso;
    }
    public void incrementarProgreso() throws InterruptedException{
        
        if(progreso<100){
            this.setProgress(progreso/100);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                Thread.currentThread().stop();
            }
            progreso = progreso + 2;
            incrementarProgreso();
        }
        
        ThreadMensajes thread = new ThreadMensajes(null,true);
        thread.start();
    }
}
