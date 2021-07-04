package com.grupo5;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.sun.org.apache.xpath.internal.operations.Mod;

public class Opciones {
    public static Gestor_Producto Producto;
    public static Gestor_usuario Usuario;
    public static Gestor_cliente Cliente;
    public static int Modo;

    public Opciones(Gestor_cliente cliente, Gestor_usuario usuario, Gestor_Producto producto, int modo){
        Producto = producto;
        Usuario = usuario;
        Cliente = cliente;
        Modo = modo;
    }
}
