/*
 * PagarGiro.java
 *
 * Created on 31 de octubre de 2006, 15:35
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.Cheque;
import beans.Credito;

public class PagarGiro extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Giro giro;
private String mensaje="";
private boolean editar;
Giro gh;
Lista listaAnteriores;
private Cheque cheque;
private Credito credito;


    public PagarGiro() {
        initComponents();
        fijaMetodos();
        inicializa();
         
  }
    
private boolean isVacio(){
  if( (txtNeto.getText().equalsIgnoreCase("")) 
    | (txtTotal.getText().equalsIgnoreCase(""))
    |(txtNombre.getText().equalsIgnoreCase(""))  
    )
     return true;
  return false;
} 
    
private void inicializa(){
   agencia = new Agencia();
   lista = new Lista(new Agencia().lista());

   for(int i=0;i<lista.getSize();i++){
       Agencia b1=(Agencia) lista.getObject(i);
       cboAgencia.addItem(b1.getNombre());
   }

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
           Agencia agco=new Agencia();
           agco=(Agencia)lista.ultimo();
           
           giro=new Giro();
           getPanel();
           if(giro.guardar()){
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
                               Mensaje.showMensaje(this,"GIRO PAGADO");
                               modoEdicion(false);
            
            setTabla();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR EL GIRO","Eliminar");
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
            giro=(Giro)lista.getMyself();
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
        giro=(Giro)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        giro=(Giro)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        giro=(Giro)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        giro=(Giro)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
   
   txtCodigo.setText(""+agencia.getCodigo());
   txtNeto.setText(""+giro.getNeto());
   txtTotal.setText(""+giro.getTotal());
   txtNombre1.setText(""+giro.getNombre());
   txtReferencia.setText(""+giro.getReferencia());
   cboAgencia.setSelectedItem(agencia.getNombre().toString());

}  
 private void setPanel(Giro gg){
   
   txtCodigo.setText(""+gg.getClave());
   txtNeto.setText(""+String.valueOf(gg.getNeto()));
   txtTotal.setText(""+String.valueOf(gg.getTotal()));
   txtNombre1.setText(""+gg.getNombre());
   txtReferencia.setText(""+gg.getReferencia());
   cboAgencia.setSelectedItem(gg.getAgencia().getNombre());   
 }  
    
    private void getPanel(){
    
        giro.setNeto(Float.parseFloat(txtNeto.getText()));
        giro.setTotal(Float.parseFloat(txtTotal.getText()));
        giro.setClave(txtCodigo.getText());
        giro.setFechaLlegada(datFechaIngreso.getDate());
        giro.setEstado(false);
        giro.setAnulado(false);
        giro.setRem(false);
        giro.setPagado(true);
        giro.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
        giro.setNombre(txtNombre1.getText());
        giro.setReferencia(txtReferencia.getText());
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        giro.setHorario(otro);
  
  
    }
    
    
private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);     
        gh.setNeto(Float.parseFloat(txtNeto.getText()));
        gh.setTotal(Float.parseFloat(txtTotal.getText()));
        gh.setNombre(txtNombre1.getText());
        gh.setClave(txtCodigo.getText());
        gh.setClave(txtCodigo.getText());
        gh.setReferencia(txtReferencia.getText());
        gh.actualizar();      
}
    
private void borra(){
  int fila=tblProducto.getSelectedRow();
  gh=(Giro)listaAnteriores.getObject(fila);     
  gh.borrar();   
  
}
    
    
private void setBlanco(){

   txtNombre1.setText("");
   txtNeto.setText("");
   txtReferencia.setText(""); 
   txtTotal.setText("");
   txtNombre1.setText("");
  
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
   
        txtNombre1.setEditable(b);
        txtNeto.setEditable(b);
        txtReferencia.setEditable(b);
        txtTotal.setEditable(b);
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
                new AnularGiro().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelCedula2 = new javax.swing.JLabel();
        cboAgencia = new javax.swing.JComboBox();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabelCivil4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        txtNombre = new javax.swing.JTextField();
        jLabelNombreGrup1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                                     PAGAR   GIROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                                        DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        lblFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso.setText("                                                                  Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        datFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelCedula2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCedula2.setText("                                                                  Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula2, gridBagConstraints);

        cboAgencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(cboAgencia, gridBagConstraints);

        jLabelNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre1.setText("                                                                  Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCodigo, gridBagConstraints);

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("                                                                  Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNombre1, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil2.setText("                                                                  Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtNeto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNeto, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil5.setText("                                                                  Referencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil5, gridBagConstraints);

        txtReferencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReferenciaKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtReferencia, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil4.setText("                                                                  Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
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
        tblProducto.setColumnControlVisible(true);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(tblProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombre, gridBagConstraints);

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombreGrup1.setText("                                                                  Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtReferenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferenciaKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
            
        }  
    }//GEN-LAST:event_txtReferenciaKeyPressed

    private void txtNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetoKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtReferencia.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNetoKeyPressed

    private void txtNombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtNeto.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNombre1KeyPressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtNombre1.requestFocus();
            
        }  
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh);
     
    }//GEN-LAST:event_tblProductoMouseClicked

    private void cboAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaActionPerformed
   setTabla();
    }//GEN-LAST:event_cboAgenciaActionPerformed
private void setTabla(){
         
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(true);
         hora=horario.buscar(est);
         codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));      
        
         codigos = new CodigoAgencia();
         codigos=(CodigoAgencia) codigo.ultimo();  
         
         listaAnteriores =new Lista(new Giro().lista6(est));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAPAGOGIROS,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgencia;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
