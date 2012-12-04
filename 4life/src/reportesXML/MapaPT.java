/*
 * MapaPT.java
 *
 * Created on 7 de noviembre de 2006, 20:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.PagoT;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaPT extends ModeloTabla implements ModeloMapa{
    
   private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Vendedor",
            "Fecha",
            "# factura",
            "Valor Neto",
            "Valor oagado"
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
    
    private PagoT pago;
    
    
    public MapaPT(Lista lista,boolean numerador) {
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
            setPago((PagoT)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getPago().getVendedor());
            row.add(""+ getPago().getFecha().getYear()+" - "+getPago().getFecha().getMonth()+" - "+getPago().getFecha().getDate());
            row.add(""+ getPago().getFactura());
            row.add(""+ getPago().getValorneto());
            row.add(""+ getPago().getValorpagar());
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

    public PagoT getPago() {
        return pago;
    }

    public void setPago(PagoT pago) {
        this.pago = pago;
    }

    public void setDatos(Vector lista) {
    }
    
}
