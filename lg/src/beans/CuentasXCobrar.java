/*
 * CuentasXCobrar.java
 *
 * Created on 6 de noviembre de 2006, 22:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.CuentasXCobrarHBM;
import java.util.List;
import java.util.Set;

public class CuentasXCobrar {
    
     private int id_CuentasXCobrar;
    
     private Date fecha;
     private Float cuota;
     private Float saldo;
     private Boolean giros;
     private CuentasXPagar cuentasXPagar;
     private Horario horario;
    
     private CuentasXCobrarHBM base;
     
    public CuentasXCobrar() {
        setBase(new CuentasXCobrarHBM());   
    }

    public int getId_CuentasXCobrar() {
        return id_CuentasXCobrar;
    }

    public void setId_CuentasXCobrar(int id_CuentasXCobrar) {
        this.id_CuentasXCobrar = id_CuentasXCobrar;
    }

   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public CuentasXCobrarHBM getBase() {
        return base;
    }

    public void setBase(CuentasXCobrarHBM base) {
        this.base = base;
    }
   public List lista3(Horario horas, Boolean gir){
        return getBase().lista3(horas, gir);
   }  
   
   public List lista4(Date hora, Date anul){
        return getBase().lista4(hora, anul);
   }
   public List lista5(Horario hora){
        return getBase().lista5(hora);
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

    public Float getCuota() {
        return cuota;
    }

    public void setCuota(Float cuota) {
        this.cuota = cuota;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public CuentasXPagar getCuentasXPagar() {
        return cuentasXPagar;
    }

    public void setCuentasXPagar(CuentasXPagar cuentasXPagar) {
        this.cuentasXPagar = cuentasXPagar;
    }

    public Boolean getGiros() {
        return giros;
    }

    public void setGiros(Boolean giros) {
        this.giros = giros;
    }

   
}
