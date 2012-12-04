/*
 * PanNavegador.java
 *
 * Created on 5 de marzo de 2006, 03:38 PM
 */

package clases;

import javax.swing.JInternalFrame;

/**
 *
 * @author  Edison
 */
public class PanNavegador extends javax.swing.JPanel{
    
    public static final int PRIMERO = 1;
    public static final int ULTIMO = 2;
    public static final int VACIO = 3;
    public static final int NADA = 4;
    public static final int PRIMERO_y_ULTIMO = 5;
    
    private int tipo;
    
    /** Creates new form PanNavegador */
    public PanNavegador() {
        initComponents();
    }
    
    /**
     * 
     * @param b 
     */
    public void activa(boolean b){
        getBtnAnterior().setEnabled(!b);
        getBtnPrimero().setEnabled(!b);
        getBtnSiguiente().setEnabled(!b);
        getBtnUltimo().setEnabled(!b);
    }
    
    /**
     * 
     * @param tipo 
     */
    public void setPosicion(int tipo){
        setTipo(tipo);
        getBtnAnterior().setEnabled(true);
        getBtnPrimero().setEnabled(true);
        getBtnSiguiente().setEnabled(true);
        getBtnUltimo().setEnabled(true);
        switch (getTipo()){
            case PRIMERO:
                getBtnAnterior().setEnabled(false);
                getBtnPrimero().setEnabled(false);
                break;
            case ULTIMO:
                getBtnSiguiente().setEnabled(false);
                getBtnUltimo().setEnabled(false);
                break;
            case VACIO:
                getBtnAnterior().setEnabled(false);
                getBtnPrimero().setEnabled(false);
                getBtnSiguiente().setEnabled(false);
                getBtnUltimo().setEnabled(false);
                break;
            case PRIMERO_y_ULTIMO:
                getBtnAnterior().setEnabled(false);
                getBtnPrimero().setEnabled(false);
                getBtnSiguiente().setEnabled(false);
                getBtnUltimo().setEnabled(false);
                break;
        }
    }

    /**
     * 
     * @return 
     */
    public javax.swing.JButton getBtnAnterior() {
        return btnAnterior;
    }

    /**
     * 
     * @param btnAnterior 
     */
    public void setBtnAnterior(javax.swing.JButton btnAnterior) {
        this.btnAnterior = btnAnterior;
    }

    /**
     * 
     * @return 
     */
    public javax.swing.JButton getBtnPrimero() {
        return btnPrimero;
    }

    /**
     * 
     * @param btnPrimero 
     */
    public void setBtnPrimero(javax.swing.JButton btnPrimero) {
        this.btnPrimero = btnPrimero;
    }

    /**
     * 
     * @return 
     */
    public javax.swing.JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    /**
     * 
     * @param btnSiguiente 
     */
    public void setBtnSiguiente(javax.swing.JButton btnSiguiente) {
        this.btnSiguiente = btnSiguiente;
    }

    /**
     * 
     * @return 
     */
    public javax.swing.JButton getBtnUltimo() {
        return btnUltimo;
    }

    /**
     * 
     * @param btnUltimo 
     */
    public void setBtnUltimo(javax.swing.JButton btnUltimo) {
        this.btnUltimo = btnUltimo;
    }

    /**
     * 
     * @return 
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo 
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        setBorder(javax.swing.BorderFactory.createTitledBorder("Navegador"));
        setForeground(java.awt.SystemColor.info);
        setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        btnPrimero.setBackground(java.awt.SystemColor.activeCaptionText);
        btnPrimero.setFont(new java.awt.Font("MS Sans Serif", 1, 10));
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Primero.gif")));
        btnPrimero.setToolTipText("Primer Registro");
        btnPrimero.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add(btnPrimero, new java.awt.GridBagConstraints());

        btnAnterior.setBackground(java.awt.SystemColor.activeCaptionText);
        btnAnterior.setFont(new java.awt.Font("MS Sans Serif", 1, 12));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Atras.gif")));
        btnAnterior.setToolTipText("Anterior Registro");
        btnAnterior.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add(btnAnterior, new java.awt.GridBagConstraints());

        btnSiguiente.setBackground(java.awt.SystemColor.activeCaptionText);
        btnSiguiente.setFont(new java.awt.Font("MS Sans Serif", 1, 12));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Siguiente.gif")));
        btnSiguiente.setToolTipText("Siguiente Registro");
        btnSiguiente.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add(btnSiguiente, new java.awt.GridBagConstraints());

        btnUltimo.setBackground(java.awt.SystemColor.activeCaptionText);
        btnUltimo.setFont(new java.awt.Font("MS Sans Serif", 1, 12));
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Ultimo.gif")));
        btnUltimo.setToolTipText("Ultimo Registro");
        btnUltimo.setIconTextGap(1);
        btnUltimo.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnUltimo.setMaximumSize(new java.awt.Dimension(40, 20));
        add(btnUltimo, new java.awt.GridBagConstraints());

    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    // End of variables declaration//GEN-END:variables
    
}
