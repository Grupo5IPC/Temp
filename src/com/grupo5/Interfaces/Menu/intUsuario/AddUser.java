package com.grupo5.Interfaces.Menu.intUsuario;

import javax.swing.*;
import java.awt.*;

public class AddUser extends JPanel {

    public JLabel title;

    public AddUser() {

        this.setSize(500, 520);


        this.setVisible(true);
        setBackground(Color.cyan);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AddUser();
            }
        });
    }
}


