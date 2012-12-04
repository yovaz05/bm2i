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
        generarcierre();
        horarios ();
    }
    private void generarcierre(){
       moneytrasmiter();     
      // sumas();
      // sumas2();
       lgtravel();
        horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    oo=otro;
       
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
       ventascredito();
       FaltanteCierre();
       sumas2();
       adelantoLG();
   }
 
         private void ventascredito(){
        
        
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
            int tamaño = lista.getSize();
            if(tamaño==0){
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
     int tamaño = codigo.getSize();
     if(tamaño==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(false);
                          cierre.setConcepto("Faltante de Otros Cierres");
                          
                          for(int j=0;j<tamaño;j++){
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
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
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
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
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
      
            int tamaño = codigo.getSize();
            if(tamaño==0){
      
            }else{  
                flores=(Flores) codigo.primero();
                ult=(Flores) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(String.valueOf(flores.getFactura()));
                cierre.setHasta(String.valueOf(ult.getFactura()));
                cierre.setIngreso(false);
                cierre.setConcepto("Flores");
                cierre.setNumero(String.valueOf(tamaño));
      
                float tot =0;
                for(int j=0;j<tamaño;j++){
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
      
            int tamaño = codigo.getSize();
            if(tamaño==0){
            
            }else{
                pasajes=(Pasajes) codigo.primero();
                ul=(Pasajes) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(" ");
                cierre.setHasta(" ");
                cierre.setIngreso(false);
                cierre.setConcepto("Pasajes");
                cierre.setNumero(String.valueOf(tamaño));
      
                float to =0;
                for(int j=0;j<tamaño;j++){
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
      
            int tamaño = codigo.getSize();
            if(tamaño==0){
            
            }else{
                video=(VideoConferencia) codigo.primero();
                vid=(VideoConferencia) codigo.ultimo();
                cierre = new Cierre();
                
                cierre.setHasta(String.valueOf(video.getNumero()));
                cierre.setDesde(String.valueOf(vid.getNumero()));
                cierre.setIngreso(false);
                cierre.setConcepto("Video Conferencia");
                cierre.setNumero(String.valueOf(tamaño));
      
                float to =0;
                for(int j=0;j<tamaño;j++){
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
      
            int tamaño = codigo.getSize();
            if(tamaño==0){
      
            }else{
                cabinas=(Cabinas) codigo.primero();
                ultimo=(Cabinas) codigo.ultimo();
                cierre = new Cierre();
                cierre.setDesde(" ");
                cierre.setHasta(" ");
                cierre.setIngreso(false);
                cierre.setConcepto("Cabinas");
                cierre.setNumero(String.valueOf(tamaño));
      
                float o =0;
                for(int j=0;j<tamaño;j++){
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
            otros = new Otros();
            int p;
            horario=new Horario();
            Horario otro = new Horario();
            Boolean est=(false);
            otro=horario.buscar(est);
            txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
 
            lista = new Lista(new VentaProductos().lista2(otro));
            for(int i=0;i<lista.getSize();i++){
                    venta =(VentaProductos) lista.getObject(i);
                    int tamaño = lista.getSize();
                    if(tamaño==0){
                    }else{
                        cierre = new Cierre();
                       // Mensaje.showMensaje(this,"La agencia es "+venta.getOtros().getNombre());
                        if(Integer.parseInt(venta.getContado())>0){
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
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
      }else{
      
      cierre = new Cierre();
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Cheques Protestados");
      
      int unidades=0;
      float o =0;
      for(int j=0;j<tamaño;j++){
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
      for(int j=0;j<tamaño;j++){
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
                //  Mensaje.showMensaje(this,"Cual es teamaño "+agencia.getNombre());
                  giro = new Giro();
                  boolean b = false;
                  codigo = new Lista(new Giro().lista10(agencia, otro, b));

                  int tamaño = codigo.getSize();

                  if(tamaño==0){
               //   Mensaje.showMensaje(this,"Cual es teamaño "+tamaño);
                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(false);
                  cierre.setConcepto("Paquetes ");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;

                  for(int j=0;j<tamaño;j++){
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

              int tamaño = codigo.getSize();
              if(tamaño==0){

              }else{

              cierre = new Cierre();
              cierre.setDesde("");
              cierre.setHasta("");
              cierre.setIngreso(false);
              cierre.setConcepto("Cuentas X Cobrar");
              cierre.setNumero(String.valueOf(tamaño));

              float o =0;

              for(int j=0;j<tamaño;j++){
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
     
     anulargiro anull = new anulargiro();

     codigo = new Lista(new anulargiro().lista2(otro));
     float o =0;    
     int num=0;
     int tamaño = codigo.getSize();
     if(tamaño==0){
     
     
     }else{
             for(int i=0;i<tamaño;i++){
                                       anull=(anulargiro)codigo.getObject(i);
                                       if (anull.getGiro().getAgencia().getCodigo().equals("PQ")){
                                          o=o+anull.getGiro().getTotal();
                                       num=num+1;   
                                       }
                                       
                             } 
         if (num==0){
                 
         }else{
            cierre = new Cierre();
            cierre.setDesde("");
            cierre.setHasta("");
            cierre.setIngreso(true);
            cierre.setConcepto("Paquetes Devueltos ");
            cierre.setNumero(String.valueOf(tamaño));
            cierre.setTotal(String.valueOf(o));
            cierre.setNeto("0");
            cierre.setHorario(otro);
            cierre.setCierre1(false);
            if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los paquetes devueltos ","Error");
            }      
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

                  int tamaño = codigo.getSize();
                  if(tamaño==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Cuentas X Pagar");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;
                  for(int j=0;j<tamaño;j++){
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

                      int tamaño = codigo.getSize();
                      if(tamaño==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Compras de Oficina");
                      cierre.setNumero(String.valueOf(tamaño));

                      float o =0;
                      for(int j=0;j<tamaño;j++){
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
                  int tamaño = codigo.getSize();

                  if(tamaño==0){
                  }else{
                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Pago Facturas de Tarjetas ");
                      cierre.setNumero(String.valueOf(tamaño));
                      float o =0;
                      for(int j=0;j<tamaño;j++){
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

                      int tamaño = codigo.getSize();
                      if(tamaño==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Compras de Oficina");
                      cierre.setNumero(String.valueOf(tamaño));

                      float o =0;
                      for(int j=0;j<tamaño;j++){
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
     int tamaño = codigo.getSize();
     if(tamaño==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(false);
                          cierre.setConcepto("Faltante de Otros Cierres");
                          
                          for(int j=0;j<tamaño;j++){
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
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
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
  txtAdelantoMT.setText(""+si1);
  String as=String.valueOf(si1);
  otro.setAdelanto(Float.parseFloat(as));
  float and=0;
  float bet=0;
  if (txtUNeta.getText().equals("")){
      and=0;
  }else{
      and=Float.parseFloat(txtUNeta.getText());
  }
   
  bet=and-beto;
  double si2 = ((double)Math.round(bet*100))/100;
  
  txtDepositoMT.setText(""+si2);
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
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
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
    txtNombre.setText(otro.getUsuario().getNombre());
    txtApellido.setText(otro.getUsuario().getApellido());
    txtIngreso.setText(""+otro.getFechaInicio());
    txtSalida.setText(""+otro.getFechaFin());
    
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
                       txtNombre2.setText("0"+" - "+minutollegada+" - "+segundo);
                      }else{
                      txtNombre2.setText(""+horallegada+" - "+minutollegada+" - "+segundo);
                       }
    txtApellido1.setText("0");
}

public void  cie(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    Boolean es=(true);
    lista = new Lista(new Cierre().lista(otro, est, es));
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

private void agencias(){
     
  
        agencia = new Agencia();
        lista = new Lista(new Agencia().lista());

        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
 
        for(int i=0;i<lista.getSize();i++){
            cierre = new Cierre();
            Agencia b1=(Agencia) lista.getObject(i);
            listaAnteriores =new Lista(new Giro().lista19(otro,b1)); 
            //EL NUMERO DE GIROS
            int tamaño = listaAnteriores.getSize();
            if(tamaño==0){
        
            }else{
                    cierre.setConcepto(b1.getNombre());
                    cierre.setNumero(String.valueOf(tamaño));
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
                                        cierre.setHorario(otro);
                                        fin = new Giro();
                         
                                        float net =0;
                                        float tot =0;
                          for(int j=0;j<listaAnteriores.getSize();j++){
                              Giro sum=(Giro)listaAnteriores.getObject(j);
                              if (sum.getPagado()!=true){
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
     
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      cheque = new Cheque();
      boolean b = true;
      boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
      
      int tamaño = codigo.getSize();
      if(tamaño==0){
      
      }else{
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Cheques Protestados");
      
      int unidades=0;
      float o =0;
      for(int j=0;j<tamaño;j++){
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
      cierre.setHorario(otro);
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
      for(int j=0;j<tamaño;j++){
           Cheque bainas=(Cheque)codigo.getObject(j);
           if (bainas.getGiro()!=null){
                                       p=p+bainas.getProtesto();
                                       
                                       }
           
         }
      cierre.setNumero(String.valueOf(unidades));
      cierre.setTotal(String.valueOf(p));
      cierre.setNeto("0");
      cierre.setHorario(otro);
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
    
      } 
     
 }
 private void ccobrar(){
      
              horario=new Horario();
              Horario otro = new Horario();
              Boolean est=(false);
              otro=horario.buscar(est);
              Boolean gi=true;
              
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(otro, gi));

              int tamaño = codigo.getSize();
              if(tamaño==0){
            }else{
              cierre = new Cierre();
              cierre.setDesde("");
              cierre.setHasta("");
              cierre.setIngreso(false);
              cierre.setConcepto("Cuentas X Cobrar");
              cierre.setNumero(String.valueOf(tamaño));

              float o =0;

              for(int j=0;j<tamaño;j++){
                   CuentasXCobrar cxp1=(CuentasXCobrar)codigo.getObject(j);
                   o=o+cxp1.getCuota();
                 }
              cierre.setTotal(String.valueOf(o));
              cierre.setNeto("0");
              cierre.setHorario(otro);
              cierre.setCierre1(true);
             
              if (cierre.guardar()){
              //Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
              }
              } 
     
 }
private void dgiros(){
   ////para que no se repitan los giros full quiromancias
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);
     
     anulargiro anull = new anulargiro();

     codigo = new Lista(new anulargiro().lista2(otro));
     float o =0;    
     int num=0;
     int tamaño = codigo.getSize();
     if(tamaño==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(true);
                          cierre.setConcepto("Devolucion de Giros");
                          
                          for(int i=0;i<tamaño;i++){
                                       anull=(anulargiro)codigo.getObject(i);
                                       if (anull.getGiro().getAgencia().getCodigo().equals("PQ")){
                                           
                                       }else{
                                       o=o+anull.getGiro().getTotal();
                                       num=num+1;  
                                       }
                                       
                             }            

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
 private void pgiros(){
     
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);

                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista9(otro, b));

                  int tamaño = codigo.getSize();
                  if(tamaño==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Giros Pagados");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;

                  for(int j=0;j<tamaño;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                   }
             }
 }
 private void cpagar(){

                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);
                  
                  boolean pagos =true;
                  cp = new CuentasXPagar();
                  codigo = new Lista(new CuentasXPagar().lista6(otro, pagos));

                  int tamaño = codigo.getSize();
                  if(tamaño==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Cuentas X Pagar");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;
                  for(int j=0;j<tamaño;j++){
                       CuentasXPagar cp1=(CuentasXPagar)codigo.getObject(j);
                       o=o+cp1.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
                  }
                  } 
 }
 private void rgiro(){
 
      
                                    horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);
                  
                  Remplazo remplaz=new Remplazo();
                  
                  
                  codigo = new Lista(new Remplazo().lista2(otro));

                  int tamaño = codigo.getSize();
                  if(tamaño==0){

                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Remplazo de Giros");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;
                  for(int j=0;j<tamaño;j++){
                       remplaz=(Remplazo)codigo.getObject(j);
                       o=o+remplaz.getGiro().getTotal();

                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                ////  Mensaje.showError(this,"guardado los giros remplazados ","Error");
                  }
                  }
      
 }
  private void goficina(){
 
     
                      horario=new Horario();
                      Horario otro = new Horario();
                      Boolean est=(false);
                      otro=horario.buscar(est);

                      agencia = new Agencia();
                       String cod ="GO";
                      agencia = agencia.Busca(cod);

                      giro = new Giro();

                      codigo = new Lista(new Giro().lista2(agencia, otro));

                      int tamaño = codigo.getSize();

                      if(tamaño==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Giros de Oficina ");
                      cierre.setNumero(String.valueOf(tamaño));

                      float o =0;

                      for(int j=0;j<tamaño;j++){
                           Giro sum=(Giro)codigo.getObject(j);
                           o=o+sum.getTotal();
                         }
                      cierre.setTotal(String.valueOf(o));
                      cierre.setNeto("0");
                      cierre.setHorario(otro);
                      cierre.setCierre1(true);
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardado los giros de oficina ","Error");
                      }
                      } 
     
 
 }

    
 public void  sumas2(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    
    //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
      boolean ciert=false;
      codigo = new Lista(new Cheque().lista4(otro,b, ciert));
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

txtNeto3.setText(String.valueOf(six));
txtChequesSobrante.setText(String.valueOf(si2x));
txtChequeUtil.setText(String.valueOf(si1x));
//*************************************SACO EL TOTAL DE INGRESOS 
    
    
    
    lista = new Lista(new Cierre().lista(otro, est, est));
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
         txtCodigo.setText(String.valueOf(tres));
    }else{
     txtCodigo.setText("0");
    }
   //*************************************SCO LO EGRESOS
    Boolean es=(true);
    codigo = new Lista(new Cierre().lista(otro, es, est));
    int  ve=codigo.getSize();
    float suma2=0;
    
    if (ve !=0){
         Cierre cie = new Cierre();
         
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   double cuatro = ((double)Math.round(suma2*100))/100;
   txtNombre1.setText(String.valueOf(cuatro));
    }else{
     txtNombre1.setText("0");
    }
  float  to= util-suma2;
  double cinco = ((double)Math.round(to*100))/100;
  txtAgente.setText(""+cinco);

//*************************************SACO EL efectivo
  Boolean cie=false;
 listaAnteriores = new Lista(new Billetes().lista(otro, cie));
  Billetes bill = new Billetes();
  int tamas=listaAnteriores.getSize();
  float efectivi=0;
  if (tamas<=0){
        txtEfec.setText(""+efectivi);
  }else{
        bill=(Billetes) listaAnteriores.getObject(0);
        efectivi=Float.parseFloat(bill.getTotal());
        txtEfec.setText(""+efectivi);
  }
  
  //*************************************SACO EL FALTANTE DE CAJA
  
  float faltante= to-(efectivi+ches);
  double seis = ((double)Math.round(faltante*100))/100;
  jTextField1.setText(""+seis);
 

//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(otro, cie));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   double siete = ((double)Math.round(cuenta*100))/100;           
   txtCredito1.setText(String.valueOf(siete));           
              
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
         suma1= suma1+ Float.parseFloat(sum.getTotal());
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
         suma2= suma2+ Float.parseFloat(sum.getTotal());
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

  
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
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

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(51, 153, 0));
        jLabelCreditopendiente1.setText("           LG MONEY TRASNMITTER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
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

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil2.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil2, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil4.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil4, gridBagConstraints);

        txtTIngresos.setEditable(false);
        txtTIngresos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtTIngresos.setBorder(null);
        txtTIngresos.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtTIngresos, gridBagConstraints);

        txtTEgresos.setEditable(false);
        txtTEgresos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
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
        txtUNeta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtUNeta.setAutoscrolls(false);
        txtUNeta.setBorder(null);
        txtUNeta.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtUNeta, gridBagConstraints);

        txtEfectivo.setEditable(false);
        txtEfectivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtEfectivo.setBorder(null);
        txtEfectivo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtEfectivo, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil5.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil5, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil6.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil8.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil8, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil7.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelCivil7, gridBagConstraints);

        txtSoCheque.setEditable(false);
        txtSoCheque.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
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
        txtSobranteChe.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
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
        txtCredito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
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
        txtNeto2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto2.setBorder(null);
        txtNeto2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNeto2, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                                                     CIERRE TOTAL DE CAJA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente2, gridBagConstraints);

        jLabelCreditopendiente4.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente4.setForeground(new java.awt.Color(51, 153, 0));
        jLabelCreditopendiente4.setText("             CIERRE  TOTAL DE LG TRAVEL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente4, gridBagConstraints);

        jLabelCreditopendiente5.setFont(new java.awt.Font("Arial Black", 0, 12));
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

        jLabelNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre2.setText("Horas Trabajadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre2, gridBagConstraints);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCodigo.setBorder(null);
        txtCodigo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtCodigo, gridBagConstraints);

        jLabelApellido3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido3.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido3, gridBagConstraints);

        txtNombre1.setEditable(false);
        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNombre1, gridBagConstraints);

        jLabelCivil3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil3.setText("Faltante Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil3, gridBagConstraints);

        txtAgente.setEditable(false);
        txtAgente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtAgente.setAutoscrolls(false);
        txtAgente.setBorder(null);
        txtAgente.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtAgente, gridBagConstraints);

        jLabelCivil9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil9.setText("Fecha de salida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil9, gridBagConstraints);

        txtEfec.setEditable(false);
        txtEfec.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtEfec.setBorder(null);
        txtEfec.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtEfec, gridBagConstraints);

        jLabelCivil10.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil10.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil10, gridBagConstraints);

        txtChequesSobrante.setEditable(false);
        txtChequesSobrante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtChequesSobrante.setBorder(null);
        txtChequesSobrante.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtChequesSobrante.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtChequesSobrante, gridBagConstraints);

        jLabelCivil11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil11.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil11, gridBagConstraints);

        txtChequeUtil.setEditable(false);
        txtChequeUtil.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtChequeUtil.setBorder(null);
        txtChequeUtil.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtChequeUtil.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtChequeUtil, gridBagConstraints);

        jLabelCivil12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil12.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil12, gridBagConstraints);

        txtNeto3.setEditable(false);
        txtNeto3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto3.setBorder(null);
        txtNeto3.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNeto3, gridBagConstraints);

        txtCredito1.setEditable(false);
        txtCredito1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCredito1.setBorder(null);
        txtCredito1.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtCredito1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
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

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel2.setText("Faltante de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabelNombre3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre3.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 39, 0, 0);
        add(jLabelNombre3, gridBagConstraints);

        jLabelCivil14.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil14.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil14, gridBagConstraints);

        jLabelCreditopendiente6.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente6.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente6.setText("                                          DATOS DE LA PERSONA ENCARGADA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 9, 0);
        add(jLabelCreditopendiente6, gridBagConstraints);

        jLabelNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre4.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre4, gridBagConstraints);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtNombre, gridBagConstraints);

        jLabelApellido4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido4.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido4, gridBagConstraints);

        txtIngreso.setEditable(false);
        txtIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtIngreso.setBorder(null);
        txtIngreso.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtIngreso, gridBagConstraints);

        jLabelCivil15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil15.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil15, gridBagConstraints);

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtApellido.setAutoscrolls(false);
        txtApellido.setBorder(null);
        txtApellido.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtApellido, gridBagConstraints);

        jLabelCivil16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil16.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil16, gridBagConstraints);

        txtSalida.setEditable(false);
        txtSalida.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtSalida.setBorder(null);
        txtSalida.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtSalida, gridBagConstraints);

        jLabelNombre5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre5, gridBagConstraints);

        txtNombre2.setEditable(false);
        txtNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre2.setBorder(null);
        txtNombre2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtNombre2, gridBagConstraints);

        jLabelCivil17.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil17.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelCivil17, gridBagConstraints);

        txtApellido1.setEditable(false);
        txtApellido1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtApellido1.setAutoscrolls(false);
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

        jLabelCivil13.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil13.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil13.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil13, gridBagConstraints);

        txtAdelantoMT.setEditable(false);
        txtAdelantoMT.setFont(new java.awt.Font("Arial Black", 1, 12));
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

        jLabelCivil18.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil18.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil18.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil18, gridBagConstraints);

        txtDepositoMT.setEditable(false);
        txtDepositoMT.setFont(new java.awt.Font("Arial Black", 1, 12));
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

        jLabelCivil19.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil19.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil19.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil19, gridBagConstraints);

        txtAdelantoLG.setEditable(false);
        txtAdelantoLG.setFont(new java.awt.Font("Arial Black", 1, 12));
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

        jLabelCivil20.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil20.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil20.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil20, gridBagConstraints);

        txtDepositoLG.setEditable(false);
        txtDepositoLG.setFont(new java.awt.Font("Arial Black", 1, 12));
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
