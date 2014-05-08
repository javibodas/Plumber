/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import static java.lang.Thread.sleep;
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
    
    public void iniciarReloj() throws InterruptedException{
         
         count++;
         if(count==20){
             return;
         }
         this.setProgress(this.progreso);
         this.progreso = this.progreso + 0.05;
         System.out.println(this.progreso);
         sleep(1);
         this.iniciarReloj();
         
         
        
        
    }
    
}
