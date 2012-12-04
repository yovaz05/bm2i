/*
 * VerPasajes.java
 *
 * Created on 29 de enero de 2007, 11:22 PM
 */

package Paneles;

import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Pasajes;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class VerPasajes extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Pasajes pasajes;
private String mensaje="";
private boolean editar;
Pasajes gh;
Lista listaAnteriores;

    public VerPasajes() {
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
         Pasajes pasajes= new Pasajes();
               
               
        // Mensaje.showMensaje(this,"el nombre es "+agencia.getNombre());
         Date hora1;
         Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
         Boolean rem=true;
         
         listaAnteriores =new Lista(new Pasajes().lista4(hora1,hora2));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVIAJES,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
     
 } 
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelNombreGrup1 = new javax.swing.JLabel();
        lblFechaIngreso2 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        jBImprimir = new javax.swing.JButton();
        jBVer = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        datHasta = new org.jdesktop.swingx.JXDatePicker();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombreGrup1.setText("Nombre del Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabelNombreGrup1, gridBagConstraints);

        lblFechaIngreso2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso2.setText("HASTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso2, gridBagConstraints);

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso1.setText("DESDE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jBImprimir, gridBagConstraints);

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 12);
        add(jBVer, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombre, gridBagConstraints);

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datDesde, gridBagConstraints);

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

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText(" REPORTES DE PASAJES PROTESTADOS DESDE UNA FECHA HASTA OTRA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        add(jLabelCreditopendiente2, gridBagConstraints);

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datHasta, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        /**TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh); */
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed
        setTabla();
    }//GEN-LAST:event_jBVerActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        Boolean rem=true;
        
        Date hora1;
        Date hora2;
        
        hora1=datDesde.getDate();
        hora2=datHasta.getDate();
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Pasajes().lista4(hora1,hora2)),Mapa.MAPAVIAJES,true),ReportePrevio.VERPASAJES);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            //rp.setAgencia(""+agencia.getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBImprimirActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datDesde;
    private org.jdesktop.swingx.JXDatePicker datHasta;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBVer;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JLabel lblFechaIngreso2;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
