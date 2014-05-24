/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author javier
 */
public class LogicaJuego {
    
    private PanelTuberias panel;
    private Tuberias[][] tuberias;
    private Task task;
    private BarraProgreso time;
    public LogicaJuego(PanelTuberias panel,Tuberias[][] tuberias,Task task,BarraProgreso time){
        this.panel = panel;
        this.tuberias = tuberias;
        this.task = task;
        this.time = time;
    }
    
    private boolean error = false;
    private int gradoAnterior = 0;
    private int grado = 0;
    private int puntero = 0;
    private int punteroAnterior = 0;
    public void girarGrifo(){
        
        
        Tuberias tuberia;
        ImageView imageview;
        Image[] imagenes = tuberias[0][0].getImagenes();
        ObservableList<Node> list = panel.getChildren();
       
        
        while(puntero<32 && !error){
            tuberia = (Tuberias) list.get(puntero);
            imageview = (ImageView) tuberia.getGraphic();
            grado = tuberia.getGrado();
            comprobarGradoAnterior();
            
            int pos = 0;
            if(grado>3){
              pos = ((grado/90)-1)+6;
            }else{
              pos = (grado + 3)+6;
            }
            tuberia.setGraphic(new ImageView(imagenes[pos]));
        }
        task.cancel();
        //Es necesario hacer ver el mensaje a través de otro thread ya que si no, el thread
        //principal no hace ver las tuberías pintadas hasta que se acepta el mensaje
        ThreadMensajes m = new ThreadMensajes(this,error);
        m.start(); 
    }
    
    /**
     * Comprobamos los principales casos de error que se pueden detectar antes
     */
    private void comprobarGradoAnterior(){
   
        //Si la posicion anterior es la misma tuberia error, a no ser que sean horizontales o verticales
        if(grado!=1 && grado!=2 && grado==gradoAnterior){
            error = true;
            return;
        }
        //Si la primera tuberia no es ni grado 1 o 90 error
        if(gradoAnterior==0 && (grado==180 || grado==2 || grado==270)){
            error = true;
            return;
        }
        //Si la siguiente posicion a una tuberia horizontal es vertical error y viceversa
        if((grado==1 && gradoAnterior==2) || (grado==2 && gradoAnterior==1)){
            error = true;
            return;
        }
        //Si la posición anterior no encaja con la tuberia error
        if(grado==90 && (punteroAnterior==puntero-1 || punteroAnterior==puntero+8)){
            error = true;
            return;
        }else if(grado==180 && (punteroAnterior==puntero-1 || punteroAnterior==puntero-8)){
            error = true;
            return;
        }else if(grado==270 && (punteroAnterior==puntero+1 || punteroAnterior==puntero-8)){
            error = true;
            return;
        }else if(grado==360 && (punteroAnterior==puntero+8 || punteroAnterior==puntero+1)){
            error = true;
            return;
        }else if(grado==1 && (punteroAnterior==puntero+1 || punteroAnterior==puntero-1)){
            error = true;
            return;
        }
        
        boolean err = avanzarPuntero();
        if(!err){
            error = true;
            return;
        }
        gradoAnterior = grado;
    }
    
    /**
     * 
     * @return boolean
     * 
     * Avanzaremos el puntero que apunta a la posición de la siguiente tubería según
     * la tubería en la que estemos y la posicion de la tuberia anterior, es decir, desde que lado
     * entra el agua en la tuberia actual para saber por que lado sale. Daremos error en el 
     * caso de que el puntero intente apuntar a una posición donde no hay tuberia (límites del panel) 
     */
    private boolean avanzarPuntero(){
        boolean err = true;
        switch(grado){
            case 90:
                if(puntero<8 && punteroAnterior==puntero+1){
                    err = false; break;
                }else if((puntero==15 || puntero==23 || puntero==31) && punteroAnterior==puntero-8){
                    err = false; break;
                }else if(punteroAnterior==puntero+1){
                     punteroAnterior = puntero; puntero = puntero - 8; break;
                }else if(punteroAnterior==puntero-8){
                     punteroAnterior = puntero; puntero = puntero + 1; break;
                }else if(punteroAnterior==0){
                     punteroAnterior = puntero; puntero = puntero + 1; break;
                }
            case 180:
                if((puntero==7 || puntero==15 || puntero==23) && punteroAnterior==puntero+8){
                    err = false; break;
                }else if((puntero>23 && puntero<31) && punteroAnterior==puntero+1){
                    err = false; break;
                }else if(punteroAnterior==puntero+1){
                     punteroAnterior = puntero; puntero = puntero + 8; break;
                }else if(punteroAnterior==puntero+8){
                     punteroAnterior = puntero ;puntero = puntero + 1; break;
                }
            case 270:
                if((puntero==8 || puntero==16 || puntero==24) && punteroAnterior==puntero+8){
                    err = false; break;
                }else if((puntero>23 && puntero<31) && punteroAnterior==puntero-1){
                    err = false; break;
                }else if(punteroAnterior==puntero-1){
                    punteroAnterior = puntero; puntero = puntero + 8; break;
                }else if(punteroAnterior==puntero+8){
                    punteroAnterior = puntero ;puntero = puntero - 1; break;
                }
            case 360:
                if(puntero<8 && punteroAnterior==puntero-1){
                    err = false; break;
                }else if((puntero==8 || puntero==16 || puntero==24) && punteroAnterior==puntero-8){
                    err = false; break;
                }else if(punteroAnterior==puntero-1){
                     punteroAnterior = puntero; puntero = puntero - 8; break;
                }else if(punteroAnterior==puntero-8){
                     punteroAnterior = puntero; puntero = puntero - 1; break;
                }else if(punteroAnterior==0){
                     err = false; break;
                }
            case 1:
                if(puntero<8 && punteroAnterior==puntero+8){
                    err = false; break;
                }else if((puntero>23 && puntero<31) && punteroAnterior==puntero-8){
                    err = false; break;
                }else if(punteroAnterior==puntero-8){
                     punteroAnterior = puntero; puntero = puntero + 8; break;
                }else if(punteroAnterior==puntero+8){
                     punteroAnterior = puntero; puntero = puntero - 8; break;
                }else if(punteroAnterior==0){
                     punteroAnterior = puntero; puntero = puntero + 8; break;
                }
            case 2:
                if((puntero==8 || puntero==16 || puntero==24) && punteroAnterior==puntero+1){
                    err = false; break;
                }else if((puntero==7 || puntero==15 || puntero==23 || puntero==31) && punteroAnterior==puntero-1){
                    err = false; break;
                }else if(punteroAnterior==puntero-1){
                    punteroAnterior = puntero; puntero = puntero + 1; break;
                }else if(punteroAnterior==puntero+1){
                    punteroAnterior = puntero ;puntero = puntero - 1; break;
                }
        } 
        return err;
    }
    
    public void reiniciar(){
        //Reseteo valores
        puntero = 0;
        punteroAnterior = 0;
        grado = 0;
        gradoAnterior = 0;
        error = false;
        
        panel.reiniciarTuberias();
        task.cancel(true);
        time.setProgreso(0.0);
        task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    time.incrementarProgreso();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plumber.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }};
        new Thread(task).start();
    }
}
