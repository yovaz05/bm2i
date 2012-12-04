/*
 * Destino.java
 *
 * Created on 19 de septiembre de 2006, 16:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import Datos.DestinoHBM;
/*import java.util.Date;*
 *
 * @author ANtro
 */
public class Destino {
    
    private int id_Destino;
    private Clientes cliente;
    private Direccion direccion;
    private DestinoHBM base;
    
       
    public Destino() {
        setBase(new DestinoHBM ());
    }

    public int getId_Destino() {
        return id_Destino;
    }

    public void setId_Destino(int id_Destino) {
        this.id_Destino = id_Destino;
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
       
    public Destino getUsu(String ced){
        return getBase().busca(ced);        
    }

    public DestinoHBM getBase() {
        return base;
    }

    public void setBase(DestinoHBM base) {
        this.base = base;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
}
