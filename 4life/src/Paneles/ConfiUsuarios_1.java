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

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLTelefono = new javax.swing.JLabel();
        jTRuc = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLTelefono1 = new javax.swing.JLabel();
        jTelefono = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setForeground(java.awt.SystemColor.textHighlight);
        jLabel3.setText("                                          PANEL PARA CONFIGURACION DE PROVEEDORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 34, 0);
        add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("                                                    DATOS DE LA EMPRESA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 7, 0);
        add(jLabel1, gridBagConstraints);

        jLNombre.setText("                                                Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLNombre, gridBagConstraints);

        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jTNombre, gridBagConstraints);

        jLabel4.setText("                                                Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel4, gridBagConstraints);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jTextField3, gridBagConstraints);

        jLTelefono.setText("                                                Ruc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLTelefono, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jTRuc, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
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
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLTelefono1.setText("                                                Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLTelefono1, gridBagConstraints);

        jTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTelefonoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jTelefono, gridBagConstraints);

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

    private void jTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        jTextField3.requestFocus();
            
        }  
    }//GEN-LAST:event_jTNombreKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Provedor)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiUsuarios().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLTelefono1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTRuc;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jTextField3;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
    
}
