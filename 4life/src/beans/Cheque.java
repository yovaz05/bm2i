/*
 * Cheque.java
 *
 * Created on 29 de septiembre de 2006, 9:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.ChequesHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

public class Cheque {
   
    private int id_Cheque;
    private Boolean protestado;
    private Date fecha;
    private String Nombre;
    private Float neto;
    private Float total;
    private String numero;
    private Float utilidad;
    private Float utilidadche;
    private String clave;
    private Float protesto; 
    private Boolean lgtrasmiter;
    private Boolean adelanto;
    private ChequesHBM base;
    private Horario horario;
    private Giro giro;
    
  
    public Cheque() {
         setBase(new ChequesHBM());
    }

    public int getId_Cheque() {
        return id_Cheque;
    }

    public void setId_Cheque(int id_Cheque) {
        this.id_Cheque = id_Cheque;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   public Float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Float utilidad) {
        this.utilidad = utilidad;
    }

    public ChequesHBM getBase() {
        return base;
    }

    public void setBase(ChequesHBM base) {
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
       
    public Cheque getUsu(String ced){
        return getBase().busca(ced);        
    }

    public Boolean getProtestado() {
        return protestado;
    }

    public void setProtestado(Boolean protestado) {
        this.protestado = protestado;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
  public List lista3(Horario horas){
        return getBase().lista3(horas);
   }  
  
   public List lista4(Horario horas, Boolean b, Boolean cierre){
        return getBase().lista4(horas, b, cierre);
   } 
   
   public List lista11(Horario horas, Boolean b){
        return getBase().lista11(horas, b);
   } 
    public List lista7(Horario horas, Boolean b){
        return getBase().lista7(horas, b);
   } 
    
     public List lista8(Horario horas, Boolean b){
        return getBase().lista8(horas, b);
   } 
   
    public List lista5(Date hora, Date anul){
        return getBase().lista5(hora, anul);
   } 
   public List lista9(Date hora, Date anul, Boolean b){
        return getBase().lista9(hora, anul, b);
   } 
    
   public List lista6(Date hora, Date anul, Boolean b){
        return getBase().lista6(hora, anul, b);
   } 
    public Cheque Busca2(String che){
        return getBase().busca2(che);
   }  

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getNeto() {
        return neto;
    }

    public void setNeto(Float neto) {
        this.neto = neto;
    }

    public Giro getGiro() {
        return giro;
    }

    public void setGiro(Giro giro) {
        this.giro = giro;
    }

    public Float getUtilidadche() {
        return utilidadche;
    }

    public void setUtilidadche(Float utilidadche) {
        this.utilidadche = utilidadche;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Float getProtesto() {
        return protesto;
    }

    public void setProtesto(Float protesto) {
        this.protesto = protesto;
    }

    public Boolean getLgtrasmiter() {
        return lgtrasmiter;
    }

    public void setLgtrasmiter(Boolean lgtrasmiter) {
        this.lgtrasmiter = lgtrasmiter;
    }

    public Boolean getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Boolean adelanto) {
        this.adelanto = adelanto;
    }

   
}
