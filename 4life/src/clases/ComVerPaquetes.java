/*
 * ComVerPaquetes.java
 *
 * Created on 21 de octubre de 2006, 10:14 PM
 */

package clases;

/**
 *
 * @author  Fernando Chagaray
 */
public class ComVerPaquetes extends javax.swing.JInternalFrame {
    
    /** Creates new form ComVerPaquetes */
    public ComVerPaquetes() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        verpaquetes1 = new Paneles.Verpaquetes();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Paquetes enviados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/system-log-out(2).png")));
        getContentPane().add(verpaquetes1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.Verpaquetes verpaquetes1;
    // End of variables declaration//GEN-END:variables
    
}
