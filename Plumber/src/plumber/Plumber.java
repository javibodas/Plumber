/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author javier
 */
public class Plumber extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        /* Inicizalizar elementos del panel central del fondo*/
        Tuberias[][] tuberias = new Tuberias[4][8];
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                tuberias[i][j] = new Tuberias();
            }
        }
        Grifo grifo = new Grifo();
        Tuberias tuberiaFinal = new Tuberias();
        PanelTuberias panelTuberias = new PanelTuberias(tuberias,grifo,tuberiaFinal);
        
        /*Inicializar elementos del panel superior del fondo*/
        Label moves = new Label("MOVES:");
        Label level = new Label("LEVEL:");
        BarraProgreso time = new BarraProgreso();
        PanelSuperior panelSuperior = new PanelSuperior(moves,level,time);
        
        /* Crear fondo pasandole sus elementos como argumentos*/
        Fondo fondo = new Fondo(panelTuberias,panelSuperior);
        fondo.colocarElementos();
        
        
        Scene scene = new Scene(fondo, 1000, 590);
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("Plumber");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
