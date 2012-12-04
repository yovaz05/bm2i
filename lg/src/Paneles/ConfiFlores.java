/*
 * ConfiFlores.java
 *
 * Created on 3 de noviembre de 2006, 16:35
 */

package Paneles;


import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.Agencia;
import beans.CodigoAgencia;
import beans.Flores;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import reportesXML.ReportePrevio;
import clases.MenuPrin;
import org.jdesktop.swingx.autocomplete.Configurator;

public class ConfiFlores extends javax.swing.JPanel {

private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Flores flores;
private String mensaje="";
private boolean editar;
Flores gh;
Lista listaAnteriores;


    public ConfiFlores() {
        initComponents();
        fijaMetodos();
        inicializa();
        setTabla();
    }
     private boolean isVacio(){
  if(txtTotal.getText().equalsIgnoreCase("")  )  
   
     return true;
  return false;
        } 
   
 private void inicializa(){
                  
                                   
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
                   flores = new Flores();
                   codigo = new Lista(new Flores().lista2());
                   flores=(Flores) codigo.ultimo();
                   
                   if(flores==null){
                   txtFactura.setText("1"); 
                   }else{
                   int fact = flores.getFactura()+1;
                   txtFactura.setText(""+fact); 
                   }
                   
                   
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
              flores=new Flores();
              getPanel();
              if(flores.guardar()){
                 modoEdicion(false);
                 return true;
                    
                 }  return false;
     }
         return true;
         }
    private void aceptar(){
     horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
        
        
            if(saveOrUpdate()){
                 modoEdicion(false);
                 setTabla();
                 inicializa();
                          try {
                                Mensaje.showError(this,"Registros Guardado","error");
                                ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(flores),Mapa.MAPAFLORES,true),ReportePrevio.FLORES);
                                rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
                                rp.mostrarVistaPreliminar(MenuPrin.escritorio);
                
                              } catch (Exception e) {
                                e.printStackTrace();
                              }
             }else{
             Mensaje.showError(this,"ERRO AL GRABAR","Error");
            }   
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
            flores=(Flores)lista.getMyself();
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
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
        flores = new Flores();
        codigo = new Lista(new Flores().lista2());
        flores=(Flores) codigo.ultimo();
                   
         if(flores==null){
         txtFactura.setText("1"); 
         }else{
               int fact = flores.getFactura()+1;
               txtFactura.setText(""+fact); 
              }
 }
    
    private void anterior(){
        flores=(Flores)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        flores=(Flores)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        flores=(Flores)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        flores=(Flores)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
    
        txtFactura.setText(""+flores.getFactura());
        txtNombreC.setText(""+flores.getNombre());
        txtDedicaria.setText(""+flores.getDedicatoria());
        txtDescripcion.setText(""+flores.getDescripcion());
        txtTotal.setText(""+flores.getTotal());
        txtRecibe.setText(""+flores.getRecibe());
        txtPais.setText(""+flores.getPais());
        txtCiudad.setText(""+flores.getCiudad());
        txtDireccion.setText(""+flores.getDireccion());
        txtTelefono.setText(""+flores.getTelefono());
        
} 
private void setPanel(Flores gg){
    
        txtFactura.setText(""+gg.getFactura());
        txtNombreC.setText(""+gg.getNombre());
        txtDedicaria.setText(""+gg.getDedicatoria());
        txtDescripcion.setText(""+gg.getDescripcion());
        txtTotal.setText(""+gg.getTotal());
        txtRecibe.setText(""+gg.getRecibe());
        txtPais.setText(""+gg.getPais());
        txtCiudad.setText(""+gg.getCiudad());
        txtDireccion.setText(""+gg.getDireccion());
        txtTelefono.setText(""+gg.getTelefono());
        
    }  
    
    
    private void getPanel(){
        
       flores.setFechaLlegada(datFechaIngreso.getDate());
       //flores.setFactura(Integer.parseInt(txtFactura.getText()));
       flores.setNombre(txtNombreC.getText());
       flores.setDedicatoria(txtDedicaria.getText());
       flores.setDescripcion(txtDescripcion.getText());
       flores.setTotal(Float.parseFloat(txtTotal.getText()));
       
       flores.setRecibe(txtRecibe.getText());
       flores.setPais(txtPais.getText());
       flores.setCiudad(txtCiudad.getText());
       flores.setDireccion(txtDireccion.getText());
       flores.setTelefono(txtTelefono.getText());
       
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       flores.setHorario(otro);
       
       gh = new Flores();
       codigo = new Lista(new Flores().lista2());
       int fact=0;
       if (codigo.getSize()==0){
       fact=1;
       }else{
       gh=(Flores) codigo.ultimo();
       fact = gh.getFactura()+1;
       }
       boolean a= false;
       
       for(int i=0; i<codigo.getSize(); i++){
          gh =(Flores) codigo.getObject(i);
          if (gh.getFactura()==fact){
                                      a=true;
                                      }
       }
       if (a ==false){
       flores.setFactura(fact); 
       }else{
        Mensaje.showMensaje(this,"Mierda");
       }
   
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Flores)listaAnteriores.getObject(fila);     
       
       gh.setFechaLlegada(datFechaIngreso.getDate());
       gh.setFactura(Integer.parseInt(txtFactura.getText()));
       gh.setNombre(txtNombreC.getText());
       gh.setDedicatoria(txtDedicaria.getText());
       gh.setDescripcion(txtDescripcion.getText());
       gh.setTotal(Float.parseFloat(txtTotal.getText()));
       
       gh.setRecibe(txtRecibe.getText());
       gh.setPais(txtPais.getText());
       gh.setCiudad(txtCiudad.getText());
       gh.setDireccion(txtDireccion.getText());
       gh.setTelefono(txtTelefono.getText());
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Flores)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){

        txtNombreC.setText("");
        txtDedicaria.setText("");
        txtDescripcion.setText("");
        txtTotal.setText("");
        txtRecibe.setText("");
        txtPais.setText("");
        txtCiudad.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
          
    }
    
    
