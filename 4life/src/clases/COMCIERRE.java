/*
 * COMCIERRE.java
 *
 * Created on 7 de noviembre de 2006, 22:07
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMCIERRE extends javax.swing.JInternalFrame {
    
    /** Creates new form COMCIERRE */
    public COMCIERRE() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        verCierre21 = new Paneles.VerCierre2();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        jScrollPane1.setViewportView(verCierre21);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private Paneles.VerCierre2 verCierre21;
    // End of variables declaration//GEN-END:variables
    
}