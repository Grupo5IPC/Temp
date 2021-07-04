package com.grupo5.Clientes;

import java.util.ArrayList;
import java.io.Serializable;

public class Gestor_cliente implements Serializable {

    ArrayList<Cliente> clientes = new ArrayList();

    public boolean insertarCliente(int id, String nombre, String direccion, int telefono, String nit) {
        Cliente user = new Cliente(id, nombre, direccion, telefono, nit);
        if (clientes.add(user)) {
            return true;
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void printClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No existen clientes");
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.print(clientes.get(i).getId() + ",");
            System.out.print(clientes.get(i).getName() + ",");
            System.out.print(clientes.get(i).getAddress() + ",");
            System.out.print(clientes.get(i).getPhone() + ",");
            System.out.println(clientes.get(i).getNit());

        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public boolean buscarCliente(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                System.out.print("\nNombre: " + clientes.get(i).getName());
                System.out.print("\nDirección: " + clientes.get(i).getAddress());
                System.out.print("\nTelefono: " + clientes.get(i).getPhone());
                System.out.println("\nNit: " + clientes.get(i).getNit());
                System.out.println("\n");
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean verificarCliente(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public Cliente getCliente(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < clientes.size()) {
            if ((clientes.get(i).getId() == id)) {
                state = true;
                return clientes.get(i);
            } else {
                i++;
            }
        }
        return null;
    }
    
    public Cliente getClienteNom(String Nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < clientes.size()) {
            if ((clientes.get(i).getName().equals(Nombre))) {
                state = true;
                return clientes.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public int getindex(int Id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == Id ) {
                state = true;
                return i;
            } else {
                i++;
            }
        }
        return i;
    }
    
    public String getNombre_id(int id) {
        boolean state = false;
        String nombre = "";
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                nombre = clientes.get(i).getName();
                return nombre;
            } else {
                i++;
            }
        }
        return nombre;
    }
    
    public boolean updateCliente(int index, Cliente client){
        clientes.set(index,client);
        return true;
    }

    public void printClienteSolo(int id) {
        int aux = id - 1;
        System.out.print("\nNombre: " + clientes.get(aux).getName());
        System.out.print("\nDirección: " + clientes.get(aux).getAddress());
        System.out.print("\nTelefono: " + clientes.get(aux).getPhone());
        System.out.println("\nNit: " + clientes.get(aux).getNit());
        System.out.println("\n");
    }

    public int eliminarCliente(int id) {
        boolean state = false;
        int i = 0;
        int modo = 0;
        if (clientes == null || clientes.isEmpty()) {
            modo = 1;
            return modo;
        }
        while (state == false && i < clientes.size()) {
            if (clientes.get(i).getId() == id) {
                state = true;
                clientes.remove(i);
                modo = 2;
                //System.out.println("Cliente con id " + (i+1) + " eliminado");
                return modo;
            } else {
                i++;
            }
        }
        return modo;
    }
}
