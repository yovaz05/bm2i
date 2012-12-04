/*
 * MapaProvedores.java
 *
 * Created on 11 de enero de 2007, 20:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Provedor;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaProvedores extends ModeloTabla implements ModeloMapa{
    
     private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Nombre",
            "Direccion",
            "Telefono",
                       
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
    
    private Provedor provedor;
    
    
    public MapaProvedores(Lista lista,boolean numerador) {
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
            setProvedor((Provedor)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getProvedor().getNombre());
            row.add(""+ getProvedor().getDireccion());
            row.add(""+ getProvedor().getTelefono());
           
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

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }
    
}
