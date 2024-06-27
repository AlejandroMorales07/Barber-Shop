/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jesus
 */
public class Persona {
    private int cedulaPersona;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    // Constructores
    public Persona() {}

    public Persona(int cedulaPersona, String nombre, String apellido, String telefono, String email) {
        this.cedulaPersona = cedulaPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public int getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(int cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
