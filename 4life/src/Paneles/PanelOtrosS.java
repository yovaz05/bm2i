/*
 * PanelOtrosS.java
 *
 * Created on 5 de noviembre de 2006, 9:33
 */

package Paneles;

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



public class PanelOtrosS extends javax.swing.JPanel {
    
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

Boolean activado;
VentaProductos gh;
Lista listaAnteriores;

    public PanelOtrosS() {
       
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
       jButton6.setEnabled(true);
       txtVtotal.setText("0");
       txtPtotal.setText("0");
       txtUtilidad.setText("0");
       enblanco();
       setBlanco();
       setTabla();
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

  
  setTabla();
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
            
            setTabla();
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR LLENE TODOS LOS CAMPOS","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR","Eliminar");
        if (b){
            borra();
            setTabla();
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
    
   jTNombre.setText(""+cli.getNombres());
   jTApellido.setText(""+cli.getApellidos());
   jTCedula.setText(""+cli.getCedularuc());
   jTelefono.setText(""+cli.getTelefono());
   jCelular.setText(""+cli.getCelular());
   jDireccion.setText(""+cli.getNombre());//Nombres igual a direccion       
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

      jButton4.setEnabled(b);
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
                        cli.setNombres(jTNombre.getText());
                        cli.setApellidos(jTApellido.getText());
                        cli.setCedularuc(jTCedula.getText());
                        cli.setTelefono(jTelefono.getText());
                        cli.setCelular(jCelular.getText());
                        cli.setNombre(jDireccion.getText());
                        cli.guardar();   
                        if(cli.guardar()){
                            modoEdicion2(false);
                            Mensaje.showMensaje(this,"Se ha creado el Cliente con EXITO");
                            modoEdicion2(false);
                            jButton2.setEnabled(false);
                jButton6.setEnabled(false);
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
 //jTCantidad.setEditable(true);
    cboLinea.setSelectedItem(gg.getOtros().getLinea().getNombre()); 
    cboProductos.setSelectedItem(gg.getOtros().getNombre());  
    jTCantidad.setText(""+gg.getCantidad());
    txtStock.setText(""+gg.getOtros().getStock());
    jTPuntos.setText(""+gg.getOtros().getPuntos());
    jTPrecio.setText(""+gg.getVuproducto());
   jTotal.setText(""+gg.getTotalproducto());
 // int p;
   //txtPrecio.setText(""+gg.getOtros().getStock());
   //   cboLinea.setSelectedItem(gg.getOtros().getNombre().toString());
  // txCodigo.setText(""+gg.getId_Venta());     
    }  
    
    
    private void getPanel(){
        /* xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                   OPERACIONES MATEMATICAS*/
           linea=((Linea)lista.getObject(cboLinea.getSelectedIndex()));
           codigo =new Lista(new Otros().lista2(linea));
           otros = ((Otros)codigo.getObject(cboProductos.getSelectedIndex()));
      
            jCTipoPago.setEnabled(false);   
           
           Cliente cli = new Cliente();        
           String bus = jTCodigo.getText();
           cli = cli.buscarCodigo(bus);
           
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
        
           Factura li =new Factura();
           li=li.Busca(jtNfactura.getText());
           if(li==null){
                        factura = new Factura();
                        factura.setCerrada(false);
                        factura.setFecha(datFechaIngreso.getDate());
                        factura.setNumero(""+jtNfactura.getText());
                        int a = jCTipoPago.getSelectedIndex();
                        if (a==0){
                        factura.setTpago("Efectivo");
                        }else
                        factura.setTpago("Deposito");   
                        factura.setVtotal(tt);
                        factura.setVpuntos(tp);
                        factura.setUtilidad(tu);
                        factura.setCliente(cli);
                        factura.setHorario(hora);
                      
                        
                         if(factura.guardar()){
                            Mensaje.showMensaje(this,"PRODUCTO AGREGADO"); 
                         }
           }
           
    /* xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                                  FIN  FACTURA Y GRABO VENTAS
       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX*/        
           
         Factura l =new Factura();
         l=l.Busca(jtNfactura.getText());   
        if((l.getCerrada().equals(false)) |(l.getCerrada().equals(null))){
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
           otros.actualizar();
           
            factura.setVtotal(tt);
            factura.setVpuntos(tp);
            factura.setUtilidad(tu);
            factura.actualizar();   
           
           
           
           if(venta.guardar()){
               //Mensaje.showError(this,"Producto agregado","ERROR");
              inicializa();
              setTabla();
              }else{
                     Mensaje.showError(this,"NO se ha podido agregar el producto","ERROR");
               } 
            
        } else{
                     Mensaje.showError(this,"factura cerrada","ERROR");
               }    
           
            
         }
    
   
  private void getPanel2(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista9(jtNfactura.getText(),hora));
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
           otros.actualizar();
           
            factura.setVtotal(tt);
            factura.setVpuntos(tp);
            factura.setUtilidad(tu);
            factura.actualizar();   
    
 if(venta.guardar()){
               //Mensaje.showError(this,"Producto agregado","ERROR");
              inicializa();
              setTabla();
              }else{
                     Mensaje.showMensaje(this,"Editado con exito");
               } 
        

    }
    
    
 private void borra(){
 
     
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista9(jtNfactura.getText(),hora));
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);
        
        
   //primero devuelvo el estok 
        
