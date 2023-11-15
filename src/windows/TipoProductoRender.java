/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

/**
 *
 * @author andres
 */
public class TipoProductoRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Convierte el valor numérico a su representación correspondiente
        String tipoProducto = "";
        if (value != null) {
            int codigo = Integer.parseInt(value.toString());
            switch (codigo) {
                case 1:
                    tipoProducto = "Food";
                    break;
                case 2:
                    tipoProducto = "Accessories";
                    break;
                case 3:
                    tipoProducto = "Veterinary";
                    break;
                default:
                    break;
            }
        }

        return super.getTableCellRendererComponent(table, tipoProducto, isSelected, hasFocus, row, column);
    }
}