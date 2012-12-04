/*
 * PanelCheques.java
 *
 * Created on 7 de noviembre de 2006, 0:07
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Giro;
import beans.Cheque;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelCheques extends javax.swing.JPanel {

private Lista lista;
private Lista codigo;
private Horario horario;
private Cheque cheque;
private String mensaje="";
private boolean editar;
Cheque gh;
Lista listaAnteriores;
private Giro giro;   
public PanelCheques() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
    }
    
     private boolean isVacio(){
  if(txtValorCheque.getText().equalsIgnoreCase("")  )  
   
     return true;
  return false;
        } 
   
 private void inicializa(){
                                     
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                   cheque = new Cheque();
                   codigo = new Lista(new Cheque().lista3(otro));
                   cheque=(Cheque) codigo.ultimo();
                 
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
                             cheque=new Cheque();
                             getPanel();
                             if(cheque.guardar()){
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
            cheque=(Cheque)lista.getMyself();
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
   
        cheque = new Cheque();
        codigo = new Lista(new Cheque().lista3(otro));
        cheque=(Cheque) codigo.ultimo();
                   
       
                          }
    
    private void anterior(){
        cheque=(Cheque)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        cheque=(Cheque)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        cheque=(Cheque)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        cheque=(Cheque)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        txtNombreC.setText(""+cheque.getNombre());
        txtNumero.setText(""+cheque.getNumero());
        txtValorCheque.setText(""+cheque.getTotal());
        txtNeto.setText(""+cheque.getNeto());
        txtUtilidadCheque.setText(""+cheque.getUtilidadche());
        txtUtil.setText(""+cheque.getUtilidad());
} 
private void setPanel(Cheque gg){
    
        txtNombreC.setText(""+gg.getNombre());
        txtNumero.setText(""+gg.getNumero());
        txtValorCheque.setText(""+gg.getTotal());
        txtNeto.setText(""+gg.getNeto());
        txtUtilidadCheque.setText(""+gg.getUtilidadche());
        txtUtil.setText(""+gg.getUtilidad());
    }  
    
    
    private void getPanel(){
       
       cheque.setFecha(datFechaIngreso.getDate());
       cheque.setNombre(txtNombreC.getText());
       cheque.setNumero(txtNumero.getText());
       cheque.setTotal(Float.parseFloat(txtValorCheque.getText()));
       cheque.setNeto(Float.parseFloat(txtNeto.getText()));
       cheque.setUtilidadche(Float.parseFloat(txtUtilidadCheque.getText()));
      
       float beto=((Float.parseFloat(txtValorCheque.getText()))-(Float.parseFloat(txtNeto.getText())));
       double si1 = ((double)Math.round(beto*100))/100; 
       txtUtil.setText(""+si1);
       cheque.setUtilidad(Float.parseFloat(txtUtil.getText()));
       
       cheque.setProtestado(false);
       cheque.setAdelanto(false);
       
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       cheque.setHorario(otro);
       
       if (rb2.isSelected()==true){
         cheque.setLgtrasmiter(false);
        }
       if (rb3.isSelected()==true){
               Giro giro = new Giro();
               if (txtNGiro.getText().equals("")){
               Mensaje.showMensaje(this,"Usted no ha ingresado ningun codigo");
               cheque.setLgtrasmiter(true);
               }else{
                     String dos=txtNGiro.getText();
                     dos = dos+"."+"0";
                     giro = giro.Busca(dos);
                     if (giro==null){
                                 Mensaje.showMensaje(this,"No hay ningun giro con ese codigo");
                                 cheque.setClave(txtNGiro.getText());
                                    }else{
                                          txtAgencia.setText(""+giro.getAgencia().getNombre());   
                                          cheque.setGiro(giro);
                                          cheque.setClave(txtNGiro.getText());
                                          cheque.setLgtrasmiter(true);
                                          }
                     } 
           
         }
       
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Cheque)listaAnteriores.getObject(fila);     
        gh.setFecha(datFechaIngreso.getDate());
        gh.setNombre(txtNombreC.getText());
        gh.setNumero(txtNumero.getText());
        gh.setTotal(Float.parseFloat(txtValorCheque.getText()));
        gh.setNeto(Float.parseFloat(txtNeto.getText()));
        gh.setUtilidadche(Float.parseFloat(txtUtilidadCheque.getText()));
        //
        
        
       float beto=((Float.parseFloat(txtValorCheque.getText()))-(Float.parseFloat(txtNeto.getText())));
       double si1 = ((double)Math.round(beto*100))/100; 
       txtUtil.setText(""+si1);
       gh.setUtilidad(Float.parseFloat(txtUtil.getText()));
       
        gh.setProtestado(false);
        gh.setAdelanto(false);
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Cheque)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

        
        txtNombreC.setText("");
        txtNumero.setText("");
        txtValorCheque.setText("");
        txtNeto.setText("");
        txtUtilidadCheque.setText("");
        txtUtil.setText("");
        txtNGiro.setText("");
        txtAgencia.setText("");
    }
    
    
public void modoEdicion(boolean b){
      
        txtNombreC.setEditable(b);
        txtNumero.setEditable(b);
        txtValorCheque.setEditable(b);
        txtNeto.setEditable(b);
        txtUtilidadCheque.setEditable(b);
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
         Boolean a=true;
         
         listaAnteriores =new Lista(new Cheque().lista8(hora, a));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACHEQUE,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
private void setTabla2(){
         
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         Boolean a=false;
    
         listaAnteriores =new Lista(new Cheque().lista8(hora, a));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACHEQUE,true);
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
        jLabelCivil2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtValorCheque = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelCivil3 = new javax.swing.JLabel();
        txtUtil = new javax.swing.JTextField();
        jLabelCivil4 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtUtilidadCheque = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        jLabelCivil6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        txtNGiro = new javax.swing.JTextField();
        txtAgencia = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                            PAGO DE GIROS CON CHEQUES ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                          Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(datFechaIngreso, gridBagConstraints);

        jLabelApellido1.setText("         # de Giro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelApellido1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setText("          Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNumero, gridBagConstraints);

        jLabelCivil1.setText("                                          Valor del Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtValorCheque, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 223;
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
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelCivil3.setText("                                          Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        add(jLabelCivil3, gridBagConstraints);

        txtUtil.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtUtil, gridBagConstraints);

        jLabelCivil4.setText("                                          Sobrantes del Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        add(jLabelCivil4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        add(txtNeto, gridBagConstraints);

        jLabelCivil5.setText("                                          Utilidad Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 149;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtUtilidadCheque, gridBagConstraints);

        jLabelApellido2.setText("                                          Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil6.setText("                                          Numero de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil6, gridBagConstraints);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jButton1, gridBagConstraints);

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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(rb3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNGiro, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtAgencia, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       txtAgencia.setEditable(false);
        txtNGiro.setEditable(true);
        setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
       txtAgencia.setEditable(false);        
        txtNGiro.setEditable(false);
        setTabla2();
    }//GEN-LAST:event_rb2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     Giro giro = new Giro();
     if (txtNGiro.getText().equals("")){
         Mensaje.showMensaje(this,"Usted no ha ingresado ningun codigo");
        }else{
            //    float nu= Float.parseFloat(txtNGiro.getText());
              //  String dos=String.valueOf(nu);
                String dos=txtNGiro.getText();
                dos = dos+"."+"0";       
                giro = giro.Busca(dos);
                if (giro==null){
                Mensaje.showMensaje(this,"No hay ningun giro con ese codigo");
                }else{
                txtAgencia.setText(""+giro.getAgencia().getNombre());                
                }
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(Cheque)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtNGiro;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUtil;
    private javax.swing.JTextField txtUtilidadCheque;
    private javax.swing.JTextField txtValorCheque;
    // End of variables declaration//GEN-END:variables
    
}
