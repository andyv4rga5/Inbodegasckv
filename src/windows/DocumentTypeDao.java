/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor velandia
 */
public class DocumentTypeDao {

    private int id;
    
    private String detDocumento;

    public ArrayList<DocumentTypeDao> getDocumentType() {
        ArrayList<DocumentTypeDao> list = new ArrayList<DocumentTypeDao>();
        Connection connection = ConnectionBD.getConnection();
        Statement stmt;
        try {
            stmt = connection.createStatement();

            String sql = "select * from tipo_documento";
            ResultSet rs = stmt.executeQuery(sql);
            DocumentTypeDao dao;
            while (rs.next()) {
                dao = new DocumentTypeDao();
                dao.setId(rs.getInt("id_TipoDocumento"));
                dao.setDetDocumento(rs.getString("DetDocumento"));
                list.add(dao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DocumentTypeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetDocumento() {
        return detDocumento;
    }

    public void setDetDocumento(String detDocumento) {
        this.detDocumento = detDocumento;
    }

}
