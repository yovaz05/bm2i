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

public class MapaInversion extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Nombre",
            "Costo",
            "Tot Adquirido",
            "Tot Vendido",
            "Stock",
            "Inversion",
            "Ganancia",
            "Tot Puntos",           
          
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
       };
    
    private Otros otros;
    
    
    public MapaInversion(Lista lista,boolean numerador) {
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
                row.add(""+ getOtros().getNombre());
                row.add(""+ getOtros().getCosto());
                row.add(""+ getOtros().getTotal());
                int ven = 0;
                ven=getOtros().getTotal()- getOtros().getStock();
                row.add(""+ ven);
                row.add(""+ getOtros().getStock());
                float inv=0;
                inv=getOtros().getTotal()* getOtros().getCosto();
                row.add(""+ inv);
                row.add(""+ getOtros().getUtilidad());
                row.add(""+ getOtros().getTotal()* getOtros().getPuntos());
               
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