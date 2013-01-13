/*
 * VerPasajes.java
 *
 * Created on 29 de enero de 2007, 11:22 PM
 */

package Paneles;


import beans.Factura;
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

public class VerPasajes extends javax.swing.JPanel {
      private Lista lista;
    private Lista codigo;
    private Horario horario;
 
    private String mensaje = "";
    private boolean editar;
    Lista listaAnteriores;
    Lista listaFactura;


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
   
       private void setTabla() {
      
        horario = new Horario();
        Horario hora = new Horario();
        Boolean est = (false);
        hora = horario.buscar(est);


        // Mensaje.showMensaje(this,"el nombre es "+agencia.getNombre());
        Date hora1;
        Date hora2;

        hora1 = datDesde.getDate();
        hora2 = datHasta.getDate();
        Boolean rem = true;

        listaFactura = new Lista(new Factura().listarFecha(hora1, hora2));
        //listaAnteriores =new Lista(new Flores().lista4(hora1,hora2));         
        Mapa mapa = new Mapa(listaFactura, Mapa.MAPAFAC, true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo);

    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso2 = new javax.swing.JLabel();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datHasta = new org.jdesktop.swingx.JXDatePicker();
        jBVer = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1130, 530));

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreditopendiente2.setText("REPORTE PARA ENVIAR A QUITO");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 450, -1));

        lblFechaIngreso2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso2.setText("DESDE");
        add(lblFechaIngreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, 23));

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 129, -1));

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("HASTA");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, 23));

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, -1, -1));

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        add(jBVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        add(jBImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, -1, -1));

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre del Responsable");
        add(jLabelNombreGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 167, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.setPreferredSize(new java.awt.Dimension(20, 16));
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 166, 771, -1));
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
        horario = new Horario();
        Horario hora = new Horario();
        Boolean est = (false);
        hora = horario.buscar(est);

        Date hora1;
        Date hora2;

        hora1 = datDesde.getDate();
        hora2 = datHasta.getDate();

        try {

            listaFactura = new Lista(new Factura().listarFecha(hora1, hora2));
            Mapa mapa = new Mapa(listaFactura, Mapa.MAPAFAC, true);
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Factura().listarFecha(hora1, hora2)), Mapa.MAPAFAC, true), ReportePrevio.REPORTEQUITO);
            rp.setRespon(hora.getUsuario().getNombre() + " " + hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
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
