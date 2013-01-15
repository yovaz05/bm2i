/*
 * VerCabinas.java
 *
 * Created on 21 de octubre de 2006, 11:50 PM
 */

package Paneles;
import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class VerCabinas extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private String mensaje="";
private boolean editar;
Lista listaAnteriores;

    public VerCabinas() {
        initComponents();
        inicializa();
    }
    private void inicializa(){
  
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
  
 }
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        datHasta = new org.jdesktop.swingx.JXDatePicker();
        jBVer = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        lblFechaIngreso2 = new javax.swing.JLabel();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        jLabel24 = new javax.swing.JLabel();
        txtPtotal = new javax.swing.JTextField();
        txtVtotal = new javax.swing.JTextField();
        jLabelNombreGrup4 = new javax.swing.JLabel();
        jLabelNombreGrup7 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        jLabelNombreGrup8 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                REPORTE DE INVERSION POR PRODUCTO");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 431, -1));

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("DESDE");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 82, -1, 23));

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 82, 129, -1));

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 82, -1, -1));

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        add(jBVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 71, -1));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        add(jBImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre del Responsable");
        add(jLabelNombreGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 133, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 133, 207, -1));

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProducto.setColumnControlVisible(true);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 152, 1030, 420));

        lblFechaIngreso2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso2.setText("HASTA");
        add(lblFechaIngreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 82, -1, 23));

        jXPanel6.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel6.setDoubleBuffered(false);
        jXPanel6.setFocusCycleRoot(true);
        jXPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 0, 153));
        jLabel24.setText("---------------------------------------");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 8, 25);
        jXPanel6.add(jLabel24, gridBagConstraints);

        txtPtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtPtotal.setForeground(java.awt.SystemColor.activeCaption);
        txtPtotal.setBorder(null);
        txtPtotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 11);
        jXPanel6.add(txtPtotal, gridBagConstraints);

        txtVtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtVtotal.setForeground(java.awt.SystemColor.activeCaption);
        txtVtotal.setBorder(null);
        txtVtotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        jXPanel6.add(txtVtotal, gridBagConstraints);

        jLabelNombreGrup4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup4.setText("Valor Inversion ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup4, gridBagConstraints);

        jLabelNombreGrup7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup7.setText("Total Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup7, gridBagConstraints);

        txtPuntos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtPuntos.setForeground(java.awt.SystemColor.activeCaption);
        txtPuntos.setBorder(null);
        txtPuntos.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 11);
        jXPanel6.add(txtPuntos, gridBagConstraints);

        jLabelNombreGrup8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup8.setText("Total Ganancia ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup8, gridBagConstraints);

        add(jXPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        /**TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh); */
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        
        
        Date hora1;
        Date hora2;
        hora1=datDesde.getDate();
        hora2=datHasta.getDate();
        listaAnteriores =new Lista(new Otros().listarFecha(hora1,hora2));  
        
        Otros otros = new Otros();
        
         float inver=0;
         float gan=0;
         int pun=0;
      
         
         
          if (listaAnteriores!= null){
   
               for(int j=0;j<listaAnteriores.getSize();j++){
                      otros=(Otros)listaAnteriores.getObject(j);
                      inver=inver+(otros.getTotal()*otros.getCosto());
                      gan=gan+(otros.getUtilidad());
                      pun=pun+(otros.getPuntos()*otros.getTotal());
              } 
                 }  
         txtVtotal.setText(""+inver);  
         txtPtotal.setText(""+gan);
         txtPuntos.setText(""+pun);
        
        
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAINVERSION,true),ReportePrevio.REPORTEUTILIDAD);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setTotale(inver);
            rp.setTotali(gan);
            rp.setPunto(pun);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed

               
         Otros otros = new Otros();
         Date hora1;
         Date hora2;
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
         float inver=0;
         float gan=0;
         int pun=0;
         listaAnteriores =new Lista(new Otros().listarFecha(hora1,hora2));
         
         
          if (listaAnteriores!= null){
   
               for(int j=0;j<listaAnteriores.getSize();j++){
                      otros=(Otros)listaAnteriores.getObject(j);
                      inver=inver+(otros.getTotal()*otros.getCosto());
                      gan=gan+(otros.getUtilidad());
                      pun=pun+(otros.getPuntos()*otros.getTotal());
              } 
                 }  
         txtVtotal.setText(""+inver);  
         txtPtotal.setText(""+gan);
         txtPuntos.setText(""+pun);
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAINVERSION,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
                 
         
    }//GEN-LAST:event_jBVerActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datDesde;
    private org.jdesktop.swingx.JXDatePicker datHasta;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBVer;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelNombreGrup4;
    private javax.swing.JLabel jLabelNombreGrup7;
    private javax.swing.JLabel jLabelNombreGrup8;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JLabel lblFechaIngreso2;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPtotal;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtVtotal;
    // End of variables declaration//GEN-END:variables
    
}
