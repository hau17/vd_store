/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.GUI;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author congh
 */
class ImageRenderer extends DefaultTableCellRenderer {
    JLabel label;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        label = new JLabel();
        label.setIcon((ImageIcon) value);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
}
