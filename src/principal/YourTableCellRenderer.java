/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author ciroa
 */
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class YourTableCellRenderer extends DefaultTableCellRenderer {
    private final String[][] asientos;
    public YourTableCellRenderer(String[][] asientos) {
        super();
        this.setOpaque(true);
        if(asientos!=null)
        System.err.println("Filas: "+asientos.length);
        this.asientos=asientos;        
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = 
      super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);

    // Only for specific cell
    if(this.asientos!=null && this.asientos.length>0){
        System.out.println(this.asientos[row][column]);
        if(this.asientos[row][column].equals("X"))
            c.setBackground(Color.RED);
        else
            c.setBackground(Color.GREEN);
    }else
        c.setBackground(Color.WHITE);
    return c;
  }
}
