/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.visuals;

import CineSegundoParcial.controlador.ControladorCine;
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
public class SalaView extends VBox{
    public SalaView(Stage stage, ControladorCine controlador, Cliente cliente) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lblTitulo = new Label("Seleccione una sala:");

        getChildren().add(lblTitulo);

        for (Sala sala : controlador.getCine().getSalas()) {
            Button btnSala = new Button("Sala " + sala.getNumero() + " - " + sala.getPelicula());
            btnSala.setOnAction(e -> new ButacaView(stage, controlador, cliente, sala));
            getChildren().add(btnSala);
        }

        stage.setScene(new Scene(this));
    }
}
