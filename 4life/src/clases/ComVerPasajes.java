/*
 * ComVerPasajes.java
 *
 * Created on 29 de enero de 2007, 11:42 PM
 */

package clases;

/**
 *
 * @author  Fernando Chagaray
 */
public class ComVerPasajes extends javax.swing.JInternalFrame {
    
    /** Creates new form ComVerPasajes */
    public ComVerPasajes() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        verPasajes1 = new Paneles.VerPasajes();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Pasajes");
        getContentPane().add(verPasajes1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.VerPasajes verPasajes1;
    // End of variables declaration//GEN-END:variables
    
}
