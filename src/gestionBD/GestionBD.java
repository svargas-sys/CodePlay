
package gestionBD;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class GestionBD {
    
    static Connection conexion = null;
    static Statement sentencia = null;
    static ResultSet resultados = null;
    static String DRIVER = "org.sqlite.JDBC";
    static String NOMBREBD = "CodePlay.sqlite";
    static String URL = "jdbc:sqlite:"+NOMBREBD;
    
    public  void crearBD(){
        
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
    
    public static void insertarClientes(int Rut, String nombre, String apellidos, String correo){
        
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
    
    
    public static void VerDatos(JTable tablaProducto){
        
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
                tablaProducto.setValueAt(resultados.getString("CORREOELC"), fila, 3);
                fila++;
                
            }
            resultados.close();
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
        }
    }
    public static void updateClientes(int oldRut, int Rut, String nombre, String apellidos, String correo){
    /*NO REVISADO*//*NO REVISADO*//*NO REVISADO*//*NO REVISADO*//*NO REVISADO*//*NO REVISADO*//*NO REVISADO*/
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "UPDATE PRODUCTOS "+
                    "SET Rut, NOM_PRODU, PRECIO, STOCK, FK_ID, "+
                    "VALUES '"+nombre+"','"+apellidos+"','"+correo+"', "+
                    "WHERE (Rut = '"+oldRut+"' )";
            
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null,"Datos ACTUALIZADOS con exito!!","EXITO!",JOptionPane.INFORMATION_MESSAGE );
            sentencia.close();
            conexion.close();
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error: " + e,
                    "Error!!", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Datos ingresados a la tabla productos con exito");
    }//FIN METODO updateProductos...        
        
    }//FIN METODO    
    






