/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package windows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author victor velandia
 */
public class UpdateUser extends javax.swing.JFrame {

    ArrayList<DocumentTypeDao> listDocumentType;
    ArrayList<RoleDao> listRole;
    ArrayList<JobDao> listJob;
    String idLogin;

    /**
     * Creates new form createUser
     */
    public UpdateUser(String idLogin) {
        initComponents();
        setLocationRelativeTo(null);
        this.idLogin = idLogin;

        this.initializeDocument();
        this.initializeRol();
        this.initializeJob();

        this.queryUser(idLogin);

    }

    private void queryUser(String idLogin) {

        try {
            Connection con = ConnectionBD.getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM usuarios WHERE id_Login = " + idLogin;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                String userName = rs.getString("Nombre");
                this.jtfName.setText(userName);

                String lastName = rs.getString("Apellido");
                this.jtfLastName.setText(lastName);

                //obtiene el id del documento del usuario
                int docType = rs.getInt("id_TipoDocumento");

                //busca el documento relacionado al id de documento del usuario
                DocumentTypeDao temp;
                for (int i = 0; i < this.listDocumentType.size(); i++) {
                    temp = this.listDocumentType.get(i);
                    if (temp.getId() == docType) {
                        this.ComBoxDocType.setSelectedItem(temp.getDetDocumento());
                    }
                }

                String docNumber = rs.getString("Documento");
                this.jtfDocNumber.setText(docNumber);

                //obtiene el id del rol del usuario
                int rolId = rs.getInt("id_Rol");

                //busca el documento relacionado al id del Rol del usuario
                RoleDao tempRol;
                for (int i = 0; i < this.listRole.size(); i++) {
                    tempRol = this.listRole.get(i);
                    if (tempRol.getId() == rolId) {
                        this.comBoxRole.setSelectedItem(tempRol.getDetRol());
                    }
                }

                //obtiene el id del cargo del usuario
                int jobId = rs.getInt("id_Cargo");

                //busca el documento relacionado al id del Rol del usuario
                JobDao tempJob;
                for (int i = 0; i < this.listJob.size(); i++) {
                    tempJob = this.listJob.get(i);
                    if (tempJob.getId() == jobId) {
                        this.ComBoxJob.setSelectedItem(tempJob.getDetCargo());
                    }
                }

                /* Consulta la informacion de la tabla Login del usuario*/
                String queryLogin = "SELECT * FROM login WHERE id_Login = " + idLogin;
                ResultSet rsLogin = stmt.executeQuery(queryLogin);
                if (rsLogin.next()) {
                    //Setea el valor del usuario en el campo User del formulario
                    String user = rsLogin.getString("User");
                    this.jtfUser.setText(user);
                } else {
                    JOptionPane.showMessageDialog(this, "user not found.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "user not found.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initializeDocument() {
        DocumentTypeDao dao = new DocumentTypeDao();
        this.listDocumentType = dao.getDocumentType();

        String[] str = new String[this.listDocumentType.size() + 1];
        DocumentTypeDao temp;
        str[0] = "SELECT";
        for (int i = 0; i < this.listDocumentType.size(); i++) {

            temp = this.listDocumentType.get(i);
            str[i + 1] = temp.getDetDocumento();

        }
        this.ComBoxDocType.setModel(new javax.swing.DefaultComboBoxModel<>(str));
    }

    public void initializeRol() {
        RoleDao dao = new RoleDao();
        this.listRole = dao.getRole();

        String[] str = new String[this.listRole.size() + 1];
        RoleDao temp;
        str[0] = "SELECT";
        for (int i = 0; i < this.listRole.size(); i++) {

            temp = this.listRole.get(i);
            str[i + 1] = temp.getDetRol();

        }
        this.comBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(str));
    }

    public void initializeJob() {
        JobDao dao = new JobDao();
        this.listJob = dao.getJob();

        String[] str = new String[this.listJob.size() + 1];
        JobDao temp;
        str[0] = "SELECT";
        for (int i = 0; i < this.listJob.size(); i++) {

            temp = this.listJob.get(i);
            str[i + 1] = temp.getDetCargo();

        }
        this.ComBoxJob.setModel(new javax.swing.DefaultComboBoxModel<>(str));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCheckIn = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblDocType = new javax.swing.JLabel();
        lblDocNum = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblJob = new javax.swing.JLabel();
        btnUpdateUser = new javax.swing.JButton();
        ComBoxDocType = new javax.swing.JComboBox<>();
        comBoxRole = new javax.swing.JComboBox<>();
        ComBoxJob = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        jtfName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfDocNumber = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCheckIn.setText("UPDATE USER");

        lblName.setText("NAME");

        lblLastName.setText("LAST NAME");

        lblDocType.setText("DOCUMENT TYPE");

        lblDocNum.setText("DOCUMENT NUMBER");

        lblRole.setText(" ROLE");

        lblJob.setText("JOB");

        btnUpdateUser.setText("UPDATE USER");
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        ComBoxDocType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", " " }));
        ComBoxDocType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBoxDocTypeActionPerformed(evt);
            }
        });

        comBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", " ", " " }));

        ComBoxJob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "CHIEF OF WHAREHOUSE", " " }));

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        jtfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNameKeyPressed(evt);
            }
        });

        jtfLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLastNameActionPerformed(evt);
            }
        });
        jtfLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfLastNameKeyPressed(evt);
            }
        });

        lblUser.setText("USER");

        jtfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUserActionPerformed(evt);
            }
        });

        lblPassword.setText("PASSWORD");

        jtfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btnUpdateUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(lblCheckIn))
                            .addComponent(btnCancel)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfUser, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDocNum, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblJob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComBoxJob, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comBoxRole, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComBoxDocType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDocType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfLastName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfDocNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCheckIn)
                .addGap(26, 26, 26)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblDocType)
                .addGap(18, 18, 18)
                .addComponent(ComBoxDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDocNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDocNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRole)
                .addGap(9, 9, 9)
                .addComponent(comBoxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblJob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComBoxJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateUser)
                    .addComponent(btnCancel))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComBoxDocTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBoxDocTypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ComBoxDocTypeActionPerformed

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jtfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUserActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        String userName = this.jtfName.getText();
        String lastname = this.jtfLastName.getText();
        String document = this.jtfDocNumber.getText();
        String password = this.jtfPassword.getText();

        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "the name field cannot be empty.");
            return;
        }

        int idTipoDocumento = this.ComBoxDocType.getSelectedIndex();
        if (idTipoDocumento == 0) {
            JOptionPane.showMessageDialog(this, "the document type field cannot be empty.");
            return;
        }

        int idRol = this.comBoxRole.getSelectedIndex();
        if (idRol == 0) {
            JOptionPane.showMessageDialog(this, "the role field cannot be empty.");
            return;
        }

        int idCargo = this.ComBoxJob.getSelectedIndex();
        if (idCargo == 0) {
            JOptionPane.showMessageDialog(this, "the job field cannot be empty.");
            return;
        }

        DocumentTypeDao documentType = this.listDocumentType.get(idTipoDocumento - 1);
        int documentId = documentType.getId();

        RoleDao role = this.listRole.get(idRol - 1);
        int roleId = role.getId();

        JobDao job = this.listJob.get(idCargo - 1);
        int jobId = job.getId();
        String user = this.createUserName(userName, lastname);
        jtfUser.setText(user);
        UserDao dao = new UserDao();

        boolean response = dao.updateUser(this.idLogin, password, user, userName, lastname, roleId, document, roleId, jobId);
        if (response) {
            JOptionPane.showMessageDialog(this, "The user updated successfully");
                
            ViewAdminUser jframe = new ViewAdminUser();
            jframe.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error updating the user");

        }


    }//GEN-LAST:event_btnUpdateUserActionPerformed

    public String createUserName(String userName, String lastName) {
        String user = "";
        String[] arregloNombre = userName.split(" ");
        String[] arregloApellido = lastName.split(" ");
        String primerNombre = arregloNombre[0];
        String apellidoPaterno = arregloApellido[0];
        if (apellidoPaterno.length() > 6) {
            apellidoPaterno = apellidoPaterno.substring(0, 6);
        }
        String apellidoMaterno = "";
        if (arregloApellido.length >= 2) {
            apellidoMaterno = arregloApellido[1];
        }

        if (apellidoMaterno.length() > 1) {
            apellidoMaterno = apellidoMaterno.substring(0, 1);
        }

        String correo = primerNombre.substring(0, 1);
        correo = correo + apellidoPaterno;
        correo = correo + apellidoMaterno;
        correo = correo + "@sanmateo.edu.co";
        correo = correo.toLowerCase();

        System.out.println(correo);
        return correo;
    }
    private void jtfLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfLastNameActionPerformed

    private void jtfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPasswordActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        GestionarUsuario manageUser = new GestionarUsuario();
        manageUser.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jtfNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNameKeyPressed
        String userName = this.jtfName.getText();
        String lastname = this.jtfLastName.getText();
        if (userName.length() > 0 && lastname.length() > 0) {
            String user = this.createUserName(userName, lastname);
            jtfUser.setText(user);
        } else {
            jtfUser.setText("");
        }
    }//GEN-LAST:event_jtfNameKeyPressed

    private void jtfLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfLastNameKeyPressed
        String userName = this.jtfName.getText();
        String lastname = this.jtfLastName.getText();
        if (userName.length() > 0 && lastname.length() > 0) {
            String user = this.createUserName(userName, lastname);
            jtfUser.setText(user);
        } else {
            jtfUser.setText("");
        }
    }//GEN-LAST:event_jtfLastNameKeyPressed

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
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComBoxDocType;
    private javax.swing.JComboBox<String> ComBoxJob;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JComboBox<String> comBoxRole;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfDocNumber;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUser;
    private javax.swing.JLabel lblCheckIn;
    private javax.swing.JLabel lblDocNum;
    private javax.swing.JLabel lblDocType;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
