/*
 * VideoConferencia.java
 *
 * Created on 22 de noviembre de 2006, 23:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.VideoConferenciaHBM;
import java.util.List;
import java.util.Set;

public class VideoConferencia {
    
     private int id_Video;
     private Date fechaLlegada;
     private int Numero;
     private String Nombre;
     private String Referencia;
     private Float Tiempo;
     private Float Total;
     private Horario horario;
     
     private VideoConferenciaHBM base;
     
    public VideoConferencia() {
        setBase(new VideoConferenciaHBM());  
    }

    

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public VideoConferenciaHBM getBase() {
        return base;
    }

    public void setBase(VideoConferenciaHBM base) {
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

    public int getId_Video() {
        return id_Video;
    }

    public void setId_Video(int id_Video) {
        this.id_Video = id_Video;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    

   

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public Float getTiempo() {
        return Tiempo;
    }

    public void setTiempo(Float Tiempo) {
        this.Tiempo = Tiempo;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }
    public List lista2(){
        return getBase().lista2();
   }  

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
    public List lista4(Date hora, Date anul){
        return getBase().lista4(hora,anul);
   } 
   
}
