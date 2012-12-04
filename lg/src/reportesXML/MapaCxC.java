/*
 * MapaCxC.java
 *
 * Created on 6 de noviembre de 2006, 23:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.CuentasXCobrar;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaCxC extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
           "N",
           "Nombre",
           "Fecha Inicio",
           "Total",
           "Fecha Pago",
           "Cuota",
           "Saldo",
           "Responsable"
            
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
    
    private CuentasXCobrar cuentas;
    
    
    public MapaCxC(Lista lista,boolean numerador) {
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
            setCuentas((CuentasXCobrar)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getCuentas().getCuentasXPagar().getNombre());
            row.add(""+ getCuentas().getCuentasXPagar().getFechaLlegada());
            row.add(""+ getCuentas().getCuentasXPagar().getTotal());
            row.add(""+ getCuentas().getFecha());
            row.add(""+ getCuentas().getCuota());
            row.add(""+ getCuentas().getSaldo());
            row.add(""+ getCuentas().getHorario().getUsuario().getNombre());
            
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

    public CuentasXCobrar getCuentas() {
        return cuentas;
    }

    public void setCuentas(CuentasXCobrar cuentas) {
        this.cuentas = cuentas;
    }

    public void setDatos(Vector lista) {
    }
}
