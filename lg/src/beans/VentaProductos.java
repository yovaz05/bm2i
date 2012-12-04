/*
 * VentaProductos.java
 *
 * Created on 23 de octubre de 2006, 18:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.VentaProductosHBM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VentaProductos {
    
     private int id_Venta;
     private Date fechasalida;
     private String nombre;
     private String cedula;
     private Boolean pagado;
     private String contado;
     private String credito;
     private Float total;
     private Otros otros;
     private Usuario usuario;
     private Horario horario;
     
     private VentaProductosHBM base;
    public VentaProductos() {
       setBase(new VentaProductosHBM());    
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public VentaProductosHBM getBase() {
        return base;
    }

    public void setBase(VentaProductosHBM base) {
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

    public Otros getOtros() {
        return otros;
    }

    public void setOtros(Otros otros) {
        this.otros = otros;
    }
    public List lista(Otros otros){
        return getBase().lista(otros);
    } 

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
   public VentaProductos vendido(Otros otros, Horario hora){
        return getBase().vendido(otros,hora);
    } 
   public List lista2( Horario horas){
        return getBase().lista2(horas);
    } 
    public List lista4( Date hora, Date anul){
        return getBase().lista4(hora, anul);
    } 

   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public List lista3( String nom, Boolean bo){
        return getBase().lista3(nom, bo);
    } 
    public List lista5(Boolean bo, Horario hora){
        return getBase().lista5(bo, hora);
    } 
     public List lista4(String ced, Boolean bo){
        return getBase().lista4(ced, bo);
    } 
     
     public List lista4(int ced, Boolean bo){
        return getBase().lista4(ced, bo);
    } 
     
      public List lista7(Boolean bo){
        return getBase().lista7(bo);
    } 
       public List lista8(String ced, Horario hora){
        return getBase().lista8(ced,hora);
    }
    public VentaProductos habiliatr(Integer in){
        return getBase().habiliatr(in);
    }
    public List lista22(){
        return getBase().lista22();
    }
    public List lista(){
        return getBase().lista();
    }

    public String getContado() {
        return contado;
    }

    public void setContado(String contado) {
        this.contado = contado;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }
}
