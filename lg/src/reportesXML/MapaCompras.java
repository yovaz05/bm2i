/*
 * MapaCompras.java
 *
 * Created on 7 de noviembre de 2006, 16:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.ComprasOficina;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaCompras extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Descripcion",
            "Valor"
            
    };
    private boolean[] edit = new boolean[]{
            false,
            false,
            false 
            
    };
    private Class[] tipo =new Class[]{
            Integer.class,
            String.class,
            String.class
                                    
    };
    
    private ComprasOficina compras;
    
    
    public MapaCompras(Lista lista,boolean numerador) {
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
            setCompras((ComprasOficina)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getCompras().getDescripcion());
            row.add(""+ getCompras().getValor());
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

    
   public ComprasOficina getCompras() {
        return compras;
    }

    public void setCompras(ComprasOficina compras) {
        this.compras = compras;
    }

    public void setDatos(Vector lista) {
    }
    
}
