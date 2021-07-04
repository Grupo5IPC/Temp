package com.grupo5;

import com.google.gson.*;
import com.grupo5.Clientes.Cliente;
import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Detalle;
import com.grupo5.Facturas.Factura;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Interfaces.Menu.Principal;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Productos.Ingrediente;
import com.grupo5.Productos.Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.grupo5.Usuarios.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Restaurante Nuevo;
    public static String tipoDeCarga;
    public static Gestor_usuario usuario;
    public static Gestor_cliente cliente;
    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Log log;
    public static String usuarioLog;
    public static Logdeacciones logdeacciones;
    public static Ingrediente ingrediente = new Ingrediente();
    public static String ruta;
    public static int modo = 0;

    public static void main(String[] args) {
        // write your code here
        // Aqui ira el menu, la carga de los jsons iniciales, etc. ver el grupo xd

        // en la instancia de la clase opciones se pide un entero que es el modo
        // el modo es la seleccion entre json o bin
        leerConfig();
        logdeacciones = new Logdeacciones();
        log = new Log();
        leerClientes();
        leerUsuarios();
        leerProductos();
        leerFacturas();
        //desserializarObjetos();
        if ("json".equals(tipoDeCarga)) {
            Opciones op = new Opciones(cliente, usuario, producto, 1);
        } else if ("ipcrm".equals(tipoDeCarga)) {
            Opciones op = new Opciones(cliente, usuario, producto, 0);
        } else {
            System.out.println("ERROR: La carga no es un archivo json o binario");
        }
        usuario.print_usu();

        Principal p = new Principal(usuario, producto, factura, cliente);
        p.setVisible(true);
    }

    public static void menuPrincipal() {
        Scanner login = new Scanner(System.in);
        Scanner MenuPrincipal = new Scanner(System.in);
        try {
            //usuario.print_usu();
            //cliente.printClientes();
            System.out.println("*******************************");
            System.out.println("*           LOGIN             *");
            System.out.println("*******************************");
            System.out.println("* Ingrese su usuario          *");
            String user = login.nextLine();
            System.out.println("* Ingrese su contraseña       *");
            String pass = login.nextLine();
            System.out.println("*******************************");
            int Opciones = 0;

            if (usuario.verificar(user, pass)) {
                usuarioLog = user;
                logdeacciones.addlog(user + ": Inicio de sesión exitoso");
                do {
                    try {
                        System.out.println("*******************************");
                        System.out.println("*       MENÚ PRINCIPAL        *");
                        System.out.println("*******************************");
                        System.out.println("* 1) Informacion Restaurante  *");
                        System.out.println("* 2) Usuarios                 *");
                        System.out.println("* 3) Productos                *");
                        System.out.println("* 4) Clientes                 *");
                        System.out.println("* 5) Facturas                 *");
                        System.out.println("* 6) Guardar Cambios          *");
                        System.out.println("* 7) Salir                    *");
                        System.out.println("*******************************");
                        System.out.print("Elige una opcion: ");
                        Opciones = MenuPrincipal.nextInt();
                        switch (Opciones) {
                            case 1:
                                Nuevo.printRestaurante();
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 2:
                                do {
                                    //USUARIOS
                                    System.out.println("*******************************");
                                    System.out.println("*          USUARIOS           *");
                                    System.out.println("*******************************");
                                    System.out.println("* 1) Listado de Usuarios      *");
                                    System.out.println("* 2) Eliminar Usuario         *");
                                    System.out.println("* 3) Ver Usuario              *");
                                    System.out.println("* 4) Menu Principal           *");
                                    System.out.println("*******************************");
                                    System.out.print("Elige una opcion: ");
                                    Opciones = MenuPrincipal.nextInt();
                                    switch (Opciones) {
                                        case 1:
                                            System.out.println("");
                                            usuario.print_usu();
                                            System.out.println("");
                                            break;

                                        case 2:
                                            Scanner eliminar = new Scanner(System.in);
                                            System.out.println("Ingrese el username del usuario a eliminar: ");
                                            String eliminarUser = eliminar.nextLine();
                                            int res = usuario.eliminarUsuario(eliminarUser);
                                            if (res == 1) {
                                                log.addCuerpo("USERS: No existen usuarios a eliminar");
                                            } else if (res == 2) {
                                                //System.out.println("USERS: El usuario se ha eliminado");
                                                if (usuarioLog.equals(eliminarUser)) {
                                                    System.out.println("Se ha cerrado la sesion");
                                                }
                                                logdeacciones.addlog(user + ": Eliminó al usuario \"" + eliminarUser + "\" ");
                                                serializarObjetos(modo);
                                                if (usuarioLog.equals(eliminarUser)) {
                                                    System.out.println("Se ha cerrado la sesion");
                                                    menuPrincipal();
                                                }
                                            } else if (res == 0) {
                                                System.out.println("El usuario ingresado no existe");
                                            }
                                            break;

                                        case 3:
                                            Scanner buscar = new Scanner(System.in);
                                            System.out.println("Ingrese el username del usuario a buscar: ");
                                            String buscarUser = buscar.nextLine();
                                            System.out.println(buscarUser);
                                            if (usuario.buscarUsuario(buscarUser) == true) {

                                            } else {
                                                System.out.println("No se ha encontrado el usuario");
                                            }
                                            break;

                                        case 4:
                                            //VUELTA AL MENU PRINCIPAL
                                            break;

                                        default:
                                            System.out.println("Seleccione una opcion");
                                            break;
                                    }
                                } while (Opciones != 4);
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 3:
                                //PRODUCTOS
                                do {
                                    System.out.println("*******************************");
                                    System.out.println("*          PRODUCTOS          *");
                                    System.out.println("*******************************");
                                    System.out.println("* 1) Listado de Productos     *");
                                    System.out.println("* 2) Eliminar Producto        *");
                                    System.out.println("* 3) Ver Producto             *");
                                    System.out.println("* 4) Menu Principal           *");
                                    System.out.println("*******************************");
                                    System.out.print("Elige una opcion: ");
                                    Opciones = MenuPrincipal.nextInt();
                                    switch (Opciones) {
                                        case 1:
                                            producto.printProductos();
                                            break;

                                        case 2:
                                            Scanner eliminar = new Scanner(System.in);
                                            System.out.println("Ingrese el id del producto a eliminar: ");
                                            int eliminarId = eliminar.nextInt();
                                            String nombre = producto.getNombre_id(eliminarId);
                                            if (producto.verificarProducto(eliminarId)) {
                                                producto.eliminarProducto(eliminarId);

                                                serializarObjetos(modo);
                                                logdeacciones.addlog(user + ": Eliminó el producto \"" + nombre + "\" con id " + eliminarId);
                                            } else {
                                                log.addCuerpo("PRODUCTS: No existe el id " + eliminarId + ", no se elimino");
                                            }

                                            break;

                                        case 3:
                                            Scanner buscar = new Scanner(System.in);
                                            System.out.println("Ingrese el id del producto a buscar: ");
                                            int buscarId = buscar.nextInt();
                                            if (producto.buscarProducto(buscarId)) {
                                                //producto.printProductoSolo(buscarId);
                                            } else {
                                                System.out.println("No se encontro el producto");
                                            }
                                            break;

                                        case 4:
                                            //VUELTA AL MENU PRINCIPAL
                                            break;

                                        default:
                                            System.out.println("Seleccione una opcion");
                                            break;
                                    }
                                } while (Opciones != 4);

                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 4:
                                //CLIENTES
                                do {
                                    System.out.println("*******************************");
                                    System.out.println("*          CLIENTES           *");
                                    System.out.println("*******************************");
                                    System.out.println("* 1) Listado de Clientes      *");
                                    System.out.println("* 2) Eliminar Cliente         *");
                                    System.out.println("* 3) Ver Cliente              *");
                                    System.out.println("* 4) Menu Principal           *");
                                    System.out.println("*******************************");
                                    System.out.print("Elige una opcion: ");
                                    Opciones = MenuPrincipal.nextInt();
                                    switch (Opciones) {
                                        case 1:
                                            System.out.println("");
                                            cliente.printClientes();
                                            System.out.println("");
                                            break;

                                        case 2:
                                            Scanner eliminar = new Scanner(System.in);
                                            System.out.println("Ingrese el id del cliente a eliminar: ");
                                            int eliminarId = eliminar.nextInt();
                                            String nombre = cliente.getNombre_id(eliminarId);
                                            int res = cliente.eliminarCliente(eliminarId);

                                            if (res == 1) {
                                                log.addCuerpo("CLIENTS: No existen clientes ingresados, no se elimino");
                                            } else if (res == 2) {
                                                System.out.println("Cliente eliminado correctamente");
                                                logdeacciones.addlog(user + ": Eliminó al cliente \"" + nombre + "\" con id " + eliminarId);
                                                serializarObjetos(modo);
                                            } else if (res == 0) {
                                                log.addCuerpo("CLIENTS: No existe el id " + eliminarId + ", no se elimino");
                                            }

                                            break;

                                        case 3:
                                            Scanner buscar = new Scanner(System.in);
                                            System.out.println("Ingrese el id del cliente a buscar: ");
                                            int buscarId = buscar.nextInt();
                                            if (cliente.buscarCliente(buscarId)) {

                                            } else {
                                                System.out.println("no se ha encontrado el cliente");
                                            }
                                            break;

                                        case 4:
                                            //VUELTA AL MENU PRINCIPAL
                                            break;

                                        default:
                                            System.out.println("Seleccione una opcion");
                                            break;
                                    }
                                } while (Opciones != 4);
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 5:
                                //FACTURAS
                                do {
                                    System.out.println("*******************************");
                                    System.out.println("*          FACTURAS           *");
                                    System.out.println("*******************************");
                                    System.out.println("* 1) Listado de Facturas      *");
                                    System.out.println("* 2) Eliminar Factura         *");
                                    System.out.println("* 3) Ver Factura              *");
                                    System.out.println("* 4) Menu Principal           *");
                                    System.out.println("*******************************");
                                    System.out.print("Elige una opcion: ");
                                    Opciones = MenuPrincipal.nextInt();
                                    switch (Opciones) {
                                        case 1:
                                            System.out.println("");
                                            factura.printFacturas();
                                            System.out.println("");
                                            break;

                                        case 2:
                                            Scanner eliminar = new Scanner(System.in);
                                            System.out.println("Ingrese el id de la factura a eliminar: ");
                                            int eliminarId = eliminar.nextInt();
                                            int res = factura.eliminarFactura(eliminarId);
                                            if (res == 1) {
                                                log.addCuerpo("INVOICES: No existen facturas ingresadas, no se elimino");
                                            } else if (res == 2) {
                                                System.out.println("Factura eliminado correctamente");
                                                logdeacciones.addlog(user + ": Eliminó la factura con id " + eliminarId);
                                                serializarObjetos(modo);
                                            } else if (res == 0) {
                                                log.addCuerpo("INVOICES: No existe el id " + eliminarId + ", no se elimino");
                                            }
                                            break;

                                        case 3:
                                            Scanner buscar = new Scanner(System.in);
                                            System.out.println("Ingrese el id de la factura a buscar: ");
                                            int buscarId = buscar.nextInt();
                                            if (factura.buscarFactura(buscarId)) {

                                            } else {
                                                System.out.println("No se ha encontrado la factura");
                                            }
                                            break;

                                        case 4:
                                            //VUELTA AL MENU PRINCIPAL
                                            break;

                                        default:
                                            System.out.println("Seleccione una opcion");
                                            break;
                                    }
                                } while (Opciones != 4);
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 6:
                                //GUARDAR CAMBIOS
                                do {
                                    System.out.println("*******************************");
                                    System.out.println("*       GUARDAR CAMBIOS       *");
                                    System.out.println("*******************************");
                                    System.out.println("* 1) Archivo JSON             *");
                                    System.out.println("* 2) Archivo Binario          *");
                                    System.out.println("* 3) Menu Principal           *");
                                    System.out.println("*******************************");
                                    System.out.print("Elige una opcion: ");
                                    Opciones = MenuPrincipal.nextInt();
                                    switch (Opciones) {
                                        case 1:
                                            //JSON
                                            serializarObjetos(Opciones);
                                            System.out.println("Serializacion correcta");
                                            break;

                                        case 2:
                                            //BINARIO
                                            serializarObjetos(Opciones);
                                            System.out.println("Serializacion correcta");

                                            break;

                                        case 3:
                                            //VUELTA AL MENU PRINCIPAL
                                            break;

                                        default:
                                            System.out.println("Seleccione una opcion");
                                            break;
                                    }
                                } while (Opciones != 3);
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            case 7:
                                //SALIDA
                                System.out.println("Has salido del programa");
                                break;

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
                            default:
                                System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                                break;
                        }
                    } catch (Exception e) {
                        MenuPrincipal = new Scanner(System.in);
                        System.out.println("Advertencia: Debes elegir una opción de 1 a x");
                    }
                } while (Opciones != 7);
            } else {
                System.out.println("\n");
                System.out.println("Datos incorrectos, prueba de nuevo");
                System.out.println("\n");
                menuPrincipal();

                logdeacciones.addlog(user + ": Inicio de sesión fallido" + "\t");
            }
        } catch (Exception e) {
            System.out.println("Has hecho una acción no valida,");
            System.out.println("Vuelve a intentarlo");
        }
    }

    public static void leerConfig() {

        File archivo;
        FileReader fr = null;
        BufferedReader br;
        String Contenido = "";
        try {
            archivo = new File("config.json");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String Linea;

            while ((Linea = br.readLine()) != null) {
                Contenido += Linea;
            }

            JsonParser Parser = new JsonParser();
            JsonObject GsonObj = (JsonObject) Parser.parse(Contenido);

            String nombre = GsonObj.get("name").getAsString();
            String direccion = GsonObj.get("address").getAsString();
            int numero = GsonObj.get("phone").getAsInt();
            tipoDeCarga = GsonObj.get("load").getAsString();
            //System.out.println(tipoDeCarga);
            if (tipoDeCarga.equals("bin")) {
                tipoDeCarga = "ipcrm";
                modo = 2;
            }
            Nuevo = new Restaurante(nombre, direccion, numero, tipoDeCarga);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }

    public static void leerClientes() {
        if (tipoDeCarga.equals("json")) {
            File archivo;
            FileReader fr = null;
            BufferedReader br;
            String Contenido = "";
            try {
                archivo = new File("clients." + tipoDeCarga);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String Linea;

                while ((Linea = br.readLine()) != null) {
                    Contenido += Linea;
                }
                //System.out.println(Contenido);
                //System.out.println(cliente);
                if (cliente == null) {
                    // System.out.println("nulo");
                    cliente = new Gestor_cliente();
                }
                JsonParser Parser = new JsonParser();
                JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

                for (int i = 0; i < GsonArr.size(); i++) {
                    JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                    int id = GsonObj.get("id").getAsInt();
                    String nombre = GsonObj.get("name").getAsString();
                    String direccion = GsonObj.get("address").getAsString();
                    int numero = GsonObj.get("phone").getAsInt();
                    String nit = GsonObj.get("nit").getAsString();
                    if (cliente.verificarCliente(id) == false) {
                        cliente.insertarCliente(id, nombre, direccion, numero, nit);
                    } else {
                        log.addCuerpo("CLIENTS: El id " + id + " ya existe, no se registro");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    System.out.println(e2);
                }
            }
        } else {
            try {
                //Deserializar clientes
                File archivo1 = new File("Guardado/BIN/clients.ipcrm");
                System.out.println("La ruta del fichero es:Guardado/BIN/");
                if (archivo1.exists()) {

                    try {
                        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo1));
                        cliente = (Gestor_cliente) entrada.readObject();
                        //cliente.printClientes();
                        entrada.close();
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void leerUsuarios() {
        if (tipoDeCarga.equals("json")) {

            File archivo;
            FileReader fr = null;
            BufferedReader br;
            String Contenido = "";
            try {
                archivo = new File("users." + tipoDeCarga);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String Linea;

                while ((Linea = br.readLine()) != null) {
                    Contenido += Linea;
                }
                if (usuario == null) {
                    usuario = new Gestor_usuario();
                }
                JsonParser Parser = new JsonParser();
                JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

                for (int i = 0; i < GsonArr.size(); i++) {
                    JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                    String nombre = GsonObj.get("username").getAsString();
                    String password = GsonObj.get("password").getAsString();
                    if (usuario.verificarExistencia(nombre) == false) {
                        usuario.Ins_usu(nombre, password);
                    } else {
                        log.addCuerpo("USERS: El nombre de usuario " + nombre + " ya existe, no se registro");
                    }
                }

            } catch (Exception e) {
                System.out.println("user");
                System.out.println(e);
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    System.out.println("user");
                    System.out.println(e2);
                }
            }
        } else {
            try {
                //Deserializar usuarios
                File archivo2 = new File("Guardado/BIN/users.ipcrm");
                // System.out.println("La ruta del fichero es: " + archivo1.getAbsolutePath());
                if (archivo2.exists()) {

                    try {
                        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo2));
                        usuario = (Gestor_usuario) entrada.readObject();
                        entrada.close();
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void leerProductos() {
        if (tipoDeCarga.equals("json")) {
            File archivo;
            FileReader fr = null;
            BufferedReader br;
            String Contenido = "";
            try {
                archivo = new File("products." + tipoDeCarga);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String Linea;

                while ((Linea = br.readLine()) != null) {
                    Contenido += Linea;
                }
                if (producto == null) {
                    producto = new Gestor_Producto();
                }
                JsonParser Parser = new JsonParser();
                JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

                for (int i = 0; i < GsonArr.size(); i++) {
                    JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                    int id = GsonObj.get("id").getAsInt();
                    String nombre = GsonObj.get("name").getAsString();
                    String descripcion = GsonObj.get("description").getAsString();
                    double costo = GsonObj.get("cost").getAsInt();
                    double precio = GsonObj.get("price").getAsInt();

                    JsonArray Ingred = GsonObj.get("ingredients").getAsJsonArray();
                    ArrayList<Ingrediente> aux = new ArrayList(Ingred.size());

                    for (int j = 0; j < Ingred.size(); j++) {
                        JsonObject GsonObj2 = Ingred.get(j).getAsJsonObject();
                        String nombreIng = GsonObj2.get("name").getAsString();
                        int cantidadIng = GsonObj2.get("quantity").getAsInt();
                        String unidadesIng = GsonObj2.get("units").getAsString();
                        //----------------------------1----------------------------
                        Ingrediente auxIng = new Ingrediente(nombreIng, cantidadIng, unidadesIng);
                        aux.add(auxIng);
                    }
                    if (producto.verificarProducto(id) == false) {
                        //----------------------------2----------------------------
                        producto.insertarProducto(id, nombre, descripcion, costo, precio, aux);
                    } else {
                        log.addCuerpo("PRODUCTOS: El id " + id + " ya existe, no se registro");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                }
            }
        } else {
            try {
                //Deserializar productos
                File archivo3 = new File("Guardado/BIN/products.ipcrm");
                //System.out.println("La ruta del fichero es: " + archivo1.getAbsolutePath());
                if (archivo3.exists()) {

                    try {
                        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo3));
                        producto = (Gestor_Producto) entrada.readObject();
                        entrada.close();
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public static void leerFacturas() {
        if (tipoDeCarga.equals("json")) {
            File archivo;
            FileReader fr = null;
            BufferedReader br;
            String Contenido = "";
            try {
                archivo = new File("invoices." + tipoDeCarga);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String Linea;

                while ((Linea = br.readLine()) != null) {
                    Contenido += Linea;
                }
                if (factura == null) {
                    factura = new Gestor_Factura();
                }
                JsonParser Parser = new JsonParser();
                JsonArray GsonArr = Parser.parse(Contenido).getAsJsonArray();

                for (int i = 0; i < GsonArr.size(); i++) {
                    JsonObject GsonObj = GsonArr.get(i).getAsJsonObject();

                    int id = GsonObj.get("id").getAsInt();
                    int idcliente = GsonObj.get("client").getAsInt();
                    Cliente auxclient = cliente.getCliente(idcliente);
                    String fecha = GsonObj.get("date").getAsString();

                    JsonArray Prod = GsonObj.get("products").getAsJsonArray();
                    ArrayList<Detalle> auxdetalle = new ArrayList(Prod.size());

                    for (int j = 0; j < Prod.size(); j++) {
                        try {
                            JsonObject GsonObj2 = Prod.get(j).getAsJsonObject();
                            String nombreProd = GsonObj2.get("name").getAsString();
                            //Encontrar Id con el Nombre
                            //Encontrar un Prodcuto con el Id
                            int x = 0;
                            boolean encontrado = false;
                            while (x < producto.contProductos() && encontrado == false) {
                                boolean found = producto.verificarProducto(producto.getId_nombre(nombreProd));
                                if (found == true) {
                                    encontrado = true;
                                    int auxProductId = producto.getId_nombre(nombreProd);
                                    Producto auxProduct = producto.getProductos(auxProductId);
                                    Detalle detail = new Detalle(id, auxProduct);
                                    auxdetalle.add(detail);
                                } else {
                                    i++;
                                }
                            }
                            //int cantidadIng = GsonObj2.get("price").getAsInt();
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                    if (factura.verificarFactura(id) == false) {
                        factura.insertarFactura(id, auxclient, fecha, auxdetalle);
                    } else {
                        log.addCuerpo("INVOICES: El id" + id + " ya existe, no se registro");
                    }
                }

            } catch (Exception e) {
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                }
            }
        } else {
            try {

                //Deserializar facturas
                File archivo4 = new File("Guardado/BIN/invoices.ipcrm");
                //System.out.println("La ruta del fichero es: " + archivo1.getAbsolutePath());
                if (archivo4.exists()) {

                    try {
                        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo4));
                        factura = (Gestor_Factura) entrada.readObject();
                        entrada.close();
                    } catch (Exception e) {
                        // e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void desserializarObjetos() {
        if (tipoDeCarga.equals("json")) {

            try {
                File directorio = new File("Guardado/JSON");
                if (!directorio.exists()) {
                    if (directorio.mkdirs()) {
                    } else {
                    }
                }

                // Serializar usuarios
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                ArrayList<Usuario> array = usuario.getArray();
                String g = gson.toJson(array);
                FileWriter writer1 = new FileWriter("users.json", true);
                writer1.write(g);
                writer1.close();
                //System.out.println(g);

                // Serializar clientes
                ArrayList<Cliente> clientes = cliente.getClientes();
                String g2 = gson.toJson(clientes);
                FileWriter writer2 = new FileWriter("clients.json", true);
                writer2.write(g2);
                writer2.close();
                //System.out.println(g2);

                // Serializar productos
                ArrayList<Producto> array2 = producto.getProductos();
                String g3 = gson.toJson(array2);
                FileWriter writer3 = new FileWriter("products.json", true);
                writer3.write(g3);
                writer3.close();
                //System.out.println(g3);

                // Serializar facturas
                ArrayList<Factura> array4 = factura.getFacturas();
                String g4 = gson.toJson(array4);
                FileWriter writer4 = new FileWriter("invoices.json", true);
                writer4.write(g4);
                writer4.close();
                //System.out.println(g4);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                File directorio = new File("Guardado/BIN");

                if (!directorio.exists()) {
                    if (directorio.mkdirs()) {

                    } else {

                    }
                }
            } catch (Exception e) {

            }
            File archivo1 = new File("Guardado/BIN/clients.ipcrm");

            try {
                if (!archivo1.exists()) {
                    archivo1.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo1));
                salida.writeObject(cliente);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo2 = new File("Guardado/BIN/users.ipcrm");
            try {
                if (!archivo2.exists()) {
                    archivo2.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo2));
                salida.writeObject(usuario);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo3 = new File("Guardado/BIN/products.ipcrm");
            try {
                if (!archivo3.exists()) {
                    archivo3.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo3));
                salida.writeObject(producto);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo4 = new File("Guardado/BIN/invoices.ipcrm");
            try {
                if (!archivo4.exists()) {
                    archivo4.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo4));
                salida.writeObject(factura);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void serializarObjetos(int modo) {
        if (modo == 0 || modo == 1) {

            try {

                // Serializar usuarios
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                ArrayList<Usuario> array = usuario.getArray();
                String g = gson.toJson(array);

                FileWriter writer1 = new FileWriter("users.json", false);
                writer1.write(g);
                writer1.close();
                //System.out.println(g);

                // Serializar clientes
                ArrayList<Cliente> clientes = cliente.getClientes();
                String g2 = gson.toJson(clientes);
                FileWriter writer2 = new FileWriter("clients.json", false);
                writer2.write(g2);
                writer2.close();
                //System.out.println(g2);

                // Serializar productos
                ArrayList<Producto> array2 = producto.getProductos();
                String g3 = gson.toJson(array2);
                FileWriter writer3 = new FileWriter("products.json", false);
                writer3.write(g3);
                writer3.close();
                //System.out.println(g3);

                // Serializar facturas
                ArrayList<Factura> array4 = factura.getFacturas();
                String g4 = gson.toJson(array4);
                FileWriter writer4 = new FileWriter("invoices.json", false);
                writer4.write(g4);
                writer4.close();
                //System.out.println(g4);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                File directorio = new File("Guardado/BIN");

                if (!directorio.exists()) {
                    if (directorio.mkdirs()) {

                    } else {

                    }
                }
            } catch (Exception e) {

            }
            File archivo1 = new File("Guardado/BIN/clients.ipcrm");

            try {
                if (!archivo1.exists()) {
                    archivo1.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo1));
                salida.writeObject(cliente);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo2 = new File("Guardado/BIN/users.ipcrm");
            try {
                if (!archivo2.exists()) {
                    archivo2.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo2));
                salida.writeObject(usuario);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo3 = new File("Guardado/BIN/products.ipcrm");
            try {
                if (!archivo3.exists()) {
                    archivo3.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo3));
                salida.writeObject(producto);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            File archivo4 = new File("Guardado/BIN/invoices.ipcrm");
            try {
                if (!archivo4.exists()) {
                    archivo4.createNewFile();
                }

                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(archivo4));
                salida.writeObject(factura);
                salida.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
