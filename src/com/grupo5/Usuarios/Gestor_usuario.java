package com.grupo5.Usuarios;

import java.io.Serializable;
import java.util.ArrayList;

public class Gestor_usuario implements Serializable {

    ArrayList<Usuario> usuarios = new ArrayList();

    public boolean Ins_usu(String nombre, String pass) {
        Usuario user = new Usuario(nombre, pass);
        usuarios.add(user);
        // System.out.println("Ingresado");
            return true;

    }
    public boolean buscarUsuario(String username){
        boolean state = false;
        int i = 0;

        while (state == false && i < usuarios.size()) {

            if (usuarios.get(i).getUsername().equals( username)) {

                System.out.print("\nNombre: " + usuarios.get(i).getUsername());
                System.out.print("\nPassword: " + usuarios.get(i).getPassword());

                System.out.println("\n");
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void print_usu() {
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.print(usuarios.get(i).getUsername() + ",");
            System.out.println(usuarios.get(i).getPassword());

        }
    }
    public ArrayList<Usuario> getArray(){
        return usuarios;
    }

    public boolean verificar(String nombre, String pass) {
        boolean state = false;
        int i = 0;
        while (state == false && i < usuarios.size()) {

            if (usuarios.get(i).getUsername().equals(nombre) && usuarios.get(i).getPassword().equals(pass)) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean verificarExistencia(String nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < usuarios.size()) {
            if (usuarios.get(i).getUsername().equals(nombre) ) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
    public boolean updateUsuario(int index, Usuario user){
        usuarios.set(index,user);
        return true;
    }

    public int getindex(String nombre) {
        boolean state = false;
        int i = 0;
        while (state == false && i < usuarios.size()) {
            if (usuarios.get(i).getUsername().equals(nombre) ) {
                state = true;
                return i;
            } else {
                i++;
            }
        }
        return i;
    }
    public void printUsuarioSolo(String nombre) {
        int i = 0;
        for (i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getUsername().equals(nombre)) {
                System.out.print("\nUsuario: " + usuarios.get(i).getUsername());
                System.out.print("\nPassword: " + usuarios.get(i).getPassword());
                System.out.println("\n");    
            }
        }
    }
            
    public int eliminarUsuario(String nombre) {
        int i = 0;
        int modo = 0;
        if (usuarios == null || usuarios.isEmpty()){
            modo = 1;
            return modo;
        }

        while (i < usuarios.size()) {
            if (usuarios.get(i).getUsername().equals(nombre)) {
                usuarios.remove(i);
                modo = 2;
                System.out.println("Usuario con username " + nombre + " eliminado");
                return modo;

            } else {
                i++;
            }
        }
        return modo = 3;
    }

    /*
    public boolean verificar_exis(String usu) {
        for (int i = 0; i < 10; i++) {
            if (usuarios[i] != null) {
                if ((usuarios[i].getUsuario().equals(usu))) {
                    return true;
                }
            }
        }
        return false;
    }



    public String buscar_nombre_USU(String nom) {
        String nombre = "";
        for (int i = 0; i < 10; i++) {

            if (usuarios[i] != null) {
                if (usuarios[i].getUsuario().equals(nom)) {
                    nombre = usuarios[i].getUsuario();
                    break;
                }
            }
        }
        return nombre;
    }



     */
}
