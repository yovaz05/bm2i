/*
 * PanelCobrarTarjetas.java
 *
 * Created on 2 de abril de 2007, 6:27
 */

package Paneles;


import beans.Otros;
import beans.Horario;
import beans.VentaProductos;
import clases.MenuPrin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import modelo.Lista;
import modelo.Mensaje;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class PanelCobrarTarjetas extends javax.swing.JPanel {
    
private VentaProductos venta;
private Lista lista;
private Lista codigo;
private Horario horario;
private String mensaje="";
private boolean editar;
Lista listaAnteriores;
VentaProductos gh;
Otros otros;

    public PanelCobrarTarjetas() {
        initComponents();
        inicializa();
    }
    
     private void inicializa(){
  
    VentaProductos venta = new VentaProductos();
  
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
    
    modoEdicion(false);
   
} 

    
       
private void setPanel(){
   /*
   datFechaIngreso.setDate(venta.getFechasalida());
   jTNombre.setText(""+venta.getNombre());
   JTCantidad.setText(""+venta.getCredito());
   jTVUnitario.setText(""+venta.getOtros().getVunitario());
   jTVTotal.setText(""+venta.getTotal());
   jTextField1.setText(venta.getNombre());

*/
}  
 private void setPanel(VentaProductos gg){
  /*   
   datFechaIngreso.setDate(gg.getFechasalida());
   jTNombre.setText(""+gg.getNombre());
   JTCantidad.setText(""+gg.getCredito());
   jTVUnitario.setText(""+gg.getOtros().getVunitario());
   jTVTotal.setText(""+gg.getTotal());
   jTextField1.setText(gg.getNombre());
   jTNombre1.setText(gg.getOtros().getNombre());
   int p=Integer.parseInt(gh.getCredito());
   
   if (p==0){
       jBHabilitar.setEnabled(true);
       jBPagar.setEnabled(false);
       
      }else{
       jBHabilitar.setEnabled(false);
       jBPagar.setEnabled(true);
           }
     */
      }  

    
private void borra(){
  int fila=tblProducto.getSelectedRow();
  gh=(VentaProductos)codigo.getObject(fila);     
  Otros otros=new Otros();
  otros=gh.getOtros();
  otros.actualizar();
  gh.borrar();   
  
}
    
    
private void setBlanco(){
   jTNombre.setText("");
   JTCantidad.setText("");
   jTVUnitario.setText("");
   jTVTotal.setText("");
   
   horario=new Horario();
   Horario otro = new Horario();
   Boolean est=(false);
   otro=horario.buscar(est);
      
   if(otro==null){
     Mensaje.showError(this,"ES NULO QUE PASA","Error");
     }else{
         txtNombre.setText(""+otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   }  
 }
 
 public void modoEdicion(boolean b){
   
  // JTCantidad.setEditable(b);
   jTVUnitario.setEditable(b);
  
          
}

     
private void setTabla(){
      
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        Lista codigo = new Lista();
        if (rb2.isSelected()==true){
            codigo = new Lista(new VentaProductos().lista3(jTextField1.getText(), false)); 
            }
       if (rb3.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista4(Integer.parseInt(jTextField1.getText()), false));
                }
      
        if (jRadioButton1.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista8("Credito Cancelado", otro)); 
        }
       if (jRadioButton2.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista7(false)); 
        }
         
         Mapa mapa = new Mapa(codigo,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
}
     
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTVUnitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTVTotal = new javax.swing.JTextField();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        jBPagar = new javax.swing.JButton();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelSubtitulo7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jBHabilitar = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTNombre1 = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("Pago de tarjetas dadas a Credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 1);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso1.setText("                                   Fecha del Credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabel4.setText("Nombre del Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 1);
        add(jLabel4, gridBagConstraints);

        jTNombre.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTNombre, gridBagConstraints);

        jLabel1.setText("                                   Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JTCantidad, gridBagConstraints);

        jLabel6.setText("Valor de Unitario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTVUnitario, gridBagConstraints);

        jLabel5.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel5, gridBagConstraints);

        jTVTotal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTVTotal, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setSelected(true);
        rb2.setText("Por Nombre");
        rb2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setText("Por # Credito");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb3, gridBagConstraints);

        jBPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Otro.png")));
        jBPagar.setText("Pagar");
        jBPagar.setEnabled(false);
        jBPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPagarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 29);
        add(jBPagar, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                   BUSCAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 26, 0);
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
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
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelSubtitulo7.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo7.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo7.setText("                                   DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 26, 0);
        add(jTextField1, gridBagConstraints);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 26, 0);
        add(jButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Pago Hechos Hoy");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Deudores");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jRadioButton2, gridBagConstraints);

        jBHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Otro.png")));
        jBHabilitar.setText("Habilitar");
        jBHabilitar.setEnabled(false);
        jBHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHabilitarActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 29);
        add(jBHabilitar, gridBagConstraints);

        jBPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/print.png")));
        jBPrint.setText("Imprimir");
        jBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrintActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 45, 0, 19);
        add(jBPrint, gridBagConstraints);

        jLabel7.setText("                                   Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel7, gridBagConstraints);

        jTNombre1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTNombre1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrintActionPerformed
         horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        
        
        Lista codigo = new Lista();
        if (rb2.isSelected()==true){
            codigo = new Lista(new VentaProductos().lista3(jTextField1.getText(), false)); 
            }
       if (rb3.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista4(jTextField1.getText(), false));
                }
      
        if (jRadioButton1.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista8("Credito Cancelado", otro)); 
        }
       if (jRadioButton2.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista7(false)); 
        }
        
                    
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(codigo,Mapa.MAPAVENTASDIA,true),ReportePrevio.VERVENTAS);
            rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBPrintActionPerformed

    private void jBHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHabilitarActionPerformed
