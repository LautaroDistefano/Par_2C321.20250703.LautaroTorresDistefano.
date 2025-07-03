/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.visuals;

import CineSegundoParcial.controlador.ControladorCine;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Lautaro
 */
public class RegistroView extends VBox{
    public RegistroView(Stage stage, ControladorCine controladorCine) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lblNombre = new Label("Nombre:");
        TextField tfNombre = new TextField();

        Label lblEmail = new Label("Email:");
        TextField tfEmail = new TextField();

        Label lblContrasena = new Label("Contraseña:");
        PasswordField pfContrasena = new PasswordField();

        Button btnRegistrar = new Button("Registrarse");

        btnRegistrar.setOnAction(e -> {
            boolean exito = controladorCine.registrarCliente(
                    tfNombre.getText(), tfEmail.getText(), pfContrasena.getText()
            );
            if (exito) {
                mostrarInfo("Registro exitoso");
                new LoginView(stage, controladorCine);
            } else {
                mostrarAlerta("Ya existe un cliente con ese email");
            }
        });

        getChildren().addAll(lblNombre, tfNombre, lblEmail, tfEmail, lblContrasena, pfContrasena, btnRegistrar);
        stage.setScene(new Scene(this));
    }

    private void mostrarInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
