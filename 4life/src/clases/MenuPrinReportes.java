/*
 * MenuPrin.java
 *
 * Created on 13 de abril de 2006, 14:34
 */
package clases;

import hibernate.Configuracion;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class MenuPrinReportes extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrin
     */
    public MenuPrinReportes() {
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
        jXTaskPane1 = new org.jdesktop.swingx.JXTaskPane();
        jXHEnviarGiro = new org.jdesktop.swingx.JXHyperlink();
        jXHPagarGiro = new org.jdesktop.swingx.JXHyperlink();
        jXHGiroOficina = new org.jdesktop.swingx.JXHyperlink();
        jXHEnvioPaquete = new org.jdesktop.swingx.JXHyperlink();
        jXHEnviarGiro1 = new org.jdesktop.swingx.JXHyperlink();
        jXHEnviarGiro2 = new org.jdesktop.swingx.JXHyperlink();
        jXTaskPane2 = new org.jdesktop.swingx.JXTaskPane();
        jXHFlores = new org.jdesktop.swingx.JXHyperlink();
        jXHCabinas = new org.jdesktop.swingx.JXHyperlink();
        jXHConferenciaV = new org.jdesktop.swingx.JXHyperlink();
        jXHVentas = new org.jdesktop.swingx.JXHyperlink();
        jXHFlores1 = new org.jdesktop.swingx.JXHyperlink();
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
        jMenu3 = new javax.swing.JMenu();
        jMvERgIROS1 = new javax.swing.JMenuItem();
        jMGirosRemplazados1 = new javax.swing.JMenuItem();
        jMGirosAnulados1 = new javax.swing.JMenuItem();
        jMGirospagados1 = new javax.swing.JMenuItem();
        jMVerGiroOfi1 = new javax.swing.JMenuItem();
        JMVerPaquetes1 = new javax.swing.JMenuItem();
        jMVerFlores1 = new javax.swing.JMenuItem();
        jMReportesCabinas1 = new javax.swing.JMenuItem();
        jMVerVideo1 = new javax.swing.JMenuItem();
        jMVerVentas1 = new javax.swing.JMenuItem();
        jMVerDarCreditos1 = new javax.swing.JMenuItem();
        jMcREDITOSpAGADOS1 = new javax.swing.JMenuItem();
        jMVerPagoCheque1 = new javax.swing.JMenuItem();
        JMVerProtestados1 = new javax.swing.JMenuItem();
        jMVerPasajes1 = new javax.swing.JMenuItem();

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

        jXTaskPane1.setTitle("    GIROS");

        jXHEnviarGiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Accesos.png"))); // NOI18N
        jXHEnviarGiro.setText("Enviar un Giro");
        jXHEnviarGiro.setEnabled(false);
        jXHEnviarGiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHEnviarGiroActionPerformed(evt);
            }
        });

        jXHPagarGiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/edit_f2.png"))); // NOI18N
        jXHPagarGiro.setText("Pago de Giros");
        jXHPagarGiro.setEnabled(false);
        jXHPagarGiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHPagarGiroActionPerformed(evt);
            }
        });

        jXHGiroOficina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/guardar.png"))); // NOI18N
        jXHGiroOficina.setText("Giros de Oficina");
        jXHGiroOficina.setEnabled(false);
        jXHGiroOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHGiroOficinaActionPerformed(evt);
            }
        });

        jXHEnvioPaquete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/system-log-out(2).png"))); // NOI18N
        jXHEnvioPaquete.setText("Envio de Paquetes");
        jXHEnvioPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHEnvioPaqueteActionPerformed(evt);
            }
        });

        jXHEnviarGiro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Cortar.png"))); // NOI18N
        jXHEnviarGiro1.setText("Devolver un Giro");
        jXHEnviarGiro1.setEnabled(false);
        jXHEnviarGiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHEnviarGiro1ActionPerformed(evt);
            }
        });

        jXHEnviarGiro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Warning.png"))); // NOI18N
        jXHEnviarGiro2.setText("Remplazar un Giro");
        jXHEnviarGiro2.setEnabled(false);
        jXHEnviarGiro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHEnviarGiro2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jXTaskPane1Layout = new org.jdesktop.layout.GroupLayout(jXTaskPane1.getContentPane());
        jXTaskPane1.getContentPane().setLayout(jXTaskPane1Layout);
        jXTaskPane1Layout.setHorizontalGroup(
            jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jXTaskPane1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jXHEnviarGiro2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHGiroOficina, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHEnviarGiro1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHEnviarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHPagarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXHEnvioPaquete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXTaskPane1Layout.setVerticalGroup(
            jXTaskPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jXTaskPane1Layout.createSequentialGroup()
                .add(jXHEnviarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHEnviarGiro1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jXHEnviarGiro2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHPagarGiro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jXHGiroOficina, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(jXHEnvioPaquete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        jPanel5.add(jXTaskPane1, gridBagConstraints);

        jXTaskPane2.setTitle("Ingresos LG");

        jXHFlores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/kcontrol.png"))); // NOI18N
        jXHFlores.setText("Enviar Flores");
        jXHFlores.setEnabled(false);
        jXHFlores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHFloresActionPerformed(evt);
            }
        });

        jXHCabinas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Materia.png"))); // NOI18N
        jXHCabinas.setText("Cabinas");
        jXHCabinas.setEnabled(false);
        jXHCabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHCabinasActionPerformed(evt);
            }
        });

        jXHConferenciaV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Pensum.png"))); // NOI18N
        jXHConferenciaV.setText("Video Conferencia");
        jXHConferenciaV.setEnabled(false);
        jXHConferenciaV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHConferenciaVActionPerformed(evt);
            }
        });

        jXHVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Usuarios.png"))); // NOI18N
        jXHVentas.setText("Ventas ");
        jXHVentas.setEnabled(false);
        jXHVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXHVentasActionPerformed(evt);
            }
        });

        jXHFlores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/Internet.png"))); // NOI18N
        jXHFlores1.setText("Pasajes");
        jXHFlores1.setEnabled(false);
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
                .addContainerGap(72, Short.MAX_VALUE))
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
        jButton1.setToolTipText("Configurar Agencia");
        jButton1.setEnabled(false);
        jButton1.setName("Configurar Agencia"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        enviargiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Accesos.png"))); // NOI18N
        enviargiro.setToolTipText("Enviar un Giro");
        enviargiro.setEnabled(false);
        enviargiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviargiroActionPerformed(evt);
            }
        });
        jToolBar2.add(enviargiro);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/edit_f2.png"))); // NOI18N
        jButton2.setToolTipText("Pago de Giros");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/guardar.png"))); // NOI18N
        jButton4.setToolTipText("Giros de Oficina");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/system-log-out(2).png"))); // NOI18N
        jButton5.setToolTipText("Envio de Paquetes");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jToolBar1.setFocusable(false);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 42));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/kcontrol.png"))); // NOI18N
        jButton3.setToolTipText("Enviar Flores");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Materia.png"))); // NOI18N
        jButton6.setToolTipText("Cabinas");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/24/Pensum.png"))); // NOI18N
        jButton7.setToolTipText("Video Conferencia");
        jButton7.setEnabled(false);
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

        jMenu3.setText("REPORTES");

        jMvERgIROS1.setText("EXISTENCIA DE PRODUCTOS");
        jMvERgIROS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMvERgIROS1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMvERgIROS1);

        jMGirosRemplazados1.setText("RERPORTES DE FACTURAS");
        jMGirosRemplazados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirosRemplazados1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMGirosRemplazados1);

        jMGirosAnulados1.setText("REPORTE UTILIDAD");
        jMGirosAnulados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirosAnulados1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMGirosAnulados1);

        jMGirospagados1.setText("REPORTE DE CIERRES CAJA");
        jMGirospagados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGirospagados1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMGirospagados1);

        jMVerGiroOfi1.setText("FACTURAS POR CLIENTE");
        jMVerGiroOfi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerGiroOfi1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerGiroOfi1);

        JMVerPaquetes1.setText("REPORTE PARA ENVIAR");
        JMVerPaquetes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMVerPaquetes1ActionPerformed(evt);
            }
        });
        jMenu3.add(JMVerPaquetes1);

        jMVerFlores1.setText("Ver las Flores Vendidas");
        jMVerFlores1.setEnabled(false);
        jMVerFlores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerFlores1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerFlores1);

        jMReportesCabinas1.setText("Ver Reportes de Cabinas");
        jMReportesCabinas1.setEnabled(false);
        jMReportesCabinas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMReportesCabinas1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMReportesCabinas1);

        jMVerVideo1.setText("Reporte de Video Conferencias");
        jMVerVideo1.setEnabled(false);
        jMVerVideo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerVideo1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerVideo1);

        jMVerVentas1.setText("Reporte de Ventas Diarias");
        jMVerVentas1.setEnabled(false);
        jMVerVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerVentas1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerVentas1);

        jMVerDarCreditos1.setText("Reporte de Creditos Dados");
        jMVerDarCreditos1.setEnabled(false);
        jMVerDarCreditos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerDarCreditos1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerDarCreditos1);

        jMcREDITOSpAGADOS1.setText("Reportes de Creditos Pagados");
        jMcREDITOSpAGADOS1.setEnabled(false);
        jMcREDITOSpAGADOS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcREDITOSpAGADOS1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMcREDITOSpAGADOS1);

        jMVerPagoCheque1.setText("Reportes de Pagos con Cheques");
        jMVerPagoCheque1.setEnabled(false);
        jMVerPagoCheque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerPagoCheque1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerPagoCheque1);

        JMVerProtestados1.setText("Reporte de Cheques Protestados");
        JMVerProtestados1.setEnabled(false);
        JMVerProtestados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMVerProtestados1ActionPerformed(evt);
            }
        });
        jMenu3.add(JMVerProtestados1);

        jMVerPasajes1.setText("Reporte de Pasajes");
        jMVerPasajes1.setEnabled(false);
        jMVerPasajes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMVerPasajes1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMVerPasajes1);

        jMenuBar1.add(jMenu3);

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
        COMviajes f = new COMviajes();
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

    private void jXHEnviarGiro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHEnviarGiro2ActionPerformed
