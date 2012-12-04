/*
 * FinTurno.java
 *
 * Created on 1 de febrero de 2007, 09:22 AM
 */

package Paneles;

import beans.Billetes;
import beans.Cabinas;
import beans.ComprasOficina;
import beans.Flores;
import beans.Otros;
import beans.Pasajes;
import beans.Usuario;
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

import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class FinTurno_1 extends javax.swing.JPanel {
    
  private Lista lista;
  private Lista codigo;
  private Horario horario;
  Lista betos;
  Horario oo; 
  Usuario otros;

  
  
    private Lista codigo1;
    private Agencia agencia;
    private CodigoAgencia codigos;
    
    
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
    

    private Otros ultim;
    private Otros suma;
    private VentaProductos venta;
    
    private ComprasOficina pras ;
  
  
  
  
    public FinTurno_1() {
        initComponents();
       
        //horarios ();
                   otros = new Usuario();
                   lista = new Lista(new Usuario().lista());
                   for(int i=0;i<lista.getSize();i++){
                   Usuario b1=(Usuario) lista.getObject(i);
                   cboProductos.addItem(b1.getNombre());
        }
        
    }
     
    private void generarcierre(){
       moneytrasmiter();     
       lgtravel();
      }
    
 private void lgtravel(){
       cie2();
       flores();
       pasaje();
       videos();
       Cabina();
       venats();
       cheq2();
       ccobrar2();
       paquetes();
       utilidadcheque();
       cie3();
       dpaquetes();
       cpagar2();
       compras();   
       pt();
       FaltanteCierre();
       sumas2();
       adelantoLG();
   }
 
 
     private void FaltanteCierre(){
     //para que no se repitan los giros full quiromancias
    CierreFaltante cierrefaltante = new CierreFaltante();
    
                
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);

     giro = new Giro();
     boolean b = false;
     codigo = new Lista(new CierreFaltante().lista3(otro, b));
     float o =0;    
     int num=0;
     int tamanio = codigo.getSize();
     if(tamanio==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(false);
                          cierre.setConcepto("Faltante de Otros Cierres");
                          
                          for(int j=0;j<tamanio;j++){
                          cierrefaltante=(CierreFaltante)codigo.getObject(j); 
                          o=o+cierrefaltante.getSaldo();
                         }
                  //txtDeposito2.getText(String.valueOf(o));
                  cierre.setNumero(String.valueOf(num));
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(false);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los giros devueltos ","Error");
                  }
            } 
      
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
  
  String au=String.valueOf(dos);
  otro.setAdelanto(Float.parseFloat(au));
  
  float and=0;
  float bet=0;

   
  bet=and-beto;
  double uno = ((double)Math.round(bet*100))/100;
  
  String aus=String.valueOf(uno);
  otro.setDepoL(Float.parseFloat(aus));
  otro.actualizar();
      } 
     
 }
 
 
 private void utilidadcheque(){
     
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      cheque = new Cheque();
      boolean b = true;
      boolean ciert=false;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
      
      float che=0;
      float che1=0;
      float che2=0;
      
      int tamanio = codigo.getSize();
      if(tamanio==0){
      
      }else{
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Utilidad de Cheque");
               
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
          if (cheque.getLgtrasmiter()==false){
         che = che+ cheque.getTotal();
         che1 = che1+ cheque.getUtilidad();
         che2 = che2+ cheque.getUtilidadche();
         }
    }
         
    //  txtNeto2.setText(String.valueOf(che));
     // txtSobranteChe.setText(String.valueOf(che2));
      cierre.setNumero(String.valueOf(codigo.getSize()));
      cierre.setTotal(String.valueOf(che1));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(false);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Sobrante de Cheques");
      
               
    //  txtNeto2.setText(String.valueOf(che));
     // txtSobranteChe.setText(String.valueOf(che2));
      cierre.setNumero(String.valueOf(codigo.getSize()));
      cierre.setTotal(String.valueOf(che2));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(false);
      if (cierre.guardar()){
         }
    
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
    
 private void flores(){

            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
      
            flores = new Flores();
            codigo = new Lista(new Flores().lista3(otro));
      
            int tamanio = codigo.getSize();
            if(tamanio==0){
      
            }else{  
                flores=(Flores) codigo.primero();
                ult=(Flores) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(String.valueOf(flores.getFactura()));
                cierre.setHasta(String.valueOf(ult.getFactura()));
                cierre.setIngreso(false);
                cierre.setConcepto("Flores");
                cierre.setNumero(String.valueOf(tamanio));
      
                float tot =0;
                for(int j=0;j<tamanio;j++){
                    Flores su=(Flores)codigo.getObject(j);
                    tot=tot+su.getTotal();
                    }
                cierre.setTotal(String.valueOf(tot));
                cierre.setNeto("0");
                cierre.setHorario(otro);
                cierre.setCierre1(false);
                cierre.guardar();
                } 

}
 private void pasaje(){
     
    
            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
      
            pasajes = new Pasajes();
            codigo = new Lista(new Pasajes().lista3(otro));
      
            int tamanio = codigo.getSize();
            if(tamanio==0){
            
            }else{
                pasajes=(Pasajes) codigo.primero();
                ul=(Pasajes) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(" ");
                cierre.setHasta(" ");
                cierre.setIngreso(false);
                cierre.setConcepto("Pasajes");
                cierre.setNumero(String.valueOf(tamanio));
      
                float to =0;
                for(int j=0;j<tamanio;j++){
                    Pasajes s=(Pasajes)codigo.getObject(j);
                    to=to+s.getValor();
                }
                cierre.setTotal(String.valueOf(to));
                cierre.setNeto("0");
                cierre.setHorario(otro);
                cierre.setCierre1(false);
                cierre.guardar();
                }
   
  }
 private void videos(){
     
    
            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
      
            video = new VideoConferencia();
            codigo = new Lista(new VideoConferencia().lista3(otro));
      
            int tamanio = codigo.getSize();
            if(tamanio==0){
            
            }else{
                video=(VideoConferencia) codigo.primero();
                vid=(VideoConferencia) codigo.ultimo();
                cierre = new Cierre();
                
                cierre.setHasta(String.valueOf(video.getNumero()));
                cierre.setDesde(String.valueOf(vid.getNumero()));
                cierre.setIngreso(false);
                cierre.setConcepto("Video Conferencia");
                cierre.setNumero(String.valueOf(tamanio));
      
                float to =0;
                for(int j=0;j<tamanio;j++){
                    VideoConferencia vi=(VideoConferencia)codigo.getObject(j);
                    to=to+vi.getTotal();
                           
                }
                cierre.setTotal(String.valueOf(to));
                cierre.setNeto("0");
                cierre.setHorario(otro);
                cierre.setCierre1(false);
                cierre.guardar();
                }
   
  }
 private void Cabina(){
     
      
            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
      
            cabinas = new Cabinas();
            codigo = new Lista(new Cabinas().lista3(otro));
      
            int tamanio = codigo.getSize();
            if(tamanio==0){
      
            }else{
                cabinas=(Cabinas) codigo.primero();
                ultimo=(Cabinas) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(" ");
                cierre.setHasta(" ");
                cierre.setIngreso(false);
                cierre.setConcepto("Cabinas");
                cierre.setNumero(String.valueOf(tamanio));
      
                float o =0;
                for(int j=0;j<tamanio;j++){
                     Cabinas sumas=(Cabinas)codigo.getObject(j);
                    o=o+sumas.getValor();
                  }
                cierre.setTotal(String.valueOf(o));
                cierre.setNeto("0");
                cierre.setHorario(otro);
                cierre.setCierre1(false);
                if (cierre.guardar()){
     // Mensaje.showError(this,"ya se guardo ","Error");
                 }
            } 
      

  }
 private void venats(){
   
    
            venta = new VentaProductos();
          
          
            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
         
 
            lista = new Lista(new VentaProductos().lista2(otro));
            for(int i=0;i<lista.getSize();i++){
                    venta =(VentaProductos) lista.getObject(i);
                    int tamanio = lista.getSize();
                    if(tamanio==0){
                    }else{
                        cierre = new Cierre();
                       // Mensaje.showMensaje(this,"La agencia es "+venta.getOtros().getNombre());
                        if (Integer.parseInt(venta.getContado())>0){
                               cierre.setNumero(String.valueOf(venta.getContado()));
                             }else{
                                cierre.setNumero(String.valueOf(venta.getCredito()));
                               }
                        cierre.setConcepto(venta.getOtros().getNombre());
                        cierre.setIngreso(false);
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
 private void cheq2(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      cheque = new Cheque();
      boolean b = true;
      boolean ciert=false;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
      
      int tamanio = codigo.getSize();
      if(tamanio==0){
      
      }else{
      
      cierre = new Cierre();
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Cheques Protestados");
      
      int unidades=0;
      float o =0;
      for(int j=0;j<tamanio;j++){
           Cheque bainas=(Cheque)codigo.getObject(j);
           if (bainas.getGiro()==null){
                                       o=o+bainas.getTotal();
                                       unidades=unidades+1;
                                       }
           
         }
      cierre.setNumero(String.valueOf(unidades));
      cierre.setTotal(String.valueOf(o));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(false);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Valor del Protesto");
      
      int protesto=0;
      float p =0;
      for(int j=0;j<tamanio;j++){
           Cheque bainas=(Cheque)codigo.getObject(j);
           if (bainas.getGiro()==null){
                                       p=p+bainas.getProtesto();
                                       
                                       }
           
         }
      cierre.setNumero(String.valueOf(unidades));
      cierre.setTotal(String.valueOf(p));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(false);
      if (cierre.guardar()){
         }
    
      } 
     
 }
 private void paquetes(){
 
     
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);

                  agencia = new Agencia();
                   String cod ="PQ";
                  agencia = agencia.Busca(cod);
                //  Mensaje.showMensaje(this,"Cual es teamanio "+agencia.getNombre());
                  giro = new Giro();
                  boolean b = false;
                  codigo = new Lista(new Giro().lista10(agencia, otro, b));

                  int tamanio = codigo.getSize();

                  if(tamanio==0){
               //   Mensaje.showMensaje(this,"Cual es teamanio "+tamanio);
                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(false);
                  cierre.setConcepto("Paquetes ");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;

                  for(int j=0;j<tamanio;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(false);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los paquetes devueltos ","Error");
                  }
                  } 
     
 }

 
 private void ccobrar2(){
      
             horario=new Horario();
              Horario otro = new Horario();
              Boolean est=(false);
              otro=horario.buscar(est);
              Boolean gi=false;
              
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(otro, gi));

              int tamanio = codigo.getSize();
              if(tamanio==0){

              }else{

              cierre = new Cierre();
              cierre.setDesde("");
              cierre.setHasta("");
              cierre.setIngreso(false);
              cierre.setConcepto("Cuentas X Cobrar");
              cierre.setNumero(String.valueOf(tamanio));

              float o =0;

              for(int j=0;j<tamanio;j++){
                   CuentasXCobrar cxp1=(CuentasXCobrar)codigo.getObject(j);
                   o=o+cxp1.getCuota();
                 }
              cierre.setTotal(String.valueOf(o));
              cierre.setNeto("0");
              cierre.setHorario(otro);
              cierre.setCierre1(false);
              if (cierre.guardar()){
            //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
              }
              }  
     
 }
private void dpaquetes(){
 
     
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);

                  agencia = new Agencia();
                   String cod ="PQ";
                  agencia = agencia.Busca(cod);
                //  Mensaje.showMensaje(this,"Cual es teamanio "+agencia.getNombre());
                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista10(agencia, otro, b));

                  int tamanio = codigo.getSize();

                  if(tamanio==0){
               //   Mensaje.showMensaje(this,"Cual es teamanio "+tamanio);
                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Paquetes Devueltos ");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;

                  for(int j=0;j<tamanio;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(false);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los paquetes devueltos ","Error");
                  }
                  } 
     
 }
 private void cpagar2(){
 
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);
                  
                  boolean pagos =true;
                  cp = new CuentasXPagar();
                  codigo = new Lista(new CuentasXPagar().lista6(otro, est));

                  int tamanio = codigo.getSize();
                  if(tamanio==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Cuentas X Pagar");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;
                  for(int j=0;j<tamanio;j++){
                       CuentasXPagar cp1=(CuentasXPagar)codigo.getObject(j);
                       o=o+cp1.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(false);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
                  }
                  } 
     
 }
