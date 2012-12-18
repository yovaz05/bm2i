/*
 * FinTurno.java
 *
 * Created on 1 de febrero de 2007, 09:22 AM
 */

package Paneles;

import beans.Billetes;
import beans.Cabinas;
import beans.ComprasOficina;
import beans.Flores;
import beans.Otros;
import beans.Pasajes;
import beans.Usuario;
import beans.VentaProductos;
import beans.VideoConferencia;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.CierreFaltante;
import beans.Cierre;
import beans.Agencia;
import beans.Cheque;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import beans.CuentasXCobrar;
import beans.CuentasXPagar;
import beans.PagoT;

import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class FinTurno_1 extends javax.swing.JPanel {
    
  private Lista lista;
  private Lista codigo;
  private Horario horario;
  Lista betos;
  Horario oo; 
  Usuario otros;

  
  
    private Lista codigo1;
    private Agencia agencia;
    private CodigoAgencia codigos;
    
    
    private Giro giro;
    private Giro fin;
    private Giro sum;
    private CierreFaltante cierrefaltante;
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    
    private Cheque cheque;
    private Cheque pri;
    private Cheque ultimito;
    private Cheque bainas;
    

  
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabelNombre2 = new javax.swing.JLabel();
        cboProductos = new javax.swing.JComboBox();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("VER CIEERES ANTERIORES");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 34, 290, -1));

        jButton3.setText("Ver el cieere General de las dos Agencias ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 260, -1));

        jLabelNombre2.setText("RESPONSABLE");
        add(jLabelNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 88, -1));

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });

        add(cboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 138, -1));

        lblFechaIngreso.setText("Hasta");
        add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 24));

        add(datFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 870, 440));

        lblFechaIngreso1.setText("Desde ");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 105, 24));

        add(datFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jButton1.setText("Ingresos LGMT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jButton2.setText("Egresos LGMT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jButton4.setText("Ingresos LG");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jButton5.setText("Egresos LG");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

      

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    // TODO add your handling code here:
        otros = new Usuario();
        otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex()); 
        Date fecha= datFechaIngreso.getDate();
        Date fecha2=datFechaIngreso1.getDate();
      
        Lista betos = new Lista();
        betos = new Lista(new Horario().lista4(fecha, fecha2,otros)); 
        
       int fila=tblProducto.getSelectedRow();
      
       
       
       oo = new Horario();    
       oo=(Horario)betos.getObject(fila);
     
        //setPanel(gh);   
        
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed

        otros = new Usuario();
        otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex()); 
        Date fecha= datFechaIngreso.getDate();
        Date fecha2=datFechaIngreso1.getDate();
      
        Lista betos = new Lista();
        betos = new Lista(new Horario().lista4(fecha, fecha2,otros)); 
             
              
 
         Mapa mapa = new Mapa(betos,Mapa.MAPAFINTURNO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
        
        
    }//GEN-LAST:event_jBuscarActionPerformed

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed
//        otros = new Usuario();
//        otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
//        txtStock.setText(String.valueOf(otros.getStock()));
//        txtVunitario.setText(String.valueOf(otros.getVunitario()));
//
//
//        otros = new Usuario();
//                   lista = new Lista(new Usuario().lista());
//                   for(int i=0;i<lista.getSize();i++){
//                   Usuario b1=(Usuario) lista.getObject(i);
//                   cboProductos.addItem(b1.getNombre());
//        }
    }//GEN-LAST:event_cboProductosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Date hora1;
    hora1=new Date();
    
    try {
      ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(oo.bus(oo)),Mapa.MAPAFINTURNO,true),ReportePrevio.FINDETURNO);
      rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
      rp.setDesde(hora1);
    //  rp.setTotale(egre);
      rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboProductos;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
    
}
