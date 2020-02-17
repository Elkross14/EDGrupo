 /**
 * <h2>Clase ExamenTest</2>
 * 
 * Clase derivada de Examen. 
 * Todo lo necesario para crear una nota de un examen tipo test.
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1
 */

package VariablesDelPrograma;

public class ExamenTest extends Examen{
	/**
	 * variables de clase
	 */
	private int correctas;
	private int falladas;
	private int sinContestar;
	private int preguntasTotales;
	private double nota;
	private int porcNotaGlobal;
	
	/**
	 * Constructor vacio
	 */
	public ExamenTest() {
		correctas=0;
		falladas=0;
		sinContestar=0;
		preguntasTotales=0;
		nota=0;
		porcNotaGlobal=0;
	}
	
	/**
	 * Constructor con variables de clase
	 * @param correctas: respuestas acertadas en el examen tipo test
	 * @param falladas: respuestas falladas en el examen tipo test
	 * @param sinContestar: preguntas sin contestar en el examen de tipo test
	 * @param preguntasTotales: cantidad total de preguntas en el examen de tipo test
	 * @param nota: nota de examen tipo test
	 * @param porcNotaGlobal: porcentaje de peso del examen en la nota global
	 */
	public ExamenTest(int correctas, int falladas, int sinContestar, int preguntasTotales, 
			double nota, int porcNotaGlobal) {
		
		this.correctas=correctas;
		this.falladas=falladas;
		this.sinContestar=sinContestar;
		this.preguntasTotales=preguntasTotales;
		this.nota=nota;
		this.porcNotaGlobal=porcNotaGlobal;
	}

	/**
	 * @return  respuestas acertadas en el examen tipo test
	 */
	public int getCorrectas() {
		return correctas;
	}

	/**
	 * @return respuestas falladas en el examen tipo test
	 */
	public int getFalladas() {
		return falladas;
	}

	/**
	 * @return preguntas sin contestar en el examen de tipo test
	 */
	public int getSinContestar() {
		return sinContestar;
	}
	
	/**
	 * @return cantidad total de preguntas en el examen de tipo test
	 */
	public int preguntasTotales() {
		return preguntasTotales;
	}
	
	/**
	 * @return nota de examen tipo test
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @return porcentaje de peso del examen en la nota global
	 */
	public int getPorcNotaGlobal() {
		return porcNotaGlobal;
	}

	/**
	 * @param correctas: respuestas acertadas en el examen tipo test
	 */
	public void setCorrectas(int correctas) {
		this.correctas = correctas;
	}

	/**
	 * @param falladas: respuestas falladas en el examen tipo test
	 */
	public void setFalladas(int falladas) {
		this.falladas = falladas;
	}

	/**
	 * @param sinContestar: preguntas sin contestar en el examen de tipo test
	 */
	public void setSinContestar(int sinContestar) {
		this.sinContestar = sinContestar;
	}
	
	/**
	 * @param preguntasTotales: cantidad total de preguntas en el examen de tipo test
	 */
	public void preguntasTotales(int preguntasTotales) {
		this.preguntasTotales=preguntasTotales;
	}

	/**
	 * @param nota: nota de examen tipo test
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	/**
	 * @param porcNotaGlobal: porcentaje de peso del examen en la nota global
	 */
	public void setPorcNotaGlobal(int porcNotaGlobal) {
		this.porcNotaGlobal = porcNotaGlobal;
	}
}