private void compras(){
     
                      horario=new Horario();
                      Horario otro = new Horario();
                      Boolean est=(false);
                      otro=horario.buscar(est);

                      pras = new ComprasOficina();
                      boolean b = true;
                      codigo = new Lista(new ComprasOficina().lista3(otro, est));

                      int tamanio = codigo.getSize();
                      if(tamanio==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Compras de Oficina");
                      cierre.setNumero(String.valueOf(tamanio));

                      float o =0;
                      for(int j=0;j<tamanio;j++){
                           ComprasOficina pras1=(ComprasOficina)codigo.getObject(j);
                           o=o+pras1.getValor();


                         }
                      cierre.setTotal(String.valueOf(o));
                      cierre.setNeto("0");
                      cierre.setHorario(otro);
                      cierre.setCierre1(false);
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardadas las compras ","Error");
                      }
                      } 
     
 } 
 private void pt(){
     
     
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);

                  pg = new PagoT();

                  codigo = new Lista(new PagoT().lista3(otro));
                  int tamanio = codigo.getSize();

                  if(tamanio==0){
                  }else{
                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Pago Facturas de Tarjetas ");
                      cierre.setNumero(String.valueOf(tamanio));
                      float o =0;
                      for(int j=0;j<tamanio;j++){
                            PagoT pg1=(PagoT)codigo.getObject(j);
                            o=o+pg1.getValorpagar();

                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(false);
                  if (cierre.guardar()){
               //   Mensaje.showError(this,"guardado los giros de oficina ","Error");
                  }
                  } 
     
 
 }    
      
    // ******************************************************* 
    // ******************************************************* 
    // ******************************************************* 

    // DE AQUI EN ADELANTE MONEY TRASNMITTER 

    // ******************************************************* 
    // ******************************************************* 
    // ******************************************************* 
