/*
 * anulargiro.java
 *
 * Created on 7 de marzo de 2007, 18:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.anulargiroHBM;
import java.util.List;
import java.util.Set;
public class anulargiro {
    
private int id_anulargiro;
private Horario horario;
private Giro giro;
private anulargiroHBM base;

    public anulargiro() {
     setBase(new anulargiroHBM());   
    }

   

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public anulargiroHBM getBase() {
        return base;
    }

    public void setBase(anulargiroHBM base) {
        this.base = base;
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

    public int getId_anulargiro() {
        return id_anulargiro;
    }

    public void setId_anulargiro(int id_anulargiro) {
        this.id_anulargiro = id_anulargiro;
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
 
}
