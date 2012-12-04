/*
 * MapaRemplazo.java
 *
 * Created on 28 de octubre de 2006, 19:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Giro;
import beans.Remplazo;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaRemplazo extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Codigo",
            "Cajera",
            "Agencia",       
            "Total",
            "Codigo new",
            "Cajera new",
            "Agencia new",
            "Total new"
            
           
            
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
            String.class
                                    
    };
    
    private Remplazo rem;
    
    
    public MapaRemplazo(Lista lista,boolean numerador) {
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
            setRem((Remplazo)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            
                row.add(""+ getRem().getGiro().getClave());
                row.add(""+ getRem().getGiro().getHorario().getUsuario().getNombre());
                row.add(""+ getRem().getGiro().getAgencia().getNombre());
                row.add(""+ getRem().getGiro().getTotal());
                
                row.add(""+ getRem().getGiroviejo().getClave());
                row.add(""+ getRem().getGiroviejo().getHorario().getUsuario().getNombre());
                row.add(""+ getRem().getGiroviejo().getAgencia().getNombre());
                row.add(""+ getRem().getGiroviejo().getTotal());
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

   
    public void setDatos(Vector lista) {
    }

    public Remplazo getRem() {
        return rem;
    }

    public void setRem(Remplazo rem) {
        this.rem = rem;
    }
    
}
