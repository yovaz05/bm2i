/*
 * COMCheque.java
 *
 * Created on 7 de noviembre de 2006, 0:57
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMCheque extends javax.swing.JInternalFrame {
    
    /** Creates new form COMCheque */
    public COMCheque() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelCheques1 = new Paneles.PanelCheques();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().add(panelCheques1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.PanelCheques panelCheques1;
    // End of variables declaration//GEN-END:variables
    
}
