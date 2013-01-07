/*
 * ConfiUsuarios.java
 *
 * Created on 26 de octubre de 2006, 21:50
 */

package Paneles;

import modelo.Mensaje;
import modelo.Lista;
import beans.Provedor;
import beans.Compras;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;

public class ConfiUsuarios_1 extends javax.swing.JPanel {
    
private Lista lista;
private Provedor usuario;
private Horario horario;
private String mensaje="";
private boolean editar;
Provedor gh;
Lista listaAnteriores;
Compras com;
    public ConfiUsuarios_1() {
      
        horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        if (hora==null){
            Mensaje.showMensaje(this,"DEBE INICIAR CESION  CIERRE Y ABRA EL PROGRAMA NUEVAMENTE");
        }else{
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
        }
        
    }
     private boolean isVacio(){
  if(jTNombre.getText().equalsIgnoreCase("") | (jTextField3.getText().equalsIgnoreCase(""))
    |(jTelefono.getText().equalsIgnoreCase("")) ) 
      return true;
  return false;
        } 
   private void inicializa(){
     
        modoEdicion(false);
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
       if (isVacio())
            return false;
                  
             
        if(isEditar()){
            getPanel2();
            setTabla();
               }else{            
            usuario=new Provedor();
            getPanel();
            if(usuario.guardar()){
                inicializa();
                 setTabla();
               Mensaje.showMensaje(this,"USUARIO AGREGADO"); 
            }else{
                return false;
         
            }
        }
        return true;
    } 
    
    private void aceptar(){
     
            
        if(saveOrUpdate()){
            modoEdicion(false);
            verificador();
        }else
            Mensaje.showError(this,"El registro ya existe","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"Desea eliminar el Provedor","Eliminar");
        if (b){
            borra();
            setBlanco();
            setTabla();
            inicializa();
        }
    }
   private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Provedor)listaAnteriores.getObject(fila);     
        Compras com= new Compras();
        Lista lista =new Lista(new Compras().lista12(gh));
        if (lista.getSize()<=0){
          gh.borrar();   
          setTabla();  
        }else{
            Mensaje.showError(this,"No se puede borrar este Proveedor por que tiene productos vendidos en la empresa","ERROR");
        }
        
       
        
   } 
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            usuario=(Provedor)lista.getMyself();
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
        usuario=(Provedor)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        usuario=(Provedor)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        usuario=(Provedor)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        usuario=(Provedor)lista.ultimo();
        setPanel();
       
    }
    
    private void setPanel(){
        
   jTNombre.setText(""+usuario.getNombre());
   jTextField3.setText(""+usuario.getDireccion());
   jTelefono.setText(""+usuario.getTelefono());   
   jTRuc.setText(usuario.getRuc());
       }  
   
    private void getPanel(){
        usuario.setNombre(jTNombre.getText());
        usuario.setDireccion(jTextField3.getText());
        usuario.setTelefono(jTelefono.getText());
        usuario.setRuc(jTRuc.getText());
    }
    
    private void setBlanco(){
       
   jTNombre.setText("");
   jTextField3.setText("");
   jTelefono.setText(""); 
   jTRuc.setText("");
       }
    
    public void verificador(){
       
    }
    
    public void modoEdicion(boolean b){
       
   jTNombre.setEditable(b);
   jTextField3.setEditable(b);
   jTelefono.setEditable(b);  
   jTRuc.setEditable(b);
    panMantenimiento1.setActiva(b);
       
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Provedor)listaAnteriores.getObject(fila);     
        gh.setNombre(jTNombre.getText());
        gh.setDireccion(jTextField3.getText());
        gh.setTelefono(jTelefono.getText());
        gh.setRuc(jTRuc.getText());
        gh.actualizar();      
}
 private void setPanel(Provedor gg){
   
   jTNombre.setText(""+gg.getNombre());
   jTextField3.setText(""+gg.getDireccion());
   jTelefono.setText(""+gg.getTelefono()); 
   jTRuc.setText(gg.getRuc());
     
 }  
 
 private void setTabla(){
         
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(true);
         hora=horario.buscar(est);
                 
         listaAnteriores =new Lista(new Provedor().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAPROVEDOR,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel16 = new javax.swing.JLabel();
        jLNombre1 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTRuc = new javax.swing.JTextField();
        jLTelefono = new javax.swing.JLabel();
        jTelefono = new javax.swing.JTextField();
        jLTelefono1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("                                                    DATOS DE LA EMPRESA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 7, 0);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        add(panMantenimiento1, gridBagConstraints);

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
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jXPanel2.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jXPanel2.setName("Panel de Miercoles"); // NOI18N
        jXPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("                  PANEL PARA INGRESAR PROVEEDORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 26);
        jXPanel2.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.textHighlight);
        jLabel13.setText("                          Ingrese los datos de los Proveedores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 7, 0);
        jXPanel2.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 16, 7, 21);
        add(jXPanel2, gridBagConstraints);

        jXPanel1.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel1.setDoubleBuffered(false);
        jXPanel1.setFocusCycleRoot(true);
        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 153));
        jLabel16.setText("  ____________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 6, 25);
        jXPanel1.add(jLabel16, gridBagConstraints);

        jLNombre1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jXPanel1.add(jLNombre1, gridBagConstraints);

        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 14);
        jXPanel1.add(jTNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 11, 14);
        jXPanel1.add(jTRuc, gridBagConstraints);

        jLTelefono.setText("Ruc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 11, 0);
        jXPanel1.add(jLTelefono, gridBagConstraints);

        jTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTelefonoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 14);
        jXPanel1.add(jTelefono, gridBagConstraints);

        jLTelefono1.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jXPanel1.add(jLTelefono1, gridBagConstraints);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 14);
        jXPanel1.add(jTextField3, gridBagConstraints);

        jLabel4.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jXPanel1.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(6, 27, 7, 21);
        add(jXPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTelefonoKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
       jTRuc.requestFocus();
            
        } 
    }//GEN-LAST:event_jTelefonoKeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed

        if(evt.getKeyCode()==10){
            //tecla enter
       jTelefono.requestFocus();
            
        }  
    }//GEN-LAST:event_jTextField3KeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Provedor)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreKeyPressed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiUsuarios().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLNombre1;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLTelefono1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTRuc;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
    
}
