/*
 * PanelCierre.java
 *
 * Created on 7 de noviembre de 2006, 20:28
 */

package Paneles;

import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Cierre;
import beans.Agencia;
import beans.Flores;
import beans.Pasajes;
import beans.Cabinas;
import beans.Otros;
import beans.VentaProductos;
import beans.Cheque;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.CuentasXCobrar;
import beans.CuentasXPagar;
import beans.ComprasOficina;
import beans.PagoT;
import beans.VideoConferencia;
import reportesXML.ReportePrevio;
public class PanelCierre extends javax.swing.JPanel {
    
    private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private Agencia agencia;
    private CodigoAgencia codigos;
    private Horario horario;
   
    private Giro giro;
    private Giro fin;
    private Giro sum;
    
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
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

    private Cheque cheque;
    private Cheque pri;
    private Cheque ultimito;
    private Cheque bainas;
    
    private CuentasXCobrar cxp;
    private CuentasXCobrar cxp1;
    
    private CuentasXPagar cp;
    private CuentasXPagar cp1;
    
    private ComprasOficina pras;
    private ComprasOficina pras1;
       
    private PagoT pg;
    private PagoT pg1;
    public int v=0;
public PanelCierre() {
       initComponents();
       generarcierre();
}


public void  cie(){
    
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
public void  cie1(){
    
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
public void  sumas(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, est, est));
    int ver=lista.getSize();
    float suma1=0;
    
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
   txtCodigo.setText(String.valueOf(suma1));
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
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
   txtNombre1.setText(String.valueOf(suma2));
    }else{
     txtNombre1.setText("0");
    }
  float  to= suma1-suma2;
  txtAgente.setText(""+to);


