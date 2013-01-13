package reportesXML;

import modelo.Lista;
import java.util.Vector;

public class Mapa {

    public static final int MAPAPRODUCTOS = 1;
    public static final int MAPAVENTASDIA = 2;
    public static final int MAPAGIRO = 3;
    public static final int MAPAREMPLAZO = 4;
    public static final int MAPAINVERSION = 5;
    public static final int MAPAPAGOGIROS = 6;
    public static final int MAPAAGENCIAS = 7;
    public static final int MAPAFLORES = 8;
    public static final int MAPAVIAJES = 9;
    public static final int MAPAOTROSV = 10;
    public static final int MAPACXC = 11;
    public static final int MAPACHEQUE = 12;
    public static final int MAPACXP = 13;
    public static final int MAPACOMPRAS = 14;
    public static final int MAPAPT = 15;
    public static final int MAPACABINAS = 16;
    public static final int MAPACIERRE = 17;
    public static final int MAPAVIDEO = 18;
    public static final int MAPATODOSG = 19;
    public static final int MAPAPAQUETEANULADO = 21;
    public static final int MAPAPROTESTADO = 22;
    public static final int MAPAREPORTECIERRE = 23;
    public static final int MAPABILLETES = 24;
    public static final int MAPAPROVEDOR = 25;
    public static final int MAPADEUDA = 26;
    public static final int MAPAFALTANTECIERRE = 27;
    public static final int MAPAFINTURNO = 28;
    public static final int MAPADEVOLVERPAQUETE = 29;
    public static final int MAPAADQUICICIONES = 30;
    public static final int MAPATARJETAS = 31;
    public static final int MAPALINEA = 32;
    public static final int MAPAMINIMA = 33;
    public static final int CLIENTES = 34;
    public static final int MAPADESGLOCE = 35;
    public static final int MAPAFACTURA = 36;
    public static final int MAPAEXISTENCIAS = 37;
    public static final int MAPACIERRES = 38;
    public static final int MAPAFAC = 39;
    
    private Lista lista;
    private Vector vec;
    private int type;
    private ModeloTabla modeloTabla;
    private boolean numerador;
    private Vector vect;

    public Mapa() {
    }

    public Mapa(Vector vec, int type, boolean numerador) {
        setNumerador(numerador);
        setVect(vec);
        setType(type);
        setMapa();
    }

    public Mapa(Lista lista, int type, boolean numerador) {
        setNumerador(numerador);
        setLista(lista);
        setType(type);
        setMapa();
    }

    public Mapa(Object obj, int type, boolean numerador) {
        setNumerador(numerador);
        setLista(new Lista(obj));
        setType(type);
        setMapa();
    }

    public void setMapa() {
        switch (getType()) {

            case MAPAEXISTENCIAS:
                setMapaExistencias();
                break;
            
            case MAPAPRODUCTOS:
                setMapaProductos();
                break;

            case MAPAVENTASDIA:
                setMapaVentasdia();
                break;

            case MAPAGIRO:
                setMapaGiro();
                break;

            case MAPAREMPLAZO:
                setMapaRemplazo();
                break;

            case MAPAINVERSION:
                setMapaInversion();
                break;

            case MAPAPAGOGIROS:
                setMapaPagoGiros();
                break;

            case MAPAAGENCIAS:
                setMapaAgencias();
                break;

            case MAPAFLORES:
                setMapaFlores();
                break;

            case MAPAVIAJES:
                setMapaViajes();
                break;

            case MAPAOTROSV:
                setMapaOtrosv();
                break;

            case MAPACXC:
                setMapaCxC();
                break;

            case MAPACHEQUE:
                setMapaCheque();
                break;

            case MAPACXP:
                setMapaCxP();
                break;

            case MAPACOMPRAS:
                setMapaCompras();
                break;

            case MAPAPT:
                setMapaPT();
                break;

            case MAPACABINAS:
                setMapaCabinas();
                break;

            case MAPACIERRE:
                setMapaCierre();
                break;
                
            case MAPACIERRES:
                setMapaCierres();
                break;    

            case MAPAVIDEO:
                setMapaVC();
                break;

            case MAPATODOSG:
                setMapaG();
                break;

            case MAPAPAQUETEANULADO:
                setMapaPQ();
                break;

            case MAPAPROTESTADO:
                setMapaPro();
                break;

            case MAPAREPORTECIERRE:
                setMapaReporteCie();
                break;

            case MAPABILLETES:
                setMapaBilletes();
                break;

            case MAPAPROVEDOR:
                setMapaProvedor();
                break;

            case MAPADEUDA:
                setMapaDeudas();
                break;

            case MAPAFALTANTECIERRE:
                setMapaFaltanteCierre();
                break;

            case MAPAFINTURNO:
                setMapaFinTurno();
                break;

            case MAPADEVOLVERPAQUETE:
                setMapaDevolverPaquete();
                break;


            case MAPAADQUICICIONES:
                setMapaAdquiciciones();
                break;


            case MAPATARJETAS:
                setMapaTarjetas();
                break;

            case MAPALINEA:
                setMapaLinea();
                break;

            case MAPAMINIMA:
                setMapaMinima();
                break;

            case CLIENTES:
                setMapaCliente();
                break;
                
            case MAPADESGLOCE:
                setMapaDesgloce();
                break;
                
            case MAPAFACTURA:
                setMapafactura();
                break;
                
           case MAPAFAC:
                setMapafac();
                break;     
                
                
        }
    }

