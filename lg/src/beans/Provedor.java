/*
 * Provedor.java
 *
 * Created on 11 de enero de 2007, 20:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.ProvedorHBM;
import java.util.List;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Provedor extends Persona{

private int Id_Provedor;
private String ruc;
private ProvedorHBM base;
    public Provedor() {
        setBase(new ProvedorHBM());
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

    public ProvedorHBM getBase() {
        return base;
    }

    public void setBase(ProvedorHBM base) {
        this.base = base;
    }
    public List lista(){
        return getBase().lista();
    }

    public int getId_Provedor() {
        return Id_Provedor;
    }

    public void setId_Provedor(int Id_Provedor) {
        this.Id_Provedor = Id_Provedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
