/*
 * MapaCierre.java
 *
 * Created on 13 de noviembre de 2006, 13:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

    import beans.Cierre;
    import modelo.Fechas;
    import modelo.Lista;
    import reportesXML.ModeloMapa;
    import reportesXML.ModeloTabla;
    import java.util.Vector;
    

public class MapaCierres extends ModeloTabla implements ModeloMapa{
    
     private boolean numerador;
    
    private String[] nombre = new String[]{
            
            "N",
            "Inicio",
            "Fin",
            "T Ingreso",
            "T Egreso",
            "T Puntod",
            "Efectivo",
            "Deposito",
            "Aper Caja",
            "Total Caja",
            "Hora : Min : Seg",
            
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
    
    private Cierre cierre;
    
    
    public MapaCierres(Lista lista,boolean numerador) {
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
            setCierre((Cierre)lista.getObject(i));
            if(isNumerador())
            row.add(i+1);
            row.add(""+ getCierre().getDesde());
            row.add(""+ getCierre().getHasta());
            row.add(""+ getCierre().getTingreso());
            row.add(""+ getCierre().getTegresos());
            row.add(""+ getCierre().getTpuntos());
            row.add(""+ getCierre().getEfectivo());
            row.add(""+ getCierre().getDeposito());
            row.add(""+ getCierre().getAperturacaja());
            row.add(""+ getCierre().getTotalcaja());
            row.add(""+ getCierre().getHora()+" : "+getCierre().getMinutos()+" : "+getCierre().getSegundos());
          
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

   public Cierre getCierre() {
        return cierre;
    }

    public void setCierre(Cierre cierre) {
        this.cierre = cierre;
    }

    public void setDatos(Vector lista) {
    }
    
    
}
