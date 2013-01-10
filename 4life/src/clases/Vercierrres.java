/*
 * Vercierrres.java
 *
 * Created on 13 de marzo de 2007, 14:29
 */

package clases;

import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Otros;
import beans.Provedor;
import beans.VentaProductos;
import beans.Horario;
import beans.Linea;
import beans.Cliente;
import beans.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.MapaVentasdia;
import reportesXML.ReportePrevio;

public class Vercierrres extends javax.swing.JInternalFrame {

    
private Lista lista;
private Lista codigo;
private Lista tar;
private Horario horario;
Otros otros;
Horario otro;
private String mensaje="";
private boolean editar;
private VentaProductos venta;
private VentaProductos mas;
private Provedor provedor;
Factura factura;
private javax.swing.DefaultComboBoxModel modelo2;
private javax.swing.DefaultComboBoxModel modelo3;
Linea linea;
Lista tres;
Cliente cliente;
 Factura g;
Boolean activado;
VentaProductos gh;
Lista listaAnteriores;
   
    /** Creates new form Vercierrres */
    public Vercierrres() {
               
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        if (hora==null){
            Mensaje.showMensaje(this,"DEBE INICIAR CESION  CIERRE Y ABRA EL PROGRAMA NUEVAMENTE");
        }else{
        initComponents();
        fijaMetodos();
        inicializa();
        responsable();
        setTabla();
        combos();
        }
    }
    
    private void encerar() {
   // a qui enceramos todo para una nueva factura
       jtNfactura.setText(""); 
       jButton2.setEnabled(true);
       jCTipoPago.setEnabled(true);
      // jButton6.setEnabled(true);
       txtVtotal.setText("0");
       txtPtotal.setText("0");
       txtUtilidad.setText("0");
       enblanco();
       setBlanco();
       setTabla1();
    }
    
    
    private void combos(){
    linea = new Linea();
    lista = new Lista(new Linea().lista());
    for(int i=0;i<lista.getSize();i++){
                                        Linea b1=(Linea) lista.getObject(i);
                                        cboLinea.addItem(b1.getNombre());
                                       }
    
    jCTipoPago.addItem("Efectivo");
    jCTipoPago.addItem("deposito");
    
  txtVtotal.setText("0");
  txtPtotal.setText("0");
  txtUtilidad.setText("0");
 }
 
    private void responsable(){
                   horario=new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre1.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
  }
    
 private boolean isVacio(){
 if((jTCantidad.getText().equalsIgnoreCase(""))  | (jTotal.getText().equalsIgnoreCase("") | (jTCodigo.getText().equalsIgnoreCase("")
     | (txtStock.getText().equalsIgnoreCase("")) | (jTPuntos.getText().equalsIgnoreCase("")) | (jtNfactura.getText().equalsIgnoreCase(""))
     | (jTPrecio.getText().equalsIgnoreCase(""))      )))
  return true;
  return false;
        } 
   
