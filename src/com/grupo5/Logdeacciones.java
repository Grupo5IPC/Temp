package com.grupo5;

import java.io.File;
import java.io.FileWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Logdeacciones {
    public static String nlog;

    public Logdeacciones() {
        nlog = "log";
        try {
            File directorio = new File("Log de acciones");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {

                } else {

                }
            }
            File archivo = new File("Log de acciones/" + nlog + ".log");
            if (archivo.createNewFile()) {
            } 
        } catch (Exception e) {
            System.out.println(e);

        }

    }


    public static void addlog(String cadena) {
        try {
            FileWriter fn = new FileWriter("Log de acciones/" + nlog + ".log", true);
            String formato = "dd-MM-yyyy HH:mm";
            DateTimeFormatter formato_a = DateTimeFormatter.ofPattern(formato);
            LocalDateTime ahora = LocalDateTime.now();
            String tiempo = formato_a.format(ahora);
            String accion = tiempo + "\t" + cadena + "\n";
            fn.write(accion);
            fn.close();
        } catch (Exception e) {

        }
    }
}
