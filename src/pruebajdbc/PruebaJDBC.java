/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebajdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaJDBC {

   
    public static void main(String[] args) {
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/pruebajdbc";
        Connection cnx;
        Statement st;
        ResultSet rs;
        //consulta
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cnx = DriverManager.getConnection(url, usuario, password);
            st = cnx.createStatement();
           
            
            //insert
            st.executeUpdate("INSERT INTO producto VALUES('2','Huevos', 550)");
            System.out.println("");
            
            
            
             //Modificar
              st.executeUpdate("UPDATE producto SET precio = 600 WHERE id_producto = 2");
            System.out.println("");
            
           
             
              // Eliminar un producto
            st.executeUpdate("DELETE FROM producto WHERE id_producto = 3");
            System.out.println("");
            
              rs = st.executeQuery("select * from producto");
            rs.next();
             do {
                System.out.println(rs.getInt("id_producto")+ " : " +rs.getString("nombre")+ " : " +rs.getDouble("precio"));
                
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(PruebaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
