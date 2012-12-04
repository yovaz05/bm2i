/*
 * EditorDecimal.java
 *
 * Created on 5 de mayo de 2006, 02:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

import javax.swing.*; 
import javax.swing.text.*; 

import java.awt.Toolkit;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class EditorDecimal extends JTextField {

    private Toolkit toolkit;
    private NumberFormat integerFormatter;

    public EditorDecimal(double value, int columns) {
        super(columns);
        toolkit = Toolkit.getDefaultToolkit();
        integerFormatter = NumberFormat.getNumberInstance(Locale.US);
        integerFormatter.setMaximumFractionDigits(2);
        setValue(value);
    }

    public double getValue() {
        double retVal = 0;
        try {
            retVal = integerFormatter.parse(getText()).doubleValue();
        } catch (ParseException e) {
            // This should never happen because insertString allows
            // only properly formatted data to get in the field.
            toolkit.beep();
        }
        return retVal;
    }

    public void setValue(double value) {
        setText(integerFormatter.format(value));
    }

    protected Document createDefaultModel() {
        return new WholeNumberDocument();
    }

    protected class WholeNumberDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a) 
            throws BadLocationException {

            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;

            for (int i = 0; i < result.length; i++) {
                if (Character.isDigit(source[i]) || source[i]=='.' && (!existe('.')))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    System.err.println("insertString: " + source[i]);
                }
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
        
        private boolean existe(char c)throws BadLocationException{
            boolean bandera=false;
            String s = super.getText(0,super.getLength());
            char[] source = s.toCharArray();
            for (int i = 0; i < source.length; i++) {
                if (source[i]==c)
                    bandera=true;
            }
            return bandera;
        }
    }

}