/** 
 *<h2> Clase NotaTotal </h2> 
 *
 * Almacena todos los datos necesarios de las notas.
 * 
 * �ltima actualizaci�n:
 * - A�adido el m�todo getRespuestasExamenTest
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.2.2
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
	
	private double notaGlobal;
	
	
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
	 * @return devuelve la cantidad de examenes cl�sicos que hace cada persona
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
	 * @return devuelve el n�mero de trabajos
	 */
	public int getNUM_TRABAJOS() {
		return NUM_TRABAJOS;
	}

	
	/**
	 * 
	 * @return devuelve el n�mero de preguntas que tiene cada examen tipo test
	 */
	public int getNUM_PREGUNTAS_TEST() {
		return NUM_PREGUNTAS_TEST;
	}


	/**
	 * @return Devuelve la nota global del alumno
	 */
	public double getNotaGlobal() {
		return notaGlobal;
	}
	
	
	/**
	 * @return Devuelve una matriz int con los resultados de los examenes tipo test
	 */
	public int[][] getRespuestasExamenTest(){
		int[][] respuestasTest = new int [NUM_EXAMENES_TEST][3];
		
		for (int i = 0; i < NUM_EXAMENES_TEST; i++) {
			respuestasTest [i][0]= examenTestArray[i].getCorrectas();
			respuestasTest [i][1]= examenTestArray[i].getFalladas();
			respuestasTest [i][2]= examenTestArray[i].getSinContestar();
		}
		return respuestasTest;
	}

	
	/**
	 * @return devuelve un array double con las notas de los examenes cl�sicos
	 */
	public double[] getNotaExamenClasico() {
		double[] notaExamenClasico = new double [NUM_EXAMENES_CLASICOS];
		
		for (int i = 0; i < NUM_EXAMENES_CLASICOS; i++) {
			notaExamenClasico[i] = examenClasicoArray[i].getNota();
		}
		return notaExamenClasico;
	}


	/**
	 * @param notaGlobal Valor de tipo double
	 */
	public void setNotaGlobal(double notaGlobal) {
		this.notaGlobal = notaGlobal;
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
	 * pasamos los valores de las notas del examen cl�sico al array de tipo ExamenClasico
	 * 
	 * @param NotaExamenClasico: Array double con las notas de todos los examenes cl�sicos
	 */
	public void setNotaExamenClasico(double [] NotaExamenClasico) {
		for (int i = 0; i < NUM_EXAMENES_CLASICOS; i++) {
			examenClasicoArray[i].setNota(NotaExamenClasico[i]);
		}
	}
	
	
	/**
	 * pasamos los valores de las respuesta del examen tipo test al array de tipo ExamenTest
	 * 
	 * @param correctas Respuestas acertadas en un notaTotal tipo test
	 * @param falladas Respuestas falladas en un notaTotal tipo test
	 * @param sinContestar Respuesta no contestasdas en un notaTotal tipo test
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
	 * @param diasDeRetraso: es la cantidad de d�as que se tarda en entregar el trabajo
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
	 * @return devolver� la nota global
	 */
	public void calcularNotaGlobal() {
		double notaExamenes;
		
		if(getTrabajosEntregadosATiempo()) {
			notaGlobal = 3;
		} else {
			notaExamenes = calcularNotaTotalExText() + calcularNotaTotalExClasico();
			notaGlobal = notaExamenes - getTotalDiasRetraso() * 0.1;
		}
	}
	

	/**
	 * Calcula la nota total que se consigue juntando todos los examenes tipo test
	 * y su porcentaje de peso en la nota final
	 * 
	 * @return devolver� la nota de los examenes tipo test con decimales
	 */
	public double calcularNotaTotalExText() {
		double notaTotalExText = 0.0;
		double notaExTest;
		double porcentajeNotaGlobal;
		
		calcularNotaExTest();
		
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
		double puntuacion;
		double notaTest;
		
		for (int i = 0; i < NUM_EXAMENES_TEST; i++) {
			 puntuacion = examenTestArray[i].getCorrectas() - 
					 (examenTestArray[i].getFalladas() / 3);
			 notaTest = (puntuacion * 10) / NUM_PREGUNTAS_TEST;
			 examenTestArray[i].setNota(notaTest);
		}
	}
	
	
	/**
	 * Calcula la nota total que se consigue juntando todos los examenes clasicos
	 * y su porcentaje de peso en la nota final
	 * 
	 * @return devolver� la nota de los examenes cl�sicos con decimales
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
	 * Nos dir� si todos los trabajos han sido entregado y si ha sido dentro del plazo
	 * de 5 dias como m�ximo de retraso
	 * 
	 * @return devolver� false en caso de que se hayan entregado todos los trabajos a tiempo
	 */
	public boolean getTrabajosEntregadosATiempo() {
		for (int i = 0; i < NUM_TRABAJOS; i++) {
			if(!trabajoArray[i].isEntregado() || trabajoArray[i].getDiasDeRetraso() >= 5) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Sumar� la cantidad total de dias de retraso en la entraga de los trabajos
	 * 
	 * @return devolver� la cantidad total de dias de retraso de todos los tabajos 
	 */
	public int getTotalDiasRetraso() {
		int diasDeRetraso = 0;
		
		for (int i = 0; i < NUM_TRABAJOS; i++) {
			diasDeRetraso = diasDeRetraso + trabajoArray[i].getDiasDeRetraso();
		}
		return diasDeRetraso;
	}
	

}
