/*
 * Otros.java
 *
 * Created on 23 de octubre de 2006, 17:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.OtrosHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import beans.Linea;

public class Otros {
    
     private int id_Otros;
     private Date fechaLlegada;
     private int stock;
     private String nombre;
     private Float vunitario;
     private Float vunitario2;
     private Float utilidad;
     private int eminima;
     private int emaxima;
     private String unidad;
     private int puntos;
     private Float costo;

     private int total;

     private Horario horario;
     private Linea linea;
    
     private OtrosHBM base;
    
    public Otros() {
        setBase(new OtrosHBM());   
    }

    public int getId_Otros() {
        return id_Otros;
    }

    public void setId_Otros(int id_Otros) {
        this.id_Otros = id_Otros;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getVunitario() {
        return vunitario;
    }

    public void setVunitario(Float vunitario) {
        this.vunitario = vunitario;
    }

   public OtrosHBM getBase() {
        return base;
    }

    public void setBase(OtrosHBM base) {
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
     public List lista(){
        return getBase().lista();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
  public List lista3(Horario horas){
        return getBase().lista3(horas);
   } 
   public List lista2(Linea reg){
        return getBase().lista2(reg);
   }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the vunitario2
     */
    public Float getVunitario2() {
        return vunitario2;
    }

    /**
     * @param vunitario2 the vunitario2 to set
     */
    public void setVunitario2(Float vunitario2) {
        this.vunitario2 = vunitario2;
    }

    /**
     * @return the eminima
     */
    public int getEminima() {
        return eminima;
    }

    /**
     * @param eminima the eminima to set
     */
    public void setEminima(int eminima) {
        this.eminima = eminima;
    }

    /**
     * @return the emaxima
     */
    public int getEmaxima() {
        return emaxima;
    }

    /**
     * @param emaxima the emaxima to set
     */
    public void setEmaxima(int emaxima) {
        this.emaxima = emaxima;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * @return the costo
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * @return the linea
     */
    public Linea getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Linea linea) {
        this.linea = linea;
    }
 public List listarFecha(Date desde, Date hasta){
         return getBase().listarFecha(desde, hasta);
     }

    /**
     * @return the utilidad
     */
    public Float getUtilidad() {
        return utilidad;
    }

    /**
     * @param utilidad the utilidad to set
     */
    public void setUtilidad(Float utilidad) {
        this.utilidad = utilidad;
    }

}
