/*
 * MapaDeudas.java
 *
 * Created on 12 de enero de 2007, 16:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

    import beans.Compras;
    import modelo.Fechas;
    import modelo.Lista;
    import reportesXML.ModeloMapa;
    import reportesXML.ModeloTabla;
    import java.util.Vector;
    
public class MapaDeudas extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Nombre",
            "Cantidad",
            "Valor",
            "Proveedor",
            "Total",
            
            
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
    
    private Compras compras;
    
    
    public MapaDeudas(Lista lista,boolean numerador) {
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
            setCompras((Compras)lista.getObject(i));
            if(isNumerador())
            row.add(i+1);
            row.add(""+ getCompras().getFecha());
            row.add(""+ getCompras().getOtros().getNombre());
            row.add(""+ getCompras().getUnidades());
            row.add(""+ getCompras().getProvedor().getNombre());
            
           
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

       public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }
    
}