private void moneytrasmiter(){
       cie();
       agencias();
       cheq();
       ccobrar();
       utilidadcheque1();
       cie1();
       dgiros();
       pgiros();
       cpagar();
       rgiro();
        FaltanteCierre1();
       goficina();
       compras2();
       sumas();
       adelanto();
      
}  
 private void compras2(){
     
                      horario=new Horario();
                      Horario otro = new Horario();
                      Boolean est=(false);
                      otro=horario.buscar(est);

                      pras = new ComprasOficina();
                      boolean b = true;
                      codigo = new Lista(new ComprasOficina().lista3(otro, b));

                      int tamanio = codigo.getSize();
                      if(tamanio==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Compras de Oficina");
                      cierre.setNumero(String.valueOf(tamanio));

                      float o =0;
                      for(int j=0;j<tamanio;j++){
                           ComprasOficina pras1=(ComprasOficina)codigo.getObject(j);
                           o=o+pras1.getValor();


                         }
                      cierre.setTotal(String.valueOf(o));
                      cierre.setNeto("0");
                      cierre.setHorario(otro);
                      cierre.setCierre1(true);
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardadas las compras ","Error");
                      }
                      } 
     
 }

 private void FaltanteCierre1(){
     //para que no se repitan los giros full quiromancias
    CierreFaltante cierrefaltante = new CierreFaltante();
    
                
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);

     giro = new Giro();
     boolean b = true;
     codigo = new Lista(new CierreFaltante().lista3(otro, b));
     float o =0;    
     int num=0;
     int tamanio = codigo.getSize();
     if(tamanio==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(false);
                          cierre.setConcepto("Faltante de Otros Cierres");
                          
                          for(int j=0;j<tamanio;j++){
                          cierrefaltante=(CierreFaltante)codigo.getObject(j); 
                          o=o+cierrefaltante.getSaldo();
                         }
                  //txtDeposito2.getText(String.valueOf(o));
                  cierre.setNumero(String.valueOf(num));
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los giros devueltos ","Error");
                  }
            } 
      
 }



