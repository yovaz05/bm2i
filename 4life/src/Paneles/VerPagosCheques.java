/*
 * VerPagosCheques.java
 *
 * Created on 29 de octubre de 2006, 12:11 PM
 */

package Paneles;

import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Giro;
import beans.Cheque;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class VerPagosCheques extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private Cheque cheque;
private String mensaje="";
private boolean editar;
Cheque gh;
Lista listaAnteriores;
private Giro giro;  

    public VerPagosCheques() {
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
    private void setTabla(){
         Cheque cheque= new Cheque();
               
               
        // Mensaje.showMensaje(this,"el nombre es "+agencia.getNombre());
         Date hora1;
         Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
         Boolean rem=true;
         
         if (rb2.isSelected()==true){
                
                Boolean a=true;
                listaAnteriores =new Lista(new Cheque().lista9(hora1,hora2, a));         
                Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACHEQUE,true);
                reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
                tblProducto.setModel(modelo);
             
             
        }
        if (rb3.isSelected()==true){
                
                Boolean a=false;
                listaAnteriores =new Lista(new Cheque().lista9(hora1,hora2, a));         
                Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACHEQUE,true);
                reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
                tblProducto.setModel(modelo);
             
             
        }
         
         
        
        
     
 }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        lblFechaIngreso2 = new javax.swing.JLabel();
        datHasta = new org.jdesktop.swingx.JXDatePicker();
        jBVer = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText(" REPORTES DE PAGOS CON CHEQUES DESDE UNA FECHA HASTA OTRA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        add(jLabelCreditopendiente2, gridBagConstraints);

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("DESDE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datDesde, gridBagConstraints);

        lblFechaIngreso2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso2.setText("HASTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso2, gridBagConstraints);

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datHasta, gridBagConstraints);

        jBVer.setText("Ver     .");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        add(jBVer, gridBagConstraints);

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jBImprimir, gridBagConstraints);

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre del Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombre, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rb2.setForeground(new java.awt.Color(0, 51, 255));
        rb2.setText("LG TRAVEL");
        rb2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 7, 0);
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rb3.setForeground(new java.awt.Color(51, 51, 255));
        rb3.setSelected(true);
        rb3.setText("LG TRASMITTER");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 0);
        add(rb3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        
        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

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
        if (rb2.isSelected()==true){
                
                Boolean a=true;
             try {
            
             ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Cheque().lista9(hora1,hora2,a)),Mapa.MAPACHEQUE,true),ReportePrevio.VERPAGOCHEQUE);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setAgencia("LG TRAVEL");
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
                
       }
        if (rb3.isSelected()==true){
                
                Boolean a=false;
             try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Cheque().lista9(hora1,hora2,a)),Mapa.MAPACHEQUE,true),ReportePrevio.VERPAGOCHEQUE);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setAgencia("LG TRASMITTER");
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
             
        }
        
    }//GEN-LAST:event_jBImprimirActionPerformed
    }
    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed
        setTabla();
    }//GEN-LAST:event_jBVerActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datDesde;
    private org.jdesktop.swingx.JXDatePicker datHasta;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBVer;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JLabel lblFechaIngreso2;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
