/*
 * MapaGiroAnulado.java
 *
 * Created on 31 de octubre de 2006, 14:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.anulargiro;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaGiroAnulado extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
     private String[] nombre = new String[]{
            "N",
            "Codigo",
            "Nombre",
            "Neto",
            "Total",
            "Anulado",
            
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
    
    private anulargiro giro;
    
    
      public MapaGiroAnulado(Lista lista,boolean numerador) {
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
            setGiro((anulargiro)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
                if (getGiro().getGiro().getAgencia().getCodigo().equals("PQ")){
                
                }else{
                    row.add(""+ getGiro().getGiro().getClave());
                    row.add(""+ getGiro().getGiro().getNombre());
                    row.add(""+ getGiro().getGiro().getNeto());
                    row.add(""+ getGiro().getGiro().getTotal());
                    row.add("SI");
                    rows.add(row);
                
                }
                    
                
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

         public anulargiro getGiro() {
        return giro;
    }

    public void setGiro(anulargiro giro) {
        this.giro = giro;
    }

    public void setDatos(Vector lista) {
    }

     
}