private void adelanto(){
     
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
         if (cheque.getLgtrasmiter()==true ){
                         if(cheque.getAdelanto()==true){
                         che = che+ cheque.getTotal();
                         che1 = che1+ cheque.getUtilidad();
                         che2 = che2+ cheque.getUtilidadche();
             }
         
         }
    }
         
    //  txtNeto2.setText(String.valueOf(che));
     // txtSobranteChe.setText(String.valueOf(che2));
     
  
//Aqui pongo el total Billetes
      
 //*************************************SACO EL efectivo
  Boolean cie=true;
  float adelan=0;
 listaAnteriores = new Lista(new Billetes().lista9(otro,cie, cie));
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
  double si1 = ((double)Math.round(beto*100))/100;
 
  String as=String.valueOf(si1);
  otro.setAdelanto(Float.parseFloat(as));
  float and=0;
  float bet=0;

   
  bet=and-beto;
  double si2 = ((double)Math.round(bet*100))/100;
  
 
  otro.setDepoT(bet);
  otro.actualizar();
      } 
     
 }


private void utilidadcheque1(){
     
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
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Utilidad de Cheque");
               
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         if (cheque.getLgtrasmiter()==true){
         che = che+ cheque.getTotal();
         che1 = che1+ cheque.getUtilidad();
         che2 = che2+ cheque.getUtilidadche();
         }
    }
         

         cierre.setNumero(String.valueOf(codigo.getSize()));
      cierre.setTotal(String.valueOf(che1));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Sobrante de Cheques");
      
               
    //  txtNeto2.setText(String.valueOf(che));
     // txtSobranteChe.setText(String.valueOf(che2));
      cierre.setNumero(String.valueOf(codigo.getSize()));
      cierre.setTotal(String.valueOf(che2));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
    
      } 
     
 }

