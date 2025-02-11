 /**
 * <h2>Clase ExamenTest</2>
 * 
 * Todo lo necesario para crear una nota de un examen de tipo test.
 * 
 * �ltima actualizaci�n:
 * -Se ha mejorado la legibilidad
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1.3
 */

package registroDeValores;

public class ExamenTest {
	
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
		correctas = 0;
		falladas = 0;
		sinContestar = 0;
		preguntasTotales = 0;
		nota = 0.0;
		porcNotaGlobal = 0;
	}
	
	/**
	 * Constructor con variables de clase
	 * 
	 * @param correctas: respuestas acertadas en el notaTotal tipo test
	 * @param falladas: respuestas falladas en el notaTotal tipo test
	 * @param sinContestar: preguntas sin contestar en el notaTotal de tipo test
	 * @param preguntasTotales: cantidad total de preguntas en el notaTotal de tipo test
	 * @param nota: nota de notaTotal tipo test
	 * @param porcNotaGlobal: porcentaje de peso del notaTotal en la nota global
	 */
	public ExamenTest(int correctas, int falladas, int sinContestar, int preguntasTotales, 
			double nota, int porcNotaGlobal) {
		
		this.correctas = correctas;
		this.falladas = falladas;
		this.sinContestar = sinContestar;
		this.preguntasTotales = preguntasTotales;
		this.nota = nota;
		this.porcNotaGlobal = porcNotaGlobal;
	}
	
	/**
	 * Constructor copia
	 * 
	 * @param examenTest: se le pasa como variable un objeto ExamenTest
	 */
	public ExamenTest(ExamenTest examenTest) {
		this.correctas = examenTest.correctas;
		this.falladas = examenTest.falladas;
		this.sinContestar = examenTest.sinContestar;
		this.preguntasTotales = examenTest.preguntasTotales;
		this.nota = examenTest.nota;
		this.porcNotaGlobal = examenTest.porcNotaGlobal;
	}
	

	/**
	 * @return  respuestas acertadas en el notaTotal tipo test
	 */
	public int getCorrectas() {
		return correctas;
	}

	
	/**
	 * @return respuestas falladas en el notaTotal tipo test
	 */
	public int getFalladas() {
		return falladas;
	}
	

	/**
	 * @return preguntas sin contestar en el notaTotal de tipo test
	 */
	public int getSinContestar() {
		return sinContestar;
	}
	
	
	/**
	 * @return cantidad total de preguntas en el notaTotal de tipo test
	 */
	public int preguntasTotales() {
		return preguntasTotales;
	}
	
	
	/**
	 * @return nota de notaTotal tipo test
	 */
	public double getNota() {
		return nota;
	}
	

	/**
	 * @return porcentaje de peso del notaTotal en la nota global
	 */
	public int getPorcNotaGlobal() {
		return porcNotaGlobal;
	}
	

	/**
	 * @param correctas: respuestas acertadas en el notaTotal tipo test
	 */
	public void setCorrectas(int correctas) {
		this.correctas = correctas;
	}
	

	/**
	 * @param falladas: respuestas falladas en el notaTotal tipo test
	 */
	public void setFalladas(int falladas) {
		this.falladas = falladas;
	}
	

	/**
	 * @param sinContestar: preguntas sin contestar en el notaTotal de tipo test
	 */
	public void setSinContestar(int sinContestar) {
		this.sinContestar = sinContestar;
	}
	
	
	/**
	 * @param preguntasTotales: cantidad total de preguntas en el notaTotal de tipo test
	 */
	public void preguntasTotales(int preguntasTotales) {
		this.preguntasTotales = preguntasTotales;
	}
	

	/**
	 * @param nota: nota de notaTotal tipo test
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	/**
	 * @param porcNotaGlobal: porcentaje de peso del notaTotal en la nota global
	 */
	public void setPorcNotaGlobal(int porcNotaGlobal) {
		this.porcNotaGlobal = porcNotaGlobal;
	}
}
