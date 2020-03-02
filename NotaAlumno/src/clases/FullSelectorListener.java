/** 
 *<h2> Clase FullSelectorListener </h2> 
 *
 * Clase que nos seleccionará automaticamente todo el texto de un jfield
 * cuando entremos a editarlo
 * 
 * Última actualización: 
 * - Clase Añadida
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1
 */

package clases;

public class FullSelectorListener extends java.awt.event.FocusAdapter {
    public FullSelectorListener() {
    }
    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
 
    }
    
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        Object o = evt.getSource();
        if(o instanceof javax.swing.JTextField){
            javax.swing.JTextField txt = (javax.swing.JTextField) o;
            txt.setSelectionStart(0);
            txt.setSelectionEnd(txt.getText().length());
        }
    }
}
