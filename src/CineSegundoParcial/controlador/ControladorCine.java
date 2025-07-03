/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.controlador;

import CineSegundoParcial.models.Butaca;
import CineSegundoParcial.models.Cine;
import CineSegundoParcial.models.Cliente;
import CineSegundoParcial.models.Entrada;
import CineSegundoParcial.models.Sala;
import CineSegundoParcial.persistencia.PersistenciaDatos;

/**
 *
 * @author Lautaro
 */
public class ControladorCine {
    private Cine cine;

    public ControladorCine() {
        this.cine = PersistenciaDatos.cargarEstado();
    }

    public Cine getCine() {
        return cine;
    }

    // Registro de clientes
    public boolean registrarCliente(String nombre, String email, String contrasena) {
        if (cine.buscarClientePorEmail(email) != null) {
            return false;
        }
        Cliente nuevo = new Cliente(nombre, email, contrasena);
        cine.agregarCliente(nuevo);
        PersistenciaDatos.guardarEstado(cine);
        return true;
    }

    // Login de clientes
    public Cliente login(String email, String contrasena) {
        Cliente cliente = cine.buscarClientePorEmail(email);
        if (cliente != null && cliente.getContrasena().equals(contrasena)) {
            return cliente;
        }
        return null;
    }

    // Compra de entrada
    public boolean comprarEntrada(Cliente cliente, Sala sala, int fila, int columna) {
        Butaca butaca = sala.getButaca(fila, columna);
        if (butaca.estaOcupada()) {
            return false;
        }
        butaca.ocupar();
        Entrada entrada = new Entrada(cliente, sala, butaca);
        cine.agregarEntrada(entrada);
        PersistenciaDatos.guardarEstado(cine);
        return true;
    }

    // hardcodeamos unas salas para poder testear
    public void inicializarSalasPorDefecto() {
        if (cine.getSalas().isEmpty()) {
            cine.agregarSala(new Sala(1, "Matrix", 5, 5));
            cine.agregarSala(new Sala(2, "Inception", 6, 6));
            cine.agregarSala(new Sala(3, "Pulp Fiction", 4, 7));
            PersistenciaDatos.guardarEstado(cine);
        }
    }
}
