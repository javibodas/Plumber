/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.awt.BorderLayout;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 *
 * @author javier
 */
public class Fondo extends BorderPane{
    
    private Label moves;
    //private Label movesResult;
    private Label level;
    //private Label leveResult;
    private PanelSuperior panelSuperior;
    private BarraProgreso time;
    private PanelTuberias panelTuberias;
    
    public Fondo(PanelTuberias panelTuberias, PanelSuperior panelSuperior){
        
        this.panelTuberias = panelTuberias;
        this.panelSuperior = panelSuperior;
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
        this.setCenter(panelTuberias);
        this.setTop(panelSuperior);
    }
    
}