        otros= gh.getOtros();
        int cant=0;
        cant=otros.getStock()+gh.getCantidad();
        otros.setStock(cant);
        otros.actualizar();    
// corregir la sumatoria de factura.  
        
           Float tt=(Float.parseFloat(txtVtotal.getText()))-gh.getTotalproducto();
           int tp=(Integer.parseInt(txtPtotal.getText()))-gh.getTotalpuntos();
           Float tu=(Float.parseFloat(txtUtilidad.getText()))-gh.getUtilidad(); 
        factura.setVtotal(tt);
            factura.setVpuntos(tp);
            factura.setUtilidad(tu);
            factura.actualizar();   
        
        gh.borrar();   
        setTabla();
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
   if (jtNfactura.getText().equals("")){
            jtNfactura.setEditable(b);
        }else {
       jtNfactura.setEditable(false);
   }
    
           
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
         activado=true;
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
               
                
         Lista listaAnteriores =new Lista(new VentaProductos().lista9(jtNfactura.getText(),hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     
     }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLNombre1 = new javax.swing.JLabel();
        jLApellido1 = new javax.swing.JLabel();
        jLCedula1 = new javax.swing.JLabel();
        jLTelefono1 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jTCedula = new javax.swing.JTextField();
        jLNombre2 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jLTelefono2 = new javax.swing.JLabel();
        jDireccion = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLTelefono3 = new javax.swing.JLabel();
        jCelular = new javax.swing.JTextField();
        jTelefono = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboLinea = new javax.swing.JComboBox();
        cboProductos = new javax.swing.JComboBox();
        jCParroquia = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jTotal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jTCantidad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTPuntos = new javax.swing.JTextField();
        jBPrint1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jXPanel5 = new org.jdesktop.swingx.JXPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabelNombreGrup2 = new javax.swing.JLabel();
        jtNfactura = new javax.swing.JTextField();
        jLabelNombreGrup3 = new javax.swing.JLabel();
        jCTipoPago = new javax.swing.JComboBox();
        jXPanel6 = new org.jdesktop.swingx.JXPanel();
        jLabel24 = new javax.swing.JLabel();
        txtPtotal = new javax.swing.JTextField();
        txtVtotal = new javax.swing.JTextField();
        jLabelNombreGrup4 = new javax.swing.JLabel();
        jLabelNombreGrup5 = new javax.swing.JLabel();
        jLabelNombreGrup6 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JTextField();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                                                                            DATOS DEL USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                                                                                                                                                      Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(txtNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jXPanel2.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jXPanel2.setName("Panel de Miercoles"); // NOI18N
        jXPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("                               EGRESO DE MERCADERIA           ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 26);
        jXPanel2.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.textHighlight);
        jLabel13.setText("                      Selección de cliente,  y elegir  los productos a vender.");
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
        add(jXPanel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("                          DATOS DEL CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 7, 0);
        add(jLabel4, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("SELECCION DEL PRODUCTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 57, 7, 0);
        add(jLabel1, gridBagConstraints);

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

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(lblFechaIngreso1, gridBagConstraints);

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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 17);
        jXPanel1.add(datFechaIngreso, gridBagConstraints);
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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton4.setText("GRABAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(11, 15, 11, 5);
        jXPanel1.add(jButton4, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("Busca Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jXPanel1.add(jButton2, gridBagConstraints);

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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton6.setText("Crear Cliente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(11, 15, 11, 5);
        jXPanel1.add(jButton6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.insets = new java.awt.Insets(6, 26, 7, 19);
        add(jXPanel1, gridBagConstraints);

        jXPanel3.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel3.setFocusCycleRoot(true);
        jXPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("  _________________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 11, 19);
        jXPanel3.add(jLabel15, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel7.setText("Linea");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel8.setText("Existencias");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.gridy = 3;
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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jXPanel3.add(jCParroquia, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel21.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 16, 12);
        jXPanel3.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 13, 20);
        jXPanel3.add(jTotal, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel22.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(32, 20, 0, 11);
        jXPanel3.add(jLabel22, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(jTPrecio, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel9.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 21);
        jXPanel3.add(txtStock, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(32, 0, 0, 20);
        jXPanel3.add(jTCantidad, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel23.setText("Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        jXPanel3.add(jButton1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        jXPanel3.add(jBPrint1, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel19.setText("Tipo Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 10, 21);
        add(jXPanel3, gridBagConstraints);

        txtNombre1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre1.setForeground(java.awt.SystemColor.activeCaption);
        txtNombre1.setBorder(null);
        txtNombre1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 11);
        add(txtNombre1, gridBagConstraints);

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
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 18);
        jXPanel5.add(jtNfactura, gridBagConstraints);

        jLabelNombreGrup3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup3.setText("Tipo de Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jXPanel5.add(jCTipoPago, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 22, 8, 15);
        add(jXPanel5, gridBagConstraints);

        jXPanel6.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel6.setDoubleBuffered(false);
        jXPanel6.setFocusCycleRoot(true);
        jXPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 0, 153));
        jLabel24.setText("---------------------------------------");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 8, 25);
        jXPanel6.add(jLabel24, gridBagConstraints);

        txtPtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtPtotal.setForeground(java.awt.SystemColor.activeCaption);
        txtPtotal.setBorder(null);
        txtPtotal.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 11);
        jXPanel6.add(txtUtilidad, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 23, 16, 16);
        add(jXPanel6, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista9(jtNfactura.getText(),hora));
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            
      Cliente cli = new  Cliente();
      if (jTCodigo.getText().equals("")){
      Mensaje.showError(this,"No ha ingresado ningun codigo","Error");
      enblanco();
      }else{
      String bus = jTCodigo.getText();
      cli = cli.buscarCodigo(bus);
      if (cli==null){
                 Mensaje.showError(this,"No hay ningun Cliente con este codigo intente denuevo","Error");
                 enblanco();
      }else{
                setPanel2(cli);
                jButton2.setEnabled(false);
                jButton6.setEnabled(false);
       }
    }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
 private void setTabla2(){
          activado=false; 
     
         Lista listaAnteriores =new Lista(new Otros().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }

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

    private void jDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDireccionActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
getPanellinete();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCelularActionPerformed

    private void jTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTelefonoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     modoEdicion2(true);
             // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jBPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrint1ActionPerformed

         boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA CERRAR LA FACTURA","IMPRIMIR");
        if (b){
            
        
        
        
           Factura li =new Factura();
           li=li.Busca(jtNfactura.getText());
       
           if(li==null){
               Mensaje.showError(this,"No se ha ingresado el numero de FACTURA ","Error");
           }else{
                    
                    horario=new Horario();
                    Horario hora= new Horario();
                    Boolean est=(false);
                    hora=horario.buscar(est);
        
                    if (activado==true){

                         Lista listaAnteriores =new Lista(new VentaProductos().lista9(jtNfactura.getText(),hora));
                         try {
                              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAVENTASDIA,true),ReportePrevio.VERVENTAS);
                             rp.setDesde(li.getFecha());
                             rp.setRespon(li.getCliente().getNombres()+" "+otro.getUsuario().getApellido());
                             rp.setAgencia(li.getCliente().getCodigocliente());
                             rp.setTelefono(li.getCliente().getTelefono());
                             rp.setDireccion(li.getCliente().getNombre());
                             rp.setTotale(li.getVtotal());
                             rp.setPunto(li.getVpuntos());
                              rp.mostrarVistaPreliminar(MenuPrin.escritorio);
                             } catch (Exception e) {
                               e.printStackTrace();
                             }

                        }else{
                         Date hora1;
                         hora1= new Date();

                         Lista listaAnteriores =new Lista(new Otros().lista());
                         try {
                              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true),ReportePrevio.INVENTARIO);
                              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
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
  }      // TODO add your handling code here:
    }//GEN-LAST:event_jBPrint1ActionPerformed

    private void jCTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTipoPagoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboLinea;
    private javax.swing.JComboBox cboProductos;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBPrint1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel jLabelSubtitulo6;
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