 //*************************************SACO EL TOTAL DE CHEQUES     
      cheque = new Cheque();
      boolean b = false;
      codigo = new Lista(new Cheque().lista4(otro,b,b));
      float che=0;
      float che1=0;
      float che2=0;
   
             
      for(int j=0;j<codigo.getSize();j++){
         cheque=(Cheque)codigo.getObject(j);
         che = che+ cheque.getTotal();
         che1 = che1+ cheque.getUtilidad();
         che2 = che2+ cheque.getUtilidadche();
    }
txtNeto2.setText(String.valueOf(che));
txtSobranteChe.setText(String.valueOf(che2));
txtUtilidadche.setText(String.valueOf(che1));

//*************************************SACO EL TOTAL DE LOS CREDITOS 
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista5(otro));
              float cuenta =0;
              for(int j=0;j<codigo.getSize();j++){
                 cxp=(CuentasXCobrar)codigo.getObject(j);
                 cuenta = cuenta+ cxp.getCuota();
              }
   txtCredito.setText(String.valueOf(cuenta));           
              
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
                              net=net+sum.getNeto();
                              tot=tot+sum.getTotal();
                           }
                          cierre.setNeto(String.valueOf(net)) ;
                          cierre.setTotal(String.valueOf(tot));
                          cierre.setIngreso(false);
                          if (cierre.guardar()){
                             //  Mensaje.showError(this,"BIEN CARAJO ","Error");
       
                          }else{
                                Mensaje.showError(this,"SE PUDRIO TODO","Error");
                                }
                     }
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
                cierre.setHasta(String.valueOf(flores.getFactura()));
                cierre.setDesde(String.valueOf(ult.getFactura()));
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
                if (cierre.guardar()){
     // Mensaje.showError(this,"ya se guardo ","Error");
                 }
            } 
      

  }
 private void venats(){
   
    
            venta = new VentaProductos();
            otros = new Otros();
          
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
                        
                       
                        cierre.setConcepto(venta.getOtros().getNombre());
                        cierre.setIngreso(false);
                        cierre.setHorario(otro);
                        cierre.setDesde(" ");
                        cierre.setHasta(" ");
                        cierre.setNeto(" ");
                        cierre.setTotal(String.valueOf(venta.getTotal()));
                        if (cierre.guardar()){
                        //   Mensaje.showError(this,"BIEN CARAJO ","Error");
                         }else{
                            Mensaje.showError(this,"SE PUDRIO TODO","Error");
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
      codigo = new Lista(new Cheque().lista4(otro,b, b));
      
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
      cierre.setCierre1(true);
      if (cierre.guardar()){
         }
  
//Aqui pongo el total del saldo de los cheques protesto el valor de protesto
      
      cierre = new Cierre();
      
      cierre.setHasta("");
      cierre.setDesde("");
      cierre.setIngreso(false);
      cierre.setConcepto("Vaolor del Protesto");
      
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
             
              
              cxp = new CuentasXCobrar();
              codigo = new Lista(new CuentasXCobrar().lista5(otro));

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
            //  Mensaje.showError(this,"guardado las cuentas por cobrar ","Error");
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
             
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     otro=horario.buscar(est);

     giro = new Giro();
     boolean b = true;
     codigo = new Lista(new Giro().lista18(otro, b));
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
                          
                          
                          
                          Lista codigo=new Lista (new Agencia().lista());
                          int tamaño1 = codigo.getSize();
                          for(int j=0;j<tamaño1;j++){
                             agencia=(Agencia)codigo.getObject(j); 
                             if (agencia!=age){
                                 Lista codigo1 =new Lista(new Giro().lista8(otro, b, agencia)); 
                                 int tamaño2 = codigo1.getSize();
                                 if(tamaño2==0){
                                 }else{
                                      for(int i=0;i<tamaño2;i++){
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
                  cierre.setHorario(otro);
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
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los giros pagados ","Error");
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
                //  Mensaje.showMensaje(this,"Cual es teamaño "+agencia.getNombre());
                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista10(agencia, otro, b));

                  int tamaño = codigo.getSize();

                  if(tamaño==0){
               //   Mensaje.showMensaje(this,"Cual es teamaño "+tamaño);
                  }else{

                  cierre = new Cierre();
                  cierre.setDesde("");
                  cierre.setHasta("");
                  cierre.setIngreso(true);
                  cierre.setConcepto("Paquetes Devueltos ");
                  cierre.setNumero(String.valueOf(tamaño));

                  float o =0;

                  for(int j=0;j<tamaño;j++){
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();
                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  if (cierre.guardar()){
                //  Mensaje.showError(this,"guardado los paquetes devueltos ","Error");
                  }
                  } 
     
 }
 private void cpagar(){
 
      
                  horario=new Horario();
                  Horario otro = new Horario();
                  Boolean est=(false);
                  otro=horario.buscar(est);
                  
                  boolean pagos =false;
                  cp = new CuentasXPagar();
                  codigo = new Lista(new CuentasXPagar().lista3(otro, pagos));

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

                  giro = new Giro();
                  boolean b = true;
                  codigo = new Lista(new Giro().lista11(otro, b));

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
                       Giro sum=(Giro)codigo.getObject(j);
                       o=o+sum.getTotal();

                     }
                  cierre.setTotal(String.valueOf(o));
                  cierre.setNeto("0");
                  cierre.setHorario(otro);
                  if (cierre.guardar()){
                ////  Mensaje.showError(this,"guardado los giros remplazados ","Error");
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
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardadas las compras ","Error");
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
                      if (cierre.guardar()){
                    //  Mensaje.showError(this,"guardado los giros de oficina ","Error");
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
                  if (cierre.guardar()){
               //   Mensaje.showError(this,"guardado los giros de oficina ","Error");
                  }
                  } 
     
 
 }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtUtilidadche = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jLabelCivil4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtSobranteChe = new javax.swing.JTextField();
        jLabelCivil7 = new javax.swing.JLabel();
        txtNeto2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jLabelCivil8 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jButton1.setText("Ver Ingreso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton1, gridBagConstraints);

        jButton2.setText("Ver Egresos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton2, gridBagConstraints);

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("CIERRE DE CAJA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 24, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 21, 0);
        add(jLabelCreditopendiente3, gridBagConstraints);

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCodigo.setBorder(null);
        txtCodigo.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 33, 0, 0);
        add(txtCodigo, gridBagConstraints);

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        txtNombre1.setEditable(false);
        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNombre1, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil2.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtUtilidadche.setEditable(false);
        txtUtilidadche.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtUtilidadche.setBorder(null);
        txtUtilidadche.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtUtilidadche.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtUtilidadche, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil5.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil5, gridBagConstraints);

        txtAgente.setEditable(false);
        txtAgente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtAgente.setAutoscrolls(false);
        txtAgente.setBorder(null);
        txtAgente.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtAgente, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil4.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtTotal.setBorder(null);
        txtTotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtTotal, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil6.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil6, gridBagConstraints);

        txtSobranteChe.setEditable(false);
        txtSobranteChe.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtSobranteChe.setBorder(null);
        txtSobranteChe.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtSobranteChe.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtSobranteChe, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil7.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil7, gridBagConstraints);

        txtNeto2.setEditable(false);
        txtNeto2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto2.setBorder(null);
        txtNeto2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtNeto2, gridBagConstraints);

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

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil8.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil8, gridBagConstraints);

        txtCredito.setEditable(false);
        txtCredito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCredito.setBorder(null);
        txtCredito.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtCredito, gridBagConstraints);

        jButton3.setText("Cerrar Caja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        hora.setFechaFin(new Date());
        hora.setSecion(true);
        hora.actualizar();
        
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista3(hora)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRE);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
private void generarcierre(){
       cie();
       agencias();
       flores();
       pasaje();
       videos();
       Cabina();
       venats();
       cheq();
       ccobrar();
      
       
       cie1();
       dgiros();
       pgiros();
       dpaquetes();
       cpagar();
       rgiro();
       compras();   
       goficina();
       pt();
       sumas();

}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        setTabla();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void setTabla(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      Boolean anu=false;
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, est));
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
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, est));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRE,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
     // jXTable1.setModel(modelo);
       jXTable2.setModel(modelo);
     
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCivil7;
    private javax.swing.JLabel jLabelCivil8;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtNeto2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtSobranteChe;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUtilidadche;
    // End of variables declaration//GEN-END:variables
    
}
