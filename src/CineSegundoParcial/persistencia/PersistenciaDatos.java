/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.persistencia;

import CineSegundoParcial.models.Cine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Lautaro
 */
public class PersistenciaDatos {
    private static final String ARCHIVO = "cine.ser";

    // Guardar el estado completo del cine
    public static void guardarEstado(Cine cine) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(cine);
            System.out.println("Estado del cine guardado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el estado del cine: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Cargar el estado del cine
    public static Cine cargarEstado() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No se encontró un estado previo del cine. Se crea uno nuevo.");
            return new Cine();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Cine cine = (Cine) ois.readObject();
            System.out.println("Estado del cine cargado correctamente.");
            return cine;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el estado del cine: " + e.getMessage());
            e.printStackTrace();
            return new Cine();
        }
    }
}
