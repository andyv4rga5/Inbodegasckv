/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import com.mysql.jdbc.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor velandia
 */
public class UserDao {

    public boolean createUser(String password, String user, String userName, String userLastName, int docTypeId, String docNumber, int roleId, int jobId) {
        Connection connection = ConnectionBD.getConnection();
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO `login` (`User`, `Password`) VALUES ('" + user + "', '" + password + "')";
            stmt.executeUpdate(sql);
            ResultSet keys = (ResultSet) stmt.getGeneratedKeys();

            if (keys.next()) {
                int idLogin = keys.getInt(1);

                String sqlUser = "INSERT INTO `usuarios` (`Nombre`, `Apellido`, `Documento`, `id_Rol`, `id_TipoDocumento`, `id_Cargo`, `id_Login`)"
                        + " VALUES('" + userName + "', '" + userLastName + "', '" + docNumber + "', "
                        + "'" + roleId + "', '" + docTypeId + "', '" + jobId + "', '" + idLogin + "') ";
                stmt.executeUpdate(sqlUser);
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean deleteUser(String idLogin) {
        Connection connection = ConnectionBD.getConnection();
        try {
            Statement stmt = connection.createStatement();

            String sql = "DELETE FROM `login` WHERE id_Login = '" + idLogin + "'";
            stmt.executeUpdate(sql);

            sql = "DELETE FROM `Usuarios` WHERE id_Login = '" + idLogin + "'";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean updateUser(String idLogin, String password, String user, String userName, String userLastName, int docTypeId, String docNumber, int roleId, int jobId) {
        Connection connection = ConnectionBD.getConnection();
        try {
            Statement stmt = connection.createStatement();

            String sql = "UPDATE `login` SET `User` = '" + user + "', `Password` = '" + password + "' WHERE id_Login = '" + idLogin + "'";
            stmt.executeUpdate(sql);
            ResultSet keys = (ResultSet) stmt.getGeneratedKeys();

            String sqlUser = "UPDATE `usuarios` SET "
                    + "`Nombre` = '" + userName + "',"
                    + "`Apellido` = '" + userLastName + "',"
                    + "`Documento` = '" + docNumber + "',"
                    + "`id_Rol` = '" + roleId + "',"
                    + "`id_TipoDocumento` = '" + docTypeId + "',"
                    + "`id_Cargo` = '" + jobId + "' "
                    + " WHERE `id_Login` = '"+idLogin+"'";
            stmt.executeUpdate(sqlUser);
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
