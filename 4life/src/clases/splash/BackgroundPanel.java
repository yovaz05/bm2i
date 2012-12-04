/*
 *Richard Armijos (C) 2007
 */
package clases.splash;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
 
public  class BackgroundPanel extends JPanel {

    private BufferedImage im;
     
    private int x;  
    private int y;  
    private int width;  
    private int height;
    private Robot robot;
   
    public BackgroundPanel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        try {
            robot = new Robot();
        } catch(Exception e) {  
            e.printStackTrace();
        }

        capture();
    }    
 
    public void capture() {
        try {
            im = robot.createScreenCapture(new Rectangle(x, y, width, height));
        } catch(Exception e) {
            e.printStackTrace();
        }
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    
        if (im != null) {
            g.drawImage(im, 0, 0, null);
        }
    }
}