     private void setMapafactura() {
        modeloTabla = new MapaFacturas(lista, isNumerador());
    }
     private void setMapafac() {
        modeloTabla = new MapaFac(lista, isNumerador());
    }
    
     private void setMapaDesgloce() {
        modeloTabla = new MapaDesgloce(lista, isNumerador());
    }
    
    private void setMapaCliente() {
        modeloTabla = new MapaCliente(lista, isNumerador());
    }
    
    private void setMapaMinima() {
        modeloTabla = new MapaMinima(lista, isNumerador());
    }

    private void setMapaLinea() {
        modeloTabla = new MapaLinea(lista, isNumerador());
    }

    private void setMapaTarjetas() {
        modeloTabla = new MapaTarjetas(lista, isNumerador());
    }

    private void setMapaAdquiciciones() {
        modeloTabla = new MapaAdquiciciones(lista, isNumerador());
    }

    private void setMapaDevolverPaquete() {
        modeloTabla = new MapaDevolverPaquete(lista, isNumerador());
    }

    private void setMapaFinTurno() {
        modeloTabla = new MapaFinTurno(lista, isNumerador());
    }

    private void setMapaFaltanteCierre() {
        modeloTabla = new MapaFaltanteCierre(lista, isNumerador());
    }

    private void setMapaDeudas() {
        modeloTabla = new MapaDeudas(lista, isNumerador());
    }

    private void setMapaProvedor() {
        modeloTabla = new MapaProvedores(lista, isNumerador());
    }

    private void setMapaBilletes() {
        modeloTabla = new MapaBilletes(lista, isNumerador());
    }

    private void setMapaReporteCie() {
        modeloTabla = new MapaReporteCierre(lista, isNumerador());
    }

    private void setMapaPro() {
        modeloTabla = new MapaChequePro(lista, isNumerador());
    }

    private void setMapaPQ() {
        modeloTabla = new MapaPaqueteAnulado(lista, isNumerador());
    }

    private void setMapaG() {
        modeloTabla = new MapaTodosg(lista, isNumerador());
    }

    private void setMapaVC() {
        modeloTabla = new MapaVC(lista, isNumerador());
    }

    private void setMapaCierre() {
        modeloTabla = new MapaCierre(lista, isNumerador());
    }
 private void setMapaCierres() {
        modeloTabla = new MapaCierres(lista, isNumerador());
    }
    private void setMapaCabinas() {
        modeloTabla = new MapaCabinas(lista, isNumerador());
    }

    private void setMapaPT() {
        modeloTabla = new MapaPT(lista, isNumerador());
    }

    private void setMapaCompras() {
        modeloTabla = new MapaCompras(lista, isNumerador());
    }

    private void setMapaCxP() {
        modeloTabla = new MapaCxP(lista, isNumerador());
    }

    private void setMapaCheque() {
        modeloTabla = new MapaCheque(lista, isNumerador());
    }

    private void setMapaCxC() {
        modeloTabla = new MapaCxC(lista, isNumerador());
    }

    private void setMapaOtrosv() {
        modeloTabla = new MapaOtrosv(lista, isNumerador());
    }

    private void setMapaViajes() {
        modeloTabla = new MapaViajes(lista, isNumerador());
    }

    private void setMapaFlores() {
        modeloTabla = new MapaFlores(lista, isNumerador());
    }

    private void setMapaAgencias() {
        modeloTabla = new MapaAgencias(lista, isNumerador());
    }

    private void setMapaPagoGiros() {
        modeloTabla = new MapaPagoGiros(lista, isNumerador());
    }

    private void setMapaInversion() {
        modeloTabla = new MapaInversion(lista, isNumerador());
    }

    private void setMapaRemplazo() {
        modeloTabla = new MapaRemplazo(lista, isNumerador());
    }

    private void setMapaProductos() {
        modeloTabla = new MapaProductos(lista, isNumerador());
    }
    
    private void setMapaExistencias() {
        modeloTabla = new MapaExistencias(lista, isNumerador());
    }

    private void setMapaVentasdia() {
        modeloTabla = new MapaVentasdia(lista, isNumerador());
    }

    private void setMapaGiro() {
        modeloTabla = new MapaGiro(lista, isNumerador());
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ModeloTabla getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(ModeloTabla modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public boolean isNumerador() {
        return numerador;
    }

    public void setNumerador(boolean numerador) {
        this.numerador = numerador;
    }

    public Vector getVect() {
        return vect;
    }

    public void setVect(Vector vect) {
        this.vect = vect;
    }

    public Vector getVec() {
        return vec;
    }

    public void setVec(Vector vec) {
        this.vec = vec;
    }
}
