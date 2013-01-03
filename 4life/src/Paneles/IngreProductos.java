/*
 * IngreProductos.java
 *
 * Created on 4 de noviembre de 2006, 20:01
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.VentaProductos;
import beans.Otros;
import beans.Linea;
import beans.Horario;
import clases.MenuPrin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;

public class IngreProductos extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private Otros otros;
private String mensaje="";
private boolean editar;
private VentaProductos produc;
Otros gh;
Linea linea;
Lista listaAnteriores;
Boolean activado;


    public IngreProductos() {
        horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
        if (hora==null){
            Mensaje.showMensaje(this,"DEBE INICIAR CESION  CIERRE Y ABRA EL PROGRAMA NUEVAMENTE");
        }else{
       initComponents();
        fijaMetodos();
        combos();
        inicializa();
        setTabla();
        }
        
      
    }
    
private boolean isVacio(){
  if(txtFactura.getText().equalsIgnoreCase("") | txtNombreC.getText().equalsIgnoreCase("") 
     | txtVunitario.getText().equalsIgnoreCase("") | txtMaxima.getText().equalsIgnoreCase("") | txtMinima.getText().equalsIgnoreCase("")
     | txtPublico.getText().equalsIgnoreCase("") | txtPuntos.getText().equalsIgnoreCase("") | txtUnidad.getText().equalsIgnoreCase("")
     | txtCosto.getText().equalsIgnoreCase(""))

      return true;
  return false;
        } 
   


 private void combos(){
     
      linea = new Linea();
    lista = new Lista(new Linea().lista());
    for(int i=0;i<lista.getSize();i++){
                                        Linea b1=(Linea) lista.getObject(i);
                                        cboAgencia.addItem(b1.getNombre());
                                       }
 }
 private void inicializa(){

                                      
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                   otros = new Otros();
                   codigo = new Lista(new Otros().lista3(otro));
                   otros=(Otros) codigo.ultimo();
                   
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
                             otros=new Otros();
                             getPanel();
                             if(otros.guardar()){
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
            Mensaje.showMensaje(this,"GUARDADO");
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
            //otros=(Otros)lista.getMyself();
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
        otros=(Otros)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
       otros=(Otros)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        otros=(Otros)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        otros=(Otros)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        txtFactura.setText(""+otros.getStock());
        txtNombreC.setText(""+otros.getNombre());
        txtVunitario.setText(""+otros.getVunitario());//precio lider
        txtMaxima.setText(""+otros.getEmaxima());
        txtMinima.setText(""+otros.getEminima());
        txtPublico.setText(""+otros.getVunitario2());//precio publico
        txtPuntos.setText(""+otros.getPuntos());
        txtUnidad.setText(""+otros.getUnidad());
        txtCosto.setText(""+otros.getCosto());
        cboAgencia.setSelectedItem(""+otros.getLinea().getNombre());
       
} 
private void setPanel(Otros gg){
    
        txtFactura.setText(""+gg.getStock());
        txtNombreC.setText(""+gg.getNombre());
        txtVunitario.setText(""+gg.getVunitario());
        txtMaxima.setText(""+gg.getEmaxima());
        txtMinima.setText(""+gg.getEminima());
        txtPublico.setText(""+gg.getVunitario2());//precio publico
        txtPuntos.setText(""+gg.getPuntos());
        txtUnidad.setText(""+gg.getUnidad());
        txtCosto.setText(""+gg.getCosto());
        cboAgencia.setSelectedItem(""+gg.getLinea().getNombre());


 }
    
    
    private void getPanel(){
      
        otros.setFechaLlegada(datFechaIngreso.getDate());
        otros.setStock(Integer.parseInt(txtFactura.getText()));
        otros.setTotal(Integer.parseInt(txtFactura.getText()));
        otros.setVunitario(Float.parseFloat(txtVunitario.getText()));
        otros.setNombre(txtNombreC.getText());

        otros.setLinea((Linea)lista.getObject(cboAgencia.getSelectedIndex()));

        otros.setEmaxima(Integer.parseInt(txtMaxima.getText()));
        otros.setEminima(Integer.parseInt(txtMinima.getText()));
        otros.setVunitario2(Float.parseFloat(txtPublico.getText())); //precio publico
        otros.setPuntos(Integer.parseInt(txtPuntos.getText()));
        otros.setUnidad(txtUnidad.getText());
        otros.setCosto(Float.parseFloat(txtCosto.getText()));
        
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       otros.setHorario(otro);
      
    }
       
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Otros)listaAnteriores.getObject(fila);

        gh.setFechaLlegada(datFechaIngreso.getDate());
        gh.setStock(Integer.parseInt(txtFactura.getText()));
        gh.setTotal(Integer.parseInt(txtFactura.getText()));
        gh.setVunitario(Float.parseFloat(txtVunitario.getText()));
        gh.setNombre(txtNombreC.getText());
        gh.setLinea((Linea)lista.getObject(cboAgencia.getSelectedIndex()));

        gh.setEmaxima(Integer.parseInt(txtMaxima.getText()));
        gh.setEminima(Integer.parseInt(txtMinima.getText()));
        gh.setVunitario2(Float.parseFloat(txtPublico.getText())); //precio publico
        gh.setPuntos(Integer.parseInt(txtPuntos.getText()));
        gh.setUnidad(txtUnidad.getText());
        gh.setCosto(Float.parseFloat(txtCosto.getText()));




        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Otros)listaAnteriores.getObject(fila);     
       
//########################################################################################       
                          //VEO SI ESTE PRODUCTO YA TIENE VENTAS  
        
        VentaProductos produc=new VentaProductos();
        listaAnteriores = new Lista();
        listaAnteriores =new Lista(new VentaProductos().lista(gh));  
        int tam=listaAnteriores.getSize();
       
        if (tam<=0){
             gh.borrar();   
             setTabla(); 
        }else{
            Mensaje.showError(this,"NO se puede borrar este producto ya que hay ventas del mismo ","ERROR");
        }
       
//########################################################################################  
   }
    
    
 private void setBlanco(){

        txtFactura.setText("0");
        txtNombreC.setText("");
        txtVunitario.setText("");
        txtMaxima.setText("");
        txtMinima.setText("");
        txtPublico.setText("");//precio publico
        txtPuntos.setText("");
        txtUnidad.setText("");
        txtCosto.setText("");

    }
    
    
public void modoEdicion(boolean b){

    //  txtFactura.setEditable(b);
      txtNombreC.setEditable(b);
      txtVunitario.setEditable(b);
      txtMaxima.setEditable(b);
      txtMinima.setEditable(b);
      txtPublico.setEditable(b);//precio publico
      txtPuntos.setEditable(b);
      txtUnidad.setEditable(b);
      txtCosto.setEditable(b);


      panMantenimiento1.setActiva(b);
      
}

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
     private void setTabla(){
      activado=false;
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
           
         listaAnteriores =new Lista(new Otros().lista());         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAOTROSV,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelNombre2 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtVunitario = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelApellido2 = new javax.swing.JLabel();
        jLabelCivil3 = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        txtMaxima = new javax.swing.JTextField();
        jLabelApellido3 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        txtPublico = new javax.swing.JTextField();
        txtPuntos = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtMinima = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        cboAgencia = new javax.swing.JComboBox();
        jLabelCedula2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();

        setBackground(java.awt.SystemColor.window);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                               CREAR UN NUEVO PRODUCTOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                                                        Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("                                                                        # de productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelNombre2, gridBagConstraints);

        txtFactura.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtFactura, gridBagConstraints);

        jLabelApellido1.setText("                                                                        Nombre del Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreCKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setText("                                                                        Precio Lider");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtVunitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVunitarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtVunitario, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12)); // NOI18N
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                           Dato del Responsable de Transacci�n");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                                                                        Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombreGrup1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(panMantenimiento1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

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
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelApellido2.setText("                                                                        Unidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil3.setText("                                                                        COSTO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil3, gridBagConstraints);

        txtUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUnidadKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtUnidad, gridBagConstraints);

        txtMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaximaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtMaxima, gridBagConstraints);

        jLabelApellido3.setText("                                                                        Precio Publico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido3, gridBagConstraints);

        jLabelCivil4.setText("                                                                        Puntos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        txtPublico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPublicoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtPublico, gridBagConstraints);

        txtPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuntosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtPuntos, gridBagConstraints);

        jLabelCivil5.setText("                                                                        Existencia Minima");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil5, gridBagConstraints);

        txtMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtMinima, gridBagConstraints);

        jLabelCivil6.setText("                                                                        Existencia Maxima");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil6, gridBagConstraints);

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtCosto, gridBagConstraints);

        cboAgencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 2;
        add(cboAgencia, gridBagConstraints);

        jLabelCedula2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCedula2.setText("                                                      LINEA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula2, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("E MINIMA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton3.setText("INVENTARIO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        add(jButton3, gridBagConstraints);

        jBPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/print.png"))); // NOI18N
        jBPrint.setText("Imprimir");
        jBPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrintActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
        add(jBPrint, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtVunitario.requestFocus();
            
        } 
    }//GEN-LAST:event_txtNombreCKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Otros)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked

    private void txtVunitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVunitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVunitarioActionPerformed

    private void txtUnidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadKeyPressed

    private void txtMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaximaActionPerformed

    private void txtPublicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPublicoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublicoKeyPressed

    private void txtPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuntosActionPerformed

    private void txtMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimaActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void cboAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaActionPerformed
        /**    codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
         * codigos = new CodigoAgencia();
         * codigos=(CodigoAgencia) codigo.ultimo();
         *
         * if (codigos==null){
         * Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");
         *
         * }else{
         * Float newcod= codigos.getCodigo()+1;
         * txtCodigo.setText(String.valueOf(newcod));
         * setTabla();
         * }   */
}//GEN-LAST:event_cboAgenciaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setTabla2();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       setTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrintActionPerformed
      horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);


        if (activado==true){

         Lista listaAnteriores =new Lista(new Otros().lista());
         try {
              ReportePrevio rp = new ReportePrevio(new Mapa(listaAnteriores,Mapa.MAPAMINIMA,true),ReportePrevio.INVENTARIO);
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
    private void setTabla2(){
         activado=true;

         Lista listaAnteriores =new Lista(new Otros().lista());
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAMINIMA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);

     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgencia;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jBPrint;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelApellido3;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtMaxima;
    private javax.swing.JTextField txtMinima;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtPublico;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtUnidad;
    private javax.swing.JTextField txtVunitario;
    // End of variables declaration//GEN-END:variables
    
}
