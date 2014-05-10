/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class Grifo extends Button{
   
    
    private PanelTuberias panelTuberias;
    private ImageView image;
    public Grifo(ImageView image){
        
        this.image = image;
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                try {     
                    panelTuberias.girarGrifo();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Grifo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        });
    }
    
    public PanelTuberias getPanelTuberia(){
        return this.panelTuberias;
        
    }
    public void setPanelTuberia(PanelTuberias panelTuberias){
        
        this.panelTuberias = panelTuberias;
        
    }
    
    public void colocarImagenGrifo(){
        this.setGraphic(image);
        
    }
    
    
}
