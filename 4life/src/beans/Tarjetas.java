/*
 * Tarjetas.java
 *
 * Created on 2 de abril de 2007, 14:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.TarjetasHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import Datos.TarjetasHBM;

public class Tarjetas {
    
     private int id_Tarjetas;
     private Date fecha;
     private String nombre;
     private int recibi;
     private int dejo;
     private int vendidos;
     private Horario horario;
    
     private TarjetasHBM base;
     
    public Tarjetas() {
        setBase(new TarjetasHBM()); 
    }

    public int getId_Tarjetas() {
        return id_Tarjetas;
    }

    public void setId_Tarjetas(int id_Tarjetas) {
        this.id_Tarjetas = id_Tarjetas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRecibi() {
        return recibi;
    }

    public void setRecibi(int recibi) {
        this.recibi = recibi;
    }

    public int getDejo() {
        return dejo;
    }

    public void setDejo(int dejo) {
        this.dejo = dejo;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public TarjetasHBM getBase() {
        return base;
    }

    public void setBase(TarjetasHBM base) {
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
   public Tarjetas Busca(String cod, Horario hora){
        return getBase().buscar(cod, hora);
    }
}
