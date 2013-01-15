/*
 * Vergiros.java
 *
 * Created on 8 de octubre de 2006, 03:10 PM
 */
package Paneles;

import beans.Otros;
import clases.MenuPrin;
//import com.sun.rmi.rmid.ExecOptionPermission;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class Vergiros extends javax.swing.JPanel {

    private Lista lista;
    private Lista codigo;
    private Agencia agencia;
    private CodigoAgencia codigos;
    private Horario horario;
    private Giro giro;
    private String mensaje = "";
    private boolean editar;
    Giro gh;
    Lista listaAnteriores;
    Boolean activado;
    public Vergiros() {
        initComponents();
        //fijaMetodos();
        inicializa();

    }

    private void inicializa() {
        agencia = new Agencia();
        lista = new Lista(new Agencia().lista());
//listaBodega = new Lista(new Bodega().lista());
        for (int i = 0; i < lista.getSize(); i++) {
            Agencia b1 = (Agencia) lista.getObject(i);
            //cboAgencia.addItem(b1.getNombre());
        }




        horario = new Horario();
        Horario otro = new Horario();
        Boolean est = (false);
        otro = horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre() + " " + otro.getUsuario().getApellido());

        //modoEdicion(false);
    }

    private void setTabla() {
     
        
        activado=false;
        listaAnteriores = new Lista(new Otros().lista());
        Mapa mapa = new Mapa(listaAnteriores, Mapa.MAPAEXISTENCIAS, true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo);


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jBVer = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreditopendiente2.setText("Inventario");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 167, 19));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 960, 460));

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre ");
        add(jLabelNombreGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 927, -1));

        jBVer.setText("INVENTARIO");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        add(jBVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        add(jBImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("E MINIMA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
    horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);


        if (activado==true){

         Lista listaAnteriores =new Lista(new Otros().lista());
         try {
              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAMINIMA,true),ReportePrevio.INVENTARIO);
              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
              rp.mostrarVistaPreliminar(MenuPrin.escritorio);
             } catch (Exception e) {
               e.printStackTrace();
             }

        }else{
         Date hora1;
         hora1= new Date();

         Lista listaAnteriores =new Lista(new Otros().lista());
         try {
              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true),ReportePrevio.INVENTARIO);
              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
              rp.setDesde(hora1);
              rp.mostrarVistaPreliminar(MenuPrin.escritorio);
             } catch (Exception e) {
               e.printStackTrace();
             }
        }

    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jBVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVerActionPerformed
        setTabla();
    }//GEN-LAST:event_jBVerActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        /**
         * TODO add your handling code here: int
         * fila=tblProducto.getSelectedRow();
         * gh=(Giro)listaAnteriores.getObject(fila); setPanel(gh);
         */
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       activado=true;

         Lista listaAnteriores =new Lista(new Otros().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAMINIMA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBVer;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
