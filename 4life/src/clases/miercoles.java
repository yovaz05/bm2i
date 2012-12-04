/*
 * miercoles.java
 *
 * Created on 25 de octubre de 2006, 22:08
 */

package clases;

import beans.Otros;
import com.sun.rmi.rmid.ExecOptionPermission;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.Cheque;
import beans.CuentasXPagar;

public class miercoles extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Giro giro;
private String mensaje="";
private boolean editar;
Giro gh;
Lista listaAnteriores;
private Cheque cheque;
private CuentasXPagar credito;


    public miercoles() {
       initComponents();
       fijaMetodos();
       inicializa();
     //  setTabla2();
    }
    
private boolean isVacio(){
  if(txtCodigo.getText().equalsIgnoreCase("")    | (txtNeto.getText().equalsIgnoreCase("")) 
    |(txtNombre.getText().equalsIgnoreCase(""))  
    )
     return true;
     return false;
} 
   
 private void inicializa(){
                   agencia = new Agencia();
                   lista = new Lista(new Agencia().lista());

                for(int i=0;i<lista.getSize();i++){
                   Agencia b1=(Agencia) lista.getObject(i);
                    cboAgencia.addItem(b1.getNombre());
                                }
                cboPago.addItem("Efectivo");
                cboPago.addItem("Cheque");
                cboPago.addItem("Credito");
                
                   
                   
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
   modoEdicion(false);
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
           Agencia agco=new Agencia();
           agco=(Agencia)lista.ultimo();
           
           giro=new Giro();
            getPanel();
            if(giro.guardar()){
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
            Mensaje.showMensaje(this,"GIRO GUARDADO");
            modoEdicion(false);
            verificador();
        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        newcod();    
        setTabla();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
        }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR EL GIRO","Eliminar");
        if (b){
            borra();
            setTabla();
            setBlanco();
            newcod();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            giro=(Giro)lista.getMyself();
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
    }
    
    private void anterior(){
        giro=(Giro)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        giro=(Giro)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        giro=(Giro)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        giro=(Giro)lista.ultimo();
        setPanel();
       
    }
    
    private void setPanel(){
   
   txtCodigo.setText(""+agencia.getCodigo());
   txtNeto.setText(""+giro.getNeto());
   txtTotal.setText(""+giro.getTotal());
   txtNombre1.setText(""+giro.getNombre());
   txtCmanual.setText(""+giro.getCodigo());
   referencia.setText(""+giro.getReferencia());
   cboAgencia.setSelectedItem(agencia.getNombre().toString());
    }  
 private void setPanel(Giro gg){
   
   txtCodigo.setText(""+gg.getClave());
   txtNeto.setText(""+String.valueOf(gg.getNeto()));
   txtTotal.setText(""+String.valueOf(gg.getTotal()));
   txtNombre1.setText(""+gg.getNombre());
   txtNombreC.setText(""+String.valueOf(gg.getTotal()));
   txtCmanual.setText(""+gg.getCodigo());
   referencia.setText(""+gg.getReferencia());
   if (gg.getCheque()!=null){
       cboPago.setSelectedIndex(1);
       txtNombreC1.setText(""+gg.getCheque().getTotal());
       txtNet.setText(""+gg.getCheque().getNeto());
       txtChequeN.setText(""+gg.getCheque().getNumero());
       txtUtil.setText(""+gg.getCheque().getUtilidad());
       txtNombreC.setText("");
       txtUtilche.setText(""+gg.getCheque().getUtilidadche());
       txtGiron.setText("");
       
       txtNombreC1.setEditable(false);
       txtNet.setEditable(false);
       txtChequeN.setEditable(false);
       txtUtil.setEditable(false);
       txtNombreC.setEditable(false);
       txtUtilche.setEditable(false);
       txtGiron.setEditable(false);
       txtAgencia.setEditable(false);
       
   }else  if (gg.getCredito()!=null){
       cboPago.setSelectedIndex(2);
       txtGiron.setText(""+gg.getCredito().getTotal());
       txtNombreC.setText("");
       txtNombreC1.setText("");
       txtNet.setText("");
       txtChequeN.setText("");
       txtUtilche.setText("");
       txtUtil.setText("");
       txtAgencia.setText("LG TRASMITTER");
   }
   
   if ((gg.getCredito()==null)&&(gg.getCheque()==null)){
       cboPago.setSelectedIndex(0);
       txtGiron.setText("");
       txtNombreC1.setText("");
       txtNet.setText("");
       txtChequeN.setText("");
       txtUtilche.setText("");
       txtUtil.setText("");
       txtAgencia.setText("LG TRASMITTER");
   }
 }  
    
    private void getPanel(){
    
 try{
        giro.setNeto(Float.parseFloat(txtNeto.getText()));
        giro.setTotal(Float.parseFloat(txtTotal.getText()));
        txtTotal.setEditable(false);
        giro.setEstado(false);
        giro.setAnulado(false);
        giro.setRem(false);
        giro.setPagado(false);
        giro.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
        giro.setNombre(txtNombre1.getText());
        giro.setCodigo(txtCmanual.getText());
        giro.setReferencia(referencia.getText());
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        giro.setHorario(otro);
    
  //GENERO LA LISTA Y TOMO EL ULTIMO VALOR 
  codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
 //  Mensaje.showError(this,"el tamañoa es  "+String.valueOf(codigo.getSize()),"Error");
   codigos = new CodigoAgencia();
   codigos=(CodigoAgencia) codigo.ultimo();
  if (codigos==null){
    Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");  
    codigos = new CodigoAgencia();    
    codigos.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
    codigos.setCodigo(Float.parseFloat(txtCodigo.getText()));  
    codigos.guardar();
    giro.setClave(txtCodigo.getText());
    giro.setFechaLlegada(new Date());  
  }else{
    Float newcod= codigos.getCodigo()+1;
    codigos.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
    codigos.setCodigo(newcod);  
    codigos.guardar();
    giro.setClave(String.valueOf(newcod));
    giro.setFechaLlegada(new Date());
   }
   
   int mierda = cboPago.getSelectedIndex();
   switch(mierda){
                  
              case 1: {
                  cheque = new Cheque();
                  cheque.setFecha(datFechaIngreso.getDate());
                  cheque.setHorario(otro);
                  cheque.setNeto(Float.parseFloat(txtNet.getText()));
                  cheque.setNombre(txtNombre1.getText());
                  cheque.setNumero(txtChequeN.getText());
                  cheque.setProtestado(false);
                  cheque.setTotal(Float.parseFloat(txtNombreC1.getText()));
                  cheque.setUtilidadche(Float.parseFloat( txtUtilche.getText()));
                  cheque.setUtilidad(Float.parseFloat(txtUtil.getText()));
                  cheque.setGiro(giro);
                  cheque.setLgtrasmiter(true);
                  cheque.setAdelanto(false);
                  cheque.setClave(txtCodigo.getText());
                  
                  if (cheque.guardar()){
                    // Mensaje.showMensaje(this,"No se que hice pero ya guardo ");
                     txtNombreC.setEditable(false);
                     txtNombreC1.setEditable(false);
                     txtNet.setEditable(false);
                     txtChequeN.setEditable(false);
                     txtGiron.setEditable(false);
                     txtUtil.setEditable(false);
                     txtUtilche.setEditable(false);
                      }else{
                       Mensaje.showMensaje(this,"No guardo ni geivol ");
                     }
                  giro.setCheque(cheque);
                 }
              break;
              case 2: {
                   credito = new CuentasXPagar();
                   credito.setFecha(datFechaIngreso.getDate());
                   credito.setTotal(Float.parseFloat(txtGiron.getText()));
                   credito.setHorario(otro);
                   credito.setGiros(true);
                   credito.setPagado(false);
                   credito.setNombre(txtNombre1.getText());
                   credito.setEnvio("Giro");
                   credito.setGiro(giro); 
                   credito.setMt(true);
                   credito.guardar();
                   giro.setCredito(credito);
              }
    
    }
  
   
      }catch(Exception e){
       
        Mensaje.showError(this,"Escriba la separacion de decimales com punto ","Error");  
         setBlanco();
         e.printStackTrace();
         cancelar();
      }

  
    }
    //**********************************************************************
    //****************           GET PANEL 2    ****************************
    //**********************************************************************
private void getPanel2(){
   try{  
        int fila=tblProducto.getSelectedRow();
         if (fila < 0){
            Mensaje.showError(this,"No ha selleccionad ningun Giro","ERROR");
         }else{
            gh=(Giro)listaAnteriores.getObject(fila);     
            gh.setNeto(Float.parseFloat(txtNeto.getText()));
            gh.setTotal(Float.parseFloat(txtTotal.getText()));
            gh.setNombre(txtNombre1.getText());
            gh.setCodigo(txtCmanual.getText());
            gh.setReferencia(referencia.getText());
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
       
   int mierda = cboPago.getSelectedIndex();
   switch(mierda){
       
       case 1: {           
                  if (gh.getCheque()!=null){
                  cheque=gh.getCheque();
                                  
                  cheque.setFecha(datFechaIngreso.getDate());
                  cheque.setNeto(Float.parseFloat(txtChequeN.getText()));
                  cheque.setNombre(txtNombre1.getText());
                  cheque.setNumero(txtNet.getText());
                  cheque.setProtestado(false);
                  cheque.setTotal(Float.parseFloat(txtNombreC1.getText()));
                  cheque.setUtilidad(Float.parseFloat(txtUtil.getText()));
                  cheque.setUtilidadche(Float.parseFloat( txtUtilche.getText()));
                  cheque.setGiro(gh);
                  cheque.setLgtrasmiter(true);
                  cheque.setAdelanto(false);
                  cheque.actualizar();
                  txtNombreC.setEditable(false);
                  txtNombreC1.setEditable(false);
                  txtNet.setEditable(false);
                  txtChequeN.setEditable(false);
                  txtGiron.setEditable(false);
                  txtUtil.setEditable(false);
                  txtUtilche.setEditable(false);
           }else{
                  cheque = new Cheque();
                  cheque.setFecha(datFechaIngreso.getDate());
                  cheque.setNeto(Float.parseFloat(txtChequeN.getText()));
                  cheque.setNombre(txtNombre1.getText());
                  cheque.setNumero(txtNet.getText());
                  cheque.setProtestado(false);
                  cheque.setTotal(Float.parseFloat(txtNombreC1.getText()));
                  cheque.setUtilidad(Float.parseFloat(txtUtil.getText()));
                  cheque.setUtilidadche(Float.parseFloat( txtUtilche.getText()));
                  cheque.setGiro(gh);
                  cheque.setHorario(otro);
                  txtNombreC.setEditable(false);
                  txtNombreC1.setEditable(false);
                  txtNet.setEditable(false);
                  txtChequeN.setEditable(false);
                  txtGiron.setEditable(false);
                  txtUtil.setEditable(false);
                  txtUtilche.setEditable(false);
                  cheque.setLgtrasmiter(true);
                  cheque.setAdelanto(false);
                  cheque.guardar();
                }
    break;                
            }

   case 2: {
               if (gh.getCredito()!=null){
                 credito = gh.getCredito();
                 credito.setFecha(datFechaIngreso.getDate());
                 credito.setTotal(Float.parseFloat(txtGiron.getText()));
                 credito.actualizar();
               }else{
                 credito = new CuentasXPagar();
                 credito.setFecha(datFechaIngreso.getDate());
                 credito.setTotal(Float.parseFloat(txtGiron.getText()));
                 credito.setHorario(otro);
                 credito.setGiro(gh);
                 credito.setGiros(true);
                 credito.setNombre(txtNombre1.getText());
                 credito.setMt(true);
                 credito.setPagado(false);
                 credito.guardar();
               }
    break; 
          }
   
   }
        gh.setCredito(credito);
        gh.setCheque(cheque);
        gh.actualizar();   
   }
  }catch(Exception e){
      Mensaje.showError(this,"Escriba la separacion de decimales com punto ","Error");  
       setBlanco();
       e.printStackTrace();
       cancelar();
  }
 
  
 
 }
    
private void borra(){
  int fila=tblProducto.getSelectedRow();
  if (fila < 0){
      Mensaje.showError(this,"No ha seleccionado ningun Giro","ERROR");
  }else{
   gh=(Giro)listaAnteriores.getObject(fila);     
   if (gh.getCheque()!=null){
     cheque=gh.getCheque();
     cheque.borrar();
     }
  if (gh.getCredito()!=null){
      credito=gh.getCredito();
      credito.borrar();
    }
  gh.borrar();   
      
  }
   
  
       }
    
    
    private void setBlanco(){

  
   txtNeto.setText("0");
   txtTotal.setText("0");
   txtNombre1.setText("");
   horario=new Horario();
   Horario otro = new Horario();
   Boolean est=(false);
   otro=horario.buscar(est);
   txtNombreC1.setText("0");
   txtNet.setText("0");
   txtChequeN.setText("0");
   txtUtil.setText("0");
   txtGiron.setText("0");
   txtUtilche.setText("0");
   txtCmanual.setText("0");
   referencia.setText(" ");
   if(otro==null){
   Mensaje.showError(this,"ES NULO QUE PASA","Error");
   
   }else{
   
   txtNombre.setText(""+otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   }  
              
        
    }
    
    public void verificador(){
       
        
    }
    
 public void modoEdicion(boolean b){
   
        txtNombre1.setEditable(b);
        txtNeto.setEditable(b);
        txtTotal.setEditable(b);
        txtCmanual.setEditable(b);
        referencia.setEditable(b);
        panMantenimiento1.setActiva(b);
   
        int mierda = cboPago.getSelectedIndex();
        switch(mierda){
              
              case 1: {
                   txtGiron.setEditable(false);
                  // Mensaje.showMensaje(this,"aquie creo es ");
                   txtNombreC1.setEditable(b);
                   txtNet.setEditable(b);
                   txtChequeN.setEditable(b);
                   txtUtil.setEditable(b);
                   break;
                 }
              case 2: {
                   txtGiron.setEditable(b);
                   break;
                    }
    
           }
   
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
         
         codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));      
         System.out.println("tam 1 "+ codigo.getSize());
         codigos = new CodigoAgencia();
         codigos=(CodigoAgencia) codigo.ultimo();  
         
         listaAnteriores =new Lista(new Giro().lista19(hora,codigos.getAgencia()));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIRO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
         System.out.println("paso 3");
     
     }
  private void setTabla2(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
                  
         Lista listaAnteriores =new Lista(new Giro().lista3(hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIRO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }  
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new miercoles().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelCedula1 = new javax.swing.JLabel();
        cboAgencia = new javax.swing.JComboBox();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelNombre2 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelCivil1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelApellido2 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtNet = new javax.swing.JTextField();
        jLabelCivil3 = new javax.swing.JLabel();
        txtChequeN = new javax.swing.JTextField();
        jLabelCivil4 = new javax.swing.JLabel();
        txtUtil = new javax.swing.JTextField();
        cboPago = new javax.swing.JComboBox();
        jLabelCedula2 = new javax.swing.JLabel();
        jLabelCivil5 = new javax.swing.JLabel();
        txtGiron = new javax.swing.JTextField();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jLabelNombre4 = new javax.swing.JLabel();
        txtNombreC1 = new javax.swing.JTextField();
        txtUtilche = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtCmanual = new javax.swing.JTextField();
        txtAgencia = new javax.swing.JTextField();
        jLabelCivil7 = new javax.swing.JLabel();
        referencia = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                          FORMAS DE PAGOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 27, 0, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso.setText("                    Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        datFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelCedula1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCedula1.setText("Forma de Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        add(jLabelCedula1, gridBagConstraints);

        cboAgencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(cboAgencia, gridBagConstraints);

        jLabelNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre1.setText("                    Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCodigo, gridBagConstraints);

        jLabelNombre3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre3.setText("Valor Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 26, 0, 0);
        add(jLabelNombre3, gridBagConstraints);

        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNombre1, gridBagConstraints);

        jLabelNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre2.setText("Valor Credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 25, 0, 0);
        add(jLabelNombre2, gridBagConstraints);

        txtNeto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNeto, gridBagConstraints);

        jLabelApellido1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido1.setText("Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        add(jLabelApellido1, gridBagConstraints);

        jLabelCivil1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil1.setText("# de Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        add(jLabelCivil1, gridBagConstraints);

        txtTotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                          DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombreGrup1.setText("                    Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
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
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelApellido2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelApellido2.setText("                    Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        txtNombreC.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreCKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil2.setText("                    Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtNet.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtNet, gridBagConstraints);

        jLabelCivil3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil3.setText("Sobrante de Ch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        add(jLabelCivil3, gridBagConstraints);

        txtChequeN.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtChequeN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChequeNKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtChequeN, gridBagConstraints);

        jLabelCivil4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil4.setText("                    Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        txtUtil.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtUtil, gridBagConstraints);

        cboPago.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        cboPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPagoActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(cboPago, gridBagConstraints);

        jLabelCedula2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCedula2.setText("                    Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula2, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil5.setText("                    Codigo Manual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil5, gridBagConstraints);

        txtGiron.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtGiron.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGironKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtGiron, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                    INGRESO DE  GIROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        jLabelNombre4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombre4.setText("Valor Cheque");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 26, 0, 0);
        add(jLabelNombre4, gridBagConstraints);

        txtNombreC1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtNombreC1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreC1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtNombreC1, gridBagConstraints);

        txtUtilche.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtUtilche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUtilcheKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(txtUtilche, gridBagConstraints);

        jLabelCivil6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil6.setText("Utilidad del Ch");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

        txtCmanual.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtCmanual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCmanualKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtCmanual, gridBagConstraints);

        txtAgencia.setEditable(false);
        txtAgencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        txtAgencia.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 0);
        add(txtAgencia, gridBagConstraints);

        jLabelCivil7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCivil7.setText("                    Referencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil7, gridBagConstraints);

        referencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(referencia, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtUtilcheKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUtilcheKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        txtUtil.requestFocus();
            
        }  
    }//GEN-LAST:event_txtUtilcheKeyPressed

    private void txtChequeNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeNKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        txtUtilche.requestFocus();
            
        }  
    }//GEN-LAST:event_txtChequeNKeyPressed

    private void txtNetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetKeyPressed
                if(evt.getKeyCode()==10){
            //tecla enter
         txtChequeN.requestFocus();
            
        }  
        
    }//GEN-LAST:event_txtNetKeyPressed

    private void txtNombreC1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreC1KeyPressed
                if(evt.getKeyCode()==10){
            //tecla enter
         txtNet.requestFocus();
            
        }  
        
        
    }//GEN-LAST:event_txtNombreC1KeyPressed

    private void txtGironKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGironKeyPressed
                if(evt.getKeyCode()==10){
            //tecla enter
         txtNombreC1.requestFocus();
            
        }  
        
    }//GEN-LAST:event_txtGironKeyPressed

    private void txtNombreCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyPressed
