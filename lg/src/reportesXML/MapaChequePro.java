/*
 * MapaChequePro.java
 *
 * Created on 21 de octubre de 2006, 04:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.Cheque;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaChequePro extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Nombre",
            "Numero",
            "Utilidad 1",
            "Utilidad 2",
            "Giro",
            "Total",
            "Valor Protesto"

            
    };
    private boolean[] edit = new boolean[]{
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
            String.class
                                    
    };
    
    private Cheque cheque;
    
    
    public MapaChequePro(Lista lista,boolean numerador) {
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
            setCheque((Cheque)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getCheque().getNombre());
            row.add(""+ getCheque().getNumero());
            row.add(""+ getCheque().getUtilidad());
            row.add(""+ getCheque().getUtilidadche());
            row.add(""+ getCheque().getClave());
            row.add(""+ getCheque().getTotal());
            row.add(""+ getCheque().getProtesto());

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
    
    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public void setDatos(Vector lista) {
    }
    
}
