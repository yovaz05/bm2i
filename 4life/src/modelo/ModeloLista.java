/*
 * ModeloLista.java
 *
 * Created on 6 de marzo de 2006, 04:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

import javax.swing.AbstractListModel;

/**
 *
 * @author Edison
 */
public class ModeloLista extends AbstractListModel {
    
    private Lista lista;
    private String[] strings={};
    
    /** Creates a new instance of ModeloLista */
    public ModeloLista(Lista lista) {
        this.lista=lista;
        strings = new String[lista.getSize()];
        for (int i = 0; i < lista.getSize(); i++) {
            strings[i]=lista.getObject(i).toString();
        }
    }
    
    /**
     * 
     * @return 
     */
    public ModeloLista getModel(){
        return this;
    }

    /**
     * 
     * @return 
     */
    public int getSize() {
        return getStrings().length;
    }

    /**
     * 
     * @param index 
     * @return 
     */
    public Object getElementAt(int index) {
        return getStrings()[index];
    }

    /**
     * 
     * @return 
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * 
     * @param lista 
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    /**
     * 
     * @return 
     */
    public String[] getStrings() {
        return strings;
    }

    /**
     * 
     * @param strings 
     */
    public void setStrings(String[] strings) {
        this.strings = strings;
    }
    
}
