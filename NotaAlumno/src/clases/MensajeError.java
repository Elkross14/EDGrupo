/** 
 *<h2> Clase MensajeError </h2> 
 *
 * Contiene todos los mensajes de error que usará el programa
 * 
 * Última actualización:
 * - Cambiado notaIncorrecta de warning a error
 * - Cambiado sumaTotal de warning a error
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.5
 */

package clases;


import javax.swing.JOptionPane;

import registroDeValores.NotaTotal;


public class MensajeError extends javax.swing.JFrame {
	
	NotaTotal notaTotal = new NotaTotal();
    
	
	/**
	 * Saltará un WARNING_MESSAGE de campo sin rellenar.
	 * 
	 * @param campo Nombre del campo a rellenar.
	 */
    public void vacioCampo(String campo) {
        JOptionPane.showMessageDialog(this,
            "No se ha rellenado el campo " + campo + ".",
            "Campo vacio",
            JOptionPane.WARNING_MESSAGE);
    }
    
    
    /**
     * Saltará un WARNING_MESSAGE en caso de que no haya un jradio seleccionado
     * 
     * @param grupo Grupo de jradio sin opción seleccionada
     */
    public void vacioRadio(String grupo) {
        JOptionPane.showMessageDialog(this,
            "No se ha seleccionado ninguna opción de " + grupo + ".",
            "Radio vacio",
            JOptionPane.WARNING_MESSAGE);
    }
    
    
    /**
     * Saltará un WARNING_MESSAGE en caso de que haya más caracteres de los permitidos.
     * 
     * @param campo Nombre del campo con el exceso de caracteres 
     */
    public void maximoCaracteres(String campo) {
        JOptionPane.showMessageDialog(this,
                "Se ha superado el maximo de caracteres en el campo " + campo + ".",
                "Campo excedido",
                JOptionPane.WARNING_MESSAGE);
    }

    
    /**
     * Saltará un ERROR_MESSAGE en caso de que no sea un número entero
     * 
     * @param campo Nombre del campo con el error de entrada de número entero
     */
    public void errorNumEnt(String campo) {
        JOptionPane.showMessageDialog(this,
            "No es valido nada que no sea numeros enteros en " + campo,
            "Error numerico Entero",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltará un ERROR_MESSAGE en caso de que no sea un número decimal
     * 
     * @param campo Nombre del campo con el error de entrada de número decimal
     */
    public void errorNumDouble(String campo) {
        JOptionPane.showMessageDialog(this,
                "No es valido nada que no sea numeros en el campo " + campo + ".",
                "Error numerico",
                JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltará un ERROR_MESSAGE en caso de que lo introducido no sea alfabeto ingles y español
     * 
     * @param campo Nombre del campo con caracteres no ingleses o españoles
     */
    public void errorString(String campo) {
        JOptionPane.showMessageDialog(this,
            "No se puede introducir numeros\nni caracteres extraños en " + campo,
            "Error String",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltará un YES_NO_OPTION en caso de que se quiera volver atrás y perder los datos
     * 
     * @return devolverá cero en el caso de confirmar
     */
    public int preguntaAtras() {
        return JOptionPane.showConfirmDialog(null, 
            "Si vuelve atrás se perderán todos los datos\n"
                + "¿Quieres contiunar?", 
            "Confirmar atras",JOptionPane.YES_NO_OPTION);
    }
    
    
    /**
     * Saltará un INFORMATION_MESSAGE en caso de haber enviado los datos al servidor
     */
    public void envioCorrecto() {
        JOptionPane.showMessageDialog(this,
            "Datos enviados correctamente",
            "Envio de datos",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    /**
     * Saltará un ERROR_MESSAGE en caso de no poder enviar los mensajes al servidor
     */
    public void envioIncorrecto() {
        JOptionPane.showMessageDialog(this,
            "No se han podido enviar los datos al servidor.",
            "Envio de datos",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltará un ERROR_MESSAGE en el caso de que haya un error en la petición de datos al servidor
     */
    public void errorPedirDatos() {
        JOptionPane.showMessageDialog(this,
            "No se han podido recibir los datos del servidor.",
            "Recepción de datos",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
     * Saltará un ERROR_MESSAGE en el caso de que no se haya podido borrar el dato en el servidor
     */
    public void errorBorrado() {
        JOptionPane.showMessageDialog(this,
            "Ha surgido un error en el borrado del dato.",
            "Error de borrado",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
	 * Saltará un WARNING_MESSAGE en el caso de que la suma total de las preguntas contestadas supera el limite.
	 * 
	 * @param exam Nombre del examen con preguntas de más.
	 */
    public void errorSumaTotal(String exam) {
        JOptionPane.showMessageDialog(this,
            "El total de preguntas del " + exam + " colocadas\n no son un total del "+notaTotal.getNUM_PREGUNTAS_TEST()+".",
            "Preguntas de mas",
            JOptionPane.ERROR_MESSAGE);
    }
    
    
    /**
	 * Saltará un WARNING_MESSAGE en caso de que alguna nota de un examen clasico este mal puesta.
	 * 
	 * @param exam Nombre del examen con la nota que no sea valida.
	 */
    public void errorNotaIncorrecta(String exam) {
        JOptionPane.showMessageDialog(this,
            "La nota del " + exam + " no es valida.",
            "Nota incorrecta",
            JOptionPane.ERROR_MESSAGE);
    }
}

