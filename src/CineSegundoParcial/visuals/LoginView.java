/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.visuals;

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

    public LoginView(Stage stage) {
        setSpacing(10);
        setPadding(new Insets(20));

        Label lblTitulo = new Label("Login");

        TextField tfUsuario = new TextField();
        tfUsuario.setPromptText("Usuario");

        PasswordField tfPassword = new PasswordField();
        tfPassword.setPromptText("Contraseña");

        Button btnLogin = new Button("Ingresar");

        btnLogin.setOnAction(e -> {
            String usuario = tfUsuario.getText().trim();
            String password = tfPassword.getText().trim();

            if (usuario.isEmpty() || password.isEmpty()) {
                mostrarAlerta("Campos vacíos", "Por favor completá ambos campos.");
                return;
            }

            // Acá podrías llamar a tu lógica de verificación
            // Por ahora, solo mostramos que se capturaron los datos
            mostrarAlerta("Info", "Usuario: " + usuario + "\nContraseña: " + password);
        });

        getChildren().addAll(lblTitulo, tfUsuario, tfPassword, btnLogin);
        stage.setScene(new Scene(this, 300, 200));
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
