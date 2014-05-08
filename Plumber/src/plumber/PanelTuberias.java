/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import static java.lang.Thread.sleep;
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
        int grado = 0;
        int gradoAnterior = 0;
        int puntero = 0;
        int punteroAnterior = 0;
        boolean error = false;
        Tuberias tuberia;
        ImageView imageview;
        while(puntero<32 && !error){
            tuberia = (Tuberias) list.get(puntero);
            imageview = (ImageView) tuberia.getGraphic();
            grado = tuberia.getGrado();
            System.out.println(grado);
            switch(grado){
                case 90:
                    if(gradoAnterior==0){
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[6]));
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==2){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[6]));
                        if(puntero<8){
                            error=true;
                            break;
                        }
                        puntero = puntero-8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==1){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[6]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==270){
                        if(punteroAnterior==puntero+1){
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[6]));
                            if(puntero<8){
                                error=true;
                                break;
                            }
                            puntero = puntero-8;
                            gradoAnterior = grado;                       
                        }else{
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[6]));
                            if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                                error=true;
                                break;
                            }
                            puntero = puntero+1;
                            gradoAnterior = grado;
                        }
                        break;
                    }else if(gradoAnterior==360){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[6]));
                        if(puntero<8){
                            error=true;
                            break;
                        }
                        puntero = puntero-8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==180){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[6]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==90){
                        error=true;
                        break;
                    }
                case 180:
                    if(gradoAnterior==0){
                        error=true;
                        break;
                    }else if(gradoAnterior==180){
                        error=true;
                        break;
                    }else if(gradoAnterior==360){
                        if(punteroAnterior==puntero+1){
                             punteroAnterior=puntero;
                            tuberia.setGraphic(new ImageView(imagenes[7]));
                            if(puntero>23 && puntero<31){
                                error=true;
                                break;
                            }
                            puntero = puntero + 8;
                            gradoAnterior = grado;
                         }else{
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[7]));
                            if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                                error=true;
                                break;
                            }
                            puntero = puntero+1;
                            gradoAnterior = grado;
                         }
                        break;
                    }else if(gradoAnterior==90){
                        if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[11]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==270){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                         punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[7]));
                        if(puntero>23 && puntero<31){
                             error=true;
                             break;
                        }
                        puntero = puntero + 8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==1){
                        if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[7]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==2){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                         tuberia.setGraphic(new ImageView(imagenes[7]));
                         if(puntero>23 && puntero<31){
                             error=true;
                             break;
                         }
                         puntero = puntero + 8;
                         gradoAnterior = grado;
                         break;
                    }
                case 270:
                    if(gradoAnterior==0){
                        error = true;
                    }else if(gradoAnterior==90){
                        if(punteroAnterior==puntero-1){
                            punteroAnterior=puntero;
                            tuberia.setGraphic(new ImageView(imagenes[8]));
                            if(puntero>23 && puntero<31){
                                error=true;
                                break;
                            }
                            puntero = puntero + 8;
                            gradoAnterior = grado;
                            break;
                           
                        }else{
                             punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[8]));
                            if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                                error=true;
                                break;
                            }
                            puntero = puntero-1;
                            gradoAnterior = grado;
                            break;
                            
                        }
                    }else if(gradoAnterior==360){
                        if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==180){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                         tuberia.setGraphic(new ImageView(imagenes[8]));
                         if(puntero>23 && puntero<31){
                             error=true;
                             break;
                         }
                         puntero = puntero + 8;
                         gradoAnterior = grado;
                         break;
                    }else if(gradoAnterior==1){
                        if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[8]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==2){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                         tuberia.setGraphic(new ImageView(imagenes[8]));
                         if(puntero>23 && puntero<31){
                             error=true;
                             break;
                         }
                         puntero = puntero + 8;
                         gradoAnterior = grado;
                         break;
                    }else if(gradoAnterior==270){
                        error=true;
                    }
                 case 360:
                    if(gradoAnterior==90){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        if(puntero<8){
                            error=true;
                            break;
                        }
                        puntero = puntero - 8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==0){
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        error=true;
                        break;
                    }else if(gradoAnterior==270){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==1){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==2){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[9]));
                        if(puntero<8){
                            error=true;
                            break;
                        }
                        puntero = puntero - 8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==180){
                        if(punteroAnterior==puntero-8){
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[9]));
                            if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                                error=true;
                                break;
                            }
                            puntero = puntero-1;
                            gradoAnterior = grado;
                        }else{
                            punteroAnterior=puntero;
                            tuberia.setGraphic(new ImageView(imagenes[9]));
                            if(puntero<8){
                                error=true;
                                break;
                            }
                            puntero = puntero - 8;
                            gradoAnterior = grado;
                        }
                        break;
                    }else if(gradoAnterior==360){
                        error= true;
                        break;
                    }
                
                case 1:
                    if(gradoAnterior==270){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                         punteroAnterior=puntero;
                         tuberia.setGraphic(new ImageView(imagenes[10]));
                         if(puntero>23 && puntero<31){
                             error=true;
                             break;
                         }
                         puntero = puntero + 8;
                         gradoAnterior = grado;
                         break;
                    }else if(gradoAnterior==180){
                        if(punteroAnterior!=puntero-8){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[10]));
                        if(puntero>23 && puntero<31){
                            error=true;
                            break;
                        }
                        puntero = puntero + 8;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==360){
                        if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[10]));
                         if(puntero<8){
                             error=true;
                             break;
                         }
                         puntero = puntero - 8;
                         gradoAnterior = grado;
                         break;
                    }else if(gradoAnterior==90){
                         if(punteroAnterior!=puntero+8){
                            error=true;
                            break;
                        }
                        punteroAnterior=puntero;
                        tuberia.setGraphic(new ImageView(imagenes[10]));
                         if(puntero<8){
                             error=true;
                             break;
                         }
                         puntero = puntero - 8;
                         gradoAnterior = grado;
                         break;
                    }else if(gradoAnterior==0){
                      punteroAnterior=puntero;
                      tuberia.setGraphic(new ImageView(imagenes[10]));
                      puntero = puntero + 8;
                      gradoAnterior = grado;  
                      break;
                    }else if(gradoAnterior==1){
                        if(punteroAnterior==puntero+8){
                            punteroAnterior=puntero;
                            tuberia.setGraphic(new ImageView(imagenes[10]));
                            if(puntero<8){
                                error=true;
                                break;
                            }
                            puntero = puntero - 8;
                            gradoAnterior = grado;
                        }else{
                            punteroAnterior=puntero;
                            tuberia.setGraphic(new ImageView(imagenes[10]));
                            if(puntero>23 && puntero<31){
                                error=true;
                                break;
                            }
                            puntero = puntero + 8;
                            gradoAnterior = grado;
                        }
                        break;
                    }else if(gradoAnterior==2){
                      error= true;
                      break;
                    }
                case 2:
                    if(gradoAnterior==0){
                         error=true;
                         break;
                    }else if(gradoAnterior==360){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[11]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==270){
                        if(punteroAnterior!=puntero+1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[11]));
                        if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                            error=true;
                            break;
                        }
                        puntero = puntero-1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==180){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[11]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==90){
                        if(punteroAnterior!=puntero-1){
                            error=true;
                            break;
                        }
                        punteroAnterior = puntero;
                        tuberia.setGraphic(new ImageView(imagenes[11]));
                        if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                            error=true;
                            break;
                        }
                        puntero = puntero+1;
                        gradoAnterior = grado;
                        break;
                    }else if(gradoAnterior==1){
                        error = true;
                        break;
                    }else if(gradoAnterior==2){
                        if(punteroAnterior==puntero+1){
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[11]));
                            if(puntero==0 || puntero==8 || puntero==16 || puntero==24){
                                error=true;
                                break;
                            }
                            puntero = puntero-1;
                            gradoAnterior = grado;
                        }else{
                            punteroAnterior = puntero;
                            tuberia.setGraphic(new ImageView(imagenes[11]));
                            if(puntero==7 || puntero==15 || puntero==23 || puntero==31){
                                error=true;
                                break;
                            }
                            puntero = puntero+1;
                            gradoAnterior = grado;
                        }
                        break;
                    }                  
            }
        }
        
        //Es necesario hacer ver el mensaje a través de otro thread ya que si no, el thread
        //principal no hace ver las tuberías pintadas hasta que se acepta el mensaje
        ThreadMensajes m = new ThreadMensajes(error);
        m.start();     
    }  
    
}
