/*
 * DevolverP.java
 *
 * Created on 7 de noviembre de 2006, 2:41
 */

package Paneles;

import beans.Otros;
import beans.anulargiro;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.Remplazo;
import beans.Agencia;
import beans.Remplazo;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import java.util.List;

public class DevolverP extends javax.swing.JPanel {

  private anulargiro an;
private Lista lista;
private Lista codigo;
private Agencia agencia;
private Remplazo remplazo;
private CodigoAgencia codigos;
private Horario horario;
private Giro giro;
private String mensaje="";
private boolean editar;
anulargiro gh;
Lista listaAnteriores;
    public DevolverP() {
        initComponents();
        setTabla();
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
    }
     private void setPanel(){
   horario=new Horario();
         Horario otro = new Horario();
         Boolean est=(false);
         otro=horario.buscar(est);
         
    Giro g = new Giro();
    if (txtBuscar.getText().equals("")){
            
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(anulargiro)listaAnteriores.getObject(fila);
     if (gh==null){
        
         txtCodigo1.setText("");
         txtTotal1.setText("");
         txtEstado.setText("");
                        }else{
                              g=gh.getGiro();   
                            }
    
     }else{
      Float bus = Float.parseFloat(txtBuscar.getText());
      String bu=String.valueOf(bus);
      g = giro.Busca(bu);  
     }
    
    if (g==null) {
         } else{
    datFechaIngreso.setDate(g.getFechaLlegada());
   
    txtCodigo1.setText(""+g.getClave());
    txtTotal1.setText(""+g.getTotal());
    Boolean rem;
    rem = g.getAnulado();
    if(g.getAnulargiro()==null){
    txtEstado.setText("LIBRE");
    }else{
    txtEstado.setText("ANULADO");
    }   
    }

    }  
 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnularGiro().setVisible(true);
            }
        });
    }
 private void setTabla(){
    horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     Boolean b=(true);
     otro=horario.buscar(est);
     
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));
     Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPADEVOLVERPAQUETE,true);
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
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
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
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                            DEVOLVER   PAQUETES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabel1.setText("                                                                     Codigo del  paquete   . ");
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Buscar.png")));
        jButton1.setText("Busacar");
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
        jLabelCreditopendiente3.setText("                                                    DATOS DE  PAQUETE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(jLabelCreditopendiente3, gridBagConstraints);

        lblFechaIngreso1.setText("                                                                     Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabelNombre1.setText("                                                                     Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo1.setEditable(false);
        txtCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtCodigo1, gridBagConstraints);

        jLabelCivil2.setText("                                                                     Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil2, gridBagConstraints);

        txtTotal1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtTotal1, gridBagConstraints);

        jLabelCivil1.setText("                                                                     Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil1, gridBagConstraints);

        txtEstado.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtEstado, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Login.png")));
        jButton3.setText("Habilitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton3, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Borrar.png")));
        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton2, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Look.png")));
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton4, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                     DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
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
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 16, 15);
        add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            //tecla enter
            txtTotal1.requestFocus();
            
        }
    }//GEN-LAST:event_txtCodigo1KeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     Boolean b=(true);
     otro=horario.buscar(est);
     
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(anulargiro)listaAnteriores.getObject(fila);
     setPanel(gh);
    
    }//GEN-LAST:event_tblProductoMouseClicked
private void setPanel(anulargiro gg){

       
        datFechaIngreso.setDate(gg.getGiro().getFechaLlegada());
        txtCodigo1.setText(""+gg.getGiro().getClave());
        txtTotal1.setText(""+gg.getGiro().getTotal());
        if(gg.getGiro().getAnulargiro()==null){
        txtEstado.setText("LIBRE");
        }else{
         txtEstado.setText("ANULADO");
        }
    }  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtBuscar.setEnabled(true);
        //txtFecha.setText("");
        txtCodigo1.setText("");
        txtTotal1.setText("");
        txtEstado.setText("");
        setTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
           
    txtBuscar.setEnabled(true);
    Giro g = new Giro();
    Float bus = Float.parseFloat(txtBuscar.getText());
    String bu=String.valueOf(bus);
    
    anulargiro an =new anulargiro();
    
    g = giro.Busca(bu);
    if (g.getAnulargiro()==null){
               if (otro==g.getHorario()){
                 an.setHorario(otro);
                 an.setGiro(g);
                 an.guardar();
                 g.setAnulargiro(an);
                 g.setAnulado(true);
                 g.actualizar();
               }else{
                 an.setHorario(otro);
                 an.setGiro(g);
                 an.guardar();
                 g.setAnulargiro(an);
                 g.actualizar();   
               }
               Mensaje.showMensaje(this,"El paquete Fue ANULADO con exito");
               setPanel();
    }else{
                   Mensaje.showError(this,"Este paquete ya fua ANULADO antes","ERROR");
               }
   setTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
           
    txtBuscar.setEnabled(true);
    Giro g = new Giro();
    
    if (txtBuscar.getText().equals("")){
            
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(anulargiro)listaAnteriores.getObject(fila);
     g=gh.getGiro();
         if (g.getAnulargiro()!=null){
               if (otro==g.getHorario()){
                 g.setAnulado(false);
                 an=g.getAnulargiro();
                 an.borrar();
                 g.setAnulargiro(null);
                 g.actualizar();
               }else{
                 an=g.getAnulargiro();
                 an.borrar();
                 g.setAnulargiro(null);
                 g.actualizar();  
               }
               Mensaje.showMensaje(this,"El Paquete Fue ACTIVADO con exito");
               bos();
               
    }else{
                   Mensaje.showError(this,"Este Paquete ya fua ACTIVADO antes","ERROR");
               }
     }else{
      
    Float bus = Float.parseFloat(txtBuscar.getText());
    String bu=String.valueOf(bus);
    
    anulargiro an =new anulargiro();
    
    g = giro.Busca(bu);
    if (g.getAnulargiro()!=null){
               if (otro==g.getHorario()){
                 g.setAnulado(false);
                 an=g.getAnulargiro();
                 an.borrar();
                 g.setAnulargiro(null);
                 g.actualizar();
               }else{
                 an=g.getAnulargiro();
                 an.borrar();
                 g.setAnulargiro(null);
                 g.actualizar();  
               }
               Mensaje.showMensaje(this,"El Paquete Fue ACTIVADO con exito");
               bos();
               
    }else{
                   Mensaje.showError(this,"Este Paquete ya fua ACTIVADO antes","ERROR");
               }  
        
     }
    
   setTabla();
    
    }//GEN-LAST:event_jButton3ActionPerformed
private void bos(){
       
         txtCodigo1.setText("");
         txtTotal1.setText("");
         txtEstado.setText("");  
       
   }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Giro g = new Giro();
        giro = new Giro();
        Float bus = Float.parseFloat(txtBuscar.getText());
        String bu=String.valueOf(bus);
        g = giro.Busca(bu);
        
        if (g==null){
            Mensaje.showError(this,"No hay ningun giro con este codigo intente denuevo","Error");
        }else{
            setPanel();
            //   txtBuscar.setEnabled(false);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
    
}
