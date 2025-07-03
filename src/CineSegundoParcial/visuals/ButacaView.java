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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lautaro
 */
public class ButacaView extends VBox{
    public ButacaView(Stage stage, ControladorCine controlador, Cliente cliente, Sala sala) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lbl = new Label("Butacas - Sala " + sala.getNumero() + " - " + sala.getPelicula());

        Button btnHome = new Button("Volver");
        
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        Butaca[][] butacas = sala.getButacas();

        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[i].length; j++) {
                Butaca butaca = butacas[i][j];
                Button btn = new Button(butaca.estaOcupada() ? "X" : "O");
                btn.setStyle(butaca.estaOcupada() ? "-fx-background-color: red" : "-fx-background-color: green");
                btn.setDisable(butaca.estaOcupada());
                int fila = i, columna = j;

                btn.setOnAction(e -> {
                    boolean ok = controlador.comprarEntrada(cliente, sala, fila, columna);
                    if (ok) {
                        new ConfirmacionView(stage, cliente, sala, butaca, controlador);
                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Butaca ocupada.");
                        a.showAndWait();
                    }
                });

                grid.add(btn, j, i);
            }
        }
        
        btnHome.setOnAction(e -> {
            SalaView menu = new SalaView(stage, controlador, cliente);
        });

        getChildren().addAll(lbl, grid, btnHome);
        stage.setScene(new Scene(this));
    }
}
