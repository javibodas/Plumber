/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.scene.layout.GridPane;

/**
 *
 * @author javier
 */
public class PanelTuberias extends GridPane {
    
    private Tuberias[] tuberias;
    private Grifo grifo;
    private Tuberias tuberiaFinal;
    
    public PanelTuberias(Tuberias[] tuberias,Grifo grifo,Tuberias tuberiaFinal){
        
        this.tuberias = tuberias;
        this.grifo = grifo;
        this.tuberiaFinal = tuberiaFinal;
    }
    
    public void colocarGrifo(){
        this.add(grifo, 0, 0);
    }
    
    public void colocarTuberias(){
        int columna=0;
        int fila =1;
        for(int i=0;i<tuberias.length;i++){
            if(columna==7){
                this.add(tuberias[i],columna,fila);
                tuberias[i].insertarImagenTuberia();
                columna=0;
                fila++;
            }else{
                this.add(tuberias[i],columna,fila);
                tuberias[i].insertarImagenTuberia();
                columna++;
            }
        }
        
        tuberiaFinal.insertarImagenFinal();
        this.add(tuberiaFinal, 7, 5);
        
 }
    
    
}
