/*
 * Pasajes.java
 *
 * Created on 23 de octubre de 2006, 10:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.PasajesHBM;
import java.util.List;
import java.util.Set;

public class Pasajes {
    
     private int id_Pasajes;
     private Date fechaLlegada;
     private String nombre;
     private Float neto;
     private Float valor;
     private Horario horario;
    
      
     private PasajesHBM base;
    
    public Pasajes() {
       setBase(new PasajesHBM());  
            }

    public int getId_Pasajes() {
        return id_Pasajes;
    }

    public void setId_Pasajes(int id_Pasajes) {
        this.id_Pasajes = id_Pasajes;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getNeto() {
        return neto;
    }

    public void setNeto(Float neto) {
        this.neto = neto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public PasajesHBM getBase() {
        return base;
    }

    public void setBase(PasajesHBM base) {
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
        return getBase().lista4(hora, anul);
   }
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
}
