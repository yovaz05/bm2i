/*
 * Cabinas.java
 *
 * Created on 8 de noviembre de 2006, 23:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.CabinasHBM;
import java.util.List;
import java.util.Set;

public class Cabinas {
    
     private int id_Cabinas;
     private Date fechaLlegada;
     private String Pais;
     private String Ciudad;
     private String minutos;
     private Float valor;
     private Horario horario;
     
     private CabinasHBM base;
     
    public Cabinas() {
        setBase(new CabinasHBM()); 
        
    }

    public int getId_Cabinas() {
        return id_Cabinas;
    }

    public void setId_Cabinas(int id_Cabinas) {
        this.id_Cabinas = id_Cabinas;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public CabinasHBM getBase() {
        return base;
    }

    public void setBase(CabinasHBM base) {
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

    public List lista3(Horario horas){
        return getBase().lista3(horas);
   } 
      public List lista4(Date hora, Date anul){
        return getBase().lista4(hora,anul);
   } 
}