private void horarios(){
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    Date fin;
    otro.setFechaFin(new Date());
    otro.actualizar();
    
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
 
}

public void  cie(){
   
    Boolean est=(false);
    Boolean es=(true);
    
    lista = new Lista(new Cierre().lista(oo, est, es));
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
    
    
    Boolean est=(false);
    Boolean es=(true);
  
    lista = new Lista(new Cierre().lista(oo, es, es));
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

private void agencias(){
     
  
        agencia = new Agencia();
        lista = new Lista(new Agencia().lista());

        Boolean est=(false);
      
       
 
        for(int i=0;i<lista.getSize();i++){
            cierre = new Cierre();
            Agencia b1=(Agencia) lista.getObject(i);
            listaAnteriores =new Lista(new Giro().lista19(oo,b1)); 
            //EL NUMERO DE GIROS
            int tamanio = listaAnteriores.getSize();
            if(tamanio==0){
        
            }else{
                    cierre.setConcepto(b1.getNombre());
                    cierre.setNumero(String.valueOf(tamanio));
                    giro = new Giro();
                    giro = (Giro) listaAnteriores.primero();
                    //GUARDO EL PRIMER CODIGO
                    if (giro==null){
                                        
                    }else if (b1.getCodigo().equals("GO")){
            
                   }else if (b1.getCodigo().equals("PQ")){
            
                                }else{
                                        fin = (Giro) listaAnteriores.ultimo();
                                        cierre.setDesde(fin.getClave());
                                        cierre.setHasta(giro.getClave());
                                        cierre.setHorario(oo);
                                        fin = new Giro();
                         
                                        float net =0;
                                        float tot =0;
                          for(int j=0;j<listaAnteriores.getSize();j++){
                              Giro sum=(Giro)listaAnteriores.getObject(j);
                              if (sum.getAnulado()==false){
                                   net=net+sum.getNeto();
                                   tot=tot+sum.getTotal();
                              }
                           }
                          cierre.setNeto(String.valueOf(net)) ;
                          cierre.setTotal(String.valueOf(tot));
                          cierre.setIngreso(false);
                          cierre.setCierre1(true);
                          if (cierre.guardar()){
                             //  Mensaje.showError(this,"BIEN CARAJO ","Error");
       
                          }else{
                                Mensaje.showError(this,"SE PUDRIO TODO","Error");
                                }
                     }
            }
        }
 
    
} 
 private void cheq(){
     
     
      Boolean est=(false);
      
      
      cheque = new Cheque();
      boolean b = true;
      boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(oo,b, ciert));
      
      int tamanio = codigo.getSize();
      if(tamanio==0){
      
      }else{
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Cheques Protestados");
      
      int unidades=0;
      float o =0;
      for(int j=0;j<tamanio;j++){
           Cheque bainas=(Cheque)codigo.getObject(j);
            if (bainas.getGiro()!=null){
                                       o=o+bainas.getTotal();
                                       unidades=unidades+1;
                                       }else{
                                     }
           
         }
      cierre.setNumero(String.valueOf(unidades));
      cierre.setTotal(String.valueOf(o));
      cierre.setNeto("0");
      cierre.setHorario(oo);
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Valor del Protesto");
      
      int protesto=0;
      float p =0;
      for(int j=0;j<tamanio;j++){
           Cheque bainas=(Cheque)codigo.getObject(j);
           if (bainas.getGiro()!=null){
                                       p=p+bainas.getProtesto();
                                       
                                       }
           
         }
      cierre.setNumero(String.valueOf(unidades));
      cierre.setTotal(String.valueOf(p));
      cierre.setNeto("0");
      cierre.setHorario(oo);
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
    
      } 
     
 }
 private void ccobrar(){
      
             
              Boolean est=(false);
              Boolean gi=true;
              
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(oo, gi));

              int tamanio = codigo.getSize();
              if(tamanio==0){
            }else{
              cierre = new Cierre();
              cierre.setDesde("");
              cierre.setHasta("");
              cierre.setIngreso(false);
              cierre.setConcepto("Cuentas X Cobrar");
              cierre.setNumero(String.valueOf(tamanio));

              float o =0;

              for(int j=0;j<tamanio;j++){
                   CuentasXCobrar cxp1=(CuentasXCobrar)codigo.getObject(j);
                   o=o+cxp1.getCuota();
                 }
              cierre.setTotal(String.valueOf(o));
              cierre.setNeto("0");
              cierre.setHorario(oo);
              cierre.setCierre1(true);
             
              if (cierre.guardar()){
              //Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
              }
              } 
     
 }
