/*
 * GirosOficina.java
 *
 * Created on 1 de noviembre de 2006, 9:36
 */

package Paneles;

import beans.Otros;
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

public class GirosOficina extends javax.swing.JPanel {
    
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

    public GirosOficina() {
       initComponents();
       fijaMetodos();
       inicializa();
      
    }
     private boolean isVacio(){
  if(txtTotal.getText().equalsIgnoreCase("")  )  
   
     return true;
  return false;
        } 
   
 private void inicializa(){
                   agencia = new Agencia();
                   String cod ="GO";
                   agencia = agencia.Busca(cod);
                   txtAgencia.setText(agencia.getNombre());
                   txtClave.setText(agencia.getCodigo());
                   
                   codigos= new CodigoAgencia();
                   codigos = codigos.busca(agencia);
                   Float cd=codigos.getCodigo()+1;
                   txtCodigo.setText(""+cd);
                   
                   horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
                   txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
   
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
            setTabla();
            inicializa();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR EL GIRO","Eliminar");
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
        txtTotal.setText(""+giro.getTotal());
        txtNombre1.setText(""+giro.getNombre());
} 
private void setPanel(Giro gg){
        txtNombre1.setText(""+gg.getNombre());
        txtTotal.setText(""+String.valueOf(gg.getTotal()));
    }  
    
    
    private void getPanel(){
    
        giro.setNeto(Float.parseFloat("0"));
        giro.setTotal(Float.parseFloat(txtTotal.getText()));
        giro.setEstado(false);
        giro.setAnulado(false);
        giro.setRem(false);
        giro.setPagado(false);
        giro.setNombre(txtNombre1.getText());
        giro.setClave(txtCodigo.getText());
        giro.setCodigo(txtClave.getText());
        
        agencia = new Agencia();
         String cod ="GO";
        agencia = agencia.Busca(cod);
        txtAgencia.setText(agencia.getNombre());
        giro.setAgencia(agencia);
                
        codigos= new CodigoAgencia();
        codigos = codigos.busca(agencia);
        codigos.setCodigo(Float.parseFloat(txtCodigo.getText()));
        codigos.actualizar();
        //GUARDO EL USUARIO    
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        giro.setHorario(otro);
        giro.setFechaLlegada(new Date());
    
    }
    
   
  private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);     
        gh.setTotal(Float.parseFloat(txtTotal.getText()));
        gh.setNombre(txtNombre1.getText());
        gh.actualizar();      
  
    }
    
    
 private void borra(){
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);     
        gh.borrar();    
   }
    
    
 private void setBlanco(){

          txtNombre1.setText("");
          txtTotal.setText("");
          
    }
    
    
public void modoEdicion(boolean b){
   
      txtNombre1.setEditable(b);
      txtTotal.setEditable(b);
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
    
         agencia = new Agencia();
          String cod ="GO";
         agencia = agencia.Busca(cod);
         
                  
         listaAnteriores =new Lista(new Giro().lista2(agencia,hora));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIRO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
     }
       
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabelCedula1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabelNombre2 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        txtAgencia = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("                                                                                DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
        add(txtNombre, gridBagConstraints);

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("                                                                              GIROS DE OFICINA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("                                                                                Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabelCedula1.setText("                                                                                Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula1, gridBagConstraints);

        jLabelNombre1.setText("                                                                                Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre1, gridBagConstraints);

        txtCodigo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtCodigo, gridBagConstraints);

        jLabelNombre3.setText("                                                                                Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre3, gridBagConstraints);

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtNombre1, gridBagConstraints);

        jLabelNombre2.setText("                                                                                Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelNombre2, gridBagConstraints);

        txtClave.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtClave, gridBagConstraints);

        jLabelCivil1.setText("                                                                                Valor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCivil1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
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
        add(jScrollPane2, gridBagConstraints);

        txtAgencia.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(txtAgencia, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtNombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyPressed
if(evt.getKeyCode()==10){
            //tecla enter
        txtTotal.requestFocus();
            
        }  
    }//GEN-LAST:event_txtNombre1KeyPressed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelCedula1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
