/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
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
    
    
    private int grado = 0;
    private Image[] imagenes = new Image[13];
    private int[] posicion = new int[2];
    private PanelTuberias panel;
    public Tuberias(){
        
       //Inicializar imagenes
       imagenes[0] = new Image("Tuberia90.png");
       imagenes[1] = new Image("Tuberia180.png");
       imagenes[2] = new Image("Tuberia270.png");
       imagenes[3] = new Image("Tuberia360.png");
       imagenes[4] = new Image("TuberiaVertical.png");
       imagenes[5] = new Image("TuberiaHorizontal.png");
       imagenes[6] = new Image("Tuberia90Llena.png");
       imagenes[7] = new Image("Tuberia180Llena.png");
       imagenes[8] = new Image("Tuberia270Llena.png");
       imagenes[9] = new Image("Tuberia360Llena.png");
       imagenes[10] = new Image("TuberiaVerticalLlena.png");
       imagenes[11] = new Image("TuberiaHorizontalLlena.png");
       imagenes[12] = new Image("TuberiaFinal.png");
        
       this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t) {
                
                Tuberias b = (Tuberias) t.getSource();
                ImageView v = (ImageView) b.getGraphic();
                
                //Gira la imagen 90 grados en el sentido de las agujas del reloj
                if(b.getGrado()==270){
                    b.setGraphic(new ImageView(imagenes[3]));
                    b.setGrado(360);
                }else if(b.getGrado()==360){
                    b.setGraphic(new ImageView(imagenes[0]));
                    b.setGrado(90);
                }else if(b.getGrado()==90){
                    b.setGraphic(new ImageView(imagenes[1]));
                    b.setGrado(180);
                }else if(b.getGrado()==180){
                    b.setGraphic(new ImageView(imagenes[2]));
                    b.setGrado(270);
                }else if(b.getGrado()==1){
                     b.setGraphic(new ImageView(imagenes[5]));
                     b.setGrado(2);
                }else if(b.getGrado()==2){
                     b.setGraphic(new ImageView(imagenes[4]));
                     b.setGrado(1);
                }
            }
            
        });
    }
    
   
    
    public Image[] getImagenes(){
        return this.imagenes;
    }
    
    public void setImagenes(Image[] imagenes){
        this.imagenes = imagenes;
    }
    
    public void insertarImagenTuberia(){ 
        this.setGraphic(new ImageView(imagenes[(int) (Math.random()*6)]));
        
        ImageView v = (ImageView) this.getGraphic();
        if(v.getImage().equals(imagenes[0])){
            this.grado = 90;
        }else if(v.getImage().equals(imagenes[1])){
            this.grado = 180;
        }else if(v.getImage().equals(imagenes[2])){
            this.grado = 270;
        }else if(v.getImage().equals(imagenes[3])){
            this.grado = 360;
        }else if(v.getImage().equals(imagenes[4])){
            this.grado = 1;
        }else if(v.getImage().equals(imagenes[5])){
            this.grado = 2;
        } 
    }
      
    public void setGrado(int grado) {
       this.grado = grado;
    }
    public int getGrado(){
        return this.grado;
    }
    
    public void setPosicion(int x,int y){
       this.posicion[0] = x;
       this.posicion[1] = y;
    }
    
    public int[] getPosicion(){
        return this.posicion;
    }
}
