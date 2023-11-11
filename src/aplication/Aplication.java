package aplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import windows.LogIn;

/**
 *
 * @author david.camacho
 */
public class Aplication {

    public static LogIn jframe;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.145.120:3306/inbodegasCKV", "camilo", "123");
 
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            while (rs.next()) { 
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }*/
        jframe = new LogIn();
            jframe.setVisible(true);
        
    }

}
