package com.grupo5.Fuentes;
import java.awt.Font;
import java.io.InputStream;
public class Fuentes {
    private Font font = null;
    public String RobotoRegular = "ttf\\Roboto-Bold.ttf";
    public String RobotoBold = "ttf\\Roboto-Black.ttf";
    public String OpensansBold = "ttf\\OpenSans-Bold.ttf";
    public String Opensansreg = "ttf\\OpenSans-Regular.ttf";
    //public String ITROMATRIC = "ltromatic.ttf";


    public Font fuente( String fontName, int estilo, float tamanio)
    {
        try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);

            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
    public Font fuenteOpensans( String fontName, int estilo, float tamanio)
    {
        try {
            //Se carga la fuente
            InputStream is =  getClass().getResourceAsStream(fontName);

            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }
}