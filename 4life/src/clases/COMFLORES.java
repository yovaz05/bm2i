/*
 * COMFLORES.java
 *
 * Created on 3 de noviembre de 2006, 17:27
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMFLORES extends javax.swing.JInternalFrame {
    
    /** Creates new form COMFLORES */
    public COMFLORES() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        confiFlores1 = new Paneles.ConfiFlores();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Panel para enviar Flores");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/kcontrol.png")));
        getContentPane().add(confiFlores1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.ConfiFlores confiFlores1;
    // End of variables declaration//GEN-END:variables
    
}
