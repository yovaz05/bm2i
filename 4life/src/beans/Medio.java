/*
 * Medio.java
 *
 * Created on 19 de septiembre de 2006, 16:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author ANtro
 */
public class Medio extends Agencia{
    
    private int id_Medio;
    private String codigo;
   
    public Medio() {
    } 

    public int getId_Medio() {
        return id_Medio;
    }

    public void setId_Medio(int id_Medio) {
        this.id_Medio = id_Medio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
  
    
}
