/*
 * ConfiUsuarios.java
 *
 * Created on 26 de octubre de 2006, 21:50
 */

package Paneles;

import modelo.Mensaje;
import modelo.Lista;
import beans.Usuario;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;

public class ConfiUsuarios extends javax.swing.JPanel {
    
private Lista lista;
private Usuario usuario;
private Horario horario;
private String mensaje="";
private boolean editar;

    public ConfiUsuarios() {
       initComponents();
        fijaMetodos();
        inicializa();
    }
     private boolean isVacio(){
  if(jTNombre.getText().equalsIgnoreCase("")      | (jTApellido.getText().equalsIgnoreCase("")) 
    |(jTApellido.getText().equalsIgnoreCase(""))  | (jTApellido.getText().equalsIgnoreCase(""))
    |(jTCedula.getText().equalsIgnoreCase(""))    | (jTextField3.getText().equalsIgnoreCase(""))
    |(jTelefono.getText().equalsIgnoreCase(""))   | (jTLoguin.getText().equalsIgnoreCase(""))
    | (jTPassword.getText().equalsIgnoreCase("")) 
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
            usuario.actualizar();
        }else{            
            usuario=new Usuario();
            getPanel();
            if(usuario.guardar()){
                inicializa();
               Mensaje.showError(this,"USUARIO AGREGADO","Error"); 
            }else{
                return false;
         
            }
        }
        return true;
    } 
    
    private void aceptar(){
     
            
        if(saveOrUpdate()){
            Mensaje.showError(this,"TIENE QUE SALIR ESTO SI GRABA","Error");
            modoEdicion(false);
            verificador();
        }else
            Mensaje.showError(this,"El registro ya existe","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"Desea eliminar el Cafe","Eliminar");
        if (b){
            usuario.eliminar();
            inicializa();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            usuario=(Usuario)lista.getMyself();
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
        usuario=(Usuario)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        usuario=(Usuario)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        usuario=(Usuario)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        usuario=(Usuario)lista.ultimo();
        setPanel();
       
    }
    
    private void setPanel(){
        
   jTNombre.setText(""+usuario.getNombre());
   jTApellido.setText(""+usuario.getNombre()); 
   jTCedula.setText(""+usuario.getCedula());
   jTextField3.setText(""+usuario.getDireccion());
   jTelefono.setText(""+usuario.getTelefono());   
   jTLoguin.setText(""+usuario.getLoguin());
   jTPassword.setText(""+usuario.getPassword());
   jComCargo.setSelectedItem(usuario.getCargo().toString());
                  
    }  
    
    
    private void getPanel(){
        usuario.setNombre(jTNombre.getText());
        usuario.setApellido(jTApellido.getText());
        usuario.setCedula(jTCedula.getText());
        usuario.setDireccion(jTextField3.getText());
        usuario.setTelefono(jTelefono.getText());
        usuario.setLoguin(jTLoguin.getText());
        usuario.setPassword(jTPassword.getText());
        usuario.setCargo((String) jComCargo.getSelectedItem());
               
       
    }
    
    private void setBlanco(){
       
   jTNombre.setText("");
   jTApellido.setText(""); 
   jTCedula.setText("");
   jTextField3.setText("");
   jTelefono.setText("");   
   jTLoguin.setText("");
   jTPassword.setText("");
   
        
        
        
    }
    
    public void verificador(){
       
        
    }
    
    public void modoEdicion(boolean b){
       
   jTNombre.setEditable(b);
   jTApellido.setEditable(b);
   jTCedula.setEditable(b);
   jTextField3.setEditable(b);
   jTelefono.setEditable(b);  
   jTLoguin.setEditable(b);
   jTPassword.setEditable(b);
   jComCargo.setEditable(b);
   panMantenimiento1.setActiva(b);
       
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLApellido = new javax.swing.JLabel();
        jTApellido = new javax.swing.JTextField();
        jLCedula = new javax.swing.JLabel();
        jTCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLTelefono = new javax.swing.JLabel();
        jTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTLoguin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTPassword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComCargo = new javax.swing.JComboBox();
        panMantenimiento1 = new clases.PanMantenimiento();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.window);
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setForeground(java.awt.SystemColor.textHighlight);
        jLabel3.setText("PANEL PARA CONFIGURACION DE USUARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 34, 0);
        add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("DATOS DEL USUARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 7, 0);
        add(jLabel1, gridBagConstraints);

        jLNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTNombre, gridBagConstraints);

        jLApellido.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLApellido, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTApellido, gridBagConstraints);

        jLCedula.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLCedula, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTCedula, gridBagConstraints);

        jLabel4.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTextField3, gridBagConstraints);

        jLTelefono.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLTelefono, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTelefono, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setForeground(java.awt.SystemColor.textHighlight);
        jLabel2.setText("DATOS DEL USUARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 7, 0);
        add(jLabel2, gridBagConstraints);

        jLabel7.setText("Loguin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTLoguin, gridBagConstraints);

        jLabel8.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 12);
        add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jTPassword, gridBagConstraints);

        jLabel9.setText("Cargo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel9, gridBagConstraints);

        jComCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cajera", "Administrador" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jComCargo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        add(panMantenimiento1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiUsuarios().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComCargo;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLCedula;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextField jTLoguin;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPassword;
    private javax.swing.JTextField jTelefono;
    private javax.swing.JTextField jTextField3;
    private clases.PanMantenimiento panMantenimiento1;
    // End of variables declaration//GEN-END:variables
    
}
