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
public class Butaca implements Serializable{
    //Attributes
    private int fila;
    private int numero;
    private boolean ocupada;

    //Getters
    public int getFila() { return fila; }
    public int getNumero() { return numero; }
    public boolean estaOcupada() { return ocupada; }

    //Constructor
    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = false;
    }

    //Methods

    @Override
    public String toString() {
        return "Butaca [F:" + fila + ", N:" + numero + ", " + (ocupada ? "Ocupada" : "Libre") + "]";
    }
    
    public void ocupar() { this.ocupada = true; }
}
