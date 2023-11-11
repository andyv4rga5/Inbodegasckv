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
public class JobDao {

    private int id;
    
    private String detCargo;

    public ArrayList<JobDao> getJob() {
        ArrayList<JobDao> list = new ArrayList<JobDao>();
        Connection connection = ConnectionBD.getConnection();
        Statement stmt;
        try {
            stmt = connection.createStatement();

            String sql = "select * from cargo";
            ResultSet rs = stmt.executeQuery(sql);
            JobDao dao;
            while (rs.next()) {
                dao = new JobDao();
                dao.setId(rs.getInt("id_Cargo"));
                dao.setDetCargo(rs.getString("DetCargo"));
                list.add(dao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JobDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetCargo() {
        return detCargo;
    }

    public void setDetCargo(String detCargo) {
        this.detCargo = detCargo;
    }

}
