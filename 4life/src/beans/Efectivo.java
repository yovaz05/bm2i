/*
 * Efectivo.java
 *
 * Created on 29 de septiembre de 2006, 10:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.EfectivoHBM;


public class Efectivo {
    
    
    private int id_Efectivo;
    private Float monto;
    private EfectivoHBM base;    
    
    /** Creates a new instance of Efectivo */
    public Efectivo() {
       setBase(new EfectivoHBM());
    }

    public int getId_Efectivo() {
        return id_Efectivo;
    }

    public void setId_Efectivo(int id_Efectivo) {
        this.id_Efectivo = id_Efectivo;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public EfectivoHBM getBase() {
        return base;
    }

    public void setBase(EfectivoHBM base) {
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
       
    public Efectivo getUsu(String ced){
        return getBase().busca(ced);        
    }
    
}
