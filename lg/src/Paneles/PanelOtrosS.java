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
private Otros otros;
private String mensaje="";
private boolean editar;
private VentaProductos venta;
private VentaProductos mas;
private Provedor provedor;
private Tarjetas tarjetas;

Boolean activado;
VentaProductos gh;
Lista listaAnteriores;

    public PanelOtrosS() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
        
         otros = new Otros();
                   lista = new Lista(new Otros().lista());
                   for(int i=0;i<lista.getSize();i++){
                   Otros b1=(Otros) lista.getObject(i);
                   cboProductos.addItem(b1.getNombre());
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
   cboProductos.setSelectedItem(otros.getNombre().toString());
       
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
   cboProductos.setSelectedItem(gg.getOtros().getNombre().toString());
   txCodigo.setText(""+gg.getId_Venta());     
    }  
    
    
    private void getPanel(){
      
       if (jRadioButton1.isSelected()==true){
            venta.setOtros((Otros)lista.getObject(cboProductos.getSelectedIndex()));
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
           otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
        
           otros.setStock(otros.getStock()-Integer.parseInt(txtCantidad.getText()));    
           otros.actualizar();    
            
        }
        if(jRadioButton2.isSelected()==true){
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
            
        }
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
        if(jRadioButton1.isSelected()==true){
           gh.setOtros((Otros)lista.getObject(cboProductos.getSelectedIndex()));
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
        
        
        if(jRadioButton2.isSelected()==true){
           gh.setOtros((Otros)lista.getObject(cboProductos.getSelectedIndex()));
           gh.setFechasalida(datFechaIngreso.getDate());
           Float sun= Float.parseFloat(txtVunitario.getText())*Float.parseFloat(txtCantidad.getText());
           gh.setTotal(sun);
           gh.setCredito(txtCantidad.getText());
           gh.setContado("0");
           gh.setNombre(txNombre.getText());
           gh.setCedula(txCedula.getText());
           gh.setPagado(false);
           gh.setHorario(hora);
           gh.setUsuario(hora.getUsuario());
           gh.actualizar(); 
        } 

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

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        cboProductos = new javax.swing.JComboBox();
        haybodega = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        vunitario = new javax.swing.JLabel();
        txtVunitario = new javax.swing.JTextField();
        cliente = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        total = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelCedula3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cantidadcomprar = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jBPrint = new javax.swing.JButton();
        jBEstado = new javax.swing.JButton();
        cedula = new javax.swing.JLabel();
        txCedula = new javax.swing.JTextField();
        jLabelSubtitulo7 = new javax.swing.JLabel();
        cliente1 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                     SALIDA DE PRODUCTOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                            Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(cboProductos, gridBagConstraints);

        haybodega.setText("                            Hay en Bodega");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(haybodega, gridBagConstraints);

        txtStock.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtStock, gridBagConstraints);

        vunitario.setText("                            V Unitario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(vunitario, gridBagConstraints);

        txtVunitario.setEditable(false);
        txtVunitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtVunitarioKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtVunitario, gridBagConstraints);

        cliente.setText("                            Nombre del Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cliente, gridBagConstraints);

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCantidad, gridBagConstraints);

        total.setText("                            Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(total, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtTotal, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Informacion.png")));
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton1, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                             DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                            Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(txtNombre, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png")));
        jButton2.setText("Ver Inventario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
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
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelCedula3.setText("                            Nombre del Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula3, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Profesor.png")));
        jButton3.setText("Ver Ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton3, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Pago Contado");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 1, 17, 1);
        add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Pago Credito");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(15, 1, 17, 1);
        add(jRadioButton2, gridBagConstraints);

        cantidadcomprar.setText("                            Cantidad a Comprar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cantidadcomprar, gridBagConstraints);

        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNombreKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txNombre, gridBagConstraints);

        jBPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/print.png")));
        jBPrint.setText("Imprimir");
        jBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrintActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        add(jBPrint, gridBagConstraints);

        jBEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/ayuda.png")));
        jBEstado.setText("ESTADO");
        jBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEstadoActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jBEstado, gridBagConstraints);

        cedula.setText("                            Cedula del Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cedula, gridBagConstraints);

        txCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCedulaKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txCedula, gridBagConstraints);

        jLabelSubtitulo7.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo7.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo7.setText("                             DATOS DEL CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelSubtitulo7, gridBagConstraints);

        cliente1.setText("                            Numero de credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(cliente1, gridBagConstraints);

        txCodigo.setEditable(false);
        txCodigo.setDragEnabled(true);
        txCodigo.setEnabled(false);
        txCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodigoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txCodigo, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigoKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_txCodigoKeyPressed

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

    private void txNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_txNombreKeyPressed

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

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed
        Otros otros;
        otros = ((Otros)lista.getObject(cboProductos.getSelectedIndex()));
        txtStock.setText(String.valueOf(otros.getStock()));
        txtVunitario.setText(String.valueOf(otros.getVunitario()));
    }//GEN-LAST:event_cboProductosActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cantidadcomprar;
    private javax.swing.JComboBox cboProductos;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel cliente1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel haybodega;
    private javax.swing.JButton jBEstado;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelCedula3;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JLabel jLabelSubtitulo7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txCedula;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVunitario;
    private javax.swing.JLabel vunitario;
    // End of variables declaration//GEN-END:variables
    
}
