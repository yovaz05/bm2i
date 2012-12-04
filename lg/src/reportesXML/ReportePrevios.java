/*
 * ReportePrevios.java
 *
 * Created on 9 de octubre de 2006, 11:04 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import reportesXML.Mapa;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.jfree.report.JFreeReport;
import org.jfree.report.JFreeReportBoot;
import org.jfree.report.ReportProcessingException;
import org.jfree.report.modules.gui.base.PreviewInternalFrame;
import org.jfree.report.modules.parser.base.ReportGenerator;


public class ReportePrevios {
    
   public static final int FLORES = 1;
   public static final int CIERRE = 2;
   public static final int GIROS = 3;
    
    private String encabezadoDelReporte;
    private String encabezadoDePagina;
    private String encabezadoDeGrupo;
    private String pieDelReporte;
    private String pieDePagina;
    private Mapa mapa;
    private int tipo;
    private URL url;
    private JFreeReport reporte;
    private ReportGenerator generator;   
    
    public ReportePrevios(Mapa mapa, int tipo) {
          this(mapa,tipo,"","","","","");
    }
 public ReportePrevios(Mapa mapa, 
            int tipo, 
            String encabezadoDelReporte, 
            String encabezadoDePagina, 
            String encabezadoDeGrupo, 
            String pieDelReporte, 
            String pieDePagina) {
        setMapa(mapa);
        setTipo(tipo);
        setEncabezadoDelReporte(encabezadoDelReporte);
        setEncabezadoDePagina(encabezadoDePagina);
        setEncabezadoDeGrupo(encabezadoDeGrupo);
        setPieDelReporte(pieDelReporte);
        setPieDePagina(pieDePagina);
    }
  public void mostrarVistaPreliminar(JDesktopPane dsk)throws Exception{
        createReporte();
        try{
            final PreviewInternalFrame preview = new PreviewInternalFrame(getReporte());
            JMenuBar menu=preview.getJMenuBar();
//            for (int i = 0; i <menu.getMenuCount(); i++) {
//                for (int j = 0; j < menu.getMenu(i).getMenuComponentCount(); j++) {
//                    if (menu.getMenu(i).getMenuComponent(j) instanceof JMenuItem){
//                        JMenuItem menuItem = (JMenuItem)menu.getMenu(i).getMenuComponent(j);
//                        if (menuItem.getText().equalsIgnoreCase("Acerca de...")){
//                            menu.getMenu(i).remove(menuItem);
//                            JMenuItem mnuItmAyuda = new JMenuItem("Ayuda");
//                            mnuItmAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
//                            mnuItmAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/16/help.png")));
//                            mnuItmAyuda.setText("Ayuda");
//                            mnuItmAyuda.addActionListener(new java.awt.event.ActionListener() {
//                                public void actionPerformed(java.awt.event.ActionEvent evt) {
//                //                    PantallaPrincipal.getAyuda().showAyuda("productA");
//                                }
//                            });
//                            menu.getMenu(i).add(mnuItmAyuda);
//                        }
//                    }
//                }
//            }
           // setAboutAction(preview);
            preview.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/16/preview.png")));
            preview.setClosable(true);
            preview.setMaximizable(true);
            preview.setIconifiable(true);
            preview.setResizable(true);
            preview.setVisible(true);
            dsk.add(preview, javax.swing.JLayeredPane.DEFAULT_LAYER);
            preview.pack();
            preview.moveToFront();
            preview.setMaximum(true);
        }
        catch (Exception e){
        }
    }
    
    private void setAboutAction(final PreviewInternalFrame previo){
        previo.getBase().setAboutAction(new Action() {
                public void actionPerformed(ActionEvent e) {
                  //  PantallaPrincipal.getAccion().accionAcercaDe(previo);
                }
                public void addPropertyChangeListener(PropertyChangeListener listener) {
                }
                public Object getValue(String key) {
                    return "valor";
                }
                public boolean isEnabled() {
                    return true;
                }
                public void putValue(String key, Object value) {
                }
                public void removePropertyChangeListener(PropertyChangeListener listener) {
                }
                public void setEnabled(boolean b) {
                }
            });
    }
    

    private void createReporte(){
        try {
            
            JFreeReportBoot.getInstance().start();
            loadURL();
            setGenerator(ReportGenerator.getInstance());
            setReporte(getGenerator().parseReport(getUrl()));
            getReporte().setProperty("encGrupo",getEncabezadoDeGrupo());
            getReporte().setProperty("encPagina", getEncabezadoDePagina());
            getReporte().setProperty("encReporte", getEncabezadoDelReporte());
            getReporte().setProperty("piePagina", getPieDePagina());
            getReporte().setProperty("pieReporte", getPieDelReporte());
            loadLogo();
            getReporte().setData(getMapa().getModeloTabla());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
    
    private void loadURL(){
        switch (getTipo()){
            case FLORES:
                setUrl(getClass().getResource("Flores.xml"));
                break;
            case CIERRE:
                setUrl(getClass().getResource("Cierre.xml"));
                break;
            case GIROS:
                setUrl(getClass().getResource("Giros2.xml"));
                break;
        }
    }

    private void loadLogo(){
//        final URL imageURL = getClass().getResource("/UNL.GIF");
//        final Image image = Toolkit.getDefaultToolkit().createImage(imageURL);
//        final WaitingImageObserver obs = new WaitingImageObserver(image);
//        obs.waitImageLoaded();
//        getReporte().setProperty("logo", image);
  //      getReporte().setPropertyMarked("logo", true);
    }
    
    public String getEncabezadoDelReporte() {
        return encabezadoDelReporte;
    }

    public void setEncabezadoDelReporte(String encabezadoDelReporte) {
        this.encabezadoDelReporte = encabezadoDelReporte;
    }

    public String getEncabezadoDePagina() {
        return encabezadoDePagina;
    }

    public void setEncabezadoDePagina(String encabezadoDePagina) {
        this.encabezadoDePagina = encabezadoDePagina;
    }

    public String getEncabezadoDeGrupo() {
        return encabezadoDeGrupo;
    }

    public void setEncabezadoDeGrupo(String encabezadoDeGrupo) {
        this.encabezadoDeGrupo = encabezadoDeGrupo;
    }

    public String getPieDelReporte() {
        return pieDelReporte;
    }

    public void setPieDelReporte(String pieDelReporte) {
        this.pieDelReporte = pieDelReporte;
    }

    public String getPieDePagina() {
        return pieDePagina;
    }

    public void setPieDePagina(String pieDePagina) {
        this.pieDePagina = pieDePagina;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public JFreeReport getReporte() {
        return reporte;
    }

    public void setReporte(JFreeReport reporte) {
        this.reporte = reporte;
    }

    public ReportGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(ReportGenerator generator) {
        this.generator = generator;
    }
      
}
