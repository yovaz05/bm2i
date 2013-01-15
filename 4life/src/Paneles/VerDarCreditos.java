/*
 * VerDarCreditos.java
 *
 * Created on 22 de octubre de 2006, 11:11 PM
 */

package Paneles;

import beans.Otros;
import beans.Cierre;
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

public class VerDarCreditos extends javax.swing.JPanel {
 
    private Lista lista;
    private Lista codigo;
    private Horario horario;
    private Cierre cierre;
    private String mensaje="";
    private boolean editar;
    Cierre gh;
    Lista listaAnteriores;
    
    public VerDarCreditos() {
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
         Cierre cuentas= new Cierre();
         Date hora1;
         Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
          
         listaAnteriores =new Lista(new Cierre().listarFecha(hora1,hora2));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRES,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
       }   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreditopendiente2.setText(" REPORTES DE CIERRES DE CAJA");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 85, 430, -1));

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("DESDE");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 116, -1, 23));

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 116, 129, -1));

        lblFechaIngreso2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso2.setText("HASTA");
        add(lblFechaIngreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 116, -1, 23));

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 116, -1, -1));

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        add(jBVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 71, -1));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        add(jBImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre del Responsable");
        add(jLabelNombreGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 167, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 167, 206, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 186, 1040, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    
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
        listaAnteriores =new Lista(new Cierre().listarFecha(hora1,hora2));
        try {
        //  ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAINVERSION,true),ReportePrevio.INVENTARIO); 
            ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPACIERRES,true),ReportePrevio.REPORTECIERRE);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            //rp.setAgencia(""+agencia.getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed
        setTabla();
    }//GEN-LAST:event_jBVerActionPerformed
    
    
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
