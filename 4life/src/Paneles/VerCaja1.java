/*
 * VerCaja1.java
 *
 * Created on 30 de enero de 2007, 12:13 AM
 */

package Paneles;

import beans.Remplazo;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.CierreFaltante;
import beans.anulargiro;
import beans.Cierre;
import beans.Agencia;
import beans.Cheque;
import beans.Billetes;
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
import beans.ComprasOficina;
import beans.PagoT;

import org.jdesktop.swingx.autocomplete.Configurator;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class VerCaja1 extends javax.swing.JPanel {
    
    private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private Agencia agencia;
    private CodigoAgencia codigos;
    private Horario horario;
    private CierreFaltante cierrefaltante;
    private Giro giro;
    private Giro fin;
    private Giro sum;
    
    private anulargiro anull;
    
    private Remplazo remplaz;
    
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    
    private Cheque cheque;
    private Cheque pri;
    private Cheque ultimito;
    private Cheque bainas;
    
    private ComprasOficina pras;
    private ComprasOficina pras1;
    
    private CuentasXCobrar cxp;
    private CuentasXCobrar cxp1;
    
    private CuentasXPagar cp;
    private CuentasXPagar cp1;
    
    private Billetes bill;
    private Billetes betos;
    
    private PagoT pg;
    private PagoT pg1;
    public int v=0;
    
    public VerCaja1() {
        initComponents();
        generarcierre();
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

public void  sumas(){
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
       // che1=che1+cheque.getNeto();
         che2 = che2+ cheque.getUtilidadche();
         
         }
    }
double si = ((double)Math.round(che*100))/100;
double si1 = ((double)Math.round(che1*100))/100;
double si2 = ((double)Math.round(che2*100))/100;
      
txtNeto2.setText(String.valueOf(si));
txtSobranteChe.setText(String.valueOf(si1));
txtUtilidadche.setText(String.valueOf(si2));


 //*************************************SACO EL efectivo
  Boolean cie=true;
 Billetes bill = new Billetes();
 listaAnteriores = new Lista(new Billetes().lista(otro, cie));

 int tamas=listaAnteriores.getSize();
 float efectv=0;
  if (tamas<=0){
        efectv=0;
        //txtEfectivo.setText(""+efectv);
  }else{
        
         for(int j=0;j<listaAnteriores.getSize();j++){
         
         bill=(Billetes)listaAnteriores.getObject(j);
         efectv= efectv+ Float.parseFloat(bill.getTotal());
       }
  double efec = ((double)Math.round(efectv*100))/100;     
        txtEfectivo.setText(""+efec);
  }
    
    lista = new Lista(new Cierre().lista(otro, est, es));
    int ver=lista.getSize();
    float suma1=0;
    float utilidad=0;
    if (ver !=0){
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
         utilidad=suma1;
         double util = ((double)Math.round(utilidad*100))/100;
         txtCodigo.setText(String.valueOf(util));
    }else{
     txtCodigo.setText("0");
    }
   //*************************************SACO LO EGRESOS
    
    codigo = new Lista(new Cierre().lista(otro, es, es));
    int  ve=codigo.getSize();
    float suma2=0;
    
    if (ve !=0){
      
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   
   double egre = ((double)Math.round(suma2*100))/100;
   txtNombre1.setText(String.valueOf(egre));
    }else{
     txtNombre1.setText("0");
    }
  float  tos= utilidad-suma2;
  double l = ((double)Math.round(tos*100))/100;
  txtAgente.setText(""+l);


//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista3(otro, true));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   double cre = ((double)Math.round(cuenta*100))/100;
   txtCredito.setText(String.valueOf(cre));           
 //*************************************SACO EL TOTAL DE LOS CREDITOS 
float to=0;
   if (txtAgente.getText().equals("")){
       to=0;
}else{
  to=Float.parseFloat(txtAgente.getText());     
}
 
 float falta= to-(efectv+che);
  double fal = ((double)Math.round(falta*100))/100;
  jTextField2.setText(""+fal);
  //*************************************SACO LOS INGRESOS                 
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
            int tamanio = listaAnteriores.getSize();
            if(tamanio==0){
        
            }else if (b1.getCodigo().equals("GO")){
            
                   }else if (b1.getCodigo().equals("PQ")){
            
                             }else{
                                    cierre.setConcepto(b1.getNombre());
                                    cierre.setNumero(String.valueOf(tamanio));
                                    giro = new Giro();
                                    giro = (Giro) listaAnteriores.primero();
                    //GUARDO EL PRIMER CODIGO
                    if (giro==null){
                                        
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
private void utilidadcheque(){
     
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
      cierre.setConcepto("Sobrante de Cheque");
               
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         if (cheque.getLgtrasmiter()==true ){
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
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Utilidad de Cheques");
      
               
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

//ni??????))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))
//la tontera de adelanto de deposito

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

  txtDeposito.setText(""+beto);
  otro.setAdelanto(beto);
  float and=0;
  float bet=0;
  if (txtAgente.getText().equals("")){
      and=0;
  }else{
      and=Float.parseFloat(txtAgente.getText());
  }
   
  bet=and-beto;
 
   double deg = ((double)Math.round(bet*100))/100;
   
  txtDeposito1.setText(""+deg);
  String col=String.valueOf(deg);
  
  otro.setDepoT(Float.parseFloat(col));
  otro.actualizar();
      } 
     
 }


//*********************************************************
//qui van los cheques protestador
//*********************************************************
 private void cheq(){
     
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      cheque = new Cheque();
      boolean b = true;
        boolean ciert=true;
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
   //        Mensaje.showMensaje(this,"Llega a ver si diferente de nulo el giro "+bainas.getNumero());
           if (bainas.getGiro()!=null){
                                 //      Mensaje.showMensaje(this,"no es nulo"+bainas.getNumero());
                                       o=o+bainas.getTotal();
                                       unidades=unidades+1;
                                       }else{
                                      // Mensaje.showMensaje(this,"si es nulo "+bainas.getNumero());
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
      for(int j=0;j<tamanio;j++){
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
              cierre.setCierre1(true);
              
              if (cierre.guardar()){
            //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
              }
              } 
     
 }
 
 
private void generarcierre(){
       cie();
       agencias();
       utilidadcheque();
       cheq();
       ccobrar();
       cie1();
       dgiros();
       pgiros();
       cpagar();
       rgiro();
       goficina();
       FaltanteCierre();
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
                      codigo = new Lista(new ComprasOficina().lista3(otro));

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

 private void FaltanteCierre(){
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
     int tamanio = codigo.getSize();
     if(tamanio==0){

                    }else{
                          cierre = new Cierre();
                          cierre.setDesde("");
                          cierre.setHasta("");
                          cierre.setIngreso(true);
                          cierre.setConcepto("Devolucion de Giros");
                          
                          for(int i=0;i<tamanio;i++){
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
                  cierre.setHorario(otro);
                  cierre.setCierre1(true);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los giros pagados ","Error");
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
                  codigo = new Lista(new CuentasXPagar().lista6(otro,pagos));

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
                       remplaz=(Remplazo)codigo.getObject(j);
                       if (remplaz==null){
                           Mensaje.showMensaje(this,"Es nulo");
                       }else{
                         Mensaje.showMensaje(this,"No es  nulo");
                         Mensaje.showMensaje(this,"el valor de giro es "+remplaz.getGiro().getTotal());
                         o=o+remplaz.getGiro().getTotal();  
                       }
                       

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
                      cierre.setHorario(otro);
                      cierre.setCierre1(true);
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardado los giros de oficina ","Error");
                      }
                      } 
     
 
 }
  private void setTabla(){
      
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      
      Boolean anu=false;
      Boolean es=true;
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, es));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRE,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
      //jXTable1.setModel(modelo);
      jXTable2.setModel(modelo);
     
     }
    
 private void setTabla2(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      Boolean anu=true;
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, anu));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRE,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
     // jXTable1.setModel(modelo);
       jXTable2.setModel(modelo);
     
     }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jLabelCivil7 = new javax.swing.JLabel();
        txtNeto2 = new javax.swing.JTextField();
        jLabelCivil8 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtSobranteChe = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtUtilidadche = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelCivil9 = new javax.swing.JLabel();
        txtDeposito = new javax.swing.JTextField();
        jLabelCivil10 = new javax.swing.JLabel();
        txtDeposito1 = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        jLabelCivil16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        txtDeposito2 = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                   CIERRE DE CAJA DE L.G. MONEY TRANSMITTER");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 9, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 21, 0);
        add(jLabelCreditopendiente3, gridBagConstraints);

        datFechaIngreso.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre1.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCodigo.setBorder(null);
        txtCodigo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtCodigo, gridBagConstraints);

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        txtNombre1.setEditable(false);
        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNombre1, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil2.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtAgente.setEditable(false);
        txtAgente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtAgente.setAutoscrolls(false);
        txtAgente.setBorder(null);
        txtAgente.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtAgente, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil7.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil7, gridBagConstraints);

        txtNeto2.setEditable(false);
        txtNeto2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto2.setBorder(null);
        txtNeto2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtNeto2, gridBagConstraints);

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil8.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil8, gridBagConstraints);

        txtCredito.setEditable(false);
        txtCredito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCredito.setBorder(null);
        txtCredito.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtCredito, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil6.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

        txtSobranteChe.setEditable(false);
        txtSobranteChe.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtSobranteChe.setBorder(null);
        txtSobranteChe.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtSobranteChe.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtSobranteChe, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil5.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil5.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil5, gridBagConstraints);

        txtUtilidadche.setEditable(false);
        txtUtilidadche.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtUtilidadche.setBorder(null);
        txtUtilidadche.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtUtilidadche.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtUtilidadche, gridBagConstraints);

        jButton1.setText("Ver Ingreso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jButton1, gridBagConstraints);

        jButton2.setText("Ver Egresos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton2, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(txtNombre, gridBagConstraints);

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
        jXTable2.setColumnControlVisible(true);
        jScrollPane2.setViewportView(jXTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton4.setText("Imprimir Cierre Total");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton4, gridBagConstraints);

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton5, gridBagConstraints);

        jButton6.setText("Imprimir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton6, gridBagConstraints);

        jLabelCivil9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil9.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil9, gridBagConstraints);

        txtDeposito.setEditable(false);
        txtDeposito.setFont(new java.awt.Font("Arial Black", 1, 12));
        txtDeposito.setForeground(new java.awt.Color(0, 0, 255));
        txtDeposito.setBorder(null);
        txtDeposito.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtDeposito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 32, 0, 0);
        add(txtDeposito, gridBagConstraints);

        jLabelCivil10.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil10.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil10.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 37, 0, 0);
        add(jLabelCivil10, gridBagConstraints);

        txtDeposito1.setEditable(false);
        txtDeposito1.setFont(new java.awt.Font("Arial Black", 1, 12));
        txtDeposito1.setForeground(new java.awt.Color(0, 0, 255));
        txtDeposito1.setBorder(null);
        txtDeposito1.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtDeposito1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtDeposito1, gridBagConstraints);

        txtEfectivo.setEditable(false);
        txtEfectivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtEfectivo.setBorder(null);
        txtEfectivo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 0);
        add(txtEfectivo, gridBagConstraints);

        jLabelCivil16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil16.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil16, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel2.setText("Faltante de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 0);
        add(jLabel2, gridBagConstraints);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField2.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(jTextField2, gridBagConstraints);

        txtDeposito2.setEditable(false);
        txtDeposito2.setFont(new java.awt.Font("Arial Black", 1, 12));
        txtDeposito2.setForeground(new java.awt.Color(0, 0, 255));
        txtDeposito2.setBorder(null);
        txtDeposito2.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtDeposito2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtDeposito2, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        //*************************************SACO LOs Ingresos
    lista = new Lista(new Cierre().lista(hora, est, true));
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
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(hora,est,true)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL3);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotali(ingre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        
        
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);

         Date hora1;
         hora1=new Date();
         Boolean anu=true;
         Boolean es=(true);
 //*************************************SACO LO EGRESOS
    
    codigo = new Lista(new Cierre().lista(hora, es, es));
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
            
      ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(hora,anu, anu)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL2);
      rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
      rp.setDesde(hora1);
      rp.setTotale(egre);
      rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);

         Date hora1;
         hora1=new Date();
         Boolean anu=true;
         Boolean es=(true);
         
 //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
        boolean ciert=true;
      codigo = new Lista(new Cheque().lista4(hora,b, ciert));
      float che=0;
      float che1=0;
      float che2=0;
   
             
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         if (cheque.getGiro()!=null){
         che = che+ cheque.getTotal();
         che1 = che1+ cheque.getUtilidad();
         che2 = che2+ cheque.getUtilidadche();
         }
    }

 //*************************************SACO LOs Ingresos
    lista = new Lista(new Cierre().lista(hora, est, es));
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
    
    //*************************************SACO LOs EGRESOS
    Boolean mie=true;
    float egres=0;
    lista = new Lista(new Cierre().lista(hora, mie, es));
   
    if (ver !=0){
         
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
               egres=suma1;
    }else{
    egres=0;
    }
    
  //(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    //nininininininininininininininininininininininininininisaco utilidad
    float neto=ingre-egres;   
  //*************************************SACO EL efectivo
  Boolean cie=true;
 listaAnteriores = new Lista(new Billetes().lista(hora, cie));
  Billetes bill = new Billetes();
 int tamas=listaAnteriores.getSize();
 float efectv=0;
  if (tamas<=0){
        efectv=0;
       // txtEfectivo.setText(""+efectv);
  }else{
        bill=(Billetes) listaAnteriores.getObject(0);
        efectv=Float.parseFloat(bill.getTotal());
   //     txtEfectivo.setText(""+efectv);
  }
 //*************************************SACO EL TOTAL DE LOS CREDITOS 
 float falta= neto-(efectv+che);
     
    
        try {
            
      ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista2(hora,anu)),Mapa.MAPAREPORTECIERRE,true),ReportePrevio.CIERREGMT);
      rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
      rp.setDesde(hora1);
      rp.setTotali(ingre);
      rp.setTotale(Float.parseFloat(txtNombre1.getText()));
      rp.setUtilidad(Float.parseFloat(txtAgente.getText()));
      rp.setFaltante(Float.parseFloat(jTextField2.getText()));
      rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
      
      rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setTabla();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil10;
    private javax.swing.JLabel jLabelCivil16;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCivil7;
    private javax.swing.JLabel jLabelCivil8;
    private javax.swing.JLabel jLabelCivil9;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtDeposito;
    private javax.swing.JTextField txtDeposito1;
    private javax.swing.JTextField txtDeposito2;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtNeto2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtSobranteChe;
    private javax.swing.JTextField txtUtilidadche;
    // End of variables declaration//GEN-END:variables
    
}
