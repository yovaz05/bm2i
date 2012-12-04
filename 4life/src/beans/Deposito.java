/*
 * Deposito.java
 *
 * Created on 19 de septiembre de 2006, 16:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;

/**
 *
 * @author ANtro
 */
public class Deposito {
    
    private int id_Deposito;
    private Date fecha;
    private double efectivo;
    private double cheque;
    private Clientes cliente;
    
    public Deposito() {
    }

    public int getId_Deposito() {
        return id_Deposito;
    }

    public void setId_Deposito(int id_Deposito) {
        this.id_Deposito = id_Deposito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCheque() {
        return cheque;
    }

    public void setCheque(double cheque) {
        this.cheque = cheque;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
}
