/*
 * nuevoU.java
 *
 * Created on 9 de diciembre de 2006, 20:05
 */

package Paneles;

import beans.Otros;
import beans.Usuario;
import beans.Horario;
import java.awt.event.KeyEvent;
import java.util.List;
import modelo.Lista;
import modelo.Mensaje;
import java.util.Date;
import beans.Tarjetas;
public class nuevoU extends javax.swing.JPanel {
    
   private Usuario usuario;
   private Horario horario;
   private String mensaje="";
   private List lista;
   private Tarjetas tarjetas;
    public nuevoU() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabel2.setBackground(java.awt.SystemColor.textHighlight);
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setForeground(java.awt.SystemColor.textHighlight);
        jLabel2.setText("ENTRAR COMO OTRO USUARIO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 0, 1);
        add(jLabel2, gridBagConstraints);

        jLabel1.setBackground(java.awt.SystemColor.textHighlight);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 13));
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("INGRESE POR FAVOR SU NOMBRE Y CLAVE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 17, 0);
        add(jLabel1, gridBagConstraints);

        jLabel3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 0);
        add(jTNombre, gridBagConstraints);

        jLabel4.setText("Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel4, gridBagConstraints);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 0);
        add(jPasswordField1, gridBagConstraints);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 24, 0, 0);
        add(jButton1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    private void tarjetas(){
        
      horario=new Horario();
                   Horario otro = new Horario();
                   Boolean est=(false);
                   otro=horario.buscar(est);
       Lista listaAnteriores =new Lista(new Otros().lista());
       
       for(int i=0;i<listaAnteriores.getSize();i++){
           
                   Otros b1=(Otros) listaAnteriores.getObject(i);
                   tarjetas = new Tarjetas();
                   tarjetas.setNombre(b1.getNombre());
                   tarjetas.setRecibi(b1.getStock());
                   tarjetas.setFecha(new Date());
                   tarjetas.setHorario(otro);
                   tarjetas.guardar();
                   
                   }
        
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    jTNombre.setEditable(false);
    jPasswordField1.setEditable(false);
    jButton1.setEnabled(false);
    Usuario u= new Usuario();
    horario = new Horario();
    String nom = jTNombre.getText();
    String clav =jPasswordField1.getText();
    
    Boolean seci=false;
    Usuario usa= new Usuario();
    u=usa.bus(nom,clav);
  
   if (u==null){
       Mensaje.showMensaje(this,"EL socio no existe ");
       blanco();
        }else{
    // Mensaje.showMensaje(this,"EL socio existe ");
               Horario otro = new Horario();
               otro=horario.bus(u,seci);
               lista = horario.lista2(seci);
               
                 if(otro==null){
                                 //Mensaje.showMensaje(this,"CUANDO ENTRA POR PRIMERA VEZ UN NUEVO USUARIO ");
                                if (lista.size()==0){
                                    
                                     horario.setUsuario(u);
                                     horario.setFechaInicio(new Date());
                                     horario.setSecion(false);
                                     if (horario.guardar()){
                                     Mensaje.showMensaje(this,"ya se guardo");
                                     tarjetas();
                                     blanco();
                                                        }else{
                                 Mensaje.showMensaje(this,"no guardo nada");
                                  blanco();
                                                                  }     
                                
                                }else{
                                        horario=(Horario) lista.get(0);
                                        Mensaje.showMensaje(this, "ERROR  "+horario.getUsuario().getNombre()+"  NO HA CERRADO EL TURNO");
                                        blanco();
                                }
                            
                              }else{
                                Date fecha=otro.getFechaFin();
                                Boolean sec=otro.getSecion();
                               // Mensaje.showMensaje(this,"lo encontro");
                                if(sec==false){
                                                Mensaje.showMensaje(this,"NO HA MARCADO LA HORA DE SALIDA ");
                                                 blanco();
                                                /*
                                                  otro.setFechaFin(new Date());
                                                  otro.setSecion(true);
                                                  otro.guardar();
                                                 */ 
                                                  
                                               }else{
                                                    horario = new Horario();
                                                    Mensaje.showMensaje(this,"hay que crear otro TURNO");
                                                    horario.setUsuario(u);
                                                    horario.setFechaInicio(new Date());
                                                    horario.setSecion(false);
                                    
                                                     if (horario.guardar()){
                                             Mensaje.showMensaje(this,"ya se guardo");
                                             tarjetas();
                                             blanco();
                                                     }else{
                                             Mensaje.showMensaje(this,"no guardo nada");
                                              blanco();
                                                                  }
                                                      }
   
                                }
   
    }    
                
    }//GEN-LAST:event_jButton1ActionPerformed
private void blanco (){
    jTNombre.setText("");
    jPasswordField1.setText("");
     jButton1.setEnabled(false);
}
    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
if(evt.getKeyCode()== KeyEvent.VK_ENTER){
    jTNombre.setEditable(false);
    jPasswordField1.setEditable(false);
    jButton1.setEnabled(false);
    Usuario u= new Usuario();
    horario = new Horario();
    String nom = jTNombre.getText();
    String clav =jPasswordField1.getText();
    
    Boolean seci=false;
    Usuario usa= new Usuario();
    u=usa.bus(nom,clav);
  
   if (u==null){
       Mensaje.showMensaje(this,"EL socio no existe ");
       blanco();
        }else{
    // Mensaje.showMensaje(this,"EL socio existe ");
               Horario otro = new Horario();
               otro=horario.bus(u,seci);
               lista = horario.lista2(seci);
               
                 if(otro==null){
                                 //Mensaje.showMensaje(this,"CUANDO ENTRA POR PRIMERA VEZ UN NUEVO USUARIO ");
                                if (lista.size()==0){
                                    
                                     horario.setUsuario(u);
                                     horario.setFechaInicio(new Date());
                                     horario.setSecion(false);
                                     if (horario.guardar()){
                                     Mensaje.showMensaje(this,"ya se guardo");
                                     tarjetas();
                                     blanco();
                                                        }else{
                                 Mensaje.showMensaje(this,"no guardo nada");
                                  blanco();
                                                                  }     
                                
                                }else{
                                        horario=(Horario) lista.get(0);
                                        Mensaje.showMensaje(this, "ERROR  "+horario.getUsuario().getNombre()+"  NO HA CERRADO EL TURNO");
                                        blanco();
                                }
                            
                              }else{
                                Date fecha=otro.getFechaFin();
                                Boolean sec=otro.getSecion();
                               // Mensaje.showMensaje(this,"lo encontro");
                                if(sec==false){
                                                Mensaje.showMensaje(this,"NO HA MARCADO LA HORA DE SALIDA ");
                                                 blanco();
                                                /*
                                                  otro.setFechaFin(new Date());
                                                  otro.setSecion(true);
                                                  otro.guardar();
                                                 */ 
                                                  
                                               }else{
                                                    horario = new Horario();
                                                    Mensaje.showMensaje(this,"hay que crear otro TURNO");
                                                    horario.setUsuario(u);
                                                    horario.setFechaInicio(new Date());
                                                    horario.setSecion(false);
                                    
                                                     if (horario.guardar()){
                                             Mensaje.showMensaje(this,"ya se guardo");
                                             tarjetas();
                                             blanco();
                                                     }else{
                                             Mensaje.showMensaje(this,"no guardo nada");
                                              blanco();
                                                                  }
                                                      }
   
                                }
   
    }                                        
       blanco();
        }     
        
    }//GEN-LAST:event_jPasswordField1KeyPressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables
    
}
