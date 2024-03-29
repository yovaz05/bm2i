/*
 * MenuPrin.java
 *
 * Created on 13 de abril de 2006, 14:34
 */
package clases;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import Paneles.PanelCierre;

public class MenuPrin extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrin
     */
    public MenuPrin() {
        //   JFreeReportBoot.getInstance().start();

        initComponents();
        init();
    }

    private void init() {
        escritorio = new Paneles.Escritorio();
        panel.add(escritorio, BorderLayout.CENTER);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jXMonthView1 = new org.jdesktop.swingx.calendar.JXMonthView();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXHFlores = new org.jdesktop.swingx.JXHyperlink();
        jXHCabinas = new org.jdesktop.swingx.JXHyperlink();
        jXHConferenciaV = new org.jdesktop.swingx.JXHyperlink();
        jXHVentas = new org.jdesktop.swingx.JXHyperlink();
        jXHFlores1 = new org.jdesktop.swingx.JXHyperlink();
        jXTaskPane3 = new org.jdesktop.swingx.JXTaskPane();
        jXHCobrarCreditos = new org.jdesktop.swingx.JXHyperlink();
        jXHDarCredito = new org.jdesktop.swingx.JXHyperlink();
        jXHCheques = new org.jdesktop.swingx.JXHyperlink();
        jXTaskPane5 = new org.jdesktop.swingx.JXTaskPane();
        jXHCobrarCreditos2 = new org.jdesktop.swingx.JXHyperlink();
        jXHDarCredito2 = new org.jdesktop.swingx.JXHyperlink();
        jXHCheques2 = new org.jdesktop.swingx.JXHyperlink();
        panel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        enviargiro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSocios = new javax.swing.JMenu();
        jMenuItemConfiSocios = new javax.swing.JMenuItem();
        jmConfiguracion = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuCuotas = new javax.swing.JMenu();
        jMenuItemPagoCuo = new javax.swing.JMenuItem();
        jMenuItemConfiCuo = new javax.swing.JMenuItem();
        jMFlores = new javax.swing.JMenu();
        jMenuItemPago = new javax.swing.JMenuItem();
        Cabinas = new javax.swing.JMenuItem();
        VideoConferencias = new javax.swing.JMenuItem();
        Pasajes = new javax.swing.JMenuItem();
        jMenuCreditos = new javax.swing.JMenu();
        jMenuItemPagoMercaderia = new javax.swing.JMenuItem();
        jMuNIDADES = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMProvedores = new javax.swing.JMenuItem();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItemAgregarPro = new javax.swing.JMenuItem();
        jMCheques = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMProtestarCheque = new javax.swing.JMenuItem();
        jMCierreFaltante = new javax.swing.JMenuItem();
        jMenuInventario = new javax.swing.JMenu();
        jmProducto = new javax.swing.JMenuItem();
        jMCajas = new javax.swing.JMenu();
        jMVerCaja1 = new javax.swing.JMenuItem();
        jMVercierres1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMNuevoUsuario = new javax.swing.JMenuItem();
        jMVercierres = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMvERgIROS = new javax.swing.JMenuItem();
        jMGirosRemplazados = new javax.swing.JMenuItem();
        jMGirosAnulados = new javax.swing.JMenuItem();
        jMGirospagados = new javax.swing.JMenuItem();
        jMVerGiroOfi = new javax.swing.JMenuItem();
        JMVerPaquetes = new javax.swing.JMenuItem();
        jMVerFlores = new javax.swing.JMenuItem();
        jMReportesCabinas = new javax.swing.JMenuItem();
        jMVerVideo = new javax.swing.JMenuItem();
        jMVerVentas = new javax.swing.JMenuItem();
        jMVerDarCreditos = new javax.swing.JMenuItem();
        jMcREDITOSpAGADOS = new javax.swing.JMenuItem();
        jMVerPagoCheque = new javax.swing.JMenuItem();
        JMVerProtestados = new javax.swing.JMenuItem();
        jMVerPasajes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Princippal");

        jSplitPane1.setBackground(java.awt.Color.white);
        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setDividerSize(10);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jXMonthView1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255)));
        jXMonthView1.setAntialiased(true);
        jXMonthView1.setAutoscrolls(true);
        jXMonthView1.setFocusCycleRoot(true);
        jXMonthView1.setFocusTraversalPolicyProvider(true);
        jXMonthView1.setInheritsPopupMenu(true);
        jXMonthView1.setTraversable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 12, 0);
        jPanel5.add(jXMonthView1, gridBagConstraints);

        jXTaskPane2.setTitle("MENU PRINCIPAL");

        jXHFlores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/kcontrol.png"))); // NOI18N
        jXHFlores.setText("Crear Lineas");
        jXHFlores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHFloresActionPerformed(evt);
            }
        });

        jXHCabinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Materia.png"))); // NOI18N
        jXHCabinas.setText("Crear Clientes");
        jXHCabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHCabinasActionPerformed(evt);
            }
        });

        jXHConferenciaV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Pensum.png"))); // NOI18N
        jXHConferenciaV.setText("Crear producto");
        jXHConferenciaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHConferenciaVActionPerformed(evt);
            }
        });

        jXHVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Usuarios.png"))); // NOI18N
        jXHVentas.setText("AGREGAR UNIDADES");
        jXHVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHVentasActionPerformed(evt);
            }
        });

        jXHFlores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Internet.png"))); // NOI18N
        jXHFlores1.setText("CREAR PROVEEDOR");
        jXHFlores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHFlores1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jXTaskPane2Layout = new org.jdesktop.layout.GroupLayout(jXTaskPane2.getContentPane());
        jXTaskPane2.getContentPane().setLayout(jXTaskPane2Layout);
        jXTaskPane2Layout.setHorizontalGroup(
            jXTaskPane2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jXTaskPane2Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jXTaskPane2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXHFlores1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHVentas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHFlores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHCabinas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHConferenciaV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jXTaskPane2Layout.setVerticalGroup(
            jXTaskPane2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jXTaskPane2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jXHFlores, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jXHCabinas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHConferenciaV, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHVentas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHFlores1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel5.add(jXTaskPane2, gridBagConstraints);

        jXTaskPane3.setTitle("Cuentas");

        jXHCobrarCreditos.setText("FACTURAR");
        jXHCobrarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHCobrarCreditosActionPerformed(evt);
            }
        });

        jXHDarCredito.setText("COMPRAS DE OFICINA");
        jXHDarCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHDarCreditoActionPerformed(evt);
            }
        });

        jXHCheques.setText("CIERRE DE CAJA");
        jXHCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHChequesActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jXTaskPane3Layout = new org.jdesktop.layout.GroupLayout(jXTaskPane3.getContentPane());
        jXTaskPane3.getContentPane().setLayout(jXTaskPane3Layout);
        jXTaskPane3Layout.setHorizontalGroup(
            jXTaskPane3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jXTaskPane3Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jXTaskPane3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXHCobrarCreditos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHDarCredito, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHCheques, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jXTaskPane3Layout.setVerticalGroup(
            jXTaskPane3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jXTaskPane3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jXHCobrarCreditos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jXHDarCredito, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHCheques, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(51, 51, 51))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        jPanel5.add(jXTaskPane3, gridBagConstraints);

        jXTaskPane5.setTitle("USUARIOS Y REPORTES");

        jXHCobrarCreditos2.setText("USUARIOS");
        jXHCobrarCreditos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHCobrarCreditos2ActionPerformed(evt);
            }
        });

        jXHDarCredito2.setText("REPORTE 1");
        jXHDarCredito2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHDarCredito2ActionPerformed(evt);
            }
        });

        jXHCheques2.setText("REPORTE 2");
        jXHCheques2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHCheques2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jXTaskPane5Layout = new org.jdesktop.layout.GroupLayout(jXTaskPane5.getContentPane());
        jXTaskPane5.getContentPane().setLayout(jXTaskPane5Layout);
        jXTaskPane5Layout.setHorizontalGroup(
            jXTaskPane5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jXTaskPane5Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jXTaskPane5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXHCobrarCreditos2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHDarCredito2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHCheques2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jXTaskPane5Layout.setVerticalGroup(
            jXTaskPane5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jXTaskPane5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jXHCobrarCreditos2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jXHDarCredito2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHCheques2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(51, 51, 51))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel5.add(jXTaskPane5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel1.add(jPanel5, gridBagConstraints);

        jSplitPane1.setLeftComponent(jPanel1);

        panel.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setRightComponent(panel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jToolBar2.setFloatable(false);
        jToolBar2.setBorderPainted(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Asistencia.png"))); // NOI18N
        jButton1.setToolTipText("Crear Lineas");
        jButton1.setName("Configurar Agencia"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        enviargiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Accesos.png"))); // NOI18N
        enviargiro.setToolTipText("Crear Cliente");
        enviargiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviargiroActionPerformed(evt);
            }
        });
        jToolBar2.add(enviargiro);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/edit_f2.png"))); // NOI18N
        jButton2.setToolTipText("Crear Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/guardar.png"))); // NOI18N
        jButton4.setToolTipText("GREGAR UNIDADES");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/system-log-out(2).png"))); // NOI18N
        jButton5.setToolTipText("PROVEEDOR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jToolBar1.setFocusable(false);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 42));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/kcontrol.png"))); // NOI18N
        jButton3.setToolTipText("FACTURAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Materia.png"))); // NOI18N
        jButton6.setToolTipText("COMPRAS DE OFICINA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Pensum.png"))); // NOI18N
        jButton7.setToolTipText("Video Conferencia");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Usuarios.png"))); // NOI18N
        jButton8.setToolTipText("Ventas");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Internet.png"))); // NOI18N
        jButton9.setToolTipText("Pasajes");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jToolBar2.add(jToolBar1);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/abrir.png"))); // NOI18N
        jButton10.setToolTipText("Crear un nuevo Producto");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton10);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Profesor.png"))); // NOI18N
        jButton11.setToolTipText("Agregar Unidades");
        jButton11.setEnabled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton11);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Usuarios.png"))); // NOI18N
        jButton12.setToolTipText("Vender Productos");
        jButton12.setEnabled(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton12);

        jToolBar2.add(jToolBar3);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/preferences-desktop-accessibility(2).png"))); // NOI18N
        jButton13.setToolTipText("Pago de Credito (Cuentas por Pagar)");
        jButton13.setEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/preferences-desktop-peripherals(2).png"))); // NOI18N
        jButton14.setToolTipText("Dar Creditos (Cuentas por Cobrar)");
        jButton14.setEnabled(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton14);

        jToolBar2.add(jToolBar4);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.NORTH);

        jMenuSocios.setText("LINEAS");

        jMenuItemConfiSocios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Asistencia.png"))); // NOI18N
        jMenuItemConfiSocios.setText("Configuración de Linea");
        jMenuItemConfiSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfiSociosActionPerformed(evt);
            }
        });
        jMenuSocios.add(jMenuItemConfiSocios);

        jMenuBar1.add(jMenuSocios);

        jmConfiguracion.setText("CLIENTES");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Accesos.png"))); // NOI18N
        jMenuItem5.setText("Crear Cliente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmConfiguracion.add(jMenuItem5);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Warning.png"))); // NOI18N
        jMenuItem9.setText("Remplazo de Giros");
        jMenuItem9.setEnabled(false);
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmConfiguracion.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Cortar.png"))); // NOI18N
        jMenuItem10.setText("Anular Giros");
        jMenuItem10.setEnabled(false);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmConfiguracion.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/edit_f2.png"))); // NOI18N
        jMenuItem11.setText("Pagos de Giros");
        jMenuItem11.setEnabled(false);
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmConfiguracion.add(jMenuItem11);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/guardar.png"))); // NOI18N
        jMenuItem12.setText("Giros de oficina");
        jMenuItem12.setEnabled(false);
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jmConfiguracion.add(jMenuItem12);

        jMenuBar1.add(jmConfiguracion);

        jMenuCuotas.setText("PAQUETES");
        jMenuCuotas.setEnabled(false);

        jMenuItemPagoCuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/system-log-out(2).png"))); // NOI18N
        jMenuItemPagoCuo.setText("Envio de Paquetes");
        jMenuItemPagoCuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagoCuoActionPerformed(evt);
            }
        });
        jMenuCuotas.add(jMenuItemPagoCuo);

        jMenuItemConfiCuo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Cortar.png"))); // NOI18N
        jMenuItemConfiCuo.setText("Anular Paquetes");
        jMenuItemConfiCuo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfiCuoActionPerformed(evt);
            }
        });
        jMenuCuotas.add(jMenuItemConfiCuo);

        jMenuBar1.add(jMenuCuotas);

        jMFlores.setText("INGRESOS LG");
        jMFlores.setEnabled(false);

        jMenuItemPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/kcontrol.png"))); // NOI18N
        jMenuItemPago.setText("Flores");
        jMenuItemPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagoActionPerformed(evt);
            }
        });
        jMFlores.add(jMenuItemPago);

        Cabinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Materia.png"))); // NOI18N
        Cabinas.setText("Cabinas");
        Cabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CabinasActionPerformed(evt);
            }
        });
        jMFlores.add(Cabinas);

        VideoConferencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Pensum.png"))); // NOI18N
        VideoConferencias.setText("Video Conferencias");
        VideoConferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VideoConferenciasActionPerformed(evt);
            }
        });
        jMFlores.add(VideoConferencias);

        Pasajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Internet.png"))); // NOI18N
        Pasajes.setText("Pasajes");
        Pasajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasajesActionPerformed(evt);
            }
        });
        jMFlores.add(Pasajes);

        jMenuBar1.add(jMFlores);

        jMenuCreditos.setText("PRODUCTOS");

        jMenuItemPagoMercaderia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/abrir.png"))); // NOI18N
        jMenuItemPagoMercaderia.setText("Crear un nuevo Producto");
        jMenuItemPagoMercaderia.setActionCommand("CREAR PRODUCTO");
        jMenuItemPagoMercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagoMercaderiaActionPerformed(evt);
            }
        });
        jMenuCreditos.add(jMenuItemPagoMercaderia);

        jMuNIDADES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Profesor.png"))); // NOI18N
        jMuNIDADES.setText("Agregar Unidades");
        jMuNIDADES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMuNIDADESActionPerformed(evt);
            }
        });
        jMenuCreditos.add(jMuNIDADES);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/Usuarios.png"))); // NOI18N
        jMenuItem7.setText("Vender");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuCreditos.add(jMenuItem7);

        jMProvedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/go-home(2).png"))); // NOI18N
        jMProvedores.setText("Configurar Proveedores");
        jMProvedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMProvedoresActionPerformed(evt);
            }
        });
        jMenuCreditos.add(jMProvedores);

        jMenuBar1.add(jMenuCreditos);

        jMenuUsuarios.setText("PRESTAMOS");
        jMenuUsuarios.setEnabled(false);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/preferences-desktop-accessibility(2).png"))); // NOI18N
        jMenuItem13.setText("Cobrar Creditos (Cuentas por Cobrar)");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItem13);

        jMenuItemAgregarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/12/preferences-desktop-peripherals(2).png"))); // NOI18N
        jMenuItemAgregarPro.setText("Dar Creditos (Cuentas por Pagar)");
        jMenuItemAgregarPro.setBorderPainted(true);
        jMenuItemAgregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarProActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemAgregarPro);

        jMenuBar1.add(jMenuUsuarios);

        jMCheques.setEnabled(false);

        jMenuItem14.setText("Pago de Giros con Cheque");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMCheques.add(jMenuItem14);

        jMProtestarCheque.setText("Protestar Cheque");
        jMProtestarCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMProtestarChequeActionPerformed(evt);
            }
        });
        jMCheques.add(jMProtestarCheque);

        jMCierreFaltante.setText("FALTANTE DE CIERRE ANTERIOR");
        jMCierreFaltante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCierreFaltanteActionPerformed(evt);
            }
        });
        jMCheques.add(jMCierreFaltante);

        jMenuBar1.add(jMCheques);

        jMenuInventario.setText("EGRESOS");

        jmProducto.setText("Compras de Oficina");
        jmProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductoActionPerformed(evt);
            }
        });
        jMenuInventario.add(jmProducto);

        jMenuBar1.add(jMenuInventario);

        jMCajas.setText("CIERRE DE CAJA");

        jMVerCaja1.setText("Cierre de Caja");
        jMVerCaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerCaja1ActionPerformed(evt);
            }
        });
        jMCajas.add(jMVerCaja1);

        jMVercierres1.setText("EDITAR FACTURA");
        jMVercierres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVercierres1ActionPerformed(evt);
            }
        });
        jMCajas.add(jMVercierres1);

        jMenuBar1.add(jMCajas);

        jMenu1.setText("USUARIOS");

        jMenuItem1.setText("CONFIGURAR USUARIOS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMNuevoUsuario.setText("Entrar como Nuevo Usuario");
        jMNuevoUsuario.setEnabled(false);
        jMNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMNuevoUsuario);

        jMVercierres.setText("Ver Cierres");
        jMVercierres.setEnabled(false);
        jMVercierres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVercierresActionPerformed(evt);
            }
        });
        jMenu1.add(jMVercierres);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("REPORTES");

        jMvERgIROS.setText("EXISTENCIA DE PRODUCTOS");
        jMvERgIROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMvERgIROSActionPerformed(evt);
            }
        });
        jMenu2.add(jMvERgIROS);

        jMGirosRemplazados.setText("RERPORTES DE FACTURAS");
        jMGirosRemplazados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirosRemplazadosActionPerformed(evt);
            }
        });
        jMenu2.add(jMGirosRemplazados);

        jMGirosAnulados.setText("REPORTE UTILIDAD");
        jMGirosAnulados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirosAnuladosActionPerformed(evt);
            }
        });
        jMenu2.add(jMGirosAnulados);

        jMGirospagados.setText("REPORTE DE CIERRES CAJA");
        jMGirospagados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirospagadosActionPerformed(evt);
            }
        });
        jMenu2.add(jMGirospagados);

        jMVerGiroOfi.setText("FACTURAS POR CLIENTE");
        jMVerGiroOfi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerGiroOfiActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerGiroOfi);

        JMVerPaquetes.setText("REPORTE PARA ENVIAR");
        JMVerPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMVerPaquetesActionPerformed(evt);
            }
        });
        jMenu2.add(JMVerPaquetes);

        jMVerFlores.setText("Ver las Flores Vendidas");
        jMVerFlores.setEnabled(false);
        jMVerFlores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerFloresActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerFlores);

        jMReportesCabinas.setText("Ver Reportes de Cabinas");
        jMReportesCabinas.setEnabled(false);
        jMReportesCabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMReportesCabinasActionPerformed(evt);
            }
        });
        jMenu2.add(jMReportesCabinas);

        jMVerVideo.setText("Reporte de Video Conferencias");
        jMVerVideo.setEnabled(false);
        jMVerVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerVideoActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerVideo);

        jMVerVentas.setText("Reporte de Ventas Diarias");
        jMVerVentas.setEnabled(false);
        jMVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerVentasActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerVentas);

        jMVerDarCreditos.setText("Reporte de Creditos Dados");
        jMVerDarCreditos.setEnabled(false);
        jMVerDarCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerDarCreditosActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerDarCreditos);

        jMcREDITOSpAGADOS.setText("Reportes de Creditos Pagados");
        jMcREDITOSpAGADOS.setEnabled(false);
        jMcREDITOSpAGADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcREDITOSpAGADOSActionPerformed(evt);
            }
        });
        jMenu2.add(jMcREDITOSpAGADOS);

        jMVerPagoCheque.setText("Reportes de Pagos con Cheques");
        jMVerPagoCheque.setEnabled(false);
        jMVerPagoCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerPagoChequeActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerPagoCheque);

        JMVerProtestados.setText("Reporte de Cheques Protestados");
        JMVerProtestados.setEnabled(false);
        JMVerProtestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMVerProtestadosActionPerformed(evt);
            }
        });
        jMenu2.add(JMVerProtestados);

        jMVerPasajes.setText("Reporte de Pasajes");
        jMVerPasajes.setEnabled(false);
        jMVerPasajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerPasajesActionPerformed(evt);
            }
        });
        jMenu2.add(jMVerPasajes);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-845)/2, (screenSize.height-856)/2, 845, 856);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        COMCxP f = new COMCxP();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        COMCunetasXcobrar f = new COMCunetasXcobrar();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        COMAgreUnidades f = new COMAgreUnidades();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        COMOtrosV f = new COMOtrosV();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jButton10ActionPerformed

    private void jXHFlores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHFlores1ActionPerformed
       COMProvedor f = new COMProvedor();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHFlores1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        COMviajes f = new COMviajes();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMVercierresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVercierresActionPerformed
        Vercierrres f = new Vercierrres();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
