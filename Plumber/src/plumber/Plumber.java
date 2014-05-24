/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plumber;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class Plumber extends Application {
    Task copyWorker;
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        
        /*Inicializar elementos del panel superior del fondo*/
        Label moves = new Label("MOVES: 0");
        Nivel level = new Nivel("LEVEL: 1");
        BarraProgreso time = new BarraProgreso(0.0);
        time.setMinSize(400, 40);
        PanelSuperior panelSuperior = new PanelSuperior(moves,level,time);
        
        Task task = new Task<Void>() {
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
        
        
        /* Inicizalizar elementos del panel central del fondo*/
        Tuberias[][] tuberias = new Tuberias[4][8];
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                tuberias[i][j] = new Tuberias();
            }
        }
        Grifo grifo = new Grifo(new ImageView(new Image("Grifo.png")));
        Sumidero sumidero = new Sumidero();
        PanelTuberias panelTuberias = new PanelTuberias(tuberias,grifo,sumidero);
        
        
        
        LogicaJuego logica = new LogicaJuego(panelTuberias,tuberias,task,time);
        grifo.setLogica(logica);
        Reiniciar reiniciar = new Reiniciar(logica);
        
        /* Crear fondo pasandole sus elementos como argumentos*/
        Fondo fondo = new Fondo(panelTuberias,panelSuperior,reiniciar);
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
