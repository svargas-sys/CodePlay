/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionBD;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import principal.Splash;

/**
 *
 * @author Sergio Vargas
 */
public class Principal {
    
    
    
    public static void main(String[] args) {
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Splash s = new Splash();
            s.setSize(400, 400);
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            gestionBD.GestionBD.crearTabla();
            gestionBD.GestionBD.crearTablaPr();
            gestionBD.GestionBD.insertarProductos();
            gestionBD.GestionBD.crearTablaVenta();
            
        
        }catch(      ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
    }
        
}
        
    
    
}
