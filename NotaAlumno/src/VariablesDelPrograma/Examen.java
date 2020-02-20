/** 
 *<h2> Clase Examen </h2> 
 *
 * Almacena todos los datos necesarios de las notas.
 * 
 * Última actualización:
 * -Se ha creado el método setRespuestasExamenTest
 * Se ha creado la constante  NUM_TRABAJOS
 * -Se ha eliminado la variable retraso
 * -Se ha modificado trabajoEntregado de Array a vector
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.2
 */
package VariablesDelPrograma;



public class Examen {

	private final int PORCENTAJE10 =10;
	private final int PORCENTAJE20 =20;
	private final int PORCENTAJE25 =25;
	
	private final int NUM_EXAMENES_CLASICOS = 3;
	private final int NUM_EXAMENES_TEST = 2;
	private final int NUM_TRABAJOS = 3;
	
	private int trabajoEntregado [][];
	private ExamenClasico examenClasico[] = new ExamenClasico[NUM_EXAMENES_CLASICOS];
	private ExamenTest examenTest [] = new ExamenTest[NUM_EXAMENES_TEST];
	
	
	/**
	 * Constructor vacio
	 */
	public Examen() {
		trabajoEntregado= new int[NUM_TRABAJOS][2];
		examenClasico[0]= new ExamenClasico(0, PORCENTAJE10);
		examenClasico[1]= new ExamenClasico(0, PORCENTAJE20);
		examenClasico[2]= new ExamenClasico(0, PORCENTAJE20);
		examenTest [0] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
		examenTest [1] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
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
	public Examen(int [][] trabajoEntregado, ExamenClasico [] examenClasico,
			ExamenTest [] examenTest, int retrasos) {
		
		this.trabajoEntregado = trabajoEntregado;
		this.examenClasico = examenClasico;
		this.examenTest = examenTest;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param examen: se le pasa como variable un objeto Examen
	 */
	public Examen(Examen examen) {
		
		this.trabajoEntregado= examen.trabajoEntregado;
		this.examenClasico=examen.examenClasico;
		this.examenTest=examen.examenTest;
	}

	
	/**
	 * @return Array de trabajos entregados
	 */
	public int[][] getTrabajoEntregado() {
		return trabajoEntregado;
	}

	
	/**
	 * @return objeto de ExamenClasico (double nota, int porcNotaGlobal)
	 */
	public ExamenClasico[] getExamenClasico() {
		return examenClasico;
	}

	
	/**
	 * @return objeto de ExamenTest (int correctas, int falladas, int sinContestar, 
	 * int preguntasTotales, double nota, int porcNotaGlobal)
	 */
	public ExamenTest[] getExamenTest() {
		return examenTest;
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
		this.trabajoEntregado = trabajoEntregado;
	}

	
	/**
	 * @param examenClasico: objeto ExamenClasico Array
	 */
	public void setExamenClasico(ExamenClasico[] examenClasico) {
		this.examenClasico = examenClasico;
	}

	
	/**
	 * @param examenTest: objeto ExamenTest Array
	 */
	public void setExamenTest(ExamenTest[] examenTest) {
		this.examenTest = examenTest;
	}
	
	
	/**
	 * Nos pasa los datos de las notas a los examenes clásicos
	 * 
	 * @param NotaExamenClasico: Array double con las notas de todos los examenes clásicos
	 */
	public void setNotaExamenClasico (double NotaExamenClasico[]) {
		for (int i=0; i<NUM_EXAMENES_CLASICOS;i++) {
			examenClasico[i].setNota(NotaExamenClasico[i]);
		}
	}
	
	
	/**
	 * Nos pasa las respuestas recogidas por una clase a la clase ExamenTest
	 * 
	 * @param correctas: respuestas acertadas en un examen tipo test
	 * @param falladas: respuestas falladas en un examen tipo test
	 * @param sinContestar: respuesta no contestasdas en un examen tipo test
	 */
	public void setRespuestasExamenTest(int correctas[], int falladas[],
			int sinContestar[]) {
		for (int i=0; i< NUM_EXAMENES_TEST;i++) {
			examenTest[i].setCorrectas(correctas[i]);
			examenTest[i].setFalladas(falladas[i]);
			examenTest[i].setSinContestar(sinContestar[i]);
		}
	}
	

}
