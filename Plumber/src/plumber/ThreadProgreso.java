/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class ThreadProgreso  extends Thread{
    
    BarraProgreso barra;
    public ThreadProgreso(){
        //this.barra = barra;
    }

   

    @Override
    public void run() {
         JOptionPane.showConfirmDialog(null,"Quiere seguir jugando?");
    }


}
