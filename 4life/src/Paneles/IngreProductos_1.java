/*
 * IngreProductos.java
 *
 * Created on 4 de noviembre de 2006, 20:01
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.Provedor;
import beans.Otros;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.Compras;


public class IngreProductos_1 extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private Otros otros;
private String mensaje="";
private boolean editar;
private Provedor provedor;
private Compras compras;
Compras gh;
Lista listaAnteriores;


    public IngreProductos_1() {
       
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        if (hora==null){
            Mensaje.showMensaje(this,"DEBE INICIAR CESION  CIERRE Y ABRA EL PROGRAMA NUEVAMENTE");
        }else{
        compras = new Compras();
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
        
         otros = new Otros();
                   lista = new Lista(new Otros().lista());
                   for(int i=0;i<lista.getSize();i++){
                   Otros b1=(Otros) lista.getObject(i);
                   cboProductos.addItem(b1.getNombre());
            }
        provedor = new Provedor();
                   codigo = new Lista(new Provedor().lista());
                   for(int i=0;i<codigo.getSize();i++){
                   Provedor pro=(Provedor) codigo.getObject(i);
                   cboProveedor.addItem(pro.getNombre());
                   }  
        }
      
    }
   
 private void inicializa(){
                  
                                   
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                  
                   modoEdicion(false);
                   setTabla();
                          } 
 
 
       private void fijaMetodos(){
                    
        panMantenimiento1.getBtnCancelar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        
        panMantenimiento1.getBtnEditar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
        
        panMantenimiento1.getBtnNuevo().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevo();
            }
        });
         
        panMantenimiento1.getBtnAceptar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aceptar();
            }
        });
        
        panMantenimiento1.getBtnBorrar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
    }
       
  public boolean saveOrUpdate(){
        
      
        if(isEditar()){
             compras = new Compras();            
             getPanel3();
                       }else{            
                             compras = new Compras();                 
                             getPanel2();
                             
                             }
                        return true;
                 } 
    
    private void aceptar(){
     
            if(saveOrUpdate()){
            Mensaje.showMensaje(this,"GUARDADO");
            modoEdicion(false);
            setTabla();
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR","Eliminar");
        if (b){
            borra();
            setTabla();
            setBlanco();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            otros=(Otros)lista.getMyself();
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
        otros=(Otros)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       otros=(Otros)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        otros=(Otros)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        otros=(Otros)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
       
        
       
} 
private void setPanel(Compras gg){
        cboProductos.setSelectedItem(gg.getOtros().getNombre());
        txtStock.setText(""+gg.getUnidades());
        cboProveedor.setSelectedItem(gg.getProvedor().getNombre());
        txtNfactura.setText(""+gg.getNfactura());
    }  
    
    
    private void getPanel(){
      
        otros.setFechaLlegada(datFechaIngreso.getDate());
                
        int tot=otros.getTotal();
        int st=otros.getStock();
        
       otros.setTotal(tot+Integer.parseInt(txtStock.getText()));
       otros.setTotal(st+Integer.parseInt(txtStock.getText()));


       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       otros.setHorario(otro);
      
    }
    
   
  private void getPanel2(){
        
        otros = new Otros(); 
        provedor= new Provedor();
        
      
       horario=new Horario();
                     Horario otro = new Horario();
                     Boolean est=(false);
                     otro=horario.buscar(est);
                       
                     otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));  
                    
                     int tot=otros.getTotal();
                     int st=otros.getStock();
        
                     otros.setTotal(tot+Integer.parseInt(txtStock.getText()));
                     otros.setStock(st+Integer.parseInt(txtStock.getText()));
                    // otros.setUtilidad(Float.parseFloat(""+0));
                     otros.actualizar(); 
                     
                     provedor =((Provedor)codigo.getObject(cboProveedor.getSelectedIndex()));  
                     compras = new Compras();
                     
                     compras.setFecha(datFechaIngreso.getDate());
                     compras.setHorario(otro);
                     compras.setOtros(otros);
                     compras.setProvedor(provedor);
                     compras.setUnidades(Integer.parseInt(txtStock.getText()));
                     compras.setNfactura(txtNfactura.getText());
                     compras.guardar();
      
       }
    
  private void getPanel3(){
        int fila=tblProducto.getSelectedRow();
        otros = new Otros(); 
        if (fila<=0){
                    Mensaje.showError(this,"No ha elejido un producto para editar","ERROR");
        }else{
                     horario=new Horario();
                     Horario otro = new Horario();
                     Boolean est=(false);
                     otro=horario.buscar(est);
            
            
                  gh=(Compras)listaAnteriores.getObject(fila);     
                               
     
                  int tot=gh.getOtros().getTotal();
                  int st=gh.getOtros().getStock();
                  Otros otros = new Otros(); 
                  otros=gh.getOtros();
                  
                  otros.setTotal(tot+Integer.parseInt(txtStock.getText()));
                  otros.setStock(st+Integer.parseInt(txtStock.getText()));
                  otros.actualizar();    
          
                  provedor =((Provedor)codigo.getObject(cboProveedor.getSelectedIndex()));  
                     
                     gh.setFecha(datFechaIngreso.getDate());
                     gh.setHorario(otro);
                     gh.setOtros(otros);
                     gh.setProvedor(provedor);
                     gh.setUnidades(Integer.parseInt(txtStock.getText()));
                     gh.setNfactura(txtNfactura.getText());
                     gh.actualizar();
        
          }
        
        
          
  
    }    
 private void borra(){
    int fila=tblProducto.getSelectedRow();
    gh=(Compras)listaAnteriores.getObject(fila); 
                 //AQUI BORRO LA ADQUICION Y RESTO DEL STOCK Y DEL OTRO TOTAO
//#####################################################################################3
    Otros otros= new Otros();
    otros=gh.getOtros();
    otros.setStock(otros.getStock()-gh.getUnidades());
    otros.setTotal(otros.getTotal()-gh.getUnidades());
    otros.actualizar();
//#####################################################################################3
        
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

        txtStock.setText("");
        txtNfactura.setText("");
         
    }
    
    
public void modoEdicion(boolean b){

       txtNfactura.setEditable(b);
       txtStock.setEditable(b);
       panMantenimiento1.setActiva(b);
      
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
         Boolean est=(false);
         hora=horario.buscar(est);
           
        listaAnteriores =new Lista(new Compras().lista1(hora));
               
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAADQUICICIONES,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo);
     
     }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre2 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelCivil2 = new javax.swing.JLabel();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        cboProductos = new javax.swing.JComboBox();
        cboProveedor = new javax.swing.JComboBox();
        jLabelCedula2 = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        jLabelNombre4 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabelNombre5 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtStock4 = new javax.swing.JTextField();
        jLabelNombre6 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                 ADQUICICION DE MERCADERIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFechaIngreso.setForeground(new java.awt.Color(51, 51, 255));
        lblFechaIngreso.setText("           Si los datos del producto no coincide con los de esta pantalla ingrese el producto como nuevo ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(lblFechaIngreso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        add(jLabelNombre2, gridBagConstraints);

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(txtStock, gridBagConstraints);

        jLabelApellido1.setText("                               Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        jLabelCivil2.setText("Numero de Factura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 19, 0, 0);
        add(jLabelCivil2, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                         DATOS DEL RESPONSABLE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(panMantenimiento1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(cboProductos, gridBagConstraints);

        cboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProveedorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(cboProveedor, gridBagConstraints);

        jLabelCedula2.setText("Nombre del Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 19, 0, 0);
        add(jLabelCedula2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(txtNfactura, gridBagConstraints);

        jLabelNombre3.setText("                               Puntos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre3, gridBagConstraints);

        txtPuntos.setEditable(false);
        txtPuntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPuntosKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtPuntos, gridBagConstraints);

        jLabelNombre4.setText("                               Costo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre4, gridBagConstraints);

        txtCosto.setEditable(false);
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCosto, gridBagConstraints);

        jLabelNombre5.setText("                               Linea");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre5, gridBagConstraints);

        txtLinea.setEditable(false);
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLineaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtLinea, gridBagConstraints);

        txtStock4.setEditable(false);
        txtStock4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStock4KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtStock4, gridBagConstraints);

        jLabelNombre6.setText("                                Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre6, gridBagConstraints);

        lblFechaIngreso1.setText("                               Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
       txtNfactura.requestFocus();
            
        } 
    }//GEN-LAST:event_txtStockKeyPressed

    private void cboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProveedorActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_cboProveedorActionPerformed

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed
        Otros otros;
        otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
        txtStock.setText(String.valueOf(otros.getStock()));
        txtLinea.setText(String.valueOf(otros.getLinea().getNombre()));
        txtCosto.setText(String.valueOf(otros.getCosto()));
        txtPuntos.setText(String.valueOf(otros.getPuntos()));
        txtStock4.setText(String.valueOf(otros.getStock()));
    }//GEN-LAST:event_cboProductosActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Compras)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void txtPuntosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuntosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuntosKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoKeyPressed

    private void txtLineaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaKeyPressed

    private void txtStock4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStock4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStock4KeyPressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboProductos;
    private javax.swing.JComboBox cboProveedor;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombre5;
    private javax.swing.JLabel jLabelNombre6;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtNfactura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStock4;
    // End of variables declaration//GEN-END:variables
    
}
