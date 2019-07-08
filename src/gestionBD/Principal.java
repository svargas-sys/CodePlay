//CodePlay is licensed under the
//
//Apache License 2.0
//A permissive license whose main conditions require preservation of 
//copyright and license notices. Contributors provide an express grant 
//of patent rights. Licensed works, modifications, and larger works 
//may be distributed under different terms and without source code.
//
//creadores
//CARLOS CERDA
//JOSE LOBOS
//SERGIO VARGAS
//JOSE MUÑOZ
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
