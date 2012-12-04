/*
 * CierreFaltante.java
 *
 * Created on 8 de marzo de 2007, 15:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.CierreFaltanteHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

public class CierreFaltante {
 
private int id_CierreFaltante;
private Date fecha;
private Float saldo;
private Boolean gmt;
private Horario horario;
private String nota;
private String cajera;
private CierreFaltanteHBM base;

    public CierreFaltante() {
          setBase(new CierreFaltanteHBM());   
    }

    public int getId_CierreFaltante() {
        return id_CierreFaltante;
    }

    public void setId_CierreFaltante(int id_CierreFaltante) {
        this.id_CierreFaltante = id_CierreFaltante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Boolean getGmt() {
        return gmt;
    }

    public void setGmt(Boolean gmt) {
        this.gmt = gmt;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public CierreFaltanteHBM getBase() {
        return base;
    }

    public void setBase(CierreFaltanteHBM base) {
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getCajera() {
        return cajera;
    }

    public void setCajera(String cajera) {
        this.cajera = cajera;
    }
   
    public List lista3(Horario horas, Boolean b){
        return getBase().lista3(horas, b);
   } 
    
}
