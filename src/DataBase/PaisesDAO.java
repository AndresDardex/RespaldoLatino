/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andrés Dardex
 */
public class PaisesDAO {
    
    private Connection connection;
    
     
    public PaisesDAO(){
    
    try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:BaseDatosRespaldoLatino.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PaisesIndividuales (id INTEGER PRIMARY KEY, Pais TEXT, Capital TEXT, Moneda TEXT, Region TEXT, SubRegion TEXT,Poblacion TEXT, InicioSemana TEXT, Gini TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableFull() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS TodosLosPaises (id INTEGER PRIMARY KEY, Pais TEXT, Capital TEXT, Moneda TEXT, Region TEXT, SubRegion TEXT,Poblacion TEXT, InicioSemana TEXT, Gini TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableLatam() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PaisesLATAM (id INTEGER PRIMARY KEY, Pais TEXT, Capital TEXT, Moneda TEXT, Region TEXT, SubRegion TEXT,Poblacion TEXT, InicioSemana TEXT, Gini TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableRegion() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PaisesPorRegion (id INTEGER PRIMARY KEY, Pais TEXT, Capital TEXT, Moneda TEXT, Region TEXT, SubRegion TEXT,Poblacion TEXT, InicioSemana TEXT, Gini TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableSubRegion() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PaisesPorSubRegion (id INTEGER PRIMARY KEY, Pais TEXT, Capital TEXT, Moneda TEXT, Region TEXT, SubRegion TEXT,Poblacion TEXT, InicioSemana TEXT, Gini TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void create(String Pais,String Capital,String Moneda,String Region,String SubRegion,String Poblacion,String InicioSemana, String gini) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PaisesIndividuales(Pais,Capital,Moneda,Region,SubRegion,Poblacion,InicioSemana, gini) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Pais);
            preparedStatement.setString(2, Capital);
            preparedStatement.setString(3, Moneda);
            preparedStatement.setString(4, Region);
            preparedStatement.setString(5, SubRegion);
            preparedStatement.setString(6, Poblacion);
            preparedStatement.setString(7, InicioSemana);
            preparedStatement.setString(8, gini);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createFull(String Pais,String Capital,String Moneda,String Region,String SubRegion,String Poblacion,String InicioSemana, String gini) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TodosLosPaises(Pais,Capital,Moneda,Region,SubRegion,Poblacion,InicioSemana, gini) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Pais);
            preparedStatement.setString(2, Capital);
            preparedStatement.setString(3, Moneda);
            preparedStatement.setString(4, Region);
            preparedStatement.setString(5, SubRegion);
            preparedStatement.setString(6, Poblacion);
            preparedStatement.setString(7, InicioSemana);
            preparedStatement.setString(8, gini);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createLATAM(String Pais,String Capital,String Moneda,String Region,String SubRegion,String Poblacion,String InicioSemana, String gini) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PaisesLATAM(Pais,Capital,Moneda,Region,SubRegion,Poblacion,InicioSemana, gini) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Pais);
            preparedStatement.setString(2, Capital);
            preparedStatement.setString(3, Moneda);
            preparedStatement.setString(4, Region);
            preparedStatement.setString(5, SubRegion);
            preparedStatement.setString(6, Poblacion);
            preparedStatement.setString(7, InicioSemana);
            preparedStatement.setString(8, gini);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createRegion(String Pais,String Capital,String Moneda,String Region,String SubRegion,String Poblacion,String InicioSemana, String gini) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PaisesPorRegion(Pais,Capital,Moneda,Region,SubRegion,Poblacion,InicioSemana, gini) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Pais);
            preparedStatement.setString(2, Capital);
            preparedStatement.setString(3, Moneda);
            preparedStatement.setString(4, Region);
            preparedStatement.setString(5, SubRegion);
            preparedStatement.setString(6, Poblacion);
            preparedStatement.setString(7, InicioSemana);
            preparedStatement.setString(8, gini);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void createSubRegion(String Pais,String Capital,String Moneda,String Region,String SubRegion,String Poblacion,String InicioSemana, String gini) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PaisesPorSubRegion(Pais,Capital,Moneda,Region,SubRegion,Poblacion,InicioSemana, gini) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, Pais);
            preparedStatement.setString(2, Capital);
            preparedStatement.setString(3, Moneda);
            preparedStatement.setString(4, Region);
            preparedStatement.setString(5, SubRegion);
            preparedStatement.setString(6, Poblacion);
            preparedStatement.setString(7, InicioSemana);
            preparedStatement.setString(8, gini);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
