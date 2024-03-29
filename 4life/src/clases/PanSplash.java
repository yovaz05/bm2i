/*
 * PanSplash.java
 *
 * Created on 14 de abril de 2006, 02:24 AM
 */

package clases;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * 
 */
public class PanSplash extends javax.swing.JWindow {
    
    /** Creates new form BeanForm */
    public PanSplash() {
        initComponents();
        pack();
    }
    
    /**
     * 
     * @param frame 
     */
    public PanSplash(JFrame frame) {
        super(frame);
        initComponents();
        pack();
        centrar();
    }
    
     public void centrar(){
        Dimension dim = getToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getWidth()/2,
                dim.height/2-this.getHeight()/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        pgbLooading = new javax.swing.JProgressBar();
        lblImagen = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pgbLooading.setForeground(new java.awt.Color(153, 153, 255));
        pgbLooading.setFocusable(false);
        pgbLooading.setIndeterminate(true);
        pgbLooading.setPreferredSize(new java.awt.Dimension(100, 8));
        getContentPane().add(pgbLooading, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 320, 10));

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Datos/LOGOLG.jpg")));
        getContentPane().add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 390, -1));

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-397)/2, (screenSize.height-341)/2, 397, 341);
    }// </editor-fold>//GEN-END:initComponents
    

    public void showSplashScreen() {
	    this.show();
    }

    /**
     * pop down the spash screen
     */
    public void hideSplash() {
	    this.setVisible(false);
    }

   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblImagen;
    private javax.swing.JProgressBar pgbLooading;
    // End of variables declaration//GEN-END:variables
    
}
