/*
 * Viajes.java
 *
 * Created on 4 de noviembre de 2006, 18:52
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Pasajes;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class Viajes extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Pasajes pasajes;
private String mensaje="";
private boolean editar;
Pasajes gh;
Lista listaAnteriores;

    public Viajes() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
    }
    
 private boolean isVacio(){
  if(txtNombrep.getText().equalsIgnoreCase("") | txtNeto.getText().equalsIgnoreCase("") | txtValor.getText().equalsIgnoreCase(""))  
   
     return true;
  return false;
        } 
   
 private void inicializa(){
                  
                                   
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                   pasajes = new Pasajes();
                   codigo = new Lista(new Pasajes().lista3(otro));
                   pasajes=(Pasajes) codigo.ultimo();
                   
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
                       getPanel2();
                       }else{            
                             pasajes=new Pasajes();
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
            Mensaje.showMensaje(this,"Se ah Guardado este Pasaje con Exito");
                   
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
            pasajes=(Pasajes)lista.getMyself();
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
        pasajes=(Pasajes)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       pasajes=(Pasajes)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        pasajes=(Pasajes)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        pasajes=(Pasajes)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
        txtNombrep.setText(""+pasajes.getNombre());
        txtNeto.setText(""+pasajes.getNeto());
        txtValor.setText(""+pasajes.getValor());
       
} 
private void setPanel(Pasajes gg){
    
        txtNombrep.setText(""+gg.getNombre());
        txtNeto.setText(""+gg.getNeto());
        txtValor.setText(""+gg.getValor());
        
    }  
    
    
    private void getPanel(){
      
       pasajes.setFechaLlegada(datFechaIngreso.getDate());
       pasajes.setNombre(txtNombrep.getText());
       pasajes.setNeto(Float.parseFloat(txtNeto.getText()));
       pasajes.setValor(Float.parseFloat(txtValor.getText()));
             
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       pasajes.setHorario(otro);
      
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Pasajes)listaAnteriores.getObject(fila);     
        gh.setFechaLlegada(datFechaIngreso.getDate());
        gh.setNombre(txtNombrep.getText());
        gh.setNeto(Float.parseFloat(txtNeto.getText()));
        gh.setValor(Float.parseFloat(txtValor.getText()));
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Pasajes)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

        txtNombrep.setText("");
        txtNeto.setText("");
        txtValor.setText("");
         
    }
    
    
public void modoEdicion(boolean b){

      txtNombrep.setEditable(b);
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
           
         listaAnteriores =new Lista(new Pasajes().lista3(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVIAJES,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre2 = new javax.swing.JLabel();
        txtNombrep = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        txtNombre = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                  INGRESO DE  PASAJES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                                                    Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("                                                                    Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelNombre2, gridBagConstraints);

        txtNombrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombrepKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombrep, gridBagConstraints);

        jLabelApellido1.setText("                                                                    Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        txtNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNeto, gridBagConstraints);

        jLabelCivil1.setText("                                                                    Valor");
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
        jLabelSubtitulo6.setText("                                                                    DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                                                                    Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetoKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtValor.requestFocus();
            
        } // TODO add your handling code here:
    }//GEN-LAST:event_txtNetoKeyPressed

    private void txtNombrepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrepKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtNeto.requestFocus();
            
        } 
    }//GEN-LAST:event_txtNombrepKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(Pasajes)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrep;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
    
}
