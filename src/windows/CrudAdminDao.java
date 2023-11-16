/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class CrudAdminDao {
    
    public boolean EliminarProduct(String registro){
        Connection connection = ConnectionBD.getConnection();
        PreparedStatement statement = null;

        try {
            // Utiliza un PreparedStatement para evitar problemas de seguridad (SQL injection)
            String sql = "DELETE FROM `productos` WHERE `Descripcion` = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, registro);

            // Ejecutar la consulta
            int rowsAffected = statement.executeUpdate();

            // Verificar si se eliminó al menos una fila
            return rowsAffected > 0;
        } catch (SQLException ex) {
            // Manejar la excepción (log, mostrar mensaje, etc.)
            ex.printStackTrace();
        } 
        
        return false; // En caso de error
    }
    
    public boolean actualizarProducto(String descripcion, String nuevoNombre, String nuevaMarca, String nuevaDescripcion, double nuevoPrecio, int nuevaCantidad, String nuevoTipoProducto) {
        Connection connection = ConnectionBD.getConnection();
        PreparedStatement statement = null;

        try {
            // Utiliza un PreparedStatement para evitar problemas de seguridad (SQL injection)
            String sql = "UPDATE `productos` SET `Nombre` = ?, `Marca` = ?, `Descripcion` = ?, `Precio` = ?, `Cantidad` = ?, `TipoProducto` = ? WHERE `Descripcion` = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevaMarca);
            statement.setString(3, nuevaDescripcion);
            statement.setDouble(4, nuevoPrecio);
            statement.setInt(5, nuevaCantidad);
            statement.setString(6, nuevoTipoProducto);
            statement.setString(7, descripcion);

            // Ejecutar la consulta
            int rowsAffected = statement.executeUpdate();

            // Verificar si se actualizó al menos una fila
            return rowsAffected > 0;
        } catch (SQLException ex) {
            // Manejar la excepción (log, mostrar mensaje, etc.)
            ex.printStackTrace();
        }
        return false;
    }
}
