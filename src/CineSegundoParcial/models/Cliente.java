/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CineSegundoParcial.models;

/**
 *
 * @author Lautaro
 */
public class Cliente {
    //Attributes
    private String nombre;
    private String email;
    private String contrasena;
    
    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    //Constructor
    public Cliente(String nombre, String email, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }
    //Methods
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", email=" + email + ", contrasena=" + contrasena + '}';
    }
}
