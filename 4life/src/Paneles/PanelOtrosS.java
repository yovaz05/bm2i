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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.MapaVentasdia;
import reportesXML.ReportePrevio;
import beans.Tarjetas;


public class PanelOtrosS extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Lista tar;
private Horario horario;
Otros otros;
private String mensaje="";
private boolean editar;
private VentaProductos venta;
private VentaProductos mas;
private Provedor provedor;
private Tarjetas tarjetas;
private javax.swing.DefaultComboBoxModel modelo2;
Linea linea;
Lista tres;

Boolean activado;
VentaProductos gh;
Lista listaAnteriores;

    public PanelOtrosS() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
        combos();
         
    }
    
    
    private void combos(){
     
    linea = new Linea();
    lista = new Lista(new Linea().lista());
    for(int i=0;i<lista.getSize();i++){
                                        Linea b1=(Linea) lista.getObject(i);
                                        cboLinea.addItem(b1.getNombre());
                                       }
 }
    
    
    
    private boolean isVacio(){
 if(txtStock.getText().equalsIgnoreCase("")    | (txtVunitario.getText().equalsIgnoreCase("")) 
    |(txtCantidad.getText().equalsIgnoreCase(""))  | (txtTotal.getText().equalsIgnoreCase(""))
        )
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
                   codigo = new Lista(new VentaProductos().lista2(otro));
                   venta=(VentaProductos) codigo.ultimo();
                   
                   modoEdicion(false);
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
                           venta = new VentaProductos();
                           getPanel(); 
                            if(venta.guardar()){
                                                inicializa();
                                                 setTabla();
                                               }else{
                                                     return false;
                                                    }
         }
       return true;
   } 
    
    private void aceptar(){
     
            if(saveOrUpdate()){
            Mensaje.showMensaje(this,"Se ha realizado la venta con EXITO");
            modoEdicion(false);
            setTabla();
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
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
            venta=(VentaProductos)lista.getMyself();
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
    
   txtStock.setText(""+otros.getStock());
   txtVunitario.setText(""+otros.getVunitario());
   int p=Integer.parseInt(venta.getContado());
    if (p==0){
      txtCantidad.setText(""+venta.getCredito());  
   }else{
       txtCantidad.setText(""+venta.getContado());  
   }
   txtTotal.setText(""+venta.getTotal());
   txNombre.setText(""+venta.getNombre());
   cboLinea.setSelectedItem(otros.getNombre().toString());
       
} 
private void setPanel(VentaProductos gg){
 
  int p;
   txtStock.setText(""+gg.getOtros().getStock());
   txtVunitario.setText(""+gg.getOtros().getVunitario());
   
   if (gg.getContado().equals(null)){
       p=0;
       gg.setContado("0");
       gg.actualizar();
   }else{
          p=Integer.parseInt(gg.getContado());
          if (p==0){
                   txtCantidad.setText(""+gg.getCredito());  
          }else{
             txtCantidad.setText(""+gg.getContado());  
           } 
    }
   
   p=Integer.parseInt(gg.getContado());
   if (p==0){
      txtCantidad.setText(""+gg.getCredito());  
   }else{
       txtCantidad.setText(""+gg.getContado());  
   }
   
   txtTotal.setText(""+gg.getTotal());
   txNombre.setText(""+gg.getNombre());
   txCedula.setText(gg.getCedula());
   cboLinea.setSelectedItem(gg.getOtros().getNombre().toString());
   txCodigo.setText(""+gg.getId_Venta());     
    }  
    
    
    private void getPanel(){
      
      
            venta.setOtros((Otros)lista.getObject(cboLinea.getSelectedIndex()));
            venta.setFechasalida(datFechaIngreso.getDate());
            venta.setTotal(Float.parseFloat(txtTotal.getText()));
            venta.setContado(txtCantidad.getText());
            venta.setCredito("0");
            venta.setNombre(txNombre.getText());
            venta.setCedula(txCedula.getText());
            venta.setPagado(true);
            
           horario=new Horario();
           Horario hora = new Horario();
           Boolean est=(false);
           hora=horario.buscar(est);
        
           venta.setHorario(hora);
           venta.setUsuario(hora.getUsuario());
        
           Otros otros;
           otros = ((Otros)lista.getObject(cboLinea.getSelectedIndex()));
        
           otros.setStock(otros.getStock()-Integer.parseInt(txtCantidad.getText()));    
           otros.actualizar();    
            
        /*        if(jRadioButton2.isSelected()==true){
            venta.setOtros((Otros)lista.getObject(cboProductos.getSelectedIndex()));
            venta.setFechasalida(datFechaIngreso.getDate());
            venta.setTotal(Float.parseFloat(txtTotal.getText()));
            venta.setCredito(txtCantidad.getText());
            venta.setContado("0");
            venta.setNombre(txNombre.getText());
            venta.setCedula(txCedula.getText());
            venta.setPagado(false);
            
           horario=new Horario();
           Horario hora = new Horario();
           Boolean est=(false);
           hora=horario.buscar(est);
        
           venta.setHorario(hora);
           venta.setUsuario(hora.getUsuario());
        
           Otros otros;
           otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
        
           otros.setStock(otros.getStock()-Integer.parseInt(txtCantidad.getText()));    
           otros.actualizar();    
            
        }*/
  }
    
   
  private void getPanel2(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
               
        Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
        int fila=tblProducto.getSelectedRow();
        if (fila<0){
            Mensaje.showError(this,"No ha elejido ningun producto","ERROR");
        }else{
               gh=(VentaProductos)listaAnteriores.getObject(fila);
//#########################################################################################
        //RESTRUCTURO EL ANTIGUO ESTOK
        Otros otros=new Otros();
        otros=gh.getOtros();
        if (gh.getCredito().equals(null)){
            gh.setCredito("0");
            gh.actualizar();
        }
            
        int ant= otros.getStock()+Integer.parseInt(gh.getContado())+Integer.parseInt(gh.getCredito());
        otros.setStock(ant-Integer.parseInt(txtCantidad.getText()));
        otros.actualizar();
//#########################################################################################        
       
           gh.setOtros((Otros)lista.getObject(cboLinea.getSelectedIndex()));
           gh.setFechasalida(datFechaIngreso.getDate());
           Float sun= Float.parseFloat(txtVunitario.getText())*Float.parseFloat(txtCantidad.getText());
           gh.setTotal(sun);
           gh.setContado(txtCantidad.getText());
           gh.setCredito("0");
           gh.setNombre(txNombre.getText());
           gh.setCedula(txCedula.getText());
           gh.setPagado(true);
           gh.setHorario(hora);
           gh.setUsuario(hora.getUsuario());
           gh.actualizar();  
 
        }

        

    }
    
    
 private void borra(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        
        Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
     
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);     
//#########################################################################################
        //SE DEBE SUMAR LO QUE SE BORRA A LA TABLA OTROS
        Otros otros = new Otros();
        otros= gh.getOtros();
        otros.setStock(otros.getStock()+Integer.parseInt(gh.getContado())+Integer.parseInt(gh.getCredito()));
        otros.actualizar();
//#########################################################################################       
        
        gh.borrar();   
        setTabla();
        
        
   }
    
    
 private void setBlanco(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         
         
   Lista tar =new Lista(new VentaProductos().lista2(hora));
   
     if(tar.getSize()!=0){
        venta=(VentaProductos) tar.getObject(tar.getSize()-1);
        txCodigo.setText(""+(venta.getId_Venta()+1));
     }
   txtCantidad.setText("0"); 
   txtTotal.setText("0");
     
}
    
    
public void modoEdicion(boolean b){

      txtCantidad.setEditable(b);
      txtTotal.setEditable(b);
      txNombre.setEditable(b);
      txCedula.setEditable(b);
      panMantenimiento1.setActiva(b);
      
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
               
                
         Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     
     }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        vunitario = new javax.swing.JLabel();
        txtVunitario = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jButton3 = new javax.swing.JButton();
        cantidadcomprar = new javax.swing.JLabel();
        jBPrint = new javax.swing.JButton();
        jBEstado = new javax.swing.JButton();
        cedula = new javax.swing.JLabel();
        txCedula = new javax.swing.JTextField();
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
        jCelular = new javax.swing.JTextField();
        jLNombre2 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jLTelefono2 = new javax.swing.JLabel();
        jTelefono = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cboLinea = new javax.swing.JComboBox();
        cboProductos = new javax.swing.JComboBox();
        jCParroquia = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        vunitario.setText("                            V Unitario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(vunitario, gridBagConstraints);

        txtVunitario.setEditable(false);
        txtVunitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVunitarioKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtVunitario, gridBagConstraints);

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCantidad, gridBagConstraints);

        total.setText("                            Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(total, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtTotal, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Informacion.png"))); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton1, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                             DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                            Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 24;
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
        gridBagConstraints.gridy = 25;
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
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Profesor.png"))); // NOI18N
        jButton3.setText("Ver Ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton3, gridBagConstraints);

        cantidadcomprar.setText("                            Cantidad a Comprar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cantidadcomprar, gridBagConstraints);

        jBPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/print.png"))); // NOI18N
        jBPrint.setText("Imprimir");
        jBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrintActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        add(jBPrint, gridBagConstraints);

        jBEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/ayuda.png"))); // NOI18N
        jBEstado.setText("ESTADO");
        jBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEstadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jBEstado, gridBagConstraints);

        cedula.setText("                            Cedula del Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cedula, gridBagConstraints);

        txCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCedulaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txCedula, gridBagConstraints);

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
        jLTelefono1.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
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

        jCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCelularActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 11, 17);
        jXPanel1.add(jCelular, gridBagConstraints);

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
        jLTelefono2.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        jXPanel1.add(jLTelefono2, gridBagConstraints);

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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton4.setText("Crear Cliente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(11, 15, 11, 0);
        jXPanel1.add(jButton4, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("Busca Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        jXPanel1.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        jLabel8.setText("Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel8, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel17.setText("Existencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel17, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel18.setText("Costo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 0, 12);
        jXPanel3.add(jLabel18, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabel19.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 21, 16, 12);
        jXPanel3.add(jLabel19, gridBagConstraints);

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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jXPanel3.add(jCParroquia, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 22);
        jXPanel3.add(jTextField3, gridBagConstraints);

        txtStock.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jXPanel3.add(txtStock, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 10, 21);
        add(jXPanel3, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton5.setText("Ver Inventario");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton5, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCedulaKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_txCedulaKeyPressed

    private void jBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEstadoActionPerformed

      tarjetas = new Tarjetas();
      horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
     
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
         Mapa mapa = new Mapa(tar,Mapa.MAPATARJETAS,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);              
         Date p = new Date();
         
//         try {
//              ReportePrevio rp = new ReportePrevio(new Mapa(tar,Mapa.MAPATARJETAS,true),ReportePrevio.TARJETAS);
//              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
//              rp.setDesde(p);
//              rp.mostrarVistaPreliminar(MenuPrin.escritorio);
//             } catch (Exception e) {
//               e.printStackTrace();
//             } 
    }//GEN-LAST:event_jBEstadoActionPerformed

    private void jBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrintActionPerformed
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        
        if (activado==true){
            
         Lista listaAnteriores =new Lista(new VentaProductos().lista2(otro));
         try {
              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAVENTASDIA,true),ReportePrevio.VERVENTAS);
              rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
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
    }//GEN-LAST:event_jBPrintActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
        float vunit=Float.parseFloat(txtVunitario.getText());
        float cant = Float.parseFloat(txtCantidad.getText());
        float igual= (vunit * cant);
        txtTotal.setText(String.valueOf(igual));
        }  
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtVunitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVunitarioKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtCantidad.requestFocus();
            
        }  
    }//GEN-LAST:event_txtVunitarioKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
setTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
               
                
         Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
        
        
        
        int fila=tblProducto.getSelectedRow();
        gh=(VentaProductos)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed
 private void setTabla2(){
          activado=false; 
     
         Lista listaAnteriores =new Lista(new Otros().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        float vunit=Float.parseFloat(txtVunitario.getText());
        float cant = Float.parseFloat(txtCantidad.getText());
        float igual= (vunit * cant);
        txtTotal.setText(String.valueOf(igual));
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
        txtVunitario.setText(String.valueOf(otros.getVunitario()));
   
    }//GEN-LAST:event_cboProductosActionPerformed

    private void jCParroquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCParroquiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCParroquiaActionPerformed

    private void jTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTelefonoActionPerformed

    private void jCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCelularActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cantidadcomprar;
    private javax.swing.JComboBox cboLinea;
    private javax.swing.JComboBox cboProductos;
    private javax.swing.JLabel cedula;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBEstado;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jCParroquia;
    private javax.swing.JTextField jCelular;
    private javax.swing.JLabel jLApellido1;
    private javax.swing.JLabel jLCedula1;
    private javax.swing.JLabel jLNombre1;
    private javax.swing.JLabel jLNombre2;
    private javax.swing.JLabel jLTelefono1;
    private javax.swing.JLabel jLTelefono2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jTextField3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txCedula;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVunitario;
    private javax.swing.JLabel vunitario;
    // End of variables declaration//GEN-END:variables
    
}
