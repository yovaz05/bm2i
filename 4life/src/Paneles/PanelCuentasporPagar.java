/*
 * PanelCuentasporPagar.java
 *
 * Created on 6 de noviembre de 2006, 22:31
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;

import beans.CuentasXCobrar;
import beans.CuentasXPagar;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;


public class PanelCuentasporPagar extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private CuentasXCobrar cuentas;
private CuentasXPagar cp;
private String mensaje="";
private boolean editar;
CuentasXCobrar gh;
Lista listaAnteriores;
Boolean bandera=false;


    public PanelCuentasporPagar() {
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
   
                   cuentas = new CuentasXCobrar();
                   codigo = new Lista(new CuentasXCobrar().lista5(otro));
                   cuentas=(CuentasXCobrar) codigo.ultimo();
                   
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
                       return true;
                       }else{ 
                             CuentasXPagar cp = new CuentasXPagar();
                             int fila=tblProducto.getSelectedRow();
                             cp =(CuentasXPagar)listaAnteriores.getObject(fila);
                             if (cp.getPagado()==true){
                                                       return false;
                                                      // Mensaje.showMensaje(this,"ESTE CREDITO YA ESTA PAGADO");
                                                       }else{
                                                       float sal=0;
                                                       if (cp.getApagado()==null){
                                                       cp.setApagado(sal);
                                                       cp.actualizar();
                                                       sal= (cp.getTotal()-0);
                                                       }else{
                                                       sal= (cp.getTotal()-cp.getApagado());
                                                       }
                                                       if (sal<=0){
                                                                   float c=0;
                                                                   cp.setPagado(true);
                                                                   cp.actualizar();
                                                                   Mensaje.showMensaje(this,"FELICIDADES A TERMONADO DE PAGAR SU CREDITO");
                                                                   cuentas=new CuentasXCobrar();
                                                                   getPanel();
                                                                   bandera=false;
                                                                    if(cuentas.guardar()){
                                                                                         modoEdicion(false);
                                                                                         return true;
                                                                                         
                                                                                         }
                                                                  }else{
                                                                  cuentas=new CuentasXCobrar();
                                                                  getPanel();
                                                                  bandera=false;
                                                                   if(cuentas.guardar()){
                                                                    modoEdicion(false);
                                                                    return true;
                                                                  
                                                                    }
                                                                   } 
                                                       }
       }  
        return false;
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
       if (bandera==false){
        
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR","Eliminar");
        if (b){
            int fila=tblProducto.getSelectedRow();
            gh=(CuentasXCobrar)listaAnteriores.getObject(fila);     
            CuentasXPagar cp = new CuentasXPagar();
            cp=gh.getCuentasXPagar();
            cp.setApagado(cp.getApagado()-gh.getCuota());
            cp.actualizar();
            borra();
            setTabla();
            setBlanco();
            inicializa();
        }
       }else{
       Mensaje.showError(this,"NO se puede borrar los datos de este credito","Error");
             
       }
       }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            cuentas=(CuentasXCobrar)lista.getMyself();
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
   
        cuentas = new CuentasXCobrar();
        codigo = new Lista(new CuentasXCobrar().lista5(otro));
        cuentas=(CuentasXCobrar) codigo.ultimo();
                   
              }
    
    private void anterior(){
        cuentas=(CuentasXCobrar)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        cuentas=(CuentasXCobrar)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        cuentas=(CuentasXCobrar)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        cuentas=(CuentasXCobrar)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
        txtNombreC.setText(""+cuentas.getCuentasXPagar().getNombre());
        txtEnvio.setText(""+cuentas.getCuentasXPagar().getEnvio());
        txtTotal.setText(""+cuentas.getCuota());
        
} 
private void setPanel(CuentasXCobrar gg){
        txtNombreC.setText(""+gg.getCuentasXPagar().getNombre());
        txtEnvio.setText(""+gg.getCuentasXPagar().getEnvio());
        txtTotal.setText(""+gg.getCuota());
        txtCuota.setText(""+gh.getCuota());
        //datFechaIngreso1(gg.getFecha().getDate);
    }  

private void setPanel2(CuentasXPagar gg){
        txtNombreC.setText(""+gg.getNombre());
        txtEnvio.setText(""+gg.getEnvio());
        txtTotal.setText(""+gg.getTotal());
        //datFechaIngreso1(gg.getFecha().getDate);
    }  
    
    
    private void getPanel(){
       CuentasXPagar cp = new CuentasXPagar();
       int fila=tblProducto.getSelectedRow();
       float resta =0;
       cp =(CuentasXPagar)listaAnteriores.getObject(fila);
       // Mensaje.showMensaje(this,"inicia pregunto si Pgado es falso "+cp.getPagado());
                              
if (cp.getPagado()==false){     
      //       Mensaje.showMensaje(this,"si es falso ");
        
       cuentas.setCuentasXPagar(cp);
       cuentas.setCuota(Float.parseFloat(txtCuota.getText()));
       cuentas.setFecha(datFechaIngreso1.getDate());
       
       horario=new Horario();
       Horario otro = new Horario();
       Boolean est=(false);
       otro=horario.buscar(est);
       cuentas.setHorario(otro);
       
       if (cp.getApagado()==0){
        cp.setApagado(Float.parseFloat(txtCuota.getText()));
        cp.actualizar();   
       }else{
           
        cp.setApagado(cp.getApagado()+Float.parseFloat(txtCuota.getText()));
        cp.actualizar();  
          }
      
     float sal= (cp.getTotal()-cp.getApagado());
       cuentas.setSaldo(cp.getTotal()-cp.getApagado()); 
     
     if (sal<=0){
                 float c=0;
                 cuentas.setSaldo(c);
                 cp.setPagado(true);
                 }
     
    if (cp.getGiros()==false){
    cuentas.setGiros(false);    
    }else{
    cuentas.setGiros(true);
    }   
    }else{

    Mensaje.showMensaje(this,"El CREDITO YA FUE CANCELADO");
   
}  
    }
    
   
  private void getPanel2(){
     //  Mensaje.showMensaje(this,"si lllega a ca creo");
           
        if (bandera==false){
        int fila=tblProducto.getSelectedRow();
        gh=(CuentasXCobrar)listaAnteriores.getObject(fila);     
        
       
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        gh.setHorario(otro);
      
        
        CuentasXPagar cp = new CuentasXPagar();
        cp=gh.getCuentasXPagar();
       
        float ap=cp.getApagado(); 
       //  Mensaje.showMensaje(this,"al a pagado anterior "+ap+" "+gh.getCuota());
        cp.setApagado(ap-gh.getCuota()+Float.parseFloat(txtCuota.getText()));
        cp.actualizar();
        //Mensaje.showMensaje(this,"el a pagado nuevo "+cp.getApagado());
        gh.setSaldo(cp.getTotal()-cp.getApagado());
        gh.setCuota(Float.parseFloat(txtCuota.getText()));
        gh.setFecha(datFechaIngreso1.getDate());
        gh.actualizar();    
       // Mensaje.showMensaje(this,"el saldo "+gh.getSaldo());
         }
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(CuentasXCobrar)listaAnteriores.getObject(fila);     
        gh.borrar();   
        setTabla();
   }
    
    
 private void setBlanco(){
        txtCuota.setText("");
        }
    
    
public void modoEdicion(boolean b){
      
      txtCuota.setEditable(b);
      panMantenimiento1.setActiva(b);
        
}

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
     private void setTabla(){
         txtTabla.setText("TABLA DE CUOTAS PAGADAS");
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
    
         listaAnteriores =new Lista(new CuentasXCobrar().lista5(hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXC,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelApellido1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtEnvio = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jLabelApellido2 = new javax.swing.JLabel();
        txtNombreC1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        jLabelCivil3 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabelCivil5 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        txtTabla = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        lblFechaIngreso.setText("                                             Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        datFechaIngreso.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelApellido1.setText("                                             Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido1, gridBagConstraints);

        txtNombreC.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setText("                                             # de Envio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil2, gridBagConstraints);

        txtEnvio.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtEnvio, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                             DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelSubtitulo6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(panMantenimiento1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
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
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 9);
        add(jScrollPane2, gridBagConstraints);

        lblFechaIngreso1.setText("Fecha del Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(lblFechaIngreso1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 92);
        add(datFechaIngreso1, gridBagConstraints);

        jLabelApellido2.setText("                                             Buscar por ..?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelApellido2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNombreC1, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/preferences-desktop-peripherals(2).png")));
        jButton1.setText("Cuotas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 89);
        add(jButton1, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setSelected(true);
        rb2.setText("Por Nombre");
        rb2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setText("Por # de Credito");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        add(rb3, gridBagConstraints);

        rb4.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb4);
        rb4.setText("Por # de Giro");
        rb4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        add(rb4, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("                                                       PAGOS DE CREDITOD (CUENTAS POR COBRAR)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        add(jLabelCreditopendiente3, gridBagConstraints);

        jLabelCivil3.setText("                                             Total de Credito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil3, gridBagConstraints);

        jLabelCivil4.setText("Saldo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(jLabelCivil4, gridBagConstraints);

        txtSaldo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 92);
        add(txtSaldo, gridBagConstraints);

        jLabelCivil5.setText("Pago de ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(jLabelCivil5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 92);
        add(txtCuota, gridBagConstraints);

        txtTabla.setFont(new java.awt.Font("Arial Black", 1, 14));
        txtTabla.setBorder(null);
        txtTabla.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtTabla, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/preferences-desktop-accessibility(2).png")));
        jButton2.setText("Creditos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 89);
        add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Buscar.png")));
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        add(jButton3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
txtTabla.setText("TABLA DE CREDITOS");
    CuentasXPagar cp = new CuentasXPagar();
    Lista codigo = new Lista();

   if (rb2.isSelected()==true){
    //busco por nombre y me devuelve una lista  
  
    listaAnteriores =new Lista(new CuentasXPagar().lista(txtNombreC1.getText()));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El nombre ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista(txtNombreC1.getText()));         
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
   }
    
     if (rb3.isSelected()==true){
     //busco por numero de orden medevueleve un objeto
    
        listaAnteriores =new Lista(new CuentasXPagar().lista2(Integer.parseInt(txtNombreC1.getText())));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El numero de orden ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista2(Integer.parseInt(txtNombreC1.getText())));        
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
     
     }
    
    if (rb4.isSelected()==true){
     //busco por numero de orden medevueleve un objeto
      
        listaAnteriores =new Lista(new CuentasXPagar().lista3(txtNombreC1.getText()));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El numero de giro ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista3(txtNombreC1.getText()));         
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
     
     }
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
txtTabla.setText("TABLA DE CREDITOS");
    CuentasXPagar cp = new CuentasXPagar();
    Lista codigo = new Lista();

   if (rb2.isSelected()==true){
    //busco por nombre y me devuelve una lista  
  
    listaAnteriores =new Lista(new CuentasXPagar().lista(txtNombreC1.getText()));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El nombre ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista(txtNombreC1.getText()));         
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
   }
    
     if (rb3.isSelected()==true){
     //busco por numero de orden medevueleve un objeto
    
        listaAnteriores =new Lista(new CuentasXPagar().lista2(Integer.parseInt(txtNombreC1.getText())));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El numero de orden ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista2(Integer.parseInt(txtNombreC1.getText())));        
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
     
     }
    
    if (rb4.isSelected()==true){
     //busco por numero de orden medevueleve un objeto
      
        listaAnteriores =new Lista(new CuentasXPagar().lista3(txtNombreC1.getText()));  
    int t= listaAnteriores.getSize();
    if (t==0){
            Mensaje.showError(this, "El numero de giro ingresado no existe intente denuevo","ERROR");
            bandera =false;
    }else{
        listaAnteriores =new Lista(new CuentasXPagar().lista3(txtNombreC1.getText()));         
        Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACXP,true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo); 
        bandera=true;
    
    }
     
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
setTabla();    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
            
        
    }//GEN-LAST:event_rb4ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
       
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
//        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
//Mensaje.showMensaje(this,"bandera es "+bandera);        
        System.out.println("bandera es "+bandera);
        int fila=tblProducto.getSelectedRow();
        
        if (bandera==true){
         cp =(CuentasXPagar)listaAnteriores.getObject(fila);
         setPanel2(cp);          
        }else{
         gh=(CuentasXCobrar)listaAnteriores.getObject(fila);
         setPanel(gh);
        }
        
       
       
       
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtEnvio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreC1;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTabla;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
