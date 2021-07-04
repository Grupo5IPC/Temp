package com.grupo5.Facturas;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Productos.Producto;

import java.util.ArrayList;
import java.io.Serializable;

public class Gestor_Factura implements Serializable {

    ArrayList<Factura> facturas = new ArrayList();

    public Detalle crearDetalle(int id, Producto producto) {
// usar antes los metodos getId_nombre para obtener el id del producto por el nombre del mismo, luego usar el getProducto y conseguir el objeto Producto
        Detalle detalle = new Detalle(id, producto);
        return detalle;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public boolean insertarFactura(int id, Cliente cliente, String fecha, ArrayList<Detalle> detalle) {
        // para obtener el cliente usar antes el metodo getCliente del gesto Cliente con el id que se ingresa
        // esta devuelve un objeto cliente de esta forma en la factura tenemos, nit, nombre, etc.

        // usar el metodo crearDetalle para obtener el objeto Detalle, esto para que la factura a la hora de manejarla cuente con los datos necesarios
        Factura factura = new Factura(id, cliente, fecha, detalle);
        //
        if (facturas.add(factura)) {
            return true;
        }
        return false;
    }

    // lo hice rapido se puede usar el metodo .forEach si lo prefieren
    public void printFacturas() {
        if (facturas.isEmpty()) {
            System.out.println("No hay mas facturas");
        }
        for (int i = 0; i < facturas.size(); i++) {
            System.out.println("");
            System.out.println("Id Factura: " + facturas.get(i).getId());
            System.out.println("Cliente: " + facturas.get(i).getClient().getName());
            System.out.println("Fecha: " + facturas.get(i).getDate());
            System.out.println("--------Productos--------");
            for (int j = 0; j < facturas.get(i).getDetalles().size(); j++) {
                System.out.println("\tNombre:" + facturas.get(i).getDetalles().get(j).getProducto().getName());
                System.out.println("\tPrecio:" + facturas.get(i).getDetalles().get(j).getProducto().getPrice());
                System.out.println("");
            }
// si se dan cuenta si colocan un . luego del getDetalle les dejara tomar cualquier dato que deseen de el objeto detalle y a su vez si colocan esto facturas.get(i).getDetalle().getProducto().
// luego del punto les dejara tomar cualquier field del objeto producto

        }
    }

    public boolean verificarFactura(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    public void printFacturaSolo(int id) {
        int aux = id - 1;
        for (int i = 0; i < facturas.size(); i++) {
            System.out.println("");
            System.out.println("Id Factura: " + facturas.get(aux).getId());
            System.out.println("Cliente: " + facturas.get(aux).getClient().getName());
            System.out.println("Fecha: " + facturas.get(aux).getDate());
            System.out.println("--------Productos--------");
            for (int j = 0; j < facturas.get(aux).getDetalles().size(); j++) {
                System.out.println("\tNombre:" + facturas.get(aux).getDetalles().get(j).getProducto().getName());
                System.out.println("\tPrecio:" + facturas.get(aux).getDetalles().get(j).getProducto().getPrice());
                System.out.println("");
            }
        }
    }

    public int eliminarFactura(int id) {
        boolean state = false;
        int i = 0;
        int modo = 0;
        if (facturas.isEmpty() || facturas == null) {
            modo = 1;
            return modo;
        }
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                facturas.remove(i);
                System.out.println("Factura con id " + (i + 1) + " eliminado");
                modo = 2;
                return modo;
            } else {
                i++;
            }
        }
        return modo;
    }

    public boolean buscarFactura(int id) {
        boolean state = false;
        int i = 0;
        //System.out.println(clientes.size());
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                System.out.println("");
                System.out.println("Id Factura: " + facturas.get(i).getId());
                System.out.println("Cliente: " + facturas.get(i).getClient().getName());
                System.out.println("Fecha: " + facturas.get(i).getDate());
                System.out.println("--------Productos--------");
                for (int j = 0; j < facturas.get(i).getDetalles().size(); j++) {
                    System.out.println("\tNombre:" + facturas.get(i).getDetalles().get(j).getProducto().getName());
                    System.out.println("\tPrecio:" + facturas.get(i).getDetalles().get(j).getProducto().getPrice());
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

    public Factura getFactura(int id) {
        boolean state = false;
        int i = 0;
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == id) {
                state = true;
                return facturas.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    public void eliminarProductoFact(int idFactura, String nombreProd) {
        boolean state = false;
        boolean state2 = false;
        int i = 0;
        int j = 0;
        while (state == false && i < facturas.size()) {
            if (facturas.get(i).getId() == idFactura) {
                state = true;
                while (state2 == false && j < facturas.get(i).getDetalles().size()) {
                    if (nombreProd.equals(facturas.get(i).getDetalles().get(j).getProducto().getName())) {
                        state2 = true;
                        facturas.get(i).getDetalles().remove(j);
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
