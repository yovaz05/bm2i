/*
 * MapaVentasdia.java
 *
 * Created on 24 de octubre de 2006, 13:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

//import beans.Otros;
import beans.VentaProductos;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaVentasdia extends ModeloTabla implements ModeloMapa{
    
   private boolean numerador;
    
    private String[] nombre = new String[]{
            "Credito N",
            "Fecha",
            "Cliente",
            "Producto",
            "Unidades al Contado",
            "Unidades a Credito",
            "Total"
            
    };
    private boolean[] edit = new boolean[]{
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false 
            
    };
    private Class[] tipo =new Class[]{
            Integer.class,
            String.class,
            String.class,
            String.class,
            Integer.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private VentaProductos venta;
    
    /**
     * Creates a new instance of MapaAcceso
     * @param lista 
     */
    public MapaVentasdia(Lista lista,boolean numerador) {
        setNumerador(numerador);
        setColumnNames(getNombre());
        setCanEdit(getEdit());
        setTypes(getTipo());
        setDatos(lista);
    }
    
    /**
     * 
     * @param lista 
     */
    public void setDatos(Lista lista){   
        Vector rows = new Vector();
        for (int i = 0; i < lista.getSize(); i++) {
            Vector row = new Vector();
            setVenta((VentaProductos)lista.getObject(i));
//            if(isNumerador())
//                row.add(i+1);
            row.add(""+ getVenta().getId_Venta());
            row.add(""+ getVenta().getFechasalida());
            row.add(""+ getVenta().getNombre());
            row.add(""+ getVenta().getOtros().getNombre());
            
            
            row.add(""+ getVenta().getContado());
            
            row.add(""+getVenta().getCredito());
            row.add(""+ getVenta().getTotal());
            row.add(""+ getVenta().getHorario().getUsuario().getNombre());
            rows.add(row);
        }
        setRows(rows);
        if(!isNumerador())
            deleteColumn(0);
    }
    
    public void setNumerador(boolean b){
        numerador=b;
    }
    
    public boolean isNumerador(){
        return numerador;
    }

    public String[] getNombre() {
        return nombre;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public boolean[] getEdit() {
        return edit;
    }

    public void setEdit(boolean[] edit) {
        this.edit = edit;
    }

    public Class[] getTipo() {
        return tipo;
    }

    public void setTipo(Class[] tipo) {
        this.tipo = tipo;
    }

    public VentaProductos getVenta() {
        return venta;
    }

    public void setVenta(VentaProductos venta) {
        this.venta = venta;
    }

    public void setDatos(Vector lista) {
    }
    
}
