/*
 * CinfiAgencias.java
 *
 * Created on 26 de octubre de 2006, 19:23
 */

package Paneles;

import modelo.Mensaje;
import modelo.Lista;

import beans.Linea;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;

public class CinfLinea extends javax.swing.JPanel {
    
private Lista lista;
private Linea linea;
Linea gh;
private String mensaje="";
private boolean editar;
Lista listaAnteriores;


 public CinfLinea() {
       initComponents();
       fijaMetodos();
       inicializa();
       setTabla();
      
    }
 
  private boolean isVacio(){
         if(   jTNombre.getText().equalsIgnoreCase(""))  
             
              return true;
              return false;
  }
    
     
   private void inicializa(){
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
       if (isVacio())
            return false;
                  
             
        if(isEditar()){

         //getPanel2();
            setTabla();
               }else{
            linea =new Linea();
            getPanel();
            if(linea.guardar()){
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
            Mensaje.showMensaje(this,"SE HA GRABADO CON EXITO");
                      modoEdicion(false);
            verificador();
        }else
            Mensaje.showError(this,"Este Error se debe a las sigientes opciones: #1 Este nombre de Agencia ya existe, #2 La clave ya existe, #3 El Codigo contiene letras","Error");
    }
    
    private void borrar(){
        
        boolean b = Mensaje.showPregunta(this,"Desea eliminar la Linea","Eliminar");
        if (b){
            borra();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            linea=(Linea)lista.getMyself();
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
        linea=(Linea)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        linea=(Linea)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        linea=(Linea)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        linea=(Linea)lista.ultimo();
        setPanel();
       
    }
    
    private void setPanel(){
   
        jTNombre.setText(""+linea.getNombre());
        
        
    }  
   private void setPanel(Linea gg){

   jTNombre.setText(""+gg.getNombre());
   

 }
    
    private void getPanel(){
               
        Linea linea= new Linea();
        linea.setNombre(jTNombre.getText());
        
    }
    
    private void setBlanco(){

   jTNombre.setText("");
  
    }
    
    public void verificador(){
       
        
    }
    
    public void modoEdicion(boolean b){
      
   jTNombre.setEditable(b);
  
   panMantenimiento1.setActiva(b);
        
           }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CinfLinea().setVisible(true);
             
            }
        });
    }
    private void setTabla(){


         listaAnteriores =new Lista(new Linea().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAPROVEDOR,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
         
     }
     //**********************************************************************
    //****************           GET PANEL 2    ****************************
    //**********************************************************************
  
     private void borra(){
       /* int fila=tblProducto.getSelectedRow();
        gh=(Linea)listaAnteriores.getObject(fila);
        Compras com= new Compras();
        Lista lista =new Lista(new Compras().lista12(gh));
        if (lista.getSize()<=0){
          gh.borrar();
          setTabla();
        }else{
            Mensaje.showError(this,"No se puede borrar este Proveedor por que tiene productos vendidos en la empresa","ERROR");
        }

       */
       
       }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.textHighlight);
        jLabel3.setText("                                     PANEL PARA CONFIGURACION DE LINEAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 92);
        add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("                                            DATOS DE LA AGENCIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLNombre.setText("                                                           Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 0);
        add(jLNombre, gridBagConstraints);

        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNombreKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 62;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 92);
        add(jTNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 74, 0, 0);
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
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 417;
        gridBagConstraints.ipady = 371;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        jTNombre.requestFocus();
            
        }  
    }//GEN-LAST:event_jTNombreKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Linea)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTNombre;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
    
}