//                DEFAULT_LAYER);
        f.moveToFront();
// TODO add your handling code here:
    }//GEN-LAST:event_jMVercierresActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     COMprasOficina f = new COMprasOficina();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        COMProvedor f = new COMProvedor();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        COMAgreUnidades f = new COMAgreUnidades();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             COMOtrosV f = new COMOtrosV();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void enviargiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviargiroActionPerformed
   

    }//GEN-LAST:event_enviargiroActionPerformed

    private void PasajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasajesActionPerformed
// TODO add your handling code here:
        COMviajes f = new COMviajes();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_PasajesActionPerformed

    private void VideoConferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VideoConferenciasActionPerformed
// TODO add your handling code here:
        COMvc f = new COMvc();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_VideoConferenciasActionPerformed

    private void CabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CabinasActionPerformed
        COMcb f = new COMcb();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_CabinasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           Confagencia f = new Confagencia();
        f.setVisible(true);
        //f.setBounds(0,0,escritorio.getSize().width,escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMCierreFaltanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCierreFaltanteActionPerformed

        COmCieereFaltante f = new COmCieereFaltante();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMCierreFaltanteActionPerformed

    private void jMProvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMProvedoresActionPerformed
        COMProvedor f = new COMProvedor();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMProvedoresActionPerformed

    private void jXHCheques2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHCheques2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jXHCheques2ActionPerformed

    private void jXHDarCredito2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHDarCredito2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jXHDarCredito2ActionPerformed

    private void jXHCobrarCreditos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHCobrarCreditos2ActionPerformed
    ConfiUser f = new ConfiUser();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();// TODO add your handling code here:
    }//GEN-LAST:event_jXHCobrarCreditos2ActionPerformed

    private void jXHChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHChequesActionPerformed
      COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHChequesActionPerformed

    private void jXHDarCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHDarCreditoActionPerformed
         COMprasOficina f = new COMprasOficina();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jXHDarCreditoActionPerformed

    private void jXHCobrarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHCobrarCreditosActionPerformed
         COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jXHCobrarCreditosActionPerformed

    private void jXHVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHVentasActionPerformed
        COMAgreUnidades f = new COMAgreUnidades();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jXHVentasActionPerformed

    private void jXHConferenciaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHConferenciaVActionPerformed
          COMOtrosV f = new COMOtrosV();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHConferenciaVActionPerformed

    private void jXHCabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHCabinasActionPerformed
        
    }//GEN-LAST:event_jXHCabinasActionPerformed

    private void jXHFloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHFloresActionPerformed
            Confagencia f = new Confagencia();
        f.setVisible(true);
        //f.setBounds(0,0,escritorio.getSize().width,escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHFloresActionPerformed

    private void jMVerCaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerCaja1ActionPerformed
        COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerCaja1ActionPerformed

    private void jMVerPasajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerPasajesActionPerformed
        ComVerPasajes f = new ComVerPasajes();
        f.setVisible(true);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerPasajesActionPerformed

    private void JMVerProtestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMVerProtestadosActionPerformed
        VerChequePro f = new VerChequePro();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_JMVerProtestadosActionPerformed

    private void jMVerPagoChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerPagoChequeActionPerformed
        ComVerPagoCheque f = new ComVerPagoCheque();
        f.setVisible(true);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMVerPagoChequeActionPerformed

    private void jMcREDITOSpAGADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcREDITOSpAGADOSActionPerformed
