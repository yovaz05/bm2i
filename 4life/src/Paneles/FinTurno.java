/*
 * FinTurno.java
 *
 * Created on 1 de febrero de 2007, 09:22 AM
 */

package Paneles;

import beans.Remplazo;
import beans.Billetes;
import beans.anulargiro;
import beans.Cabinas;
import beans.ComprasOficina;
import beans.Flores;
import beans.Otros;
import beans.Pasajes;
import beans.VentaProductos;
import beans.VideoConferencia;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.CierreFaltante;
import beans.Cierre;
import beans.Agencia;
import beans.Cheque;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import beans.CuentasXCobrar;
import beans.CuentasXPagar;
import beans.PagoT;
import beans.Tarjetas;

import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class FinTurno extends javax.swing.JPanel {
    
private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private Agencia agencia;
    private CodigoAgencia codigos;
    private Horario horario;
    Horario oo;
    
    private Tarjetas tarjetas;
    private Lista tar;
    private Lista ta;
    
    private anulargiro anull;
    private Remplazo remplaz;
    
    private Giro giro;
    private Giro fin;
    private Giro sum;
    private CierreFaltante cierrefaltante;
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    
    private Cheque cheque;
    private Cheque pri;
    private Cheque ultimito;
    private Cheque bainas;
    
    private CuentasXCobrar cxp;
    private CuentasXCobrar cxp1;
    
    private CuentasXPagar cp;
    private CuentasXPagar cp1;
    
    
       
    private PagoT pg;
    private PagoT pg1;
    public int v=0;
    
    private Flores flores;
    Flores ult;
    Flores su;
    
    private Pasajes pasajes;
    Pasajes ul;
    Pasajes s;
   
    private  VideoConferencia video;
    VideoConferencia vid;
    VideoConferencia vi;
    
    private Cabinas cabinas;
    private Cabinas ultimo;
    private Cabinas sumas;
    
    private Otros otros;
    private Otros ultim;
    private Otros suma;
    private VentaProductos venta;
    
    private ComprasOficina pras ;
//   
    
    public FinTurno() {
        initComponents();
      //  generarcierre();
      
    }
   
    
 
 
         private void ventascredito(){
     /*   
        
        venta = new VentaProductos();
        otros = new Otros();
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
        
        lista = new Lista(new VentaProductos().lista2(otro));
        int p= Integer.parseInt(venta.getCredito());
        for(int i=0;i<lista.getSize();i++){
            venta =(VentaProductos) lista.getObject(i);
            int tamanio = lista.getSize();
            if(tamanio==0){
            }else{
                cierre = new Cierre();
                // Mensaje.showMensaje(this,"La agencia es "+venta.getOtros().getNombre());
              if (p>0){
                
                    cierre.setNumero(String.valueOf(venta.getCredito()));
                    cierre.setConcepto(venta.getOtros().getNombre());
                    cierre.setIngreso(true);
                    cierre.setHorario(otro);
                    cierre.setDesde(" ");
                    cierre.setHasta(" ");
                    cierre.setNeto(" ");
                    cierre.setTotal(String.valueOf(venta.getTotal()));
                    cierre.setCierre1(false);
                    if (cierre.guardar()){
                        //   Mensaje.showError(this,"BIEN CARAJO ","Error");
                    }else{
                    Mensaje.showError(this,"SE PUDRIO TODO","Error");
                        }
                    }
                }
  
        }
        */
        
    }
     private void FaltanteCierre(){
     //para que no se repitan los giros full quiromancias
      Cierre cierre = new Cierre();
    
                
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);

    
             
      
 }
 private void adelantoLG(){
     
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      cheque = new Cheque();
      boolean b = false;
       boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
      
      float che=0;
      float che1=0;
      float che2=0;
      
      int tamanio = codigo.getSize();
      if(tamanio==0){
      
      }else{
      
      
               
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         if (cheque.getLgtrasmiter()==false ){
                         if(cheque.getAdelanto()==true){
                         che = che+ cheque.getTotal();
                         che1 = che1+ cheque.getUtilidad();
                         che2 = che2+ cheque.getUtilidadche();
             }
         
         }
    }
 
   
  
//Aqui pongo el total Billetes
      
 //*************************************SACO EL efectivo
  Boolean cie=true;
  float adelan=0;
  listaAnteriores = new Lista(new Billetes().lista9(otro,cie, false));
  Billetes bill = new Billetes();
  int tamas=listaAnteriores.getSize();
  
  if (tamas<=0){
        adelan=0;
  }else{
        bill=(Billetes) listaAnteriores.getObject(0);
        adelan=Float.parseFloat(bill.getTotal());
     
  }

//*************************************SUMO todo
  float beto= adelan+che;
  
  double dos = ((double)Math.round(beto*100))/100;
  txtAdelantoLG.setText(""+dos);
  String au=String.valueOf(dos);
  otro.setAdelanto(Float.parseFloat(au));
  
  float and=0;
  float bet=0;
  if (txtAgente.getText().equals("")){
      and=0;
  }else{
      and=Float.parseFloat(txtAgente.getText());
  }
   
  bet=and-beto;
  double uno = ((double)Math.round(bet*100))/100;
  txtDepositoLG.setText(""+uno);
  String aus=String.valueOf(uno);
  otro.setDepoL(Float.parseFloat(aus));
  otro.actualizar();
      } 
     
 }
 
 
 
