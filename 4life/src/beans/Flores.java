/*
 * Flores.java
 *
 * Created on 23 de octubre de 2006, 03:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.FloresHBM;
import java.util.List;
import java.util.Set;

public class Flores {
    
     private int id_Flores;
     private Date fechaLlegada;
     private int factura;
     private String nombre;
     private String recibe;
     private Float total;
     private String descripcion;
     private String dedicatoria;
     private String pais;
     private String ciudad;
     private String telefono;
     private String direccion;
     
     
     
     
     private Horario horario;
    
    private FloresHBM base;
    public Flores() {
       setBase(new FloresHBM());   
    }

    public int getId_Flores() {
        return id_Flores;
    }

    public void setId_Flores(int id_Flores) {
        this.id_Flores = id_Flores;
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

    public String getRecibe() {
        return recibe;
    }

    public void setRecibe(String recibe) {
        this.recibe = recibe;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

   public FloresHBM getBase() {
        return base;
    }

    public void setBase(FloresHBM base) {
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

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

   public Flores Busca(String  clav){
        return getBase().busca(clav);
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
    
   public List lista4(Date hora, Date anul){
        return getBase().lista4(hora,anul);
   } 
    
   public List lista2(){
        return getBase().lista2();
   } 

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDedicatoria() {
        return dedicatoria;
    }

    public void setDedicatoria(String dedicatoria) {
        this.dedicatoria = dedicatoria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
