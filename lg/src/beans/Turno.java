/*
 * Turno.java
 *
 * Created on 19 de septiembre de 2006, 16:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.TurnoHBM;

/**
 *
 * @author ANtro
 */
public class Turno {
    
    private int id_Turno;
    private String actividad;
    private Agencia agencia;
    private Usuario usuario;
    
    private TurnoHBM base;
    
    public Turno() {
        setBase(new TurnoHBM());
    }

    public int getId_Turno() {
        return id_Turno;
    }

    public void setId_Turno(int id_Turno) {
        this.id_Turno = id_Turno;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TurnoHBM getBase() {
        return base;
    }

    public void setBase(TurnoHBM base) {
        this.base = base;
    }
    
    //nada despues de estos metodos
    
     public boolean guardar(){
        return getBase().guardar(this);
    }
    
    public boolean actualizar(){
        return getBase().actualizar(this);
    }
    
    public void borrar(){
        getBase().eliminar(this);
    }
}