// TODO add your handling code here:
        ComDarCredito f = new ComDarCredito();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMcREDITOSpAGADOSActionPerformed

    private void jMVerDarCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerDarCreditosActionPerformed
        ComVerDarCreditos f = new ComVerDarCreditos();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jMVerDarCreditosActionPerformed

    private void jMVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerVentasActionPerformed
        ConVerVentas f = new ConVerVentas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerVentasActionPerformed

    private void jMVerVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerVideoActionPerformed
        ComVerVideo f = new ComVerVideo();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerVideoActionPerformed

    private void jMReportesCabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMReportesCabinasActionPerformed
        ComVerCabinas f = new ComVerCabinas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMReportesCabinasActionPerformed

    private void jMVerFloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerFloresActionPerformed
        ComVerFlores f = new ComVerFlores();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerFloresActionPerformed

    private void JMVerPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMVerPaquetesActionPerformed
           ComVerPasajes f = new  ComVerPasajes();
        f.setVisible(true);
        escritorio.add(f,JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_JMVerPaquetesActionPerformed

    private void jMVerGiroOfiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerGiroOfiActionPerformed
          COManulargiros f = new COManulargiros();
        f.setVisible(true);
       f.setBounds(0,0,escritorio.getSize().width,escritorio.getSize().height);
        escritorio.add(f,JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMVerGiroOfiActionPerformed

    private void jMProtestarChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMProtestarChequeActionPerformed
        
    }//GEN-LAST:event_jMProtestarChequeActionPerformed

    private void jMGirospagadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirospagadosActionPerformed
      
       ComVerDarCreditos f = new ComVerDarCreditos();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMGirospagadosActionPerformed

    private void jMGirosAnuladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirosAnuladosActionPerformed
       ComVerCabinas f = new ComVerCabinas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMGirosAnuladosActionPerformed

    private void jMGirosRemplazadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirosRemplazadosActionPerformed
        ComVerFlores f = new ComVerFlores();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMGirosRemplazadosActionPerformed

    private void jMuNIDADESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMuNIDADESActionPerformed
        COMAgreUnidades f = new COMAgreUnidades();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMuNIDADESActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        COMCheque f = new COMCheque();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        COMCunetasXcobrar f = new COMCunetasXcobrar();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
      

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        Pagosdegiros f = new Pagosdegiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
     
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        RemplazarG f = new RemplazarG();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMvERgIROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMvERgIROSActionPerformed

        COMverGiros f = new COMverGiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();

    }//GEN-LAST:event_jMvERgIROSActionPerformed

    private void jMNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNuevoUsuarioActionPerformed
        COMnuevoU f = new COMnuevoU();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMNuevoUsuarioActionPerformed

    private void jMenuItemPagoMercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagoMercaderiaActionPerformed
        COMOtrosV f = new COMOtrosV();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMenuItemPagoMercaderiaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        ConfiUser f = new ConfiUser();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductoActionPerformed
        COMprasOficina f = new COMprasOficina();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jmProductoActionPerformed

    private void jMenuItemAgregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarProActionPerformed

        COMCxP f = new COMCxP();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jMenuItemAgregarProActionPerformed

    private void jMenuItemConfiCuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfiCuoActionPerformed
       
    }//GEN-LAST:event_jMenuItemConfiCuoActionPerformed

    private void jMenuItemPagoCuoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagoCuoActionPerformed
        COMpaquete f = new COMpaquete();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMenuItemPagoCuoActionPerformed

    private void jMenuItemConfiSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfiSociosActionPerformed

        Confagencia f = new Confagencia();
        f.setVisible(true);
        //f.setBounds(0,0,escritorio.getSize().width,escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMenuItemConfiSociosActionPerformed

    private void jMenuItemPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagoActionPerformed
        COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMenuItemPagoActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

      COMvc f = new COMvc();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMVercierres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVercierres1ActionPerformed
       Vercierrres f = new Vercierrres();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
