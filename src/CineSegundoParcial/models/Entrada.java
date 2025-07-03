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
public class Entrada implements Serializable{
    //Attributes
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    //Getters
    public Cliente getCliente() { return cliente; }
    public Sala getSala() { return sala; }
    public Butaca getButaca() { return butaca; }
    
    //Constructor
    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }

    @Override
    public String toString() {
        return "Entrada - Cliente: " + cliente.getNombre() +
               ", Sala: " + sala.getNumero() +
               ", Butaca: F" + butaca.getFila() + " N" + butaca.getNumero();
    }
    
}
