/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lautaro
 */
public class Cine implements Serializable{
    //Attributes
    private List<Sala> salas;
    private List<Entrada> entradas;
    private List<Cliente> clientes;

    //Getters
    public List<Sala> getSalas() { return salas; }
    public List<Entrada> getEntradas() { return entradas; }
    public List<Cliente> getClientes() { return clientes; }
    
    //Constructor
    public Cine() {
        this.salas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    //Methods
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorEmail(String email) {
        if (email == null || this.clientes == null || this.clientes.isEmpty()) {
            return null;
        }
        for (Cliente cliente : this.clientes) {
            if (email.equals(cliente.getEmail())) {
                return cliente;
            }
        }
        return null;
    }
}
