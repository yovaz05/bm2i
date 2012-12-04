/*
 * Paquete.java
 *
 * Created on 19 de septiembre de 2006, 16:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author ANtro
 */
public class Paquete {
    
    private int id_Paquete;
    private boolean porCobrar;
    private Agencia agencia;
    
    public Paquete() {
    }

    public int getId_Paquete() {
        return id_Paquete;
    }

    public void setId_Paquete(int id_Paquete) {
        this.id_Paquete = id_Paquete;
    }

    public boolean isPorCobrar() {
        return porCobrar;
    }

    public void setPorCobrar(boolean porCobrar) {
        this.porCobrar = porCobrar;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
}
