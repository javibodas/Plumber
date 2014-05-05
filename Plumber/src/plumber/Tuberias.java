/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author javier
 */
public class Tuberias extends Button {
    
    
    private int gradosImagen = 0; /*0: posicion inicial; 90: un click; 180: dos click;
                                    270: tres clicks; 360=0:cuatro clicks*/
    private Image[] imagenes = new Image[7];
    public Tuberias(){
        
        //Inicializar imagenes
        imagenes[0] = new Image("Tuberia90.png");
        imagenes[1] = new Image("Tuberia180.png");
        imagenes[2] = new Image("Tuberia270.png");
        imagenes[3] = new Image("Tuberia360.png");
        imagenes[4] = new Image("TuberiaVertical.png");
        imagenes[5] = new Image("TuberiaHorizontal.png");
        imagenes[6] = new Image("TuberiaFinal.png");
        
        setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                
                Button b = (Button) t.getSource();
                ImageView v = (ImageView) b.getGraphic();
                
                if(v.getImage().equals(imagenes[2])){
                    b.setGraphic(new ImageView(imagenes[3]));
                }else if(v.getImage().equals(imagenes[3])){
                     b.setGraphic(new ImageView(imagenes[0]));
                }else if(v.getImage().equals(imagenes[0])){
                    b.setGraphic(new ImageView(imagenes[1]));
                }else if(v.getImage().equals(imagenes[1])){
                    b.setGraphic(new ImageView(imagenes[2]));
                }else if(v.getImage().equals(imagenes[4])){
                     b.setGraphic(new ImageView(imagenes[5]));
                }else if(v.getImage().equals(imagenes[5])){
                     b.setGraphic(new ImageView(imagenes[4]));
                }
            }
            
        });
    }
    
    public void insertarImagenTuberia(){
        
        this.setGraphic(new ImageView(imagenes[(int) (Math.random()*6)]));  
    }
    
    public void insertarImagenFinal(){
        
        this.setGraphic(new ImageView(imagenes[6]));
    }   
}