public void  cie2(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, est, est));
    int ver=lista.getSize();
    if (ver ==0){
  
    }else{
    Cierre cie = new Cierre();
    cie=(Cierre)lista.primero();
    
       for(int j=0;j<lista.getSize();j++){
                        Cierre sum=(Cierre)lista.getObject(j);
                       // Mensaje.showMensaje(this,"lo borro encontro "+sum.getId_Cierre());
                        sum.borrar();
                     //   Mensaje.showMensaje(this,"lo borro encontro ");    
                        
                        }
    }
  

}
   public void  cie3(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    Boolean es=(true);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, es, est));
    int ver=lista.getSize();
    if (ver ==0){
  
    }else{
    Cierre cie = new Cierre();
    cie=(Cierre)lista.primero();
    
       for(int j=0;j<lista.getSize();j++){
                        Cierre sum=(Cierre)lista.getObject(j);
                       // Mensaje.showMensaje(this,"lo borro encontro "+sum.getId_Cierre());
                        sum.borrar();
                     //   Mensaje.showMensaje(this,"lo borro encontro ");    
                        
                        }
    }
  

} 
public void  cie1(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    Boolean es=(true);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, es, es));
    int ver=lista.getSize();
    if (ver ==0){
  
    }else{
    Cierre cie = new Cierre();
    cie=(Cierre)lista.primero();
    
       for(int j=0;j<lista.getSize();j++){
                        Cierre sum=(Cierre)lista.getObject(j);
                       // Mensaje.showMensaje(this,"lo borro encontro "+sum.getId_Cierre());
                        sum.borrar();
                     //   Mensaje.showMensaje(this,"lo borro encontro ");    
                        
                        }
    }
  

}


public void  sumas(){
//Cieere de Money Trasmitter    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    Boolean es=(true);
    otro=horario.buscar(est);
    
    //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
      boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
      float che=0;
      float che1=0;
      float che2=0;
   
             
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         if (cheque.getLgtrasmiter()==true){
         che = che+ cheque.getTotal();
         che1 = che1+ cheque.getUtilidad();
         che2 = che2+ cheque.getUtilidadche();
         }
    }

double si = ((double)Math.round(che*100))/100;
double si1 = ((double)Math.round(che1*100))/100;
double si2 = ((double)Math.round(che2*100))/100;

txtNeto2.setText(String.valueOf(che));
txtSobranteChe.setText(String.valueOf(si2));
txtSoCheque.setText(String.valueOf(si1));



