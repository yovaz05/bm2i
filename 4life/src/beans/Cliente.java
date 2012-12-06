/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Datos.ClienteHBM;
import java.util.List;

/**
 *
 * @author richard
 */
public class Cliente {

    private int id_cliente;
    /**
     * nombre voy a almacenar un solo nombre para la busqueda
     */
    private String nombre;
    private String nombres;
    private String apellidos;
    private String cedularuc;
    private String codigocliente;
    private String email;
    private String telefono;
    private String celular;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    private ClienteHBM base;

    public Cliente() {
        setBase(new ClienteHBM());
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedularuc() {
        return cedularuc;
    }

    public void setCedularuc(String cedularuc) {
        this.cedularuc = cedularuc;
    }

    public String getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(String codigocliente) {
        this.codigocliente = codigocliente;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteHBM getBase() {
        return base;
    }

    public void setBase(ClienteHBM base) {
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
    
    public List lista() {
        return getBase().lista();
    }
    
    public List<Cliente> buscarNombres(String nombre) {
        return getBase().buscarNombres(nombre);
    }

    public Cliente buscarCodigo(String codigo) {
        return getBase().buscarCodigoCliente(codigo);
    }

    public Cliente buscarCedula(String cedula) {
        return getBase().buscaCedula(cedula);
    }
}
