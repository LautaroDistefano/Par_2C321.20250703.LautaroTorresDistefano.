/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CineSegundoParcial.app;

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
        LoginView login = new LoginView(primaryStage);
        primaryStage.setTitle("Sistema de Login");
        // El setScene ya está en el constructor de LoginView, así que no hace falta repetirlo
        primaryStage.show();
    }
    
}
