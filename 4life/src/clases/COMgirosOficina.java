/*
 * COMgirosOficina.java
 *
 * Created on 3 de noviembre de 2006, 14:41
 */

package clases;

/**
 *
 * @author  ANtro
 */
public class COMgirosOficina extends javax.swing.JInternalFrame {
    
    /** Creates new form COMgirosOficina */
    public COMgirosOficina() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        girosOficina1 = new Paneles.GirosOficina();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Panel Giros de Oficina");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/guardar.png")));
        getContentPane().add(girosOficina1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paneles.GirosOficina girosOficina1;
    // End of variables declaration//GEN-END:variables
    
}