//*************************************SACO EL TOTAL DE INGRESOS  
    
    lista = new Lista(new Cierre().lista(otro, est, es));
    int ver=lista.getSize();
    float suma1=0;
    float utilidad=0;
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         //Mensaje.showMensaje(this,"ES el "+sum.getConcepto());
      
       }
        utilidad=suma1;
        double us = ((double)Math.round(utilidad*100))/100;
        txtTIngresos.setText(String.valueOf(us));
    }else{
        suma1=0;
        txtTIngresos.setText(""+suma1);
    }
   //*************************************SACO LO EGRESOS
    
    codigo = new Lista(new Cierre().lista(otro, es, es));
    int  ve=codigo.getSize();
    float suma2=0;
   //Mensaje.showMensaje(this,"LA cadena es "+ve);
    if (ve!=0){
        
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
      //   suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   double sisi = ((double)Math.round(suma2*100))/100;
   txtTEgresos.setText(String.valueOf(sisi));
    }else{
        suma2=0;
        txtTEgresos.setText(""+suma2);
    }
  float  to= utilidad-suma2;
  double sil = ((double)Math.round(to*100))/100;
  txtUNeta.setText(""+sil);
  
  //*************************************SACO EL efectivo
  Boolean cie=true;
 listaAnteriores = new Lista(new Billetes().lista(otro, cie));
  Billetes bill = new Billetes();
 int tamas=listaAnteriores.getSize();
 float efectv=0;
  if (tamas<=0){
        efectv=0;
       
        txtEfectivo.setText(""+efectv);
  }else{
        
         for(int j=0;j<listaAnteriores.getSize();j++){
         bill=(Billetes)listaAnteriores.getObject(j);
         efectv= efectv+ Float.parseFloat(bill.getTotal());
       }
        double efes = ((double)Math.round(efectv*100))/100;
        txtEfectivo.setText(""+efectv);
  }
 //*************************************SACO EL TOTAL DE LOS CREDITOS 
 float falta= to-(efectv+che);
 double fal = ((double)Math.round(falta*100))/100;
  jTextField2.setText(""+fal);

