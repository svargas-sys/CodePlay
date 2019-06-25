
package gestionBD;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class GestionBD {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC";
    String NOMBREBD = "CodePlay.sqlite";
    String URL = "jdbc:sqlite:"+NOMBREBD;
    
    public void crearBD(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }
    
}//fin metodo
    
    
    public void crearTabla(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE CLIENTES" +
                    "(RUT        TEXT      PRIMARY KEY NOT NULL, " +
                    "NOMBRE    TEXT     NOT NULL, " +
                    "APELLIDOPAT    TEXT     NOT NULL, " +
                    "CORREOELC    TEXT      NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA CLIENTES CREADA!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }        
        
    }    
    
    public void insertarClientes(int Rut, String nombre, String apellidos, String correo){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO CLIENTES " +
                    "(RUT, NOMBRE, APELLIDOPAT, CORREOELC) VALUES " +
                    "('"+Rut+"','"+nombre+"','"+apellidos+"','"+correo+"')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "CLIENTE INGRESADO!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }   
        
    }
    
    
    public void VerDatos(JTable tablaProducto){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT * FROM CLIENTES";
            resultados = sentencia.executeQuery(SQL);
            
            int fila = 0;
            while(resultados.next()){
                
                tablaProducto.setValueAt(resultados.getInt("RUT"), fila, 0);
                tablaProducto.setValueAt(resultados.getString("NOMBRE"), fila, 1);
                tablaProducto.setValueAt(resultados.getString("APELLIDOPAT"), fila, 2);
                tablaProducto.setValueAt(resultados.getString("CORREOELC"), fila, 4);
                fila++;
                
            }
            resultados.close();
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }  
        
    }//FIN METODO    
    


    
}
