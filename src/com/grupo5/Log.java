package com.grupo5;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class Log {


    public static String n_reporte = "errors";
    public boolean m_ing = false;

    public Log() {
        Calendar fecha = Calendar.getInstance();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minutos = fecha.get(Calendar.MINUTE);
        n_reporte = "errors";
        try {
            File directorio = new File("Log de errores");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {

                } else {

                }
            }
            File archivo = new File("Log de errores/" + n_reporte + ".log");
            if (archivo.createNewFile()) {
                //System.out.println("reporte creado");
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }


    public static void add_Titulo(String cadena) {
        try {
            FileWriter fn = new FileWriter("Log de errores" + n_reporte + ".log", true);
            Calendar fecha = Calendar.getInstance();
            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minutos = fecha.get(Calendar.MINUTE);
            String aux = dia + "-" + mes + "-" + anio + " " + hora + "." + minutos + ": ";
            String texto = cadena + " " + aux + "\n";
            fn.write(texto);
            fn.close();
        } catch (Exception e) {

        }
    }

    public static void addCuerpo(String cadena) {
        try {
            FileWriter fn = new FileWriter("Log de errores/" + n_reporte + ".log", true);
            Calendar fecha = Calendar.getInstance();
            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minutos = fecha.get(Calendar.MINUTE);
            String aux = dia + "/" + mes + "/" + anio + "\t" + hora + ":" + minutos + "\t ";
            String texto = aux.concat(cadena + "\n");
            fn.write(texto);
            fn.close();
        } catch (Exception e) {

        }
    }
}