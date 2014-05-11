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
    
    
    private PanelSuperior panelSuperior;
    private PanelTuberias panelTuberias;
    private Reiniciar reiniciar;
    
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
        panelSuperior.colocarElementos();
        reiniciar.colocarReinicio();
        this.setCenter(panelTuberias);
        this.setTop(panelSuperior);
        this.setRight(reiniciar);
    }
    
    public void setPaneTuberias(PanelTuberias panel){
        this.panelTuberias = panel;
    }
    
    public PanelTuberias getPanelTuberias(){
        return this.panelTuberias;
    }
    
    public void setPanelSuperior(PanelSuperior panel){
        this.panelSuperior = panel;
    }
    
    public PanelSuperior getPanelSuperior(){
        return this.panelSuperior;
    }
    
    public void setReiniciar(Reiniciar reinicio){
        this.reiniciar = reinicio;
    }
    
    public Reiniciar getReiniciar(){
        return this.reiniciar;
    }
    
}
