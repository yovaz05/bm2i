/*
 * ComprasOficina.java
 *
 * Created on 7 de noviembre de 2006, 14:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.ComprasOficinaHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComprasOficina {
    
     private int id_Compras;
     private Date fecha;
     private String descripcion;
     private Float valor;
     private Boolean gmt;
     private Horario horario;
     
     private ComprasOficinaHBM base;
     
    public ComprasOficina() {
        setBase(new ComprasOficinaHBM());   
    }

    public int getId_Compras() {
        return id_Compras;
    }

    public void setId_Compras(int id_Compras) {
        this.id_Compras = id_Compras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ComprasOficinaHBM getBase() {
        return base;
    }

    public void setBase(ComprasOficinaHBM base) {
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
  
 public List lista3(Horario horas, Boolean b){
        return getBase().lista3(horas, b);
   }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Boolean getGmt() {
        return gmt;
    }

    public void setGmt(Boolean gmt) {
        this.gmt = gmt;
    }
}
