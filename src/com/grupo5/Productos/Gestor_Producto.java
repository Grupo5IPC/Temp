package com.grupo5.Productos;

import java.io.Serializable;
import java.util.ArrayList;

public class Gestor_Producto implements Serializable {

    ArrayList<Producto> productos = new ArrayList();
    ArrayList<Ingrediente> ingredientes = new ArrayList();

    public Ingrediente createIngrediente(String nombre, int cantidad, String unidades) {
        Ingrediente ingrediente = new Ingrediente(nombre, cantidad, unidades);

        if (ingredientes.add(ingrediente)) {
            return ingrediente;
        }
        return null;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public boolean insertarProducto(int id, String nombre, String descripcion, double costo, double precio, ArrayList<Ingrediente> ingredientes) {
        // usar antes de crear un producto el crear ingrediente y luego usar como parametro el ingrediente devuelto
        // esto para ahorrar el tener que crear arreglos temporales y para que la extraccion de datos se haga mas facil
        Producto producto = new Producto(id, nombre, descripcion, costo, precio, ingredientes);
        //
        if (productos.add(producto)) {
            return true;
        }
        return false;
    }
// lo hice rapido se puede usar el metodo .forEach si lo prefieren

    public void printProductos() {
        if (productos.isEmpty()) {
            System.out.println("No existen productos");
        }
        for (int i = 0; i < productos.size(); i++) {
            System.out.print(productos.get(i).getId() + ",");
            System.out.print(productos.get(i).getName() + ",");
            System.out.print(productos.get(i).getDescription() + ",");
            System.out.print(productos.get(i).getCost() + ",");
            System.out.print(productos.get(i).getPrice());
            System.out.println("");
            System.out.println("Ingredientes del producto " + productos.get(i).getId());
            for (int j = 0; j < productos.get(i).getIngredientes().size(); j++) {
                System.out.print(productos.get(i).getIngredientes().get(j).getName() + ",");
                System.out.print(productos.get(i).getIngredientes().get(j).getQuantity() + ",");
                System.out.print(productos.get(i).getIngredientes().get(j).getUnits());
                System.out.println("");
            }
            System.out.println("\n");
        }
    }

    public void printIngredientes() {
        if (ingredientes.isEmpty()) {
            System.out.println("No existen productos");
        }
        for (int i = 0; i < ingredientes.size(); i++) {
            System.out.print(ingredientes.get(i).getName() + ",");
            System.out.print(ingredientes.get(i).getQuantity() + ",");
            System.out.print(ingredientes.get(i).getUnits());
            System.out.println("");

        }
    }

    public boolean verificarProducto(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public int contProductos() {
        int cont = 0;
        for (int i = 0; i < productos.size(); i++) {
            if (productos != null) {
                cont++;
            }
        }
        return cont;
    }

    public Producto getProductos(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                return productos.get(i);
            } else {
                i++;
            }
        }
        return null;
    }
    
    public Producto getProductosNom(String Nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getName().equals(Nombre)) {
                state = true;
                return productos.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public int getId_nombre(String nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getName().compareTo(nombre) == 0) {
                state = true;
                return productos.get(i).getId();
            } else {
                i++;
            }
        }
        return 0;

    }

    public void printProductoSolo(int id) {
        int aux = id - 1;
        System.out.print(productos.get(aux).getId() + ",");
        System.out.print(productos.get(aux).getName() + ",");
        System.out.print(productos.get(aux).getDescription() + ",");
        System.out.print(productos.get(aux).getCost() + ",");
        System.out.print(productos.get(aux).getPrice());
        System.out.println("");
        System.out.println("Ingredientes del producto " + productos.get(aux).getId());
        for (int j = 0; j < productos.get(aux).getIngredientes().size(); j++) {
            System.out.print(productos.get(aux).getIngredientes().get(j).getName() + ",");
            System.out.print(productos.get(aux).getIngredientes().get(j).getQuantity() + ",");
            System.out.print(productos.get(aux).getIngredientes().get(j).getUnits());
            System.out.println("");
        }
        System.out.println("\n");
    }

    public String getNombre_id(int id) {
        boolean state = false;
        String nombre = "";
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                nombre = productos.get(i).getName();
                return nombre;
            } else {
                i++;
            }
        }
        return nombre;
    }

    public boolean buscarProducto(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                System.out.print(productos.get(i).getId() + ",");
                System.out.print(productos.get(i).getName() + ",");
                System.out.print(productos.get(i).getDescription() + ",");
                System.out.print(productos.get(i).getCost() + ",");
                System.out.print(productos.get(i).getPrice());
                System.out.println("");
                System.out.println("Ingredientes del producto " + productos.get(id).getId());
                for (int j = 0; j < productos.get(i).getIngredientes().size(); j++) {
                    System.out.print(productos.get(i).getIngredientes().get(j).getName() + ",");
                    System.out.print(productos.get(i).getIngredientes().get(j).getQuantity() + ",");
                    System.out.print(productos.get(i).getIngredientes().get(j).getUnits());
                    System.out.println("");
                }
                System.out.println("\n");
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public void eliminarProducto(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == id) {
                state = true;
                productos.remove(i);
                System.out.println("Producto con id " + (i + 1) + " eliminado");
            } else {
                i++;
            }
        }
    }

    public void eliminarIngrediente(int idProducto, String nombre) {
        boolean state = false;
        boolean state2 = false;
        int i = 0;
        int j = 0;
        while (state == false && i < productos.size()) {
            if (productos.get(i).getId() == idProducto) {
                state = true;
                while (state2 == false && j < productos.get(i).getIngredientes().size()) {
                    if (nombre.equals(productos.get(i).getIngredientes().get(j).getName())) {
                        state2 = true;
                        productos.get(i).getIngredientes().remove(j);
                    } else {
                        j++;
                    }
                }
            } else {
                i++;
            }
        }
    }
}
