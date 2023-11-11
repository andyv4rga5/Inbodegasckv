package windows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author victor velandia
 */
public class ConnectionBD {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/inbodegasCKV", "cchaparro", "192837465");

                /**
                 * connection.close();*
                 */
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
        }
        return connection;
    }

    public static int LogIn(String user, String password) throws SQLException {

        Statement stmt = connection.createStatement();
        String sql = "select * from login where user = '" + user + "' and password = '" + password + "'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            //System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            int idUser = rs.getInt(1);
            return idUser;
        }

        return -1;
    }

    public static int rol(int userId) throws SQLException {

        Statement stmt = connection.createStatement();
        String sql = "select id_Rol from usuarios where id_Login = '"+ userId +"'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            //System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            int idRol = rs.getInt(1);
            return idRol;
        }

        return -1;
    }

}