private void dgiros(){
     //para que no se repitan los giros full quiromancias
     Agencia agencia = new Agencia();
     Agencia age= new Agencia();
     String cod ="PQ";
     age= agencia.Busca(cod);
     Giro sum = new Giro();
             
     
     Boolean est=(false);
     

     giro = new Giro();
     boolean b = true;
     codigo = new Lista(new Giro().lista18(oo, b));
     float o =0;    
     int num=0;
     int tamanio = codigo.getSize();
     if(tamanio==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(true);
                          cierre.setConcepto("Devolucion de Giros");
                          
                          
                          
                          Lista codigo=new Lista (new Agencia().lista());
                          int tamanio1 = codigo.getSize();
                          for(int j=0;j<tamanio1;j++){
                             agencia=(Agencia)codigo.getObject(j); 
                             if (agencia!=age){
                                 Lista codigo1 =new Lista(new Giro().lista8(oo, b, agencia)); 
                                 int tamanio2 = codigo1.getSize();
                                 if(tamanio2==0){
                                 }else{
                                      for(int i=0;i<tamanio2;i++){
                                       sum=(Giro)codigo1.getObject(i);
                                       o=o+sum.getTotal();
                                       num=num+1;
                                     }
                            }
                 }
              
                       }
                  cierre.setNumero(String.valueOf(num));
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(oo);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                   }
            } 
      
 }
 private void pgiros(){
     
                  
                  Boolean est=(false);
                 

                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista9(oo, b));

                  int tamanio = codigo.getSize();
                  if(tamanio==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Giros Pagados");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;

                  for(int j=0;j<tamanio;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(oo);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                   }
             }
 }
 private void cpagar(){

                 
                  Boolean est=(false);
                  
                  
                  boolean pagos =true;
                  cp = new CuentasXPagar();
                  codigo = new Lista(new CuentasXPagar().lista6(oo, pagos));

                  int tamanio = codigo.getSize();
                  if(tamanio==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Cuentas X Pagar");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;
                  for(int j=0;j<tamanio;j++){
                       CuentasXPagar cp1=(CuentasXPagar)codigo.getObject(j);
                       o=o+cp1.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(oo);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
                  }
                  } 
 }
 private void rgiro(){
 
      
                  
                  Boolean est=(false);
                 

                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista11(oo, b));

                  int tamanio = codigo.getSize();
                  if(tamanio==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Remplazo de Giros");
                  cierre.setNumero(String.valueOf(tamanio));

                  float o =0;
                  for(int j=0;j<tamanio;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();

                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(oo);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                ////  Mensaje.showError(this,"guardado los giros remplazados ","Error");
                  }
                  } 
      
 }
  private void goficina(){
 
     
                      Boolean est=(false);
                     

                      agencia = new Agencia();
                       String cod ="GO";
                      agencia = agencia.Busca(cod);

                      giro = new Giro();

                      codigo = new Lista(new Giro().lista2(agencia, oo));

                      int tamanio = codigo.getSize();

                      if(tamanio==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Giros de Oficina ");
                      cierre.setNumero(String.valueOf(tamanio));

                      float o =0;

                      for(int j=0;j<tamanio;j++){
                           Giro sum=(Giro)codigo.getObject(j);
                           o=o+sum.getTotal();
                         }
                      cierre.setTotal(String.valueOf(o));
                      cierre.setNeto("0");
                      cierre.setHorario(oo);
                      cierre.setCierre1(true);
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardado los giros de oficina ","Error");
                      }
                      } 
     
 
 }

    
 public void  sumas2(){
    
   
    Boolean est=(false);
    
    
    //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
      boolean ciert=false;
      codigo = new Lista(new Cheque().lista4(oo,b, ciert));
      float ches=0;
      float ches1=0;
      float ches2=0;
           
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j); 
             if (cheque.getGiro()==null){
                ches = ches+ cheque.getTotal();
                ches1 = ches1+ cheque.getUtilidad();
                ches2 = ches2+ cheque.getUtilidadche();
              }   
    }
