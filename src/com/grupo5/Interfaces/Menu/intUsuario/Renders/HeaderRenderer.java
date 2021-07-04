package com.grupo5.Interfaces.Menu.intUsuario.Renders;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class HeaderRenderer implements TableCellRenderer {

    DefaultTableCellRenderer renderer;

    public HeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer)
                table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col) {
        return renderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
    }
}