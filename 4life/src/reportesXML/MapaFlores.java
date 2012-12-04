/*
 * MapaFlores.java
 *
 * Created on 3 de noviembre de 2006, 17:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Flores;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaFlores extends ModeloTabla implements ModeloMapa{
    
   private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Factura #",
            "Nombre",
            "Dedicatoria",
            "Descripcion",
            "Total",
            "Recibe",
            "Pais",
            "Ciudad",
            "Direccion",
            "Telefono"
            
            
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
            String.class
                                    
    };
    
    private Flores flores;
    
    
    public MapaFlores(Lista lista,boolean numerador) {
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
            setFlores((Flores)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getFlores().getFactura());
            row.add(""+ getFlores().getNombre());
            row.add(""+ getFlores().getDedicatoria());
            row.add(""+ getFlores().getDescripcion()); 
            row.add(""+ getFlores().getTotal());
            row.add(""+ getFlores().getRecibe());
            row.add(""+ getFlores().getPais());
            row.add(""+ getFlores().getCiudad());
            row.add(""+ getFlores().getDireccion());
            row.add(""+ getFlores().getTelefono());
           
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

    
    public Flores getFlores() {
        return flores;
    }

    public void setFlores(Flores flores) {
        this.flores = flores;
    }

    public void setDatos(Vector lista) {
    }

  
}