double six = ((double)Math.round(ches*100))/100;
double si1x = ((double)Math.round(ches1*100))/100;
double si2x = ((double)Math.round(ches2*100))/100;


//*************************************SACO EL TOTAL DE INGRESOS 
    
    
    
    lista = new Lista(new Cierre().lista(oo, est, est));
    int ver=lista.getSize();
    float suma1=0;
    float util=0;
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
         util=suma1+ches2+ches1;
         double tres = ((double)Math.round(util*100))/100;
         
    }else{
    
    }
   //*************************************SCO LO EGRESOS
    Boolean es=(true);
    codigo = new Lista(new Cierre().lista(oo, es, est));
    int  ve=codigo.getSize();
    float suma2=0;
    
    if (ve !=0){
         Cierre cie = new Cierre();
         
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   double cuatro = ((double)Math.round(suma2*100))/100;
  
    }else{
     
    }
  float  to= util-suma2;
  double cinco = ((double)Math.round(to*100))/100;
 

//*************************************SACO EL efectivo
  Boolean cie=false;
 listaAnteriores = new Lista(new Billetes().lista(oo, cie));
  Billetes bill = new Billetes();
  int tamas=listaAnteriores.getSize();
  float efectivi=0;
  if (tamas<=0){
        
  }else{
        bill=(Billetes) listaAnteriores.getObject(0);
        efectivi=Float.parseFloat(bill.getTotal());
        
  }
  
  //*************************************SACO EL FALTANTE DE CAJA
  
  float faltante= to-(efectivi+ches);
  double seis = ((double)Math.round(faltante*100))/100;
  
 

//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(oo, cie));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   double siete = ((double)Math.round(cuenta*100))/100;           
 
              
}
    
public void  sumas(){
//Cieere de Money Trasmitter    
    
    Boolean est=(false);
    Boolean es=(true);
   
    
    //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
      boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(oo,b, ciert));
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





//*************************************SACO EL TOTAL DE INGRESOS  
    
    lista = new Lista(new Cierre().lista(oo, est, es));
    int ver=lista.getSize();
    float suma1=0;
    float utilidad=0;
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         //Mensaje.showMensaje(this,"ES el "+sum.getConcepto());
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
        utilidad=suma1;
        double us = ((double)Math.round(utilidad*100))/100;
     
    }else{
        suma1=0;
        
    }
   //*************************************SACO LO EGRESOS
    
    codigo = new Lista(new Cierre().lista(oo, es, es));
    int  ve=codigo.getSize();
    float suma2=0;
   //Mensaje.showMensaje(this,"LA cadena es "+ve);
    if (ve!=0){
        
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   double sisi = ((double)Math.round(suma2*100))/100;
   
    }else{
        suma2=0;
       
    }
  float  to= utilidad-suma2;
  double sil = ((double)Math.round(to*100))/100;
 
  
  //*************************************SACO EL efectivo
  Boolean cie=true;
 listaAnteriores = new Lista(new Billetes().lista(oo, cie));
  Billetes bill = new Billetes();
 int tamas=listaAnteriores.getSize();
 float efectv=0;
  if (tamas<=0){
        efectv=0;
       
        
  }else{
        
         for(int j=0;j<listaAnteriores.getSize();j++){
         bill=(Billetes)listaAnteriores.getObject(j);
         efectv= efectv+ Float.parseFloat(bill.getTotal());
       }
        double efes = ((double)Math.round(efectv*100))/100;
       
  }
 //*************************************SACO EL TOTAL DE LOS CREDITOS 
 float falta= to-(efectv+che);
 double fal = ((double)Math.round(falta*100))/100;
 