/*
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
       if (jRadioButton1.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista8("Credito Cancelado", otro)); 
        }
       
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)codigo.getObject(fila);
        
        
        venta = new VentaProductos();
        venta= venta.habiliatr(Integer.parseInt(gh.getCedula()));
        venta.setPagado(false);
        venta.actualizar();
        
        gh.borrar();
        setTabla();*/
    }//GEN-LAST:event_jBHabilitarActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
setTabla();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
setTabla();
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Lista codigo = new Lista(); 
        
       if (jTextField1.getText().equals("")){
           Mensaje.showError(this, "No a Ingresado ninguna busqueda","ERROR");
       }else{
              if (rb2.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista3(jTextField1.getText(), false)); 
                        }
              
              if (rb3.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista4(jTextField1.getText(), false));
                        }
  
              if (codigo.getSize()==0){
              Mensaje.showError(this,"No hay Deudor con esos DATOS","ERROR");
                        } 
       }
       
        
        
         Mapa mapa = new Mapa(codigo,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        
        
        Lista codigo = new Lista();
        if (rb2.isSelected()==true){
            codigo = new Lista(new VentaProductos().lista3(jTextField1.getText(), false)); 
            }
       if (rb3.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista4(jTextField1.getText(), false));
                }
      
        if (jRadioButton1.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista8("Credito Cancelado", otro)); 
        }
       if (jRadioButton2.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista7(false)); 
        }
       
       
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)codigo.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    
   
    
    
    private void jBPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPagarActionPerformed
         
  /*      horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        Lista codigo = new Lista();
        
       if (rb2.isSelected()==true){
            codigo = new Lista(new VentaProductos().lista3(jTextField1.getText(), false)); 
            }
       if (rb3.isSelected()==true){
              codigo = new Lista(new VentaProductos().lista4(jTextField1.getText(), false));
                }
       if (jRadioButton1.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista5(true, otro)); 
        }
       if (jRadioButton2.isSelected()==true){
           codigo = new Lista(new VentaProductos().lista7(false)); 
        }
       if (codigo.getSize()==0){
              Mensaje.showError(this,"No se pude pagar este credito","ERROR");
        }else{
             int fila=tblProducto.getSelectedRow();
             gh=(VentaProductos)codigo.getObject(fila);
             boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA PAGAR EL CREDITO","Eliminar"+gh.getTotal());
             if (b){
                 int c=Integer.parseInt(JTCantidad.getText());
                 int p=Integer.parseInt(gh.getCredito());
                 if (p==c){
                      gh.setPagado(true);
                      gh.actualizar();
                      venta = new VentaProductos();
                      venta.setFechasalida(new Date());
                      venta.setContado(JTCantidad.getText());
                      venta.setTotal(Float.parseFloat(jTVTotal.getText()));
                      venta.setOtros(gh.getOtros());
                      venta.setUsuario(otro.getUsuario());
                      venta.setHorario(otro);
                      venta.setNombre("Credito Cancelado "+jTNombre.getText());
                      venta.setPagado(true);
                      venta.setCedula(""+gh.getId_Venta());
                      venta.guardar();
                      setBlanco();
                      Mensaje.showMensaje(this,"Esta adquicicion fue pagada con exito");
                      setTabla();
                      jBPagar.setEnabled(false);
                 }
                 
                 if (p>c){
                     gh.setCredito(""+(p-c));
                     gh.actualizar();
                     venta = new VentaProductos();
                      venta.setFechasalida(new Date());
                      venta.setContado(JTCantidad.getText());
                      float as=gh.getOtros().getVunitario();
                      
                      venta.setTotal(as*c);
                      venta.setOtros(gh.getOtros());
                      venta.setUsuario(otro.getUsuario());
                      venta.setHorario(otro);
                      venta.setNombre("Pago cuota "+jTNombre.getText());
                      venta.setPagado(true);
                      venta.setCedula(""+gh.getId_Venta());
                      venta.guardar();
                      setBlanco();
                      Mensaje.showMensaje(this,"Esta adquicicion fue pagada con exito");
                      setTabla();
                      jBPagar.setEnabled(false);
                  }
                   if (p<c){
                       Mensaje.showError(this, "No se puede pagar mas de lo que se debe", "ERROR");
                 
                   }
               
             } 
  }


     */  
      
    }//GEN-LAST:event_jBPagarActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
     setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTCantidad;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBHabilitar;
    private javax.swing.JButton jBPagar;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JLabel jLabelSubtitulo7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTNombre1;
    private javax.swing.JTextField jTVTotal;
    private javax.swing.JTextField jTVUnitario;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
