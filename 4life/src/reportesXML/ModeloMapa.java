/*
 * ModeloMapa.java
 *
 * Created on 22 de abril de 2006, 12:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import java.util.Vector;
import modelo.Lista;


/**
 * Interface necesaria para crear los Mapa de los objetos del sistema
 * @author Edison
 */
public interface ModeloMapa {
    
    /**
     * Metodo que fija y crea los datos en un Modelo de Tabla
     * @param lista Datos a fijar
     */
    public void setDatos(Lista lista);
    public void setDatos(Vector lista);
    
    public void setNumerador(boolean b);
    
    public boolean isNumerador();
    
}
