/*
 * Escritorio.java
 *
 * Created on 3 de marzo de 2007, 6:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Paneles;

import java.awt.Graphics;

/**
 *
 * @author Fercho
 */
public class Escritorio extends javax.swing.JDesktopPane {
    java.awt.Image image;
    int alto;
    int ancho;
    
    /** Creates a new instance of Escritorio */
    public Escritorio() {
       // this.setLayout(new java.awt.BorderLayout());
        javax.swing.ImageIcon img;
        img = new javax.swing.ImageIcon(Escritorio.class.getResource("/fondo22.gif"));
        alto = img.getIconWidth();
        ancho = img.getIconHeight();
        image = img.getImage();
    }
    
    public void paintComponent(Graphics g){
        java.awt.Dimension dimension = this.getSize();
        if(image != null){
          int x = (dimension.width - alto)/2;
          int y = (dimension.height - ancho)/2;
          g.drawImage(image,x,y,this);
        }
        //g.drawImage(image,0,0,this);
    }
}
