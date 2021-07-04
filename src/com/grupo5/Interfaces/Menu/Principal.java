package com.grupo5.Interfaces.Menu;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.intCliente.CRUD_cliente;
import com.grupo5.Interfaces.Menu.intFacturas.CRUD_factura;
import com.grupo5.Interfaces.Menu.intProductos.CRUD_products;
import com.grupo5.Interfaces.Menu.intUsuario.CRUD_user;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.sun.istack.internal.NotNull;
//import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Principal extends JFrame {

    public JPanel user;
    public JPanel lateralSecundario;
    public JPanel Principal;
    public JPanel superior;
    public JLabel txtTitle;
    public JPanel CRUD;
    public CRUD_user u;
    public CRUD_cliente c;
    public CRUD_factura f;
    public CRUD_products p;
    public Dashboard dash;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);

    public static Gestor_usuario usuario;
    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;

    public Principal(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes) {
        usuario = usuarios;
        producto = productos;
        factura = facturas;
        cliente = clientes;
        this.setSize(1080, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        setUndecorated(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            }
        });

        //Menu lateral
        user = new JPanel();
        user.setSize(200, 180);
        user.setBounds(0, 0, 200, 180);
        user.setBackground(fondo);
        lateralSecundario = new JPanel();
        lateralSecundario.setSize(200, 720);
        lateralSecundario.setBounds(0, 0, 200, 720);
        lateralSecundario.setBackground(fondo);
        lateralSecundario.setLayout(new GroupLayout(lateralSecundario));
        this.add(lateralSecundario);
        user.setLayout(null);
        lateralSecundario.add(user);

        Principal = new JPanel();
        Principal.setSize(900, 720);
        Principal.setBounds(180, 0, 900, 720);
        Principal.setBackground(azul);
        Principal.setLayout(new GroupLayout(Principal));
        this.add(Principal);
        setCRUD();
        setUser();
        setSuperior();

        menu();
        repaint();
        revalidate();

    }

    void setUser() {

        JLabel profile = new JLabel();
        profile.setHorizontalAlignment(0);
        profile.setForeground(Color.white);

        profile.setSize(100, 100);
        profile.setBounds(40, 20, 110, 110);
        profile.setIcon(getIcon2("iconos\\profile.png", profile));

        user.add(profile);

        // users
        JLabel users = new JLabel("Darwin Arevalo");
        users.setHorizontalAlignment(0);
        users.setForeground(Color.white);
        users.setVerticalAlignment(0);
        users.setSize(180, 30);
        users.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        users.setForeground(texto);
        users.setBounds(0, 140, 180, 20);

        user.add(users);

    }

    ImageIcon getIcon(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth() - 30, label.getHeight() - 18, Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    ImageIcon getIcon2(String ruta, @NotNull JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    void menu() {
        //boton listar usuarios
        Fuentes fuente = new Fuentes();
        JPanel Dashboard = new JPanel(null);
        Dashboard.setBounds(0, 200, lateralSecundario.getWidth(), 45);
        Dashboard.setBackground(fondo);
        // botonVer.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        JLabel icondash = new JLabel();
        icondash.setHorizontalAlignment(0);

        icondash.setVerticalAlignment(0);
        icondash.setSize(30, 30);
        icondash.setBounds(150, 8, 30, 30);
        icondash.setIcon(getIcon2("iconos\\home.png", icondash));

        Dashboard.add(icondash);

        JLabel txtdash = new JLabel("Dashboard");
        txtdash.setBounds(20, 15, 80, 20);

        txtdash.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtdash.setForeground(texto);
        Dashboard.add(txtdash);
        Dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Dashboard.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                Dashboard.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {
                closeOthers();
                Dashboard.setBackground(new Color(46, 51, 73));
                dash = new Dashboard();
                dash.setVisible(true);
                dash.setForeground(textoSecundario);
                dash.setBounds(2, 0, 898, 620);
                CRUD.add(dash);
                txtTitle.setText("Dashboard");
                revalidate();
                repaint();
            }

        });

        lateralSecundario.add(Dashboard);

        JPanel botonVer = new JPanel(null);
        botonVer.setBounds(0, 245, lateralSecundario.getWidth(), 45);
        botonVer.setBackground(fondo);
        // botonVer.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        JLabel iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\user.png", iconVer));

        botonVer.add(iconVer);

        JLabel txtVer = new JLabel("Usuarios");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonVer.add(txtVer);
        botonVer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonVer.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                botonVer.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {
                closeOthers();
                botonVer.setBackground(new Color(46, 51, 73));
                u = new CRUD_user(usuario);
                u.setVisible(true);
                u.setForeground(textoSecundario);
                u.setBounds(2, 0, 898, 620);
                CRUD.add(u);
                txtTitle.setText("Usuarios");
                revalidate();
                repaint();
            }

        });

        lateralSecundario.add(botonVer);

        //boton listar clientes
        JPanel botonclient = new JPanel(null);
        botonclient.setBounds(0, 290, lateralSecundario.getWidth(), 45);
        botonclient.setBackground(fondo);
        // botonclient.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\clients.png", iconVer));

        botonclient.add(iconVer);

        txtVer = new JLabel("Clientes");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonclient.add(txtVer);
        botonclient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonclient.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                botonclient.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {
                botonclient.setBackground(new Color(46, 51, 73));
                botonclient.setBackground(new Color(46, 51, 73));
                closeOthers();
                c = new CRUD_cliente(cliente);
                c.setVisible(true);
                c.setForeground(textoSecundario);
                c.setBounds(2, 0, 898, 620);
                CRUD.add(c);
                txtTitle.setText("Clientes");
                revalidate();
                repaint();
            }
        });

        lateralSecundario.add(botonclient);

        //boton listar product
        JPanel botonproduct = new JPanel(null);
        botonproduct.setBounds(0, 335, lateralSecundario.getWidth(), 45);
        botonproduct.setBackground(fondo);
        //botonproduct.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\products.png", iconVer));

        botonproduct.add(iconVer);

        txtVer = new JLabel("Productos   ");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonproduct.add(txtVer);
        botonproduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonproduct.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                botonproduct.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {

                botonproduct.setBackground(new Color(46, 51, 73));
                closeOthers();

                p = new CRUD_products(producto);
                p.setVisible(true);
                p.setForeground(textoSecundario);
                p.setBounds(2, 0, 898, 620);
                CRUD.add(p);
                txtTitle.setText("Productos");
                revalidate();
                repaint();
            }
        });
        lateralSecundario.add(botonproduct);

        //boton listar invoice
        JPanel botoninvoice = new JPanel(null);
        botoninvoice.setBounds(0, 380, lateralSecundario.getWidth(), 45);
        botoninvoice.setBackground(fondo);
        //botoninvoice.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\invoice.png", iconVer));

        botoninvoice.add(iconVer);

        txtVer = new JLabel("Facturas");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botoninvoice.add(txtVer);
        botoninvoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botoninvoice.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                botoninvoice.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {
                botoninvoice.setBackground(new Color(46, 51, 73));
                closeOthers();

                f = new CRUD_factura(factura, cliente, producto);
                f.setVisible(true);
                f.setForeground(textoSecundario);
                f.setBounds(2, 0, 898, 620);
                CRUD.add(f);
                txtTitle.setText("Facturas");
                revalidate();
                repaint();
            }
        });
        lateralSecundario.add(botoninvoice);

        JPanel botonexit = new JPanel(null);
        botonexit.setBounds(0, 675, lateralSecundario.getWidth(), 45);
        botonexit.setBackground(fondo);
        //botonexit.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(150, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\logout.png", iconVer));

        botonexit.add(iconVer);
        botonexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonexit.setBackground(azul);
            }

            public void mouseExited(MouseEvent e) {
                botonexit.setBackground(fondo);
            }

            public void mouseClicked(MouseEvent e) {
                botonexit.setBackground(texto);
            }

        });
        txtVer = new JLabel("Salir");
        txtVer.setBounds(20, 15, 80, 20);

        txtVer.setFont(fuente.fuente(fuente.RobotoRegular, 0, 14));
        txtVer.setForeground(texto);
        botonexit.add(txtVer);

        lateralSecundario.add(botonexit);

    }

    void setSuperior() {
        superior = new JPanel(null);
        superior.setBounds(0, 0, 900, 100);
        superior.setBackground(Principal.getBackground());
        superior.setForeground(textoSecundario);
        Principal.add(superior);
        txtTitle = new JLabel("Dashboard");
        txtTitle.setBounds(60, 30, 200, 40);
        txtTitle.setForeground(textoSecundario);
        txtTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
        superior.add(txtTitle);

        JLabel exit = new JLabel("x");
        exit.setBounds(875, 0, 200, 40);
        exit.setForeground(textoSecundario);
        exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
            }

            public void mouseExited(MouseEvent e) {
                exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
            }

        });
        superior.add(exit);

    }

    void setCRUD() {
        CRUD = new JPanel(null);
        CRUD.setBackground(azul);
        CRUD.setBounds(1, 100, 898, 620);

        Principal.add(CRUD);
        dash = new Dashboard();

        dash.setVisible(true);
        dash.setForeground(textoSecundario);
        dash.setBounds(2, 0, 898, 620);
        CRUD.add(dash);
        repaint();
        revalidate();

    }

    void closeOthers() {
        try {
            CRUD.remove(dash);
            CRUD.remove(u);
            CRUD.remove(c);
            CRUD.remove(p);
            CRUD.remove(f);

            revalidate();
            repaint();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
