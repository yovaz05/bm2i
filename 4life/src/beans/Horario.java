/*
 * Horario.java
 *
 * Created on 19 de septiembre de 2006, 16:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.HorarioHBM;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ANtro
 */
public class Horario {
    
    private int id_Horario;
    private Date fechaInicio;
    private Date fechaFin;
    private Float ingresoT;
    private Float egresoT;
    private Float ingresoL;
    private Float egresoL;
    private Float faltaT;
    private Float faltaL;
    
    private Float depoT;
    private Float depoL;
    
    private Boolean secion;
    private int horas;
    private int minutos;
    private int segundos;
    private Float Adelanto;
    
    private Usuario usuario;
   
    private HorarioHBM base;
    public Horario() {
        setBase(new HorarioHBM());
    }

    public int getId_Horario() {
        return id_Horario;
    }

    public void setId_Horario(int id_Horario) {
        this.id_Horario = id_Horario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     public Horario bus(Usuario nom, Boolean sec){
        return getBase().busca(nom, sec);
          }
     
    public Horario buscar(Boolean nom){
        return getBase().buscar(nom);
          }

     public Horario bus(Horario nom){
        return getBase().bus(nom);
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

    public HorarioHBM getBase() {
        return base;
    }

    public void setBase(HorarioHBM base) {
        this.base = base;
    }
     public Horario getVer(Usuario id){
        return (Horario)base.getVer(id);
    }

    public Boolean getSecion() {
        return secion;
    }

    public void setSecion(Boolean secion) {
        this.secion = secion;
    }

    public Float getIngresoT() {
        return ingresoT;
    }

    public void setIngresoT(Float ingresoT) {
        this.ingresoT = ingresoT;
    }

    public Float getEgresoT() {
        return egresoT;
    }

    public void setEgresoT(Float egresoT) {
        this.egresoT = egresoT;
    }

    public Float getIngresoL() {
        return ingresoL;
    }

    public void setIngresoL(Float ingresoL) {
        this.ingresoL = ingresoL;
    }

    public Float getEgresoL() {
        return egresoL;
    }

    public void setEgresoL(Float egresoL) {
        this.egresoL = egresoL;
    }

    public Float getFaltaT() {
        return faltaT;
    }

    public void setFaltaT(Float faltaT) {
        this.faltaT = faltaT;
    }

    public Float getFaltaL() {
        return faltaL;
    }

    public void setFaltaL(Float faltaL) {
        this.faltaL = faltaL;
    }
 public List lista2(Boolean se){
        return getBase().lista2(se);
   }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public Float getAdelanto() {
        return Adelanto;
    }

    public void setAdelanto(Float Adelanto) {
        this.Adelanto = Adelanto;
    }

    public Float getDepoT() {
        return depoT;
    }

    public void setDepoT(Float depoT) {
        this.depoT = depoT;
    }

    public Float getDepoL() {
        return depoL;
    }

    public void setDepoL(Float depoL) {
        this.depoL = depoL;
    }
    public List lista4(Date hora, Date anul, Usuario b){
        return getBase().lista4(hora, anul, b);
   } 
       
}
