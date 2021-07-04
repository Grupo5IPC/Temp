package com.grupo5;

public class Restaurante {

    private String nombre;
    private String direccion;
    private int numero;
    private String tipoDeCarga;

    public Restaurante(String nombre, String direccion, int numero, String tipoDeCarga) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.tipoDeCarga = tipoDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public void printRestaurante() {
        System.out.println("");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Número de teléfono: " + numero);
        System.out.println("");
    }
}
