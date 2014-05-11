/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import static java.lang.Thread.sleep;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class PanelTuberias extends GridPane {
    
    private Tuberias[][] tuberias;
    private Grifo grifo;
    private Tuberias tuberiaFinal;
    private Nivel level;
    private int numeroNivel=1;
    private boolean error = false;
    private int valor=0;
    private boolean introducirValor=false;
    
    private int gradoAnterior = 0;
    private int grado = 0;
    private int puntero = 0;
    private int punteroAnterior = 0;
    public PanelTuberias(Tuberias[][] tuberias,Grifo grifo,Tuberias tuberiaFinal){
        
        this.tuberias = tuberias;
        this.grifo = grifo;
        this.tuberiaFinal = tuberiaFinal;        
    }
    
    public void colocarGrifo(){
        grifo.setPanelTuberia(this);
        grifo.colocarGrifo();
    }
    
    public void colocarTuberias(){
        
        //tuberias[0][0].setPanelTuberias(this);
        //tuberias[0][0].colocarTuberias();
        
        
        for(int i=0;i<tuberias.length;i++){
            for(int j=0;j<tuberias[i].length;j++){
                tuberias[i][j].insertarImagenTuberia();
                tuberias[i][j].setPosicion(j, i+1);
                this.add(tuberias[i][j],j,i+1);
            }
        }
 
        tuberiaFinal.insertarImagenFinal();
        this.add(tuberiaFinal, tuberias[0].length-1, tuberias.length+1);
        
    }
    
    public void reiniciarTuberias(){
        int contador=0;
        for(int i=0;i<tuberias.length;i++){
            for(int j=0;j<tuberias[i].length;j++){
                tuberias[i][j].insertarImagenTuberia();
                this.getChildren().set(contador, tuberias[i][j]);
                contador++;
            }
        }
        //Reseteo valores
        puntero = 0;
        punteroAnterior = 0;
        grado = 0;
        gradoAnterior = 0;
        error = false;
        
    }
    
    public void girarGrifo(){
        
        
        Tuberias tuberia;
        ImageView imageview;
        Image[] imagenes = tuberias[0][0].getImagenes();
        ObservableList<Node> list = this.getChildren();
       
        
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
    public void setNumeroNivel(int nivel){
        this.numeroNivel = nivel;
        level.setNivel(nivel);
    }
    
    public int getNumeroNivel(){
        this.numeroNivel = level.getNivel();
        return this.numeroNivel;
    }   

    public void esperarRespuestaMensaje(){
        while(!introducirValor){
        }
        
        if(error){
            valor = JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?");
        }else{
            JOptionPane.showMessageDialog(null, "Siguiente nivel");
        } 
        
        if(valor==JOptionPane.OK_OPTION){
            //this.setNumeroNivel(1);
            this.reiniciarTuberias();
        }else if(valor==700){
            //this.setNumeroNivel(this.getNumeroNivel()+1);
            this.reiniciarTuberias();
        }else{
            System.exit(0);
        
        }
    }
    
    public void setValor(int valor){
        this.valor = valor;
        introducirValor=true;
    }
    
}
