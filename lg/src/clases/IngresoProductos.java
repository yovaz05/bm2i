/*
 * IngresoProductos.java
 *
 * Created on 23 de octubre de 2006, 18:03
 */

package clases;

import java.util.Date;
import modelo.Mensaje;
import modelo.Lista;

import beans.Otros;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;

public class IngresoProductos extends javax.swing.JFrame {
    
private Lista lista;   
private Otros otros;
private Horario horario;
private String mensaje="";
private boolean editar;


    public IngresoProductos() {
        initComponents();
       fijaMetodos();
       inicializa();
    }
     private boolean isVacio(){
  if(txtFactura.getText().equalsIgnoreCase("")   |(txtNombreC.getText().equalsIgnoreCase("")) 
    |(txtVunitario.getText().equalsIgnoreCase(""))  
    )
     return true;
  return false;
        } 
     
     
   private void inicializa(){
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
      
           
        if(isEditar()){
            getPanel();
            otros.actualizar();
        }else{            
                      
           otros=new Otros();
            getPanel();
            if(otros.guardar()){
                inicializa();
             //  Mensaje.showError(this,"USUARIO AGREGADO","Error"); 
            }else{
                return false;
         
            }
        }
        return true;
    } 
    
    private void aceptar(){
     
            
        if(saveOrUpdate()){
            Mensaje.showError(this,"PRODUCTO GUARDADO","Error");
            modoEdicion(false);
            
            verificador();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"Desea eliminar el Cafe","Eliminar");
        if (b){
            otros.borrar();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            otros=(Otros)lista.getMyself();
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
   txtVunitario.setText(""+otros.getVunitario()); 
  
    }  
    
    
    private void getPanel(){
        
        
        otros.setStock(Integer.parseInt(txtFactura.getText()));
        otros.setNombre(txtNombreC.getText());
        otros.setVunitario(Float.parseFloat(txtVunitario.getText()));
        otros.setFechaLlegada(datFechaIngreso.getDate());
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        otros.setHorario(otro);
   
}
    

    
    private void setBlanco(){

   txtFactura.setText("");
   txtNombreC.setText("");
   txtVunitario.setText(""); 
  
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
   
        
   txtFactura.setEditable(b);
   txtNombreC.setEditable(b);
   txtVunitario.setEditable(b);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
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
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(java.awt.SystemColor.window);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("INGRESAR PRODUCTOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(lblFechaIngreso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(datFechaIngreso, gridBagConstraints);

        jLabelNombre2.setText("# de productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabelNombre2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtFactura, gridBagConstraints);

        jLabelApellido1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabelApellido1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtNombreC, gridBagConstraints);

        jLabelCivil2.setText("Valor unitario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabelCivil2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtVunitario, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabelSubtitulo6, gridBagConstraints);

        jLabelNombreGrup1.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabelNombreGrup1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(panMantenimiento1, gridBagConstraints);

        jScrollPane2.setViewportView(jPanel1);

        jScrollPane1.setViewportView(jScrollPane2);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoProductos().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelCivil2;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtVunitario;
    // End of variables declaration//GEN-END:variables
    
}
