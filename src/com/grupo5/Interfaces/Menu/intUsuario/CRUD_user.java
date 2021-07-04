package com.grupo5.Interfaces.Menu.intUsuario;

import com.grupo5.Fuentes.Fuentes;
import com.grupo5.Interfaces.Menu.intUsuario.Dialogs.AddUser;
import com.grupo5.Interfaces.Menu.intUsuario.Dialogs.updateUser;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.HeaderRenderer;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.Render;
import com.grupo5.Usuarios.Gestor_usuario;
import com.grupo5.Usuarios.Usuario;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class CRUD_user extends JPanel {
    public static Gestor_usuario usuario;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public JTable table;
    JButton eliminar;
    public JButton nuevo;
    JButton modificar;
    DefaultTableModel model;

    public Color textoSecundario = new Color(158, 161, 176);

    public CRUD_user(Gestor_usuario user) {
        usuario = user;
        JPanel aux = new JPanel();
        Fuentes fuente = new Fuentes();
        setSize(898, 300);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        usuario.print_usu();


        ArrayList<Usuario> data = usuario.getArray();

        Object[] header = new Object[]{"   Usuario", "   Password", "", ""};


        Object matriz[][] = new Object[data.size()][4];
        modificar = new JButton("Modificar");
        modificar.setName("m");
        modificar.setForeground(textoSecundario);
        modificar.setBorder(null);
        modificar.setBackground(azul);
        modificar.setBounds(0, 0, 30, 30);
        modificar.setIcon(getIcon2("iconos\\update.png", modificar));
        modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modificar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

        eliminar = new JButton("Eliminar");
        eliminar.setName("e");
        eliminar.setForeground(textoSecundario);
        eliminar.setBorder(null);
        eliminar.setBackground(azul);
        eliminar.setBounds(0, 0, 30, 30);
        eliminar.setForeground(textoSecundario);
        eliminar.setIcon(getIcon2("iconos\\delete2.png", modificar));
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));
        for (int i = 0; i < data.size(); i++) {

            matriz[i][0] = data.get(i).getUsername();
            matriz[i][1] = data.get(i).getPassword();
            matriz[i][2] = modificar;
            matriz[i][3] = eliminar;

        }

        model = new DefaultTableModel(matriz, header) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setForeground(textoSecundario);
        table.getTableHeader().setForeground(textoSecundario);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));
        table.setDefaultRenderer(Object.class, new Render());
        table.setFocusable(false);
        table.setBackground(azul);
        table.setIntercellSpacing(new Dimension(0, 1));
        table.setRowHeight(50);
        table.setSelectionBackground(texto);
        table.setShowVerticalLines(false);
        table.setBorder(BorderFactory.createEmptyBorder());
        table.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

        table.getTableHeader().setFont(fuente.fuente(fuente.OpensansBold, 0, 17));
        table.getTableHeader().setOpaque(true);

        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
        table.getTableHeader().setBackground(azul);
        table.getTableHeader().setResizingAllowed(false);
        table.setShowHorizontalLines(true);
        table.setGridColor(texto);


        UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setBounds(80, 100, 400, 400);
        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int col = table.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / table.getRowHeight();
                if (row < table.getRowCount() && row >= 0 && col < table.getColumnCount() && col > 0) {
                    Object valor = table.getValueAt(row, col);
                    if (valor instanceof JButton) {
                        ((JButton) valor).doClick();
                        JButton btn = (JButton) valor;
                        if (btn.getName().equals("m")) {
                            System.out.println(row);
                            //System.out.println("Modificar");
                            String usuarios = (String) table.getValueAt(row, 0);
                            System.out.println(usuarios);
                            openDialog(usuarios);
                            Refresh();
                        }
                        if (btn.getName().equals("e")) {
                            String usuarios = (String) table.getValueAt(row, 0);
                            System.out.println(usuarios);
                            int opcion = JOptionPane.showConfirmDialog(table, "¿Esta seguro de elimnar el usuario: "+ usuarios+"?","Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE );
                            if (opcion == JOptionPane.YES_OPTION){
                                usuario.eliminarUsuario((String) table.getValueAt(row, 0));
                                model.removeRow(row);
                                usuario.print_usu();
                                System.out.println("Eliminar");
                                Refresh();
                            }
                            if (opcion == JOptionPane.NO_OPTION){

                            }


                        }
                    }
                }
            }
        });
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        pane.setBackground(azul);

        pane.setOpaque(true);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getViewport().setBackground(azul);
        pane.setBounds(150, 100, 600, 400);


        add(pane);

        nuevo = new JButton("Nuevo usuario");
        nuevo.setForeground(textoSecundario);
        nuevo.setBackground(azul);
        nuevo.setBounds(600, 520, 140, 45);
        nuevo.setFont(fuente.fuente(fuente.RobotoBold,0,16));
        nuevo.setBorder(BorderFactory.createLineBorder(textoSecundario));
        nuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("si");
                AddUser a = new AddUser(usuario, true);
                a.setVisible(true);
                //a.setBounds((int)table.getBounds().getX()-20, table.getY(), 600,400  );
                //System.out.println(a.getSize().getWidth());
                Refresh();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                nuevo.setBackground(fondo);
                nuevo.setForeground(texto);
                nuevo.setBorder(BorderFactory.createLineBorder(texto));
                nuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                nuevo.setBackground(azul);
                nuevo.setForeground(textoSecundario);
                nuevo.setBorder(BorderFactory.createLineBorder(textoSecundario));
                nuevo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        add(nuevo);


    }

    ImageIcon getIcon2(String ruta, @NotNull JButton label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    void openDialog(String username) {
        updateUser c = new updateUser(usuario,true, username);
        c.setVisible(true);
    }
    void Refresh(){
        Fuentes fuente = new Fuentes();
        ArrayList<Usuario> data = usuario.getArray();

        Object[] header = new Object[]{"   Usuario", "   Password", "", ""};


        Object matriz[][] = new Object[data.size()][4];
        modificar = new JButton("Modificar");
        modificar.setName("m");
        modificar.setForeground(textoSecundario);
        modificar.setBorder(null);
        modificar.setBackground(azul);
        modificar.setBounds(0, 0, 30, 30);
        modificar.setIcon(getIcon2("iconos\\update.png", modificar));
        modificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        modificar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

        eliminar = new JButton("Eliminar");
        eliminar.setName("e");
        eliminar.setForeground(textoSecundario);
        eliminar.setBorder(null);
        eliminar.setBackground(azul);
        eliminar.setBounds(0, 0, 30, 30);
        eliminar.setForeground(textoSecundario);
        eliminar.setIcon(getIcon2("iconos\\delete2.png", modificar));
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminar.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));
        for (int i = 0; i < data.size(); i++) {

            matriz[i][0] = data.get(i).getUsername();
            matriz[i][1] = data.get(i).getPassword();
            matriz[i][2] = modificar;
            matriz[i][3] = eliminar;

        }

        model = new DefaultTableModel(matriz, header) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);


    }


}