//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(oo, true));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   double credi = ((double)Math.round(cuenta*100))/100;          
            
             
}

  
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabelNombre2 = new javax.swing.JLabel();
        cboProductos = new javax.swing.JComboBox();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("VER CIEERES ANTERIORES");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 34, 290, -1));

        jButton3.setText("Ver el cieere General de las dos Agencias ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 260, -1));

        jLabelNombre2.setText("RESPONSABLE");
        add(jLabelNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 88, -1));

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });

        add(cboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 138, -1));

        lblFechaIngreso.setText("Hasta");
        add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 24));

        add(datFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 870, 440));

        lblFechaIngreso1.setText("Desde ");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 105, 24));

        add(datFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jButton1.setText("Ingresos LGMT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jButton2.setText("Egresos LGMT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jButton4.setText("Ingresos LG");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        jButton5.setText("Egresos LG");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        generarcierre();
        Boolean est=(false);
      
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        
        //*************************************SCO LO EGRESOS
        
        codigo = new Lista(new Cierre().lista(oo, es, est));
        int  ve=codigo.getSize();
        float suma2=0;
        float egre=0;
        
        if (ve !=0){
            Cierre cie = new Cierre();
            cie=(Cierre)lista.primero();
            
            for(int j=0;j<codigo.getSize();j++){
                Cierre sum=(Cierre)codigo.getObject(j);
                suma2= suma2+ Float.parseFloat(sum.getTotal());
            }
            egre=suma2;
        }else{
            egre=0;
        }
        
        
        //*************************************
        //*************************************
        
        try {
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(oo,anu, est)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL4);
            rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotale(egre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        generarcierre();
        Boolean est=(false);
       
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        //*************************************SACO LOs Ingresos
        lista = new Lista(new Cierre().lista(oo, est, est));
        int ver=lista.getSize();
        float suma1=0;
        float ingre=0;
        if (ver !=0){
            Cierre cie = new Cierre();
            cie=(Cierre)lista.primero();
            
            for(int j=0;j<lista.getSize();j++){
                Cierre sum=(Cierre)lista.getObject(j);
                suma1= suma1+ Float.parseFloat(sum.getTotal());
            }
            ingre=suma1;
        }else{
            ingre=0;
        }
        //*************************************
        
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(oo,est,est)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL3);
            rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotali(ingre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        generarcierre();
        Boolean est=(false);
      

         Date hora1;
         hora1=new Date();
         Boolean anu=true;
         Boolean es=(true);
 //*************************************SACO LO EGRESOS
    
    codigo = new Lista(new Cierre().lista(oo, es, es));
    int  ve=codigo.getSize();
    float suma2=0;
    float egre=0;
    if (ve !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
         egre=suma2;
       }else{
     egre=0;
    }
 
 //*************************************         
         
         
         
        try {
            
      ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(oo,anu, anu)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL2);
      rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
      rp.setDesde(hora1);
      rp.setTotale(egre);
      rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         generarcierre();
        Boolean est=(false);
        
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        //*************************************SACO LOs Ingresos
    lista = new Lista(new Cierre().lista(oo, est, true));
    int ver=lista.getSize();
    float suma1=0;
    float ingre=0;
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
  ingre=suma1;
    }else{
   ingre=0;
    }
        //*************************************
  
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(oo,est,true)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL3);
            rp.setRespon(oo.getUsuario().getNombre()+" "+oo.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotali(ingre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
    // TODO add your handling code here:
        otros = new Usuario();
        otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex()); 
        Date fecha= datFechaIngreso.getDate();
        Date fecha2=datFechaIngreso1.getDate();
      
        Lista betos = new Lista();
        betos = new Lista(new Horario().lista4(fecha, fecha2,otros)); 
        
       int fila=tblProducto.getSelectedRow();
      
       
       
       oo = new Horario();    
       oo=(Horario)betos.getObject(fila);
     
        //setPanel(gh);   
        
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed

        otros = new Usuario();
        otros =(Usuario) lista.getObject(cboProductos.getSelectedIndex()); 
        Date fecha= datFechaIngreso.getDate();
        Date fecha2=datFechaIngreso1.getDate();
      
        Lista betos = new Lista();
        betos = new Lista(new Horario().lista4(fecha, fecha2,otros)); 
             
              
 
         Mapa mapa = new Mapa(betos,Mapa.MAPAFINTURNO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
        
        
    }//GEN-LAST:event_jBuscarActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Date hora1;
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
       
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboProductos;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
    
}
