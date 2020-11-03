package com.example.appdistribuidas.Models;

public class Usuario {
    private int id;
    private String Nombre;
    private String apellido;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    private String contraseña;
}
