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
            "Cantidad",
            "Producto Descripcion ",
            "Precio Unitario",
            "Puntos",
            "Precio Total",
            
    };
    private boolean[] edit = new boolean[]{
            false,
            false,
            false,
            false,
            false 
            
    };
    private Class[] tipo =new Class[]{
            String.class,
            String.class,
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
            if(isNumerador())
//                row.add(i+1);
            row.add(""+ getVenta().getCantidad());
            row.add(""+ getVenta().getOtros().getNombre());
            row.add(""+ getVenta().getVuproducto());
            row.add(""+ getVenta().getTotalpuntos());
            row.add(""+ getVenta().getTotalproducto());
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
