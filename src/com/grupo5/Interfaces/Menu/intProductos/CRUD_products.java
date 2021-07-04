package com.grupo5.Interfaces.Menu.intProductos;

import com.grupo5.Fuentes.Fuentes;
import static com.grupo5.Interfaces.Menu.intProductos.CRUD_products.producto;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.*;
import com.grupo5.Interfaces.Menu.intUsuario.Renders.Render;
import com.grupo5.Productos.Gestor_Producto;
import com.grupo5.Productos.Ingrediente;
import com.grupo5.Productos.Producto;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CRUD_products extends JPanel implements MouseListener {

    public static Gestor_Producto producto;
    public Color fondo = new Color(24, 30, 54);
    public Color azul = new Color(42, 52, 67);
    public Color texto = new Color(0, 126, 249);
    public Color amarillo = new Color(66, 155,245);
    public JTable table;
    public JTable table2;
    JButton eliminar;
    JButton modificar;
    DefaultTableModel model;
    DefaultTableModel model2;

    public static Color textoSecundario = new Color(158, 161, 176);

    public CRUD_products(Gestor_Producto product) {
        producto = product;
        JPanel aux = new JPanel();
        Fuentes fuente = new Fuentes();
        setSize(898, 620);
        setBounds(0, 0, getWidth(), getHeight());
        setBackground(azul);
        setLayout(null);
        setForeground(textoSecundario);

        producto.printProductos();

        ArrayList<Producto> data = producto.getProductos();

        Object[] header = new Object[]{"Id", "Nombre", "Descripción",
            "Costo", "Precio", "", ""};

        Object matriz[][] = new Object[data.size()][7];
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

            matriz[i][0] = Integer.toString(data.get(i).getId());
            matriz[i][1] = data.get(i).getName();
            matriz[i][2] = data.get(i).getDescription();
            matriz[i][3] = Double.toString(data.get(i).getCost());
            matriz[i][4] = Double.toString(data.get(i).getPrice());
            matriz[i][5] = modificar;
            matriz[i][6] = eliminar;

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
        table.setBounds(80, 100, 400, 300);
        table.addMouseListener(this);
        this.setLayout(null);

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
                            System.out.println("Modificar");
                            String producto = (String) table.getValueAt(row, 0);
                            System.out.println(producto);
                        }
                        if (btn.getName().equals("e")) {
                            int idProd = Integer.parseInt((String) table.getValueAt(row, 0));
                            producto.eliminarProducto(idProd);
                            model.removeRow(row);
                            producto.printProductos();
                            System.out.println("Eliminar");
                            table.repaint();
                            table.revalidate();
                        }
                    }
                }
            }
        });

        //LABEL PRODUCTOS
        JLabel ProductosLabel = new JLabel("PRODUCTOS");
        ProductosLabel.setVisible(true);
        ProductosLabel.setHorizontalAlignment(0);
        ProductosLabel.setForeground(Color.white);
        ProductosLabel.setVerticalAlignment(0);
        ProductosLabel.setSize(180, 30);
        ProductosLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
        ProductosLabel.setForeground(texto);
        ProductosLabel.setBounds(20, 10, 180, 20);
        this.add(ProductosLabel);

        //TABLA 1
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
        pane.setBackground(azul);
        pane.setOpaque(true);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getViewport().setBackground(azul);
        pane.setBounds(50, 50, 800, 300);
        add(pane);

        //LABEL INFO
        JLabel InfoLabel = new JLabel("*Presione el Id del producto para ver sus ingredientes");
        InfoLabel.setVisible(true);
        InfoLabel.setHorizontalAlignment(0);
        InfoLabel.setForeground(Color.white);
        InfoLabel.setVerticalAlignment(0);
        InfoLabel.setSize(180, 30);
        InfoLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
        InfoLabel.setForeground(texto);
        InfoLabel.setBounds(210, 370, 380, 20);
        this.add(InfoLabel);
        
        //LABEL INGREDIENTES
        JLabel IngredientesLabel = new JLabel("INGREDIENTES  |");
        IngredientesLabel.setVisible(true);
        IngredientesLabel.setHorizontalAlignment(0);
        IngredientesLabel.setForeground(Color.white);
        IngredientesLabel.setVerticalAlignment(0);
        IngredientesLabel.setSize(180, 30);
        IngredientesLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
        IngredientesLabel.setForeground(texto);
        IngredientesLabel.setBounds(40, 370, 180, 20);
        this.add(IngredientesLabel);
    }

    ImageIcon getIcon2(String ruta, @NotNull JButton label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image imgs = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imgs);
        return scale;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Se le dió click a a la tabla");
        int col = table.getColumnModel().getColumnIndexAtX(me.getX());
        int row = me.getY() / table.getRowHeight();
        if (row < table.getRowCount() && row >= 0 && col < table.getColumnCount() && col >= 0) {
            try {
                Object valorObtenido = table.getValueAt(row, col);
                int valorParseado = Integer.parseInt((String) valorObtenido);
                System.out.println("valorParseado = " + valorParseado);

                //-----------------------------TABLA2--------------------------------
                Producto data = producto.getProductos(valorParseado);
                ArrayList<Ingrediente> ingArray = data.getIngredientes();

                Object[] header = new Object[]{"Nombre", "Cantidad", "Unidades", "", ""};
                Object matriz[][] = new Object[ingArray.size()][5];
                Fuentes fuente = new Fuentes();
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
                for (int i = 0; i < ingArray.size(); i++) {
                    matriz[i][0] = ingArray.get(i).getName();
                    matriz[i][1] = Integer.toString(ingArray.get(i).getQuantity());
                    matriz[i][2] = ingArray.get(i).getUnits();
                    matriz[i][3] = modificar;
                    matriz[i][4] = eliminar;
                }
                model2 = new DefaultTableModel(matriz, header) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                table2 = new JTable(model2);
                table2.setForeground(textoSecundario);
                table2.getTableHeader().setForeground(textoSecundario);
                table2.getTableHeader().setDefaultRenderer(new HeaderRenderer(table2));
                table2.setDefaultRenderer(Object.class, new Render());
                table2.setFocusable(false);
                table2.setBackground(azul);
                table2.setIntercellSpacing(new Dimension(0, 1));
                table2.setRowHeight(50);
                table2.setSelectionBackground(texto);
                table2.setShowVerticalLines(false);
                table2.setBorder(BorderFactory.createEmptyBorder());
                table2.setFont(fuente.fuente(fuente.OpensansBold, 0, 13));

                table2.getTableHeader().setFont(fuente.fuente(fuente.OpensansBold, 0, 17));
                table2.getTableHeader().setOpaque(true);

                table2.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
                table2.getTableHeader().setBackground(azul);
                table2.getTableHeader().setResizingAllowed(false);
                table2.setShowHorizontalLines(true);
                table2.setGridColor(texto);

                UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));

                //table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
                table2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                table2.setBounds(80, 100, 400, 300);
                table2.addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {
                        int col = table2.getColumnModel().getColumnIndexAtX(e.getX());
                        int row = e.getY() / table2.getRowHeight();
                        if (row < table2.getRowCount() && row >= 0 && col < table2.getColumnCount() && col > 0) {
                            Object valor = table2.getValueAt(row, col);
                            if (valor instanceof JButton) {
                                ((JButton) valor).doClick();
                                JButton btn = (JButton) valor;
                                if (btn.getName().equals("m")) {
                                    System.out.println("Modificar");
                                    String Ingrediente = (String) table2.getValueAt(row, 0);
                                    System.out.println(Ingrediente);
                                }
                                if (btn.getName().equals("e")) {
                                    String NomIng = (String) table2.getValueAt(row, 0);
                                    producto.eliminarIngrediente(valorParseado, NomIng);
                                    model2.removeRow(row);
                                    producto.printProductos();
                                    System.out.println("Eliminar");
                                    table2.repaint();
                                    table2.revalidate();
                                }
                            }
                        }
                    }
                });

                //TABLA 2
                JScrollPane pane2 = new JScrollPane();
                pane2.setViewportView(table2);
                pane2.setBackground(azul);
                pane2.setOpaque(true);
                pane2.setBorder(BorderFactory.createEmptyBorder());
                pane2.getViewport().setBackground(azul);
                pane2.setBounds(50, 400, 800, 200);
                add(pane2);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
