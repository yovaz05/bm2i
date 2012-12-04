/*
 * MapaCabinas.java
 *
 * Created on 9 de noviembre de 2006, 0:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Cabinas;
import java.util.Date;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaCabinas extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Fecha",
            "Responsable",
            "Valor"
            
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
    
    private Cabinas cabinas;
    
    
    public MapaCabinas(Lista lista,boolean numerador) {
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
            setCabinas((Cabinas)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getCabinas().getFechaLlegada());
            row.add(""+getCabinas().getHorario().getUsuario().getNombre());
            row.add(""+ getCabinas().getValor());
            
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

    public Cabinas getCabinas() {
        return cabinas;
    }

    public void setCabinas(Cabinas cabinas) {
        this.cabinas = cabinas;
    }

    public void setDatos(Vector lista) {
    }

    
}
