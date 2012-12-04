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

import beans.Billetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class PanelCheques_1 extends javax.swing.JPanel {

private Lista lista;
private Lista codigo;

private Billetes billete;

private Horario horario;
private Cheque cheque;
private String mensaje="";
private boolean editar;
Cheque gh;
Lista listaAnteriores;
private Giro giro;   
public PanelCheques_1() {
        initComponents();
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
       cheque.setUtilidad(Float.parseFloat(txtUtil.getText()));
       cheque.setProtestado(false);
       
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
               cheque.setGiro(giro);
               cheque.setLgtrasmiter(true);
           
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
        gh.setUtilidad(Float.parseFloat(txtUtil.getText()));
        gh.setProtestado(false);
       
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
        
   jT100.setText("0");
   JT50.setText("0");
   jT20.setText("0"); 
   jT10.setText("0");
   jT5.setText("0");
   jT1.setText("0");
   JTmoney.setText("0"); 
       }
    
    
public void modoEdicion(boolean b){
      
        txtNombreC.setEditable(b);
        txtNumero.setEditable(b);
        txtValorCheque.setEditable(b);
        txtNeto.setEditable(b);
        txtUtilidadCheque.setEditable(b);
        txtUtil.setEditable(b);
     
        
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
        txtNombreC = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtValorCheque = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
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
        jLabel4 = new javax.swing.JLabel();
        jT100 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JT50 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jT20 = new javax.swing.JTextField();
        jT10 = new javax.swing.JTextField();
        jT5 = new javax.swing.JTextField();
        jT1 = new javax.swing.JTextField();
        JTmoney = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelCivil18 = new javax.swing.JLabel();
        txtBilletes = new javax.swing.JTextField();
        jLabelCivil20 = new javax.swing.JLabel();
        txtCheques = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                            ADELANTO DE DEPOSITO ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(txtNombreC, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNumero, gridBagConstraints);

        jLabelCivil1.setText("Valor del Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtValorCheque, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

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
        add(jScrollPane2, gridBagConstraints);

        jLabelCivil3.setText("Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtUtil, gridBagConstraints);

        jLabelCivil4.setText("Sobrantes del Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNeto, gridBagConstraints);

        jLabelCivil5.setText("Utilidad Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtUtilidadCheque, gridBagConstraints);

        jLabelApellido2.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil6.setText("Numero de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil6, gridBagConstraints);

        jButton1.setText("Agregar Billetes al Adelanto del Deposito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 19, 8, 0);
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
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 0);
        add(rb3, gridBagConstraints);

        jLabel4.setText("Billetes de 100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT100, gridBagConstraints);

        jLabel1.setText("Billetes de 50");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JT50, gridBagConstraints);

        jLabel2.setText("Billetes de 20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT20, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JTmoney, gridBagConstraints);

        jLabel6.setText("Billetes de 10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel6, gridBagConstraints);

        jLabel3.setText("Billetes de 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel3, gridBagConstraints);

        jLabel5.setText("Billetes de 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel5, gridBagConstraints);

        jLabel7.setText("Total Monedas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel7, gridBagConstraints);

        jButton2.setText("Agregar Cheques al Adelanto del Deposito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 1);
        add(jButton2, gridBagConstraints);

        jLabelCivil18.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil18.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil18.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil18, gridBagConstraints);

        txtBilletes.setEditable(false);
        txtBilletes.setFont(new java.awt.Font("Arial Black", 1, 12));
        txtBilletes.setForeground(new java.awt.Color(0, 0, 255));
        txtBilletes.setBorder(null);
        txtBilletes.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtBilletes.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 0);
        add(txtBilletes, gridBagConstraints);

        jLabelCivil20.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil20.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil20.setText("Total Billetes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jLabelCivil20, gridBagConstraints);

        txtCheques.setEditable(false);
        txtCheques.setFont(new java.awt.Font("Arial Black", 1, 12));
        txtCheques.setForeground(new java.awt.Color(0, 0, 255));
        txtCheques.setBorder(null);
        txtCheques.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCheques.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
        add(txtCheques, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int fila=tblProducto.getSelectedRow();
       gh=(Cheque)listaAnteriores.getObject(fila);
       gh.setAdelanto(true);
       
       Horario hora= new Horario();
       hora=gh.getHorario();
         
       float suma=0;
       suma=hora.getDepoT();
       suma=suma+gh.getTotal();
       hora.setDepoT(suma);
       hora.actualizar();
       
       
       
       if (rb2.isSelected()==true){
         suma=hora.getDepoT();
         suma=suma+gh.getTotal();
         hora.setDepoT(suma);
         hora.actualizar();
        }
       if (rb3.isSelected()==true){
               suma=hora.getDepoL();
               suma=suma+gh.getTotal();
               hora.setDepoL(suma);
               hora.actualizar();
           }
       
       txtCheques.setText(""+suma);
       gh.actualizar();
       Mensaje.showMensaje(this,"El cheque fue puesto para el Adelanto del Deposito");
       
       setBlanco();
       setTabla();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void getBille(){
        billete=new Billetes();    
        if (jT100.getText().equals("")){
            billete.setCien("0");
            jT100.setText("0");
        }else{
            billete.setCien(jT100.getText());
            
        }
        
        if (JT50.getText().equals("")){
        
           billete.setCincuenta("0");
           JT50.setText("0");
        }else{
            billete.setCincuenta(JT50.getText());
        }
        if (jT20.getText().equals("")){
         
           billete.setVeinte("0");
           jT20.setText("0");
        }else{
            billete.setVeinte(jT20.getText());
        }
        if (jT10.getText().equals("")){
           
            billete.setDiez("0");
           jT10.setText("0");
        }else{
             billete.setDiez(jT10.getText());
        }

         if (jT5.getText().equals("")){
           
            billete.setCinco("0");
            jT5.setText("0");
        }else{
            billete.setCinco(jT5.getText());
        }
        
        if (jT1.getText().equals("")){
        
           billete.setUno("0");
           jT1.setText("0");
        }else{
            billete.setUno(jT1.getText());
       
        }
        if (JTmoney.getText().equals("")){
         
          billete.setMonedas("0");
          JTmoney.setText("0");
        }else{
            
        billete.setMonedas(JTmoney.getText());
        }
        
        if (rb2.isSelected()==true){
         billete.setCierre1(false);
        }
       if (rb3.isSelected()==true){
         billete.setCierre1(true);
        }
        
        int u= Integer.parseInt(jT100.getText());
        int d= Integer.parseInt(JT50.getText());
        int t= Integer.parseInt(jT20.getText());
        int c= Integer.parseInt(jT10.getText());
        int q= Integer.parseInt(jT5.getText());
        int s= Integer.parseInt(jT1.getText());
        int mo=Integer.parseInt(JTmoney.getText());
        int suma=(u*100)+(d*50)+(t*20)+(c*10)+(q*5)+s+mo;
        
        billete.setTotal(String.valueOf(suma));
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        billete.setHorario(otro);
        billete.setAdelanto(true);
        
       float sum=0;
       sum=sum+Float.parseFloat(billete.getTotal());
       txtBilletes.setText(""+sum);
       
       if (billete.guardar()){ 
         Mensaje.showMensaje(this,"Guardado el Desgloce de Billetes");  
         setBlanco();
       }
  
  
    }
    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        float che=0;
        cheque = new Cheque();
        codigo = new Lista(new Cheque().lista3(otro));
        for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
          if (cheque.getLgtrasmiter()==true){
                  if (cheque.getAdelanto()==true){
                                                   che = che+ cheque.getTotal();   
                                                  }
                                               }
                                           }
                   
        txtCheques.setText(""+che);
               
        
        
         Boolean es=true;
         lista =new Lista(new Billetes().lista9(otro, es, es));
         
         if (lista.getSize()==0){
             txtBilletes.setText("0");
         }else{
             billete=(Billetes)lista.getObject(0);
             txtBilletes.setText(billete.getTotal()); 
         }
        setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        float che=0;
        
        cheque = new Cheque();
        codigo = new Lista(new Cheque().lista3(otro));
        
         for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
          if (cheque.getLgtrasmiter()==false){
                  if (cheque.getAdelanto()==true){
                                                   che = che+ cheque.getTotal();   
                                                  }
                                               }
                                           }
                   
        txtCheques.setText(""+che);
        
        Boolean es=true;
         
         lista =new Lista(new Billetes().lista9(otro, es, est));
        // Mensaje.showMensaje(this,"El tamaño es LG "+lista.getSize());
         if (lista.getSize()==0){
             txtBilletes.setText("0");
         }else{
             billete=(Billetes)lista.getObject(0);
             txtBilletes.setText(billete.getTotal()); 
         }
        
        setTabla2();
    }//GEN-LAST:event_rb2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   getBille();    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(Cheque)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JT50;
    private javax.swing.JTextField JTmoney;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil18;
    private javax.swing.JLabel jLabelCivil20;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jT1;
    private javax.swing.JTextField jT10;
    private javax.swing.JTextField jT100;
    private javax.swing.JTextField jT20;
    private javax.swing.JTextField jT5;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtBilletes;
    private javax.swing.JTextField txtCheques;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUtil;
    private javax.swing.JTextField txtUtilidadCheque;
    private javax.swing.JTextField txtValorCheque;
    // End of variables declaration//GEN-END:variables
    
}
