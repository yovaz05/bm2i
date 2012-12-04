/*
 * Remplazo.java
 *
 * Created on 17 de octubre de 2006, 06:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.RemplazoHBM;
import java.util.List;
import java.util.Set;

public class Remplazo {
    
    private int id_Remplazo;
    private Giro giro;
    private Giro giroviejo;
    private Horario horario;
    private RemplazoHBM base;
    
      
    
    public Remplazo() {
        setBase(new RemplazoHBM());
    }

    public int getId_Remplazo() {
        return id_Remplazo;
    }

    public void setId_Remplazo(int id_Remplazo) {
        this.id_Remplazo = id_Remplazo;
    }

    public RemplazoHBM getBase() {
        return base;
    }

    public void setBase(RemplazoHBM base) {
        this.base = base;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

  
     public boolean guardar(){
        return getBase().guardar(this);
    }
    
    public boolean actualizar(){
        return getBase().actualizar(this);
    }
    
    public void borrar(){
        getBase().eliminar(this);
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }
      public List lista2(Horario o){
        return getBase().lista2(o);
   }

    public Giro getGiroviejo() {
        return giroviejo;
    }

    public void setGiroviejo(Giro giroviejo) {
        this.giroviejo = giroviejo;
    }
}
