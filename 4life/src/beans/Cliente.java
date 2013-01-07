/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Datos.ClienteHBM;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author richard
 */
public class Cliente extends Persona{

    private int id_Cliente;
    private String codigocliente;
    private String celular;
    private String email;
    private ClienteHBM base;
    
    public Cliente() {
        setBase(new ClienteHBM());
    }

    /**
     * @return the id_Cliente
     */
    public int getId_Cliente() {
        return id_Cliente;
    }

    /**
     * @param id_Cliente the id_Cliente to set
     */
    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    /**
     * @return the codigocliente
     */
    public String getCodigocliente() {
        return codigocliente;
    }

    /**
     * @param codigocliente the codigocliente to set
     */
    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the base
     */
    public ClienteHBM getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(ClienteHBM base) {
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
     public List lista(){
        return getBase().lista();
    }
     
     
     
    public Cliente buscarCodigo(String codigo) {
        return getBase().buscarCodigoCliente(codigo);
    }

    public Cliente buscarCedula(String cedula) {
        return getBase().buscaCedula(cedula);
    }
      public List<Cliente> buscarNombres(String nombre) {
        return getBase().buscarNombres(nombre);
    }
  }
