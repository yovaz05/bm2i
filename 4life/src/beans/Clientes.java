/*
 * Clientes.java
 *
 * Created on 9 de junio de 2006, 07:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.ClientesHBM;

/**
 *
 * @author Richard
 */
public class Clientes extends Persona{
    
    private int idCliente;
    private String tipo;
    private String fechaingreso;
    private String profesion;
    private String sexo;
    private String fonoOficina;
                
    private ClientesHBM base;
    
    public Clientes() {
         setBase(new ClientesHBM ());
    
    }        

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public ClientesHBM getBase() {
        return base;
    }

    public void setBase(ClientesHBM base) {
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
       
    public Clientes getUsu(String ced){
        return getBase().busca(ced);        
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFonoOficina() {
        return fonoOficina;
    }

    public void setFonoOficina(String fonoOficina) {
        this.fonoOficina = fonoOficina;
    }

    
}
