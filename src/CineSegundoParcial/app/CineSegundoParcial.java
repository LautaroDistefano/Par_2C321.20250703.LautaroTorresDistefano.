/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CineSegundoParcial.app;

import CineSegundoParcial.controlador.ControladorCine;
import CineSegundoParcial.visuals.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lautaro
 */
public class CineSegundoParcial extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ControladorCine controlador = new ControladorCine();
        controlador.inicializarSalasPorDefecto();
        new LoginView(primaryStage, controlador);
        primaryStage.setTitle("Sistema de Cine");
        primaryStage.show();
    }
    
}
