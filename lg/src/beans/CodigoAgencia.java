/*
 * CodigoAgencia.java
 *
 * Created on 20 de octubre de 2006, 04:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.CodigoAgenciaHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodigoAgencia {
    
    private int id_Codigo;
    private Float codigo;
    private Agencia agencia;
    private CodigoAgenciaHBM base;
    
    
    
    
    
    public CodigoAgencia() {
   setBase(new CodigoAgenciaHBM());

    }

    public int getId_Codigo() {
        return id_Codigo;
    }

    public void setId_Codigo(int id_Codigo) {
        this.id_Codigo = id_Codigo;
    }

   

   

    public CodigoAgenciaHBM getBase() {
        return base;
    }

    public void setBase(CodigoAgenciaHBM base) {
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

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public List lista(Agencia age){
        return getBase().lista(age);
    }
    
     public List lista2(){
        return getBase().lista2();
    }

    public Float getCodigo() {
        return codigo;
    }

    public void setCodigo(Float codigo) {
        this.codigo = codigo;
    }
    
     public CodigoAgencia busca(Agencia cod){
        return getBase().busca(cod);
    }
    
    
}
