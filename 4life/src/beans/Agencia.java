/*
 * Agencia.java
 *
 * Created on 19 de septiembre de 2006, 15:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package beans;

import Datos.AgenciaHBM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agencia {

    private int id_Agencia;
    private String nombre;
    private String codigo;
    private Float utilidad;
    private AgenciaHBM base;

    public Agencia() {
        setBase(new AgenciaHBM());
    }

    public int getId_Agencia() {
        return id_Agencia;
    }

    public void setId_Agencia(int id_Agencia) {
        this.id_Agencia = id_Agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public AgenciaHBM getBase() {
        return base;
    }

    public void setBase(AgenciaHBM base) {
        this.base = base;
    }

    public boolean guardar() {
        return getBase().guardar(this);
    }

    public boolean actualizar() {
        return getBase().actualizar(this);
    }

    public void borrar() {
        getBase().eliminar(this);
    }

    public Float getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(Float utilidad) {
        this.utilidad = utilidad;
    }

    public List lista() {
        return getBase().lista();
    }

    public Agencia Busca(String cod) {
        return getBase().busca(cod);
    }

    public Agencia bus(String nom) {
        return getBase().buscar(nom);
    }

    public Agencia busCla(String nom) {
        return getBase().buscarCl(nom);
    }
}
