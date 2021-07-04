package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {

    private int id;
    private Cliente client;
    private String date;
    private ArrayList<Detalle> detalles = new ArrayList();

    public Factura(int id, Cliente client, String date, ArrayList detalles) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<Detalle> detalles) {
        this.detalles = detalles;
    }
    
}
