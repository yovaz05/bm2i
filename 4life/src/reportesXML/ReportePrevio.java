/*
 * ReportePrevio.java
 *
 * Created on 28 de mayo de 2006, 12:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;



import java.util.Date;
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
//import org.jfree.util.WaitingImageObserver;

/**
 *
 * @author Edison
 */
public class ReportePrevio {

    
    public static final int FLORES = 1;
    public static final int CIERRE = 2;
    public static final int GIROS = 3;
    public static final int REMPLAZA_GIROS = 4;
    public static final int ANULA_GIROS = 5;
    public static final int GIROS_PAGADOS = 7;
    public static final int PAGADOS_TODOS = 8;
    public static final int GIROS_OFI = 9;
    public static final int PAQUETES = 10;
    public static final int VERFLORES = 11;
    public static final int VERCABINAS = 12;
    public static final int VERVIDEO = 13;
    public static final int VERVENTAS = 14;    
    public static final int DARCREDITO = 15;
    public static final int COBRARCREDITO = 16;
    public static final int VERPAGOCHEQUE= 17;
    public static final int CHEQUEPRO= 18;
    public static final int VERPASAJES= 19;
    public static final int CIERRETOTAL= 20;
    public static final int EGRESOS1= 21;
    public static final int CIERRETOTAL2= 22;
    public static final int CIERRETOTAL3= 23;
    public static final int CIERRETOTAL4= 24;
    public static final int CIERREBETOS= 25;
    public static final int CIERREGMT= 26;
    public static final int CIERRELG= 27;
    public static final int FINDETURNO= 28;
    public static final int INVENTARIO= 29;
    public static final int TARJETAS= 30;
    public static final int REPORTEQUITO= 31;
    public static final int REPORTECIERRE= 32;
     public static final int REPORTEUTILIDAD= 33;
    
    
    private String encabezadoDelReporte;
    private String encabezadoDePagina;
    private String encabezadoDeGrupo;
    private String pieDelReporte;
    private String pieDePagina;
    private Mapa mapa;
    private int tipo;
    private int punto;
    private URL url;
    private JFreeReport reporte;
    private ReportGenerator generator;
    private String respon;
    private String telefono;
    private String direccion;
    private Float totale;
    private Float totali;
    private Date desde;
    private Date hasta;
    private String agencia;
    private Float utilidad;
    private Float faltante;
    
    /** Creates a new instance of ReportePrevio */
    public ReportePrevio(Mapa mapa, int tipo) {
        this(mapa,tipo,"","","","","");
    }
    
    public ReportePrevio(Mapa mapa, 
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
            getReporte().setProperty("encResponsable",getEncabezadoDeGrupo());
            getReporte().setProperty("encPagina", getEncabezadoDePagina());
            getReporte().setProperty("encReporte", getEncabezadoDelReporte());
            getReporte().setProperty("piePagina", getPieDePagina());
            getReporte().setProperty("pieReporte", getPieDelReporte()); 
            getReporte().setProperty("respon", getRespon());
            getReporte().setProperty("telefono", getTelefono());
            getReporte().setProperty("direccion", getDireccion());
            getReporte().setProperty("punto", getPunto());
            getReporte().setProperty("desde", getDesde());
            getReporte().setProperty("hasta", getHasta());
            getReporte().setProperty("agencia", getAgencia());
            getReporte().setProperty("totale", getTotale());
            getReporte().setProperty("totali", getTotali());
            getReporte().setProperty("utilidad", getUtilidad());
            getReporte().setProperty("faltante", getFaltante());
            
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
        
           case REMPLAZA_GIROS:
                setUrl(getClass().getResource("Giros3.xml"));
                break;
        
          case ANULA_GIROS:
                setUrl(getClass().getResource("Giros4.xml"));
                break;
        
           case GIROS_PAGADOS:
                setUrl(getClass().getResource("Giros5.xml"));
                break;    
                
               
          case  PAGADOS_TODOS:
                setUrl(getClass().getResource("Giros6.xml"));
                break; 
                
                
          case  GIROS_OFI:
                setUrl(getClass().getResource("GOFI.XML"));
                break;
                
         case  PAQUETES:
                setUrl(getClass().getResource("Paquete.xml"));
                break;
                
          case  VERFLORES:
                setUrl(getClass().getResource("VerFlores.xml"));
                break;
         
          case  VERCABINAS:
                setUrl(getClass().getResource("VerCabinas.xml"));
                break;
                
           case  VERVIDEO:
                setUrl(getClass().getResource("VerVideo.xml"));
                break;
                
          case  VERVENTAS:
                setUrl(getClass().getResource("VerVentas.xml"));
                break;
                
          case  DARCREDITO:
                setUrl(getClass().getResource("DarCredito.xml"));
                break;
                
         case  COBRARCREDITO:
                setUrl(getClass().getResource("CobrarCredito.xml"));
                break;
                
         case  VERPAGOCHEQUE:
                setUrl(getClass().getResource("VerPagoCheque.xml"));
                break;
                
        case  CHEQUEPRO:
                setUrl(getClass().getResource("VerChequeP.xml"));
                break;   
                
        case  VERPASAJES:
                setUrl(getClass().getResource("VPasaje.xml"));
                break; 
                
        case  CIERRETOTAL:
                setUrl(getClass().getResource("CierreTotal.xml"));
                break; 
                
       case  EGRESOS1:
                setUrl(getClass().getResource("Egresos1.xml"));
                break; 
                
                
       case  CIERRETOTAL2:
                setUrl(getClass().getResource("CierreTotal2.xml"));
                break; 
       
       case  CIERRETOTAL3:
                setUrl(getClass().getResource("CierreTotal3.xml"));
                break; 
                
       case  CIERRETOTAL4:
                setUrl(getClass().getResource("CierreTotal4.xml"));
                break; 
                
      case  CIERREBETOS:
                setUrl(getClass().getResource("totalbetos.xml"));
                break;
                
      case  CIERREGMT:
                setUrl(getClass().getResource("cierregmt.xml"));
                break;         
                
      case  CIERRELG:
                setUrl(getClass().getResource("cierreLG.xml"));
                break;

     case  FINDETURNO:
                setUrl(getClass().getResource("findeturno.xml"));
                break;
     
     case  INVENTARIO:
                setUrl(getClass().getResource("Inventario.xml"));
                break;
     case  TARJETAS:
                setUrl(getClass().getResource("Tarjetas.xml"));
                break;           
         
         case  REPORTEQUITO:
                setUrl(getClass().getResource("Reportequito.xml"));
                break;   
              case  REPORTECIERRE:
                setUrl(getClass().getResource("ReporteCierre.xml"));
                break;    
                 case  REPORTEUTILIDAD:
                setUrl(getClass().getResource("ReporteUtilidad.xml"));
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

    public String getRespon() {
        return respon;
    }

    public void setRespon(String respon) {
        this.respon = respon;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Float getTotale() {
        return totale;
    }

    public void setTotale(Float totale) {
        this.totale = totale;
    }

    public Float getTotali() {
        return totali;
    }

    public void setTotali(Float totali) {
        this.totali = totali;
    }

    public Float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Float utilidad) {
        this.utilidad = utilidad;
    }

    public Float getFaltante() {
        return faltante;
    }

    public void setFaltante(Float faltante) {
        this.faltante = faltante;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the punto
     */
    public int getPunto() {
        return punto;
    }

    /**
     * @param punto the punto to set
     */
    public void setPunto(int punto) {
        this.punto = punto;
    }
    
}
