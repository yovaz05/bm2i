/*
 * COMFLORES.java
 *
 * Created on 3 de noviembre de 2006, 17:27
 */

package clases;

import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.Cierre;
import beans.Otros;
import beans.Factura;
import beans.VentaProductos;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.ComprasOficina;
import javax.swing.JLayeredPane;
import reportesXML.ReportePrevio;


public class COMFLORES extends javax.swing.JInternalFrame {
    
  
    private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private Horario horario;
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    private Otros otros;
    private Otros ultim;
    private Otros suma;
    private VentaProductos venta;
    private ComprasOficina pras;
    private ComprasOficina pras1;
    public int v=0;
    
    
    
    public COMFLORES() {
        
        horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        if (hora==null){
            Mensaje.showMensaje(this,"DEBE INICIAR CESION  CIERRE Y ABRA EL PROGRAMA NUEVAMENTE");
        }else{
          
        initComponents();
        generarcierre();
        setTabla3();
       txtAperCaja.setText("0"); 
        }
        
            
    }
    private void generarcierre(){
     // compras();
       cie();
       //cie1();
    //  sumas();
}
    
    public void  cie(){
    
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
         float efec =0;
         float dep =0;
         float uti=0;
         float total=0;
         int pun=0;
         float egre=0;
         
                
         Lista listaAnteriores =new Lista(new Factura().lista2(hora));
         
         if (listaAnteriores.getSize()==0){
             Mensaje.showMensaje(this,"NO hay ventas ");
         }else{
             for(int j=0;j<listaAnteriores.getSize();j++){
                 Factura factura =(Factura)listaAnteriores.getObject(j);
                 
                 total= total+factura.getVtotal();
                 uti=uti+factura.getUtilidad();
                 pun=pun+factura.getVpuntos();
                 if (factura.getTpago().equals("Efectivo")){
                     efec=efec+factura.getVtotal();
                 }else{
                 dep=dep+factura.getVtotal();
             }
                 
             }
         }
  Lista lista =new Lista(new ComprasOficina().lista3(hora));

             if (lista.getSize()==0){
             Mensaje.showMensaje(this,"NO hay egresos");
         }else{
             for(int j=0;j<lista.getSize();j++){
                 ComprasOficina egreso =(ComprasOficina)lista.getObject(j);
                 
                 egre= egre+egreso.getValor();
     
                 
             }
         }
  
  
  
  
  
         txtIngreso.setText(""+total);
         txtUtilidad.setText(""+uti);
         txtPuntos.setText(""+pun);
         txtEfectivo.setText(""+efec);
         txtDeposito.setText(""+dep);
         txtEgreso.setText(""+egre);
         
         datFechadesde.setDate(hora.getFechaInicio());
         
/*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             calcula  horas trabajadas                        */ 
     
    int horallegada=0;
    int minutollegada=0;
    int segundo=0;
    Date fin= new Date();
    fin=datFechahasta.getDate();
    
    horallegada= fin.getHours()-hora.getFechaInicio().getHours();
    
    if (hora.getFechaInicio().getMinutes()<fin.getMinutes()){
                    minutollegada=(fin.getMinutes()-hora.getFechaInicio().getMinutes());
    }else{
                    horallegada=horallegada-1;
                    minutollegada=(60-hora.getFechaInicio().getMinutes()+fin.getMinutes());
    }
    if (hora.getFechaInicio().getSeconds()<fin.getSeconds()){
                    segundo=(fin.getSeconds()-hora.getFechaInicio().getSeconds());
    }else{
                    minutollegada=minutollegada-1;
                    segundo=(60-hora.getFechaInicio().getSeconds()+fin.getSeconds());
    }
    if (horallegada<0){
                        hora.setHoras(0);
                        hora.setMinutos(minutollegada);
                        hora.setSegundos(segundo);
                        txtHorast.setText(""+0+" H :"+minutollegada+"  Min  :"+ segundo+"  Seg  " );
                      }else{
                        hora.setHoras(horallegada);
                        hora.setMinutos(minutollegada);
                        hora.setSegundos(segundo);
                        txtHorast.setText(""+horallegada+" H  :"+minutollegada+"  Min  :"+ segundo+"  Seg  " );
                      }
    
    }




