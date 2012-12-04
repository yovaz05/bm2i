/*
 * RemplazoG.java
 *
 * Created on 30 de octubre de 2006, 9:07
 */

package Paneles;

import beans.Otros;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.Remplazo;
import beans.Agencia;
import beans.Remplazo;
import beans.CodigoAgencia;
import beans.Giro;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;

public class RemplazoG extends javax.swing.JPanel {

private Remplazo an;
private Lista lista;
private Lista codigo;
private Agencia agencia;
private Remplazo remplazo;
private CodigoAgencia codigos;
private Horario horario;
Remplazo gh;
Lista listaAnteriores;
Giro giro;
Giro g;
private String mensaje="";
private boolean editar;
    
    public RemplazoG() {
        initComponents();
        inicializa();
        setTabla();
        jButton6.setEnabled(true);
        jButton4.setEnabled(true);
    }
    
    private boolean isVacio(){
  if(txtCodigo.getText().equalsIgnoreCase("")    | (txtNeto.getText().equalsIgnoreCase("")) 
    | (txtTotal.getText().equalsIgnoreCase(""))
    |(txtNombre.getText().equalsIgnoreCase(""))  
    )
     return true;
  return false;
        } 
   
 private void inicializa(){
                   agencia = new Agencia();
                   lista = new Lista(new Agencia().lista());
//listaBodega = new Lista(new Bodega().lista());
                for(int i=0;i<lista.getSize();i++){
                   Agencia b1=(Agencia) lista.getObject(i);
                    cboAgencia.addItem(b1.getNombre());
                    
               }
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
        modoEdicion(false);
    } 
   
