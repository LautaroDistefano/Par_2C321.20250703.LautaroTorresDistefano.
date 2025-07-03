/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.visuals;

import CineSegundoParcial.controlador.ControladorCine;
import CineSegundoParcial.models.Butaca;
import CineSegundoParcial.models.Cliente;
import CineSegundoParcial.models.Sala;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lautaro
 */
public class ConfirmacionView extends VBox {
    public ConfirmacionView(Stage stage, Cliente cliente, Sala sala, Butaca butaca, ControladorCine controlador) {
        setSpacing(10);
        setPadding(new Insets(20));
        
        Button btnHome = new Button("Inicio");

        Label lbl = new Label("¡Compra exitosa!");
        Label datos = new Label(
                "Cliente: " + cliente.getNombre() + "\n" +
                "Pelicula: " + sala.getPelicula() + "\n" +
                "Sala: " + sala.getNumero() + "\n" +
                "Butaca: F" + butaca.getFila() + " - N" + butaca.getNumero()
        );
        
        btnHome.setOnAction(e -> {
            SalaView menu = new SalaView(stage, controlador, cliente);
        });

        getChildren().addAll(lbl, datos, btnHome);
        stage.setScene(new Scene(this));
    }
}