/*
 * PagarDeudas.java
 *
 * Created on 12 de enero de 2007, 13:50
 */

package Paneles;

import beans.Compras;
import beans.Otros;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import modelo.Lista;
import modelo.Mensaje;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PagarDeudas extends javax.swing.JPanel {
 
private Compras compras;
private Lista lista;
private Lista codigo;
private Horario horario;
private String mensaje="";
private boolean editar;
Lista listaAnteriores;
Compras gh;
Otros otros;
    public PagarDeudas() {
        initComponents();
        inicializa();
    }
    
  private void inicializa(){
   Compras compras = new Compras();
  
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
    
    modoEdicion(false);
    setTabla();
} 



      
public boolean saveOrUpdate(){
  
         
  if(isEditar()){
         getPanel2();
     }else{                       
           compras=new Compras();
           getPanel();
           if(compras.guardar()){
              modoEdicion(false);
              return true;
             
            }else{
                return false;
         
            }
        }
        return true;
    } 
    
    private void aceptar(){
     
            if(saveOrUpdate()){
            Mensaje.showMensaje(this,"Guardado");
            modoEdicion(false);           
            setTabla();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR ","Eliminar");
        if (b){
            borra();
            setTabla();
            setBlanco();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            compras=(Compras)lista.getMyself();
            setPanel();
        }
    }
    
    private void editar(){
        setEditar(true);
        modoEdicion(true);
    }
    
    private void nuevo(){
        setBlanco();
        modoEdicion(true);
        setEditar(false);
    }
    
    private void anterior(){
        compras=(Compras)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        compras=(Compras)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        compras=(Compras)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        compras=(Compras)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
   
   datFechaIngreso.setDate(compras.getFecha());
   jTNombre.setText(""+compras.getOtros().getNombre());
   JTCantidad.setText(""+compras.getUnidades());
   jTVProveedor.setText(""+compras.getProvedor().getNombre());
   //float b= compras.getVcompra();
   //float c=compras.getUnidades()*b;
  // jTVTotal.setText(""+c);
   
}  
 private void setPanel(Compras gg){
   
   datFechaIngreso.setDate(gg.getFecha());
   jTNombre.setText(""+gg.getOtros().getNombre());
   JTCantidad.setText(""+gg.getUnidades());
   //jTVUnitario.setText(""+gg.getVcompra());
   jTVProveedor.setText(""+gg.getProvedor().getNombre());
  //float b= gg.getVcompra();
//   float c=gg.getUnidades()*b;
  // jTVTotal.setText(""+c);
   

 }  
    
    private void getPanel(){
   
         
  
    }
    
    
private void getPanel2(){
    
        int fila=tblProducto.getSelectedRow();
        gh=(Compras)codigo.getObject(fila);   
        gh.setUnidades(Integer.parseInt(JTCantidad.getText()));
//        gh.setVcompra(Float.parseFloat(jTVUnitario.getText()));
        float b= Float.parseFloat(JTCantidad.getText());
        float c=Float.parseFloat(jTVUnitario.getText())*b;
        jTVTotal.setText(""+c);
        gh.actualizar();      
        Otros otros=new Otros();
        otros=gh.getOtros();
        int antes=0;
        int ahora=0;
        int editar=0;
        antes=gh.getUnidades();
        ahora=Integer.parseInt(JTCantidad.getText());
        editar=antes-ahora;
        otros.setStock(otros.getStock()-editar);
        int antesT=0;
        int ahoraT=0;
        int editarT=0;
        antesT=gh.getUnidades();
        ahoraT=Integer.parseInt(JTCantidad.getText());
        editarT=antes-ahora;
        otros.setTotal(otros.getTotal()-editarT);
        otros.actualizar();
        
}
    
private void borra(){
  int fila=tblProducto.getSelectedRow();
  gh=(Compras)codigo.getObject(fila);     
  Otros otros=new Otros();
  otros=gh.getOtros();
  otros.setTotal(otros.getTotal()-gh.getUnidades());
  otros.setStock(otros.getStock()-gh.getUnidades());
  otros.actualizar();
  gh.borrar();   
  
}
    
    
private void setBlanco(){


   jTNombre.setText("");
   JTCantidad.setText("");
   jTVUnitario.setText("");
   jTVProveedor.setText("");
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
   
   JTCantidad.setEditable(b);
   jTVUnitario.setEditable(b);
  
          
}

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
 
    
private void setTabla(){
         
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(true);
         hora=horario.buscar(est);
         Boolean e=(true);
         
       if (rb2.isSelected()==true){
         e=(true);
        }
       if (rb3.isSelected()==true){
        e=(false);
        }
         
  codigo = new Lista(new Compras().lista2(e));      
        
  Mapa mapa = new Mapa(codigo,Mapa.MAPADEUDA,true);
  reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
  tblProducto.setModel(modelo);
        
}
 
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTVUnitario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jTNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTVProveedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JTCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTVTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jBPagar = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                              ESTADO DE LAS ADQUICICIONES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setSelected(true);
        rb2.setText("Se Debe");
        rb2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setText("Ya pagado");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb3, gridBagConstraints);

        lblFechaIngreso1.setText("                                   Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabel6.setText("Valor de Compra");
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

        jLabel4.setText("                                   Nombre del Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jTNombre.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTNombre, gridBagConstraints);

        jLabel3.setText("Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel3, gridBagConstraints);

        jTVProveedor.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTVProveedor, gridBagConstraints);

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

        jLabel5.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel5, gridBagConstraints);

        jTVTotal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jTVTotal, gridBagConstraints);

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

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                   DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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

        jBPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Otro.png")));
        jBPagar.setText("Pagar");
        jBPagar.setEnabled(false);
        jBPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPagarActionPerformed(evt);
            }
        });

        add(jBPagar, new java.awt.GridBagConstraints());

    }// </editor-fold>//GEN-END:initComponents

    private void jBPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPagarActionPerformed
     int fila=tblProducto.getSelectedRow();
     gh=(Compras)codigo.getObject(fila);
    // gh.setCredito(false);
   //  gh.setFechapago(new Date());
     gh.actualizar();
     setBlanco();
     Mensaje.showMensaje(this,"Esta adquicicion fue pagada con exito");
     jBPagar.setEnabled(false);
     setTabla();
    }//GEN-LAST:event_jBPagarActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked

     int fila=tblProducto.getSelectedRow();
     gh=(Compras)codigo.getObject(fila);
     setPanel(gh);
     
    }//GEN-LAST:event_tblProductoMouseClicked

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
       setTabla();
    }//GEN-LAST:event_rb2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTCantidad;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTVProveedor;
    private javax.swing.JTextField jTVTotal;
    private javax.swing.JTextField jTVUnitario;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
