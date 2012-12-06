/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Paneles.CinfLinea;
import Paneles.ClientePanel;
import beans.Cliente;
import beans.Linea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Lista;
import modelo.Mensaje;
import reportesXML.Mapa;

/**
 *
 * @author richard
 */
public class ClienteGestionIFrame extends javax.swing.JInternalFrame {

    ClientePanel clientePanel;
    Cliente cliente;
    private Lista lista;
    private Linea linea;
    Linea gh;
    private String mensaje = "";
    private boolean editar;
    Lista listaAnteriores;

    public ClienteGestionIFrame() {
        initComponents();
        //clientePanel = new ClientePanel();

        ///getContentPane().add(clientePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 602, 686));

        fijaMetodos();
        inicializa();
        setTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panMantenimiento1 = new clases.PanMantenimiento();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new org.jdesktop.swingx.JXTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtCelular = new javax.swing.JTextField();

        setBackground(java.awt.SystemColor.window);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Clientes");

        jPanel1.setBackground(java.awt.SystemColor.window);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.textHighlight);
        jLabel3.setText("PANEL PARA GESTION DE CLIENTES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("DATOS DEL CLIENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 2;
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        jPanel1.add(panMantenimiento1, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(302, 250));

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
        tblProducto.setPreferredScrollableViewportSize(new java.awt.Dimension(300, 300));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jPanel2.setBackground(java.awt.SystemColor.window);
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Cedula/RUC:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jLabel2, gridBagConstraints);

        jtCedula.setPreferredSize(new java.awt.Dimension(122, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtCedula, gridBagConstraints);

        jLabel4.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jLabel4, gridBagConstraints);

