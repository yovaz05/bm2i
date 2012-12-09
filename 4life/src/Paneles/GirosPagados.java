/*
 * GirosPagados.java
 *
 * Created on 29 de diciembre de 2006, 19:12
 */

package Paneles;

    import beans.Otros;
    import clases.MenuPrin;
    //import com.sun.rmi.rmid.ExecOptionPermission;
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
    import reportesXML.ReportePrevio;
    
    
public class GirosPagados extends javax.swing.JPanel {
    
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
    
    public GirosPagados() {
        initComponents();
        inicializa();
    }
    
    private void inicializa(){
    agencia = new Agencia();
    lista = new Lista(new Agencia().lista());
    for(int i=0;i<lista.getSize();i++){
                                        Agencia b1=(Agencia) lista.getObject(i);
                                        cboAgencia.addItem(b1.getNombre());
                                       }
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
  
 }

private void setTabla(){
     
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));      
         codigos = new CodigoAgencia();
         codigos=(CodigoAgencia) codigo.ultimo();  
         
         Date hora1;
         Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
         Boolean rem=true;
         
         listaAnteriores =new Lista(new Giro().lista15(hora1,hora2,codigos.getAgencia(),rem));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAGIRO,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
     
 }
private void setTabla2(){
     
         horario=new Horario();
         Horario hora = new Horario();
         Boolean est=(false);
         hora=horario.buscar(est);
         codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));      
         codigos = new CodigoAgencia();
         codigos=(CodigoAgencia) codigo.ultimo();  
         
         Date hora1;
         Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
         Boolean rem=true;
         
         listaAnteriores =new Lista(new Giro().lista16(hora1,hora2,rem));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAPAGOGIROS,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);
        
     
 }
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        lblFechaIngreso = new javax.swing.JLabel();
        datHasta = new org.jdesktop.swingx.JXDatePicker();
        jBImprimir = new javax.swing.JButton();
        jLabelCedula2 = new javax.swing.JLabel();
        cboAgencia = new javax.swing.JComboBox();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(java.awt.SystemColor.activeCaptionText);
        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12));
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setText(" TODOS LOS GIROS PAGADO DESDE UNA FECHA HASTA OTRA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 0);
        add(jLabelCreditopendiente2, gridBagConstraints);

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso1.setText("DESDE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(lblFechaIngreso1, gridBagConstraints);

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datDesde, gridBagConstraints);

        lblFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        lblFechaIngreso.setText("HASTA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        add(lblFechaIngreso, gridBagConstraints);

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 0);
        add(datHasta, gridBagConstraints);

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        add(jBImprimir, gridBagConstraints);

        jLabelCedula2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelCedula2.setText("AGENCIA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jLabelCedula2, gridBagConstraints);

        cboAgencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        cboAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgenciaActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 0);
        add(cboAgencia, gridBagConstraints);

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabelNombreGrup1.setText("Nombre del Responsable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(jLabelNombreGrup1, gridBagConstraints);

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jScrollPane2, gridBagConstraints);

        buttonGroup1.add(rb1);
        rb1.setText("Todos");
        rb1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        add(rb1, gridBagConstraints);

        buttonGroup1.add(rb2);
        rb2.setText("Por Agencia");
        rb2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rb2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        add(rb2, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed

        setTabla();
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
   setTabla2();
    }//GEN-LAST:event_rb1ActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        /**TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh); */
    }//GEN-LAST:event_tblProductoMouseClicked

    private void cboAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgenciaActionPerformed
        /**    codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
 
        if (codigos==null){
            Mensaje.showError(this,"Esta agencia no tiene codigo ingrese uno por favor","Error");
 
        }else{
            Float newcod= codigos.getCodigo()+1;
            txtCodigo.setText(String.valueOf(newcod));
            setTabla();
        }   */
    }//GEN-LAST:event_cboAgenciaActionPerformed

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        
        if (rb2.isSelected()==true){
        horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        
        
        Date hora1;
        Date hora2;
        
        hora1=datDesde.getDate();
        hora2=datHasta.getDate();
        Boolean rem=true;
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Giro().lista15(hora1,hora2,codigos.getAgencia(),rem)),Mapa.MAPAGIRO,true),ReportePrevio.GIROS_PAGADOS);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setAgencia(""+codigos.getAgencia().getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        if(rb1.isSelected()==true){
             horario=new Horario();
        Horario hora = new Horario();
        Boolean est=(false);
        hora=horario.buscar(est);
        codigo = new Lista(new CodigoAgencia().lista((Agencia)lista.getObject(cboAgencia.getSelectedIndex())));
        codigos = new CodigoAgencia();
        codigos=(CodigoAgencia) codigo.ultimo();
        
        
        Date hora1;
        Date hora2;
        
        hora1=datDesde.getDate();
        hora2=datHasta.getDate();
        Boolean rem=true;
        
        try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Giro().lista16(hora1,hora2,rem)),Mapa.MAPAPAGOGIROS,true),ReportePrevio.PAGADOS_TODOS);
            rp.setRespon(hora.getUsuario().getNombre()+" "+hora.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            rp.setAgencia(""+codigos.getAgencia().getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        }
    }//GEN-LAST:event_jBImprimirActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboAgencia;
    private org.jdesktop.swingx.JXDatePicker datDesde;
    private org.jdesktop.swingx.JXDatePicker datHasta;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JLabel jLabelCedula2;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
