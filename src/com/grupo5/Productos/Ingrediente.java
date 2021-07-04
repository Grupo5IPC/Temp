package com.grupo5.Productos;

import java.io.Serializable;

public class Ingrediente implements Serializable {
    private String name;
    private int quantity;
    private String units;

    public Ingrediente(){
        
    }
    
    public Ingrediente(String nombre,int cantidad, String unidades ){
        setName(nombre);
        setQuantity(cantidad);
        setUnits(unidades);
    }

    public String getName() {
        return name;
    }

    public void setName(String Nombre) {
        this.name = Nombre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Cantidad) {
        this.quantity = Cantidad;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String Unidades) {
        this.units = Unidades;
    }

}
