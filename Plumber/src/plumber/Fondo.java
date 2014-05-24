/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;


import javafx.scene.layout.BorderPane;




/**
 *
 * @author javier
 */
public class Fondo extends BorderPane{
    
    
    public PanelSuperior panelSuperior;
    public PanelTuberias panelTuberias;
    public Reiniciar reiniciar;
    
    public Fondo(PanelTuberias panelTuberias, PanelSuperior panelSuperior,Reiniciar reiniciar){
        
        this.panelTuberias = panelTuberias;
        this.panelSuperior = panelSuperior;
        this.reiniciar = reiniciar;
    }
    
    /**
     * 
     * Coloca los elemntos del fondo en su posición y manda colocar
     * cada subelemento de estos en su posición
     * 
    */
    public void colocarElementos(){
        
        panelTuberias.colocarTuberias();
        panelTuberias.colocarGrifo();
        panelTuberias.colocarSumidero();
        panelSuperior.colocarElementos();
        this.setCenter(panelTuberias);
        this.setTop(panelSuperior);
        this.setRight(reiniciar);
    }
}
