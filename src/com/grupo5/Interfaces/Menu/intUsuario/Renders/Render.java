package com.grupo5.Interfaces.Menu.intUsuario.Renders;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Render extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JButton){
            JButton btn = (JButton) value;
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return btn;
        }
        if (value instanceof JLabel){
            JLabel btn = (JLabel) value;
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return btn;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
