/*
 * Fechas.java
 *
 * Created on 5 de marzo de 2006, 01:15 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edison
 */
public class Fechas {
    
    private Date fecha;
    
    /** Creates a new instance of Fechas */
    public Fechas() {
        setFecha(new Date());
    }
    
    /**
     * 
     * @param d 
     */
    public Fechas(Date d) {
        setFecha(d);
    }
    
    /**
     * 
     * @return 
     */
    public String[] getModeloYear(){
        String[] year = new String[]{
            "1978","1979","1980","1981","1982",
            "1983","1984","1985","1986","1987",
            "1988","1989","1990","1991","1992",
            "1993","1994","1995","1996","1997",
            "1998","1999","2000","2001","2002",
            "2003","2004","2005","2006","2007",
            "2008","2009","2010","2011","2012",
        };
        return year;
    }
    
    /**
     * 
     * @return 
     */
    public String[] getModeloMes(){
        String[] mes = new String[]{
            "Enero","Febrero","Marzo","Abril",
            "Mayo","Junio","Julio","Agosto",
            "Septiembre","Octubre","Noviembre","Diciembre"
        };
        return mes;
    }
    
    /**
     * 
     * @return 
     */
    public String[] getModeloDia(){
        String[] dia = new String[]{
            "1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31"
        };
        return dia;
    }
    
    /**
     * 
     * @param year 
     * @param mes 
     * @param dia 
     */
    public void  setFecha(String year, String mes, String dia){
        int meses=0;
        if (mes.equalsIgnoreCase("Enero"))
            meses =0;
        else if (mes.equalsIgnoreCase("Febrero"))
            meses=1;
        else if (mes.equalsIgnoreCase("Marzo"))
            meses =2;
        else if (mes.equalsIgnoreCase("Abril"))
            meses =3;
        else if (mes.equalsIgnoreCase("Mayo"))
            meses =4;
        else if (mes.equalsIgnoreCase("Junio"))
            meses =5;
        else if (mes.equalsIgnoreCase("Julio"))
            meses =6;
        else if (mes.equalsIgnoreCase("Agosto"))
            meses =7;
        else if (mes.equalsIgnoreCase("Septiembre"))
            meses =8;
        else if (mes.equalsIgnoreCase("Octubre"))
            meses =9;
        else if (mes.equalsIgnoreCase("Noviembre"))
            meses =10;
        else if (mes.equalsIgnoreCase("Diciembre"))
            meses =11;
            
        this.setFecha(new Date(Integer.parseInt(year)-1900, meses, Integer.parseInt(dia)));
    }
    /**
     * 
     * @return 
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * 
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * 
     * @return 
     */
    public String getDia(){
        try {
            return "" + getFecha().getDate();
        } catch (Exception e) {
            return "";
        }
        
    }
    
    /**
     * 
     * @param d 
     * @return 
     */
    public int getDia(Date d){
        return d.getDate();
    }
    
    /**
     * 
     * @param d 
     * @return 
     */
    public int getMes(Date d){
        return d.getMonth();
    }
    
    /**
     * 
     * @param d 
     * @return 
     */
    public int getYear(Date d){
        return d.getYear();
    }
    
    
    /**
     * 
     * @return 
     */
    public String getMes(){
        String mes = "";
        try {
            
        switch (getFecha().getMonth()){
            case 0: 
                mes="Enero";
                break;
            case 1: 
                mes="Febrero";
                break;
            case 2: 
                mes="Marzo";
                break;
            case 3: 
                mes="Abril";
                break;
            case 4: 
                mes="Mayo";
                break;
            case 5: 
                mes="Junio";
                break;
            case 6: 
                mes="Julio";
                break;
            case 7: 
                mes="Agosto";
                break;
            case 8: 
                mes="Septiembre";
                break;
            case 9: 
                mes="Octubre";
                break;
            case 10: 
                mes="Noviembre";
                break;
            case 11: 
                mes="Diciembre";
                break;
        }
        return mes;
        } catch (Exception e) {
         return "";   
        }
    }
    
    /**
     * 
     * @return 
     */
    public String getYear(){
        try {
            return "" + (getFecha().getYear()+1900);
        } catch (Exception e) {
            return "'";
        }
        
    }
    
    /**
     * 
     * @return 
     */
    public String toString(){
        return new String(""+getDia()+" de "+
                getMes()+" del "+
                getYear());
    }

    
    
}
