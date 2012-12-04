/*
 * ChequeProtestado.java
 *
 * Created on 21 de octubre de 2006, 01:49 PM
 */

package Paneles;

import beans.Agencia;
import beans.Otros;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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

public class ChequeProtestado extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private Cheque cheque;
private String mensaje="";
private boolean editar;
Cheque gh;
Lista listaAnteriores;


    public ChequeProtestado() {
        initComponents();
        txtProtesto.setEditable(false);
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
        txtProtesto.setText("0");   
        setTabla();
    }
  
private void setPanel(){
   // txtBuscar.setEnabled(true);
    
    Cheque cheque = new Cheque();
   
    String bu=txtBuscar.getText();
    cheque = cheque.Busca2(bu);
    datFechaIngreso.setDate(cheque.getFecha());
    txtAgencia.setText(""+cheque.getNombre());
    txtCodigo1.setText(""+cheque.getNumero());
    txtNombre2.setText(""+cheque.getTotal());
    txtNeto1.setText(""+cheque.getNeto());
    txtAgente1.setText(""+cheque.getUtilidad()); 
    txtTotal1.setText(""+cheque.getUtilidadche());
    txtProtesto.setText("0");
    Boolean rem;
    rem = cheque.getProtestado();
    if (rem==false){
    txtEstado.setText("LIBRE");
    }else{
    txtEstado.setText("PROTESTADO");
    }

 }  

private void setTabla(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
       
         
      Boolean anu=true;
      Lista listaAnteriores =new Lista(new Cheque().lista11(otro, anu));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAPROTESTADO,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
      tblProducto.setModel(modelo);
     
     }
   
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLabelCedula2 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabelNombre2 = new javax.swing.JLabel();
        txtNeto1 = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        txtAgente1 = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelApellido2 = new javax.swing.JLabel();
        txtProtesto = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("PROTESTAR UN CHEQUE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabel1.setText("                                    Numero de Cheque ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtBuscar, gridBagConstraints);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jButton1, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("DATOS DEL  CHEQUE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(jLabelCreditopendiente3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        lblFechaIngreso1.setText("                                    Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabelCedula2.setText("                                    Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCedula2, gridBagConstraints);

        txtAgencia.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtAgencia, gridBagConstraints);

        jLabelNombre1.setText("                                    Numero de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtCodigo1, gridBagConstraints);

        jLabelNombre3.setText("                                    Valor de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre3, gridBagConstraints);

        txtNombre2.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtNombre2, gridBagConstraints);

        jLabelNombre2.setText("                                    Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre2, gridBagConstraints);

        txtNeto1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtNeto1, gridBagConstraints);

        jLabelApellido1.setText("   Valor del Protesto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 5;
        add(jLabelApellido1, gridBagConstraints);

        txtAgente1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtAgente1, gridBagConstraints);

        jLabelCivil2.setText("                                    Sobrantes de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil2, gridBagConstraints);

        txtTotal1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtTotal1, gridBagConstraints);

        jLabelCivil1.setText("                                    Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil1, gridBagConstraints);

        txtEstado.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtEstado, gridBagConstraints);

        jButton3.setText("Habilitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton3, gridBagConstraints);

        jButton2.setText("Protestar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton2, gridBagConstraints);

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton4, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                    DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
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
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelApellido2.setText("                                    Utilidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelApellido2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtProtesto, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
               
      Boolean anu=true;
      Lista listaAnteriores =new Lista(new Cheque().lista11(otro, anu));
    
     int fila=tblProducto.getSelectedRow();
     gh=(Cheque)listaAnteriores.getObject(fila);
     setPanel(gh);   
    }//GEN-LAST:event_tblProductoMouseClicked
private void setPanel(Cheque gg){

        
        datFechaIngreso.setDate(gg.getFecha());
        txtCodigo1.setText(""+gg.getClave());
        txtTotal1.setText(""+gg.getTotal());
        txtAgencia.setText(""+gg.getNombre());
        txtCodigo1.setText(""+gg.getNumero());
        txtNombre2.setText(""+gg.getTotal());
        txtNeto1.setText(""+gg.getNeto());
        txtAgente1.setText(""+gg.getUtilidad()); 
        txtTotal1.setText(""+gg.getUtilidadche());
        txtProtesto.setText(""+gg.getProtesto());
        Boolean rem;
     
        if (gg.getProtestado()==false){
            txtEstado.setText("LIBRE");
        }else{
            txtEstado.setText("PROTESTADO");
        }
    }  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
setblancos();
    }//GEN-LAST:event_jButton4ActionPerformed
private void setblancos(){
        txtBuscar.setEnabled(true);
        txtBuscar.setText("");
        txtCodigo1.setText("");
        txtTotal1.setText("");
        txtAgencia.setText("");
        txtCodigo1.setText("");
        txtNombre2.setText("");
        txtNeto1.setText("");
        txtAgente1.setText(""); 
        txtTotal1.setText("");
        txtEstado.setText("");
        setTabla();
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
        
        
        txtBuscar.setEnabled(true);
        Cheque cheque = new Cheque();
        String bu=txtBuscar.getText();
        cheque = cheque.Busca2(bu);
        
        if (cheque.getProtestado()==true){
            Mensaje.showError(this,"El cheque ya esta Protestado","Error");
            }else{
                    cheque.setProtestado(true);
                    if(txtProtesto.getText().equals("")){
                                    txtProtesto.setText("0"); 
                    }else{
                    cheque.setProtesto(Float.parseFloat(txtProtesto.getText()));
                    cheque.setHorario(otro);
                    //cheque.setTotal(cheque.getTotal()+Float.parseFloat(txtProtesto.getText()));
                    cheque.actualizar();
                    Mensaje.showMensaje(this,"Cheque Protestado");
                }
            }
        setTabla();
        txtProtesto.setText("");
        txtProtesto.setEditable(false);
        setblancos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     Cheque cheque = new Cheque();
     String bu=txtBuscar.getText();
     cheque = cheque.Busca2(bu);
     Boolean anu=true;
    
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);
 
     Lista listaAnteriores =new Lista(new Cheque().lista11(otro, anu));
     
     int fila=tblProducto.getSelectedRow();
     gh=(Cheque)listaAnteriores.getObject(fila);
        
       if(gh==null){
        txtBuscar.setEnabled(true);
        Cheque g = new Cheque();
        bu=txtBuscar.getText();
        g = cheque.Busca2(bu);
        if(g.getProtestado()==true){
                                g.setProtestado(false);
                                float ui=0;
                                g.setProtesto(ui);
                                g.actualizar();
                                Mensaje.showMensaje(this,"EL CHEQUE FUE HABILITADO  "+g.getClave());
                                setTabla();
                                }else{
                                Mensaje.showError(this,"Este cheque esta libre","Error");
                                }
       }else{
        if(gh.getProtestado()==true){
                                gh.setProtestado(false);
                                float ui=0;
                                gh.setProtesto(ui);
                                gh.actualizar();
                                Mensaje.showMensaje(this,"EL CHEQUE FUE HABILITADO  "+gh.getClave());
                                setTabla();
        }else{
                                Mensaje.showError(this,"Este cheque esta libre","Error");
                                }
       }
               
    setblancos();  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cheque cheque = new Cheque();
        String bu=txtBuscar.getText();
        cheque = cheque.Busca2(bu);
        
        if (cheque==null){
            Mensaje.showError(this,"No hay ningun cheque con ese numero intente denuevo","Error");
        }else{
            setPanel();
         txtProtesto.setEditable(true);
         txtBuscar.setEnabled(false);  
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtAgente1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNeto1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtProtesto;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
    
}
