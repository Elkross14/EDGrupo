/** 
 *<h2> Clase Examen </h2> 
 *
 * Almacena todos los datos necesarios de las notas.
 * 
 * Última actualización:
 * -Se ha añadido el constructor copia
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.1
 */
package VariablesDelPrograma;



public class Examen {

	private final int PORCENTAJE10 =10;
	private final int PORCENTAJE20 =20;
	private final int PORCENTAJE25 =25;
	
	private boolean trabajoEntregado [];
	private ExamenClasico examenClasico[];
	private ExamenTest examenTest [];
	
	private int retrasos;
	
	/**
	 * Constructor vacio
	 */
	public Examen() {
		trabajoEntregado= new boolean[3];
		examenClasico[0]= new ExamenClasico(0, PORCENTAJE10);
		examenClasico[1]= new ExamenClasico(0, PORCENTAJE20);
		examenClasico[2]= new ExamenClasico(0, PORCENTAJE20);
		examenTest [0] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
		examenTest [1] = new ExamenTest(0, 0, 0, 0, 0, PORCENTAJE25);
		retrasos=0;
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
	public Examen(boolean [] trabajoEntregado, ExamenClasico [] examenClasico,
			ExamenTest [] examenTest, int retrasos) {
		
		this.trabajoEntregado= trabajoEntregado;
		this.examenClasico=examenClasico;
		this.examenTest=examenTest;
		this.retrasos=retrasos;
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
		this.retrasos=examen.retrasos;
	}

	/**
	 * @return Array de trabajos entregados
	 */
	public boolean[] getTrabajoEntregado() {
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
	 * @return cantidad de restrasos de un alumno
	 */
	public int getRetrasos() {
		return retrasos;
	}

	/**
	 * @param trabajoEntregado: boolean array que guarda los trabajos entregados
	 */
	public void setTrabajoEntregado(boolean[] trabajoEntregado) {
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
	 * @param retrasos: cantidad de retrasos que tiene la persona
	 */
	public void setRetrasos(int retrasos) {
		this.retrasos = retrasos;
	}
	

}
