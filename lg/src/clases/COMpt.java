/*
 * COMpt.java
 *
 * Created on 7 de noviembre de 2006, 19:51
 */

package clases;

import java.util.Vector;

/**
 *
 * @author  ANtro
 */
public class COMpt extends javax.swing.JInternalFrame {
    
    /** Creates new form COMpt */
    public COMpt() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panelPagoTarjeta1 = new Paneles.PanelPagoTarjeta();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().add(panelPagoTarjeta1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.PanelPagoTarjeta panelPagoTarjeta1;
    // End of variables declaration//GEN-END:variables
    
}