        jtNombres.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtNombres, gridBagConstraints);

        jLabel5.setText("Apellidos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jLabel5, gridBagConstraints);

        jtApellidos.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtApellidos, gridBagConstraints);

        jLabel6.setText("Codigo Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jLabel6, gridBagConstraints);

        jtCodigo.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtCodigo, gridBagConstraints);

        jLabel7.setText("Correo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jLabel7, gridBagConstraints);

        jtCorreo.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtCorreo, gridBagConstraints);

        jLabel8.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 2);
        jPanel2.add(jLabel8, gridBagConstraints);

        jtTelefono.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtTelefono, gridBagConstraints);

        jLabel9.setText("Celular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 0, 2);
        jPanel2.add(jLabel9, gridBagConstraints);

        jtCelular.setPreferredSize(new java.awt.Dimension(200, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 2);
        jPanel2.add(jtCelular, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jPanel2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isVacio() {
        if (jtApellidos.getText().equalsIgnoreCase("") || jtNombres.getText().equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    private void inicializa() {
        modoEdicion(false);
        setTabla();
    }

    private void fijaMetodos() {

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

    public boolean saveOrUpdate() {
        if (isVacio()) {
            return false;
        }
        if (isEditar()) {
            getPanel2();
            setTabla();
        } else {
            cliente = new Cliente();
            getPanel();
            if (cliente.guardar()) {
                inicializa();
                setTabla();
                //Mensaje.showMensaje(this,"USUARIO AGREGADO");
            } else {
                return false;
            }
        }
        return true;
    }

    private void aceptar() {
        if (saveOrUpdate()) {
            Mensaje.showMensaje(this, "SE HA GRABADO CON EXITO");
            modoEdicion(false);
            verificador();
        } else {
            Mensaje.showError(this, "Este Error se debe a las sigientes opciones: #1 Este nombre de Agencia ya existe, #2 La clave ya existe, #3 El Codigo contiene letras", "Error");
        }
    }

    private void borrar() {
        boolean b = Mensaje.showPregunta(this, "Desea eliminar la Linea", "Eliminar");
        if (b) {
            borra();
            inicializa();
        }
    }

    private void buscar() {
    }

    private void cancelar() {
        modoEdicion(false);
        if (!lista.isEmpty()) {
            linea = (Linea) lista.getMyself();
            setPanel();
        }
    }

    private void editar() {
        setEditar(true);
        modoEdicion(true);
    }

    private void nuevo() {
        setBlanco();
        modoEdicion(true);
        setEditar(false);
    }

    private void anterior() {
        linea = (Linea) lista.anterior();
        setPanel();

    }

    private void primero() {
        linea = (Linea) lista.primero();
        setPanel();

    }

    private void siguiente() {
        linea = (Linea) lista.siguiente();
        setPanel();

    }

    private void ultimo() {
        linea = (Linea) lista.ultimo();
        setPanel();

    }

    private void setPanel() {
        jtCedula.setText(cliente.getCedularuc());
        jtNombres.setText(cliente.getNombres());
        jtApellidos.setText(cliente.getApellidos());
        jtCodigo.setText(cliente.getCodigocliente());
        jtCorreo.setText(cliente.getEmail());
        jtTelefono.setText(cliente.getTelefono());
        jtCelular.setText(cliente.getCelular());
    }

    private void setPanel(Cliente cliente) {
        jtCedula.setText(cliente.getCedularuc());
        jtNombres.setText(cliente.getNombres());
        jtApellidos.setText(cliente.getApellidos());
        jtCodigo.setText(cliente.getCodigocliente());
        jtCorreo.setText(cliente.getEmail());
        jtTelefono.setText(cliente.getTelefono());
        jtCelular.setText(cliente.getCelular());
    }

    private void getPanel() {
        //linea.setNombre(jTNombre.getText());
        cliente.setCedularuc(jtCedula.getText());
        cliente.setNombres(jtNombres.getText());
        cliente.setApellidos(jtApellidos.getText());
        cliente.setCodigocliente(jtCodigo.getText());
        cliente.setEmail(jtCorreo.getText());
        cliente.setTelefono(jtTelefono.getText());
        cliente.setCelular(jtCelular.getText());
    }

    private void getPanel2() {
        int fila = tblProducto.getSelectedRow();
        cliente = (Cliente) listaAnteriores.getObject(fila);
    }

    private void setBlanco() {
        jtCedula.setText("");
        jtNombres.setText("");
        jtApellidos.setText("");
        jtCodigo.setText("");
        jtCorreo.setText("");
        jtTelefono.setText("");
        jtCelular.setText("");
    }

    public void verificador() {
    }

    public void modoEdicion(boolean b) {
        //jTNombre.setEditable(b);
        panMantenimiento1.setActiva(b);
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CinfLinea().setVisible(true);

            }
        });
    }

    private void setTabla() {
        listaAnteriores = new Lista(new Cliente().lista());
        Mapa mapa = new Mapa(listaAnteriores, Mapa.CLIENTES, true);
        reportesXML.ModeloTabla modelo = mapa.getModeloTabla();
        tblProducto.setModel(modelo);
    }
    //**********************************************************************
    //****************           GET PANEL 2    ****************************
    //**********************************************************************

    private void borra() {
        int fila = tblProducto.getSelectedRow();
        cliente = (Cliente) listaAnteriores.getObject(fila);
        cliente.borrar();
        setTabla();
        /*
         * Compras com= new Compras(); Lista lista =new Lista(new
         * Compras().lista12(gh)); if (lista.getSize()<=0){ gh.borrar();
         * setTabla(); }else{ Mensaje.showError(this,"No se puede borrar este
         * Proveedor por que tiene productos vendidos en la empresa","ERROR"); }
         *
         */

    }

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        // TODO add your handling code here:
        int fila = tblProducto.getSelectedRow();

    }//GEN-LAST:event_tblProductoMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtApellidos;
    private javax.swing.JTextField jtCedula;
    private javax.swing.JTextField jtCelular;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtNombres;
    private javax.swing.JTextField jtTelefono;
    private clases.PanMantenimiento panMantenimiento1;
    private org.jdesktop.swingx.JXTable tblProducto;
    // End of variables declaration//GEN-END:variables
}
