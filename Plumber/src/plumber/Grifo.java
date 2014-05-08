/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

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
    public Grifo(){
        
        setGraphic(new ImageView(new Image("Grifo.png")));
        setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
               panelTuberias.girarGrifo();     
       
              /*if(error){
                    int respuesta = JOptionPane.showConfirmDialog(null, "GAME OVER. Play again?");  
                    if(respuesta == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }else if(respuesta == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }else if(respuesta == JOptionPane.OK_OPTION){
                
                    }else{
                        System.exit(0);
                    }
                }
              */  
            }
           
        });
    }
    
    public PanelTuberias getPanelTuberia(){
        return this.panelTuberias;
        
    }
    public void setPanelTuberia(PanelTuberias panelTuberias){
        
        this.panelTuberias = panelTuberias;
        
    }
    
    
}
