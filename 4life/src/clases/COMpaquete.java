/*
 * COMpaquete.java
 *
 * Created on 3 de noviembre de 2006, 16:22
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMpaquete extends javax.swing.JInternalFrame {
    
    /** Creates new form COMpaquete */
    public COMpaquete() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        paquetes1 = new Paneles.Paquetes();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Panel Enviar un Paquete");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/system-log-out(2).png")));
        getContentPane().add(paquetes1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.Paquetes paquetes1;
    // End of variables declaration//GEN-END:variables
    
}
