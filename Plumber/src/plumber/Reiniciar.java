/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author javier
 */
public class Reiniciar extends Button{
    
    
    private LogicaJuego logica;
    public Reiniciar(LogicaJuego logica){
        
        this.logica = logica;
        this.setGraphic(new ImageView(new Image("Reinicio.png")));
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
            logica.reiniciar();
            }
            
            
        });
    }
}
