package com.grupo5.Interfaces.Menu.intCliente.Dialogs;

import com.grupo5.Clientes.Cliente;
import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.Colors;
import com.grupo5.Interfaces.Menu.intCliente.CRUD_cliente;
import static com.grupo5.Interfaces.Menu.intCliente.Dialogs.AddClient.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class updateClient extends JDialog {

    public static Gestor_cliente cliente;

    public JLabel title;
    public CRUD_cliente Crud_cliente;
    public JButton acep;
    public JPanel Parent;
    public int ID;
    public int index;
    public Colors c = new Colors();
    public Color azul = new Color(42, 52, 67);
    public Color fondo = new Color(157, 207, 255);

    public updateClient(Gestor_cliente client, boolean modal, int Id) {
        ID = Id;
        Parent = new JPanel();
        cliente = client;
        index = cliente.getindex(Id);
        setUndecorated(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));
            }
        });

        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(550, 350);
        setBounds(0, 0, 650, 650);
        setAlwaysOnTop(true);

        //this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setModal(modal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBackground(fondo);
        setLayout(null);
        setLocationRelativeTo(null);
        labels();
        Parent.setBounds(0, 0, this.getWidth(), this.getHeight());
        Parent.setLayout(null);
        Parent.setBackground(fondo);
        add(Parent);

    }

    void labels() {
        Fuentes fuente = new Fuentes();
        title = new JLabel("Modificar Cliente: " + cliente.getCliente(ID).getName());
        title.setFont(fuente.fuente(fuente.RobotoBold, 1, 25));
        title.setBounds(130, 30, 420, 60);
        title.setForeground(c.fondo);
        Parent.add(title);
        JLabel cerrar = new JLabel("x");
        cerrar.setFont(fuente.fuente(fuente.RobotoBold, 1, 14));
        cerrar.setForeground(c.fondo);
        cerrar.setBounds((int) this.getSize().getWidth() - 15, 0, 30, 30);
        Parent.add(cerrar);

        JLabel Id = new JLabel("Id");
        Id.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Id.setBounds(100, 100, 100, 60);
        Id.setForeground(c.fondo);
        Parent.add(Id);

        JLabel nombre = new JLabel("Nombre");
        nombre.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        nombre.setBounds(100, 190, 100, 60);
        nombre.setForeground(c.fondo);
        Parent.add(nombre);

        JLabel Direccion = new JLabel("Dirección");
        Direccion.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Direccion.setBounds(100, 280, 100, 60);
        Direccion.setForeground(c.fondo);
        Parent.add(Direccion);

        JLabel Telefono = new JLabel("Telefono");
        Telefono.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Telefono.setBounds(100, 370, 100, 60);
        Telefono.setForeground(c.fondo);
        Parent.add(Telefono);

        JLabel Nit = new JLabel("NIT");
        Nit.setFont(fuente.fuente(fuente.RobotoRegular, 0, 20));
        Nit.setBounds(100, 460, 100, 60);
        Nit.setForeground(c.fondo);
        Parent.add(Nit);
        //-------------------------------------------------------------------------------------------

        JTextField IdClient = new JTextField(" Id del cliente");
        IdClient.setBackground(fondo);
        IdClient.setForeground(c.fondo);
        IdClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        IdClient.setBorder(BorderFactory.createEmptyBorder());
        IdClient.setBounds(210, 110, 200, 40);
        IdClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IdClient.setText("");
            }
        });
        Parent.add(IdClient);
        JSeparator separador = new JSeparator();
        separador.setBackground(c.azul);
        separador.setOrientation(0);
        separador.setForeground(c.fondo);
        separador.setBounds(210, 155, 200, 5);
        Parent.add(separador);

        JTextField NombreClient = new JTextField(" Nombre");
        NombreClient.setBackground(fondo);
        NombreClient.setForeground(c.fondo);
        NombreClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        NombreClient.setBorder(BorderFactory.createEmptyBorder());
        NombreClient.setBounds(210, 200, 200, 40);
        NombreClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NombreClient.setText("");
            }
        });
        Parent.add(NombreClient);
        JSeparator separador2 = new JSeparator();
        separador2.setBackground(c.azul);
        separador2.setOrientation(0);
        separador2.setForeground(c.fondo);
        separador2.setBounds(210, 245, 200, 5);
        Parent.add(separador2);

        JTextField DirClient = new JTextField(" Dirección");
        DirClient.setBackground(fondo);
        DirClient.setForeground(c.fondo);
        DirClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        DirClient.setBorder(BorderFactory.createEmptyBorder());
        DirClient.setBounds(210, 290, 200, 40);
        DirClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DirClient.setText("");
            }
        });
        Parent.add(DirClient);
        JSeparator separador3 = new JSeparator();
        separador3.setBackground(c.azul);
        separador3.setOrientation(0);
        separador3.setForeground(c.fondo);
        separador3.setBounds(210, 335, 200, 5);
        Parent.add(separador3);

        JTextField TelClient = new JTextField(" Teléfono");
        TelClient.setBackground(fondo);
        TelClient.setForeground(c.fondo);
        TelClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        TelClient.setBorder(BorderFactory.createEmptyBorder());
        TelClient.setBounds(210, 380, 200, 40);
        TelClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TelClient.setText("");
            }
        });
        Parent.add(TelClient);
        JSeparator separador4 = new JSeparator();
        separador4.setBackground(c.azul);
        separador4.setOrientation(0);
        separador4.setForeground(c.fondo);
        separador4.setBounds(210, 425, 200, 5);
        Parent.add(separador4);

        JTextField NitClient = new JTextField(" NIT");
        NitClient.setBackground(fondo);
        NitClient.setForeground(c.fondo);
        NitClient.setFont(fuente.fuente(fuente.Opensansreg, 0, 15));
        NitClient.setBorder(BorderFactory.createEmptyBorder());
        NitClient.setBounds(210, 470, 200, 40);
        NitClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NitClient.setText("");
            }
        });
        Parent.add(NitClient);
        JSeparator separador5 = new JSeparator();
        separador5.setBackground(c.azul);
        separador5.setOrientation(0);
        separador5.setForeground(c.fondo);
        separador5.setBounds(210, 515, 200, 5);
        Parent.add(separador5);

        //-------------------------------------------------------------------------------------------
        JButton aceptar = new JButton("Agregar");
        aceptar.setBackground(azul);
        aceptar.setBounds(NitClient.getX() + 30, NitClient.getY() + 80, 140, 45);
        aceptar.setFont(fuente.fuente(fuente.RobotoBold, 0, 16));
        aceptar.setForeground(c.textoSecundario);
        aceptar.setBorder(BorderFactory.createLineBorder(c.textoSecundario));
        aceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                aceptar.setForeground(c.texto);
                aceptar.setBackground(c.fondo);
                aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                aceptar.setBackground(azul);
                aceptar.setForeground(c.textoSecundario);
                aceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                aceptar.setBackground(azul);
                aceptar.setForeground(c.textoSecundario);
                aceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                int parseId = Integer.parseInt(IdClient.getText());
                int TelParse = Integer.parseInt((String) TelClient.getText());
                if (ID == parseId) {
                    Cliente client = new Cliente(parseId, NombreClient.getText(), DirClient.getText(), TelParse, NitClient.getText());
                    cliente.updateCliente(index, client);
                    JOptionPane.showConfirmDialog(Parent, "El cliente se modifico correctamente", "Cliente modificado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    cerrar2();
                } else {
                    if (cliente.buscarCliente(parseId) == true) {
                        JOptionPane.showConfirmDialog(Parent, "El cliente ya existe, intente con otro Id", "Cliente Incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    } else {
                        Cliente client = new Cliente(parseId, NombreClient.getText(), DirClient.getText(), TelParse, NitClient.getText());
                        cliente.updateCliente(index, client);
                        JOptionPane.showConfirmDialog(Parent, "El cliente se modifico correctamente", "Cliente modificado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        cerrar2();
                    }

                }

            }
        });
        Parent.add(aceptar);
    }

    void cerrar2() {
        this.dispose();
    }
}
