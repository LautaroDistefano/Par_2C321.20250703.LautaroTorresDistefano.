/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.models;

import java.io.Serializable;

/**
 *
 * @author Lautaro
 */
public class Sala implements Serializable{
    //Attributes
    private int numero;
    private String pelicula;
    private Butaca[][] butacas;

    //Getters
    public int getNumero() { return numero; }
    public String getPelicula() { return pelicula; }
    public Butaca[][] getButacas() { return butacas; }

    public Butaca getButaca(int fila, int columna) {
        return butacas[fila][columna];
    }
    
    //Constructor
    public Sala(int numero, String pelicula, int filas, int columnas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = new Butaca[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                butacas[i][j] = new Butaca(i, j);
            }
        }
    }

    //Methods
    @Override
    public String toString() {
        return "Sala " + numero + " - Película: " + pelicula;
    }
}
