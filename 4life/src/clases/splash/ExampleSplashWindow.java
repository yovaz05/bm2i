package clases.splash;

import clases.frm_accesosDialog;
import hibernate.HibernateDAO;

//import loja.gob.ec.vista.usuario.frm_accesosDialog;
//import loja.gob.ec.controlador.Configuracion;
import javax.swing.*;
import java.awt.*;
import static javax.swing.JOptionPane.showMessageDialog;
import org.jfree.report.JFreeReportBoot;

public class ExampleSplashWindow {

    private static SplashWindow splash;

    public static void main(String[] args) {
        ExampleSplashWindow ss = new ExampleSplashWindow();
        ss.crearSplash();
    }

    public void crearSplash() {
        splash = new SplashWindow("spla1.gif", true);

        // Between every increment of the progress bar there will be a delay of ne second.
        splash.setDelay(1000);

        // Setting progress bar properties.
        splash.setProgressBarMaximum(10);
        splash.setProgressBarValue(0);
        splash.setProgressBarBounds(35, 230, 400, 6);
        splash.setProgressBarColor(Color.BLACK);
        splash.setProgressBarVisible(true);

        // Setting progress text properties
        splash.setProgressTextBounds(380, 215, 300, 15);
        splash.setProgressTextFont(new Font("SYSTEM", Font.PLAIN, 10));
        splash.setProgressTextColor(Color.BLACK);
        splash.setProgressTextVisible(true);

        // Setting a title label
        JLabel title = new JLabel();
        title.setFont(new Font("Dialog", Font.BOLD, 12));
        title.setForeground(Color.BLACK);
        title.setText("Software de Invetarios - LIKHI S.A - LOJA");
        title.setBounds(240, 180, 260, 30);
        splash.add(title);

        // Setting a subtitle label
        JLabel subtitle = new JLabel();
        subtitle.setFont(new Font("Dialog", Font.PLAIN, 14));
        subtitle.setForeground(Color.BLACK);
        subtitle.setText("Version 1.0");
        subtitle.setBounds(420, 160, 200, 30);
        splash.add(subtitle);

        // Setting a "close" button
        JButton closeButton = new JButton();
        closeButton.setFont(new java.awt.Font("Dialog", 0, 10));
        closeButton.setText("X");
        closeButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        closeButton.setBounds(270, 12, 17, 17);
        closeButton.setOpaque(false);
        closeButton.setForeground(Color.BLACK);
        closeButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        closeButton.setVisible(true);
        //splash.add(closeButton);
        //splash.setAlwaysOnTop(true);

        // Showing splash window
        splash.setVisible(true);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        // Simulate we are loading somethig
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                metodoCero1();
            }
            if (i == 1) {
                metodoDirectorio();
            }
            if (i == 2) {
                metodoCero();
            }
            if (i == 4) {
                metodouno();
            }
            if (i == 7) {
                metododos();
            }
            if (i == 9) {
                splash.close();
                metodotres();
            }
            splash.setProgressText("Iniciando Servicios:  " + componentes(i + 1));
            splash.incrementProgressBarValue(1);
        }
    }

    private String componentes(int num) {
        String mod = "";
        switch (num) {
            case 0:
                mod = "Iniciando UIManager...";
                break;
            case 1:
                mod = "Comprobando Directorios";
                break;
            case 2:
                mod = "Buscando JVM";
                break;
            case 3:
                mod = "Librerias Swing";
                break;
            case 4:
                mod = "Conectando BD";
                break;
            case 5:
                mod = "Coneccion Exitosa";
                break;
            case 6:
                mod = "Modulos";
                break;
            case 7:
                mod = "Reportes";
                break;
            case 8:
                mod = "Frames";
                break;
            case 9:
                mod = "Reportes";
                break;
            case 10:
                mod = "Modulos y Librerias";
                break;
        }
        return mod;
    }

    private static void closeActionPerformed(java.awt.event.ActionEvent evt) {
        splash.close();
    }

    public void metodoDirectorio() {
    }

    public void metodoCero() {
        try {
//            new Reloj(true);
        } catch (Exception e) {
            showMessageDialog(null, "Por favor haga correr el Reloj en el Servidor\n" + e, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public void metodoCero1() {
        try {
//            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
//            UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
//            UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
            //UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void metodouno() {
        try {
            HibernateDAO hd = new HibernateDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void metododos() {
        JFreeReportBoot.getInstance().start();
    }

    public void metodotres() {

        frm_accesosDialog acesso = new frm_accesosDialog();
        acesso.setLocationRelativeTo(null);
        acesso.setAlwaysOnTop(true);
        acesso.setVisible(true);
//        Principal pp = new Principal();
//        pp.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        pp.setVisible(true);
    }
}
