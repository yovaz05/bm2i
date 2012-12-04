/*
 * Giro.java
 *
 * Created on 19 de septiembre de 2006, 16:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package beans;

import java.util.Date;
import Datos.GiroHBM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Giro {
    
    private int id_Giro;
    private Boolean estado;
    private Date fechaLlegada;
    private Float neto;
    private String nombre;
    private String referencia;
    private Boolean anulado;
    private Boolean rem;
    private String codigo;
    private String clave;
    private Float total;
    private Agencia agencia;  
    private Horario horario;
    private Remplazo remplazo;
    private Boolean pagado;
    private GiroHBM base;
    private Cheque cheque;
    private anulargiro anulargiro;
    private CuentasXPagar credito;
    
    public Giro() {
        setBase(new GiroHBM());
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
       
    public Giro getUsu(String ced){
        return getBase().busca(ced);        
    }

    public int getId_Giro() {
        return id_Giro;
    }

    public void setId_Giro(int id_Giro) {
        this.id_Giro = id_Giro;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Float getNeto() {
        return neto;
    }

    public void setNeto(Float neto) {
        this.neto = neto;
    }

    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public GiroHBM getBase() {
        return base;
    }

    public void setBase(GiroHBM base) {
        this.base = base;
    }

   
    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
 
    public String getNombre() {
        return nombre;
    }

 public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 public Horario getHorario() {
        return horario;
    }

 public void setHorario(Horario horario) {
        this.horario = horario;
    }

 public List lista2(Agencia age, Horario horas){
        return getBase().lista2(age,horas);
    } 
 
  public List lista8(Horario horas, Boolean anu, Agencia age){
        return getBase().lista8(horas, anu, age);
    } 
  
   public List lista19(Horario horas,Agencia age){
        return getBase().lista19(horas, age);
    } 
   
  public List lista18(Horario horas, Boolean anu){
        return getBase().lista18(horas, anu);
    }
    
  public List lista9(Horario horas, Boolean anu){
        return getBase().lista9(horas, anu);
    }
  
   public List lista10(Agencia age, Horario horas, Boolean anu){
        return getBase().lista10(age, horas, anu);
    }
  
  public List lista11(Horario horas, Boolean anu){
        return getBase().lista11(horas, anu);
    }  
  
   public List lista12(Date hora, Date anul, Agencia age){
        return getBase().lista12(hora, anul, age);
    }  
   public List lista20(Date hora, Date anul, Agencia age){
        return getBase().lista20(hora, anul, age);
    }
 public List lista13(Date hora, Date anul, Agencia age, Boolean re){
        return getBase().lista13(hora, anul, age, re);
    }  
public List lista14(Date hora, Date anul, Agencia age, Boolean re){
        return getBase().lista14(hora, anul, age, re);
    }  

public List lista15(Date hora, Date anul, Agencia age, Boolean re){
        return getBase().lista15(hora, anul, age, re);
    } 
public List lista16(Date hora, Date anul,  Boolean re){
        return getBase().lista16(hora, anul, re);
    } 

public List lista17(Boolean anul, Agencia age){
        return getBase().lista17(anul, age);
    } 
 
  public List lista3(Horario horas){
        return getBase().lista3(horas);
   } 
  public Giro Busca(String  clav){
        return getBase().busca(clav);
    } 
  public Giro Busca2(String  clav){
        return getBase().busca2(clav);
    } 
    
  public List lista4(Boolean remp){
        return getBase().lista4(remp);
    } 
   
   public List lista27(Agencia age){
        return getBase().lista27(age);
    } 
  
  
  public List lista5(Boolean anul){
        return getBase().lista5(anul);
    }
  public List lista6(Boolean pag){
        return getBase().lista6(pag);
    }
  public Remplazo getRemplazo() {
        return remplazo;
    }

    public void setRemplazo(Remplazo remplazo) {
        this.remplazo = remplazo;
    }

    public Boolean getRem() {
        return rem;
    }

    public void setRem(Boolean rem) {
        this.rem = rem;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public CuentasXPagar getCredito() {
        return credito;
    }

    public void setCredito(CuentasXPagar credito) {
        this.credito = credito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public anulargiro getAnulargiro() {
        return anulargiro;
    }

    public void setAnulargiro(anulargiro anulargiro) {
        this.anulargiro = anulargiro;
    }




}

