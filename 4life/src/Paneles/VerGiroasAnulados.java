/*
 * VerGiroasAnulados.java
 *
 * Created on 29 de diciembre de 2006, 18:40
 */

package Paneles;

    import beans.Otros;
    import clases.MenuPrin;
    import java.util.Date;
    import java.util.List;
    import modelo.Mensaje;
    import modelo.Lista;

    import beans.Agencia;
import beans.Cliente;
    import beans.CodigoAgencia;
import beans.Factura;
    import beans.Giro;
    import beans.Horario;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.DefaultComboBoxModel;
    import org.jdesktop.swingx.autocomplete.Configurator;
    import java.util.Date;
    import reportesXML.Mapa;
    import reportesXML.ReportePrevio;
   
    
public class VerGiroasAnulados extends javax.swing.JPanel {
    
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

public VerGiroasAnulados() {
        initComponents();
        inicializa();
 }
    
private void inicializa(){

    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
    txtNombre.setText(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
  
 }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCreditopendiente2 = new javax.swing.JLabel();
        lblFechaIngreso1 = new javax.swing.JLabel();
        datDesde = new org.jdesktop.swingx.JXDatePicker();
        lblFechaIngreso = new javax.swing.JLabel();
        datHasta = new org.jdesktop.swingx.JXDatePicker();
        jBImprimir = new javax.swing.JButton();
        jLabelNombreGrup1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jButton2 = new javax.swing.JButton();
        jTCodigo = new javax.swing.JTextField();
        jLNombre2 = new javax.swing.JLabel();

        setBackground(java.awt.SystemColor.activeCaption);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCreditopendiente2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelCreditopendiente2.setForeground(new java.awt.Color(204, 0, 51));
        jLabelCreditopendiente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCreditopendiente2.setText("INFORME DE VENTAS POR FECHA Y POR CLIENTE");
        add(jLabelCreditopendiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 533, -1));

        lblFechaIngreso1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso1.setText("DESDE");
        add(lblFechaIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 54, 23));

        datDesde.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 129, -1));

        lblFechaIngreso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaIngreso.setText("HASTA");
        add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 125, 23));

        datHasta.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        add(datHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        jBImprimir.setText("Imprimir");
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });
        add(jBImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, 25));

        jLabelNombreGrup1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLabelNombreGrup1.setText("Nombre del Responsable");
        add(jLabelNombreGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.setSelectionColor(java.awt.SystemColor.activeCaptionText);
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 780, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 960, 470));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/BINOC02A.png"))); // NOI18N
        jButton2.setText("Busca Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));
        add(jTCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 130, -1));

        jLNombre2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jLNombre2.setText("Codigo 4 Life");
        add(jLNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        /**TODO add your handling code here:
        int fila=tblProducto.getSelectedRow();
        gh=(Giro)listaAnteriores.getObject(fila);
        setPanel(gh); */
    }//GEN-LAST:event_tblProductoMouseClicked

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        Cliente cli = new  Cliente();
        String bus = jTCodigo.getText();
        cli = cli.buscarCodigo(bus);
    horario=new Horario();
    Horario otro = new Horario();
    Boolean est=(false);
    otro=horario.buscar(est);
        Date hora1;
        Date hora2;
        
        hora1=datDesde.getDate();
        hora2=datHasta.getDate();
 
        if (jTCodigo.getText().equals("")){
            Mensaje.showError(this,"No ha ingresado ningun codigo","Error");
           // enblanco();
        }else{
                 try {
            
            ReportePrevio rp = new ReportePrevio(new Mapa(new Lista(new Factura().lista14(hora1,hora2,cli)),Mapa.MAPAFAC,true),ReportePrevio.REPORTEQUITO);
            rp.setRespon(otro.getUsuario().getNombre()+" "+otro.getUsuario().getApellido());
            rp.setDesde(hora1);
            rp.setHasta(hora2);
            //rp.setAgencia(""+codigos.getAgencia().getNombre());
            rp.mostrarVistaPreliminar(MenuPrin.escritorio);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        }
  
    }//GEN-LAST:event_jBImprimirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Cliente cli = new  Cliente();
        Date hora1;
        Date hora2;
         
         hora1=datDesde.getDate();
         hora2=datHasta.getDate();
      
        
        
        if (jTCodigo.getText().equals("")){
            Mensaje.showError(this,"No ha ingresado ningun codigo","Error");
           // enblanco();
        }else{
            String bus = jTCodigo.getText();
            cli = cli.buscarCodigo(bus);
            if (cli==null){
                Mensaje.showError(this,"No hay ningun Cliente con este codigo intente denuevo","Error");
                //enblanco();
            }else{
              
         listaAnteriores =new Lista(new Factura().lista14(hora1,hora2,cli));         
         Mapa mapa = new Mapa(listaAnteriores,Mapa.MAPAFACTURA,true);
         reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
         tblProducto.setModel(modelo);   
                
                
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker datDesde;
    private org.jdesktop.swingx.JXDatePicker datHasta;
    private javax.swing.JButton jBImprimir;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLNombre2;
    private javax.swing.JLabel jLabelCreditopendiente2;
    private javax.swing.JLabel jLabelNombreGrup1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblFechaIngreso1;
    private org.jdesktop.swingx.JXTable tblProducto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    
}
