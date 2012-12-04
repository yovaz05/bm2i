/*
 * MapaFinTurno.java
 *
 * Created on 4 de febrero de 2007, 7:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

    import beans.Horario;
    import modelo.Fechas;
    import modelo.Lista;
    import reportesXML.ModeloMapa;
    import reportesXML.ModeloTabla;
    import java.util.Vector;
    
public class MapaFinTurno extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            
            "Hora de Entrada",
            "Hora de Salida",
            "Horas trabajadas",
            "Minutos Trabajados",
            "Segundos Trabajados",
            "Ingresos LGMT",
            "Egresos LGMT",
            "Deposito LGMT",
            "Faltante LGMT",
            "Ingresos LG",
            "Egresos LG",
            "Deposito LG",
            "Faltante LG"
           
            
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
            String.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private Horario horas;
    
    
    public MapaFinTurno(Lista lista,boolean numerador) {
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
            setHoras((Horario)lista.getObject(i));
           // if(isNumerador())
             //   row.add(i+1);
            row.add(""+ getHoras().getFechaInicio());
            row.add(""+ getHoras().getFechaFin());
            row.add(""+ getHoras().getHoras());
            row.add(""+ getHoras().getMinutos());
            row.add(""+ getHoras().getSegundos());
            row.add(""+ getHoras().getIngresoT());
            row.add(""+ getHoras().getEgresoT());
            row.add(""+ getHoras().getDepoT());
            row.add(""+ getHoras().getFaltaT());
            row.add(""+ getHoras().getIngresoL());
            row.add(""+ getHoras().getEgresoL());
            row.add(""+ getHoras().getDepoL());
            row.add(""+ getHoras().getFaltaL());
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

       public Horario getHoras() {
        return horas;
    }

    public void setHoras(Horario horas) {
        this.horas = horas;
    }
    
}
