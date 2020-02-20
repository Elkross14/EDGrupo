/** 
 *<h2> Clase MensajeError </h2> 
 *
 * Contiene todos los mensajes de error que usar� el programa
 * 
 * �ltima actualizaci�n:
 * -Se ha mejorado la legibilidad
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1.1
 */

package clases;


import javax.swing.JOptionPane;


public class MensajeError extends javax.swing.JFrame {
    
	
	/**
	 * Saltar� un WARNING_MESSAGE de campo sin rellenar.
	 * 
	 * @param campo: Nombre del campo a rellenar.
	 */
    public void vacioCampo(String campo) {
        JOptionPane.showMessageDialog(this,
            "No se ha rellenado el campo " + campo + ".",
            "Campo vacio",
            JOptionPane.WARNING_MESSAGE);
    }
    
    
    /**
     * Saltar� un WARNING_MESSAGE en caso de que no haya un jradio seleccionado
     * 
     * @param grupo: grupo de jradio sin opci�n seleccionada
     */
    public void vacioRadio(String grupo) {
        JOptionPane.showMessageDialog(this,
            "No se ha seleccionado ninguna opci�n de " + grupo + ".",
            "Radio vacio",
            JOptionPane.WARNING_MESSAGE);
    }
    
    
    /**
     * Saltar� un WARNING_MESSAGE en caso de que haya m�s caracteres de los permitidos.
     * 
     * @param campo: nombre del campo con el exceso de caracteres 
     */
    public void maximoCaracteres(String campo) {
        JOptionPane.showMessageDialog(this,
                "Se ha superado el maximo de caracteres en el campo " + campo + ".",
                "Campo excedido",
                JOptionPane.WARNING_MESSAGE);
    }

    
    /**
     * Saltar� un ERROR_MESSAGE en caso de que no sea un n�mero entero
     * 
     * @param campo: nombre del campo con el error de entrada de n�mero entero
     */
    public void errorNumEnt(String campo) {
        JOptionPane.showMessageDialog(this,
            "No es valido nada que no sea numeros enteros en " + campo,
            "Error numerico Entero",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltar� un ERROR_MESSAGE en caso de que lo introducido no sea alfabeto ingles y espa�ol
     * 
     * @param campo: nombre del campo con caracteres no ingleses o espa�oles
     */
    public void errorString(String campo) {
        JOptionPane.showMessageDialog(this,
            "No se puede introducir numeros\nni caracteres extra�os en " + campo,
            "Error String",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltar� un YES_NO_OPTION en caso de que se quiera volver atr�s y perder los datos
     * 
     * @return devolver� cero en el caso de confirmar
     */
    public int preguntaAtras() {
        return JOptionPane.showConfirmDialog(null, 
            "Si vuelve atr�s se perder�n todos los datos\n"
                + "�Quieres contiunar?", 
            "Confirmar atras",JOptionPane.YES_NO_OPTION);
    }
    
    
    /**
     * Saltar� un INFORMATION_MESSAGE en caso de haber enviado los datos al servidor
     */
    public void envioCorrecto() {
        JOptionPane.showMessageDialog(this,
            "Datos enviados correctamente",
            "Envio de datos",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    /**
     * Saltar� un ERROR_MESSAGE en caso de no poder enviar los mensajes al servidor
     */
    public void envioIncorrecto() {
        JOptionPane.showMessageDialog(this,
            "No se han podido enviar los datos al servidor.",
            "Envio de datos",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltar� un ERROR_MESSAGE en el caso de que haya un error en la petici�n de datos al servidor
     */
    public void errorPedirDatos() {
        JOptionPane.showMessageDialog(this,
            "No se han podido recibir los datos del servidor.",
            "Recepci�n de datos",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltar� un ERROR_MESSAGE en el caso de que no se haya podido borrar el dato en el servidor
     */
    public void errorBorrado() {
        JOptionPane.showMessageDialog(this,
            "Ha surgido un error en el borrado del dato.",
            "Error de borrado",
            JOptionPane.ERROR_MESSAGE);
    }
}

