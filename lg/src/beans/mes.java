/*
 * mes.java
 *
 * Created on 8 de octubre de 2006, 03:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.MesHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mes {
    
    private int id_Codigo;
    private Float codigo;
 
    private MesHBM base;

    public mes() {
    setBase(new MesHBM());

    }

    public int getId_Codigo() {
        return id_Codigo;
    }

    public void setId_Codigo(int id_Codigo) {
        this.id_Codigo = id_Codigo;
    }

    public Float getCodigo() {
        return codigo;
    }

    public void setCodigo(Float codigo) {
        this.codigo = codigo;
    }

    

    public MesHBM getBase() {
        return base;
    }

    public void setBase(MesHBM base) {
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
  
    
     public List lista2(){
        return getBase().lista2();
    }
     
}
