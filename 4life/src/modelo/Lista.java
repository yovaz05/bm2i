/*
 * Lista.java
 *
 * Created on 5 de marzo de 2006, 06:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Edison
 */
public class Lista {
    
    private LinkedList lista;
    private int index;
    
    /** Creates a new instance of Lista */
    public Lista() {
    }
    
    /**
     * 
     * @param list 
     */
    public Lista(List list) {
        lista = new LinkedList();
        setIndex(0);
        Object[] o = list.toArray();
        for (int i = 0; i < o.length; i++) {
            lista.add(o[i]);
        }
    }
    
    public Lista(Object o){
        setLista(new LinkedList());
        setIndex(0);
        getLista().add(o);
    }
    
    /**
     * 
     * @return 
     */
    public String[] getString(){
        String[] s = new String[lista.size()];
        for (int i = 0; i < s.length; i++) {
            s[i]=lista.get(i).toString();
        }
        return s;
    }
    
    /**
     * 
     * @return 
     */
    public Object primero(){
        setIndex(0);
        return getLista().get(getIndex());
    }
    
    /**
     * 
     * @return 
     */
    public Object ultimo(){
        if (this.isEmpty()){
            return null;
        }else{
            setIndex(getLista().size()-1);
            return getLista().get(getIndex());
        }
    }
    
    public Object[] toArray(){
        Object obj[] = new Object[lista.size()];
        for (int i = 0; i < obj.length; i++) {
            obj[i]=getObject(i);
        }
        return obj;
    }
    
    /**
     * 
     * @return 
     */
    public Object getMyself(){
        return getLista().get(getIndex());
    }
    
    /**
     * 
     * @return 
     */
    public Object anterior(){
        setIndex(getIndex()-1);
        if (getIndex()>=0)
            return getLista().get(getIndex());
        else{
            setIndex(getIndex()+1);
            return null;
        }
    }
    
    /**
     * 
     * @return 
     */
    public Object siguiente(){
        setIndex(getIndex()+1);
        if (getIndex()<=getLista().size()-1)
            return getLista().get(getIndex());
        else
            setIndex(getIndex()-1);
            return null;
    }
    /**
     * 
     * @param index 
     * @return 
     */
    public Object getObject(int index){
        if (index<+getLista().size())
            return getLista().get(index);
        else 
            return null;
    }
    
    
    /**
     * 
     * @return 
     */
    public boolean isPrimero(){
        if (getIndex()==0)
            return true;
        else
            return false;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isUltimo(){
        if (getIndex()==(getLista().size()-1))
            return true;
        else
            return false;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty(){
        if (getLista().size()<=0){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * 
     * @return 
     */
    public int getSize(){
        return lista.size();
    }
    
    /**
     * 
     * @return 
     */
    public LinkedList getLista() {
        return lista;
    }

    /**
     * 
     * @param lista 
     */
    public void setLista(LinkedList lista) {
        this.lista = lista;
    }

    /**
     * 
     * @return 
     */
    public int getIndex() {
        return index;
    }

    /**
     * 
     * @param index 
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    public Object goTo(Object aObject){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).toString().equalsIgnoreCase(aObject.toString())){
                index =i;
                return lista.get(i);
            }
        }
        return null;
    }
    
}
