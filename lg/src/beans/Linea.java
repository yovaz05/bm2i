/*
 * Agencia.java
 *
 * Created on 19 de septiembre de 2006, 15:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

 import Datos.LineaHBM;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;       
        
public class Linea {
    
    private int id_Linea;
    private String nombre;
    private LineaHBM base;
    
    public Linea() {
        setBase(new LineaHBM());
    }

    public int getId_Linea() {
        return id_Linea;
    }

    public void setId_Linea(int id_Linea) {
        this.id_Linea = id_Linea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LineaHBM getBase() {
        return base;
    }

    public void setBase(LineaHBM base) {
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
    
   public Linea bus(String nom){
        return getBase().buscar(nom);
        }
  
   public Linea busCla(String nom){
        return getBase(). buscarCl(nom);
        }
}
