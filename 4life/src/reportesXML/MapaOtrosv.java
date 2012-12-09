/*
 * MapaOtrosv.java
 *
 * Created on 4 de noviembre de 2006, 20:23
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

public class MapaOtrosv extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Linea",
            "Nombre",
            "Unidad",
            "Costo",
            "P.Publico",
            "P.Lider",
            "Puntos",
            "E minima",
            "E maxima",
            "Stock",
            "TOTAL",
          
    };
    private boolean[] edit = new boolean[]{
            false,
            false,
            false,
            false,
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
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class
    };
    
    private Otros otros;
    
    
    public MapaOtrosv(Lista lista,boolean numerador) {
        setNumerador(numerador);
        setColumnNames(getNombre());
        setCanEdit(getEdit());
        setTypes(getTipo());
        setDatos(lista);
    }
    
    public void setDatos(Lista lista){   
        Vector rows = new Vector();
        for (int i = 0; i < lista.getSize(); i++) {
            Vector row = new Vector();
            setOtros((Otros)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
                row.add(""+ getOtros().getLinea().getNombre());
                row.add(""+ getOtros().getNombre());
                row.add(""+ getOtros().getUnidad());
                row.add(""+ getOtros().getCosto());
                row.add(""+ getOtros().getVunitario2());
                row.add(""+ getOtros().getVunitario());
                row.add(""+ getOtros().getPuntos());
                row.add(""+ getOtros().getEminima());
                row.add(""+ getOtros().getEmaxima());
                row.add(""+ getOtros().getStock());
                row.add(""+ getOtros().getTotal());
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


    public Otros getOtros() {
        return otros;
    }

    public void setOtros(Otros otros) {
        this.otros = otros;
    }

    public void setDatos(Vector lista) {
    }
    
}