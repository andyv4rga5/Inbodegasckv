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
public class RoleDao {

    private int id;
    
    private String detRol;

    public ArrayList<RoleDao> getRole() {
        ArrayList<RoleDao> list = new ArrayList<RoleDao>();
        Connection connection = ConnectionBD.getConnection();
        Statement stmt;
        try {
            stmt = connection.createStatement();

            String sql = "select * from rol";
            ResultSet rs = stmt.executeQuery(sql);
            RoleDao dao;
            while (rs.next()) {
                dao = new RoleDao();
                dao.setId(rs.getInt("id_Rol"));
                dao.setDetRol(rs.getString("DetRol"));
                list.add(dao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetRol() {
        return detRol;
    }

    public void setDetRol(String detRol) {
        this.detRol = detRol;
    }

}
