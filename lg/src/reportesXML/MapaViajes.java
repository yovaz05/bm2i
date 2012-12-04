/*
 * MapaViajes.java
 *
 * Created on 4 de noviembre de 2006, 19:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Pasajes;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaViajes extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Fecha",
            "Nombre",
            "Neto",
            "Valor",
            "Responsable"
            
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
    
    private Pasajes pasajes;
    
    
    public MapaViajes(Lista lista,boolean numerador) {
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
            setPasajes((Pasajes)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getPasajes().getFechaLlegada());
            row.add(""+ getPasajes().getNombre());
            row.add(""+ getPasajes().getNeto());
            row.add(""+ getPasajes().getValor());
            row.add(""+ getPasajes().getHorario().getUsuario().getNombre());
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

    public Pasajes getPasajes() {
        return pasajes;
    }

    public void setPasajes(Pasajes pasajes) {
        this.pasajes = pasajes;
    }

    public void setDatos(Vector lista) {
    }
    
}
