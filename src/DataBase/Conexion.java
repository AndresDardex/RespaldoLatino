/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;
import java.sql.*;

public class Conexion {
    
    private Connection connection;

    public Conexion() {
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:proyectousuarios.db");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}