public void modoEdicion(boolean b){
      
      txtNombreC.setEditable(b);
      txtNombreC.setEditable(b);
      txtDedicaria.setEditable(b);
      txtDescripcion.setEditable(b);
      txtTotal.setEditable(b);
      txtRecibe.setEditable(b);
      txtPais.setEditable(b);
      txtCiudad.setEditable(b);
      txtDireccion.setEditable(b);
      txtTelefono.setEditable(b);
     
      panMantenimiento1.setActiva(b);
        
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
    
         listaAnteriores =new Lista(new Flores().lista3(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFLORES,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
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
        txtDescripcion = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelApellido2 = new javax.swing.JLabel();
        jLabelCivil3 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        txtRecibe = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        jLabelCivil5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabelCivil6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabelCivil10 = new javax.swing.JLabel();
        txtDedicaria = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("Recibe         ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                              Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("                                              # de Factura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre2, gridBagConstraints);

        txtFactura.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtFactura, gridBagConstraints);

        jLabelApellido1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabelApellido1, gridBagConstraints);

        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreCKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setText("Pais");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        add(jLabelCivil2, gridBagConstraints);

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtDescripcion, gridBagConstraints);

        jLabelCivil1.setText("Ciudad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        add(jLabelCivil1, gridBagConstraints);

        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                              DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("                                              Nombre ");
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
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 8;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane2, gridBagConstraints);

        jLabelApellido2.setText("                                              Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        jLabelCivil3.setText("                                              Descrpcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil3, gridBagConstraints);

        jLabelCivil4.setText("                                              Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil4, gridBagConstraints);

        txtRecibe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecibeKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtRecibe, gridBagConstraints);

        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaisKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtPais, gridBagConstraints);

        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiudadKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtCiudad, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("                                  Envia ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("                                                                                   FLORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente3, gridBagConstraints);

        jLabelCivil5.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        add(jLabelCivil5, gridBagConstraints);

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtDireccion, gridBagConstraints);

        jLabelCivil6.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 0);
        add(jLabelCivil6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTelefono, gridBagConstraints);

        jLabelCivil10.setText("                                              Dedicatoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil10, gridBagConstraints);

        txtDedicaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDedicariaKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtDedicaria, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtRecibe.requestFocus();
            
        } 
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTelefono.requestFocus();
            
        } 
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtDireccion.requestFocus();
            
        } 
    }//GEN-LAST:event_txtCiudadKeyPressed

    private void txtPaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        txtCiudad.requestFocus();
            
        } 
    }//GEN-LAST:event_txtPaisKeyPressed

    private void txtRecibeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibeKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        txtPais.requestFocus();
            
        } 
    }//GEN-LAST:event_txtRecibeKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
 if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
            
        } 
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtDedicariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDedicariaKeyPressed
       if(evt.getKeyCode()==10){
            //tecla enter
        txtDescripcion.requestFocus();
            
        } 
    }//GEN-LAST:event_txtDedicariaKeyPressed

    private void txtNombreCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyPressed
       if(evt.getKeyCode()==10){
            //tecla enter
        txtDedicaria.requestFocus();
            
        } 
        
    }//GEN-LAST:event_txtNombreCKeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Flores)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil10;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil6;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDedicaria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtRecibe;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
