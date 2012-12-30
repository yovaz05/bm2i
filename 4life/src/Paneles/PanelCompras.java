/*
 * PanelCompras.java
 *
 * Created on 7 de noviembre de 2006, 15:03
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.ComprasOficina;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelCompras extends javax.swing.JPanel {
    
    private Lista lista;
    private Lista codigo;
    private Horario horario;
    private ComprasOficina compras;
    private String mensaje="";
    private boolean editar;
    ComprasOficina gh;
    Lista listaAnteriores;
    
    public PanelCompras() {
         
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
  if(txtDescripcion.getText().equalsIgnoreCase("")  )  
   
     return true;
  return false;
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
        if (isVacio())
                      return false;
      
        if(isEditar()){
                       getPanel2();
                       }else{            
                             compras=new ComprasOficina();
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
            compras=(ComprasOficina)lista.getMyself();
            setPanel();
        }
    }
    
    private void editar(){
        setEditar(true);
        Mensaje.showMensaje(this, "Verifique a que agencia pertenece antes de Editar");
        modoEdicion(true);
        
    }
    
    private void nuevo(){
        setBlanco();
        modoEdicion(true);
        setEditar(false);
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());

//        compras = new ComprasOficina();
//        codigo = new Lista(new ComprasOficina().lista3(otro));
//        compras=(ComprasOficina) codigo.ultimo();
                 
              }
    
    private void anterior(){
        compras=(ComprasOficina)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        compras=(ComprasOficina)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        compras=(ComprasOficina)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        compras=(ComprasOficina)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        txtDescripcion.setText(""+compras.getDescripcion());
        txtValor.setText(""+compras.getValor());
       
        
} 
private void setPanel(ComprasOficina gg){
    
        txtDescripcion.setText(""+gg.getDescripcion());
        txtValor.setText(""+gg.getValor());
    
}  
private void getPanel(){
       
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       
       compras.setDescripcion(txtDescripcion.getText());
       compras.setFecha(datFechaIngreso.getDate());
       compras.setValor(Float.parseFloat(txtValor.getText()));
       compras.setHorario(otro);
       
       
    }
    
   
private void getPanel2(){
        
        int fila=tblProducto.getSelectedRow();
        gh=(ComprasOficina)listaAnteriores.getObject(fila);     
        gh.setDescripcion(txtDescripcion.getText());
        gh.setFecha(datFechaIngreso.getDate());
        gh.setValor(Float.parseFloat(txtValor.getText()));
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        compras.setHorario(otro);
        gh.setHorario(otro);
        
         
        gh.actualizar();      
  
    }
    
    
private void borra(){
        
        int fila=tblProducto.getSelectedRow();
        gh=(ComprasOficina)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
        
   }
    
    
private void setBlanco(){

        txtDescripcion.setText("");
        txtValor.setText("");
          
    }
    
    
public void modoEdicion(boolean b){
      
      txtDescripcion.setEditable(b);
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
         
            
        listaAnteriores =new Lista(new ComprasOficina().lista3(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACOMPRAS,true);
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
        jLabelApellido1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblFechaIngreso1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                         COMPRAS DE OFICINA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 10, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setBackground(new java.awt.Color(0, 0, 0));
        lblFechaIngreso.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelApellido1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelApellido1.setText("Descripcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtDescripcion, gridBagConstraints);

        lblFechaIngreso1.setBackground(new java.awt.Color(0, 0, 0));
        lblFechaIngreso1.setText("Valor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtValor, gridBagConstraints);

        jLabelSubtitulo6.setBackground(new java.awt.Color(0, 0, 0));
        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DEL RESPONSABLE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(ComprasOficina)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
    
}
