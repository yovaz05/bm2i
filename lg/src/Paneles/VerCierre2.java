/*
 * VerCierre2.java
 *
 * Created on 30 de enero de 2007, 02:35 AM
 */

package Paneles;

import beans.Agencia;
import beans.anulargiro;
import beans.Billetes;
import beans.Giro;
import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.CierreFaltante;
import beans.Cierre;
import beans.Flores;
import beans.Pasajes;
import beans.Cabinas;
import beans.Otros;
import beans.VentaProductos;
import beans.Cheque;
import beans.CodigoAgencia;
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

public class VerCierre2 extends javax.swing.JPanel {
    
    private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private CodigoAgencia codigos;
    private Horario horario;
    private Agencia agencia;
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    private Flores flores;
    Flores ult;
    Flores su;
    
    private anulargiro anull;
    
    private CierreFaltante cierrefaltante;
    private Giro giro;
    private Giro fin;
    private Giro sum;
    
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
    
    public VerCierre2() {
        initComponents();
        generarcierre();
    }
    private void generarcierre(){
        cie();
        flores();
        pasaje();
        videos();
        Cabina();
        venats();
        cheq();
        utilidadcheque();
        ccobrar();
        paquetes();
        
        cie1();
        dpaquetes();
        cpagar();
        compras();
        pt();
        ventascredito();
        FaltanteCierre();
        sumas();
        adelanto();
        
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
        
        //*************************************SACO EL TOTAL DE CHEQUES
        cheque = new Cheque();
        boolean b = false;
        boolean ciert=false;
        codigo = new Lista(new Cheque().lista4(otro,b, ciert));
        float che=0;
        float che1=0;
        float che2=0;
        
        
        for(int j=0;j<codigo.getSize();j++){
            cheque=(Cheque)codigo.getObject(j);
            if (cheque.getGiro()==null){
                che = che+ cheque.getTotal();
                che1 = che1+ cheque.getUtilidad();
                che2 = che2+ cheque.getUtilidadche();
            }
        }
        txtNeto2.setText(String.valueOf(che));
        txtSobranteChe.setText(String.valueOf(che2));
        txtUtilidadche.setText(String.valueOf(che1));
//*************************************TOTAL DE INGRESOS
        
        lista = new Lista(new Cierre().lista(otro, est, est));
        int ver=lista.getSize();
        float suma1=0;
        float utilidad=0;
        if (ver !=0){
            Cierre cie = new Cierre();
            cie=(Cierre)lista.primero();
            
            for(int j=0;j<lista.getSize();j++){
                Cierre sum=(Cierre)lista.getObject(j);
                suma1= suma1+ Float.parseFloat(sum.getTotal());
            }
            utilidad=suma1+che2+che1;
            txtCodigo.setText(String.valueOf(utilidad));
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
            //    cie=(Cierre)lista.primero();
            
            for(int j=0;j<codigo.getSize();j++){
                Cierre sum=(Cierre)codigo.getObject(j);
                suma2= suma2+ Float.parseFloat(sum.getTotal());
            }
            txtNombre1.setText(String.valueOf(suma2));
        }else{
            txtNombre1.setText("0");
        }
        float  to= utilidad-suma2;
        txtAgente.setText(""+to);
        
        //*************************************SACO EL efectivo
        Boolean cie=false;
        listaAnteriores = new Lista(new Billetes().lista(otro, cie));
        Billetes bill = new Billetes();
        int tamas=listaAnteriores.getSize();
        if (tamas<=0){
            txtTotal.setText("0");
        }else{
            bill=(Billetes) listaAnteriores.getObject(0);
            txtTotal.setText(""+bill.getTotal());
        }
        
//*************************************SACO EL TOTAL DE LOS CREDITOS
        cxp = new CuentasXCobrar();
        codigo = new Lista(new CuentasXCobrar().lista3(otro, false));
        float cuenta =0;
        for(int j=0;j<codigo.getSize();j++){
            cxp=(CuentasXCobrar)codigo.getObject(j);
            cuenta = cuenta+ cxp.getCuota();
        }
        txtCredito.setText(String.valueOf(cuenta));
        
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
        otros = new Otros();
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
        
        lista = new Lista(new VentaProductos().lista2(otro));
        for(int i=0;i<lista.getSize();i++){
            venta =(VentaProductos) lista.getObject(i);
            int tamanio = lista.getSize();
            if(tamanio==0){
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
    
        private void ventascredito(){
        
        
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
            int tamanio = lista.getSize();
            if(tamanio==0){
            }else{
                cierre = new Cierre();
                // Mensaje.showMensaje(this,"La agencia es "+venta.getOtros().getNombre());
                if (Integer.parseInt(venta.getCredito())>0){
                
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
    
    
    
    private void utilidadcheque(){
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        cheque = new Cheque();
        boolean b = false;
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
    
    private void adelanto(){
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        cheque = new Cheque();
        boolean b = false;
        boolean ciert=false;
        codigo = new Lista(new Cheque().lista4(otro,b, ciert));
        
        float che=0;
        float che1=0;
        float che2=0;
        float bet=0;
        float beto=0;
        
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
            beto= adelan+che;
            // Mensaje.showMensaje(this,"El adelanto es "+beto);
            txtDeposito.setText(""+beto);
            otro.setAdelanto(beto);
        }
        float and=0;
        if (txtAgente.getText().equals("")){
            and=0;
        }else{
            and=Float.parseFloat(txtAgente.getText());
        }
        bet=and-beto;
        txtDeposito.setText(""+beto);
        txtDeposito1.setText(""+bet);
        otro.setDepoL(bet);
        otro.setAdelanto(beto);
        otro.actualizar();
    }
    
    
    //***********************************************
    //AQUI VAN LOS CHEQUES PROTESTADOS
    //###############################################
    
    
    private void cheq(){
        
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
    private void ccobrar(){
        
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
    
    //**********************************************
    //AQUI PARA LO DE LA DEVOLUCION DE PAQUETES
    //#################################################
    private void dpaquetes(){
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
             for(int i=0;i<tamanio;i++){
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
            cierre.setNumero(String.valueOf(tamanio));
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
    private void cpagar(){
        
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
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtNeto2 = new javax.swing.JTextField();
        jLabelCivil7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelCivil4 = new javax.swing.JLabel();
        jLabelCivil2 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jLabelCivil8 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        txtSobranteChe = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelApellido2 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtUtilidadche = new javax.swing.JTextField();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelCivil9 = new javax.swing.JLabel();
        txtDeposito = new javax.swing.JTextField();
        jLabelCivil21 = new javax.swing.JLabel();
        jLabelCivil22 = new javax.swing.JLabel();
        txtEfectivo2 = new javax.swing.JTextField();
        jLabelCivil23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        txtDeposito1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        setForeground(new java.awt.Color(153, 0, 0));
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

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(txtNombre, gridBagConstraints);

        jButton2.setText("Ver Egresos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton2, gridBagConstraints);

        jButton1.setText("Ver Ingreso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jButton1, gridBagConstraints);

        txtNeto2.setEditable(false);
        txtNeto2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto2.setBorder(null);
        txtNeto2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtNeto2, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil7.setText("Total Creditos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabelCivil7, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtTotal.setBorder(null);
        txtTotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        add(txtTotal, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil4.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

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

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil8.setText("Total Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabelCivil8, gridBagConstraints);

        txtCredito.setEditable(false);
        txtCredito.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCredito.setBorder(null);
        txtCredito.setDisabledTextColor(java.awt.SystemColor.activeCaptionText);
        txtCredito.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(txtCredito, gridBagConstraints);

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

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil6.setText("Utilidad de Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

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

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

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

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil5.setText("Sobrante de  Cheques");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
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

        datFechaIngreso.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 21, 0);
        add(jLabelCreditopendiente3, gridBagConstraints);

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                             CIERRE DE CAJA DE LG TRAVEL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 24, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton5, gridBagConstraints);

        jButton4.setText("Imprimir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton4, gridBagConstraints);

        jLabelCivil9.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil9.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil9.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
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

        jLabelCivil21.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil21.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil21, gridBagConstraints);

        jLabelCivil22.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil22.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil22.setText("Deposito Adelantado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCivil22, gridBagConstraints);

        txtEfectivo2.setEditable(false);
        txtEfectivo2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtEfectivo2.setBorder(null);
        txtEfectivo2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 0);
        add(txtEfectivo2, gridBagConstraints);

        jLabelCivil23.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabelCivil23.setForeground(new java.awt.Color(0, 0, 255));
        jLabelCivil23.setText("Deposito Fin de Dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabelCivil23, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel4.setText("Faltante de Caja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabel4, gridBagConstraints);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField4.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        add(jTextField4, gridBagConstraints);

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

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton6.setText("Imprimir Cierre Total");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jButton6, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(false);
        
        //*************************************SACO EL TOTAL DE CHEQUES
        cheque = new Cheque();
        boolean b = false;
        boolean ciert=false;
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
        lista = new Lista(new Cierre().lista(hora, anu, es));
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
            Cierre cie = new Cierre();
            cie=(Cierre)lista.primero();
            
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
        Boolean cie=false;
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
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista2(hora,est)),Mapa.MAPAREPORTECIERRE,true),ReportePrevio.CIERREGMT);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotali(ingre);
            rp.setTotale(Float.parseFloat(txtNombre1.getText()));
            rp.setUtilidad(Float.parseFloat(txtAgente.getText()));
            //rp.setFaltante(Float.parseFloat(jTextField4.getText()));
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        //*************************************SACO LOs Ingresos
        lista = new Lista(new Cierre().lista(hora, est, est));
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
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(hora,est,est)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL3);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotali(ingre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        
        Date hora1;
        hora1=new Date();
        Boolean anu=true;
        Boolean es=(true);
        
        //*************************************SCO LO EGRESOS
        
        codigo = new Lista(new Cierre().lista(hora, es, est));
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
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista(hora,anu, est)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRETOTAL4);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setTotale(egre);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setTabla();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil21;
    private javax.swing.JLabel jLabelCivil22;
    private javax.swing.JLabel jLabelCivil23;
    private javax.swing.JLabel jLabelCivil4;
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
    private javax.swing.JTextField jTextField4;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtDeposito;
    private javax.swing.JTextField txtDeposito1;
    private javax.swing.JTextField txtEfectivo2;
    private javax.swing.JTextField txtNeto2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtSobranteChe;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUtilidadche;
    // End of variables declaration//GEN-END:variables
    
}