    private void setPanel(){
      
      horario=new Horario();
         Horario otro = new Horario();
         Boolean est=(false);
         otro=horario.buscar(est);
         
    Giro g = new Giro();
    if (txtBuscar.getText().equals("")){
            
     Lista listaAnteriores =new Lista(new Remplazo().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(Remplazo)listaAnteriores.getObject(fila);
     if (gh==null){
         txtAgencia.setText("");
         txtCodigo1.setText("");
         txtNombre2.setText("");
         txtNeto1.setText("");
         txtTotal1.setText("");
         txtEstado.setText("");
                        }else{
                              g=gh.getGiro();   
                            }
    
     }else{
      Float bus = Float.parseFloat(txtBuscar.getText());
      String bu=String.valueOf(bus);
      g = g.Busca(bu);  
     }
    
    if (g==null) {
         } else{
    datFechaIngreso.setDate(g.getFechaLlegada());
    txtAgencia.setText(""+g.getAgencia().getNombre());
    txtCodigo1.setText(""+g.getClave());
    txtNombre2.setText(""+g.getNombre());
    txtNeto1.setText(""+g.getNeto());
    txtTotal1.setText(""+g.getTotal());
  
    if(g.getRemplazo()==null){
    txtEstado.setText("LIBRE");
      txtBuscar.setEnabled(false);
      jButton2.setEnabled(true);
      jButton3.setEnabled(false);
      nada();
    }else{
    txtEstado.setText("REMPLAZADO");
     jButton3.setEnabled(true);
     jButton2.setEnabled(false);
    
    }   
    }
    }  
    
    
    private void getPanel(){
   
        
//GUARDO LOS DATOS DEL NUEVO GIRO   
        giro.setNeto(Float.parseFloat(txtNeto.getText()));
        giro.setTotal(Float.parseFloat(txtTotal.getText()));
        giro.setEstado(false);
        giro.setAnulado(false);
        giro.setRem(true);
        giro.setPagado(false);
        giro.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
        giro.setNombre(txtNombre1.getText());
//GUARDO EL NUEVO CODIGO DEL NUEVO GIRO 
        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        //Mensaje.showError(this,"el tamanioa es  "+String.valueOf(codigo.getSize()),"Error");
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        Float newcod= codigos.getCodigo()+1;
       // Mensaje.showError(this,"el ultimo + 1 codigo es  "+String.valueOf(newcod),"Error");
        codigos.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
        codigos.setCodigo(newcod);  
        codigos.guardar();
        giro.setClave(String.valueOf(newcod));
//GUARDO EL USUARIO    
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        giro.setHorario(otro);
        giro.setFechaLlegada(new Date());
  }
  
  private void remplazarg()  {
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);      
//guardo los valores del nuevo giro en la tabla giro   
        Remplazo remplazo = new Remplazo();
        remplazo.setHorario(otro);
        remplazo.setGiro(giro);
//pongo true al giro remplazado y le doy la direccion del nuevo giro
   
        Giro g = new Giro();
        Float bus = Float.parseFloat(txtBuscar.getText());
        String bu=String.valueOf(bus);
        g = giro.Busca(bu); 
        g.setRem(true);
        g.setRemplazo(remplazo);
        g.actualizar();
        if (remplazo.guardar()) {
     
       }
      
  }
    private void setBlanco(){

   txtNombre1.setText("");
   txtNeto.setText("");
   txtTotal.setText("");
   
   horario=new Horario();
   Horario otro = new Horario();
   Boolean est=(false);
   otro=horario.buscar(est);
   if(otro==null){
   Mensaje.showError(this,"ES NULO QUE PASA","Error");
   
   }else{
   
   txtNombre.setText(""+otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   }  
              
        
    }
    
    public void verificador(){
    
    }
    
    public void modoEdicion(boolean b){
   txtBuscar.setEditable(b);
   txtNombre1.setEditable(b);
   txtNeto.setEditable(b);
   txtTotal.setEditable(b);
   referencia.setEditable(b);
   txtCmanual.setEditable(b);
        
           }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
     private void setTabla(){
  
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     Boolean b=(true);
     otro=horario.buscar(est);
     
     Lista listaAnteriores =new Lista(new Remplazo().lista2(otro));
     Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAREMPLAZO,true);
     reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
     tblProducto.setModel(modelo);
         
         
     }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemplazoG().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelCedula1 = new javax.swing.JLabel();
        cboAgencia = new javax.swing.JComboBox();
        jLabelNombre4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelNombre5 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        txtNeto = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabelCreditopendiente3 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        jLabelCedula2 = new javax.swing.JLabel();
        txtAgencia = new javax.swing.JTextField();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        jLabelNombre2 = new javax.swing.JLabel();
        txtNeto1 = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelCivil2 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelNombre7 = new javax.swing.JLabel();
        jLabelCivil4 = new javax.swing.JLabel();
        txtCmanual = new javax.swing.JTextField();
        referencia = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        jLabelNombre8 = new javax.swing.JLabel();
        jLabelNombre9 = new javax.swing.JLabel();

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jXTable1);

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                            REMPLAZO  DE  GIROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCreditopendiente1, gridBagConstraints);

        jLabel1.setText("               Codigo del Giro   . ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Buscar.png")));
        jButton1.setText("Busacar");
        jButton1.setToolTipText("Buscar el Giro que se va a Remplazar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 14);
        add(jButton1, gridBagConstraints);

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("        DATOS DEL NUEVO GIRO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabelCreditopendiente2, gridBagConstraints);

        lblFechaIngreso.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(datFechaIngreso, gridBagConstraints);

        jLabelCedula1.setText("Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 83;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelCedula1, gridBagConstraints);

        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 108;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(cboAgencia, gridBagConstraints);

        jLabelNombre4.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 89;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelNombre4, gridBagConstraints);

        txtCodigo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtCodigo, gridBagConstraints);

        jLabelNombre5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelNombre5, gridBagConstraints);

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre1, gridBagConstraints);

        txtNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetoKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNeto, gridBagConstraints);

        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtTotal, gridBagConstraints);

        jLabelCreditopendiente3.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente3.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente3.setText("DATOS DEL  GIRO ANTERIOR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(jLabelCreditopendiente3, gridBagConstraints);

        lblFechaIngreso1.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        jLabelCedula2.setText("Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCedula2, gridBagConstraints);

        txtAgencia.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtAgencia, gridBagConstraints);

        jLabelNombre1.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtCodigo1, gridBagConstraints);

        jLabelNombre3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre3, gridBagConstraints);

        txtNombre2.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtNombre2, gridBagConstraints);

        jLabelNombre2.setText("Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelNombre2, gridBagConstraints);

        txtNeto1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtNeto1, gridBagConstraints);

        jLabelCivil1.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil1, gridBagConstraints);

        txtTotal1.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtTotal1, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 82;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 44, 0, 0);
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtNombre, gridBagConstraints);

        jLabelCivil2.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelCivil2, gridBagConstraints);

        txtEstado.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 45);
        add(txtEstado, gridBagConstraints);

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
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 23, 0, 31);
        add(jScrollPane2, gridBagConstraints);

        datFechaIngreso1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(datFechaIngreso1, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Login.png")));
        jButton3.setText("Habilitar");
        jButton3.setToolTipText("Habilitar un giro Remplazado");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 12);
        add(jButton3, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Borrar.png")));
        jButton2.setText("Remplazar");
        jButton2.setToolTipText("Remplazar un Giro");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 13);
        add(jButton2, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Look.png")));
        jButton4.setText("Cancelar");
        jButton4.setToolTipText("Cancelar la Accion");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 12);
        add(jButton4, gridBagConstraints);

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/nuevo.png")));
        jButton6.setText("Nuevo");
        jButton6.setToolTipText("Crear un nuevo Giro Y Remplazar al Viejo");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 14);
        add(jButton6, gridBagConstraints);

        jLabelNombre7.setText("Referencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelNombre7, gridBagConstraints);

        jLabelCivil4.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelCivil4, gridBagConstraints);

        txtCmanual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCmanualKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtCmanual, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(referencia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(txtBuscar, gridBagConstraints);

        jLabelNombre8.setText("Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelNombre8, gridBagConstraints);

        jLabelNombre9.setText("Codigo Manual");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 99;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        add(jLabelNombre9, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtCmanualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCmanualKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        referencia.requestFocus();
            
        } 
    }//GEN-LAST:event_txtCmanualKeyPressed

    private void txtTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtCmanual.requestFocus();
            
        } 
    }//GEN-LAST:event_txtTotalKeyPressed

    private void txtNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetoKeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNetoKeyPressed

    private void txtNombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtNeto.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNombre1KeyPressed

    private void nada() { 
   
        txtNombre1.setText("");
        txtNeto.setText("");
        txtTotal.setText("");
        txtCmanual.setText("");
        referencia.setText("");
        
        txtNombre1.setEditable(true);
        txtNeto.setEditable(true);
        txtTotal.setEditable(true);
        referencia.setEditable(true);
        txtCmanual.setEditable(true);   
        
    }
    
    private void nega(){
        
        txtNombre1.setText("");
        txtNeto.setText("");
        txtTotal.setText("");
        txtCmanual.setText("");
        referencia.setText("");
        
        txtBuscar.setEditable(false);
        txtBuscar.setEnabled(false);
        txtNombre1.setEditable(false);
        txtNeto.setEditable(false);
        txtTotal.setEditable(false);
        referencia.setEditable(false);
        txtCmanual.setEditable(false);    
    }
    
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        txtBuscar.setEnabled(true);  
        txtBuscar.setEditable(true); 
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setEnabled(false); 
        jButton2.setEnabled(false);
        
        txtAgencia.setText("");
        txtCodigo1.setText("");
        txtNombre2.setText("");
        txtNeto1.setText("");
        txtTotal1.setText("");
        txtEstado.setText("");
        
        txtBuscar.setEditable(false);
        txtNombre1.setEditable(false);
        txtNeto.setEditable(false);
        txtTotal.setEditable(false);
        referencia.setEditable(false);
        txtCmanual.setEditable(false);
        
        setTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bos(){
        txtAgencia.setText("");
        txtCodigo1.setText("");
        txtNombre2.setText("");
        txtNeto1.setText("");
        txtTotal1.setText("");
        txtEstado.setText("");
       
   }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        String bu="";
        txtBuscar.setEnabled(true);
        Giro g = new Giro();
        try{
        Float bus = Float.parseFloat(txtBuscar.getText());
        bu=String.valueOf(bus);
        
         g = g.Busca(bu);
        if (g.getRemplazo()==null){
     
                   Giro giro = new Giro();
  //PRIMERO HAGO EL NUEVO GIRO   
  //#######################################################################     
    
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
        giro.setHorario(otro);
        
        //GENERO LA LISTA DE AGENCIA Y TOMO EL ULTIMO VALOR 
          codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
 
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
        if (giro.guardar()){
            Mensaje.showMensaje(this, "El Nuevo Giro ya se Creo y Se guardo en la base de datos");
        
//#######################################################################     
  //RELACIONO LOS GIROS      
               
        Remplazo an =new Remplazo();
    
               if (otro==g.getHorario()){
                an.setHorario(otro);
                an.setGiro(giro);
                an.setGiroviejo(g);
                an.guardar();
                g.setRemplazo(an);
                g.setRem(true);
                g.actualizar();
            }else{
                an.setHorario(otro);
                an.setGiro(giro);
                an.setGiroviejo(g);
                an.guardar();
                g.setRemplazo(an);
                g.actualizar();
            }
            Mensaje.showMensaje(this,"El Giro Fue REMPLAZADO con exito");
            jButton2.setEnabled(false);
            nega();
  //#######################################################################           
        setTabla();
        
        
             }else{
                Mensaje.showError(this, "Hay un problema con el giro no se a podido GRABAR", "ERROR");
             }
       
 }else{
            Mensaje.showError(this,"Este giro ya fua ANULADO antes","ERROR");
        }
        
        
        
        
        
        
        
        
     } catch(Exception e){
         Mensaje.showError(this,"El ERROR se produce por cualquiera de las opciones: #1 No hay giro para remplazar;  #2 La separacion de decimales con coma ; #3 No puede crear giros en BLANCO ","Error");  
         setBlanco();
         e.printStackTrace();
       }   
  
       
     

 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        
        txtBuscar.setEnabled(true);
        Giro g = new Giro();
        
        if (txtBuscar.getText().equals("")){
            
            Lista listaAnteriores =new Lista(new Remplazo().lista2(otro));
            int fila=tblProducto.getSelectedRow();
            gh=(Remplazo)listaAnteriores.getObject(fila);
            g=gh.getGiro();
            if (g.getRemplazo()!=null){
                if (otro==g.getHorario()){
                    g.setRem(false);
                    an=g.getRemplazo();
                    an.borrar();
                    g.setRemplazo(null);
                    g.actualizar();
                }else{
                    an=g.getRemplazo();
                    an.borrar();
                    g.setRemplazo(null);
                    g.actualizar();
                }
                Mensaje.showMensaje(this,"El Giro ya no esta REMPLAZADO pero el giro creado aun existe en la base de datos ");
                bos();
                
            }else{
                Mensaje.showError(this,"Este giro ya fua HABILITADO antes","ERROR");
            }
        }else{
            
            Float bus = Float.parseFloat(txtBuscar.getText());
            String bu=String.valueOf(bus);
            
            Remplazo an =new Remplazo();
            
            g = g.Busca(bu);
            if (g.getRemplazo()!=null){
                if (otro==g.getHorario()){
                    g.setRem(false);
                    an=g.getRemplazo();
                    an.borrar();
                    g.setRemplazo(null);
                    g.actualizar();
                }else{
                    an=g.getRemplazo();
                    an.borrar();
                    g.setRemplazo(null);
                    g.actualizar();
                }
                  Mensaje.showMensaje(this,"El Giro ya no esta REMPLAZADO pero el giro creado aun existe en la base de datos ");
                  bos();
                
            }else{
                Mensaje.showError(this,"Este giro ya fua HABILITADO antes","ERROR");
            }
            
        }
        
        setTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
     horario=new Horario();
     Horario otro = new Horario();
     Boolean est=(false);
     Boolean b=(true);
     otro=horario.buscar(est);
     
     Lista listaAnteriores =new Lista(new Remplazo().lista2(otro));  
     int fila=tblProducto.getSelectedRow();
     gh=(Remplazo)listaAnteriores.getObject(fila);
     setPanel(gh);
     
    }//GEN-LAST:event_tblProductoMouseClicked
