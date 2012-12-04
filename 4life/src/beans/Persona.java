/*
 * Persona.java
 *
 * Created on 9 de junio de 2006, 06:52 PM
 */

package beans;


/**
 * 
 * @author Richard
 */
public abstract class Persona {
    
    private int idPersona;
    private String nombre;
    private String apellido;   
    private String cedula;
    private String direccion;
    private String telefono;
    
    public Persona() {        
    }    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   

}
