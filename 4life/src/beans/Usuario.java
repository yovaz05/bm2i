/*
 * Usuario.java
 *
 * Created on 9 de junio de 2006, 07:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.OtrosHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

import Datos.UsuarioHBM;

/**
 *
 * 
 */
public class Usuario extends Persona {
    
    private int idUsuario;    
    private String loguin;
    private String password;
    private String cargo;
    private String acceso;
    private String fechaIng;
    private Horario horario;
    
    private int tipo;
    private UsuarioHBM base;
    
    public Usuario() {
        setBase(new UsuarioHBM());
    }

   

    public String getLoguin() {
        return loguin;
    }

    public void setLoguin(String loguin) {
        this.loguin = loguin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(String fechaIng) {
        this.fechaIng = fechaIng;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public UsuarioHBM getBase() {
        return base;
    }

    public void setBase(UsuarioHBM base) {
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
       
   
    
    public String  buscar(){
        String val="";
        Usuario usu=getBase().getuser(loguin,password);
        if(usu!=null){
            val="si";
        }else{
            val="no";
        }
        return val;
    } 

     public Usuario bus(String nom, String cla){
        return getBase().buscar(nom,cla);
        }
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
 public void eliminar(){
        getBase().eliminar(this);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

     public List lista(){
        return getBase().lista();
    } 
    
}
