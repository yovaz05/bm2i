/*
 * PanelCxP.java
 *
 * Created on 7 de noviembre de 2006, 1:34
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.CuentasXPagar;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelCxP extends javax.swing.JPanel {

    private Lista lista;
    private Lista codigo;
    private Horario horario;
    private CuentasXPagar cuentas;
    private String mensaje="";
    private boolean editar;
    CuentasXPagar gh;
    Lista listaAnteriores;
    
public PanelCxP() {
          initComponents();
          fijaMetodos();
          inicializa();
          setTabla2();
    }
    
   private boolean isVacio(){
  if(txtTotal.getText().equalsIgnoreCase("")  )  
   
     return true;
  return false;
        } 
   
 private void inicializa(){
                  int cod=0;
                                   
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
                   
                   boolean pagos =false;
                   cuentas = new CuentasXPagar();
                   codigo = new Lista(new CuentasXPagar().lista3(otro, pagos));
                   cuentas=(CuentasXPagar) codigo.ultimo();
                  if (cuentas==null){
                  cod=0;
                  }else{
                          cod =cuentas.getId_XPagar()+1;
                         
                        }  
               txtOrden.setText(""+cod);
               modoEdicion(false);
               setTabla2();    
                   
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
                             cuentas=new CuentasXPagar();
                             getPanel();
                             if(cuentas.guardar()){
                                 if (rb2.isSelected()==true){
                      setTabla();
                     }
            if (rb3.isSelected()==true){
                     setTabla2();
                   }
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
            Mensaje.showMensaje(this,"Credito Aprobado");
            modoEdicion(false);
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR","Eliminar");
        if (b){
            borra();
            setTabla();
            
           if (rb2.isSelected()==true){
                      setTabla();
                     }
            if (rb3.isSelected()==true){
                     setTabla2();
                   }
            setBlanco();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            cuentas=(CuentasXPagar)lista.getMyself();
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
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
         boolean pagos =false;
         
        cuentas = new CuentasXPagar();
        codigo = new Lista(new CuentasXPagar().lista3(otro, pagos));
        cuentas=(CuentasXPagar) codigo.ultimo();
                   
              }
    
    private void anterior(){
        cuentas=(CuentasXPagar)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        cuentas=(CuentasXPagar)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        cuentas=(CuentasXPagar)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        cuentas=(CuentasXPagar)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
        txtNombreC.setText(""+cuentas.getNombre());
        txtEnvio.setText(""+cuentas.getEnvio());
        txtTotal.setText(""+cuentas.getTotal());
        txtOrden.setText(""+cuentas.getId_XPagar()); 
} 
private void setPanel(CuentasXPagar gg){
        txtNombreC.setText(""+gg.getNombre());
        txtEnvio.setText(""+gg.getEnvio());
        txtTotal.setText(""+gg.getTotal());
        txtOrden.setText(""+gg.getId_XPagar());
        //datFechaIngreso1(gg.getFecha().getDate);
    }  
    
    
    private void getPanel(){
       float a =0;
       cuentas.setNombre(txtNombreC.getText());
       cuentas.setEnvio(txtEnvio.getText());
       cuentas.setTotal(Float.parseFloat(txtTotal.getText()));
       cuentas.setFechaLlegada(datFechaIngreso.getDate());
      // cuentas.setOrdenar(txtOrden.getText());
       cuentas.setApagado(a);
       cuentas.setPagado(false);
       //cuentas.setGiros(false);
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       cuentas.setHorario(otro);
       
       if (rb2.isSelected()==true){
           cuentas.setMt(false);
           cuentas.setGiros(false);
           }
       if (rb3.isSelected()==true){
         cuentas.setMt(true);
         cuentas.setGiros(true);
                 }
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(CuentasXPagar)listaAnteriores.getObject(fila);     
        gh.setNombre(txtNombreC.getText());
        gh.setEnvio(txtEnvio.getText());
        gh.setTotal(Float.parseFloat(txtTotal.getText()));
        gh.setFechaLlegada(datFechaIngreso.getDate());
        //gh.setOrdenar(txtOrden.getText());
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(CuentasXPagar)listaAnteriores.getObject(fila);     
        gh.borrar();   
           if (rb2.isSelected()==true){
                      setTabla();
                     }
            if (rb3.isSelected()==true){
                     setTabla2();
                   }
   }
    
    
 private void setBlanco(){

        txtNombreC.setText("");
        txtEnvio.setText("");
        txtTotal.setText("");
          
    }
    
    
public void modoEdicion(boolean b){
      
      txtNombreC.setEditable(b);
      txtEnvio.setEditable(b);
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
         boolean pagos =false;
         listaAnteriores =new Lista(new CuentasXPagar().lista9(hora, pagos));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     }
     
      private void setTabla2(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         boolean pagos =true;
         listaAnteriores =new Lista(new CuentasXPagar().lista9(hora, pagos));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
      }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelApellido1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLabelCivil2 = new javax.swing.JLabel();
        txtEnvio = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        txtOrden = new javax.swing.JTextField();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                         CUENTAS POR PAGAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                                                          Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        datFechaIngreso.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelApellido1.setText("                                                                          Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombreC, gridBagConstraints);

        lblFechaIngreso1.setText("                                                                          # de Credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabelCivil2.setText("                                                                          Concepto de");
        jLabelCivil2.setToolTipText("Este campo es obligatorio y mediante este codigo se puede pagar los creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtEnvio.setToolTipText("Este campo es obligatorio y mediante este codigo se puede pagar los creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtEnvio, gridBagConstraints);

        jLabelCivil1.setText("                                                                          Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                          DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

        jLabelNombreGrup1.setText("                                                                          Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

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
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        txtOrden.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtOrden, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                                                                               DAR CREDITOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        rb2.setForeground(new java.awt.Color(0, 51, 255));
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 15, 0);
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 15, 0);
        add(rb3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed

        setTabla2();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed

        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(CuentasXPagar)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtEnvio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtOrden;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