//                DEFAULT_LAYER);
        f.moveToFront();
// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMVercierres1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*final PanSplash panSplash = new PanSplash(new javax.swing.JFrame());
         SwingUtilities.invokeLater(new Runnable() {
         public void run() {
         panSplash.showSplashScreen();
         }
         });*/

        final MenuPrin pantallaPrincipal = new MenuPrin();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //panSplash.hideSplash();
                java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                pantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                pantallaPrincipal.setBounds(0, 0, screenSize.width, screenSize.height);
                pantallaPrincipal.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Cabinas;
    private javax.swing.JMenuItem JMVerPaquetes;
    private javax.swing.JMenuItem JMVerProtestados;
    private javax.swing.JMenuItem Pasajes;
    private javax.swing.JMenuItem VideoConferencias;
    private javax.swing.JButton enviargiro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMCajas;
    private javax.swing.JMenu jMCheques;
    private javax.swing.JMenuItem jMCierreFaltante;
    private javax.swing.JMenu jMFlores;
    private javax.swing.JMenuItem jMGirosAnulados;
    private javax.swing.JMenuItem jMGirosRemplazados;
    private javax.swing.JMenuItem jMGirospagados;
    private javax.swing.JMenuItem jMNuevoUsuario;
    private javax.swing.JMenuItem jMProtestarCheque;
    private javax.swing.JMenuItem jMProvedores;
    private javax.swing.JMenuItem jMReportesCabinas;
    private javax.swing.JMenuItem jMVerCaja1;
    private javax.swing.JMenuItem jMVerDarCreditos;
    private javax.swing.JMenuItem jMVerFlores;
    private javax.swing.JMenuItem jMVerGiroOfi;
    private javax.swing.JMenuItem jMVerPagoCheque;
    private javax.swing.JMenuItem jMVerPasajes;
    private javax.swing.JMenuItem jMVerVentas;
    private javax.swing.JMenuItem jMVerVideo;
    private javax.swing.JMenuItem jMVercierres;
    private javax.swing.JMenuItem jMVercierres1;
    private javax.swing.JMenuItem jMcREDITOSpAGADOS;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCreditos;
    private javax.swing.JMenu jMenuCuotas;
    private javax.swing.JMenu jMenuInventario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemAgregarPro;
    private javax.swing.JMenuItem jMenuItemConfiCuo;
    private javax.swing.JMenuItem jMenuItemConfiSocios;
    private javax.swing.JMenuItem jMenuItemPago;
    private javax.swing.JMenuItem jMenuItemPagoCuo;
    private javax.swing.JMenuItem jMenuItemPagoMercaderia;
    private javax.swing.JMenu jMenuSocios;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JMenuItem jMuNIDADES;
    private javax.swing.JMenuItem jMvERgIROS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private org.jdesktop.swingx.JXHyperlink jXHCabinas;
    private org.jdesktop.swingx.JXHyperlink jXHCheques;
    private org.jdesktop.swingx.JXHyperlink jXHCheques2;
    private org.jdesktop.swingx.JXHyperlink jXHCobrarCreditos;
    private org.jdesktop.swingx.JXHyperlink jXHCobrarCreditos2;
    private org.jdesktop.swingx.JXHyperlink jXHConferenciaV;
    private org.jdesktop.swingx.JXHyperlink jXHDarCredito;
    private org.jdesktop.swingx.JXHyperlink jXHDarCredito2;
    private org.jdesktop.swingx.JXHyperlink jXHFlores;
    private org.jdesktop.swingx.JXHyperlink jXHFlores1;
    private org.jdesktop.swingx.JXHyperlink jXHVentas;
    private org.jdesktop.swingx.calendar.JXMonthView jXMonthView1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane3;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane5;
    private javax.swing.JMenu jmConfiguracion;
    private javax.swing.JMenuItem jmProducto;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    public static Paneles.Escritorio escritorio;
//    public JDesktopPane getescritorio(){
//        return jDesktopPane1;
//    }
}
