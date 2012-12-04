/*
 * CuentasXPagar.java
 *
 * Created on 7 de noviembre de 2006, 1:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.CuentasXPagarHBM;
import java.util.List;
import java.util.Set;

public class CuentasXPagar {
     
     private int id_XPagar;
     private Date fechaLlegada;
     private String nombre;
     private Date fecha;
     private String envio;
     private Float total;
     private Float apagado;
     private String ordenar;
     private Boolean pagado;
     private Boolean giros;
     private Boolean mt;
     private Giro giro;
     private Horario horario;
     
     private CuentasXPagarHBM base;
     
    public CuentasXPagar() {
         setBase(new CuentasXPagarHBM());   
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

    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public CuentasXPagarHBM getBase() {
        return base;
    }

    public void setBase(CuentasXPagarHBM base) {
        this.base = base;
    }
    
    public List lista3(Horario horas, Boolean pagado){
        return getBase().lista3(horas, pagado);
   } 
    
   public List lista9(Horario horas, Boolean pagado){
        return getBase().lista9(horas, pagado);
   }
     public List lista6(Horario horas,Boolean giro){
        return getBase().lista6(horas,giro);
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

    public int getId_XPagar() {
        return id_XPagar;
    }

    public void setId_XPagar(int id_XPagar) {
        this.id_XPagar = id_XPagar;
    }

    public String getOrdenar() {
        return ordenar;
    }

    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }
   public CuentasXPagar Busca(String  clav){
        return getBase().busca(clav);
    }  
    public CuentasXPagar Busca2(String  clav){
        return getBase().busca2(clav);
    }  
   
   public List lista(String remp){
        return getBase().lista(remp);
    } 
    public List lista2(int remp){
        return getBase().lista2(remp);
    } 
     public List lista3(String remp){
        return getBase().lista3(remp);
    } 
 public List lista4(Date hora, Date anul){
        return getBase().lista4(hora, anul);
    } 
    public Float getApagado() {
        return apagado;
    }

    public void setApagado(Float apagado) {
        this.apagado = apagado;
    }

    public Boolean getGiros() {
        return giros;
    }

    public void setGiros(Boolean giros) {
        this.giros = giros;
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public Boolean getMt() {
        return mt;
    }

    public void setMt(Boolean mt) {
        this.mt = mt;
    }

}
