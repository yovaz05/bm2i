/*
 * Mensaje.java
 *
 * Created on 5 de marzo de 2006, 10:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;


import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Edison
 */
public class Mensaje {
    
    /** Creates a new instance of Mensaje */
    public Mensaje() {
    }
    
    /**
     * 
     * @param parent 
     * @param mensaje 
     * @param titulo 
     */
    public static void showError(Component parent, String mensaje, String titulo){
        JOptionPane.showMessageDialog(parent,mensaje,titulo,JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * 
     * @param parent 
     * @param mensaje 
     * @param titulo 
     * @return 
     */
    public static String showEntrada(Component parent, String mensaje, String titulo){
        return JOptionPane.showInputDialog(parent,mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * 
     * @param parent 
     * @param mensaje 
     */
    public static void showMensaje(Component parent, String mensaje){
        JOptionPane.showMessageDialog(parent,mensaje);
    }
    /**
     * 
     * @param parent 
     * @param mensaje 
     * @param titulo 
     * @return 
     */
    public static boolean showPregunta(Component parent, String mensaje, String titulo){
        int i =JOptionPane.showConfirmDialog(parent,mensaje,titulo,JOptionPane.YES_NO_OPTION);
        if (i==JOptionPane.YES_OPTION)
            return true;
        else 
            return false;
    }



    
    
    
}
