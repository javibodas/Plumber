/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    
    public PanelTuberias(Tuberias[][] tuberias,Grifo grifo,Tuberias tuberiaFinal){
        
        this.tuberias = tuberias;
        this.grifo = grifo;
        this.tuberiaFinal = tuberiaFinal;
        
    }
    
    public void colocarGrifo(){
        grifo.setPanelTuberia(this);
        this.add(grifo, 0, 0);
    }
    
    public void colocarTuberias(){
        
        for(int i=0;i<tuberias.length;i++){
            for(int j=0;j<tuberias[i].length;j++){
                tuberias[i][j].insertarImagenTuberia();
                this.add(tuberias[i][j],j,i+1);
            }
        }
 
        tuberiaFinal.insertarImagenFinal();
        this.add(tuberiaFinal, tuberias[0].length-1, tuberias.length+1);
        
    }
    
    public void girarGrifo(){
        Image[] imagenes = tuberias[0][0].getImagenes();
        ObservableList<Node> list = this.getChildren();
        int puntero = 0;
        Tuberias b = (Tuberias) list.get(puntero);
        ImageView v = (ImageView) b.getGraphic();
        if(v.getImage().equals(imagenes[0])){
            b.setGraphic(new ImageView(imagenes[6]));
            while(!v.getImage().equals(imagenes[12])){
                switch(b.getGrado()){
                    case 90: 
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[6]));
                    case 180:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[7]));
                    case 270:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[8]));
                    case 360:
                        b = (Tuberias) list.get(puntero-8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[9]));
                    case 1:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[10]));
                    case 2:
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[11]));
                    default: break;
                }
                
                
            }
            
        }else if(v.getImage().equals(imagenes[3])){
            b.setGraphic(new ImageView(imagenes[9]));
            while(!v.getImage().equals(imagenes[12])){
                switch(b.getGrado()){
                    case 90: 
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[6]));
                    case 180:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[7]));
                    case 270:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[8]));
                    case 360:
                        b = (Tuberias) list.get(puntero-8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[9]));
                    case 1:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[10]));
                    case 2:
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[11]));
                    default: break;
                }
            }
        }else if(v.getImage().equals(imagenes[4])){
            b.setGraphic(new ImageView(imagenes[10]));
            while(!v.getImage().equals(imagenes[12])){
                switch(b.getGrado()){
                    case 90: 
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[6]));
                    case 180:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[7]));
                    case 270:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[8]));
                    case 360:
                        b = (Tuberias) list.get(puntero-8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[9]));
                    case 1:
                        b = (Tuberias) list.get(puntero+8);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[10]));
                    case 2:
                        b = (Tuberias) list.get(puntero+1);
                        v = (ImageView) b.getGraphic();
                        b.setGraphic(new ImageView(imagenes[11]));
                    default: break;
                }
            }
        }else{
            
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
    }  
}
