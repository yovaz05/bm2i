/*
 * Agencia.java
 *
 * Created on 19 de septiembre de 2006, 15:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package beans;

import Datos.FacturaHBM;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Factura {

    private int id_Factura;
    private String numero;
    private Date fecha;
    private Float vtotal;
    private int vpuntos;
    private String tpago;
    private Float utilidad;
    private Horario horario;
    private Cliente cliente;
    private Boolean cerrada;
    
    private FacturaHBM base;

    public Factura() {
        setBase(new FacturaHBM());
    }

    
  
    public FacturaHBM getBase() {
        return base;
    }

    public void setBase(FacturaHBM base) {
        this.base = base;
    }

    public boolean guardar() {
        return getBase().guardar(this);
    }

    public boolean actualizar() {
        return getBase().actualizar(this);
    }

    public void borrar() {
        getBase().eliminar(this);
    }

    public Float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Float utilidad) {
        this.utilidad = utilidad;
    }

    public List lista() {
        return getBase().lista();
    }

    public Factura Busca(String cod) {
        return getBase().buscar(cod);
    }

    public Factura bus(String nom) {
        return getBase().buscar(nom);
    }

    public Factura busCla(String nom) {
        return getBase().buscarCl(nom);
    }

    /**
     * @return the id_Factura
     */
    public int getId_Factura() {
        return id_Factura;
    }

    /**
     * @param id_Factura the id_Factura to set
     */
    public void setId_Factura(int id_Factura) {
        this.id_Factura = id_Factura;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the vtotal
     */
    public Float getVtotal() {
        return vtotal;
    }

    /**
     * @param vtotal the vtotal to set
     */
    public void setVtotal(Float vtotal) {
        this.vtotal = vtotal;
    }

    /**
     * @return the vpuntos
     */
    public int getVpuntos() {
        return vpuntos;
    }

    /**
     * @param vpuntos the vpuntos to set
     */
    public void setVpuntos(int vpuntos) {
        this.vpuntos = vpuntos;
    }

    /**
     * @return the tpago
     */
    public String getTpago() {
        return tpago;
    }

    /**
     * @param tpago the tpago to set
     */
    public void setTpago(String tpago) {
        this.tpago = tpago;
    }

    /**
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
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
     * @return the cerrada
     */
    public Boolean getCerrada() {
        return cerrada;
    }

    /**
     * @param cerrada the cerrada to set
     */
    public void setCerrada(Boolean cerrada) {
        this.cerrada = cerrada;
    }
     public List lista2( Horario horas){
        return getBase().lista2(horas);
    } 
     
     public List listarFecha(Date desde, Date hasta){
         return getBase().listarFecha(desde, hasta);
     }
}