// TODO add your handling code here:
        RemplazarG f = new RemplazarG();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jXHEnviarGiro2ActionPerformed

    private void jXHEnviarGiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHEnviarGiro1ActionPerformed
        

    }//GEN-LAST:event_jXHEnviarGiro1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        COMvc f = new COMvc();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        COMcb f = new COMcb();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        COMpaquete f = new COMpaquete();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Pagosdegiros f = new Pagosdegiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void enviargiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviargiroActionPerformed
        ConfigurarGiros f = new ConfigurarGiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();

    }//GEN-LAST:event_enviargiroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Confagencia f = new Confagencia();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jXHVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHVentasActionPerformed
        COMVender f = new COMVender();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jXHVentasActionPerformed

    private void jXHConferenciaVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHConferenciaVActionPerformed
        COMvc f = new COMvc();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHConferenciaVActionPerformed

    private void jXHCabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHCabinasActionPerformed
        COMcb f = new COMcb();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHCabinasActionPerformed

    private void jXHFloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHFloresActionPerformed
        COMFLORES f = new COMFLORES();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHFloresActionPerformed

    private void jXHEnvioPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHEnvioPaqueteActionPerformed
        COMpaquete f = new COMpaquete();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();


    }//GEN-LAST:event_jXHEnvioPaqueteActionPerformed

    private void jXHGiroOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHGiroOficinaActionPerformed
        
    }//GEN-LAST:event_jXHGiroOficinaActionPerformed

    private void jXHPagarGiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHPagarGiroActionPerformed
        Pagosdegiros f = new Pagosdegiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jXHPagarGiroActionPerformed

    private void jXHEnviarGiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXHEnviarGiroActionPerformed
        ConfigurarGiros f = new ConfigurarGiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();

    }//GEN-LAST:event_jXHEnviarGiroActionPerformed

    private void jMvERgIROS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMvERgIROS1ActionPerformed

        COMverGiros f = new COMverGiros();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);

        f.moveToFront();
    }//GEN-LAST:event_jMvERgIROS1ActionPerformed

    private void jMGirosRemplazados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirosRemplazados1ActionPerformed
        ComVerFlores f = new ComVerFlores();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMGirosRemplazados1ActionPerformed

    private void jMGirosAnulados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirosAnulados1ActionPerformed
        ComVerCabinas f = new ComVerCabinas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMGirosAnulados1ActionPerformed

    private void jMGirospagados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGirospagados1ActionPerformed

        ComVerDarCreditos f = new ComVerDarCreditos();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMGirospagados1ActionPerformed

    private void jMVerGiroOfi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerGiroOfi1ActionPerformed
        COManulargiros f = new COManulargiros();
        f.setVisible(true);
        f.setBounds(0,0,escritorio.getSize().width,escritorio.getSize().height);
        escritorio.add(f,JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerGiroOfi1ActionPerformed

    private void JMVerPaquetes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMVerPaquetes1ActionPerformed
        ComVerPasajes f = new  ComVerPasajes();
        f.setVisible(true);
        escritorio.add(f,JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_JMVerPaquetes1ActionPerformed

    private void jMVerFlores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerFlores1ActionPerformed
        ComVerFlores f = new ComVerFlores();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerFlores1ActionPerformed

    private void jMReportesCabinas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMReportesCabinas1ActionPerformed
        ComVerCabinas f = new ComVerCabinas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMReportesCabinas1ActionPerformed

    private void jMVerVideo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerVideo1ActionPerformed
        ComVerVideo f = new ComVerVideo();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerVideo1ActionPerformed

    private void jMVerVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerVentas1ActionPerformed
        ConVerVentas f = new ConVerVentas();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerVentas1ActionPerformed

    private void jMVerDarCreditos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerDarCreditos1ActionPerformed
        ComVerDarCreditos f = new ComVerDarCreditos();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_jMVerDarCreditos1ActionPerformed

    private void jMcREDITOSpAGADOS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcREDITOSpAGADOS1ActionPerformed
        // TODO add your handling code here:
        ComDarCredito f = new ComDarCredito();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMcREDITOSpAGADOS1ActionPerformed

    private void jMVerPagoCheque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerPagoCheque1ActionPerformed
        ComVerPagoCheque f = new ComVerPagoCheque();
        f.setVisible(true);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerPagoCheque1ActionPerformed

    private void JMVerProtestados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMVerProtestados1ActionPerformed
        VerChequePro f = new VerChequePro();
        f.setVisible(true);
        f.setBounds(0, 0, escritorio.getSize().width, escritorio.getSize().height);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();

    }//GEN-LAST:event_JMVerProtestados1ActionPerformed

    private void jMVerPasajes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMVerPasajes1ActionPerformed
        ComVerPasajes f = new ComVerPasajes();
        f.setVisible(true);
        escritorio.add(f, JLayeredPane.DEFAULT_LAYER);
        f.moveToFront();
    }//GEN-LAST:event_jMVerPasajes1ActionPerformed

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

        final MenuPrinReportes pantallaPrincipal = new MenuPrinReportes();
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
    private javax.swing.JMenuItem JMVerPaquetes1;
    private javax.swing.JMenuItem JMVerProtestados1;
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
    private javax.swing.JMenuItem jMGirosAnulados1;
    private javax.swing.JMenuItem jMGirosRemplazados1;
    private javax.swing.JMenuItem jMGirospagados1;
    private javax.swing.JMenuItem jMReportesCabinas1;
    private javax.swing.JMenuItem jMVerDarCreditos1;
    private javax.swing.JMenuItem jMVerFlores1;
    private javax.swing.JMenuItem jMVerGiroOfi1;
    private javax.swing.JMenuItem jMVerPagoCheque1;
    private javax.swing.JMenuItem jMVerPasajes1;
    private javax.swing.JMenuItem jMVerVentas1;
    private javax.swing.JMenuItem jMVerVideo1;
    private javax.swing.JMenuItem jMcREDITOSpAGADOS1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMvERgIROS1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private org.jdesktop.swingx.JXHyperlink jXHCabinas;
    private org.jdesktop.swingx.JXHyperlink jXHConferenciaV;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro1;
    private org.jdesktop.swingx.JXHyperlink jXHEnviarGiro2;
    private org.jdesktop.swingx.JXHyperlink jXHEnvioPaquete;
    private org.jdesktop.swingx.JXHyperlink jXHFlores;
    private org.jdesktop.swingx.JXHyperlink jXHFlores1;
    private org.jdesktop.swingx.JXHyperlink jXHGiroOficina;
    private org.jdesktop.swingx.JXHyperlink jXHPagarGiro;
    private org.jdesktop.swingx.JXHyperlink jXHVentas;
    private org.jdesktop.swingx.calendar.JXMonthView jXMonthView1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane1;
    private org.jdesktop.swingx.JXTaskPane jXTaskPane2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    public static Paneles.Escritorio escritorio;
//    public JDesktopPane getescritorio(){
//        return jDesktopPane1;
//    }
}
