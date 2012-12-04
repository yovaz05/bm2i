/*
 * ModeloTabla.java
 *
 * Created on 6 de marzo de 2006, 02:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package reportesXML;

import modelo.Lista;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Edison
 */

public class ModeloTabla extends AbstractTableModel {
    
    private String[] columnNames = {};
    private Vector rows = new Vector();
    private Class[] types = {};
    private boolean[] canEdit = {};
    private Lista lista;

    public ModeloTabla() {
     }
    
    /**
     * 
     * @return 
     */
    public ModeloTabla getModel(){
        return this;
    }
    
    /**
     * 
     * @return 
     */
    public String[] getColumnNames() {
        return columnNames;
    }
    
    /**
     * 
     * @param columnNames 
     */
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    /**
     * 
     * @return 
     */
    public Vector getRows() {
        return rows;
    }

    /**
     * 
     * @param rows 
     */
    public void setRows(Vector rows) {
        this.rows = rows;
    }

    /**
     * 
     * @return 
     */
    public Class[] getTypes() {
        return types;
    }

    /**
     * 
     * @param types 
     */
    public void setTypes(Class[] types) {
        this.types = types;
    }
    
    /**
     * 
     * @return 
     */
    public boolean[] getCanEdit() {
        return canEdit;
    }

    /**
     * 
     * @param canEdit 
     */
    public void setCanEdit(boolean[] canEdit) {
        this.canEdit = canEdit;
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
     * @param titulo 
     * @param clase 
     * @param editar 
     * @param dato 
     * @return 
     */
    public int addColumn(String titulo, Class clase, boolean editar, Object dato){
        String[] titulos = new String[getColumnCount()+1];
        Class[] clases = new Class[getColumnCount()+1];
        boolean[] edicion = new boolean[getColumnCount()+1];
        for (int i = 0; i < getColumnCount(); i++) {
            titulos[i]=getColumnNames()[i];
            clases[i]=getTypes()[i];
            edicion[i]=getCanEdit()[i];
        }
        titulos[getColumnCount()]=titulo;
        clases[getColumnCount()]=clase;
        edicion[getColumnCount()]=editar;
        setColumnNames(titulos);
        setTypes(clases);
        setCanEdit(edicion);
        Vector v = new Vector();
        for(int i=0;i<getRowCount();i++){
            Vector v2=(Vector)getRows().get(i);
            v2.add(dato);
            v.add(v2);
        }
        setRows(v);
        return getColumnCount()-1;
    }
    
    public boolean deleteColumn(int columna){
        if ((columna<=0)&(columna>=getColumnCount()))
            return false;
        boolean[] newCanEdit = new boolean[getColumnCount()-1];
        String[] newColumnNames = new String[getColumnCount()-1];
        Class[] newTypes = new Class[getColumnCount()-1];
        int j=0;
        for (int i = 0; i < getColumnCount(); i++) {
            if (columna!=i){
                newCanEdit[j]=getCanEdit()[i];
                newColumnNames[j]=getColumnNames()[i];
                newTypes[j]=getTypes()[i];
                j++;
            }
        }
        setCanEdit(newCanEdit);
        setColumnNames(newColumnNames);
        setTypes(newTypes);
        return true;
    }
    
    public Object[] getLongValues(){
        Object[] obj=inicializaLongValues();
        for (int i = 0; i < getRowCount(); i++) {
            Vector v=(Vector)getRows().get(i);
            for (int j = 0; j < getColumnCount(); j++) {
                System.out.println(getColumnClass(j).getName());
                if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Integer")){
                    if(((Integer)v.get(j))>(Integer)obj[j])
                        obj[j]=v.get(j);
                }
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Float")){
                    if(((Float)v.get(j))>(Float)obj[j])
                        obj[j]=v.get(j);
                }
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.String")){
                    if(((String)v.get(j).toString()).length()>((String)obj[j]).length())
                        obj[j]=v.get(j);
                }
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Boolean"))
                    obj[j]=v.get(j);
                else
                    obj[j]=v.get(j);
                    
            }
        }
        return obj;
    }

    private Object[] inicializaLongValues(){
        Object[] obj=new Object[getColumnCount()];
         for (int j = 0; j < getColumnCount(); j++) {
            if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Integer"))
                    obj[j]=new Integer(0);
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Float"))
                    obj[j]=new Float(0);
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.String"))
                    obj[j]=new String("");
                else if(getColumnClass(j).getName().equalsIgnoreCase("java.lang.Boolean"))
                    obj[j]=new Boolean(true);
                else
                    obj[j]=new Object();
         }
        return obj;
    }
    
    /**
     * 
     * @param titulo 
     * @param clase 
     * @param editar 
     * @param dato 
     * @return 
     */
   public int addColumn(String titulo, Class clase, boolean editar, Object[] dato){
        String[] titulos = new String[getColumnCount()+1];
        Class[] clases = new Class[getColumnCount()+1];
        boolean[] edicion = new boolean[getColumnCount()+1];
        for (int i = 0; i < getColumnCount(); i++) {
            titulos[i]=getColumnNames()[i];
            clases[i]=getTypes()[i];
            edicion[i]=getCanEdit()[i];
        }
        titulos[getColumnCount()]=titulo;
        clases[getColumnCount()]=clase;
        edicion[getColumnCount()]=editar;
        setColumnNames(titulos);
        setTypes(clases);
        setCanEdit(edicion);
        Vector v = new Vector();
        for(int i=0;i<getRowCount();i++){
            Vector v2=(Vector)getRows().get(i);
            v2.add(dato[i]);
            v.add(v2);
        }
        setRows(v);
        return getColumnCount()-1;
    }

    //////////////////////////////////////////////////////////////////////////
    //
    //             Implementation of the TableModel Interface
    //
    //////////////////////////////////////////////////////////////////////////

    // MetaData

    /**
     * 
     * @param column 
     * @return 
     */
    public String getColumnName(int column) {
        if (getColumnNames()[column] != null) {
            return getColumnNames()[column];
        } else {
            return "";
        }
    }

    /**
     * 
     * @param columnIndex 
     * @return 
     */
    public Class getColumnClass(int columnIndex) {
        return getTypes() [columnIndex];
    }

    /**
     * 
     * @param rowIndex 
     * @param columnIndex 
     * @return 
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return getCanEdit() [columnIndex];
    }
        
    /**
     * 
     * @return 
     */
    public int getColumnCount() {
        return getColumnNames().length;
    }

    // Data methods

    /**
     * 
     * @return 
     */
    public int getRowCount() {
        return getRows().size();
    }

    /**
     * 
     * @param aRow 
     * @param aColumn 
     * @return 
     */
    public Object getValueAt(int aRow, int aColumn) {
        Vector row = (Vector)getRows().elementAt(aRow);
        return row.elementAt(aColumn);
    }


    /**
     * 
     * @param value 
     * @param aRow 
     * @param column 
     */
    public void setValueAt(Object value, int aRow, int column) {
        Vector row = (Vector)getRows().elementAt(aRow);
        row.set(column,value);
        getRows().set(aRow,row);
    }

}