/*
 * Credito.java
 *
 * Created on 19 de septiembre de 2006, 16:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;

import java.util.Date;
import Datos.CreditoHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 


public class Credito {
   
    private int id_Credito;
    private Date fecha;
    private Float monto;
    private Horario horario;
    
    private CreditoHBM base;
    
    public Credito() {
        setBase(new CreditoHBM());   
    }

    public int getId_Credito() {
        return id_Credito;
    }

    public void setId_Credito(int id_Credito) {
        this.id_Credito = id_Credito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public CreditoHBM getBase() {
        return base;
    }

    public void setBase(CreditoHBM base) {
        this.base = base;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

  

   
}
