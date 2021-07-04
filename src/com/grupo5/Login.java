package com.grupo5;

import com.grupo5.Clientes.Gestor_cliente;
import com.grupo5.Facturas.Gestor_Factura;
import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.Principal;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Usuarios.Gestor_usuario;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Login extends JFrame {

    public JPanel user;
    public JPanel lateralSecundario;
//    public JPanel Principal;
    public JPanel superior;
    public JPanel CRUD;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color textoSecundario = new Color(158, 161, 176);
    JLabel titulo = new JLabel("CARGAR ARCHIVOS");
    JLabel info = new JLabel("Ingresa el nombre de la carpeta");
    JTextField textUser = new JTextField();
    JTextField textPass = new JTextField();
    JButton boton = new JButton("Cargar");
    JButton aceptar = new JButton("Aceptar");

    public static Gestor_usuario usuario;
    public static Gestor_Producto producto;
    public static Gestor_Factura factura;
    public static Gestor_cliente cliente;

    public Login(Gestor_usuario usuarios, Gestor_Producto productos, Gestor_Factura facturas, Gestor_cliente clientes) {
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
        user.setSize(500, 180);
        user.setBounds(0, 0, 200, 180);
        user.setBackground(fondo);
        lateralSecundario = new JPanel();
        lateralSecundario.setSize(1200, 720);
        lateralSecundario.setBounds(0, 0, 1200, 720);
        lateralSecundario.setBackground(fondo);
        lateralSecundario.setLayout(new GroupLayout(lateralSecundario));
        this.add(lateralSecundario);
        user.setLayout(null);
        lateralSecundario.add(user);

//        Principal = new JPanel();
//        Principal.setSize(900, 720);
//        Principal.setBounds(180, 0, 900, 720);
//        Principal.setBackground(azul);
//        Principal.setLayout(new GroupLayout(Principal));
//        this.add(Principal);
        setUser();
        Componentes();

        menu();
        repaint();
        revalidate();

    }

    void setUser() {

        JLabel profile = new JLabel();
        profile.setHorizontalAlignment(0);
        profile.setForeground(Color.white);

        profile.setSize(1050, 100);
        profile.setBounds(100, 20, 110, 110);
        profile.setIcon(getIcon2("iconos\\profile.png", profile));

        user.add(profile);

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
        JPanel botonVer = new JPanel(null);
        botonVer.setBounds(0, 200, lateralSecundario.getWidth(), 45);
        botonVer.setBackground(fondo);
        // botonVer.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        JLabel iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(250, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\user.png", iconVer));

        botonVer.add(iconVer);

        JLabel txtVer = new JLabel("Nombre del Usuario");
        txtVer.setBounds(300, 15, 2000, 20);

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

////            public void mouseClicked(MouseEvent e) {
////                botonVer.setBackground(new Color(46, 51, 73));
////                CRUD_user u = new CRUD_user(usuario);
////                u.setVisible(true);
////                u.setForeground(textoSecundario);
////                u.setBounds(2, 0, 898, 620);
////                CRUD.add(u);
////                u.revalidate();
////                u.repaint();
////            }
        });

        lateralSecundario.add(botonVer);

        //boton listar product
        JPanel botonproduct = new JPanel(null);
        botonproduct.setBounds(0, 290, lateralSecundario.getWidth(), 45);
        botonproduct.setBackground(fondo);
        //botonproduct.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(250, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\pass.png", iconVer));

        botonproduct.add(iconVer);

        txtVer = new JLabel("Contraseña");
        txtVer.setBounds(300, 15, 80, 20);

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
        });
        lateralSecundario.add(botonproduct);

        //boton listar invoice
        JPanel botoninvoice = new JPanel(null);
        botoninvoice.setBounds(0, 400, lateralSecundario.getWidth(), 45);
        botoninvoice.setBackground(fondo);
        //botoninvoice.setBorder(BorderFactory.createLineBorder(new Color(90, 90, 90)));

        iconVer = new JLabel();
        iconVer.setHorizontalAlignment(0);

        iconVer.setVerticalAlignment(0);
        iconVer.setSize(30, 30);
        iconVer.setBounds(450, 8, 30, 30);
        iconVer.setIcon(getIcon2("iconos\\confirmacion.png", iconVer));

        botoninvoice.add(iconVer);

        txtVer = new JLabel("Aceptar");
        txtVer.setBounds(500, 15, 80, 20);

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
                if (usuario.verificar(textUser.getText(), textPass.getText())) {
                    Principal p = new Principal(usuario, producto, factura, cliente);
                    p.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ERROR: Datos incorrectos");
                }

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

    public void Componentes() {
        //TITULO
        titulo.setBounds(250, 20, 300, 50);
        titulo.setFont(new Font("Monserrat", Font.BOLD, 18));
        titulo.setVisible(true);
        this.add(titulo);

        //TEXTFIELD
        textUser.setBounds(400, 200, 450, 30);
        textUser.setVisible(true);
        this.add(textUser);

        //TEXTFIELD
        textPass.setBounds(450, 300, 450, 30);
        textPass.setVisible(true);
        this.add(textPass);

    }

    {
//    void setSuperior() {
//        superior = new JPanel(null);
//        superior.setBounds(0, 0, 900, 100);
//        superior.setBackground(Principal.getBackground());
//        superior.setForeground(textoSecundario);
//        Principal.add(superior);
//        JLabel txtTitle = new JLabel("Bienvenido");
//        txtTitle.setBounds(60, 30, 200, 40);
//        txtTitle.setForeground(textoSecundario);
//        txtTitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 30));
//        superior.add(txtTitle);
//
//        JLabel exit = new JLabel("x");
//        exit.setBounds(875, 0, 200, 40);
//        exit.setForeground(textoSecundario);
//        exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
//        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        exit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.exit(0);
//            }
//
//            public void mouseEntered(MouseEvent e) {
//                exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
//            }
//
//            public void mouseExited(MouseEvent e) {
//                exit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
//            }
//
//        });
//        superior.add(exit);
//
//    }

//    void setCRUD() {
//        CRUD = new JPanel(null);
//        CRUD.setBackground(azul);
//        CRUD.setBounds(1, 100, 898, 620);
//
//        Principal.add(CRUD);
//
//    }
    }
}
