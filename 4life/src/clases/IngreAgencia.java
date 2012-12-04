/*
 * Giro.java
 *
 * Created on 20 de octubre de 2006, 11:15 AM
 */

package clases;

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

public class IngreAgencia extends javax.swing.JFrame {

    
private Lista lista;
private Lista codigo;
private Agencia agencia;
private CodigoAgencia codigos;
private Horario horario;
private Giro giro;
private String mensaje="";
private boolean editar;
    
    
 public IngreAgencia() {
       initComponents();
       fijaMetodos();
       inicializa();
       setTabla2();
    }
 private boolean isVacio(){
  if(txtCodigo.getText().equalsIgnoreCase("")    | (txtNeto.getText().equalsIgnoreCase("")) 
    |(txtAgente.getText().equalsIgnoreCase(""))  | (txtTotal.getText().equalsIgnoreCase(""))
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
        
    }
       
       public boolean saveOrUpdate(){
       if (isVacio())
            return false;
      
       agencia=new Agencia();
       Agencia agencia =(Agencia)lista.getObject(cboAgencia.getSelectedIndex());            
             
        if(isEditar()){
            getPanel();
            giro.actualizar();
        }else{            
           Agencia agco=new Agencia();
           agco=(Agencia)lista.ultimo();
           
           giro=new Giro();
            getPanel();
            if(giro.guardar()){
                 modoEdicion(false);
             //  Mensaje.showError(this,"USUARIO AGREGADO","Error"); 
            }else{
                return false;
         
            }
        }
        return true;
    } 
    
    private void aceptar(){
     
            if(saveOrUpdate()){
            Mensaje.showError(this,"GIRO GUARDADO","Error");
            modoEdicion(false);
            verificador();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"Desea eliminar el Cafe","Eliminar");
        if (b){
            giro.borrar();
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
   txtNeto.setText(""+giro.getNeto());
   txtTotal.setText(""+giro.getTotal());
   cboAgencia.setSelectedItem(agencia.getNombre().toString());
    }  
    
    
    private void getPanel(){
    
        giro.setNeto(Float.parseFloat(txtNeto.getText()));
        giro.setTotal(Float.parseFloat(txtTotal.getText()));
        giro.setEstado(false);
        giro.setAnulado(false);
        giro.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
        giro.setNombre(txtNombre1.getText());
    
  
  //GENERO LA LISTA Y TOMO EL ULTIMO VALOR 
  codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
   Mensaje.showError(this,"el tamanioa es  "+String.valueOf(codigo.getSize()),"Error");
   codigos = new CodigoAgencia();
   codigos=(CodigoAgencia) codigo.ultimo();
try{
   Mensaje.showError(this,"el ultimo codigo es  "+String.valueOf(codigos.getCodigo()),"Error");
}catch (Exception e){

}
  if (codigos==null){
    Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");  
    codigos = new CodigoAgencia();    
    codigos.setAgencia((Agencia)lista.getObject(cboAgencia.getSelectedIndex()));
    codigos.setCodigo(Float.parseFloat(txtCodigo.getText()));  
    codigos.guardar();
    giro.setClave(txtCodigo.getText());
    //GUARDO EL USUARIO    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    giro.setHorario(otro);
    giro.setFechaLlegada(new Date());  
  }else{
   Float newcod= codigos.getCodigo()+1;
   Mensaje.showError(this,"el ultimo + 1 codigo es  "+String.valueOf(newcod),"Error");
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
  
    }
    private void setBlanco(){

   txtNombre1.setText("");
   txtNeto.setText("");
   txtAgente.setText(""); 
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
   
   txtNombre1.setEditable(b);
   txtNeto.setEditable(b);
   txtAgente.setEditable(b);
   txtTotal.setEditable(b);
   panMantenimiento1.setActiva(b);
        
           }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panSocio = new javax.swing.JPanel();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        jLabelCedula1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabelApellido1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabelCivil1 = new javax.swing.JLabel();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        cboAgencia = new javax.swing.JComboBox();
        jLabelLonjitud = new javax.swing.JLabel();
        jLabelNombre2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblFechaIngreso = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        txtAgente = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jLabelNombre3 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panSocio.setLayout(new java.awt.GridBagLayout());

        panSocio.setBackground(java.awt.SystemColor.window);
        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelNombreGrup1, gridBagConstraints);

        jLabelCedula1.setText("Agencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelCedula1, gridBagConstraints);

        jLabelNombre1.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelNombre1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(txtNombre, gridBagConstraints);

        jLabelApellido1.setText("Agente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelApellido1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(txtTotal, gridBagConstraints);

        jLabelCivil1.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelCivil1, gridBagConstraints);

        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("INGRESO DE  GIROS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelCreditopendiente1, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(jLabelSubtitulo6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(datFechaIngreso, gridBagConstraints);

        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(cboAgencia, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelLonjitud, gridBagConstraints);

        jLabelNombre2.setText("Neto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(jLabelNombre2, gridBagConstraints);

        txtCodigo.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(txtCodigo, gridBagConstraints);

        lblFechaIngreso.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(txtNeto, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panSocio.add(txtAgente, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(panMantenimiento1, gridBagConstraints);

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
        jScrollPane2.setViewportView(tblProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jScrollPane2, gridBagConstraints);

        jLabelNombre3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(jLabelNombre3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        panSocio.add(txtNombre1, gridBagConstraints);

        jScrollPane1.setViewportView(panSocio);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void setTabla(){
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));      
         codigos = new CodigoAgencia();
         codigos=(CodigoAgencia) codigo.ultimo();  
         
         Lista listaAnteriores =new Lista(new Giro().lista2(codigos.getAgencia(),hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIRO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
     
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngreAgencia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboAgencia;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCedula1;
    private javax.swing.JLabel jLabelCivil1;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelLonjitud;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombre3;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JPanel panSocio;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    
}
