package com.grupo5.Clientes;
import java.io.Serializable;

public class Cliente implements Serializable {
    private int id;
    private String name;
    private String address;
    private int phone;
    private String nit;
    public Cliente(int Id, String nombre, String direccion, int telefono, String Nit){
        setId(Id);
        setName(nombre);
        setAddress(direccion);
        setPhone(telefono);
        setNit(Nit);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
