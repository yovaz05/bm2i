/*
 * COMCxP.java
 *
 * Created on 7 de noviembre de 2006, 1:55
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMCxP extends javax.swing.JInternalFrame {
    
    /** Creates new form COMCxP */
    public COMCxP() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelCxP1 = new Paneles.PanelCxP();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Dar Creditos (Cuentas por Pagar)");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/preferences-desktop-peripherals(2).png")));
        getContentPane().add(panelCxP1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.PanelCxP panelCxP1;
    // End of variables declaration//GEN-END:variables
    
}
