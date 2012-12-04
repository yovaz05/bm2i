/*
 * MapaProductos.java
 *
 * Created on 24 de octubre de 2006, 12:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Otros;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;



public class MapaProductos extends ModeloTabla implements ModeloMapa{
    
     private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Stock",
            "Nombre",
            "V Unitario"
            
    };
    private boolean[] edit = new boolean[]{
            false,
            false,
            false,
            false 
            
    };
    private Class[] tipo =new Class[]{
            Integer.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private Otros otro;
    
    /**
     * Creates a new instance of MapaAcceso
     * @param lista 
     */
    public MapaProductos(Lista lista,boolean numerador) {
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
            setOtro((Otros)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getOtro().getStock());
            row.add(""+ getOtro().getNombre());
            row.add(""+ getOtro().getVunitario());
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

    public Otros getOtro() {
        return otro;
    }

    public void setOtro(Otros otro) {
        this.otro = otro;
    }

    public void setDatos(Vector lista) {
    }
}
