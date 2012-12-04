/*
 * PanelCierreFaltante.java
 *
 * Created on 8 de marzo de 2007, 15:33
 */

package Paneles;

import beans.CierreFaltante;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.Usuario;
import beans.CodigoAgencia;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelCierreFaltante extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private CierreFaltante pasajes;
private String mensaje="";
private boolean editar;
private Usuario otros;
CierreFaltante gh;
Lista listaAnteriores;

    public PanelCierreFaltante() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
        
        otros = new Usuario();
                   lista = new Lista(new Usuario().lista());
                   for(int i=0;i<lista.getSize();i++){
                   Usuario b1=(Usuario) lista.getObject(i);
                   cboProductos.addItem(b1.getNombre());
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
                       getPanel2();
                       }else{            
                             pasajes=new CierreFaltante();
                             getPanel();
                             if(pasajes.guardar()){
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
            Mensaje.showError(this,"GUARDADO","Error");
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
            pasajes=(CierreFaltante)lista.getMyself();
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
        pasajes=(CierreFaltante)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       pasajes=(CierreFaltante)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        pasajes=(CierreFaltante)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        pasajes=(CierreFaltante)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        cboProductos.setSelectedItem(pasajes.getCajera().toString());
        txtNeto.setText(""+pasajes.getSaldo());
        txtValor.setText(""+pasajes.getNota());
       
} 
private void setPanel(CierreFaltante gg){
    
        cboProductos.setSelectedItem(gg.getCajera().toString());
        txtNeto.setText(""+gg.getSaldo());
        txtValor.setText(""+gg.getNota());
        
    }  
    
    
    private void getPanel(){
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       pasajes.setHorario(otro);
   
       pasajes.setFecha(datFechaIngreso.getDate());
       pasajes.setSaldo(Float.parseFloat(txtNeto.getText()));
       pasajes.setNota(txtValor.getText());
       
         otros = new Usuario();
         otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex());
         pasajes.setCajera(otros.getNombre());
     //  pasajes.setCajera((String) lista.getObject(cboProductos.getSelectedIndex()));
      
       if (rb2.isSelected()==true){
           pasajes.setGmt(false);
           
        }
       if (rb3.isSelected()==true){
              pasajes.setGmt(true);
           
         } 
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(CierreFaltante)listaAnteriores.getObject(fila);     
       
        gh.setFecha(datFechaIngreso.getDate());
        gh.setSaldo(Float.parseFloat(txtNeto.getText()));
        gh.setNota(txtValor.getText());
        
        otros = new Usuario();
        otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex());
        gh.setCajera(otros.getNombre());
        
        //gh.setCajera((String) lista.getObject(cboProductos.getSelectedIndex()));

        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
          if (rb2.isSelected()==true){
          gh.setGmt(false);
           
        }
       if (rb3.isSelected()==true){
             gh.setGmt(true);
           
     } 
        
        
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(CierreFaltante)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

       
        txtNeto.setText("");
        txtValor.setText("");
         
    }
    
    
public void modoEdicion(boolean b){

    
      txtNeto.setEditable(b);
      txtValor.setEditable(b);
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
         Boolean c=true;  
         if (rb2.isSelected()==true){
          c=false;
           
        }
       if (rb3.isSelected()==true){
            c=true;
           
     } 
         
         
         listaAnteriores =new Lista(new CierreFaltante().lista3(hora, c));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFALTANTECIERRE,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        cboProductos = new javax.swing.JComboBox();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("INGRESO DE  FALTANTES DE OTROS CIEERES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 14, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("FECHA DEL CIERRE ANTERIOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("RESPONSABLE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelNombre2, gridBagConstraints);

        jLabelApellido1.setText("TOTAL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNeto, gridBagConstraints);

        jLabelCivil1.setText("NOTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtValor, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
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
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(tblProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(cboProductos, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        rb2.setForeground(new java.awt.Color(0, 51, 255));
        rb2.setSelected(true);
        rb2.setText("LG TRAVEL");
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
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 7, 0);
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        rb3.setForeground(new java.awt.Color(51, 51, 255));
        rb3.setSelected(true);
        rb3.setText("LG TRASMITTER");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 0);
        add(rb3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       
        setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed
//        otros = new Usuario();
//        otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
//        txtStock.setText(String.valueOf(otros.getStock()));
//        txtVunitario.setText(String.valueOf(otros.getVunitario()));
//        
//        
//        otros = new Usuario();
//                   lista = new Lista(new Usuario().lista());
//                   for(int i=0;i<lista.getSize();i++){
//                   Usuario b1=(Usuario) lista.getObject(i);
//                   cboProductos.addItem(b1.getNombre());
//        }
        
    }//GEN-LAST:event_cboProductosActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(CierreFaltante)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboProductos;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrep;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
    
}
