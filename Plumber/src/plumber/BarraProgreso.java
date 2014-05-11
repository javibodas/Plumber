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
public class BarraProgreso extends ProgressBar implements Runnable {
    
    
    private double progreso;
    private int count=0;
    public BarraProgreso(double progreso){
        this.progreso = progreso;
    }
    
    @Override
    public void run() {
        count++;
         if(count==20){
             return;
         }
         this.setProgress(this.progreso);
         this.progreso = this.progreso + 0.05;
        try {
            sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(BarraProgreso.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.run();
    }
    
}
