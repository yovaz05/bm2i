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
        /*horario = new Horario();
        Horario hora = new Horario();
        Boolean est = (false);
        hora = horario.buscar(est);
        //codigo = new Lista(new CodigoAgencia().lista((Agencia) lista.getObject(cboAgencia.getSelectedIndex())));
        //codigos = new CodigoAgencia();
        //codigos = (CodigoAgencia) codigo.ultimo();


        //Date hora1;
        //Date hora2;

        //hora1 = datDesde.getDate();
        //hora2 = datHasta.getDate();



        //listaAnteriores = new Lista(new Giro().lista12(hora1, hora2, codigos.getAgencia()));*/
        //todos los productos
        listaAnteriores = new Lista(new Otros().lista());
        Mapa mapa = new Mapa(listaAnteriores, Mapa.MAPAEXISTENCIAS, true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jBVer = new javax.swing.JButton();
        jBImprimir = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreditopendiente2.setText("Existencias de productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

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
        gridBagConstraints.weightx = 400.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombre, gridBagConstraints);

        jBVer.setText("Ver");
        jBVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jBVer, gridBagConstraints);

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jBImprimir, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed

  /*      horario = new Horario();
        Horario hora = new Horario();
        Boolean est = (false);
        hora = horario.buscar(est);
//        codigo = new Lista(new CodigoAgencia().lista((Agencia) lista.getObject(cboAgencia.getSelectedIndex())));
  //      codigos = new CodigoAgencia();
//        codigos = (CodigoAgencia) codigo.ultimo();


        Date hora1;
        Date hora2;

        //hora1 = datDesde.getDate();
        //hora2 = datHasta.getDate();

        try {

            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Giro().lista12(hora1, hora2, codigos.getAgencia())), Mapa.MAPAGIRO, true), ReportePrevio.GIROS);
            rp.setRespon(hora.getUsuario().getNombre() + " " + hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setAgencia("" + codigos.getAgencia().getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }


*/


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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jBVer;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
