/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.visuals;

import CineSegundoParcial.controlador.ControladorCine;
import CineSegundoParcial.models.Cliente;
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
public class LoginView extends VBox {

    public LoginView(Stage stage, ControladorCine controladorCine) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lblEmail = new Label("Email:");
        TextField tfEmail = new TextField();

        Label lblContrasena = new Label("Contraseña:");
        PasswordField pfContrasena = new PasswordField();

        Button btnLogin = new Button("Iniciar sesión");
        Button btnRegistro = new Button("Registrarse");

        btnLogin.setOnAction(e -> {
            Cliente cliente = controladorCine.login(tfEmail.getText(), pfContrasena.getText());
            if (cliente != null) {
                new SalaView(stage, controladorCine, cliente);
            } else {
                mostrarAlerta("Error", "Credenciales inválidas");
            }
        });

        btnRegistro.setOnAction(e -> {
            new RegistroView(stage, controladorCine);
        });

        getChildren().addAll(lblEmail, tfEmail, lblContrasena, pfContrasena, btnLogin, btnRegistro);
        stage.setScene(new Scene(this));
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
