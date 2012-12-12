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
     private String nfactura;
     private int cantidad;
     private Float costo;
     private Float vuproducto;
     private Float vupuntos;
     private Float utilidad;
     private Float totalproducto;
     private int totalpuntos;
     private Otros otros;
     private Usuario usuario;
     private Horario horario;
     private Cliente cliente;
     private Factura factura;
     
     
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
       
     public List lista9(String nfac, Horario hora){
        return getBase().lista9(nfac,hora);
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

       /**
     * @return the nfactura
     */
    public String getNfactura() {
        return nfactura;
    }

    /**
     * @param nfactura the nfactura to set
     */
    public void setNfactura(String nfactura) {
        this.nfactura = nfactura;
    }

    /**
     * @return the totalproducto
     */
    public Float getTotalproducto() {
        return totalproducto;
    }

    /**
     * @param totalproducto the totalproducto to set
     */
    public void setTotalproducto(Float totalproducto) {
        this.totalproducto = totalproducto;
    }

    /**
     * @return the vuproducto
     */
    public Float getVuproducto() {
        return vuproducto;
    }

    /**
     * @param vuproducto the vuproducto to set
     */
    public void setVuproducto(Float vuproducto) {
        this.vuproducto = vuproducto;
    }

    /**
     * @return the totalpuntos
     */
      /**
     * @return the vupuntos
     */
    public Float getVupuntos() {
        return vupuntos;
    }

    /**
     * @param vupuntos the vupuntos to set
     */
    public void setVupuntos(Float vupuntos) {
        this.vupuntos = vupuntos;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * @return the totalpuntos
     */
    public int getTotalpuntos() {
        return totalpuntos;
    }

    /**
     * @param totalpuntos the totalpuntos to set
     */
    public void setTotalpuntos(int totalpuntos) {
        this.totalpuntos = totalpuntos;
    }

   
}
