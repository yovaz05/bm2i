/*
 * MapaOtrosv.java
 *
 * Created on 4 de noviembre de 2006, 20:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package reportesXML;

import beans.Cliente;
import beans.Otros;
import modelo.Lista;
import java.util.Vector;

public class MapaCliente extends ModeloTabla implements ModeloMapa {

    private boolean numerador;
    private String[] nombre = new String[]{
        "Cedula/RUC",
        "Nombres",
        "Apellidos",
        "Codigo",
        "Correo",
        "Telefono",
        "Celular",};
    private boolean[] edit = new boolean[]{
        false,
        false,
        false,
        false,
        false,
        false,
        false
    };
    private Class[] tipo = new Class[]{
        String.class,
        String.class,
        String.class,
        String.class,
        String.class,
        String.class,
        String.class
    };
    private Cliente clientes;

    public MapaCliente(Lista lista, boolean numerador) {
        setNumerador(numerador);
        setColumnNames(getNombre());
        setCanEdit(getEdit());
        setTypes(getTipo());
        setDatos(lista);
    }

    public void setDatos(Lista lista) {
        Vector rows = new Vector();
        for (int i = 0; i < lista.getSize(); i++) {
            Vector row = new Vector();
            Cliente cliente = (Cliente) lista.getObject(i);

            row.add(cliente.getCedularuc());
            row.add(cliente.getNombres());
            row.add(cliente.getApellidos());
            row.add(cliente.getCodigocliente());
            row.add(cliente.getEmail());
            row.add(cliente.getTelefono());
            row.add(cliente.getCelular());
            
            rows.add(row);

        }
        setRows(rows);
        if (!isNumerador()) {
            deleteColumn(0);
        }
    }

    public void setNumerador(boolean b) {
        numerador = b;
    }

    public boolean isNumerador() {
        return numerador;
    }

    public String[] getNombre() {
        return nombre;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public boolean[] getEdit() {
        return edit;
    }

    public void setEdit(boolean[] edit) {
        this.edit = edit;
    }

    public Class[] getTipo() {
        return tipo;
    }

    public void setTipo(Class[] tipo) {
        this.tipo = tipo;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public void setDatos(Vector lista) {
    }
}
