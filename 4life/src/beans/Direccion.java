/*
 * Direccion.java
 *
 * Created on 19 de septiembre de 2006, 15:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.DireccionHBM;

/**
 *
 * @author ANtro
 */
public class Direccion {
    
    private int id_Direccion;
    private String pais;
    private String ciudad;
    private String provincia;
    private String callePrincipal;
    private String calleSecundaria;
    private String numeroCasa;
    private String numroTelefono;
    private String numroCelular;
    private String email;   
    private DireccionHBM base;
    
    
    public Direccion() {
        setBase(new DireccionHBM());
    }

    public int getId_Direccion() {
        return id_Direccion;
    }

    public void setId_Direccion(int id_Direccion) {
        this.id_Direccion = id_Direccion;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getNumroTelefono() {
        return numroTelefono;
    }

    public void setNumroTelefono(String numroTelefono) {
        this.numroTelefono = numroTelefono;
    }

    public String getNumroCelular() {
        return numroCelular;
    }

    public void setNumroCelular(String numroCelular) {
        this.numroCelular = numroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DireccionHBM getBase() {
        return base;
    }

    public void setBase(DireccionHBM base) {
        this.base = base;
    }
   
    
    // no poner nada despues de los metodos siguientes
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
