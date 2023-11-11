/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

import com.mysql.jdbc.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class productosDao {
    
    public boolean createProduct(String nomProducto, String marca, String detalle, int precio, int cantidad, int tProducto) {
        Connection connection = ConnectionBD.getConnection();
        try {
            String sql = "INSERT INTO `productos`(`Nombre`, `Marca`, `Descripcion`, `Precio`, `Cantidad`, `TipoProducto`) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nomProducto);
                pstmt.setString(2, marca);
                pstmt.setString(3, detalle);
                pstmt.setInt(4, precio);
                pstmt.setInt(5, cantidad);
                pstmt.setInt(6, tProducto);

                int rowsAffected = pstmt.executeUpdate();
                // Si rowsAffected es mayor a 0, significa que la inserción fue exitosa
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            // Manejar la excepción (log, mostrar mensaje, etc.)
            ex.printStackTrace();
        } 

        return false; // En caso de error
    }
    
    public List<String> ListaMarcasProductos() {
        List<String> marcasProductos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionBD.getConnection();
            pstmt = connection.prepareStatement("SELECT DISTINCT Marca FROM productos");
            resultSet = (ResultSet) pstmt.executeQuery();

            while (resultSet.next()) {
                String marcaProducto = resultSet.getString("Marca");
                marcasProductos.add(marcaProducto);
            }

        } catch (SQLException e) {
            // Manejar la excepción de una manera más significativa, como lanzar una excepción personalizada o registrarla
            e.printStackTrace();
        } finally {
            // No cerrar manualmente la conexión aquí
        }

        return marcasProductos;
    }
    
    public List<String> ListaNombresProductos(String marca, int tipoProducto) {
        List<String> nombresProductos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionBD.getConnection();
            pstmt = connection.prepareStatement("SELECT Nombre FROM productos WHERE Marca = ? AND TipoProducto = ?");
            pstmt.setString(1, marca);
            pstmt.setInt(2, tipoProducto);

            resultSet = (ResultSet) pstmt.executeQuery();

            while (resultSet.next()) {
                String nombreProducto = resultSet.getString("Nombre");
                nombresProductos.add(nombreProducto);
            }

        } catch (SQLException e) {
            // Manejar la excepción de una manera más significativa, como lanzar una excepción personalizada o registrarla
            e.printStackTrace();
        } finally {
            // Cerrar manualmente los recursos
            
        }

        return nombresProductos;
    }
    
    public boolean eliminarCantidad(String Producto, int cantidad) {
        Connection connection = ConnectionBD.getConnection();

        try {
            String sql = "UPDATE `productos` SET `Cantidad` = `Cantidad` - ? WHERE `Nombre` = ?";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, cantidad);      // Disminuye la cantidad existente en la base de datos con el valor proporcionado
                pstmt.setString(2, Producto);   // Utiliza el nombre del producto como condición de actualización

                int rowsAffected = pstmt.executeUpdate();

                // Si rowsAffected es mayor a 0, significa que la actualización fue exitosa
                return rowsAffected > 0;
            }
        } catch (SQLException ex) {
            // Manejar la excepción (log, mostrar mensaje, etc.)
            ex.printStackTrace();
        }

        return false;
    }
}

