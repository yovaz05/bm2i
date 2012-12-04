
package beans;

import java.util.Date;
import Datos.ComprasHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

public class Compras {
    
     private int id_Compras;
     private Date fecha;
     private int unidades;
     private String nfactura;
     private Provedor provedor;
     private Otros otros;
     private Horario horario;
     private ComprasHBM base;
     
    public Compras() {
        setBase(new ComprasHBM());
     }

    public int getId_Compras() {
        return id_Compras;
    }

    public void setId_Compras(int id_Compras) {
        this.id_Compras = id_Compras;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

  

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public ComprasHBM getBase() {
        return base;
    }

    public void setBase(ComprasHBM base) {
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



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public Otros getOtros() {
        return otros;
    }

    public void setOtros(Otros otros) {
        this.otros = otros;
    }

 public List lista2(Boolean anul){
        return getBase().lista2(anul);
}
public List lista1(Horario anul){
        return getBase().lista1(anul);
}
  
public List lista12(Provedor anul){
        return getBase().lista12(anul);
}

    /**
     * @return the nfactura
     */
    public String getNfactura() {
        return nfactura;
    }

    /**
     * @param nfactura the nfactura to set
     */
    public void setNfactura(String nfactura) {
        this.nfactura = nfactura;
    }

    /**
     * @return the nfactura
     */
    
   
    
  }
