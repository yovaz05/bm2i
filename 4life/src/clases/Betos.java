/*
 * Betos.java
 *
 * Created on 2 de febrero de 2007, 07:40 PM
 */

package clases;

import javax.swing.JPanel;

/**
 *
 * @author  Fernando Chagaray
 */
public class Betos extends javax.swing.JFrame {
    
    /** Creates new form Betos */
    public Betos() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Escritorio = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel6 = new javax.swing.JPanel();
        jXMonthView2 = new org.jdesktop.swingx.calendar.JXMonthView();
        label1 = new java.awt.Label();
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXHEnviarGiro = new org.jdesktop.swingx.JXHyperlink();
        jXHEnviarGiro1 = new org.jdesktop.swingx.JXHyperlink();
        jXHEnviarGiro2 = new org.jdesktop.swingx.JXHyperlink();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Como se cierra");
        jSplitPane1.setBackground(java.awt.Color.white);
        jSplitPane1.setDividerLocation(0);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        Escritorio.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo22.gif")));
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel2.setBounds(0, 0, 780, 690);
        Escritorio.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(Escritorio);

        jSplitPane1.setRightComponent(jScrollPane1);

        jSplitPane1.setLeftComponent(jPanel1);

        jSplitPane2.setBackground(java.awt.Color.white);
        jSplitPane2.setDividerLocation(0);
        jSplitPane2.setDividerSize(0);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBackground(new java.awt.Color(0, 51, 153));
        jXMonthView2.setName("Calendario");
        jXMonthView2.setTraversable(true);
        org.jdesktop.layout.GroupLayout jXMonthView2Layout = new org.jdesktop.layout.GroupLayout(jXMonthView2);
        jXMonthView2.setLayout(jXMonthView2Layout);
        jXMonthView2Layout.setHorizontalGroup(
            jXMonthView2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 203, Short.MAX_VALUE)
        );
        jXMonthView2Layout.setVerticalGroup(
            jXMonthView2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 172, Short.MAX_VALUE)
        );
        jPanel6.add(jXMonthView2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel6.add(label1, gridBagConstraints);

        jXTaskPane1.setTitle("GIROS");
        jXHEnviarGiro.setText("Enviar un Giro");

        jXHEnviarGiro1.setText("Pago de Giros");

        jXHEnviarGiro2.setText("Giros de Oficina");

        org.jdesktop.layout.GroupLayout jXTaskPane1Layout = new org.jdesktop.layout.GroupLayout(jXTaskPane1.getContentPane());
        jXTaskPane1.getContentPane().setLayout(jXTaskPane1Layout);
        jXTaskPane1Layout.setHorizontalGroup(
            jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jXTaskPane1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXHEnviarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHEnviarGiro1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHEnviarGiro2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jXTaskPane1Layout.setVerticalGroup(
            jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jXTaskPane1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jXHEnviarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jXHEnviarGiro1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHEnviarGiro2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel6.add(jXTaskPane1, gridBagConstraints);

        jSplitPane2.setRightComponent(jPanel6);

        jMenu3.setText("Menu");
        jMenuBar1.add(jMenu3);

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jSplitPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 242, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, Short.MAX_VALUE)
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 757, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSplitPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 722, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 698, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Betos().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro1;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro2;
    private org.jdesktop.swingx.calendar.JXMonthView jXMonthView2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
    
}
