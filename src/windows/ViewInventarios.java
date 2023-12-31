/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Fami VargasPreciado
 */
public class ViewInventarios extends javax.swing.JFrame {

    /**
     * Creates new form ViewInventarios
     */
    public ViewInventarios() {
        initComponents();
        llenarTablaProductos();
        setLocationRelativeTo(null);
    }
    
    private void llenarTablaProductos() {
        try {
            Connection con = ConnectionBD.getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT Nombre, Marca, Descripcion, Precio, Cantidad,TipoProducto FROM productos";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Marca");
            model.addColumn("Descripcion");
            model.addColumn("Precio");
            model.addColumn("Cantidad");
            model.addColumn("Tipo Producto");

            if (tblProductosAdmin.getRowCount() > 0) {
                model.setRowCount(0);
            }

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String marca = rs.getString("Marca");
                String descripcion = rs.getString("Descripcion");
                String precio = rs.getString("Precio");
                String cantidad = rs.getString("Cantidad");
                String tProducto = rs.getString("TipoProducto");
                model.addRow(new Object[]{nombre, marca, descripcion, precio, cantidad,tProducto});
            }

            tblProductosAdmin.setModel(model);
            tblProductosAdmin.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            ajustarAnchoColumnas();

            // Asignar el renderizador personalizado a la columna "Tipo Producto"
            tblProductosAdmin.getColumnModel().getColumn(5).setCellRenderer(new TipoProductoRender());

