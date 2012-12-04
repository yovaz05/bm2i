/*
 * MapaVC.java
 *
 * Created on 22 de noviembre de 2006, 23:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import beans.VideoConferencia;
import modelo.Fechas;
import modelo.Lista;
import reportesXML.ModeloMapa;
import reportesXML.ModeloTabla;
import java.util.Vector;

public class MapaVC extends ModeloTabla implements ModeloMapa{
    
    private boolean numerador;
    
    private String[] nombre = new String[]{
            "N",
            "Fecha",
            "N VC",
            "Nombre",
            "Referencia",
            "Tiempo",
            "Total",
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
            Integer.class,
            String.class,
            String.class,
            String.class,
            String.class,
            String.class
                                    
    };
    
    private VideoConferencia video;
    
    
    public MapaVC(Lista lista,boolean numerador) {
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
            setVideo((VideoConferencia)lista.getObject(i));
            if(isNumerador())
                row.add(i+1);
            row.add(""+ getVideo().getFechaLlegada());
            row.add(""+ getVideo().getNumero());
            row.add(""+ getVideo().getNombre());
            row.add(""+ getVideo().getReferencia());
            row.add(""+ getVideo().getTiempo());
            row.add(""+ getVideo().getTotal());
            row.add(""+ getVideo().getHorario().getUsuario().getNombre());
            
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

    public VideoConferencia getVideo() {
        return video;
    }

    public void setVideo(VideoConferencia video) {
        this.video = video;
    }

    public void setDatos(Vector lista) {
    }
    
}
