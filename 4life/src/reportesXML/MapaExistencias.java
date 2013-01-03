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
import modelo.Lista;
import java.util.Vector;



public class MapaExistencias extends ModeloTabla implements ModeloMapa{
    
     private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Producto",
            "Stock",
            "Ext. Min",
            "Ext. Max",
            "Valor"
            
    };
    private boolean[] edit = new boolean[]{
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
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.Double.class
                                    
    };
    
    private Otros otro;
    
    /**
     * Creates a new instance of MapaAcceso
     * @param lista 
     */
    public MapaExistencias(Lista lista,boolean numerador) {
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
            row.add(getOtro().getNombre());
            row.add(new Integer(getOtro().getStock()));
            row.add(new Integer(getOtro().getEminima()));
            row.add(new Integer(getOtro().getEmaxima()));
            row.add(new Double(getOtro().getVunitario()));
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
