/** 
 *<h2> Clase VerificacionDeDatos </h2> 
 *
 * Verifica todos los datos de entrada del usuario
 *
 * Última actualización:
 * -Eliminado los verificadores de int y double
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.4
 */
package clases;

public class VerificacionDeDatos {
    
    
    /**
     * Evita que se le introduzcan carácteres extraños.
     * Sólo permite la entrada de caracteres anglosajones y acentos.
     * 
     * @param cadena Entrada de un String.
     * @return devolverá falso en el caso de que solo haya caracteres anglosajones y acentos.
     */
    public boolean correctoString(String cadena) {	//evia caracteres extraños y números
        for (int i = 0; i < cadena.length(); i++){
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 32 //espacio en blanco
                    && valorASCII != 209 //caracter Ñ
                    && valorASCII != 193 //caracter Á
                    && valorASCII != 201 //caracter É
                    && valorASCII != 205 //caracter Í
                    && valorASCII != 211 //caracter Ó
                    && valorASCII != 218 //caracter Ú
                    && valorASCII != 220 //caracter Ü
                    &&(valorASCII < 65 || valorASCII > 90))	//mayusculas normales
            	return true; //Se ha encontrado un caracter que no es letra
        } 
        return false;	//Todo correcto
    }
    
    
    /**
     * Verifica que se haya introducido algún valor
     * 
     * @param cadena Entrada del dato a verificar si está relleno
     * @return devolverá false en caso de estar rellenado
     */
    public boolean campoRelleno(String cadena) {
        return cadena.equals("") || cadena.equals(" ");
    }
    
    
    /**
     * Verifica si la longitud de la cadena es mayor a 50
     * 
     * @param cadena Entrada del String a verificar si es mayor a 50
     * @return devolverá false en caso de que sea menor a 50 caracteres
     */
    public boolean longitudString(String cadena) {
        if(cadena.length()>50){
            return true;	//se ha superado el límite de caracteres
        }
        return false;	//está dentro de rango
    }
    
    
    /**
     * Calcula si la cantidad de respues son las correctas
     * 
     * @param respuestasCorrectas Cantidad de respuestas correstas en el test
     * @param respuestasIncorrectas Cantidad de respuestas incorrestas en el test
     * @param respuestasSinContestar Cantidad de respuestas sin contestar en el test
     * @return devolverá false en caso de no ser la cantidad correcta de respuestas.
     */
    public boolean cantidadRespuestasTest(String respuestasCorrectas, String respuestasFalladas, String respuestasSinContestar) {
    	
        int correctas = Integer.valueOf(respuestasCorrectas);
        int falladas = Integer.valueOf(respuestasFalladas);
        int SinContestar = Integer.valueOf(respuestasSinContestar);
        
        int total = correctas + falladas + SinContestar;
        
        if(total != 30) {
            return true;	//no hay un total de 30 preguntas
        }
        
        return false;	//está dentro de rango
    }
    
    
    /**
     * Verifica que la nota esté entre 0 y 10
     * 
     * @param sNota String con la nota a verificar
     * @return devolverá false en el caso de que la nota esté dentro de rango
     */
    public boolean rangoNotaEx(String sNota) {
        double nota = Double.valueOf(sNota);
        if(nota < 0 || 10 < nota) {
            return true;	//el valor introducido no está dentro de rango
        }
        return false;
    }
    
    
}
