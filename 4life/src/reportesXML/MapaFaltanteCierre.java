/*
 * MapaFaltanteCierre.java
 *
 * Created on 8 de marzo de 2007, 17:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

    import beans.CierreFaltante;
    import modelo.Fechas;
    import modelo.Lista;
    import reportesXML.ModeloMapa;
    import reportesXML.ModeloTabla;
    import java.util.Vector;
    
public class MapaFaltanteCierre extends ModeloTabla implements ModeloMapa{
   private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Fecha del Cierre Anterior",
            "Responsable",
            "Total",
            "Neto"
            
    };
    private boolean[] edit = new boolean[]{
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
            String.class
                                    
    };
    
    private CierreFaltante cierre;
    
    
    public MapaFaltanteCierre(Lista lista,boolean numerador) {
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
           setCierre((CierreFaltante)lista.getObject(i));
            if(isNumerador())
               row.add(i+1);
            row.add(""+ getCierre().getFecha());
            row.add(""+ getCierre().getCajera());
            row.add(""+ getCierre().getSaldo());
            row.add(""+ getCierre().getNota());
                      
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

    public CierreFaltante getCierre() {
        return cierre;
    }

    public void setCierre(CierreFaltante cierre) {
        this.cierre = cierre;
    }
}
