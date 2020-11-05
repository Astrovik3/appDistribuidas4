package com.example.appdistribuidas.Models;

public class Usuario {
    private int id;
    private String FirstName;
    private String apellido;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    private String contraseña;
}
