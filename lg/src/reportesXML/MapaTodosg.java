/*
 * MapaTodosg.java
 *
 * Created on 8 de octubre de 2006, 03:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Giro;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaTodosg extends ModeloTabla implements ModeloMapa{
    
 private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Responsable",
            "Codigo",
            "Nombre",
            "Neto",
            "Total"
            
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
            String.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private Giro giro;
    
    
    public MapaTodosg(Lista lista,boolean numerador) {
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
            setGiro((Giro)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getGiro().getHorario().getUsuario().getNombre());
            row.add(""+ getGiro().getClave());
            row.add(""+ getGiro().getNombre());
            row.add(""+ getGiro().getNeto());
            row.add(""+ getGiro().getTotal());
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

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public void setDatos(Vector lista) {
    }
    
}