     private void setTabla(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
                
         Lista listaAnteriores =new Lista(new Factura().lista2(hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFACTURA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         jXTable2.setModel(modelo);
     
     }
    
 private void setTabla2(){
            horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         
            
        listaAnteriores =new Lista(new ComprasOficina().lista3(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACOMPRAS,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         jXTable2.setModel(modelo);
     
     }
 private void setTabla3(){
      //activado=true;
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
                
         Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPADESGLOCE,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         jXTable2.setModel(modelo);
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabelCivil3 = new javax.swing.JLabel();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelCivil5 = new javax.swing.JLabel();
        txtIngreso = new javax.swing.JTextField();
        txtPuntos = new javax.swing.JTextField();
        jLabelApellido3 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JTextField();
        txtEgreso = new javax.swing.JTextField();
        txtDeposito = new javax.swing.JTextField();
        jLabelCreditopendiente4 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jLabelCivil9 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabelCivil10 = new javax.swing.JLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        jLabelNombre3 = new javax.swing.JLabel();
        jLabelCivil6 = new javax.swing.JLabel();
        txtInversion = new javax.swing.JTextField();
        jLabelApellido4 = new javax.swing.JLabel();
        txtHorast = new javax.swing.JTextField();
        txtAperCaja = new javax.swing.JTextField();
        txtTotalCaja = new javax.swing.JTextField();
        jLabelCreditopendiente5 = new javax.swing.JLabel();
        datFechahasta = new org.jdesktop.swingx.JXDatePicker();
        jLabelCivil11 = new javax.swing.JLabel();
        txtUreal = new javax.swing.JTextField();
        jLabelCivil12 = new javax.swing.JLabel();
        datFechadesde = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre4 = new javax.swing.JLabel();
        jBCalcular = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cierre Diario de Caja");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/kcontrol.png"))); // NOI18N
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 87, 0, 0);
        jPanel2.add(jLabelCreditopendiente2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 4, 0, 0);
        jPanel2.add(txtNombre, gridBagConstraints);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jXTable2.setAutoscrolls(false);
        jXTable2.setColumnControlVisible(true);
        jScrollPane2.setViewportView(jXTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1163;
        gridBagConstraints.ipady = 352;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 3.3;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 13, 360, 76);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        jXPanel2.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jXPanel2.setName("Panel de Miercoles"); // NOI18N
        jXPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("                            CIERRE DE TURNO     4 LIFE - 2013           ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 26);
        jXPanel2.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.textHighlight);
        jLabel13.setText("                           En este panel se graba las transacciones del día .");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 7, 0);
        jXPanel2.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 124, 0, 0);
        jPanel2.add(jXPanel2, gridBagConstraints);

        jXPanel1.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel1.setDoubleBuffered(false);
        jXPanel1.setFocusCycleRoot(true);
        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jButton2.setText("Desgloce de Egresos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jXPanel1.add(jButton2, gridBagConstraints);

        jButton3.setText("Cerrar Caja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 25, 0);
        jXPanel1.add(jButton3, gridBagConstraints);

        jButton4.setText("Desgloce de Productos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jXPanel1.add(jButton4, gridBagConstraints);

        jButton1.setText("Desgloce de Facturas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 3, 0);
        jXPanel1.add(jButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 37, 0, 0);
        jPanel2.add(jXPanel1, gridBagConstraints);

        jXPanel3.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel3.setDoubleBuffered(false);
        jXPanel3.setFocusCycleRoot(true);
        jXPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 0, 153));
        jLabel17.setText("  ____________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 6, 25);
        jXPanel3.add(jLabel17, gridBagConstraints);

        jLabelCivil3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil3.setText("Utilidad de productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelCivil3, gridBagConstraints);

        jLabelNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre2.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelNombre2, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil5.setText("Pago en Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 30, 0, 0);
        jXPanel3.add(jLabelCivil5, gridBagConstraints);

        txtIngreso.setEditable(false);
        txtIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtIngreso.setBorder(null);
        txtIngreso.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 33, 4, 0);
        jXPanel3.add(txtIngreso, gridBagConstraints);

        txtPuntos.setEditable(false);
        txtPuntos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtPuntos.setBorder(null);
        txtPuntos.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel3.add(txtPuntos, gridBagConstraints);

        jLabelApellido3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido3.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jXPanel3.add(jLabelApellido3, gridBagConstraints);

        txtUtilidad.setEditable(false);
        txtUtilidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtUtilidad.setBorder(null);
        txtUtilidad.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel3.add(txtUtilidad, gridBagConstraints);

        txtEgreso.setEditable(false);
        txtEgreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtEgreso.setBorder(null);
        txtEgreso.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel3.add(txtEgreso, gridBagConstraints);

        txtDeposito.setEditable(false);
        txtDeposito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtDeposito.setBorder(null);
        txtDeposito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel3.add(txtDeposito, gridBagConstraints);

        jLabelCreditopendiente4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente4.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente4.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(2, 35, 2, 0);
        jXPanel3.add(jLabelCreditopendiente4, gridBagConstraints);

        datFechaIngreso1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel3.add(datFechaIngreso1, gridBagConstraints);

        jLabelCivil9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil9.setText("Pago en Deposito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelCivil9, gridBagConstraints);

        txtEfectivo.setEditable(false);
        txtEfectivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtEfectivo.setBorder(null);
        txtEfectivo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(26, 34, 4, 0);
        jXPanel3.add(txtEfectivo, gridBagConstraints);

        jLabelCivil10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil10.setText("Total Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelCivil10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 18, 0, 0);
        jPanel2.add(jXPanel3, gridBagConstraints);

        jXPanel4.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel4.setDoubleBuffered(false);
        jXPanel4.setFocusCycleRoot(true);
        jXPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 0, 153));
        jLabel18.setText("  _________________________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 6, 21);
        jXPanel4.add(jLabel18, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil4.setText("Horas Trabajadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel4.add(jLabelCivil4, gridBagConstraints);

        jLabelNombre3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre3.setText("Fecha Desde");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel4.add(jLabelNombre3, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil6.setText("Utilidad Real");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 30, 0, 0);
        jXPanel4.add(jLabelCivil6, gridBagConstraints);

        txtInversion.setEditable(false);
        txtInversion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtInversion.setBorder(null);
        txtInversion.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel4.add(txtInversion, gridBagConstraints);

        jLabelApellido4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido4.setText("Apertura de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jXPanel4.add(jLabelApellido4, gridBagConstraints);

        txtHorast.setEditable(false);
        txtHorast.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtHorast.setBorder(null);
        txtHorast.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel4.add(txtHorast, gridBagConstraints);

        txtAperCaja.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtAperCaja.setBorder(null);
        txtAperCaja.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel4.add(txtAperCaja, gridBagConstraints);

        txtTotalCaja.setEditable(false);
        txtTotalCaja.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtTotalCaja.setBorder(null);
        txtTotalCaja.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel4.add(txtTotalCaja, gridBagConstraints);

        jLabelCreditopendiente5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente5.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente5.setText("DATOS DEL FIN DE TURNO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 1;
        jXPanel4.add(jLabelCreditopendiente5, gridBagConstraints);

        datFechahasta.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel4.add(datFechahasta, gridBagConstraints);

        jLabelCivil11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil11.setText("Total en Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel4.add(jLabelCivil11, gridBagConstraints);

        txtUreal.setEditable(false);
        txtUreal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtUreal.setBorder(null);
        txtUreal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(26, 34, 4, 0);
        jXPanel4.add(txtUreal, gridBagConstraints);

        jLabelCivil12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil12.setText("Total Inversion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel4.add(jLabelCivil12, gridBagConstraints);

        datFechadesde.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel4.add(datFechadesde, gridBagConstraints);

        jLabelNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre4.setText("Fecha Hasta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel4.add(jLabelNombre4, gridBagConstraints);

        jBCalcular.setText("Calcular Caja");
        jBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jXPanel4.add(jBCalcular, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        jPanel2.add(jXPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 349;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        setTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setTabla3();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        hora.setFechaFin(new Date());
        hora.setSecion(true);
        hora.actualizar();
        /*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                             calcula  horas trabajadas                        */ 
     
    int horallegada=0;
    int minutollegada=0;
    int segundo=0;
    Date fin= new Date();
    fin=datFechahasta.getDate();
    Cierre cierre = new Cierre();
    
    horallegada= fin.getHours()-hora.getFechaInicio().getHours();
    
    if (hora.getFechaInicio().getMinutes()<fin.getMinutes()){
                    minutollegada=(fin.getMinutes()-hora.getFechaInicio().getMinutes());
    }else{
                    horallegada=horallegada-1;
                    minutollegada=(60-hora.getFechaInicio().getMinutes()+fin.getMinutes());
    }
    if (hora.getFechaInicio().getSeconds()<fin.getSeconds()){
                    segundo=(fin.getSeconds()-hora.getFechaInicio().getSeconds());
    }else{
                    minutollegada=minutollegada-1;
                    segundo=(60-hora.getFechaInicio().getSeconds()+fin.getSeconds());
    }
    if (horallegada<0){
                        hora.setHoras(0);
                        hora.setMinutos(minutollegada);
                        hora.setSegundos(segundo);
                       txtHorast.setText(""+0+" H :"+minutollegada+"  Min  :"+ segundo+"  Seg  " );
                         cierre.setHora(0);
                         cierre.setMinutos(minutollegada);
                         cierre.setSegundos(segundo);
                      }else{
                        hora.setHoras(horallegada);
                        hora.setMinutos(minutollegada);
                        hora.setSegundos(segundo);
                        txtHorast.setText(""+horallegada+" H  :"+minutollegada+"  Min  :"+ segundo+"  Seg  " );
                        cierre.setHora(horallegada);
                         cierre.setMinutos(minutollegada);
                         cierre.setSegundos(segundo);
    }
        
        
        
        cierre.setTingreso(Float.parseFloat(txtIngreso.getText()));
        cierre.setUproducto(Float.parseFloat(txtUtilidad.getText()));
        cierre.setTpuntos(Integer.parseInt(txtPuntos.getText()));
        cierre.setTegresos(Float.parseFloat(txtEgreso.getText()));
        cierre.setEfectivo(Float.parseFloat(txtEfectivo.getText()));
        cierre.setDeposito(Float.parseFloat(txtDeposito.getText()));
        cierre.setDesde(datFechadesde.getDate());
        cierre.setHasta(datFechahasta.getDate());
        cierre.setAperturacaja(Float.parseFloat(txtAperCaja.getText()));
        cierre.setTotalcaja(Float.parseFloat(txtAperCaja.getText())+Float.parseFloat(txtEfectivo.getText())-Float.parseFloat(txtEgreso.getText()));
        cierre.setHorario(hora);
        cierre.guardar();
       
        
        

        try {

            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista3(hora)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRE);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularActionPerformed
txtTotalCaja.setText(""+(Float.parseFloat(txtAperCaja.getText())+Float.parseFloat(txtEfectivo.getText())-Float.parseFloat(txtEgreso.getText())));        // TODO add your handling code here:
    }//GEN-LAST:event_jBCalcularActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private org.jdesktop.swingx.JXDatePicker datFechadesde;
    private org.jdesktop.swingx.JXDatePicker datFechahasta;
    private javax.swing.JButton jBCalcular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabelApellido3;
    private javax.swing.JLabel jLabelApellido4;
    private javax.swing.JLabel jLabelCivil10;
    private javax.swing.JLabel jLabelCivil11;
    private javax.swing.JLabel jLabelCivil12;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCivil9;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente4;
    private javax.swing.JLabel jLabelCreditopendiente5;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JTextField txtAperCaja;
    private javax.swing.JTextField txtDeposito;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtEgreso;
    private javax.swing.JTextField txtHorast;
    private javax.swing.JTextField txtIngreso;
    private javax.swing.JTextField txtInversion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtTotalCaja;
    private javax.swing.JTextField txtUreal;
    private javax.swing.JTextField txtUtilidad;
    // End of variables declaration//GEN-END:variables
    
}
