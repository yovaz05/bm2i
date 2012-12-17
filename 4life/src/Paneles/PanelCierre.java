/*
 * PanelCierre.java
 *
 * Created on 7 de noviembre de 2006, 20:28
 */

package Paneles;

import beans.Otros;
import clases.MenuPrin;
import java.util.Date;
import java.util.List;
import modelo.Mensaje;
import modelo.Lista;
import beans.Cierre;
import beans.Otros;
import beans.VentaProductos;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;
import beans.ComprasOficina;
import javax.swing.JLayeredPane;
import reportesXML.ReportePrevio;

public class PanelCierre extends javax.swing.JPanel {
    
    private Lista lista;
    private Lista codigo;
    private Lista codigo1;
    private Horario horario;
    private String mensaje="";
    private boolean editar;
    Lista listaAnteriores;
    private Cierre cierre;
    private Otros otros;
    private Otros ultim;
    private Otros suma;
    private VentaProductos venta;
    private ComprasOficina pras;
    private ComprasOficina pras1;
    public int v=0;
    
public PanelCierre() {
       initComponents();
       generarcierre();
       setTabla3();
}
 

public void  cie(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    
    lista = new Lista(new Cierre().lista(otro, est, est));
    int ver=lista.getSize();
    if (ver ==0){
  
    }else{
    Cierre cie = new Cierre();
    cie=(Cierre)lista.primero();
    
       for(int j=0;j<lista.getSize();j++){
                        Cierre sum=(Cierre)lista.getObject(j);
                       // Mensaje.showMensaje(this,"lo borro encontro "+sum.getId_Cierre());
                        sum.borrar();
                     //   Mensaje.showMensaje(this,"lo borro encontro ");    
                        
                        }
    }
  

}
public void  cie1(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    Boolean es=(true);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, es, est));
    int ver=lista.getSize();
    if (ver ==0){
  
    }else{
    Cierre cie = new Cierre();
    cie=(Cierre)lista.primero();
    
       for(int j=0;j<lista.getSize();j++){
                        Cierre sum=(Cierre)lista.getObject(j);
                       // Mensaje.showMensaje(this,"lo borro encontro "+sum.getId_Cierre());
                        sum.borrar();
                     //   Mensaje.showMensaje(this,"lo borro encontro ");    
                        
                        }
    }
  

}
public void  sumas(){
    
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    lista = new Lista(new Cierre().lista(otro, est, est));
    int ver=lista.getSize();
    float suma1=0;
    
    if (ver !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<lista.getSize();j++){
         Cierre sum=(Cierre)lista.getObject(j);
         suma1= suma1+ Float.parseFloat(sum.getTotal());
       }
   //txtCodigo.setText(String.valueOf(suma1));
    }else{
    // txtCodigo.setText("0");
    }
   //*************************************SCO LO EGRESOS
    Boolean es=(true);
    codigo = new Lista(new Cierre().lista(otro, es, est));
    int  ve=codigo.getSize();
    float suma2=0;
    
    if (ve !=0){
         Cierre cie = new Cierre();
         cie=(Cierre)lista.primero();
    
    for(int j=0;j<codigo.getSize();j++){
         Cierre sum=(Cierre)codigo.getObject(j);
         suma2= suma2+ Float.parseFloat(sum.getTotal());
       }
 //  txtNombre1.setText(String.valueOf(suma2));
    }else{
 //    txtNombre1.setText("0");
    }
  float  to= suma1-suma2;
 // txtAgente.setText(""+to);


   
              
}


 private void compras(){
     
                      horario=new Horario();
                      Horario otro = new Horario();
                      Boolean est=(false);
                      otro=horario.buscar(est);

                      pras = new ComprasOficina();
                      codigo = new Lista(new ComprasOficina().lista3(otro));

                      int tamanio = codigo.getSize();
                      if(tamanio==0){

                      }else{

                      cierre = new Cierre();
                      cierre.setDesde("");
                      cierre.setHasta("");
                      cierre.setIngreso(true);
                      cierre.setConcepto("Compras de Oficina");
                      cierre.setNumero(String.valueOf(tamanio));
                      cierre.setCierre1(true);
                      float o =0;
                      for(int j=0;j<tamanio;j++){
                           ComprasOficina pras1=(ComprasOficina)codigo.getObject(j);
                           o=o+pras1.getValor();


                         }
                      cierre.setTotal(String.valueOf(o));
                      cierre.setNeto("0");
                      cierre.setHorario(otro);
                      if (cierre.guardar()){
                     Mensaje.showError(this,"guardadas las compras ","Error");
                      }
                      } 
     
 }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelCreditopendiente2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabelCivil3 = new javax.swing.JLabel();
        jLabelCivil8 = new javax.swing.JLabel();
        jLabelNombre2 = new javax.swing.JLabel();
        jLabelCivil5 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        txtAgente1 = new javax.swing.JTextField();
        jLabelApellido3 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        txtNeto3 = new javax.swing.JTextField();
        jLabelCreditopendiente4 = new javax.swing.JLabel();
        datFechaIngreso1 = new org.jdesktop.swingx.JXDatePicker();

        setBackground(java.awt.SystemColor.activeCaptionText);
        setLayout(new java.awt.GridBagLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText("Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCreditopendiente2, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(txtNombre, gridBagConstraints);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jXTable2.setColumnControlVisible(true);
        jScrollPane2.setViewportView(jXTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        jXPanel2.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jXPanel2.setName("Panel de Miercoles"); // NOI18N
        jXPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 102));
        jLabel14.setText("                            CIERRE DE TURNO     4 LIFE - 2013           ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 19, 0, 26);
        jXPanel2.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.textHighlight);
        jLabel13.setText("                           En este panel se graba las transacciones del día .");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 7, 0);
        jXPanel2.add(jLabel13, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 16, 7, 21);
        add(jXPanel2, gridBagConstraints);

        jXPanel1.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel1.setDoubleBuffered(false);
        jXPanel1.setFocusCycleRoot(true);
        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Ver Ingreso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jXPanel1.add(jButton1, gridBagConstraints);

        jButton2.setText("Ver Egresos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jXPanel1.add(jButton2, gridBagConstraints);

        jButton3.setText("Cerrar Caja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jXPanel1.add(jButton3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        add(jXPanel1, gridBagConstraints);

        jXPanel3.setBackground(new java.awt.Color(235, 247, 247));
        jXPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jXPanel3.setDoubleBuffered(false);
        jXPanel3.setFocusCycleRoot(true);
        jXPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 0, 153));
        jLabel17.setText("  ____________________");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 6, 25);
        jXPanel3.add(jLabel17, gridBagConstraints);

        jLabelCivil3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil3.setText("Utilidad Neta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelCivil3, gridBagConstraints);

        jLabelCivil8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil8.setText("Total Deposito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelCivil8, gridBagConstraints);

        jLabelNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombre2.setText("Total Ingresos ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 30, 4, 0);
        jXPanel3.add(jLabelNombre2, gridBagConstraints);

        jLabelCivil5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelCivil5.setText("Total Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jXPanel3.add(jLabelCivil5, gridBagConstraints);

        txtCodigo1.setEditable(false);
        txtCodigo1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtCodigo1.setBorder(null);
        txtCodigo1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 33, 4, 0);
        jXPanel3.add(txtCodigo1, gridBagConstraints);

        txtAgente1.setEditable(false);
        txtAgente1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtAgente1.setBorder(null);
        txtAgente1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel3.add(txtAgente1, gridBagConstraints);

        jLabelApellido3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelApellido3.setText("Total Egresos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jXPanel3.add(jLabelApellido3, gridBagConstraints);

        txtNombre2.setEditable(false);
        txtNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNombre2.setBorder(null);
        txtNombre2.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel3.add(txtNombre2, gridBagConstraints);

        txtTotal1.setEditable(false);
        txtTotal1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtTotal1.setBorder(null);
        txtTotal1.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 34, 0, 0);
        jXPanel3.add(txtTotal1, gridBagConstraints);

        txtNeto3.setEditable(false);
        txtNeto3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtNeto3.setBorder(null);
        txtNeto3.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 34, 4, 0);
        jXPanel3.add(txtNeto3, gridBagConstraints);

        jLabelCreditopendiente4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente4.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente4.setText("Fecha ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(2, 35, 2, 0);
        jXPanel3.add(jLabelCreditopendiente4, gridBagConstraints);

        datFechaIngreso1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jXPanel3.add(datFechaIngreso1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        add(jXPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        hora.setFechaFin(new Date());
        hora.setSecion(true);
        hora.actualizar();
        
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(cierre.lista3(hora)),Mapa.MAPACIERRE,true),ReportePrevio.CIERRE);
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
private void generarcierre(){
      compras();
       cie();
       cie1();
      sumas();
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        setTabla();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    setTabla2();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void setTabla(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      Boolean anu=false;
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, est));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRE,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
      //jXTable1.setModel(modelo);
      jXTable2.setModel(modelo);
     
     }
    
 private void setTabla2(){
      horario=new Horario();
      Horario otro = new Horario();
      Boolean est=(false);
      otro=horario.buscar(est);
      Boolean anu=true;
      
      Lista listaAnteriores =new Lista(new Cierre().lista(otro,anu, est));
      Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPACIERRE,true);
      reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
     // jXTable1.setModel(modelo);
       jXTable2.setModel(modelo);
     
     }
 private void setTabla3(){
      //activado=true;
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
               
                
         Lista listaAnteriores =new Lista(new VentaProductos().lista2(hora));
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAVENTASDIA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         jXTable2.setModel(modelo);
     }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabelApellido3;
    private javax.swing.JLabel jLabelCivil3;
    private javax.swing.JLabel jLabelCivil5;
    private javax.swing.JLabel jLabelCivil8;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelCreditopendiente4;
    private javax.swing.JLabel jLabelNombre2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXTable jXTable2;
    private javax.swing.JTextField txtAgente1;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtNeto3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables

    
    
}
