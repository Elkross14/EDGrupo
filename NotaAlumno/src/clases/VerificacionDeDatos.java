/** 
 *<h2> Clase VerificacionDeDatos </h2> 
 *
 * Verifica todos los datos de entrada del usuario
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1.1
 */
package clases;

public class VerificacionDeDatos {
	
	
	/**
	 * Verifica que el n�mero entero est� bien introducido
	 * 
	 * @param cadena: Entrada de un supuesto n�mero entero
	 * @return devolver� falso en el caso de que sea un n�mero entero
	 */
    public boolean correctoInt(String cadena) {
		try {
			Integer.parseInt(cadena);
			return false;	//todo correcto
		} 
		catch (NumberFormatException nfe){
			return true;
		}
    }  
    
    
    /**
     * Verifica que el n�mero decimal est� bien introducido
     * 
     * @param cadena: Entrada de un supuesto n�mero decimal
     * @return devolver� falso en el caso de que sea un n�mero decimal
     */
    public boolean correctoDouble(String cadena) {
		try {
			Double.parseDouble(cadena);
			return false;	//todo correcto
			
		} catch (NumberFormatException nfe) {
			return true;
		}
    } 
    
    
    /**
     * Evita que se le introduzcan car�cteres extra�os.
     * S�lo permite la entrada de caracteres anglosajones y acentos.
     * 
     * @param cadena: Entrada de un String.
     * @return devolver� falso en el caso de que solo haya caracteres anglosajones y acentos.
     */
    public boolean correctoString(String cadena) {	//evia caracteres extra�os y n�meros
        for (int i = 0; i < cadena.length(); i++){
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 32 //espacio en blanco
                    && valorASCII != 209 //caracter �
                    && valorASCII != 193 //caracter �
                    && valorASCII != 201 //caracter �
                    && valorASCII != 205 //caracter �
                    && valorASCII != 211 //caracter �
                    && valorASCII != 218 //caracter �
                    && valorASCII != 220 //caracter �
                    &&(valorASCII < 65 || valorASCII > 90))	//mayusculas normales
            	return true; //Se ha encontrado un caracter que no es letra
        } 
        return false;	//Todo correcto
    }
    
    
    /**
     * Verifica que se haya introducido alg�n valor
     * 
     * @param cadena: entrada del dato a verificar si est� relleno
     * @return devolver� false en caso de estar rellenado
     */
    public boolean campoRelleno(String cadena) {
        return cadena.equals("") || cadena.equals(" ");
    }
    
    
    /**
     * Verifica si la longitud de la cadena es mayor a 50
     * 
     * @param cadena: entrada del String a verificar si es mayor a 50
     * @return devolver� false en caso de que sea menor a 50 caracteres
     */
    public boolean longitudString(String cadena) {
        if(cadena.length()>50){
            return true;	//se ha superado el l�mite de caracteres
        }
        return false;	//est� dentro de rango
    }
    
    
    /**
     * Calcula si la cantidad de respues son las correctas
     * 
     * @param respuestasCorrectas: cantidad de respuestas correstas en el test
     * @param respuestasIncorrectas: cantidad de respuestas incorrestas en el test
     * @param respuestasSinContestar: cantidad de respuestas sin contestar en el test
     * @return devolver� false en caso de no ser la cantidad correcta de respuestas.
     */
    public boolean cantidadRespuestasTest(String respuestasCorrectas, String respuestasIncorrectas, String respuestasSinContestar) {
        int correctas = Integer.valueOf(respuestasCorrectas);
        int incorrectas = Integer.valueOf(respuestasIncorrectas);
        int SinContestar = Integer.valueOf(respuestasSinContestar);
        int total = correctas + incorrectas + SinContestar;
        if(total == 30) {
            return true;	//no hay un total de 30 preguntas
        }
        
        return false;	//est� dentro de rango
    }
    
    
    /**
     * Verifica que la nota est� entre 0 y 10
     * 
     * @param sNota: String con la nota a verificar
     * @return devolver� false en el caso de que la nota est� dentro de rango
     */
    public boolean rangoNotaEx(String sNota) {
        double nota = Double.valueOf(sNota);
        if(nota < 0 || 10 < nota) {
            return true;	//el valor introducido no est� dentro de rango
        }
        return false;
    }
    
    
}
