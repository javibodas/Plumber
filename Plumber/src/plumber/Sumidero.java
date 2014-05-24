/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author javier
 */
public class Sumidero extends Button{
    
    
    public Sumidero(){
        
       this.setGraphic(new ImageView(new Image("TuberiaFinal.png")));
    }
    
}