private void setPanel(Remplazo gg){

       
        datFechaIngreso.setDate(gg.getGiroviejo().getFechaLlegada());
        txtAgencia.setText(""+gg.getGiroviejo().getAgencia().getNombre());
        txtCodigo1.setText(""+gg.getGiroviejo().getClave());
        txtNombre2.setText(""+gg.getGiroviejo().getNombre());
        txtNeto1.setText(""+gg.getGiroviejo().getNeto());
        txtTotal1.setText(""+gg.getGiroviejo().getTotal());
        if(gg.getGiroviejo().getRemplazo()==null){
        txtEstado.setText("LIBRE");
        jButton3.setEnabled(false);
        }else{
         txtEstado.setText("REMPLAZADO");
          jButton3.setEnabled(true);
          jButton2.setEnabled(false);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        
      Remplazo remplazo = new  Remplazo();
     
      Giro g = new Giro();
      
      if (txtBuscar.getText().equals("")){
      Mensaje.showError(this,"No ha ingresado ningun codigo de Giro","Error");
   
      }else{
      Float bus = Float.parseFloat(txtBuscar.getText());
      String bu=String.valueOf(bus);
      g = g.Busca(bu);
     
     if (g==null){
     Mensaje.showError(this,"No hay ningun giro con este codigo intente denuevo","Error");
      }else{
      setPanel();
      
       }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaActionPerformed
// TODO add your handling code here:
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
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCedula1;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCivil4;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente3;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombre4;
    private javax.swing.JLabel jLabelNombre5;
    private javax.swing.JLabel jLabelNombre7;
    private javax.swing.JLabel jLabelNombre8;
    private javax.swing.JLabel jLabelNombre9;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JTextField referencia;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCmanual;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNeto1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
    
}
