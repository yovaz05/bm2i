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
     private String concepto;
     private String numero;
     private String desde;
     private String hasta;
     private String neto;
     private String total;
     private Boolean ingreso;
     private Boolean cierre1;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getNeto() {
        return neto;
    }

    public void setNeto(String neto) {
        this.neto = neto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Boolean getIngreso() {
        return ingreso;
    }

    public void setIngreso(Boolean ingreso) {
        this.ingreso = ingreso;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Boolean getCierre1() {
        return cierre1;
    }

    public void setCierre1(Boolean cierre1) {
        this.cierre1 = cierre1;
    }
}
