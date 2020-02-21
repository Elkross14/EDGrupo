/** 
 *<h2> Clase NotaTotal </h2> 
 *
 * Almacena todos los datos necesarios de las notas.
 * 
 * Última actualización:
 * -Añadido los metodos que calculan la nota final
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.5
 */
package registroDeValores;



public class NotaTotal extends Trabajo {

	private final int PORCENTAJE10 = 10;
	private final int PORCENTAJE20 = 20;
	private final int PORCENTAJE25 = 25;
	
	private final int NUM_EXAMENES_CLASICOS = 3;
	private final int NUM_EXAMENES_TEST = 2;
	private final int NUM_TRABAJOS = 3;
	private final int NUM_PREGUNTAS_TEST=30;
	
	private ExamenClasico examenClasicoArray[] = new ExamenClasico[NUM_EXAMENES_CLASICOS];
	private ExamenTest examenTestArray[] = new ExamenTest[NUM_EXAMENES_TEST];
	private Trabajo trabajoArray[] = new Trabajo[NUM_TRABAJOS];
	
	
	/**
	 * Constructor vacio
	 */
	public NotaTotal() {
		
		for (int i = 0; i < NUM_TRABAJOS; i++) {
			trabajoArray[i] = new Trabajo(true, 0);
		}
		
		examenClasicoArray[0] = new ExamenClasico(0, PORCENTAJE10);
		examenClasicoArray[1] = new ExamenClasico(0, PORCENTAJE20);
		examenClasicoArray[2] = new ExamenClasico(0, PORCENTAJE20);
		examenTestArray[0] = new ExamenTest(0, 0, 0, NUM_PREGUNTAS_TEST, 0, PORCENTAJE25);
		examenTestArray[1] = new ExamenTest(0, 0, 0, NUM_PREGUNTAS_TEST, 0, PORCENTAJE25);
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
	public NotaTotal(Trabajo [] trabajoArray, ExamenClasico [] examenClasico,
			ExamenTest [] examenTest, int retrasos) {
		
		this.trabajoArray = trabajoArray;
		this.examenClasicoArray = examenClasico;
		this.examenTestArray = examenTest;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param notaTotal: se le pasa como variable un objeto NotaTotal
	 */
	public NotaTotal(NotaTotal notaTotal) {
		
		this.trabajoArray = notaTotal.trabajoArray;
		this.examenClasicoArray = notaTotal.examenClasicoArray;
		this.examenTestArray = notaTotal.examenTestArray;
	}

	
	/**
	 * @return objeto de ExamenClasico (double nota, int porcNotaGlobal)
	 */
	public ExamenClasico[] getExamenClasicoArray() {
		return examenClasicoArray;
	}

	
	/**
	 * @return objeto de ExamenTest (int correctas, int falladas, int sinContestar, 
	 * int preguntasTotales, double nota, int porcNotaGlobal)
	 */
	public ExamenTest[] getExamenTestArray() {
		return examenTestArray;
	}

	
	/**
	 * @return devuelve la cantidad de examenes clásicos que hace cada persona
	 */
	public int getNUM_EXAMENES_CLASICOS() {
		return NUM_EXAMENES_CLASICOS;
	}

	
	/**
	 * @return devuelve la cantidad de examenes tipo test que hace cada persona
	 */
	public int getNUM_EXAMENES_TEST() {
		return NUM_EXAMENES_TEST;
	}

	
	/**
	 * @return devuelve el número de trabajos
	 */
	public int getNUM_TRABAJOS() {
		return NUM_TRABAJOS;
	}

	
	/**
	 * 
	 * @return devuelve el número de preguntas que tiene cada examen tipo test
	 */
	public int getNUM_PREGUNTAS_TEST() {
		return NUM_PREGUNTAS_TEST;
	}


	/**
	 * @param examenClasico: objeto ExamenClasico Array
	 */
	public void setExamenClasicoArray(ExamenClasico[] examenClasico) {
		this.examenClasicoArray = examenClasico;
	}

	
	/**
	 * @param examenTest: objeto ExamenTest Array
	 */
	public void setExamenTestArray(ExamenTest[] examenTest) {
		this.examenTestArray = examenTest;
	}
	
	
	/**
	 * pasamos los valores de las notas del examen clásico al array de tipo ExamenClasico
	 * 
	 * @param NotaExamenClasico: Array double con las notas de todos los examenes clásicos
	 */
	public void setNotaExamenClasico(double [] NotaExamenClasico) {
		for (int i = 0; i < NUM_EXAMENES_CLASICOS; i++) {
			examenClasicoArray[i].setNota(NotaExamenClasico[i]);
		}
	}
	
	
	/**
	 * pasamos los valores de las respuesta del examen tipo test al array de tipo ExamenTest
	 * 
	 * @param correctas: respuestas acertadas en un notaTotal tipo test
	 * @param falladas: respuestas falladas en un notaTotal tipo test
	 * @param sinContestar: respuesta no contestasdas en un notaTotal tipo test
	 */
	public void setRespuestasExamenTest(int [] correctas, int [] falladas,
			int [] sinContestar) {
		for (int i = 0; i < NUM_EXAMENES_TEST; i++) {
			examenTestArray[i].setCorrectas(correctas[i]);
			examenTestArray[i].setFalladas(falladas[i]);
			examenTestArray[i].setSinContestar(sinContestar[i]);
		}
	}
	
	
	/**
	 * Pasamos los valores de los trabajos al array de tipo Trabajo
	 * 
	 * @param entregado: es de tipo boolean. true equivale a que se ha entregado el trabajo
	 * @param diasDeRetraso: es la cantidad de días que se tarda en entregar el trabajo
	 */
	public void setTrabajoArray(boolean [] entregado, int [] diasDeRetraso) {
		for (int i = 0; i < NUM_TRABAJOS; i++) {
			trabajoArray[i].setDiasDeRetraso(diasDeRetraso[i]);
			trabajoArray[i].setEntregado(entregado[i]);
		}
	}
	
	
	/**
	 * Calcula la nota global
	 * 
	 * @return devolverá la nota global
	 */
	public double calcularNotaGlobal() {
		double notaGlobal;
		
		if(getTrabajosEntregadosATiempo()) {
			notaGlobal = 3;
		}
		else {
			notaGlobal = calcularNotaTotalExText() + calcularNotaTotalExClasico();
		}
		
		return notaGlobal;
	}
	

	/**
	 * Calcula la nota total que se consigue juntando todos los examenes tipo test
	 * y su porcentaje de peso en la nota final
	 * 
	 * @return devolverá la nota de los examenes tipo test con decimales
	 */
	public double calcularNotaTotalExText() {
		double notaTotalExText = 0.0;
		double notaExTest;
		double porcentajeNotaGlobal;
		
		for (int i = 0; i < NUM_EXAMENES_TEST; i++) {
			
			notaExTest = examenTestArray[i].getNota();
			porcentajeNotaGlobal = examenTestArray[i].getPorcNotaGlobal();
			
			notaTotalExText += notaExTest * (porcentajeNotaGlobal / 100);
		}
		return notaTotalExText;
	}
	
	
	/**
	 * Calcula la nota de cada examen tipo test teniendo encuenta las respuestas
	 * acertadas, las falladas y el total de preguntas.
	 */
	public void calcularNotaExTest() {
		double acertadas;
		
		for (int i = 0; i <NUM_EXAMENES_TEST; i++) {
			 acertadas = examenTestArray[i].getCorrectas() - 
					 (examenTestArray[i].getFalladas() / 3);
			 double notaTest = (acertadas * 10)/ NUM_EXAMENES_TEST;
			 examenTestArray[i].setNota(notaTest);
		}
	}
	
	
	/**
	 * Calcula la nota total que se consigue juntando todos los examenes clasicos
	 * y su porcentaje de peso en la nota final
	 * 
	 * @return devolverá la nota de los examenes clásicos con decimales
	 */
	public double calcularNotaTotalExClasico() {
		double notaTotalExClasico = 0.0;
		double notaExClasico;
		double porcentajeNotaGlobal;
		
		for (int i = 0; i < NUM_EXAMENES_CLASICOS; i++) {
			
			notaExClasico = examenClasicoArray[i].getNota();
			porcentajeNotaGlobal = examenClasicoArray[i].getPorcNotaGlobal();
			
			notaTotalExClasico += notaExClasico * (porcentajeNotaGlobal / 100);
		}
		return notaTotalExClasico;
	}
	
	
	/**
	 * Nos dirá si todos los trabajos han sido entregado y si ha sido dentro del plazo
	 * de 5 dias como máximo de retraso
	 * 
	 * @return devolverá false en caso de que se hayan entregado todos los trabajos a tiempo
	 */
	public boolean getTrabajosEntregadosATiempo() {
		for (int i = 0; i < NUM_TRABAJOS; i++) {
			if(!trabajoArray[i].isEntregado() || trabajoArray[i].getDiasDeRetraso()>=5) {
				return true;
			}
		}
		return false;
	}
	

}
