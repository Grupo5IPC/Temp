package com.grupo5.Interfaces.Menu;

import com.grupo5.Fuentes.Fuentes;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);

    public Dashboard(){
        Fuentes fuente = new Fuentes();
        setSize(898, 300);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

    }
}
