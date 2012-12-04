/*
 * Billetes.java
 *
 * Created on 10 de enero de 2007, 03:04 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.BilletesHBM;
import java.util.List;
import java.util.Set;

public class Billetes {
    
    private int id_Billetes;
    private String cien;
    private String cincuenta;
    private String veinte;
    private String diez;
    private String cinco;
    private String uno;
    private String monedas;
    
    
    private String total;
    
    private Boolean cierre1;
    private Boolean adelanto;
    private Horario horario;
    
    private BilletesHBM base; 
    
    public Billetes() {
        setBase(new BilletesHBM()); 
    }

    public int getId_Billetes() {
        return id_Billetes;
    }

    public void setId_Billetes(int id_Billetes) {
        this.id_Billetes = id_Billetes;
    }

    

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Boolean getCierre1() {
        return cierre1;
    }

    public void setCierre1(Boolean cierre1) {
        this.cierre1 = cierre1;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public BilletesHBM getBase() {
        return base;
    }

    public void setBase(BilletesHBM base) {
        this.base = base;
    }

    public String getCien() {
        return cien;
    }

    public void setCien(String cien) {
        this.cien = cien;
    }

    public String getCincuenta() {
        return cincuenta;
    }

    public void setCincuenta(String cincuenta) {
        this.cincuenta = cincuenta;
    }

    public String getVeinte() {
        return veinte;
    }

    public void setVeinte(String veinte) {
        this.veinte = veinte;
    }

    public String getDiez() {
        return diez;
    }

    public void setDiez(String diez) {
        this.diez = diez;
    }

    public String getCinco() {
        return cinco;
    }

    public void setCinco(String cinco) {
        this.cinco = cinco;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
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
     public List lista(Horario hora, Boolean anul){
        return getBase().lista(hora, anul);
   }  
     
      public List lista3(Horario hora){
        return getBase().lista3(hora);
   }  
     public List lista9(Horario hora, Boolean anul, Boolean b){
        return getBase().lista9(hora, anul,b);
   }   
     
    public Billetes getBuscar(Horario hora, Boolean anul){
        return getBase().busca(hora, anul);        
    }

    public Boolean getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Boolean adelanto) {
        this.adelanto = adelanto;
    }
}
