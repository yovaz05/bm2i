/*
 * MapaBilletes.java
 *
 * Created on 10 de enero de 2007, 05:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

    import beans.Billetes;
    import modelo.Fechas;
    import modelo.Lista;
    import reportesXML.ModeloMapa;
    import reportesXML.ModeloTabla;
    import java.util.Vector;
    
public class MapaBilletes extends ModeloTabla implements ModeloMapa{
    
     private boolean numerador;
    
    private String[] nombre = new String[]{
            
            "Cien",
            "Cincuenta",
            "Veinte",
            "Diez",
            "Cinco",
            "Uno",
            "Monedas",
            "Total"
            
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
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private Billetes billetes;
    
    
    public MapaBilletes(Lista lista,boolean numerador) {
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
            setBilletes((Billetes)lista.getObject(i));
           // if(isNumerador())
             //   row.add(i+1);
            row.add(""+ getBilletes().getCien());
            row.add(""+ getBilletes().getCincuenta());
            row.add(""+ getBilletes().getVeinte());
            row.add(""+ getBilletes().getDiez());
            row.add(""+ getBilletes().getCinco());
            row.add(""+ getBilletes().getUno());
            row.add(""+ getBilletes().getMonedas());
            row.add(""+ getBilletes().getTotal());
            
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

    public Billetes getBilletes() {
        return billetes;
    }

    public void setBilletes(Billetes billetes) {
        this.billetes = billetes;
    }
    
    
    
}
