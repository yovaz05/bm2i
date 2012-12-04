/*
 * AnularGiro.java
 *
 * Created on 30 de octubre de 2006, 16:19
 */

package Paneles;

import beans.anulargiro;
import beans.Otros;
import java.util.Date;
import java.util.List;
import java.util.Vector;
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

public class AnularGiro extends javax.swing.JPanel {

private anulargiro an;
private Lista lista;
private Lista codigo;
private Lista codigo1;
private Agencia agencia;
private Agencia age;
private Remplazo remplazo;
private CodigoAgencia codigos;
private Horario horario;
private Giro giro;
private Giro sum;
private String mensaje="";
private boolean editar;
anulargiro gh;
Lista listaAnteriores;
    public AnularGiro()   {
         initComponents();
         setTabla();
         horario=new Horario();
         Horario otro = new Horario();
         Boolean est=(false);
         otro=horario.buscar(est);
         txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                         }
   private void bos(){
         txtAgencia.setText("");
         txtCodigo1.setText("");
         txtNombre2.setText("");
         txtNeto1.setText("");
         txtTotal1.setText("");
         txtEstado.setText("");  
       
   }
    private void setPanel(){
         horario=new Horario();
         Horario otro = new Horario();
         Boolean est=(false);
         otro=horario.buscar(est);
         
    Giro g = new Giro();
    if ((txtBuscar.getText().equals(""))){
            
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(anulargiro)listaAnteriores.getObject(fila);
     if (gh==null){
         txtAgencia.setText("");
         txtCodigo1.setText("");
         txtNombre2.setText("");
         txtNeto1.setText("");
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
    txtAgencia.setText(""+g.getAgencia().getNombre());
    txtCodigo1.setText(""+g.getClave());
    txtNombre2.setText(""+g.getNombre());
    txtNeto1.setText(""+g.getNeto());
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
     private void setPanel3(){
         horario=new Horario();
         Horario otro = new Horario();
         Boolean est=(false);
         otro=horario.buscar(est);
         
    Giro g = new Giro();
    if (txtBuscar1.getText().equals("")){
            
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(anulargiro)listaAnteriores.getObject(fila);
     if (gh==null){
         txtAgencia.setText("");
         txtCodigo1.setText("");
         txtNombre2.setText("");
         txtNeto1.setText("");
         txtTotal1.setText("");
         txtEstado.setText("");
                        }else{
                              g=gh.getGiro();   
                            }
    
     }else{
     
      String bu=String.valueOf(txtBuscar1.getText());
      g = giro.Busca2(bu);  
     }
    
    if (g==null) {
         } else{
    datFechaIngreso.setDate(g.getFechaLlegada());
    txtAgencia.setText(""+g.getAgencia().getNombre());
    txtCodigo1.setText(""+g.getClave());
    txtNombre2.setText(""+g.getNombre());
    txtNeto1.setText(""+g.getNeto());
    txtTotal1.setText(""+g.getTotal());
    Boolean rem;
    rem = g.getAnulado();
    if(g.getAnulargiro()==null){
    txtEstado.setText("LIBRE");
    }else{
    txtEstado.setText("ANULADO");
    }   
    }
    
setTabla();

    }     
  
    
 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnularGiro().setVisible(true);
            }
        });
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
        jLabelCedula2 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabelNombre2 = new javax.swing.JLabel();
        txtNeto1 = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelCivil1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        txtBuscar1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                       ANULAR   GIROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabel1.setText("                                                 Codigo Manual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtBuscar, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Buscar.png")));
        jButton1.setMnemonic('C');
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
        jLabelCreditopendiente3.setText("DATOS DEL  GIRO ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(jLabelCreditopendiente3, gridBagConstraints);

        lblFechaIngreso1.setText("                                                 Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabelCedula2.setText("                                                 Agencia");
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

        jLabelNombre1.setText("                                                 Codigo");
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

        jLabelNombre3.setText("                                                 Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre3, gridBagConstraints);

        txtNombre2.setEditable(false);
        txtNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre2KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtNombre2, gridBagConstraints);

        jLabelNombre2.setText("                                                 Neto");
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

        txtTotal1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtTotal1, gridBagConstraints);

        jLabelCivil2.setText("                                                 Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil2, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                 DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelCivil1.setText("                                                 Estado");
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

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
        add(txtNombre, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Borrar.png")));
        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Login.png")));
        jButton3.setText("Habilitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton3, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Look.png")));
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jButton4, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 31);
        add(jScrollPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtBuscar1, gridBagConstraints);

        jLabel2.setText("                                                 Codigo Automatico   . ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel2, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Buscar.png")));
        jButton5.setMnemonic('C');
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jButton5, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Giro g = new Giro();
        giro = new Giro();
       if (txtBuscar1.getText().equals("")){
            Mensaje.showError(this,"No hay ningun numero ingresado", "ERROR");
        }else{
                  g = giro.Busca2(txtBuscar1.getText());
        
        if (g==null){
            Mensaje.showError(this,"No hay ningun giro con este codigo intente denuevo","Error");
        }else{
            setPanel3();
            txtBuscar.setEnabled(false);
            
        }
        
        
        
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtNombre2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyPressed
       if(evt.getKeyCode()==10){
            //tecla enter
             txtNeto1.requestFocus();
        }  
    }//GEN-LAST:event_txtNombre2KeyPressed

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
        txtAgencia.setText(""+gg.getGiro().getAgencia().getNombre());
        txtCodigo1.setText(""+gg.getGiro().getClave());
        txtNombre2.setText(""+gg.getGiro().getNombre());
        txtNeto1.setText(""+gg.getGiro().getNeto());
        txtTotal1.setText(""+gg.getGiro().getTotal());
        if(gg.getGiro().getAnulargiro()==null){
        txtEstado.setText("LIBRE");
        }else{
         txtEstado.setText("ANULADO");
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtBuscar.setEnabled(true);
        
        txtAgencia.setText("");
        txtCodigo1.setText("");
        txtNombre2.setText("");
        txtNeto1.setText("");
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
    if (txtBuscar.getText().equals("")){
               String bu=String.valueOf(txtBuscar1.getText());
               anulargiro an =new anulargiro();
    
               g = giro.Busca2(bu);
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
                 Mensaje.showMensaje(this,"El Giro Fue ANULADO con exito");
                 setPanel3();
    }else{
                   Mensaje.showError(this,"Este giro ya fua ANULADO antes","ERROR");
               }
    }else{
    
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
               Mensaje.showMensaje(this,"El Giro Fue ANULADO con exito");
               setPanel();
    }else{
                   Mensaje.showError(this,"Este giro ya fua ANULADO antes","ERROR");
               }
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
    
    if ((txtBuscar.getText().equals(""))&&(txtBuscar1.getText().equals(""))){
            
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
               Mensaje.showMensaje(this,"El Giro Fue ACTIVADO con exito");
               bos();
               
    }else{
                   Mensaje.showError(this,"Este giro ya fua ACTIVADO antes","ERROR");
               }
     }else{
        
        if ((txtBuscar.getText().equals(""))){
             String bu=String.valueOf(txtBuscar1.getText());
             anulargiro an =new anulargiro();
             g = giro.Busca2(bu);
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
               Mensaje.showMensaje(this,"El Giro Fue ACTIVADO con exito");
               bos();
               
    }else{
                   Mensaje.showError(this,"Este giro ya fua ACTIVADO antes","ERROR");
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
               Mensaje.showMensaje(this,"El Giro Fue ACTIVADO con exito");
               bos();
               
    }else{
                   Mensaje.showError(this,"Este giro ya fua ACTIVADO antes","ERROR");
               }  
        
     }
     
     
     }
        
    setTabla();         
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Giro g = new Giro();
        giro = new Giro();
       if (txtBuscar.getText().equals("")){
            Mensaje.showError(this,"No hay ningun numero ingresado", "ERROR");
        }else{
                Float bus = Float.parseFloat(txtBuscar.getText());
                String bu=String.valueOf(bus);
                g = giro.Busca(bu);
        
        if (g==null){
            Mensaje.showError(this,"No hay ningun giro con este codigo intente denuevo","Error");
        }else{
            setPanel();
            txtBuscar1.setEnabled(false);
         //   txtBuscar.setEnabled(false);
            
        }
        
        
        
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed
     private void setTabla(){
     
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     Boolean b=(true);
     otro=horario.buscar(est);
     
     Lista listaAnteriores =new Lista(new anulargiro().lista2(otro));
     Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIROANULADO,true);
     reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
     tblProducto.setModel(modelo);
     
  
     
     
     
     
     
     
     
//     
//     Agencia agencia = new Agencia();
//     Agencia age= new Agencia();
//     String cod ="PQ";
//     age= agencia.Busca(cod);
//     float o=0;
//     int num=0;
//     
//   Vector vec= new Vector();
//                     Lista codigo=new Lista (new Agencia().lista());
//                          int tamanio1 = codigo.getSize();
//                          for(int j=0;j<tamanio1;j++){
//                             agencia=(Agencia)codigo.getObject(j); 
//                             if (agencia!=age){
//                                 Lista codigo1 =new Lista(new Giro().lista8(otro, b, agencia)); 
//                                 int tamanio2 = codigo1.getSize();
//                                 if(tamanio2==0){
//                                 }else{
//                                      for(int i=0;i<tamanio2;i++){
//                                       sum=(Giro)codigo1.getObject(i);
//                                       vec.add(sum);
//                                       num=num+1;
//                                     }
//                            }
//                 }
//              
//                       }  
//    
//    Mapa mapa = new Mapa(vec,Mapa.MAPAGIROANULADO,true);
//    reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
//    tblProducto.setModel(modelo);                       
     }
    
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNeto1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
    
}
