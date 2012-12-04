/*
 * PanelCabinas.java
 *
 * Created on 8 de noviembre de 2006, 23:49
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.VideoConferencia;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelVideo extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private VideoConferencia video;
private String mensaje="";
private boolean editar;
VideoConferencia gh;
Lista listaAnteriores;

public PanelVideo() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
}
    
private boolean isVacio(){
  if(txtNumer.getText().equalsIgnoreCase("") | txtNombreVC.getText().equalsIgnoreCase("") | txtReferencia.getText().equalsIgnoreCase("") 
     |tiempo.getText().equalsIgnoreCase("") |txtTotal.getText().equalsIgnoreCase(""))  
     return true;
  return false;
        } 
   
 private void inicializa(){
                  
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                  
                   
                   video = new VideoConferencia();
                   codigo = new Lista(new VideoConferencia().lista2());
                   video=(VideoConferencia) codigo.ultimo();
                   
                   if(video==null){
                   txtNumer.setText("1"); 
                   }else{
                   int a= video.getNumero();
                   int fact = a+1;
                   txtNumer.setText(""+fact); 
                   }
                   
                   
                   
                   
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
                             video=new VideoConferencia();
                             getPanel();
                             if(video.guardar()){
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
            Mensaje.showMensaje(this, "LA VIDEO CONFERENCIA SE HA GUARDADO CON EXITO");
                    
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
            video=(VideoConferencia)lista.getMyself();
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
        
        video = new VideoConferencia();
                   codigo = new Lista(new VideoConferencia().lista2());
                   video=(VideoConferencia) codigo.ultimo();
                   
                   if(video==null){
                   txtNumer.setText("1"); 
                   }else{
                   int a= video.getNumero();
                   int fact = a+1;
                   txtNumer.setText(""+fact); 
                   }
    }  
    private void anterior(){
        video=(VideoConferencia)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       video=(VideoConferencia)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        video=(VideoConferencia)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        video=(VideoConferencia)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        
    
} 
private void setPanel(VideoConferencia gg){
    
        txtNumer.setText(""+gg.getNumero());
        txtNombreVC.setText(""+gg.getNombre());
        txtReferencia.setText(""+gg.getReferencia());
        tiempo.setText(""+gg.getTiempo());
        txtTotal.setText(""+gg.getTotal());
        
    }  
    
    
    private void getPanel(){
        
        video.setFechaLlegada(datFechaIngreso.getDate());
        video.setNombre(txtNombreVC.getText());
        video.setReferencia(txtReferencia.getText());
        video.setTiempo(Float.parseFloat(tiempo.getText()));
        video.setTotal(Float.parseFloat(txtTotal.getText()));
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        video.setHorario(otro);
        
        int fact=0;
        
        codigo = new Lista(new VideoConferencia().lista2());
        if (codigo.getSize()==0){
               fact=1;
        }else{
        gh=(VideoConferencia) codigo.ultimo();
        int a= gh.getNumero();
        fact = a+1;
        }
   
       video.setNumero(fact);
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(VideoConferencia)listaAnteriores.getObject(fila);   
        
        gh.setFechaLlegada(datFechaIngreso.getDate());
        gh.setNombre(txtNombreVC.getText());
        gh.setReferencia(txtReferencia.getText());
        gh.setTiempo(Float.parseFloat(tiempo.getText()));
        gh.setTotal(Float.parseFloat(txtTotal.getText()));
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(VideoConferencia)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

        txtNumer.setText("");
        txtNombreVC.setText("");
        txtReferencia.setText("");
        tiempo.setText("");
        txtTotal.setText("");
    }
    
    
public void modoEdicion(boolean b){

        txtNumer.setEditable(b);
        txtNombreVC.setEditable(b);
        txtReferencia.setEditable(b);
        tiempo.setEditable(b);
        txtTotal.setEditable(b);
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
           
         listaAnteriores =new Lista(new VideoConferencia().lista3(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVIDEO,true);
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
        txtNumer = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombreVC = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                                 CONTROL DE VIDEO CONFERENCIA ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                                                                          Fecha de Ingreso");
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

        jLabelNombre2.setText("                                                                                          Numero de VC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelNombre2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNumer, gridBagConstraints);

        jLabelApellido1.setText("                                                                                          Referencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReferenciaKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtReferencia, gridBagConstraints);

        jLabelCivil1.setText("                                                                                          Tiempo (Solo n\u00fameros)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil1, gridBagConstraints);

        tiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tiempoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(tiempo, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                                          DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                                                                                          Nombre ");
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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelNombre3.setText("                                                                                          Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelNombre3, gridBagConstraints);

        txtNombreVC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreVCKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombreVC, gridBagConstraints);

        jLabelCivil2.setText("                                                                                          Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void tiempoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tiempoKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
            
        } 
    }//GEN-LAST:event_tiempoKeyPressed

    private void txtReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferenciaKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        tiempo.requestFocus();
            
        } 
    }//GEN-LAST:event_txtReferenciaKeyPressed

    private void txtNombreVCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreVCKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtReferencia.requestFocus();
            
        } 
    }//GEN-LAST:event_txtNombreVCKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(VideoConferencia)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField tiempo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreVC;
    private javax.swing.JTextField txtNumer;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