 private void inicializa(){
                  
  horario=new Horario();
  Horario otro = new Horario();
  Boolean est=(false);
  otro=horario.buscar(est);
  txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
  venta = new VentaProductos();
                  // codigo = new Lista(new VentaProductos().lista2(otro));
                  // venta=(VentaProductos) codigo.ultimo();
  modoEdicion(false);
  modoEdicion2(false);

  
 // setTabla();
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
                           if (Integer.parseInt(txtStock.getText())<Integer.parseInt(jTCantidad.getText())){
                             Mensaje.showError(this,"No hay el Estock Necesario","Error");  
                           }else{
                                 getPanel(); 
                                
                           }
                               
         }
       return true;
   } 
    
    private void aceptar(){
     
            if(saveOrUpdate()){
           // Mensaje.showMensaje(this,"Se ha realizado la venta con EXITO");
            modoEdicion(false);
            setTabla1();
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR LLENE TODOS LOS CAMPOS","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR","Eliminar");
        if (b){
            borra();
            setTabla1();
            setBlanco();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
//         venta=(VentaProductos)lista.getMyself();
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
        venta=(VentaProductos)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       venta=(VentaProductos)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        venta=(VentaProductos)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        venta=(VentaProductos)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
    cboLinea.setSelectedItem(otros.getNombre().toString());
       
} 

//***********************************************
//*****************  GESTION DE CLIENTES ********
// **********************************************
private void setPanel2(Cliente cli){
    
   jTNombre.setText(""+cli.getNombre());
   jTApellido.setText(""+cli.getApellido());
   jTCedula.setText(""+cli.getCedula());
   jTelefono.setText(""+cli.getTelefono());
   jCelular.setText(""+cli.getCelular());
   jDireccion.setText(""+cli.getDireccion());//Nombres igual a direccion       
} 


private void enblanco(){
   jTCodigo.setText("");
   jTNombre.setText("");
   jTApellido.setText("");
   jTCedula.setText("");
   jTelefono.setText("");
   jCelular.setText("");
   jDireccion.setText("");//Nombres igual a direccion        
} 

public void modoEdicion2(boolean b){

 //jButton4.setEnabled(b);
      jTNombre.setEditable(b);
      jTApellido.setEditable(b);
      jTCedula.setEditable(b);
      jTelefono.setEditable(b);
      jCelular.setEditable(b);
      jDireccion.setEditable(b);//Nombres igual a direccion 
}
private void getPanellinete(){
      
      Cliente cliente = new Cliente();
      
      if (jTCodigo.getText().equals("")){
      Mensaje.showError(this,"No se puede Grabar ya que no hay CODIGO 4LIFE","Error");
      enblanco();
      }else{
      String bus = jTCodigo.getText();
      cliente = cliente.buscarCodigo(bus);
      if (cliente==null){
                        Cliente cli = new Cliente();
                        cli.setCodigocliente(jTCodigo.getText());
                        cli.setNombre(jTNombre.getText());
                        cli.setApellido(jTApellido.getText());
                        cli.setCedula(jTCedula.getText());
                        cli.setTelefono(jTelefono.getText());
                        cli.setCelular(jCelular.getText());
                        cli.setDireccion(jDireccion.getText());
                        cli.guardar();   
                        if(cli.guardar()){
                            modoEdicion2(false);
                            Mensaje.showMensaje(this,"Se ha creado el Cliente con EXITO");
                            modoEdicion2(false);
                            jButton2.setEnabled(false);
//                jButton6.setEnabled(false);
                            }else{
                                Mensaje.showError(this,"ERRO AL GRABAR","Error");
                            }
                        }else{
                             Mensaje.showError(this,"ESTE CLIENTE YA EXISTE","Error");      
                             setPanel2(cliente);
                             modoEdicion2(false);
                         }
    }
         
  }


private void setPanel(VentaProductos gg){

    cboLinea.setSelectedItem(gg.getOtros().getLinea().getNombre()); 
    cboProductos.setSelectedItem(gg.getOtros().getNombre());  
    jTCantidad.setText(""+gg.getCantidad());
    txtStock.setText(""+gg.getOtros().getStock());
    jTPuntos.setText(""+gg.getOtros().getPuntos());
    jTPrecio.setText(""+gg.getVuproducto());
    jTotal.setText(""+gg.getTotalproducto());
    
    datFechaIngreso.setDate(gg.getFechasalida());
    jTCodigo.setText(""+gg.getCliente().getCodigocliente()); 
    jTNombre.setText(""+gg.getCliente().getNombre());
    jTApellido.setText(""+gg.getCliente().getApellido());
    jTCedula.setText(""+gg.getCliente().getCedula());
    jTelefono.setText(""+gg.getCliente().getTelefono());
    jCelular.setText(""+gg.getCliente().getCelular());
    jDireccion.setText(""+gg.getCliente().getDireccion());
    
    Factura g= new Factura();
    g=g.Busca(jtNfactura.getText());
    txtVtotal.setText(""+g.getVtotal());
    txtPtotal.setText(""+g.getVpuntos());
    txtUtilidad.setText(""+g.getUtilidad());
    datFechaIngreso.setDate(g.getFecha());
    jTCodigo.setText(""+g.getCliente().getCodigocliente()); 
    jTNombre.setText(""+g.getCliente().getNombre());
    jTApellido.setText(""+g.getCliente().getApellido());
    jTCedula.setText(""+g.getCliente().getCedula());
    jTelefono.setText(""+g.getCliente().getTelefono());
    jCelular.setText(""+g.getCliente().getCelular());
    jDireccion.setText(""+g.getCliente().getDireccion());
    jCTipoPago.setSelectedItem(g.getTpago());
 
    } 
private void setPanel2(Factura g){
 //jTCantidad.setEditable(true);
    datFechaIngreso.setDate(g.getFecha());
    jTCodigo.setText(""+g.getCliente().getCodigocliente()); 
    jTNombre.setText(""+g.getCliente().getNombre());
    jTApellido.setText(""+g.getCliente().getApellido());
    jTCedula.setText(""+g.getCliente().getCedula());
    jTelefono.setText(""+g.getCliente().getTelefono());
    jCelular.setText(""+g.getCliente().getCelular());
    jDireccion.setText(""+g.getCliente().getDireccion());
   // jtNfactura.setText(""+gg.getNumero());
    
    txtVtotal.setText(""+g.getVtotal());
    txtPtotal.setText(""+g.getVpuntos());
    txtUtilidad.setText(""+g.getUtilidad());
    
    jCTipoPago.setSelectedItem(g.getTpago());
    

    }  
    
    
    private void getPanel(){
        /* xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                   OPERACIONES MATEMATICAS*/
           linea=((Linea)lista.getObject(cboLinea.getSelectedIndex()));
           codigo =new Lista(new Otros().lista2(linea));
           otros = ((Otros)codigo.getObject(cboProductos.getSelectedIndex()));
      
            jCTipoPago.setEnabled(false);   
           
                 
            horario=new Horario();
            Horario hora = new Horario();
            Boolean est=(false);
            hora=horario.buscar(est);
           
           
           Float pro= Float.parseFloat(jTPrecio.getText())*Float.parseFloat(jTCantidad.getText());
           int pu=  Integer.parseInt(jTPuntos.getText())*Integer.parseInt(jTCantidad.getText());
           Float uti=(Float.parseFloat(jTPrecio.getText())-otros.getCosto())*Float.parseFloat(jTCantidad.getText());;

           Float tt=Float.parseFloat(txtVtotal.getText())+pro;
           int tp=Integer.parseInt(txtPtotal.getText())+pu;
           Float tu=Float.parseFloat(txtUtilidad.getText())+uti;
        /* xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                    PRIMERO GRABO LA FACTURA 
         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/
        
          
    /* xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                  FIN  FACTURA Y GRABO VENTAS
       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/        
           
           Cliente cli = new Cliente();        
           String bus = jTCodigo.getText();
           cli = cli.buscarCodigo(bus);
           
           
           venta = new VentaProductos();
           venta.setFechasalida(datFechaIngreso.getDate());
           venta.setNfactura(""+jtNfactura.getText());
           venta.setVuproducto(Float.parseFloat(jTPrecio.getText()));
           venta.setTotalproducto(pro);
           venta.setVupuntos(Float.parseFloat(jTPuntos.getText()));
           venta.setTotalpuntos(pu); 
           venta.setCantidad(Integer.parseInt(jTCantidad.getText()));
           venta.setCliente(cli);
           venta.setHorario(hora);
           venta.setUsuario(hora.getUsuario());
           venta.setOtros(otros); 
           venta.setUtilidad(uti);
           venta.setFactura(factura);
           venta.setCosto(otros.getCosto());
           
           txtVtotal.setText(""+tt);
           txtPtotal.setText(""+tp);
           txtUtilidad.setText(""+tu); 
           otros.setStock(otros.getStock()-Integer.parseInt(jTCantidad.getText()));  
           otros.setUtilidad(otros.getUtilidad()+uti);
           otros.actualizar();
            Factura factura= new Factura();
            factura=factura.Busca(jtNfactura.getText());
            factura.setVtotal(tt);
            factura.setVpuntos(tp);
            factura.setUtilidad(tu);
            factura.actualizar();   
           
           
           
           if(venta.guardar()){
               //Mensaje.showError(this,"Producto agregado","ERROR");
              inicializa();
              setTabla1();
              }else{
                     Mensaje.showError(this,"NO se ha podido agregar el producto","ERROR");
               } 
            
            
           
            
         }
    
   
  private void getPanel2(){
            horario=new Horario();
            Horario hora = new Horario();
            Boolean est=(false);
            hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista10(jtNfactura.getText()));
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);
        
        
   //primero devuelvo el estok 
        
        otros= gh.getOtros();
        int cant=0;
        cant=otros.getStock()+gh.getCantidad();
        otros.setStock(cant);
        otros.actualizar();
   //ahora grabamos nuevamente
        
           Float pro= Float.parseFloat(jTPrecio.getText())*Float.parseFloat(jTCantidad.getText());
           int pu=  Integer.parseInt(jTPuntos.getText())*Integer.parseInt(jTCantidad.getText());
           Float uti=(Float.parseFloat(jTPrecio.getText())-otros.getCosto())*Float.parseFloat(jTCantidad.getText());;
//  restamos el valor  editado.
           
           Float tt=(Float.parseFloat(txtVtotal.getText())+pro)-gh.getTotalproducto();
           int tp=(Integer.parseInt(txtPtotal.getText())+pu)-gh.getTotalpuntos();
           Float tu=(Float.parseFloat(txtUtilidad.getText())+uti)-gh.getUtilidad(); 
        
        
           gh.setFechasalida(datFechaIngreso.getDate());
           gh.setNfactura(""+jtNfactura.getText());
           gh.setVuproducto(Float.parseFloat(jTPrecio.getText()));
           gh.setTotalproducto(pro);
           gh.setVupuntos(Float.parseFloat(jTPuntos.getText()));
           gh.setTotalpuntos(pu); 
           gh.setCantidad(Integer.parseInt(jTCantidad.getText()));
           gh.setHorario(hora);
           gh.setUsuario(hora.getUsuario());
           gh.setOtros(otros); 
           gh.setUtilidad(uti);
           gh.setFactura(factura);
           gh.setCosto(otros.getCosto());
           
           txtVtotal.setText(""+tt);
           txtPtotal.setText(""+tp);
           txtUtilidad.setText(""+tu); 
           otros.setStock(otros.getStock()-Integer.parseInt(jTCantidad.getText()));  
            otros.setUtilidad(otros.getUtilidad()+uti);
           otros.actualizar();
           
            
            Factura factura= new Factura();
            factura=factura.Busca(jtNfactura.getText());
            factura.setNdepo(""+jtNDeposito.getText());
            
            factura.setVtotal(tt);
            factura.setVpuntos(tp);
            factura.setUtilidad(tu);
            factura.actualizar();   
    
 if(venta.guardar()){
               //Mensaje.showError(this,"Producto agregado","ERROR");
              inicializa();
              setTabla1();
              }else{
                     Mensaje.showMensaje(this,"Editado con exito");
               } 
        

    }
    
    
 private void borra(){
 
     
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista10(jtNfactura.getText()));
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);
        
        
   //primero devuelvo el estok 
        
        otros= gh.getOtros();
        int cant=0;
        cant=otros.getStock()+gh.getCantidad();
        otros.setStock(cant);
        otros.setUtilidad(otros.getUtilidad()-gh.getUtilidad());
        otros.actualizar();    
// corregir la sumatoria de factura.  
        
           Float tt=(Float.parseFloat(txtVtotal.getText()))-gh.getTotalproducto();
           int tp=(Integer.parseInt(txtPtotal.getText()))-gh.getTotalpuntos();
           Float tu=(Float.parseFloat(txtUtilidad.getText()))-gh.getUtilidad(); 
           
           Factura g= new Factura();
           g=g.Busca(jtNfactura.getText());
            g.setVtotal(tt);
            g.setVpuntos(tp);
            g.setUtilidad(tu);
            g.actualizar();   
        
        gh.borrar();   
        setTabla1();
        txtVtotal.setText(""+tt);
        txtPtotal.setText(""+tp);
        txtUtilidad.setText(""+tu); 
        
   }
    
    
 private void setBlanco(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
         jTCantidad.setText("1"); 
         jTotal.setText("0");
         txtStock.setText("");
         jTPuntos.setText("");
         jTPrecio.setText("");
        
      
}
    
    
public void modoEdicion(boolean b){

    
           
    cboProductos.setEditable(b);
    cboLinea.setEnabled(b);
    cboProductos.setEnabled(b);
    jCParroquia.setEnabled(b);
    
    jTCantidad.setEditable(b);
    panMantenimiento1.setActiva(b);
    txtStock.setEditable(false);
    jTPuntos.setEditable(false);   
    jTPrecio.setEditable(false); 
    jTotal.setEditable(false);
    txtVtotal.setEditable(false);
    txtPtotal.setEditable(false);      
}

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
     private void setTabla(){
       
         //PARA PONER TODAS LAS FACTURAS
         Lista listaAnteriores =new Lista(new Factura().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFACTURA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     
     }
     private void setTabla1(){
       //PARA POnER LA LISTA DE PRODUCTOS POR NUEMRO DE FACTURA  
       Lista listaAnt = new Lista();
       listaAnt =new Lista(new VentaProductos().lista10(""+jtNfactura.getText()));
       if (listaAnt==null){
         Mensaje.showError(this, "EL NUMERO DE FACTURA INGRESADO NO ES VALIDO ", "Error");
         }else{
       //Mensaje.showError(this, "no es nulo "+ listaAnt.getSize(), "Error");
         Mapa mapa = new Mapa(listaAnt,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        }

     }
     
     private void setTabla2(){
          activado=false; 
     
         Lista listaAnteriores =new Lista(new Otros().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
       public void guardarFactura() {
        boolean b = Mensaje.showPregunta(this, "SEGURO QUE DESEA CERRAR LA FACTURA", "IMPRIMIR");
        if (b) {
            
            Factura li = new Factura();
            li = li.Busca(jtNfactura.getText());

            if (li == null) {
                Mensaje.showError(this, "No se ha ingresado el numero de FACTURA ", "Error");
            } else {

                horario = new Horario();
                Horario hora = new Horario();
                Boolean est = (false);
                hora = horario.buscar(est);

                if (activado == true) {

                    Lista listaAnteriores = new Lista(new VentaProductos().lista9(jtNfactura.getText(), hora));
                    try {
                        ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores, Mapa.MAPAVENTASDIA, true), ReportePrevio.VERVENTAS);
                        rp.setDesde(li.getFecha());
                        rp.setRespon(li.getCliente().getNombre() + " " + li.getCliente().getApellido());
                        rp.setAgencia(li.getCliente().getCodigocliente());
                        rp.setTelefono(li.getCliente().getTelefono());
                        rp.setDireccion(li.getCliente().getDireccion());
                        rp.setTotale(li.getVtotal());
                        rp.setPunto(li.getVpuntos());
                        rp.mostrarVistaPreliminar(MenuPrin.escritorio);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Date hora1;
                    hora1 = new Date();

                    Lista listaAnteriores = new Lista(new Otros().lista());
                    try {
                        ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores, Mapa.MAPAOTROSV, true), ReportePrevio.INVENTARIO);
                        rp.setRespon(otro.getUsuario().getNombre() + " " + otro.getUsuario().getApellido());
                        rp.setDesde(hora1);
                        rp.mostrarVistaPreliminar(MenuPrin.escritorio);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            li.setCerrada(true);
            li.actualizar();
            encerar();
        }
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jLabel16 = new javax.swing.JLabel();
        jLNombre1 = new javax.swing.JLabel();
        jLApellido1 = new javax.swing.JLabel();
        jLCedula1 = new javax.swing.JLabel();
        jLTelefono1 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTCedula = new javax.swing.JTextField();
        jLNombre2 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jLTelefono2 = new javax.swing.JLabel();
        jDireccion = new javax.swing.JTextField();
        jLTelefono3 = new javax.swing.JLabel();
        jCelular = new javax.swing.JTextField();
        jTelefono = new javax.swing.JTextField();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboLinea = new javax.swing.JComboBox();
        cboProductos = new javax.swing.JComboBox();
        jCParroquia = new javax.swing.JComboBox();
        jTotal = new javax.swing.JTextField();
        jTCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTPuntos = new javax.swing.JTextField();
        jBPrint1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTPrecio = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtNombre1 = new javax.swing.JTextField();
        jXPanel5 = new org.jdesktop.swingx.JXPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabelNombreGrup2 = new javax.swing.JLabel();
        jtNfactura = new javax.swing.JTextField();
        jLabelNombreGrup3 = new javax.swing.JLabel();
        jCTipoPago = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombreGrup7 = new javax.swing.JLabel();
        jtNDeposito = new javax.swing.JTextField();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        txtPtotal = new javax.swing.JTextField();
        txtVtotal = new javax.swing.JTextField();
        jLabelNombreGrup4 = new javax.swing.JLabel();
        jLabelNombreGrup5 = new javax.swing.JLabel();
        jLabelNombreGrup6 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pantalla para ver Cieeres Anteriores");

        jPanel1.setBackground(java.awt.SystemColor.window);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                 DATOS DEL USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("         Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        jPanel1.add(txtNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(panMantenimiento1, gridBagConstraints);

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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jXPanel2.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jXPanel2.setName("Panel de Miercoles"); // NOI18N
        jXPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("                               MODIFICAR FACTURAS    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 26);
        jXPanel2.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.textHighlight);
        jLabel13.setText("                      Busque por el numero la factura a modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 7, 0);
        jXPanel2.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 16, 7, 21);
        jPanel1.add(jXPanel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("                          DATOS DEL CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 7, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("SELECCION DEL PRODUCTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 57, 7, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jXPanel1.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel1.setDoubleBuffered(false);
        jXPanel1.setFocusCycleRoot(true);
        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 0, 153));
        jLabel16.setText("  ____________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 6, 25);
        jXPanel1.add(jLabel16, gridBagConstraints);

        jLNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLNombre1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLNombre1, gridBagConstraints);

        jLApellido1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLApellido1.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLApellido1, gridBagConstraints);

        jLCedula1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLCedula1.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLCedula1, gridBagConstraints);

        jLTelefono1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLTelefono1.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 0);
        jXPanel1.add(jLTelefono1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jTNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jTApellido, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jTCedula, gridBagConstraints);

        jLNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLNombre2.setText("Codigo 4 Life");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLNombre2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jTCodigo, gridBagConstraints);

        jLTelefono2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLTelefono2.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLTelefono2, gridBagConstraints);

        jDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDireccionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 8, 3, 17);
        jXPanel1.add(jDireccion, gridBagConstraints);

        jLTelefono3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLTelefono3.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLTelefono3, gridBagConstraints);

        jCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCelularActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jCelular, gridBagConstraints);

        jTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTelefonoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(jTelefono, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(6, 26, 5, 19);
        jPanel1.add(jXPanel1, gridBagConstraints);

        jXPanel3.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel3.setFocusCycleRoot(true);
        jXPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("_______________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 1, 11);
        jXPanel3.add(jLabel15, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel7.setText("Linea");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel8.setText("Existencias");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel8, gridBagConstraints);

        cboLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLineaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 23);
        jXPanel3.add(cboLinea, gridBagConstraints);

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jXPanel3.add(cboProductos, gridBagConstraints);

        jCParroquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCParroquiaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jXPanel3.add(jCParroquia, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 13, 20);
        jXPanel3.add(jTotal, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(jTCantidad, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel9.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(txtStock, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel23.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel23, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Informacion.png"))); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        jXPanel3.add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(jTPuntos, gridBagConstraints);

        jBPrint1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/print.png"))); // NOI18N
        jBPrint1.setText("Imprimir");
        jBPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrint1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jXPanel3.add(jBPrint1, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel19.setText("Tipo Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel19, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel24.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 16, 12);
        jXPanel3.add(jLabel24, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(jTPrecio, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel26.setText("Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel26, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Informacion.png"))); // NOI18N
        jButton4.setText("BORRAR TODO ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        jXPanel3.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 18, 10, 21);
        jPanel1.add(jXPanel3, gridBagConstraints);

        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre1.setForeground(java.awt.SystemColor.activeCaption);
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        jPanel1.add(txtNombre1, gridBagConstraints);

        jXPanel5.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel5.setDoubleBuffered(false);
        jXPanel5.setFocusCycleRoot(true);
        jXPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 0, 153));
        jLabel20.setText("---------------------------------------");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 8, 25);
        jXPanel5.add(jLabel20, gridBagConstraints);

        jLabelNombreGrup2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup2.setText("Numero de factura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel5.add(jLabelNombreGrup2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 21);
        jXPanel5.add(jtNfactura, gridBagConstraints);

        jLabelNombreGrup3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup3.setText("Tipo de Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel5.add(jLabelNombreGrup3, gridBagConstraints);

        jCTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoPagoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 21);
        jXPanel5.add(jCTipoPago, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("Busca factura");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jXPanel5.add(jButton2, gridBagConstraints);

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel5.add(lblFechaIngreso1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 1);
        jXPanel5.add(datFechaIngreso, gridBagConstraints);

        jLabelNombreGrup7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup7.setText("Numero de Deposito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel5.add(jLabelNombreGrup7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 18);
        jXPanel5.add(jtNDeposito, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 22, 8, 15);
        jPanel1.add(jXPanel5, gridBagConstraints);

        jXPanel6.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel6.setDoubleBuffered(false);
        jXPanel6.setFocusCycleRoot(true);
        jXPanel6.setLayout(new java.awt.GridBagLayout());

        txtPtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtPtotal.setForeground(java.awt.SystemColor.activeCaption);
        txtPtotal.setBorder(null);
        txtPtotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 11);
        jXPanel6.add(txtPtotal, gridBagConstraints);

        txtVtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtVtotal.setForeground(java.awt.SystemColor.activeCaption);
        txtVtotal.setBorder(null);
        txtVtotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 11);
        jXPanel6.add(txtVtotal, gridBagConstraints);

        jLabelNombreGrup4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup4.setText("Valor Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup4, gridBagConstraints);

        jLabelNombreGrup5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup5.setText("Total Utilidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup5, gridBagConstraints);

        jLabelNombreGrup6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup6.setText("Total Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 0, 11);
        jXPanel6.add(jLabelNombreGrup6, gridBagConstraints);

        txtUtilidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtUtilidad.setForeground(java.awt.SystemColor.activeCaption);
        txtUtilidad.setBorder(null);
        txtUtilidad.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 11);
        jXPanel6.add(txtUtilidad, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton3.setText("Todas las facturas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jXPanel6.add(jButton3, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton5.setText("facturas Abiertas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jXPanel6.add(jButton5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 16, 12);
        jPanel1.add(jXPanel6, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        // TODO add your handling code here:
        horario=new Horario();
        Factura g = new Factura();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        Lista listaA =new Lista(new VentaProductos().lista10(jtNfactura.getText()));

        
        
        if (listaA.getSize()>0){ 
           int fila=tblProducto.getSelectedRow();
           gh=(VentaProductos)listaA.getObject(fila);
           setPanel(gh); 
        }else{ 
           lista =new Lista(new Factura().lista());
             int fila=tblProducto.getSelectedRow();
             g=(Factura)lista.getObject(fila);
             setPanel2(g);
        }
        
        
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDireccionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
setTabla1();
Factura g= new Factura();
g=g.Busca(jtNfactura.getText());
setPanel2(g);

   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCelularActionPerformed

    private void jTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTelefonoActionPerformed

    private void cboLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLineaActionPerformed
        //****************************************************
        //CARGAR EL COMBO DE PRODUCTO
        //****************************************************

        linea = new Linea();
        linea=((Linea)lista.getObject(cboLinea.getSelectedIndex()));
        codigo =new Lista(new Otros().lista2(linea));

        if (codigo.getSize()>=1){
            cboProductos.setEnabled(true);

            modelo2 = new javax.swing.DefaultComboBoxModel();
            for(int i=0;i<codigo.getSize();i++){
                Otros b1=(Otros) codigo.getObject(i);
                modelo2.addElement(b1.getNombre());
            }
            cboProductos.setModel(modelo2);
        }else {
            cboProductos.setEnabled(false);
            Mensaje.showError(this,"No hay productos para esta linea ","Error");
        }

    }//GEN-LAST:event_cboLineaActionPerformed

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed

        linea=((Linea)lista.getObject(cboLinea.getSelectedIndex()));
        codigo =new Lista(new Otros().lista2(linea));

        otros = ((Otros)codigo.getObject(cboProductos.getSelectedIndex()));
        txtStock.setText(String.valueOf(otros.getStock()));
        //  txtVunitario.setText(String.valueOf(otros.getVunitario()));
        modelo3 = new javax.swing.DefaultComboBoxModel();
        modelo3.addElement(String.valueOf ("Publico $"+otros.getVunitario2()));
        modelo3.addElement(String.valueOf ("Lider $"+otros.getVunitario()));
        jCParroquia.setModel(modelo3);
        jTPuntos.setText(""+otros.getPuntos());
    }//GEN-LAST:event_cboProductosActionPerformed

    private void jCParroquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCParroquiaActionPerformed
        int a = jCParroquia.getSelectedIndex();
        if (a==0){
             jTPrecio.setText(""+otros.getVunitario2());
        }else
         jTPrecio.setText(""+otros.getVunitario());
        // TODO add your handling code here:
    }//GEN-LAST:event_jCParroquiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jTPrecio.getText().equals("")){
            Mensaje.showMensaje(this,"NO ha seleccionado un precio");
        }else {
            float vunit=Float.parseFloat(jTPrecio.getText());
            float cant = Float.parseFloat(jTCantidad.getText());
            float igual= (vunit * cant);
            jTotal.setText(String.valueOf(igual));
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrint1ActionPerformed

        guardarFactura();
        // TODO add your handling code here:
    }//GEN-LAST:event_jBPrint1ActionPerformed

    private void jCTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoPagoActionPerformed
 int a = jCTipoPago.getSelectedIndex();
       if (a==0){
           jtNDeposito.setEditable(false);
       }else
         jtNDeposito.setEditable(true);    
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTipoPagoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
setTabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
         Lista listaAnteriores =new Lista(new Factura().buscarAb(editar));
   //     if (listaAnteriores.getSize()>=1){
           // Mensaje.showMensaje(this,"NO ha seleccionado un precio;  "+listaAnteriores.getSize());
              Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFACTURA,true);
              reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
              tblProducto.setModel(modelo);
        //}
       
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        horario = new Horario();
        Horario hora = new Horario();
        Boolean est = (false);
        hora = horario.buscar(est);

        Factura li = new Factura();
        li = li.Busca(jtNfactura.getText());

        Lista listaAnteriores = new Lista(new VentaProductos().lista9(jtNfactura.getText(), hora));

        modoEdicion(false);
        modoEdicion2(false);
        encerar();
        setBlanco();

        boolean b = Mensaje.showPregunta(this, "SEGURO QUE DESEA BORRAR TODA LA FACTURA?", "IMPRIMIR");
        if (li!= null){
            if (b) {
                for(int j=0;j<listaAnteriores.getSize();j++){
                    venta=(VentaProductos)listaAnteriores.getObject(j);
                    //primero devuelvo el estok
                    otros= venta.getOtros();
                    int cant=0;
                    cant=otros.getStock()+venta.getCantidad();
                    otros.setStock(cant);
                    otros.setUtilidad(otros.getUtilidad()-venta.getUtilidad());
                    otros.actualizar();
                    venta.borrar();
                }
                li.borrar();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboLinea;
    private javax.swing.JComboBox cboProductos;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBPrint1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jCParroquia;
    private javax.swing.JComboBox jCTipoPago;
    private javax.swing.JTextField jCelular;
    private javax.swing.JTextField jDireccion;
    private javax.swing.JLabel jLApellido1;
    private javax.swing.JLabel jLCedula1;
    private javax.swing.JLabel jLNombre1;
    private javax.swing.JLabel jLNombre2;
    private javax.swing.JLabel jLTelefono1;
    private javax.swing.JLabel jLTelefono2;
    private javax.swing.JLabel jLTelefono3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelNombreGrup2;
    private javax.swing.JLabel jLabelNombreGrup3;
    private javax.swing.JLabel jLabelNombreGrup4;
    private javax.swing.JLabel jLabelNombreGrup5;
    private javax.swing.JLabel jLabelNombreGrup6;
    private javax.swing.JLabel jLabelNombreGrup7;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCantidad;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JTextField jTPuntos;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jTotal;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel5;
    private org.jdesktop.swingx.JXPanel jXPanel6;
    private javax.swing.JTextField jtNDeposito;
    private javax.swing.JTextField jtNfactura;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtPtotal;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUtilidad;
    private javax.swing.JTextField txtVtotal;
    // End of variables declaration//GEN-END:variables
    
}
