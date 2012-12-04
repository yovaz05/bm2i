/*
 * PagoT.java
 *
 * Created on 7 de noviembre de 2006, 19:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.PagoTHBM;
import java.util.List;
import java.util.Set;

public class PagoT {
    
     private int id_PagoT;
     private Date fechaLlegada;
     private String vendedor;
     private Date fecha;
     private String factura;
     private Float valorneto;
     private Float valorpagar;
     private Horario horario;
    
     private PagoTHBM base;
     
    public PagoT() {
        setBase(new PagoTHBM());   
    }

    public int getId_PagoT() {
        return id_PagoT;
    }

    public void setId_PagoT(int id_PagoT) {
        this.id_PagoT = id_PagoT;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Float getValorneto() {
        return valorneto;
    }

    public void setValorneto(Float valorneto) {
        this.valorneto = valorneto;
    }

    public Float getValorpagar() {
        return valorpagar;
    }

    public void setValorpagar(Float valorpagar) {
        this.valorpagar = valorpagar;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public PagoTHBM getBase() {
        return base;
    }

    public void setBase(PagoTHBM base) {
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
}