//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(otro, true));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   double credi = ((double)Math.round(cuenta*100))/100;          
   txtCredito.setText(String.valueOf(credi));           
             
}

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelApellido2 = new javax.swing.JLabel();
        jLabelCivil2 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        txtTIngresos = new javax.swing.JTextField();
        txtTEgresos = new javax.swing.JTextField();
        txtUNeta = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        jLabelCivil6 = new javax.swing.JLabel();
        jLabelCivil8 = new javax.swing.JLabel();
        jLabelCivil7 = new javax.swing.JLabel();
        txtSoCheque = new javax.swing.JTextField();
        txtSobranteChe = new javax.swing.JTextField();
        txtCredito = new javax.swing.JTextField();
        txtNeto2 = new javax.swing.JTextField();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jLabelCreditopendiente4 = new javax.swing.JLabel();
        jLabelCreditopendiente5 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelApellido3 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelCivil3 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jLabelCivil9 = new javax.swing.JLabel();
        txtEfec = new javax.swing.JTextField();
        jLabelCivil10 = new javax.swing.JLabel();
        txtChequesSobrante = new javax.swing.JTextField();
        jLabelCivil11 = new javax.swing.JLabel();
        txtChequeUtil = new javax.swing.JTextField();
        jLabelCivil12 = new javax.swing.JLabel();
        txtNeto3 = new javax.swing.JTextField();
        txtCredito1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelNombre3 = new javax.swing.JLabel();
        jLabelCivil14 = new javax.swing.JLabel();
        jLabelCreditopendiente6 = new javax.swing.JLabel();
        jLabelNombre4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelApellido4 = new javax.swing.JLabel();
        txtIngreso = new javax.swing.JTextField();
        jLabelCivil15 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabelCivil16 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JTextField();
        jLabelNombre5 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabelCivil17 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabelCivil13 = new javax.swing.JLabel();
        txtAdelantoMT = new javax.swing.JTextField();
        jLabelCivil18 = new javax.swing.JLabel();
        txtDepositoMT = new javax.swing.JTextField();
        jLabelCivil19 = new javax.swing.JLabel();
        txtAdelantoLG = new javax.swing.JTextField();
        jLabelCivil20 = new javax.swing.JLabel();
        txtDepositoLG = new javax.swing.JTextField();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente1.setForeground(new java.awt.Color(51, 153, 0));
        jLabelCreditopendiente1.setText("           LG MONEY TRASNMITTER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente3.setForeground(new java.awt.Color(0, 153, 51));
        jLabelCreditopendiente3.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 23, 0);
        add(jLabelCreditopendiente3, gridBagConstraints);

        datFechaIngreso.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 23, 0);
        add(datFechaIngreso, gridBagConstraints);

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido2.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil2.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil2, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil4.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil4, gridBagConstraints);

        txtTIngresos.setEditable(false);
        txtTIngresos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtTIngresos.setBorder(null);
        txtTIngresos.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtTIngresos, gridBagConstraints);

        txtTEgresos.setEditable(false);
        txtTEgresos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtTEgresos.setBorder(null);
        txtTEgresos.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        txtTEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTEgresosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtTEgresos, gridBagConstraints);

        txtUNeta.setEditable(false);
        txtUNeta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtUNeta.setBorder(null);
        txtUNeta.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtUNeta, gridBagConstraints);

        txtEfectivo.setEditable(false);
        txtEfectivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtEfectivo.setBorder(null);
        txtEfectivo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtEfectivo, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil5.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil5, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil6.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil8.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil8, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil7.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil7, gridBagConstraints);

        txtSoCheque.setEditable(false);
        txtSoCheque.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSoCheque.setBorder(null);
        txtSoCheque.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtSoCheque.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtSoCheque, gridBagConstraints);

        txtSobranteChe.setEditable(false);
        txtSobranteChe.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSobranteChe.setBorder(null);
        txtSobranteChe.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtSobranteChe.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtSobranteChe, gridBagConstraints);

        txtCredito.setEditable(false);
        txtCredito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtCredito.setBorder(null);
        txtCredito.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtCredito, gridBagConstraints);

        txtNeto2.setEditable(false);
        txtNeto2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNeto2.setBorder(null);
        txtNeto2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNeto2, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                                                     CIERRE TOTAL DE CAJA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente2, gridBagConstraints);

        jLabelCreditopendiente4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente4.setForeground(new java.awt.Color(51, 153, 0));
        jLabelCreditopendiente4.setText("             CIERRE  TOTAL DE LG TRAVEL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente4, gridBagConstraints);

        jLabelCreditopendiente5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente5.setForeground(new java.awt.Color(0, 153, 51));
        jLabelCreditopendiente5.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 23, 0);
        add(jLabelCreditopendiente5, gridBagConstraints);

        datFechaIngreso1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 23, 0);
        add(datFechaIngreso1, gridBagConstraints);

        jLabelNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre2.setText("Horas Trabajadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre2, gridBagConstraints);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtCodigo.setBorder(null);
        txtCodigo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtCodigo, gridBagConstraints);

        jLabelApellido3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido3.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido3, gridBagConstraints);

        txtNombre1.setEditable(false);
        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNombre1, gridBagConstraints);

        jLabelCivil3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil3.setText("Faltante Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil3, gridBagConstraints);

        txtAgente.setEditable(false);
        txtAgente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtAgente.setBorder(null);
        txtAgente.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtAgente, gridBagConstraints);

        jLabelCivil9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil9.setText("Fecha de salida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil9, gridBagConstraints);

        txtEfec.setEditable(false);
        txtEfec.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtEfec.setBorder(null);
        txtEfec.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtEfec, gridBagConstraints);

        jLabelCivil10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil10.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil10, gridBagConstraints);

        txtChequesSobrante.setEditable(false);
        txtChequesSobrante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtChequesSobrante.setBorder(null);
        txtChequesSobrante.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtChequesSobrante.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtChequesSobrante, gridBagConstraints);

        jLabelCivil11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil11.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil11, gridBagConstraints);

        txtChequeUtil.setEditable(false);
        txtChequeUtil.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtChequeUtil.setBorder(null);
        txtChequeUtil.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtChequeUtil.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtChequeUtil, gridBagConstraints);

        jLabelCivil12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil12.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil12, gridBagConstraints);

        txtNeto3.setEditable(false);
        txtNeto3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNeto3.setBorder(null);
        txtNeto3.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNeto3, gridBagConstraints);

        txtCredito1.setEditable(false);
        txtCredito1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtCredito1.setBorder(null);
        txtCredito1.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtCredito1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel1.setText("Faltante de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 40, 0, 0);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        add(jTextField1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        add(jTextField2, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel2.setText("Faltante de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabelNombre3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre3.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelNombre3, gridBagConstraints);

        jLabelCivil14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil14.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil14, gridBagConstraints);

        jLabelCreditopendiente6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente6.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente6.setText("                                          DATOS DE LA PERSONA ENCARGADA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente6, gridBagConstraints);

        jLabelNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre4.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre4, gridBagConstraints);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtNombre, gridBagConstraints);

        jLabelApellido4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido4.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido4, gridBagConstraints);

        txtIngreso.setEditable(false);
        txtIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtIngreso.setBorder(null);
        txtIngreso.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtIngreso, gridBagConstraints);

        jLabelCivil15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil15.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil15, gridBagConstraints);

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtApellido.setBorder(null);
        txtApellido.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtApellido, gridBagConstraints);

        jLabelCivil16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil16.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil16, gridBagConstraints);

        txtSalida.setEditable(false);
        txtSalida.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSalida.setBorder(null);
        txtSalida.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtSalida, gridBagConstraints);

        jLabelNombre5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre5, gridBagConstraints);

        txtNombre2.setEditable(false);
        txtNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre2.setBorder(null);
        txtNombre2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtNombre2, gridBagConstraints);

        jLabelCivil17.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil17.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil17, gridBagConstraints);

        txtApellido1.setEditable(false);
        txtApellido1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtApellido1.setBorder(null);
        txtApellido1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtApellido1, gridBagConstraints);

        jButton3.setText("Cierre total de las Agencias");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 7, 0);
        add(jButton3, gridBagConstraints);

        jLabelCivil13.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelCivil13.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil13.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil13, gridBagConstraints);

        txtAdelantoMT.setEditable(false);
        txtAdelantoMT.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtAdelantoMT.setForeground(new java.awt.Color(0, 0, 255));
        txtAdelantoMT.setBorder(null);
        txtAdelantoMT.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtAdelantoMT.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 0);
        add(txtAdelantoMT, gridBagConstraints);

        jLabelCivil18.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelCivil18.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil18.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil18, gridBagConstraints);

        txtDepositoMT.setEditable(false);
        txtDepositoMT.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtDepositoMT.setForeground(new java.awt.Color(0, 0, 255));
        txtDepositoMT.setBorder(null);
        txtDepositoMT.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtDepositoMT.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 0);
        add(txtDepositoMT, gridBagConstraints);

        jLabelCivil19.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelCivil19.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil19.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil19, gridBagConstraints);

        txtAdelantoLG.setEditable(false);
        txtAdelantoLG.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtAdelantoLG.setForeground(new java.awt.Color(0, 0, 255));
        txtAdelantoLG.setBorder(null);
        txtAdelantoLG.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtAdelantoLG.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 0);
        add(txtAdelantoLG, gridBagConstraints);

        jLabelCivil20.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabelCivil20.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil20.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil20, gridBagConstraints);

        txtDepositoLG.setEditable(false);
        txtDepositoLG.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtDepositoLG.setForeground(new java.awt.Color(0, 0, 255));
        txtDepositoLG.setBorder(null);
        txtDepositoLG.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtDepositoLG.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
        add(txtDepositoLG, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Date hora1;
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    
    otro.setIngresoL(Float.parseFloat(txtCodigo.getText()));
    otro.setEgresoL(Float.parseFloat(txtNombre1.getText()));
    otro.setFaltaL(Float.parseFloat(jTextField1.getText()));
    
    otro.setIngresoT(Float.parseFloat(txtTIngresos.getText()));
    otro.setEgresoT(Float.parseFloat(txtTEgresos.getText()));
    otro.setFaltaT(Float.parseFloat(jTextField2.getText()));
    
    int horallegada=0;
    int minutollegada=0;
    int segundo=0;
   
    
    horallegada= otro.getFechaFin().getHours()-otro.getFechaInicio().getHours();
    
    if (otro.getFechaInicio().getMinutes()<otro.getFechaFin().getMinutes()){
                    minutollegada=(otro.getFechaFin().getMinutes()-otro.getFechaInicio().getMinutes());
    }else{
                    horallegada=horallegada-1;
                    minutollegada=(60-otro.getFechaInicio().getMinutes()+otro.getFechaFin().getMinutes());
    }
    if (otro.getFechaInicio().getSeconds()<otro.getFechaFin().getSeconds()){
                    segundo=(otro.getFechaFin().getSeconds()-otro.getFechaInicio().getSeconds());
    }else{
                    minutollegada=minutollegada-1;
                    segundo=(60-otro.getFechaInicio().getSeconds()+otro.getFechaFin().getSeconds());
    }
    if (horallegada<0){
                        otro.setHoras(0);
                        otro.setMinutos(minutollegada);
                        otro.setSegundos(segundo);
                      }else{
                        otro.setHoras(horallegada);
                        otro.setMinutos(minutollegada);
                        otro.setSegundos(segundo);
                      }
    otro.setSecion(true); 
    otro.actualizar();
    hora1=new Date();
    try {
            
      ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(oo.bus(oo)),Mapa.MAPAFINTURNO,true),ReportePrevio.FINDETURNO);
      rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
      rp.setDesde(hora1);
    //  rp.setTotale(egre);
      rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
 // """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
      tarjetas = new Tarjetas();
        
       Lista listaAnteriores =new Lista(new Otros().lista());
       for(int i=0;i<listaAnteriores.getSize();i++){
           
                   Otros b1=(Otros) listaAnteriores.getObject(i);
                   tarjetas= tarjetas.Busca(b1.getNombre(),otro);
                   
                   if (tarjetas==null){
                       tarjetas = new Tarjetas();
                       tarjetas.setDejo(b1.getStock());
                       tarjetas.setVendidos(b1.getStock());
                       tarjetas.setHorario(otro);
                       tarjetas.setNombre(b1.getNombre());
                       tarjetas.setFecha(new Date());
                       tarjetas.guardar();
                   }else{
                       tarjetas.setDejo(b1.getStock());
                       int a =tarjetas.getRecibi()-b1.getStock();
                       tarjetas.setVendidos(a);
                       tarjetas.actualizar();
                   }
                   }
                   
         Lista tar =new Lista(new Tarjetas().lista3(otro));
                  
         Date p = new Date();
         
         try {
              ReportePrevio rp = new ReportePrevio(new Mapa(tar,Mapa.MAPATARJETAS,true),ReportePrevio.TARJETAS);
              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
              rp.setDesde(p);
              rp.mostrarVistaPreliminar(MenuPrin.escritorio);
             } catch (Exception e) {
               e.printStackTrace();
             } 
     // """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtTEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTEgresosActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtTEgresosActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelApellido3;
    private javax.swing.JLabel jLabelApellido4;
    private javax.swing.JLabel jLabelCivil10;
    private javax.swing.JLabel jLabelCivil11;
    private javax.swing.JLabel jLabelCivil12;
    private javax.swing.JLabel jLabelCivil13;
    private javax.swing.JLabel jLabelCivil14;
    private javax.swing.JLabel jLabelCivil15;
    private javax.swing.JLabel jLabelCivil16;
    private javax.swing.JLabel jLabelCivil17;
    private javax.swing.JLabel jLabelCivil18;
    private javax.swing.JLabel jLabelCivil19;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil20;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCivil7;
    private javax.swing.JLabel jLabelCivil8;
    private javax.swing.JLabel jLabelCivil9;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelCreditopendiente4;
    private javax.swing.JLabel jLabelCreditopendiente5;
    private javax.swing.JLabel jLabelCreditopendiente6;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombre5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtAdelantoLG;
    private javax.swing.JTextField txtAdelantoMT;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtChequeUtil;
    private javax.swing.JTextField txtChequesSobrante;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtCredito1;
    private javax.swing.JTextField txtDepositoLG;
    private javax.swing.JTextField txtDepositoMT;
    private javax.swing.JTextField txtEfec;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtIngreso;
    private javax.swing.JTextField txtNeto2;
    private javax.swing.JTextField txtNeto3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtSalida;
    private javax.swing.JTextField txtSoCheque;
    private javax.swing.JTextField txtSobranteChe;
    private javax.swing.JTextField txtTEgresos;
    private javax.swing.JTextField txtTIngresos;
    private javax.swing.JTextField txtUNeta;
    // End of variables declaration//GEN-END:variables
    
}
