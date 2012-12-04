/*
 * BilletesTrasmitter.java
 *
 * Created on 10 de enero de 2007, 02:36 AM
 */

package Paneles;

import beans.Billetes;
import beans.Horario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import modelo.Lista;
import modelo.Mensaje;
import org.jdesktop.swingx.autocomplete.Configurator;
import java.util.Date;
import reportesXML.Mapa;


public class BilletesTrasmitter extends javax.swing.JPanel {
    
private Lista lista;
private Lista codigo;
private Horario horario;
private String mensaje="";
private Billetes billete;
private boolean editar;
 Billetes gh;
 Lista listaAnteriores;
    public BilletesTrasmitter() {
        initComponents();
        fijaMetodos();
        inicializa();
    }

    
private void inicializa(){
   Billetes billete = new Billetes();
  
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
  
         
  if(isEditar()){
         getPanel2();
     }else{                       
           billete=new Billetes();
           getPanel();
           if(billete.guardar()){
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
            Mensaje.showMensaje(this,"Guardado");
            modoEdicion(false);           
            setTabla();
        }else
            Mensaje.showError(this,"ERRO AL GRABAR","Error");
    }
    
    private void borrar(){
        boolean b = Mensaje.showPregunta(this,"SEGURO QUE DESEA ELIMINAR ","Eliminar");
        if (b){
            borra();
            setTabla();
            setBlanco();
        }
    }
    
    private void buscar(){
        
    }
    
    private void cancelar(){
        modoEdicion(false);
        if(!lista.isEmpty()){
            billete=(Billetes)lista.getMyself();
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
        billete=(Billetes)lista.anterior();
        setPanel();
       
    }
    
    private void primero(){
        billete=(Billetes)lista.primero();
        setPanel();
        
    }
    
    private void siguiente(){
        billete=(Billetes)lista.siguiente();
        setPanel();
       
    }
    
    private void ultimo(){
        billete=(Billetes)lista.ultimo();
        setPanel();
       
    }
    
private void setPanel(){
   
   jT100.setText(""+billete.getCien());
   JT50.setText(""+billete.getCincuenta());
   jT20.setText(""+billete.getVeinte()); 
   jT10.setText(""+billete.getDiez());
   jT5.setText(""+billete.getCinco());
   jT1.setText(""+billete.getUno());
   JTmoney.setText(""+billete.getMonedas());
  
}  
 private void setPanel(Billetes gg){
   
   jT100.setText(""+gg.getCien());
   JT50.setText(""+gg.getCincuenta());
   jT20.setText(""+gg.getVeinte()); 
   jT10.setText(""+gg.getDiez());
   jT5.setText(""+gg.getCinco());
   jT1.setText(""+gg.getUno());
   JTmoney.setText(""+gg.getMonedas()); 
 }  
    
    private void getPanel(){
            
        if (jT100.getText().equals("")){
            billete.setCien("0");
            jT100.setText("0");
        }else{
            billete.setCien(jT100.getText());
            
        }
        
        if (JT50.getText().equals("")){
        
           billete.setCincuenta("0");
           JT50.setText("0");
        }else{
            billete.setCincuenta(JT50.getText());
        }
        if (jT20.getText().equals("")){
         
           billete.setVeinte("0");
           jT20.setText("0");
        }else{
            billete.setVeinte(jT20.getText());
        }
        if (jT10.getText().equals("")){
           
            billete.setDiez("0");
           jT10.setText("0");
        }else{
             billete.setDiez(jT10.getText());
        }

         if (jT5.getText().equals("")){
           
            billete.setCinco("0");
            jT5.setText("0");
        }else{
            billete.setCinco(jT5.getText());
        }
        
        if (jT1.getText().equals("")){
        
           billete.setUno("0");
           jT1.setText("0");
        }else{
            billete.setUno(jT1.getText());
       
        }
        if (JTmoney.getText().equals("")){
         
          billete.setMonedas("0");
          JTmoney.setText("0");
        }else{
            
        billete.setMonedas(JTmoney.getText());
        }
        
        if (rb2.isSelected()==true){
         billete.setCierre1(false);
        }
       if (rb3.isSelected()==true){
         billete.setCierre1(true);
        }
        
        int u= Integer.parseInt(jT100.getText());
        int d= Integer.parseInt(JT50.getText());
        int t= Integer.parseInt(jT20.getText());
        int c= Integer.parseInt(jT10.getText());
        int q= Integer.parseInt(jT5.getText());
        int s= Integer.parseInt(jT1.getText());
        float mo=Float.parseFloat(JTmoney.getText());
        float suma=(u*100)+(d*50)+(t*20)+(c*10)+(q*5)+s+mo;
        
        
        double si = ((double)Math.round(suma*100))/100;
        billete.setTotal(String.valueOf(si));
        
        horario=new Horario();
        Horario otro = new Horario();
        Boolean est=(false);
        otro=horario.buscar(est);
        billete.setHorario(otro);
        billete.setAdelanto(false);
  
    }
    
   
private void getPanel2(){
        int fila=tblProducto.getSelectedRow();
        gh=(Billetes)codigo.getObject(fila);   
       
       if (jT100.getText().equals("")){
           gh.setCien("0");
            jT100.setText("0");
        }else{
            gh.setCien(jT100.getText());
        }
        
        if (JT50.getText().equals("")){
           gh.setCincuenta("0");
           JT50.setText("0");
        }else{
            gh.setCincuenta(JT50.getText());
        }
        if (jT20.getText().equals("")){
           gh.setVeinte("0");
           jT20.setText("0");
        }else{
            gh.setVeinte(jT20.getText());
        }
        if (jT10.getText().equals("")){
           gh.setDiez("0");
           jT10.setText("0");
        }else{
             gh.setDiez(jT10.getText());
        }

         if (jT5.getText().equals("")){
            gh.setCinco("0");
            jT5.setText("0");
        }else{
            gh.setCinco(jT5.getText());
        }
        
        if (jT1.getText().equals("")){
           gh.setUno("0");
           jT1.setText("0");
        }else{
            gh.setUno(jT1.getText());
       
        }
        if (JTmoney.getText().equals("")){
          gh.setMonedas("0");
          JTmoney.setText("0");
        }else{
            
        gh.setMonedas(JTmoney.getText());
        }
        
        int u= Integer.parseInt(jT100.getText());
        int d= Integer.parseInt(JT50.getText());
        int t= Integer.parseInt(jT20.getText());
        int c= Integer.parseInt(jT10.getText());
        int q= Integer.parseInt(jT5.getText());
        int s= Integer.parseInt(jT1.getText());
        float mo=Float.parseFloat(JTmoney.getText());
        float suma=(u*100)+(d*50)+(t*20)+(c*10)+(q*5)+s+mo;
        
        gh.setTotal(String.valueOf(suma));
        
        if (rb2.isSelected()==true){
         gh.setCierre1(false);
        }
       if (rb3.isSelected()==true){
         gh.setCierre1(true);
        }
        gh.actualizar();      
}
    
private void borra(){
  int fila=tblProducto.getSelectedRow();
  gh=(Billetes)codigo.getObject(fila);     
  gh.borrar();   
  
}
    
    
private void setBlanco(){

   jT100.setText("0");
   JT50.setText("0");
   jT20.setText("0"); 
   jT10.setText("0");
   jT5.setText("0");
   jT1.setText("0");
   JTmoney.setText("0"); 
   
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
 
 public void modoEdicion(boolean b){
   
   jT100.setEditable(b);
   JT50.setEditable(b);
   jT20.setEditable(b);
   jT10.setEditable(b);
   jT5.setEditable(b);
   jT1.setEditable(b);
   JTmoney.setEditable(b);
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
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
         Boolean e=(true);
         
       if (rb2.isSelected()==true){
         e=(false);
        }
       if (rb3.isSelected()==true){
        e=(true);
        }
         codigo = new Lista(new Billetes().lista(otro,e));   
         Mapa mapa = new Mapa(codigo,Mapa.MAPABILLETES,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
}

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente1 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datFechaIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        JT50 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jT20 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTmoney = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jT100 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jT1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jT5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jT10 = new javax.swing.JTextField();
        jLabelSubtitulo6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente1.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente1.setText("PANTALLA PARA ESPECIFICAR LOS BILLETES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        add(jLabelCreditopendiente1, gridBagConstraints);

        lblFechaIngreso1.setText("Fecha de Ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(lblFechaIngreso1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(datFechaIngreso, gridBagConstraints);

        jLabel1.setText("Billetes de 50");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JT50, gridBagConstraints);

        jLabel2.setText("Billetes de 20");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT20, gridBagConstraints);

        jLabel3.setText("Billetes de 5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(JTmoney, gridBagConstraints);

        jLabel4.setText("Billetes de 100");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT100, gridBagConstraints);

        jLabel5.setText("Billetes de 1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT1, gridBagConstraints);

        jLabel6.setText("Billetes de 10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT5, gridBagConstraints);

        jLabel7.setText("Total Monedas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jT10, gridBagConstraints);

        jLabelSubtitulo6.setFont(new java.awt.Font("Bodoni MT", 1, 12));
        jLabelSubtitulo6.setForeground(new java.awt.Color(0, 0, 204));
        jLabelSubtitulo6.setText("DATOS DE LA CAJERA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabelSubtitulo6, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 31, 0, 0);
        add(txtNombre, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
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
        tblProducto.setColumnControlVisible(true);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(tblProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        rb2.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb2);
        rb2.setText("LG TRAVEL");
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb2, gridBagConstraints);

        rb3.setBackground(java.awt.SystemColor.activeCaptionText);
        buttonGroup1.add(rb3);
        rb3.setSelected(true);
        rb3.setText("LG TRASMITTER");
        rb3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 17, 0);
        add(rb3, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        setTabla();
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
// TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Billetes)codigo.getObject(fila);
        setPanel(gh);
    }//GEN-LAST:event_tblProductoMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JT50;
    private javax.swing.JTextField JTmoney;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker datFechaIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCreditopendiente1;
    private javax.swing.JLabel jLabelSubtitulo6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jT1;
    private javax.swing.JTextField jT10;
    private javax.swing.JTextField jT100;
    private javax.swing.JTextField jT20;
    private javax.swing.JTextField jT5;
    private javax.swing.JLabel lblFechaIngreso1;
    private clases.PanMantenimiento panMantenimiento1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