            rs.close();
            stmt.close();
            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void ajustarAnchoColumnas() {
        for (int column = 0; column < tblProductosAdmin.getColumnCount(); column++) {
            TableColumn tableColumn = tblProductosAdmin.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < tblProductosAdmin.getRowCount(); row++) {
                TableCellRenderer cellRenderer = tblProductosAdmin.getCellRenderer(row, column);
                Component c = tblProductosAdmin.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + tblProductosAdmin.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                // Ajusta el ancho máximo para evitar que sea demasiado grande
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMarcaListUsers = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxDetProductos = new javax.swing.JComboBox<>();
        lblInventarios = new javax.swing.JLabel();
        lblTipoProductoInvent = new javax.swing.JLabel();
        lblDetProductos = new javax.swing.JLabel();
        txtDescripcionInvent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosAdmin = new javax.swing.JTable();
        btnRegresarAdminInventarios = new javax.swing.JButton();
        lblMarcaListUsers1 = new javax.swing.JLabel();
        btnEliminarRegAdmin = new javax.swing.JButton();
        btnActualizarRegAdmin = new javax.swing.JButton();

        lblMarcaListUsers.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblMarcaListUsers.setText("InBodegas CKV - Huellitas CKV");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxDetProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select --", "Food", "Accessories", "Veterinary" }));
        cbxDetProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDetProductosActionPerformed(evt);
            }
        });

        lblInventarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInventarios.setText("Stocks");

        lblTipoProductoInvent.setText("Tipe of product");

        lblDetProductos.setText("Description");

        txtDescripcionInvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionInventActionPerformed(evt);
            }
        });

        tblProductosAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductosAdmin.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblProductosAdmin);

        btnRegresarAdminInventarios.setText("Return ");
        btnRegresarAdminInventarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAdminInventariosActionPerformed(evt);
            }
        });

        lblMarcaListUsers1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblMarcaListUsers1.setText("InBodegas CKV - Huellitas CKV");

        btnEliminarRegAdmin.setText("Delete");
        btnEliminarRegAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRegAdminActionPerformed(evt);
            }
        });

        btnActualizarRegAdmin.setText("Update");
        btnActualizarRegAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoProductoInvent)
                    .addComponent(lblDetProductos))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxDetProductos, 0, 138, Short.MAX_VALUE)
                    .addComponent(txtDescripcionInvent))
                .addGap(104, 104, 104))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(lblInventarios))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMarcaListUsers1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminarRegAdmin)
                        .addGap(43, 43, 43)
                        .addComponent(btnActualizarRegAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresarAdminInventarios)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblInventarios)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDetProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoProductoInvent))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetProductos)
                    .addComponent(txtDescripcionInvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarAdminInventarios)
                    .addComponent(btnEliminarRegAdmin)
                    .addComponent(btnActualizarRegAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMarcaListUsers1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarAdminInventariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAdminInventariosActionPerformed
        InicioAdmin inicioAdmin = new InicioAdmin();
        inicioAdmin.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_btnRegresarAdminInventariosActionPerformed

    private void txtDescripcionInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionInventActionPerformed

        String filtroDescripcion = txtDescripcionInvent.getText().trim();
        filtrarTablaPorDescripcion(filtroDescripcion);
    }//GEN-LAST:event_txtDescripcionInventActionPerformed

    private void cbxDetProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDetProductosActionPerformed

        String filtroSeleccion = cbxDetProductos.getSelectedItem().toString();
        int codigoTipoProducto = obtenerCodigoTipoProducto(filtroSeleccion);
        filtrarTablaPorTipoProducto(String.valueOf(codigoTipoProducto));
    }//GEN-LAST:event_cbxDetProductosActionPerformed

    private void btnEliminarRegAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRegAdminActionPerformed

        int selectedRow = tblProductosAdmin.getSelectedRow();
        CrudAdminDao crud = new CrudAdminDao();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product from the list.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si no hay un producto seleccionado
        }

        boolean eliminacionExitosa =  crud.EliminarProduct(tblProductosAdmin.getValueAt(selectedRow, 2).toString());
        String mensaje;
        
          
        if (eliminacionExitosa) {
            mensaje = "successful product elimination.";
        } else {
            // Manejar el caso en que la actualización no fue exitosa
            mensaje = "It was not possible to remove the product.";
        }

        JOptionPane.showMessageDialog(this, mensaje);
        llenarTablaProductos();

    }//GEN-LAST:event_btnEliminarRegAdminActionPerformed

    private void btnActualizarRegAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegAdminActionPerformed
        
        int selectedRow = tblProductosAdmin.getSelectedRow();
        CrudAdminDao crud = new CrudAdminDao();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product from the list.", "Selection Error", JOptionPane.ERROR_MESSAGE);
            return; // Detener la ejecución si no hay un producto seleccionado
        }
        
        AdminIngresoProduct AdminProdView = new AdminIngresoProduct();
        AdminProdView.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnActualizarRegAdminActionPerformed

    private void filtrarTablaPorDescripcion(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tblProductosAdmin.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblProductosAdmin.setRowSorter(sorter);

        if (filtro.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 2)); // 2 es el índice de la columna de descripción
        }
    }
    
    private void filtrarTablaPorTipoProducto(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tblProductosAdmin.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblProductosAdmin.setRowSorter(sorter);

        if (filtro.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 5)); // 2 es el índice de la columna de descripción
        }
    }
    
    private void filtrarTablaPorSeleccion(String filtro) {
        DefaultTableModel model = (DefaultTableModel) tblProductosAdmin.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblProductosAdmin.setRowSorter(sorter);

        if (filtro.equals("Todos")) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 1)); // 1 es el índice de la columna de marca (ajusta el índice según la columna que desees filtrar)
        }
    }
    
    private int obtenerCodigoTipoProducto(String tipoProducto) {
        switch (tipoProducto) {
            case "Food":
                return 1;
            case "Accessories":
                return 2;
            case "Veterinary":
                return 3;
            default:
                return -1; // o algún valor predeterminado si es necesario
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInventarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarRegAdmin;
    private javax.swing.JButton btnEliminarRegAdmin;
    private javax.swing.JButton btnRegresarAdminInventarios;
    private javax.swing.JComboBox<String> cbxDetProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDetProductos;
    private javax.swing.JLabel lblInventarios;
    private javax.swing.JLabel lblMarcaListUsers;
    private javax.swing.JLabel lblMarcaListUsers1;
    private javax.swing.JLabel lblTipoProductoInvent;
    private javax.swing.JTable tblProductosAdmin;
    private javax.swing.JTextField txtDescripcionInvent;
    // End of variables declaration//GEN-END:variables
}
