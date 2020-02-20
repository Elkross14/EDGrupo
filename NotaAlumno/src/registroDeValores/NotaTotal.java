/** 
 *<h2> Clase NotaTotal </h2> 
 *
 * Almacena todos los datos necesarios de las notas.
 * 
 * Última actualización:
 * -Se ha mejorado la legibilidad
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.3
 */
package registroDeValores;



public class NotaTotal extends Trabajo {

	private final int PORCENTAJE10 = 10;
	private final int PORCENTAJE20 = 20;
	private final int PORCENTAJE25 = 25;
	
	private final int NUM_EXAMENES_CLASICOS = 3;
	private final int NUM_EXAMENES_TEST = 2;
	private final int NUM_TRABAJOS = 3;
	
	private ExamenClasico examenClasicoArray[] = new ExamenClasico[NUM_EXAMENES_CLASICOS];
	private ExamenTest examenTestArray[] = new ExamenTest[NUM_EXAMENES_TEST];
	
	
	/**
	 * Constructor vacio
	 */
	public NotaTotal() {
		trabajosEntregados = new int[NUM_TRABAJOS][2];
		examenClasicoArray[0] = new ExamenClasico(0, PORCENTAJE10);
		examenClasicoArray[1] = new ExamenClasico(0, PORCENTAJE20);
		examenClasicoArray[2] = new ExamenClasico(0, PORCENTAJE20);
		examenTestArray[0] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
		examenTestArray[1] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
	}
	
	
	/**
	 * Constructor con variables de clase
	 * @param trabajo: boolean para comprobar los trabajamos entregados
	 * @param examenClasico: objeto de ExamenClasico que contiene nota 
	 * y porcentaje de peso en la nota global
	 * @param examenTest: objeto de ExamenTest que contiene preguntas
	 * correctas, fallidas, sin responder, nota del test, nota y porcentaje
	 * de peso en la nota global
	 * @param retrasos: cantidad de restrasos de un alumno
	 */
	public NotaTotal(int [][] trabajoEntregado, ExamenClasico [] examenClasico,
			ExamenTest [] examenTest, int retrasos) {
		
		this.trabajosEntregados = trabajoEntregado;
		this.examenClasicoArray = examenClasico;
		this.examenTestArray = examenTest;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param notaTotal: se le pasa como variable un objeto NotaTotal
	 */
	public NotaTotal(NotaTotal notaTotal) {
		
		this.trabajosEntregados = notaTotal.trabajosEntregados;
		this.examenClasicoArray = notaTotal.examenClasicoArray;
		this.examenTestArray = notaTotal.examenTestArray;
	}

	
	/**
	 * @return Array de trabajos entregados
	 */
	public int[][] getTrabajoEntregado() {
		return trabajosEntregados;
	}

	
	/**
	 * @return objeto de ExamenClasico (double nota, int porcNotaGlobal)
	 */
	public ExamenClasico[] getExamenClasico() {
		return examenClasicoArray;
	}

	
	/**
	 * @return objeto de ExamenTest (int correctas, int falladas, int sinContestar, 
	 * int preguntasTotales, double nota, int porcNotaGlobal)
	 */
	public ExamenTest[] getExamenTest() {
		return examenTestArray;
	}

	
	/**
	 * @return la cantidad de examenes clásicos que hace cada persona
	 */
	public int getNUM_EXAMENES_CLASICOS() {
		return NUM_EXAMENES_CLASICOS;
	}

	
	/**
	 * @return la cantidad de examenes tipo test que hace cada persona
	 */
	public int getNUM_EXAMENES_TEST() {
		return NUM_EXAMENES_TEST;
	}

	
	public int getNUM_TRABAJOS() {
		return NUM_TRABAJOS;
	}


	/**
	 * @param trabajoEntregado: boolean array que guarda los trabajos entregados
	 */
	public void setTrabajoEntregado(int[][] trabajoEntregado) {
		this.trabajosEntregados = trabajoEntregado;
	}

	
	/**
	 * @param examenClasico: objeto ExamenClasico Array
	 */
	public void setExamenClasico(ExamenClasico[] examenClasico) {
		this.examenClasicoArray = examenClasico;
	}

	
	/**
	 * @param examenTest: objeto ExamenTest Array
	 */
	public void setExamenTest(ExamenTest[] examenTest) {
		this.examenTestArray = examenTest;
	}
	
	
	/**
	 * Nos pasa los datos de las notas a los examenes clásicos
	 * 
	 * @param NotaExamenClasico: Array double con las notas de todos los examenes clásicos
	 */
	public void setNotaExamenClasico(double NotaExamenClasico[]) {
		for (int i = 0; i < NUM_EXAMENES_CLASICOS; i++) {
			examenClasicoArray[i].setNota(NotaExamenClasico[i]);
		}
	}
	
	
	/**
	 * Nos pasa las respuestas recogidas por una clase a la clase ExamenTest
	 * 
	 * @param correctas: respuestas acertadas en un notaTotal tipo test
	 * @param falladas: respuestas falladas en un notaTotal tipo test
	 * @param sinContestar: respuesta no contestasdas en un notaTotal tipo test
	 */
	public void setRespuestasExamenTest(int correctas[], int falladas[],
			int sinContestar[]) {
		for (int i = 0; i < NUM_EXAMENES_TEST; i++) {
			examenTestArray[i].setCorrectas(correctas[i]);
			examenTestArray[i].setFalladas(falladas[i]);
			examenTestArray[i].setSinContestar(sinContestar[i]);
		}
	}
	

}
