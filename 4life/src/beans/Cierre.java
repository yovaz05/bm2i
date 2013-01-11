/*
 * Cierre.java
 *
 * Created on 7 de noviembre de 2006, 20:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.CierreHBM;
import java.util.List;
import java.util.Set;


public class Cierre {
     
     private int id_Cierre;
     private Date desde;
     private Date hasta;
     private Float tingreso;
     private Float uproducto;
     private int tpuntos;
     private Float tegresos;
     private Float efectivo;
     private Float deposito;
     private int hora;
     private int minutos;
     private int segundos;
     private Float aperturacaja;
     private Float totalcaja;
     private Horario horario;
    
     private CierreHBM base;
     
    public Cierre() {
        setBase(new CierreHBM());   
    }

    public int getId_Cierre() {
        return id_Cierre;
    }

    public void setId_Cierre(int id_Cierre) {
        this.id_Cierre = id_Cierre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public CierreHBM getBase() {
        return base;
    }

    public void setBase(CierreHBM base) {
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
      
    public List lista(Horario horas, Boolean egre, Boolean cierr1){
        return getBase().lista(horas, egre, cierr1);
   }
    public List lista2(Horario horas, Boolean cierr1){
        return getBase().lista2(horas, cierr1);
   }

    /**
     * @return the desde
     */
    public Date getDesde() {
        return desde;
    }

    /**
     * @param desde the desde to set
     */
    public void setDesde(Date desde) {
        this.desde = desde;
    }

    /**
     * @return the hasta
     */
    public Date getHasta() {
        return hasta;
    }

    /**
     * @param hasta the hasta to set
     */
    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    /**
     * @return the tingreso
     */
    public Float getTingreso() {
        return tingreso;
    }

    /**
     * @param tingreso the tingreso to set
     */
    public void setTingreso(Float tingreso) {
        this.tingreso = tingreso;
    }

    /**
     * @return the uproducto
     */
    public Float getUproducto() {
        return uproducto;
    }

    /**
     * @param uproducto the uproducto to set
     */
    public void setUproducto(Float uproducto) {
        this.uproducto = uproducto;
    }

    /**
     * @return the tpuntos
     */
    public int getTpuntos() {
        return tpuntos;
    }

    /**
     * @param tpuntos the tpuntos to set
     */
    public void setTpuntos(int tpuntos) {
        this.tpuntos = tpuntos;
    }

    /**
     * @return the tegresos
     */
    public Float getTegresos() {
        return tegresos;
    }

    /**
     * @param tegresos the tegresos to set
     */
    public void setTegresos(Float tegresos) {
        this.tegresos = tegresos;
    }

    /**
     * @return the efectivo
     */
    public Float getEfectivo() {
        return efectivo;
    }

    /**
     * @param efectivo the efectivo to set
     */
    public void setEfectivo(Float efectivo) {
        this.efectivo = efectivo;
    }

    /**
     * @return the deposito
     */
    public Float getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(Float deposito) {
        this.deposito = deposito;
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    /**
     * @return the aperturacaja
     */
    public Float getAperturacaja() {
        return aperturacaja;
    }

    /**
     * @param aperturacaja the aperturacaja to set
     */
    public void setAperturacaja(Float aperturacaja) {
        this.aperturacaja = aperturacaja;
    }

    /**
     * @return the totalcaja
     */
    public Float getTotalcaja() {
        return totalcaja;
    }

    /**
     * @param totalcaja the totalcaja to set
     */
    public void setTotalcaja(Float totalcaja) {
        this.totalcaja = totalcaja;
    }
    public List listarFecha(Date desde, Date hasta){
         return getBase().listarFecha(desde, hasta);
     }

    }
