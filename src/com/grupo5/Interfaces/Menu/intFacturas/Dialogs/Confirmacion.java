package com.grupo5.Interfaces.Menu.intFacturas.Dialogs;

import com.grupo5.Interfaces.Menu.intFacturas.CRUD_factura;

import javax.swing.*;
import java.awt.*;

public class Confirmacion extends JDialog {
    public Confirmacion(CRUD_factura parent, boolean modal) {

        //setUndecorated(true);
        /*
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });
        */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(600, 300);
        setBounds(0, 0, dim.width, 350);
        setAlwaysOnTop(true);

        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setModal(modal);


    }
}