// TODO add your handling code here:
                if(evt.getKeyCode()==10){
            //tecla enter
         txtGiron.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNombreCKeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            //tecla enter
         referencia.requestFocus();
            
        }  
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetoKeyPressed
        if(evt.getKeyCode()==10){
            //tecla enter
         txtTotal.requestFocus();
            
        }
        
    }//GEN-LAST:event_txtNetoKeyPressed

    private void txtCmanualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmanualKeyPressed
// TODO add your handling code here:
          if(evt.getKeyCode()==10){
            //tecla enter
            txtNeto.requestFocus();
            
        }
    }//GEN-LAST:event_txtCmanualKeyPressed

    private void txtNombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            //tecla enter
            txtCmanual.requestFocus();
            
        }
    }//GEN-LAST:event_txtNombre1KeyPressed

    private void cboPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPagoActionPerformed

 int mierda = cboPago.getSelectedIndex();
  
    switch(mierda){
              case 0: {
                   txtNombreC.setText(""+txtTotal.getText());
                   txtNombreC.setEditable(false);
                   txtNombreC1.setEditable(false);
                   txtNet.setEditable(false);
                   txtChequeN.setEditable(false);
                   txtGiron.setEditable(false);
                   txtUtil.setEditable(false);
                   txtUtilche.setEditable(false);
                   break;
                }
              case 1: {
                   txtNombreC1.setEditable(true);
                   txtNombreC.setText(""+txtTotal.getText());
                   txtNet.setEditable(true);
                   txtChequeN.setEditable(true);
                   txtUtil.setEditable(true);
                   txtUtilche.setEditable(true);
                   txtGiron.setEditable(false);
                   break;
                 }
              case 2: {
                   txtGiron.setEditable(true);
                   txtNombreC.setEditable(false);
                   txtNombreC1.setEditable(false);
                   txtNet.setEditable(false);
                   txtChequeN.setEditable(false);
                   txtUtil.setEditable(false);
                   txtUtilche.setEditable(false);
                   break;
                    }
    
    }
        
    }//GEN-LAST:event_cboPagoActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
            int fila=tblProducto.getSelectedRow();
            gh=(Giro)listaAnteriores.getObject(fila);        
            setPanel(gh);
       
    }//GEN-LAST:event_tblProductoMouseClicked
private void newcod(){
        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        
        if (codigos==null){
            Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");
            
        }else{
            Float newcod= codigos.getCodigo()+1;
            txtCodigo.setText(String.valueOf(newcod));
            setTabla();
        }

}
    
    private void cboAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaActionPerformed

        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        
        if (codigos==null){
            Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");
            
        }else{
            Float newcod= codigos.getCodigo()+1;
            txtCodigo.setText(String.valueOf(newcod));
            setTabla();
        }
    }//GEN-LAST:event_cboAgenciaActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgencia;
    private javax.swing.JComboBox cboPago;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCedula1;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCivil7;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JTextField referencia;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtChequeN;
    private javax.swing.JTextField txtCmanual;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGiron;
    private javax.swing.JTextField txtNet;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreC1;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUtil;
    private javax.swing.JTextField txtUtilche;
    // End of variables declaration//GEN-END:variables
    
}
