
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
    
     public void crearTablaPr(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE PRODUCTO" +
                    "(IDPR        INT      PRIMARY KEY NOT NULL, " +
                    "NOMBREPR    TEXT     NOT NULL, " +
                    "TIPOPR    TEXT     NOT NULL, " +
                    "EMPRESA_DIST    TEXT      NOT NULL, "+
                    "DETALLE  TEXT NOT NULL, "+
                    "PRECIO INT NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA PRODUCTO CREADA!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }        
       }
    
     
     public void insertarProductos(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO PRODUCTO " +
                    "(IDPR, NOMBREPR, TIPOPR, EMPRESA_DIST, DETALlE, PRECIO) VALUES " +
                    "(1,'FARCRY_4','VIDEOJUEGO','UBISOFT',' JUEGO DE ACCION-PRIMERA PERSONA',16900),"
                    + "(2,'FIFA_19','VIDEOJUEGO','EA',' JUEGO DE DEPORTES',29990),"
                    + "(3,'BATTLELFIELD_4','VIDEOJUEGO','EA','JUEGO DE ACCION-SHOOTER',19990),"
                    + "(4,'GOD_OF_WAR','VIDEOJUEGO','SANTA_MONICA','JUEGO DE ACCION-AVENTURA',19990),"
                    + "(5,'GTA_5','VIDEOJUEGO','ROCKSTAR','JUEGO DE ACCION-AVENTURA',18990),"
                    + "(6,'HORIZON_ZERO_DAWN','VIDEOJUEGO','GUERRILLA','JUEGO DE ACCION-AVENTURA',19990),"
                    + "(7,'RESIDENT_EVIL_4','VIDEOJUEGO','CAPCOM','JUEGO DE ACCION-TERROR',19990),"
                    + "(8,'SPIDER-MAN_PS4','VIDEOJUEGO','INSOMNIAC','JUEGO DE ACCION-AVENTURA',18990),"
                    + "(9,'THE_LAST_OF_US','VIDEOJUEGO','NAUGHTY_DOG','JUEGO DE ACCION-AVENTURA',19990),"
                    + "(10,'UNSHARTED_4','VIDEOJUEGO','NAUGHTY_DOG','JUEGO DE ACCION-AVENTURA',19990),"
                    + "(11,'MEMBRESIA_PSPLUS_3','MAMBRESIA DE SUSCRIPCION','PLAYSTATION','MEMBRESIA A PS PLUS POR 3 MESES',17990),"
                    + "(12,'MEMBRESIA_PSPLUS_ANUAL','MEMBRESIA DE SUSCRIPCION','PLAYSTATION','MEMBRECIA A PS PLUS POR 12 MESES',39990)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "PRODUCTOS INGRESADOS!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }   
    }
     
     
    public void crearTablaVenta(){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE VENTA" +
                    "(FOLIO INT NOT NULL, " +
                    "RUTV    TEXT     NOT NULL, " +
                    "IDPRV     INT     NOT NULL, "+
                    "FECVN  DATE     NOT NULL, "+
                    " FOREIGN KEY(RUTV) REFERENCES CLIENTES(RUT), "+
                    " FOREIGN KEY(IDPRV) REFERENCES PRODUCTO(IDPR))";
                 
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "TABLA VENTA CREADA!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }        
        
    } 
     
    
    public void insertarVenta(int folio, String rut, int idproducto, String fecha){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO VENTA " +
                    "(FOLIO, RUTV, IDPRV, FECVN) VALUES " +
                    "('"+folio+"','"+rut+"','"+idproducto+"','"+fecha+"')";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "VENTA INGRESADA!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }   
    }
    
    
    public void DettalleBoleta(JTable tablaProducto, int folio){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "select IDPRV , NOMBREPR, PRECIO " +
                          "from VENTA " +
                          "join PRODUCTO " +
                          "ON PRODUCTO.IDPR=VENTA.IDPRV " +
                          "  WHERE (FOLIO='"+folio+"') ";
            resultados = sentencia.executeQuery(SQL);
            
            int fila = 0;
            while(resultados.next()){
                
                tablaProducto.setValueAt(resultados.getInt("IDPRV"), fila, 0);
                tablaProducto.setValueAt(resultados.getString("NOMBREPR"), fila, 1);
                tablaProducto.setValueAt(resultados.getInt("PRECIO"), fila, 2);
                 
                fila++;
                
            }
            resultados.close();
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: dtalle boleta " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }  
        
    }
     public void Total(JTable tablaProducto, int folio){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT FOLIO, FECVN, RUTV ,  COUNT( PRODUCTO.IDPR ), SUM(PRECIO) " +
                "FROM VENTA " +
                "JOIN CLIENTES " +
                "ON CLIENTES.RUT=VENTA.RUTV " +
                "JOIN PRODUCTO " +
                "ON PRODUCTO.IDPR=VENTA.IDPRV " +
                "WHERE (FOLIO='"+folio+"') " +
                "GROUP by  FOLIO, FECVN ";
            resultados = sentencia.executeQuery(SQL);
            
            int fila = 0;
            while(resultados.next()){
                
                tablaProducto.setValueAt(resultados.getInt("FOLIO"), fila, 0);
                tablaProducto.setValueAt(resultados.getString("FECVN"), fila, 1);
                tablaProducto.setValueAt(resultados.getString("RUTV"), fila, 2);
                tablaProducto.setValueAt(resultados.getInt("COUNT( PRODUCTO.IDPR )"), fila, 3);
                tablaProducto.setValueAt(resultados.getInt("SUM(PRECIO)"), fila, 4);
               
                fila++;
                
            }
            resultados.close();
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: total " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }//FIN METODO 
        

     }

         public void Eliminar(int Rut){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "DELETE FROM CLIENTES WHERE Rut="+Rut+"";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "CLIENTE ELIMINADO!!", 
                    "CODE PLAY", JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
        
    }catch(ClassNotFoundException | SQLException e){
        
        JOptionPane.showMessageDialog(null, "Error: " + e, "Error!!", JOptionPane.ERROR_MESSAGE);
        
    }   
        
    }    //fin metodo
     
}
    
    

     

//   public static void main(String[] args) {
//        GestionBD gbd= new GestionBD();
//        gbd.crearTablaVenta();
//        System.out.println("o");
//    }
//
//}